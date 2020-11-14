
import java.util.Date;

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
    
    private Date datePurchased;
    
    /**
     * The constructor for creating a ticket (object)
     */
    public Ticket(String destination, int price)
    {
        this.price = price;
        this.destination = destination;
        datePurchased = new Date();
    }
          
        
    /**
     * The constructor for getting a price
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * The constructor for getting a destination
     */
    public String getDestination()
    {
        return destination;
    }
    
    /**
     * The constructor for getting a date
     */
    public Date getDatePurchased()
    {
        return datePurchased;
    }
    
    public void print()
    {
        System.out.print("Destination:" + destination);
        System.out.println(" Price: "+ price + " pence");
    }
}
