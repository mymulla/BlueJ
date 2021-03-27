
/**
 * This class creates an instance of the Game
 * class and then calls on its run method.
 *
 * @author Derek Peacock
 * @version 0.1
 * 
 * Modified by Muhammad Mulla
 * Version March 2021
 */
public class Program
{
    private static Game game;
    
    /**
     * This class creates and runs an instance of
     * the Game class after the player name is inputted
     */
    public static void main(String playerName)
    {
        game = new Game(playerName);
        game.play();
    }
}
