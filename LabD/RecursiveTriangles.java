/**
 * a program that uses recursion to draw trapezoid- one trapezoid on the corner
 * of each trapezoid. 
 * an initial side length of 200, a minimum side length of 50, and cut the size
 * of a side in half each time.
 * @author Lishan Chan
 * @version 1.0
 */

import javax.swing.JApplet;
import java.awt.*;
import java.lang.Math;

public class RecursiveTriangles extends JApplet
{
	final static double ANGLE = Math.PI/6; //set the angle of the trapezoid
	final static int min_length=50;        //a minimum side length is set to 10
	public void init() {
		setSize(800, 800);
		setBackground(Color.white);
	}
	
	public void paint(Graphics pen)
	{
		fillRect(pen,200,500,200,100);
	}
	public static void fillRect(Graphics pen, int x, int y, int h, int l)
	{
		if(h>=min_length)
		{
			/*s is length from left bottom to the point in the base
			with top left point to become a right triangle */
			int s = (int)(l*Math.cos(ANGLE)); 
			
			//draw line and figure out the first trapezoid
			pen.drawLine( x , y , x+s , y-h);	      //from top left to bottom left
			pen.drawLine( x+s ,y-h , x+h+s , y-h);	      //from bottom left to bottom right
			pen.drawLine( x+h+s , y-h , x+2*s+h , y);     //from bottom right to top right
			pen.drawLine(x+2*s+h,  y, x, y);              //from the top right to the top left
			
			//call itself to draw the four trapezoid at the corner of the current trapezoid 
			fillRect(pen, x-h/2 ,y+h/4, h/2, l/2);
			fillRect(pen, x+s+h, y+h/4, h/2, l/2);
			fillRect(pen, x , y-h*3/4,h/2, l/2);
		        fillRect(pen, x+h , y-h*3/4 , h/2, l/2);	

		}
	}
}
