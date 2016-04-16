package application;

import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 * @author Dean Iverson
 */
public class GridPaneKeyboard extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    final URL resource = getClass().getResource("/Sounds/Sound1");
    final AudioClip clip = new AudioClip(resource.toString());

    final Button button = new Button("Bing Zzzzt!");
    button.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        clip.play(1.0);
      }
    });

    final StackPane stackPane = new StackPane();
    stackPane.setPadding(new Insets(10));
    stackPane.getChildren().add(button);

    final Scene scene = new Scene(stackPane, 200, 200);
    final URL stylesheet = getClass().getResource("media.css");
    scene.getStylesheets().add(stylesheet.toString());

    primaryStage.setTitle("Basic AudioClip Example");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

