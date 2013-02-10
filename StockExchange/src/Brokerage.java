import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class Brokerage {

	/**
	 * @param args
	 */
	private TreeMap<Trader,String> myTraders;
	private TreeSet<Trader> loggedInTraders;
	private StockExchange myStockExchange;
	
	public Brokerage(StockExchange stockExchange) //Constructs new brokerage affiliated with a given stock exchange.
	{
		
	}
	public int addUser(String name, String password) //Tries to register a new trader with a given screen name and password.
	{
		myTraders.put(name,password);
	}
	public void getQuote(String stockSymbol, Trader trader) // Requests a quote for a given stock from the stock exachange and passes it along to the trader by calling trader's receiveMessage method.
	{
		//return myStockExchange.getQuote(stockSymbol);
	}
	public int login(String name, String password) // Tries to login a trader with a given screen name and password.
	{
		String lowerName = name.toLowerCase();
		
		if(lowerName.length() < 4 || lowerName.length() >= 11)  //name must be within 4-10 chars
			return -1;
		else if(password.length() < 2 || password.length() >= 11) //pass must me within 2 - 10 chars
			return -2;
		else if(myTraders.containsKey(lowerName))  //if the username is already taken
			return -3;
		else
		{
			loggedInTraders.put(lowerName,password);
			return 0;
		}
	}
	public void logout(Trader trader) //Removes a specified trader from the set of logged-in traders.
	{
		loggedInTraders.remove(trader);
		
	}
	public void placeOrder(TradeOrder to) //to = TradeOrder
	{
		myStockExchange.placeOrder(to);
	}
	
	

}
