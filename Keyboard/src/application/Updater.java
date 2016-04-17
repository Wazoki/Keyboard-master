package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;

public class Updater 
{
	
	public static final Rectangle2D SCREEN_BOUNDS = Screen.getPrimary().getVisualBounds();
	private int blackCounter=1;
	private ArrayList<Double[]> bounds = new ArrayList<Double[]>();
	private GraphicsContext graphics;
	private int whiteCounter=1;
	private boolean[] black = new boolean[89];
	private int key;
	public Updater(GraphicsContext gc)
	{
		graphics= gc;
		graphics.drawImage(new Image("/application/BackofGround.jpg",SCREEN_BOUNDS.getWidth(), SCREEN_BOUNDS.getHeight(),true,false),0,0);
		for(int i=0;i<52;i++)
		{
			
			graphics.setFill(new Color(1,1,1,1));
			graphics.fillRect((double) i*37,SCREEN_BOUNDS.getHeight()/1.072,SCREEN_BOUNDS.getWidth()/52,SCREEN_BOUNDS.getHeight()/10);
			black[key]=false;
			key++;
			if(whiteCounter==1||whiteCounter==4)
			{
				graphics.fillRect((double)i*37, SCREEN_BOUNDS.getHeight()/1.2,SCREEN_BOUNDS.getWidth()/77,SCREEN_BOUNDS.getHeight());
				Double[] rect = {1.0,(double)i*37, SCREEN_BOUNDS.getHeight()/1.2,SCREEN_BOUNDS.getWidth()/77,SCREEN_BOUNDS.getHeight(),(double) i*37,SCREEN_BOUNDS.getHeight()/1.072,SCREEN_BOUNDS.getWidth()/52,SCREEN_BOUNDS.getHeight()/10};
				bounds.add(rect);
			}
			if(whiteCounter==2||whiteCounter==5||whiteCounter==6)
			{
				graphics.fillRect((double)i*37+7, SCREEN_BOUNDS.getHeight()/1.2,SCREEN_BOUNDS.getWidth()/100,SCREEN_BOUNDS.getHeight());
				Double[] rect = {1.0,(double)i*37+7, SCREEN_BOUNDS.getHeight()/1.2,SCREEN_BOUNDS.getWidth()/100,SCREEN_BOUNDS.getHeight(),(double) i*37,SCREEN_BOUNDS.getHeight()/1.072,SCREEN_BOUNDS.getWidth()/52,SCREEN_BOUNDS.getHeight()/10};
				bounds.add(rect);
			}
			if(whiteCounter==3||whiteCounter==7)
			{
				graphics.fillRect((double)i*37+8, SCREEN_BOUNDS.getHeight()/1.2,SCREEN_BOUNDS.getWidth()/66.5,SCREEN_BOUNDS.getHeight());
				Double[] rect = {1.0,(double)i*37+8, SCREEN_BOUNDS.getHeight()/1.2,SCREEN_BOUNDS.getWidth()/66.5,SCREEN_BOUNDS.getHeight(),(double) i*37,SCREEN_BOUNDS.getHeight()/1.072,SCREEN_BOUNDS.getWidth()/52,SCREEN_BOUNDS.getHeight()/10};
				bounds.add(rect);
			}
			if(whiteCounter>=7)
				whiteCounter=1;
			else
				whiteCounter++;
			if(blackCounter!=3&&blackCounter!=7)
			{
				graphics.setFill(new Color(0,0,0,1));
				graphics.fillRect(((double) i*37)+25, SCREEN_BOUNDS.getHeight()/1.2,SCREEN_BOUNDS.getWidth()/100,SCREEN_BOUNDS.getHeight()/10);
				Double[] rect = {0.0,((double) i*37)+25,SCREEN_BOUNDS.getHeight()/1.2,SCREEN_BOUNDS.getWidth()/100,SCREEN_BOUNDS.getHeight()/10};
				bounds.add(rect);
				black[key]=true;
				key++;
			}
			if (blackCounter>=7)
				blackCounter=1;
			else
				blackCounter++;
		}
	}
	public void changeColor(int i)
	{
		if(black[i]==false)
		{
		    graphics.setFill(Color.LIGHTGREY);
		    graphics.fillRect(bounds.get(i)[5],bounds.get(i)[6],bounds.get(i)[7],bounds.get(i)[8]);
		    graphics.fillRect(bounds.get(i)[1],bounds.get(i)[2], bounds.get(i)[3], bounds.get(i)[4]);
		}
		else
		{
			graphics.setFill(Color.DARKGRAY);
			graphics.fillRect(bounds.get(i)[1],bounds.get(i)[2], bounds.get(i)[3], bounds.get(i)[4]);
		}
		System.out.println(i);
	}
	public void originalColor(int i)
	{
		if(black[i]==false)
		{
			graphics.setFill(new Color(1,1,1,1));
			graphics.fillRect(bounds.get(i)[5],bounds.get(i)[6],bounds.get(i)[7],bounds.get(i)[8]);
			graphics.fillRect(bounds.get(i)[1],bounds.get(i)[2], bounds.get(i)[3], bounds.get(i)[4]);
		}
		else
		{
			graphics.setFill(new Color(0,0,0,1));
			graphics.fillRect(bounds.get(i)[1],bounds.get(i)[2], bounds.get(i)[3], bounds.get(i)[4]);
		}
	}
	public boolean isblack(int i)
	{
		return black[i];
	}
	
}
