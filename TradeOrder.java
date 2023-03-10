import java.lang.reflect.*;

/**
 * Represents a buy or sell order for trading a given number of shares of a
 * specified stock.
 * @author Yvonne
 */
public class TradeOrder
{
    private Trader trader;
    private String symbol;
    private boolean buyOrder;
    private boolean marketOrder;
    private int numShares;
    private double price;

    private Trader getTrader()
    {
        return trader;
    }
    private String getSymbol()
    {
        return symbol;
    }
    private boolean isBuy()
    {
        return buyOrder;
    }
    private boolean isSell()
    {
        return !buyOrder;
    }
    private boolean isMarket()
    {
        return marketOrder;
    }
    private boolean isLimit()
    {
        return !marketOrder;
    }
    private int getShares()
    {
        return numShares;
    }
    private double getPrice()
    {
        return price;
    }
    private void subtractShares(int shares)
    {
        numShares -= shares;
    }

    //
    // The following are for test purposes only
    //
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this TradeOrder.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
