
/*  Project : NBTK AUTO SOLUTIONS
 * 	Course :  Cois 2240 FINAL PROJECT
 *  Contributors : Nick Gordan, Batstone Christyanton, Taran Dorland, Kevin Dsane-Selby
 *
 *
 *  Description of Main.java
 *
 *  *
 *  * *
 * *************************************************************************************************************************************/
package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;

import javafx.fxml.FXMLLoader;


public class Main extends Application{

	//Making sure I can push from this project
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		PrintWriter writer;
		try {
			writer = new PrintWriter("var.txt");
			writer.print("");
			writer.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			// setting the title of the for the application window
			primaryStage.setTitle("N.B.T.K Auto S MRUN ");
			// utilizing scene builder stack pane so application has exit max and close
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("runw.fxml"));
			// setting the size of the window
			Scene scene = new Scene(root, 800, 800);
			// using the style sheets and the css sheet for design
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// setting the scene to start
			primaryStage.setScene(scene);
			// scene displays when running
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
