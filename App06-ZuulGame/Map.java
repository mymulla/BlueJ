                                                                                                                                                                    
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    //All rooms of the map in the game
    public static Room outside;
    public static Room receptionArea;
    public static Room securityRoom;
    public static Room safe;
    public static Room laboratory;
    public static Room storageRoom;
    public static Room cafe;
    public static Room serverRoom;
    
    private String description;
    
    /**
     * Constructor for objects of class Map
     * This will create all the rooms when the Map
     * is initialised (when the game starts).
     */
    public Map()
    {
        createOutside();
        createReceptionArea();
        createSecurityRoom();
        createSafe();
        createlaboratory();
        createStorageRoom();
        createCafe();
        createServerRoom();
        
        connectAllRooms();
    }
    
    /**
     * Returns the room that the player starts in (outside)
     */
    public Room getStartRoom()
    {
        return outside;
    }
    
    /**
     * This is the room the player starts in
     */
    private void createOutside()
    {
        outside = new Room(" Outside the main entrance");

        description = "outside the main entrance of the facility.";
        description += "\n Your target is the main PC in the server room.";
        
        outside.setDescription(description);
        outside.setName("Outside");
    }
    
    /**
     * This creates the "reception area" room, which is north from "outside".
     * This is the centre which leads to all other rooms.
     * Items in this room: None.
     */
    private void createReceptionArea()
    {
        receptionArea = new Room(" Inside the Reception Area");
        
        description =  "in the building, in the main lobby.";
        description += "\n The receptionist is in the far left corner on the phone."; 
        description += "\n You see four rooms- one in each direction...";
        
        receptionArea.setDescription(description);
        receptionArea.setName("ReceptionArea");
    }

    /**
     * This creates the "security room", which is east from "reception area".
     * Items in this room: Key.
     */
    private void createSecurityRoom()
    {
        securityRoom = new Room(" The Security Room");
        
        description =  "in the security room, there are CCTV screens all around.";
        description += " A security guard is seated, asleep, his keys are on the desk";
        description += "\n You notice a small wall-mounted safe";
        
        securityRoom.setDescription(description);        
        
        securityRoom.setKey();
        securityRoom.setName("SecurityRoom");
    }
    
    /**
     * This creates the "safe", which is east from "security".
     * Items in this room: Badge.
     */
    private void createSafe()
    {
        safe = new Room("In the safe");
        
        description =  "looking inside the opened safe. ";
        
        description += "\n In the safe, you see just one access badge...";
        
        safe.setDescription(description);
        safe.setName("Safe");
        
        safe.setBadge();
    }
    
    /**
     * This creates the "labratory", which is west from "reception area".
     * Items in this room: None.
     */
    private void createlaboratory()
    {
        laboratory = new Room("in the laboratory");
        
        description = "inside the laboratory which is currently empty. ";
        description += "\n You see a door ahead, which says 'Authorised Personnel Only'";
        
        laboratory.setDescription(description); 
        laboratory.setName("Laboratory");
    }

    /**
     * This creates the "storage room", which is north from the "laboratory".
     * Items in this room: Uniform.
     */
    private void createStorageRoom()
    {
        storageRoom = new Room("In the Storage Room");
        
        description = "in the storage room, which is full of a load of rubbish, ";
        description += "\n though you see some guard's uniforms... ";
        
        storageRoom.setDescription(description);
        storageRoom.setName("StorageRoom");
        
        storageRoom.setUniform();
    }
    
    /**
     * This creates the "cafe", which is north from "reception area".
     * Items in this room: None.
     */
    private void createCafe()
    {
        cafe = new Room("A cafe ");
        
        description = "in the cafe. A few people are sat sipping away. ";
        description += " \n You notice a door to your right. ";
        description += " \n In red writing- Authorised Personnel Only";

        cafe.setDescription(description);
        cafe.setName("Cafe");
    }
    
    /**
     * This creates the "server room", which is east from "cafe".
     * Items in this room: Files.
     */
    private void createServerRoom()
    {
        serverRoom = new Room("The server room...");
        
        description = "in the server room, the main PC is here. Type 'hack' to steal the files and complete the mission";
        
        serverRoom.setDescription(description);
        serverRoom.setName("ServerRoom");
    }
    
    /**
     * This connects all the rooms after they are created
     * It uses the connectRooms() method (below)
     */
    public void connectAllRooms()
    {
        connectRooms(outside, "north", receptionArea);
        connectRooms(receptionArea, "north", cafe);
        connectRooms(receptionArea, "east", securityRoom);
        connectRooms(receptionArea, "south", outside);
        connectRooms(receptionArea, "west", laboratory);
        connectRooms(securityRoom, "east", safe);
        connectRooms(securityRoom, "west", receptionArea);
        connectRooms(safe, "west", securityRoom);
        connectRooms(laboratory, "north", storageRoom);
        connectRooms(laboratory, "east", receptionArea); 
        connectRooms(storageRoom, "south", laboratory);
        connectRooms(cafe, "east", serverRoom);
        connectRooms(cafe, "south", receptionArea);
        connectRooms(serverRoom, "west", cafe);
    }
    
    /**
     * This method is called in the above method to connect the rooms
     */
    private void connectRooms(Room room, String direction, Room otherRoom)
    {
        room.setExit(direction, otherRoom);
        
        if(direction.equals("east"))
        {
            otherRoom.setExit("west", room);
        }
        else if(direction.equals("west"))
        {
            otherRoom.setExit("east", room);
        }
        else if(direction.equals("north"))
        {
            otherRoom.setExit("south", room);
        }
        else if(direction.equals("south"))
        {
            otherRoom.setExit("north", room);
        }
    }
}
