/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * Modified by Muhammad Mulla
 * @version Feb 2021
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    
    public static final int StartID = 100; 
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        
        int id = StartID;
        manager.addProduct(new Product(id, "Samsung Galaxy S20"));
        id++;
        manager.addProduct(new Product(id,  "Samsung Galaxy S10"));
        id++;
        manager.addProduct(new Product(id,  "Samsung Galaxy S9"));
        id++;
        manager.addProduct(new Product(id,  "Samsung Galaxy S8"));
        id++;
        manager.addProduct(new Product(id,  "iPhone X"));
        id++;
        manager.addProduct(new Product(id,  "iPhone 9"));
        id++;
        manager.addProduct(new Product(id,  "iPhone 8"));
        id++;
        manager.addProduct(new Product(id,  "Google Pixel 4a"));
        id++;
        manager.addProduct(new Product(id,  "Google Pixel 5"));
        id++;
        manager.addProduct(new Product(id,  "OnePlus NORD 5G"));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demorestock()
    {
        // Show details of all of the products.
        manager.printAllProductDetails();
        // Take delivery of 5 items of one of the products.
        manager.deliverProduct(100, 5);
        //Updated details of all products
        manager.printAllProductDetails();
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id, int amount)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}
