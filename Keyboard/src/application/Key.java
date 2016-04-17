package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class Key 
{
	private boolean color;
	private int key;
	private boolean triggered;
	private GraphicsContext graphics;
	private int octave;
	private int note;
	private int x;
	private double width;
	private AudioClip audio;
	
	public Key(int i,GraphicsContext gc)
	{
		key=i;
		octave = ((i) / 12)-1;
		note=(i)%12;
		if(note>5)
			color = note%2==0;
		else
			color = note%2==1&&note!=5;
		graphics=gc;
		System.out.println(octave +" "+ note);
	}
	
	public boolean draw()
	{
		if(color)
		{
			graphics.setFill(Color.BLACK);
			graphics.fillRect(key*9+5,500,8,60);
			return true;
		}
		else
		{
			graphics.setFill(Color.WHITE);
			graphics.fillRect(key*9,560,17.9,60);
			if( note ==4||note==11)
			{
				graphics.fillRect(key*9+4, 500,10,60);
				x= key*9+4;
				width=10;
				graphics.setFill(Color.BLACK);
				graphics.fillRect(key*9+9,560 , 1, 60);
				return true;
			}
			else
			if(note ==2 || note ==7||note==9)
			{
				graphics.fillRect(key*9+4, 500,10,60);
				x= key*9+4;
				width=10;
				return true;
			}
			else
			{
				graphics.fillRect(key*9, 500,14,60);
				x= key*9;
				width=14;
				return true;
			}
		}
	}
	
	public boolean isTriggered()
	{
		return triggered;
	}
	
	public int getKey()
	{
		return key;
	}
	public boolean getColor()
	{
		return color;
	}
	public AudioClip getAudio()
	{
		return audio;
	}
	public void changeColor()
	{
		if(!color)
		{
		    graphics.setFill(Color.LIGHTGREY);
		    graphics.fillRect(x,500,width,60);
		    graphics.fillRect(key*9,560,15,60);
		}
		else
		{
			graphics.setFill(Color.DARKGRAY);
			graphics.fillRect(key*9+5, 500,8,60);
		}
	}
	public void originalColor()
	{
		if(!color)
		{
		    graphics.setFill(Color.WHITE);
		    graphics.fillRect(x,500,width,60);
		    graphics.fillRect(key*9,560,15,60);
		}
		else
		{
			graphics.setFill(Color.BLACK);
			graphics.fillRect(key*9+5,500,8,60);
		}
	}
}
