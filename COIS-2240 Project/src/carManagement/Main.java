package carManagement;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application{

	//Main
	public static void main(String[] args) {
		launch(args);
	}

	//Starting opening screen of the GUI
	@Override
	public void start(Stage primaryStage) {
		try {

			primaryStage.setTitle("N.B.T.K Auto S MRUN ");

			//Load fxml
			StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("runw.fxml"));

			//Create new scene
			Scene scene = new Scene(root, 450, 400);

			//Load css
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			//Setup/load scene
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


