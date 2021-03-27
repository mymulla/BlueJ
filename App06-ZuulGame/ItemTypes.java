
/**
 * This class is part of the "Hack-o-Mania" application. 
 * "Hack-o-Mania" is a very simple, text based adventure game,
 * which is a re-developed version of the classic adventure game, World of Zuul. 
 * 
 * Enumeration class ItemTypes - This class defines the items
 * a player can carry.
 *
 * @author Muhammad Mulla
 * @version March 2021
 */
public enum ItemTypes
{
    NONE("none"), 

    KEY("keys"), 

    BADGE("badge"), 

    UNIFORM("uniform"),
    
    FILES("files");

    private String itemString;

    ItemTypes(String itemString)
    {
        this.itemString = itemString;
    }

    public String toString()
    {
        return itemString;
    }
}
