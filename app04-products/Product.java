/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * Modified by Muhammad Mulla
 * @version Feb 2021
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial product quantity is zero.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * Return the product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * Return the product's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * This method is to rename a product
     * 
     * This is called in StockManager (renameProduct())
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Returns the quantity of items in stock.
     * 
     * Called many times in StockManager class.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Returns the id, name and quantity in stock.
     */
    public String toString()
    {
        return id + ": " +  name + ", Stock level: " + quantity;
    }

    /**
     * This method restocks an item in the stocklist, and increases its quantity.
     * 
     * This method is called in StockManager (deliverProduct()), when a delivery of a product
     * is received, which will increase its quantity.
     * 
     * Can only accept delivery and increase quantity if the "amount" is greater than 0, 
     * otherwise, an error is printed.
     */
    public void increaseQuantity(int amount)
    {
        if(amount <= 0) 
        {
            System.out.println("Please input a positive number greater than 0");
        }
        else 
        {
            quantity += amount;
        }
    }

    /**
     * This method sells one product.
     * 
     * This method is used in a loop in the sellProduct() method in StockManager.
     */
    public void sellOne()
    {
        if(quantity > 0) 
        {
            quantity--;
        }
        else 
        {
            System.out.println(
                "Attempt to sell an out of stock item: " + name);
        }
    }
}
