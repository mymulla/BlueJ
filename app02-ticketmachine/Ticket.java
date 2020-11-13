
/**
 * Write a description of class Ticket here.
 *
 * @author (Muhammad Mulla)
 * @version (a version number or a date)
 */
public class Ticket
{
    private String destination;
    
    // This is in pence
    private int price;
    
    public Ticket(String destination, int price)
    {
        this.price = price;
        this.destination = destination;
    }
          
        
    
    public void setProce(int price)
    {
        this.price = price;
    }
}