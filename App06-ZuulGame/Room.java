import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "Hack-o-Mania" application. 
 * "Hack-o-Mania" is a very simple, text based adventure game,
 * redeveloped based on the classic "World of Zuul" game.
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private String name;
    private HashMap<String, Room> exits;        // stores exits of this room.
    
    private ItemTypes item;
    private ItemTypes money;
    private ItemTypes key;
    private ItemTypes badge;
    private ItemTypes usb;
    private ItemTypes uniform;
    
    private String itemDescription;
    /**
     * Create a room described "description". Initially, it has
     * no exits.
     * @param description The room's description.
     */
    public Room(String description) 
    {
        exits = new HashMap<>();
        this.description = description;
        this.name = name;
        this.item = item;
        this.itemDescription = itemDescription;
        
        item = ItemTypes.NONE;
    }

    /**
     * Sets the description of the room
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * Sets the name of the room
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Sets the description of the room
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     * 
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String message =  " You are " + 
               description + ".\n";
        
        if(item != ItemTypes.NONE)
        {
            message += itemDescription + "\n";
        }
            
        return message + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "\n Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Sets the Items in the room
     */
    public void setItem(ItemTypes item, String itemDescription)
    {
        this.item = item;
        this.itemDescription = itemDescription;
    }
    
    /**
     * Returns the items in the room
     */
    public ItemTypes getItem()
    {
        return item;
    }
    
    /**
     * Sets the item in the room as key
     */
    public void setKey()
    {
        item = ItemTypes.KEY;
    }
    
    /**
     * Sets the item in the room as badge
     */
    public void setBadge()
    {
        item = ItemTypes.BADGE;
    }
    
    /**
     * Sets the item in the room as uniform
     */
    public void setUniform()
    {
        item = ItemTypes.UNIFORM;
    }
}

