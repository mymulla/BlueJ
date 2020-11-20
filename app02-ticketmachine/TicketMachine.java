/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Muhammad Mulla
 */
public class TicketMachine
{
    public static final Ticket ticketAylesbury = new Ticket("Aylesbury", 220);

    public static final Ticket ticketAmersham = new Ticket("Amersham", 300);

    public static final Ticket ticketWycombe = new Ticket("Wycombe", 330);
    
    private Ticket currentTicket;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    private int price;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;
        currentTicket=null;
    }
    
    public void selectAylesburyTicket()
        {
            currentTicket=ticketAylesbury;
        }
    
    public void selectAmershamTicket()
        {
            currentTicket=ticketAmersham;
        }
        
    public void selectHighWycombeTicket()
        {
            currentTicket=ticketWycombe;
        }


    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public void printBalance()
    {
        System.out.println(balance);
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {

        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# .currentTicket");
            System.out.println("# £" + price);
            System.out.println("##################");
            System.out.println();

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
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    /**
     * To print all tickets
     */
    public void printAllTickets()
    {
        printHeading();
        System.out.println("The following tickets are available for purchase:");
        ticketAylesbury.print();
        ticketAmersham.print();
        ticketWycombe.print();
    }

    public void printHeading()
    {
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("##################");
        System.out.println();
    }

}
