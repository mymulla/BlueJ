import java.util.Date;

/**
 * This class, TicketMachine, models a ticket machine
 * from which customers can purchase three different tickets.
 * They can purchase:
 * - Ticket to Aylesbury- £2.20
 * - Ticket to Amersham- £3.00
 * - Ticket to High Wycombe- £3.30
 * 
 * All prices are in pence
 * 
 * The ticket prices are defined in the field as constants (static final)
 * 
 * If a sensible amount (10, 20, 100, or 200 pence) is not inserted, then an error message will be displayed.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Muhammad Mulla
 * 27/11/2020
 */
public class TicketMachine
{
    //Tickets defined as constants
    public static final Ticket ticketAylesbury = new Ticket("Aylesbury", 220);

    public static final Ticket ticketAmersham = new Ticket("Amersham", 300);

    public static final Ticket ticketWycombe = new Ticket("HighWycombe", 330);

    //The ticket which is currently selected
    private Ticket currentTicket;

    // The amount of money entered by a customer so far
    private int balance;

    // The total amount of money collected by this machine since the start
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;
        //The currentTicket has a null value as initally, no ticket has been selected
        currentTicket = null;
    }

    /**
     * Returns the price of the selected ticket
     * Asks to select a destination if no ticket is selected
     */
    public int getPrice()
    {
        if(currentTicket != null)
        {
            return currentTicket.getPrice();
        }
        else
        {
            System.out.println("Please select a destination");
            return 0;
        }
    }

    /**
     * To print all available tickets
     */
    public void printAvailableDestinations()
    {
        printHeading();
        System.out.println("The following tickets are available for purchase:");
        System.out.println();
        ticketAylesbury.print();
        ticketAmersham.print();
        ticketWycombe.print();
    }

    /**
     * The heading to be called in the printAvailableDestinations and printTicket methods
     */
    private void printHeading()
    {
        System.out.println("##################");
        System.out.println("# Express Trains");
        System.out.println("##################");
        System.out.println();
    }

    /**
     * Selecting the Aylesbury ticket for purchase
     */
    public void selectAylesburyTicket()
    {
        System.out.println("You have selected the ticket to Aylesbury");
        currentTicket = ticketAylesbury;
    }

    /**
     * Selecting the Amersham ticket for purchase
     */
    public void selectAmershamTicket()
    {
        System.out.println("You have selected the ticket to Amersham");
        currentTicket = ticketAmersham;
    }

    /**
     * Selecting the High Wycombe ticket for purchase
     */
    public void selectHighWycombeTicket()
    {
        System.out.println("You have selected the ticket to High Wycombe");
        currentTicket = ticketWycombe;
    }

    /**
     * Prints the amount of money already inserted, which can be used to
     * purchase a ticket
     */
    public void printBalance()
    {
        System.out.println(balance + " pence");
    }

    /**
     * Defines what should be done when an amount is inserted to update
     * the balance
     */
    private void updateBalance(int amount)
    {
        balance = balance + amount;
        System.out.println(amount + " pence inserted");
        System.out.println("Current Balance: " + balance + " pence");
    }

    /**
     * Coin contains an enumeration containing only those
     * coin values that are accepted.
     */
    public void insertCoin(Coin coin)
    {
        updateBalance(coin.getValue());
    }

    /**
     * This enumeration method accepts a simple integer, only accepting 
     * 10, 20, 100 and 200 (pence)
     * 
     * An error message is printed if other than these values are inserted
     */
    public void insertCoin(int value)
    {
        switch(value)
        {
            case 10:  case 20: case 100: case 200: 

            updateBalance(value);
            break;

            default: 
            System.out.println();
            System.out.println("This " + value + " is not an acceptable coin!");
        }
    }

    /**
     * Print a ticket if there is enough money in available in the balance
     * Reduce the current balance by the ticket price if a ticket
     * is printed
     * Print an error message if more money needs to be inserted
     */
    public void printTicket()
    {
        //The Price of the ticket in pence
        int price = currentTicket.getPrice();
        //The Destination of the selected ticket
        String destination = currentTicket.getDestination();
        //The Date the ticket is being purchased
        Date date = currentTicket.getDate();
        if(currentTicket != null)
        {
            System.out.println();
        }
        else
        {
            System.out.println("Please select a destination");
        }

        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            printHeading();
            System.out.println("Ticket to: " + currentTicket.getDestination());
            System.out.println("### Cost: " + price + " pence ###");
            System.out.println("### Purchased on " + date + " ###");
            System.out.println();
            System.out.println("### Thank you for your purchase ###");

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                (price - balance) + " more pence.");

        }
    }

    /**
     * Return all money in the balance
     * The balance is reset to 0 pence
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

}
