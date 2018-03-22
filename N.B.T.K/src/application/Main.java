package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application{
	
	//Making sure I can push from this project
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		try {
			// setting the title of the for the application window
			primaryStage.setTitle("N.B.T.K Auto S MRUN ");
			// utilizing scene builder stack pane so application has exit max and close
			StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("runw.fxml"));
			// setting the size of the window
			Scene scene = new Scene(root, 1280, 720);
			// using the style sheets and the css sheet for design
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// setting the scene to start
			primaryStage.setScene(scene);
			// scene displays when running
			primaryStage.show();
			} catch(Exception e) {
			e.printStackTrace();




	}




	}
}


