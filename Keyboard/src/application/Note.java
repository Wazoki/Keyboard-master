package application;


import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class Note 
{
	public static final Rectangle2D SCREEN_BOUNDS = Screen.getPrimary().getVisualBounds();
	private double time;
	private double length;
	private int    key;
	private GraphicsContext graphics;
	private int x;
	private double y;
	public Note(GraphicsContext gc,double t,int l,double e)
	{
		key=l;
		graphics=gc;
		time=t;
		length=e;
		
	}
	public void draw(boolean black)
	{
		graphics.setFill(Color.RED);
		if(black)
		{
			graphics.fillText(";alkjf", 500, 100);
			graphics.fillRect(((double) key*37)+25, 0,SCREEN_BOUNDS.getWidth()/100,length);
			x=key*37+25;
			y=(SCREEN_BOUNDS.getHeight()/1.2)+length;
		}
		else
		{
			graphics.fillRect((double) key*37,SCREEN_BOUNDS.getHeight(),SCREEN_BOUNDS.getWidth()/52,length);
			x=key*37;
			y=SCREEN_BOUNDS.getHeight()/1.072 +length;
		}
		System.out.println("x "+x+"y "+y);
	}
	public boolean isPlayed()
	{
		return y-SCREEN_BOUNDS.getHeight()/1.2<=20;
	}
	public void changeColor(boolean black)
	{
		graphics.setFill(Color.ORANGE);
		if(black)
		{
			graphics.fillRect(((double) key*37)+25, SCREEN_BOUNDS.getHeight(),SCREEN_BOUNDS.getWidth()/100,SCREEN_BOUNDS.getHeight()/10);
			x=key*37+25;
			y=(SCREEN_BOUNDS.getHeight()/1.2)+SCREEN_BOUNDS.getHeight()/10;
		}
		else
		{
			graphics.fillRect((double) key*37,SCREEN_BOUNDS.getHeight()/1.072,SCREEN_BOUNDS.getWidth()/52,SCREEN_BOUNDS.getHeight()/10);
			x=key*37;
			y=SCREEN_BOUNDS.getHeight()/1.072 +SCREEN_BOUNDS.getHeight()/10;
		}
	}
	public int getKey()
	{
		return key;
	}
	
}
