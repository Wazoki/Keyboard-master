package application;
	

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import sun.audio.*;
import javafx.application.Application;
import javafx.beans.binding.ListExpression;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;


public class Main extends Application 
{
	
	private Canvas c = new Canvas(794,600);
//	Updater up = new Updater(c.getGraphicsContext2D());
	private Key[] keys = new Key[88];
	private ArrayList<AudioClip> noise = new ArrayList<AudioClip>();
	private boolean[] playing = new boolean[89];
	
	public void start(Stage primaryStage) 
	{
		try 
		{
			c.getGraphicsContext2D().drawImage(new Image("/application/BackOfGround.jpg",800, 600,true,false),0,0);
			for(int x =0;x<keys.length;x++)
			{
				keys[x] = new Key(x,c.getGraphicsContext2D());
				keys[x].draw();
			}
//			Note note =new Note(c.getGraphicsContext2D(),2,52,200);
//			note.draw(up.isblack(note.getKey()));
			Group root = new Group();
			root.getChildren().add(c);
			Scene scene = new Scene(root);
//			primaryStage.setX(SCREEN_BOUNDS.getMinX());
//			primaryStage.setY(SCREEN_BOUNDS.getMinY());
//			primaryStage.setWidth(SCREEN_BOUNDS.getWidth());
//			primaryStage.setHeight(SCREEN_BOUNDS.getHeight());
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		primaryStage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() 
		{
			 public void handle(KeyEvent event)
			 {
				 char key = event.getText().charAt(0);
				 for(int i =0;i<=88;i++)
				 {
					 if(key==(char)(i+38))
					 {
						 if(keys[i].getColor())
						 {
							 if(!playing[i])
							 {
								 URL resource = getClass().getResource("/application/Sound1.wav");
								 AudioClip audio = new AudioClip(resource.toString());
								 
								 audio.play(.2);
								 playing[i]=true;
							 }
						 }
						 else
						 {
							 if(!playing[i])
							 {
								 URL resource = getClass().getResource("/application/Sound2.wav");
							 	AudioClip audio = new AudioClip(resource.toString());
							 	audio.play(.2);
							 	playing[i]=true;
							 }
						 }
						 System.out.println(i+38);
						keys[i].changeColor();
						 
					 }
				 }
				 
			 }
		});
		primaryStage.getScene().addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>()
		{
			public void handle(KeyEvent event)
			{
				char key = event.getText().charAt(0);
				System.out.println((int)key);
				for(int i=0;i<=88;i++)
				{
					if(key==(char)(i+38))
					{
						playing[i]=false;
						keys[i].originalColor();
					}
				}
			}

		});
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
