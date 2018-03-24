package application;


import java.io.IOException;

import com.sun.glass.ui.Window;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Controller {
	private static final Scene Fxm2Scene = null;
	@FXML
	public AnchorPane rootPane;

	public void Sales(ActionEvent e){
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("salecar.fxml"));

	        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
	        Stage stage = new Stage();
	        stage.setTitle("Sales");

	        stage.setScene(scene);

	        stage.show();

    } catch(Exception e1) {

	}
	}



	    public void Purchase(ActionEvent e){
		    try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("carpuarchase.fxml"));

		        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
		        Stage stage = new Stage();
		        stage.setTitle("CarPurchase");

		        stage.setScene(scene);

		        stage.show();

		    } catch(Exception e1) {


		    }


	}


		public void AppointmentW(ActionEvent e){
		    try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("appointmentw.fxml"));

		        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
		        Stage stage = new Stage();
		        stage.setTitle("CarPurchase");

		        stage.setScene(scene);

		        stage.show();

		    } catch(Exception e1) {



		    }

		}

		public void ServiceWindow(ActionEvent e){

		    try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("service.fxml"));
		        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
		        Stage stage = new Stage();
		        stage.setTitle("ServiceWindow");
		        stage.setScene(scene);
		        stage.show();



		    } catch(Exception e1) {



		    }

		}




	public void addcar(ActionEvent event) throws IOException{


		       Parent root = FXMLLoader.load(getClass().getResource("addcar.fxml"));
		       Scene scene = new Scene(root);
		       Stage stage = new Stage();
		       stage.initModality(Modality.APPLICATION_MODAL);
		       stage.setTitle("addcar");
		       stage.setScene(scene);
		       stage.showAndWait();




		    }






public void Removecar(ActionEvent e){

    try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("removecar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage stage = new Stage();
        stage.setTitle("ServiceWindow");
        stage.setScene(scene);
        stage.show();



    } catch(Exception e1) {



    }

}



public void EditCAr(ActionEvent e){

    try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editcar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage stage = new Stage();
        stage.setTitle("ServiceWindow");
        stage.setScene(scene);
        stage.show();



    } catch(Exception e1) {



    }

}

@FXML
private void Exits(ActionEvent e){
	((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
}


public void addbooking(ActionEvent event) throws IOException{


    Parent root = FXMLLoader.load(getClass().getResource("addcar.fxml"));
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("addcar");
    stage.setScene(scene);
    stage.showAndWait();




 }






public void Removebooking(ActionEvent e){

try {
FXMLLoader fxmlLoader = new FXMLLoader();
fxmlLoader.setLocation(getClass().getResource("removecar.fxml"));
Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
Stage stage = new Stage();
stage.setTitle("ServiceWindow");
stage.setScene(scene);
stage.show();



} catch(Exception e1) {



}

}



public void Editbooking(ActionEvent e){

try {
FXMLLoader fxmlLoader = new FXMLLoader();
fxmlLoader.setLocation(getClass().getResource("editcar.fxml"));
Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
Stage stage = new Stage();
stage.setTitle("ServiceWindow");
stage.setScene(scene);
stage.show();



} catch(Exception e1) {



}

}

@FXML
private void Exits2(ActionEvent eff){
((Stage)(((Button)eff.getSource()).getScene().getWindow())).close();
}
}










