import java.util.HashMap;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class StockExchange {

	/**
	 * @param args
	 */
	private Brokerage myBrokerage;
	private HashMap<String,Stock> stockList;
	
	public stockExchange() //Constructs a new stock exchange object
	{
		Map<String, Integer> stockExchange = new HashMap<String , Integer>();
		
	}
	public String getQuote(String stockSymbol)//Returns a quote for a given stock.
	{
		return stockList.get(stockSymbol).returnQuote();
	}
	public void listStock(String stockSymbol, String companyName, double price) //Adds a new stock with given parameters to the listed stocks.
	{
		
	}
	public void placeOrder(TradeOrder to) //Places a trade order by calling stock.placeOrder for the stock specified by the stock symbol in the trade order.
	{
		if(to.getBuy())										//checks if buy or sell
			stockList.get(to.getStockSymbol()).buy(to);		//sends buy to Stock
		else
			stockList.get(to.getStockSymbol()).sell(to);	//sends sell to Stock
			
	}
}
