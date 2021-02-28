
/**
 * The program class creates a new application called StockApp and runs it
 *
 * @author Muhammad Mulla
 * @version Feb 2021
 */
public class Program
{
    private static StockApp app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main()
    {
        app = new StockApp();
        app.run();
    }
}
