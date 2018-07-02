/**
 * a program that uses recursion to draw squares- one square on the corner of each square. 
 * an initial side length of 200, a minimum side length of 50, and cut the size
 * of a side in half each time.
 * @author Lishan Chan
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Square extends JApplet
{ 
	final static int min_length=50;     //a minimum side length is set to 50
			
	public void init() {
		setSize(500, 500);          //set the size 
		setBackground(Color.white); //set the color of the backgroud
	}
	
	public void paint(Graphics pen)
	{
		fillRect(pen,150,150,200);  //start from (x,y)=(150,150), heigh 200
	}
	public static void fillRect(Graphics pen, int x, int y, int h)
	{

		if(h>min_length)
		{					
			//draw lines and figure it out the first square
			pen.drawLine( x , y , x , y+h);		//from top left to bottom left
			pen.drawLine( x ,y+h , x+h , y+h);	//from bottom left to bottom right
			pen.drawLine( x+h , y+h , x+h , y);	//from bottom right to top right
			pen.drawLine(x+h,y, x, y);              //from the top right to the top left	
			
			//recursions in order: top left, bottom left, bottom right, and top right square
			fillRect(pen, x-h/4 ,y-h/4, h/2);
			fillRect(pen, x-h/4, y+h*3/4, h/2);
			fillRect(pen, x+h*3/4 , y+h*3/4,h/2);
			fillRect(pen, x+h*3/4 , y-h/4 , h/2);	
		}
	}
}
