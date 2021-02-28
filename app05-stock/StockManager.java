import java.util.ArrayList;

/**
 * Manages the stock in a business.
 * Handles adding, removing, renaming and removing products from the stocklist.
 * Also accepts delivery of products, and handles selling products, searching for products by name
 * and finding them by ID
 * 
 * Also prints all products in the stocklist (ID, name, amount in stock),
 * as well as printing products which are low in stock.
 * 
 * @author Muhammad Mulla 
 * @version Feb 2021
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stocklist;

    public boolean inStock;

    public boolean idExists;

    /**
     * Constructor of class StockManager.
     * Initialise the stock manager by creating an arraylist.
     */
    public StockManager()
    {
        stocklist = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * This can be (preloaded) from the stockDemo class, or can be 
     * manually added using a product object.
     */
    public void addProduct(Product item)
    {
        stocklist.add(item);
        System.out.println("Product: " + item + " has been been added to the stock");
    }

    /**
     * This method will search for and return a product by ID
     * If the ID is not in the stocklist, it will print an error message stating that the
     * product does not exist, and will return null.
     */
    public boolean checkProductID(int id)
    {
        int index = 0;
        boolean inStock = false;
        Product product = null;
        while (!inStock && index < stocklist.size())
        {
            product = stocklist.get(index);
            if (product.getID() == id)
            {
                inStock = true;
            }
            else index++;
        }

        if ((inStock = true) && (id -99 <= stocklist.size()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method removes an existing product from the stocklist,
     * or prints an error if the product with a specified ID does not exist.
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);

        if (product != null)
        {
            stocklist.remove(product);
            System.out.println(product + " has been removed");
            System.out.println("Updated product list:");
            printAllProductDetails();
        }
    }

    /**
     * This method renames an existing product from the stocklist with a new name,
     * or prints an error if the product with a specified ID does not exist.
     */
    public void renameProduct(int id, String newName)
    {
        Product product = findProduct(id);

        if (product != null)
        {
            System.out.println("Name of product with id "
                + id + " (" + product.getName() + ") has been renamed ");
            product.setName(newName);
            System.out.println("to " + newName);
            System.out.println();
            System.out.println("Updated product list:");
            printAllProductDetails();
        }

        else 
        {
            System.out.println("This product does not exist");
        }
    }

    /**
     * This method models selling one product from the stocklist
     * This will reduce the stock level by one.
     * 
     * It will also print an error if the product with a specified ID does not exist.
     */
    public void sellOneProduct(int id)
    {
        Product product = findProduct(id);

        if (product != null)
        {
            System.out.println("Selling one of item: " + product);

            product.sellOne();

            System.out.println("Updated stock level: " + product.getQuantity());
        }

        else 
        {
            System.out.println("This product does not exist");
        }
    }

    /**
     * This method models selling product(s) from the stocklist
     * This will reduce the stock level according to how many items were purchased.
     * 
     * If the requested amount to sell is more than the amount in stock, a message will be printed
     * and only the amount in stock will be sold.
     * 
     * It will also print an error if the product with a specified ID does not exist.
     */
    public void sellProduct(int id, int amount)
    {
        Product product = findProduct(id);

        if (product != null)
        {
            if (amount > product.getQuantity())
            {
                amount = product.getQuantity();
                System.out.println("Insufficient quantity requested, only " + amount + " available in stock-");
                System.out.println("Selling " + amount + " of item: " + product);
            }

            else if (amount <= product.getQuantity())
            {
                System.out.println("Selling " + amount + " of item: " + product);
            }

            for (int loop = 0; loop < amount; loop++)
            {
                product.sellOne();
            }

            System.out.println("Updated stock level: " + product.getQuantity());
        }

        else 
        {
            System.out.println("This product does not exist");
        }
    }

    /**
     * This method recieves a delivery of a certain product from the stocklist, the amount can be specified.
     * It will update the stock level (amount in stock), and print the updated product details.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);

        //This will set the "inStock" variable to "true" if the amount in stock is more than 0
        //To be used in other methods.
        if ((product.getQuantity() > 0))
        {
            inStock = true;
        }
        else
        {
            inStock = false;
        }

        if (product != null)
        {
            System.out.println("A delivery of " + product.getName() + " has been received");
            product.increaseQuantity(amount);
            System.out.println("Restocked by " + amount);
            System.out.println("Updated Product: " + product);
        }

        else 
        {
            System.out.println("This product does not exist");
        }
    }

    /**
     * This method will check if the specified product is in stock (stock level more than 0)
     */
    public void productInStock(int id)
    {
        Product product = findProduct(id);

        if ((product.getQuantity() > 0))
        {
            inStock = true;
            System.out.println("This product is in stock");
        }
        else
        {
            inStock = false;
            System.out.println("This product is currently not in stock");
        }
    }

    /**
     * This method will search for products in the stocklist by name and print them.
     * It will also ensure case insensitivity
     */
    public void searchForProduct(String name)
    {
        int count = 0;

        for (Product product : stocklist)
        {
            if (product.getName().toLowerCase().contains(name))
            {
                System.out.println(product);
                count++;
            }
        }

        System.out.println("The search returned " + count + " results containing " + name + ".");
    }

    /**
     * This method will search for and return a product by ID
     * If the ID is not in the stocklist, it will print an error message stating that the
     * product does not exist, and will return null.
     */
    public Product findProduct(int id)
    {
        int index = 0;
        boolean inStock = false;
        Product product = null;
        while (!inStock && index < stocklist.size())
        {
            product = stocklist.get(index);
            if (product.getID() == id)
            {
                inStock = true;
            }
            else index++;
        }

        if ((inStock = true) && (id -99 <= stocklist.size()))
        {
            System.out.println("Product " + product + " has been found");
            return product;
        }
        else
        {
            System.out.println("Invalid ID!");
            System.out.println("Product not found- this product does not exist");
            return null;
        }
    }
    
    /**
     * This method will restock any low stock items to 10 
     * so that there are 10 in stock
     */
    public void restockLowStock()
    {
        for (Product product : stocklist)
        {
            int id = product.getID();
            int amountToRestock = 10 - product.getQuantity();
            if (product.getQuantity()< 5 && (product.getQuantity()>0))
            {
                deliverProduct(id,amountToRestock);
            }
        }
    }

    /**
     * This method is called in the printAllProductDetails method below 
     * and is the header which is printed before the stocklist
     */
    public void printHeading()
    {
        System.out.println();
        System.out.println("M Mulla's Phone Stock List");
        System.out.println("**************************");
        System.out.println();
    }

    /**
     * This method will print the details of all the products-
     * The Name, ID and stock level (amount in stock)
     */
    public void printAllProductDetails()
    {
        printHeading();

        if(stocklist.size() == 0)
        {
            System.out.println("There are no items in stock!");
            System.out.println();
        }
        else
        {
            //Prints details of each product in the stocklist 
            for(Product product : stocklist)
            {
                System.out.println(product);
            }
        }
    }

    /**
     * This method will print the details of all those products in the stocklist which
     * are low in stock or have ran out- if they have a stock level of less than 5 (less than 5 in stock)
     */
    public void printLowStockProducts()
    {
        System.out.println("These are the products which are low in stock (Only 1-5 in stock):");

        for(Product product : stocklist)
        {
            if (product.getQuantity()< 5 && (product.getQuantity()>0))
            {
                System.out.println(product);
            }
        }
    }
}