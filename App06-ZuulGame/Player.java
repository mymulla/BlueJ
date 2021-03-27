import java.util.ArrayList;

/**
 * This class stores information about the player
 * including the player's current state in terms
 * of energy, score and the number of turns so far.
 * The player can carry a number of items up to 
 * the maximum weight.
 *
 * @author Muhammad Mulla
 * @version March 2021
 */
public class Player
{
    public static final int START_SCORE = 0;
    
    public static final int energyPerMove = 3; //The energy which will be decreased upon each move
    
    public String name;

    private int score;

    private int moves;

    private int energy;
    
    public boolean alive; //Will determine if the player continues or finishes the game (e.g. energy finished)

    private ArrayList<ItemTypes> items; //Arraylist for the items that the player will be carrying

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        items = new ArrayList<ItemTypes>();

        score = 0;
        moves = 0;
        
        energy = 100;

        alive = true;
    }

    /**
     * Returns the name of the player
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Sets the name of the player- at the beginning when the user inputs their name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the current score of the player
     */
    public int getScore()
    {
        return this.score;
    }

    /**
     * Increase the score of the player with a specified amount
     */
    public void incScore(int amount)
    {
        score = score + amount;
    }

    /**
     * Decrease the score of the player with a specified amount
     */
    public void decScore(int amount)
    {
        score = score - amount;
        if(score < 0)
        {
            score = 0; //If the score goes into minus, it will stay zero as that is the minimum
        }
    }

    /**
     * Returns the moves taken by the player
     */
    public int getMoves()
    {
        return this.moves;
    }

    /**
     * Increases the moves taken by the player, and 
     * decreases energy accordingly
     */
    public void incMoves()
    {
        this.moves++;
        this.energy -= energyPerMove;

        if(energy < 5) //When the energy is less than 5, the user will lose the game
        {
            alive = false;
            System.out.println("You have been caught! You wandered around too much and lost too much energy!");
        }
    }
    
    /**
     * Returns the energy of the player
     */
    public int getEnergy()
    {
        return this.energy;
    }

    /**
     * Increases the energy of the player by a specified amount
     */
    public void incEnergy(int increase)
    {
        this.energy += increase;
    }

    /**
     * Decreases the energy of the player by a specified amount
     */
    public void decEnergy(int decrease)
    {
        this.energy -= decrease;
        if(energy < 5)
        {
            alive = false;
            System.out.println("You have been caught! You wandered around too much and lost too much energy!");
        }
    }

    /**
     * Returns if the player is alive or not
     */
    public boolean isAlive()
    {
        return this.alive;
    }

    /**
     * Sets the player as alive
     */
    public void setAlive()
    {
        this.alive = true;
    }

    /**
     * Returns the items in trhe arraylist
     */
    public ArrayList<ItemTypes> getItems()
    {
        return this.items;
    }

    /**
     * Adds an item to the arraylist (the player's inventory)
     * if they are not already carrying it
     */
    public void addItem(ItemTypes item)
    {
        if(!isCarrying(item))
        {
            this.items.add(item);
        }
    }

    /**
     * Removes an item to the arraylist (the player's inventory)
     */
    public void removeItem(ItemTypes item)
    {
        this.items.remove(item);
    }    

    /**
     * This is printed after each move, and displays the player's
     * name, moves, energy and score.
     */
    public String toString()
    {
        String 
        output = "\n ----------------------------------------------" +
            "\n | " + name + ": | Move " + moves + " | Energy = " + energy +
            " | Score = " + score + " |" +
            "\n ----------------------------------------------\n";
            
        return output;
    }

    /**
     * Checks if the player has a certain item in the inventory
     */
    public boolean isCarrying(ItemTypes item)
    {
        return items.contains(item);
    }
    
    /**
     * Adds an item to the arraylist (the player's inventory)
     * and will show that nothing is being carried if the arraylist 
     * is empty.
     */
    public String addItems()
    {
        String inventory = "\n You are carrying: ";
        int count = 0;
        
        if(items.size() == 0)
            inventory += "nothing!";
        else
        {
            for(ItemTypes item : items)
            {
                count++;
                inventory += item;

                if(count < items.size())
                {
                    inventory += ", ";
                }
                else
                {
                    inventory += "\n";
                }
            }
        }
        return inventory;
    }
}
