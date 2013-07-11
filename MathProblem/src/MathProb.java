import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class MathProb {

	/**
	 * @param args
	 */
	//a+b*n must equal a prime number for n=integer values from 0-9
	//b must be even
	//a must be prime
	public static List<Integer> primeList;
	public static long[] primeArray=new long[100000];
	
	
	public MathProb()
	{
//		primeList=new ArrayList<Integer>(100000);
//		for(int i=2;i<100000;i++)
//		{
//			primeList.add(i);
//		}
//		createPrimes();
		for(int i=2;i<100000;i++)
		{
			primeArray[i]=i;
		}
		createPrimesArray();
	}
	
	public void writeToText()
	{
		File primeListFile=new File("primeList");
		String[] primeStrings=new String[100000000];
		for(int i=0;i<primeList.size();i++)
		{
			primeStrings[i]=primeList.get(i).toString()+'\n';
		}
		
		try 
		{
			FileOutputStream primeOutput = new FileOutputStream(primeListFile);
			for(int i=0;i<primeList.size();i++)
			{
				primeOutput.write(primeStrings[i].getBytes());
			}
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writeToList()
	{
		List<Integer> primeStrings=new ArrayList<Integer>();
		String temp="";
		File primeListFile=new File("primeList");
		try 
		{
			FileInputStream primeInput=new FileInputStream(primeListFile);
			while(primeInput.available()>0)
			{
				byte[] b ={new Integer(primeInput.read()).byteValue()};
				
				if(b[0]==10)
				{
					primeStrings.add(Integer.valueOf(temp));
					temp="";
				}
				else
					temp+=new String(b);
			}
			primeInput.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		primeList=primeStrings;
	}
	
	public static boolean isPrime(int n)
	{
		return primeList.contains(n);
	}
	
	public void createPrimes()
	{
		for(int i=0;i<Math.sqrt(primeList.size());i++)
		{
			for(int j=i+1;j<primeList.size();j++)
			{
				if(primeList.get(j)/primeList.get(i)==((double)primeList.get(j))/primeList.get(i))
				{
					primeList.remove(j);
					j--;
				}
			}
		}
	}
	
	public void createPrimesArray()
	{
		for(int i=2;i<Math.sqrt(primeArray.length);i++)
		{
//			for(int j=i+1;j<primeArray.length;j++)
//			{
//				if(primeArray[i]!=0&&primeArray[j]!=0)
//				{
//					if(primeArray[j]/primeArray[i]==((double)primeArray[j]/primeArray[i]))
//					{
//						primeArray[j]=0;
//					}
//				}
//			}
			for(int j=i*i;j<primeArray.length;j+=i)
			{
				primeArray[j]=0;
			}	
		}
	}
	
	public void writeToTextArray()
	{
		File primeListFile=new File("primeList");
		String[] primeStrings=new String[100000000];
		for(int i=0;i<primeArray.length;i++)
		{
			if(primeArray[i]!=0)
				primeStrings[i]=BigInteger.valueOf((primeArray[i])).toString()+'\n';
		}
		
		try 
		{
			FileOutputStream primeOutput = new FileOutputStream(primeListFile);
			for(int i=0;i<primeArray.length;i++)
			{
				if(primeStrings[i]!=null)
					primeOutput.write(primeStrings[i].getBytes());
			}
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time=System.nanoTime();
		MathProb mp=new MathProb();
		float finalTime=System.nanoTime()-time;
		finalTime/=1000000000.;
		System.out.println("Calc time: "+finalTime+" seconds");
		//mp.writeToText();
		long time2=System.nanoTime();
		mp.writeToTextArray();
		float finalTime2=System.nanoTime()-time;
		finalTime2/=1000000000.;
		System.out.println("Write time: "+finalTime2+" seconds");
		
		
		
	//	MathProb.writeToList();
		
//		boolean end=false;
//		int i=1;
//		int a=primeList.get(i);
//		int b=2;
//		
//		while(!end&&a<1000)
//		{
//			while(!end&&b<1000)
//			{
//				int n;
//				for(n=0;n<10;n++)
//				{
//					if(!MathProb.isPrime(a+b*n))
//						break;
//				}
//				if(n==10)
//				{
//					System.out.println("WINNING a="+a+" b="+b);
//					for(int j=0;j<10;j++)
//					{
//						System.out.print(a+b*j+" ");
//						System.out.println(MathProb.isPrime(a+b*j));
//					}
//					end=true;
//				}
//				b+=2;
//			}
//			b=2;
//			i++;
//			a=primeList.get(i);
//		}
	}
}
