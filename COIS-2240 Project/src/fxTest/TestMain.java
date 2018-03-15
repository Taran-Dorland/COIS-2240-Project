package fxTest;

/*	Was just messing around with how to get JavaFX to work using Java's documentation
 * 	since Alaadin's slides/examples aren't the greatest. 
 * 	
 * 	In order to actually use JavaFX in Eclipse you have to follow the
 * 	instructions here: https://www.eclipse.org/efxclipse/install.html
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.css.*;

public class TestMain extends Application {
	
	//Main
	public static void main(String[] args) {
		launch(args);
	}

	//JavaFX Start
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Create button
		Button btn1 = new Button();
		btn1.setText("Button");
		
		//Add event handler to button
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("BUTTON PRESSED");
			}
			
		});
		
		//Setup grid
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.TOP_LEFT);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));
		
		//Create scene, grid, width: 400px, height: 500px
		Scene sceneTest = new Scene(gp, 400, 500);
		
		//Set scene
		primaryStage.setTitle("THIS IS A TITLE");
		primaryStage.setScene(sceneTest);
		
		//Create text object
		Text sceneTxt = new Text("THIS IS TEXT");
		
		//Assign objects id's to be identified with .css sheet
		sceneTxt.setId("scene-txt");
		btn1.setId("btn1-btn");
		
		//Add objects to grid
		gp.add(sceneTxt, 0, 0);
		gp.add(btn1, 5, 7);
		
		//Use .css
		sceneTest.getStylesheets().add(TestMain.class.getResource("JavaFXTest.css").toExternalForm());
		
		//Show window
		primaryStage.show();
	}
}
