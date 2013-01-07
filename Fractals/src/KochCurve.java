/**
 * 
 */
import edu.gatech.mediaprogramming.*;
/**
 * @author jack
 *
 */
public class KochCurve extends Turtle{

	/**
	 * @param args
	 */
	
	public void drawKochCurve(int depth, double length)
	{
		if(depth==1)
		{
			forward(length);
		}
		else
		{
			drawKochCurve(depth-1,length/3);
			turn(-60);
			drawKochCurve(depth-1,length/3);
			turn(120);
			drawKochCurve(depth-1,length/3);
			turn(-60);
			drawKochCurve(depth-1,length/3);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		KochCurve t=new KochCurve();
		t.turn(90); //face east
		t.drawKochCurve(6, 400);
		

	}

}
