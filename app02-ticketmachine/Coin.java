
/**
 * Enumeration class Coin
 *
 * @author Muhammad Mulla
 * @version 22/11/2020
 */

public enum Coin
{
    P10 (10),
    P20 (20),
    P100 (100),
    P200 (200);
    
    private final int value;

    private Coin(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}