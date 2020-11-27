
import java.util.Date;

/**
 * This class models a ticket with a destination, price and a date
 *
 * @author Muhammad Mulla
 * @version 27/11/2020
 */
public class Ticket
{
    // The destination of the selected ticket
    private String destination;
    
    // This is the price of the ticket in pence
    private int price;
    
    // The date of when the ticket was purchased
    private Date today = new Date();
    
    /**
     * The constructor for creating a ticket
     */
    public Ticket(String destination, int price)
    {
        this.price = price;
        this.destination = destination;
        this.today = new Date();
    }
 
    /**
     * Getting the destination of the ticket
     */
    public String getDestination()
    {
        return destination;
    }
    
    /**
     * Getting the price of the ticket in pence
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Getting the date and time for when the ticket is being purchased
     */
    public Date getDate()
    {
        return today;
    }
    
    /**
     * Printing the destination and price for a ticket
     */
    public void print()
    {
        System.out.print("Destination:" + destination);
        System.out.println(" Price: "+ price + " pence");
    }
}
