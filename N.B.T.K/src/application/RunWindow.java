package application;

import javafx.event.ActionEvent;
//import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunWindow {

	@FXML
//	String message;
//	private Label myMessage;
//	public void sales(ActionEvent event){
//
//	 System.out.println("hey");
//}
public void sales(ActionEvent e){
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("sales.fxml"));
	        /*
	         * if "fx:controller" is not set in fxml
	         * fxmlLoader.setController(NewWindowController);
	         */
	        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
	        Stage stage = new Stage();
	        stage.setTitle("New Window");
	        stage.setScene(scene);
	        stage.show();
	    } catch(Exception e1) {
			System.out.println(e1.getMessage());


	    }
}
}











