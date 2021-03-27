/**
 *  This class is the main class of Hack-o-Mania, the re-developed edition
 *  of the "World of Zuul" application. 
 *  "Hack-o-Mania" is a very simple, text based adventure game.  Users 
 *  can walk around rooms and try to complete the mission.
 *  
 *  The goal of this game is to find and break into the server room
 *  and hack the files.
 *  
 *  For this, there are many items to pick up, and many doors to unlock.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method, or run the program.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Muhammad Mulla
 * Version March 2021
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;

    private Player player;
    private Map map;

    private boolean safeOpened;
    private boolean serverRoomOpened;
    
    public boolean finished;
    /**
     * Create the game, initialise its internal map, initialise the player object
     * and configure the initial state of the safe and server room (locked).
     */
    public Game(String playerName) 
    {
        parser = new Parser();
        player = new Player(playerName);

        map = new Map();
        currentRoom = map.getStartRoom();

        safeOpened = false;
        serverRoomOpened = false;
    }

    /**
     * This method begins the game, printing the welcome message,
     * The game will continue in a loop until the game is won
     * or the player runs out of energy and gets caught.
     */
    public void play()
    {
        printWelcome();

        finished = false;

        while (! finished) 
        {
            System.out.println(player.toString());
            Command command = parser.getCommand();
            finished = processCommand(command);

            if(player.isCarrying(ItemTypes.FILES))
            {
                System.out.println("Congratulations! You have completed the game successfully!");
                System.out.println("Just don't try this in real life!");

                finished = true;
            }
            else if(!player.isAlive())
            {
                System.out.println("Better luck next time!");
                finished = true;               
            }
        }

        System.out.println("Thank you for playing!");
    }

    /**
     * Print out the opening message for the player, highlighting the goal of the game.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Hack-o-mania " + player.name + "!");
        System.out.println("This game is a new, re-developed edition of the adventure game, World of Zuul.");
        System.out.println();
        System.out.println("You have been assigned a mission to break into this secure facility, ");
        System.out.println("break into the secured server room and steal the confidential files! ");
        System.out.println("You must locate the server room, try to get in and hack the PC without getting caught...");
        System.out.println("Don't wander around too much and lose energy, or you'll get caught!");
        System.out.println();
        printInstructions();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * This method details how the game is played, and is called at the beginning of the game.
     */
    private void printInstructions()
    {
        System.out.println("How to play: ");
        System.out.println("Type 'go north' to go forward.");
        System.out.println("Type 'go east' to go right.");
        System.out.println("Type 'go south' to go back.");
        System.out.println("Type 'go west' to go left.");
        System.out.println("Type 'inventory' to see what items you are carrying.");
        System.out.println("Type commands such as 'get' to get and use the items.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("Good luck on your mission!");
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     * 
     * Switch used for the different command words.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
            System.out.println("I don't know what you mean...");
            break;

            case HELP:
            printHelp();
            break;
            
            case INVENTORY:
            showItems();
            break;

            case GO:
            goRoom(command);
            break;

            case GET:
            getItem(command);
            break;

            case UNLOCK:
            unlockSafe();
            break;

            case SWIPE:
            unlockServerRoom();
            break;
            
            case HACK:
            hackPC();
            break;

            case QUIT:
            wantToQuit = quit(command);
            break;

        }
        
        return wantToQuit;
    }

    // implementations of all user commands:

    /**
     * This method is called when a user types 'help'.
     * It will print out some help information.
     * Also prints a stupid, cryptic message and a list of the 
     * available command words.
     */
    private void printHelp() 
    {
        System.out.println("You need to get into the server room...");
        System.out.println("Use your common sense before you get caught!");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    /**
     * This method is called when a user types 'inventory'.
     * It will display whatever items the player is carrying.
     */
    private void showItems()
    {
        System.out.println(player.addItems());
    }

    /** 
     * Navigation between rooms based on input from user:
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * 
     * Also checks if the safe and server room are locked before entry into the room.
     * If locked, and error message is printed.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
        {
            System.out.println("There's no room here!");
        }
        else if (nextRoom.getName().equals("Safe"))
        {
            boolean safeIsOpen = checkSafe();
            if (safeIsOpen)
            {
                currentRoom = nextRoom;
                System.out.println(nextRoom.getLongDescription());
                player.incMoves();
            }
            else
            {
                System.out.println("The safe is locked! You need a key");
            }
        }

        else if (nextRoom.getName().equals("ServerRoom"))
        {
            boolean serverRoomIsOpen = checkServerRoom();
            if (serverRoomIsOpen)
            {
                if (player.isCarrying(ItemTypes.UNIFORM))
                {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    player.incMoves();
                }
                else
                {
                    System.out.println("You have been caught! One of the customers in the cafe got suspicious as you were" +
                    " wearing casual clothes and they reported you...");
                    System.out.println("You will have to restart the game and try again. Better luck next time!");
                    player.alive = false;
                    finished = true;
                }
            }
            else
            {
                System.out.println("The server room is locked!");
                System.out.println("You need an access badge to get in!");
                System.out.println("If you have a badge, type 'swipe' to unlock");
            }
        }

        else if ((nextRoom.getName().equals("Outside")) || (nextRoom.getName().equals("ReceptionArea")) ||
        (nextRoom.getName().equals("SecurityRoom")) || (nextRoom.getName().equals("Laboratory")) ||
        (nextRoom.getName().equals("StorageRoom")) || (nextRoom.getName().equals("Cafe")))
        {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            player.incMoves();
        }
    }

    /**
     * Executes the command to get an item, called when a user types 'get...'
     * If the item is in the current room, 
     * it will allow the player to pick it up, otherwise
     * it will print an error message.
     * Score (+20) & Energy (-3) when an item is picked up.
     */
    public void getItem(Command command)
    {
        ItemTypes itemsInRoom = currentRoom.getItem();
        String objectToGet = command.getSecondWord();
        String nameOfItem = itemsInRoom.toString();

        if(objectToGet == null)
        {
            System.out.println("What do you want to get?");
        }

        if((itemsInRoom.equals(ItemTypes.KEY)) && (command.getSecondWord().equals("key")))
        {
            player.addItem(ItemTypes.KEY);
            player.incScore(20);
            player.decEnergy(3);
            System.out.println("You have taken the key from the guard!");
        }
        else if((itemsInRoom.equals(ItemTypes.NONE)) && (command.getSecondWord().equals("key")))
        {
            System.out.println("There is no key here to take!");
        }

        if((itemsInRoom.equals(ItemTypes.BADGE)) && (command.getSecondWord().equals("badge")))
        {
            player.addItem(ItemTypes.BADGE);
            player.incScore(20);
            player.decEnergy(3);
            System.out.println("You have taken the badge from the safe!");
        }
        else if((itemsInRoom.equals(ItemTypes.NONE)) && (command.getSecondWord().equals("badge")))
        {
            System.out.println("There is no badge here to take!");
        }

        if((itemsInRoom.equals(ItemTypes.UNIFORM)) && (command.getSecondWord().equals("uniform")))
        {
            player.addItem(ItemTypes.UNIFORM);
            player.incScore(20);
            player.decEnergy(3);
            System.out.println("You have taken the guard's uniform from the storage room!");
            System.out.println("You put on this uniform...");
        }
        else if((itemsInRoom.equals(ItemTypes.NONE)) && (command.getSecondWord().equals("uniform")))
        {
            System.out.println("There is no uniform here to take!");
        }
    }

    /**
     * If the player is carrying a key, it will unlock the safe.
     * This is called when the user types 'unlock'.
     * Score (+10) & Energy (-3).
     */
    public void unlockSafe()
    {
        if(player.isCarrying(ItemTypes.KEY))
        {
            safeOpened = true;
            player.incScore(10);
            player.decEnergy(3);
            System.out.println("You have unlocked the safe! Type 'go east' to discover what's in the safe...");
        }
        else
        {
            System.out.println("You cannot unlock the safe without keys!");
        }
    }
    
    /**
     * This method will check if the safe has been unlocked
     * and will return true if it is open.
     * 
     * This is called under the goRoom(command) method to see
     * whether the player can enter/open the safe or not.
     */
    public boolean checkSafe()
    {
        return safeOpened;
    }

    public void unlockServerRoom()
    {
        if(player.isCarrying(ItemTypes.BADGE))
        {
            serverRoomOpened = true;
            player.incScore(10);
            player.decEnergy(3);
            System.out.println("You have unlocked the server room! Type 'go east' to enter the room...");
        }
        else
        {
            System.out.println("You cannot enter the server room without an access badge!");
        }
    }
    
    /**
     * This method will check if the server room has been unlocked
     * and will return true if it is open.
     * 
     * This is called under the goRoom(command) method to see
     * whether the player can enter the server room or not.
     */
    public boolean checkServerRoom()
    {
        return serverRoomOpened;
    }

    /**
     * Returns the current room
     */
    public Room getRoom()
    {
        return currentRoom;
    }
    
    /**
     * This method will check the room first
     * If it is the correct room, it will pick up the item "files" for the player
     * to successfully end the game.
     * 
     * Score (+20) & Energy (-3)- this is implemented before the game ends.
     */
    public void hackPC()
    {
        if ((currentRoom.getName().equals("ServerRoom")))
        {
            player.addItem(ItemTypes.FILES);
            player.incScore(20);
            player.decEnergy(3);
            System.out.println(player.toString());
            System.out.println("You have successfully hacked the main PC and stole the files!");
            System.out.println();
        }
        else
        {
            System.out.println("There's nothing to hack here! You can only hack in the server room!");
        }
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
