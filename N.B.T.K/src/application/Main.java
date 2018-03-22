package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application{
	Button button;
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		try {

			primaryStage.setTitle("N.B.T.K Auto S MRUN ");
			StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("runw.fxml"));
			Scene scene = new Scene(root,450,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch(Exception e) {
			e.printStackTrace();
		}


	}

	
	}


