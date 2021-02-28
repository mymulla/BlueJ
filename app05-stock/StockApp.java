
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Muhammad Mulla
 * @version Feb 2021
 */
public class StockApp
{
    // Use to get user input
    private InputReader input;
    
    private StockManager manager;
    
    private StockDemo demo;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        manager = new StockManager();
        demo = new StockDemo(manager);
    }

    /**
     * This method will run the program, and will loop until the user quits
     * the program
     * 
     * It will print the heading and the menu, and will convert any input 
     * into lower case.
     * 
     * It will execute the choice inputted by the user.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = input.getInput();
            choice = choice.toLowerCase();
            
            executeChoices(choice);
            
            if(choice.equals("quit"))
            {
                finished = true;
            }
        }
    }
    
    /**
     * Executes the choice which is chosen by the user from the menu.
     * 
     * This method will call other methods according to what the
     * user has decided to do.
     */
    public void executeChoices(String choice)
    {
        if(choice.equals("add"))
        {
            addProduct();
        }
        
        else if(choice.equals("remove"))
        {
            removeProduct();
        }
        
        else if(choice.equals("printall"))
        {
            printAllProducts();
        }
        
        else if(choice.equals("printlowstock"))
        {
            printLowStock();
        }
        
        else if(choice.equals("restock"))
        {
            restock();
        }
        
        else if(choice.equals("deliver"))
        {
            deliverProduct();
        }
        
        else if(choice.equals("sell"))
        {
            sellProduct();
        }
        
        else if(choice.equals("search"))
        {
            searchForProduct();
        }
    }
    
    /**
     * This method executes the choice to add a product to the stock list
     * 
     * It calls the addProduct() method from the StockManager class
     * 
     * It also ensures that a duplicate ID was not inputted, 
     * or that a blank product name is not entered (or it will return to the menu)
     */
    public void addProduct()
    {
        System.out.println ("You have selected the option to add a new product");
        System.out.println ();
        
        System.out.println ("Please enter the ID");
        String IDnumber = input.getInput();
        
        int id = Integer.parseInt(IDnumber);
        
        manager.checkProductID(id);
        
        if (manager.checkProductID(id) == true)
        {
            System.out.println("Duplicate ID detected, please select add and enter a valid ID");
            System.out.println();
            return;
        }
        else
        {
            System.out.println();
        }

        System.out.println();
        System.out.println ("Please enter the product name ");
        System.out.println();
        
        String name = input.getInput();
        
        if (name.equals(""))
        {
            System.out.println ("Blank name detected, please enter a valid ID and name");
            return;
        }
        else
        {
            Product product = new Product(id, name);
            manager.addProduct(product);
        }

    }
    
    /**
     * This method executes the choice to remove a product to the stock list
     * 
     * It calls the removeProduct() method from the StockManager class
     * 
     */
    public void removeProduct()
    {
        System.out.println ("You have selected the option to remove a product");
        System.out.println ();
        
        System.out.println ("Please enter the product id ");
        String IDnumber = input.getInput();
        
        int id = Integer.parseInt(IDnumber);
        
        manager.removeProduct(id);
    }
    
    /**
     * This method executes the choice to print all products from the stock list
     * 
     * It calls the printAllProductDetails() method from the StockManager class
     * 
     */
    public void printAllProducts()
    {
        manager.printAllProductDetails();
    }
    
    /**
     * This method executes the choice to print low stock products from the stock list
     * 
     * It calls the printLowStockProducts() method from the StockManager class
     *
     */
    public void printLowStock()
    {
        manager.printLowStockProducts();
    }
    
    /**
     * This method executes the choice to restock low stock products from the stock list
     * 
     * It will restock them so that there are 10 in stock
     * 
     * It calls the restockLowStock() method from the StockManager class
     *
     */
    public void restock()
    {
        manager.restockLowStock();
        System.out.println();
        System.out.println("All low stock products have been restocked to 10");
        System.out.println("Updated stock level for those products: 10");
        System.out.println();
    }
    
    /**
     * This method executes the choice to deliver products to stock (receive delivery)
     * 
     * It calls the deliverProduct() method from the StockManager class
     *
     * It will ensure that a positive quantity is entered by the user
     * (or it will return to the menu)
     */
    public void deliverProduct()
    {
        System.out.println ("You have selected the option to deliver a product to stock (restock an item)");
        System.out.println ();
        
        System.out.println ("Please enter the product id ");
        String IDnumber = input.getInput();
        
        int id = Integer.parseInt(IDnumber);
        
        System.out.println ("Please enter the amount you would like to deliver ");
        String amountToDeliver = input.getInput();
        
        int amount = Integer.parseInt(amountToDeliver);
        
        if (amount <=0)
        {
            System.out.println("Please input a positive quantity to deliver");
            return;
        }
        
        manager.deliverProduct(id,amount);
    }
    
    /**
     * This method executes the choice to sell a quantity of a product from the stock list
     * 
     * It calls the sellProduct() method from the StockManager class
     *
     * It will ensure that a positive quantity is entered by the user
     * (or it will return to the menu)
     */
    public void sellProduct()
    {
        System.out.println ("You have selected the option to sell an amount of a product");
        System.out.println ();
        
        System.out.println ("Please enter the product id ");
        String IDnumber = input.getInput();
        
        int id = Integer.parseInt(IDnumber);
        
        System.out.println ("Please enter the amount you would like to sell ");
        String amountToSell = input.getInput();
        
        int amount = Integer.parseInt(amountToSell);
        
        if (amount <=0)
        {
            System.out.println("Please input a positive quantity to sell");
            return;
        }
        
        manager.sellProduct(id,amount);
    }
    
    /**
     * This method executes the choice to search for products from the stock list
     * 
     * It is case insensitive, so it will carry out the search even
     * if the user uses the incorrect case
     * 
     * It calls the searchForProduct() method from the StockManager class
     *
     */
    public void searchForProduct()
    {
        System.out.println ("You have selected the option to search for a product by name");
        System.out.println ();
        
        System.out.println ("Please type the product you wish to search for");
        String name = input.getInput().toLowerCase();
        
        manager.searchForProduct(name);
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:            Add a new product");
        System.out.println("    Remove:         Remove an old product");
        System.out.println("    PrintAll:       Print all products");
        System.out.println("    PrintLowStock:  Print products which are low in stock");
        System.out.println("    Restock:        Restock all low stock items to 10");
        System.out.println("    Deliver:        Deliver an amount of a product to stock");
        System.out.println("    Sell:           Sell an amount of a product");
        System.out.println("    Search:         Search for a product by name");
        System.out.println("    Quit:           Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Muhammad Mulla");
        System.out.println("******************************");
    }
}
