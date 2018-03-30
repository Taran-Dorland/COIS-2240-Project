
/*  Project : NBTK AUTO SOLUTIONS 
 * 	Course :  Cois 2240 FINAL PROJECT
 *  Contributors : Nick Gordan, Batstone Christyanton, Taran Dorland, Kevin Dsane-Selby
 *  
 *  
 *  Description of Controller.java 
 *  * The controller class is responsible for the MVC  law of java EFX we are using the controller portion which is responsible for opening 
 *  windows are using to implement different function in this call you will see the instantiation of text fields and other try catch event
 *  used when opening and closing of windows. Here also we setting up the the prompt text of different input fields which we can use show the
 *  user what the input looks like. 
 *  * * 
 * *************************************************************************************************************************************/
package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.glass.ui.Window;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;


import javafx.event.*;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class Controller implements Initializable{


	private Connection dbConn = null;
	// instantiation needs to be done in order to set the prompting texts and being able to use them 
	@FXML
	public TextField lName = new TextField(),fName = new TextField(), pNumber = new TextField(), stNumber = new TextField(), Cname = new TextField(), pCode= new TextField(), pRovince= new TextField(), custId= new TextField(), bookType= new TextField(),
	bookDate = new TextField(),custEmail = new TextField();
	@FXML
	public TextField Make, Model, Year, Type, condition, Enginesize, Kilometers;
	@FXML
	public TextFlow textFlow;
	@FXML
	public AnchorPane rootPane;
	// button exit programmed to click the the window 
	@FXML
	public Button btnExit;
	@FXML
	// instantiation of choice box and setting different items in them 
	public ChoiceBox<String> custidbox;
	ObservableList<String> custidlist = FXCollections.observableArrayList("singke","married","singl");
	@FXML
		public void initialize(){

		custidbox.setItems(custidlist);
	}

	//-------------------------------------SALES BUTTON Functionality ------------ these comments apply to the others----------------------------------------
	public void Sales(ActionEvent e){
		// trying and then later catching the exception
		try {
			
			// loading the fxml file 
			FXMLLoader fxmlLoader = new FXMLLoader();
			// fxml set location of the background
			fxmlLoader.setLocation(getClass().getResource("salecar.fxml"));
			// scene size of the window to be 1280 by 720 
			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			// setting the stage of the sales window on load 
			Stage stage = new Stage();
			// stage title to be sales 
			stage.setTitle("Sales");
			// set scene
			stage.setScene(scene);
			// stage to show 
			stage.show();
			// catch exception 
		} catch(Exception e1) {
			e1.printStackTrace();

		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//Add booking to database
	public void addBooking(ActionEvent event) {

		try {

			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			String sql = "INSERT INTO booking(id, type, date, firstName, lastName, phoneNumber, email, address, city, province, postalCode) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps = dbConn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(custId.getText()));
			ps.setString(2, bookType.getText());
			ps.setString(3, bookDate.getText());
			ps.setString(4, fName.getText());
			ps.setString(5, lName.getText());
			ps.setInt(6, Integer.parseInt(pNumber.getText()));
			ps.setString(7, custEmail.getText());
			ps.setString(8, stNumber.getText());
			ps.setString(9, Cname.getText());
			ps.setString(10, pRovince.getText());
			ps.setString(11, pCode.getText());

			ps.executeUpdate();
			dbConn.close();

			System.out.println("Successfully written to database.");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);

			//---------------------------------------------------------------------------------------------------------------
		}

	}

	//Add purchase to database
	public void save(ActionEvent event){

		//System.out.println(fName.getText()+"-----fname");
		//System.out.println(lName.getText()+"-----lname");
		//System.out.println(pNumber.getText()+"----pnumber");
		//System.out.println(cNumber.getText()+"---cnumber");
		//System.out.println(stNumber.getText()+"----stnumber");
		//System.out.println(stName.getText()+"---stname");
		//System.out.println(Cname.getText()+"---cname");
		//System.out.println(pCode.getText()+"----pcode");
		//System.out.println(pRovince.getText()+"---province");
		//System.out.print(stNumber.getText()+"----fname");

		//-------------------------------------------------------------------------------------------------------------------

		//Email, id not applicable in this form, no proper input
		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");

			String sql = "INSERT INTO customer(id, firstName, lastName, phoneNumber, email, address, city, province, postalCode) VALUES(?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = dbConn.prepareStatement(sql);

			ps = dbConn.prepareStatement(sql);

			ps.setInt(1, 5);
			ps.setString(2, fName.getText());
			ps.setString(3, lName.getText());
			ps.setInt(4, Integer.parseInt(pNumber.getText()));
			ps.setString(5, "test@email.com");
			ps.setString(6, stNumber.getText());
			ps.setString(7, Cname.getText());
			ps.setString(8, pRovince.getText());
			ps.setString(9, pCode.getText());

			ps.executeUpdate();
			dbConn.close();

			System.out.println("Successfully written to database.");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);

			
		}

	}

	//--------------------------------------PurchaseButton functionality -----------------------------------------------
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
			System.out.println(e1.getMessage());
		}
	}

//-------------------------------------APPOINTMENT Button Functionality --------------------------------------------------

	public void AppointmentW(ActionEvent e){
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("appointmentW.fxml"));

			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("CarPurchase");

			stage.setScene(scene);

			stage.show();

		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}

	}
//--------------------------------SERVICE WINDOW--------------------------------------------------------------
	public void ServiceWindow(ActionEvent e){

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("Service.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("ServiceWindow");
			stage.setScene(scene);
			stage.show();

		} catch(Exception e1) { }
	}
	//----------------------------ADD CAR -----------------------------------------------------------------

	public void addcar(ActionEvent event) throws IOException{

		Parent root = FXMLLoader.load(getClass().getResource("addcar.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("addcar");
		stage.setScene(scene);
		stage.showAndWait();
	}
	//---------------------------REMOVER CAR-----------------------------------------------------------------
	public void Removecar(ActionEvent e){

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("removecar.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("ServiceWindow");
			stage.setScene(scene);
			stage.show();

		} catch(Exception e1) { }
	}
	//---------------------------EDIT CAR ---------------------------------------------------------------------
	public void EditCAr(ActionEvent e){

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("editcar.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("ServiceWindow");
			stage.setScene(scene);
			stage.show();



		} catch(Exception e1) { }

	}
	//--------------------------EXIT BUTTON --------------------------------------------------------------------

	@FXML
	private void Exits(ActionEvent e){
		((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
	}


	public void addbooking(ActionEvent event) throws IOException{

		Parent root = FXMLLoader.load(getClass().getResource("ddbooking.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("addbooking");
		stage.setScene(scene);
		stage.showAndWait();
	}
	//------------------------------REMOVE BOOKING FUNCTIOLAITY -----------------------------------------------------

	public void Removebooking(ActionEvent e){

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("removebooking.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("ServiceWindow");
			stage.setScene(scene);
			stage.show();


		} catch(Exception e1) { }

	}
	//--------------------------EDIT BOOKING FUNCTIONALITY -------------------------------------------------------------

	public void Editbooking(ActionEvent e){

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("editbooking.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("ServiceWindow");
			stage.setScene(scene);
			stage.show();

		} catch(Exception e1) { }

	}
	//-----------------------------------------------------------------------------------------------------------------

	@FXML
	private void Exits2(ActionEvent eff){
		((Stage)(((Button)eff.getSource()).getScene().getWindow())).close();
	}

//// EXAMPLE ON HOW ITS DONE AND IT WORKS WITHOUT PREDEFINED LIBRARYS

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		lName.setPromptText("Last Name");
		bookDate.setPromptText("dd/mm/year");
		fName.setPromptText("First Name");
		pNumber .setPromptText("ex 416-000-0000");
		stNumber .setPromptText("ex 52 ");
		Cname .setPromptText("City name ex boston");
		pCode .setPromptText("Postal code");
		pRovince.setPromptText("ex Ontario ");
		custId.setPromptText("AUTO GENERATED");
		bookType.setPromptText("");
		bookDate .setPromptText("Last Name");
		custEmail .setPromptText("Last Name");



	}
}
