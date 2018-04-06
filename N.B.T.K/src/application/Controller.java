
/*  Project : NBTK AUTO SOLUTIONS\
 * 

 * 	Course :  Cois 2240 FINAL PROJECT
 *  Contributors : Nick Gordan, Batstone Christyanton, Taran Dorland, Kevin Dsane-Selby
 *
 *
 *  Description of Controller.java
 *  * The controller class is responsible for the MVC law of java EFX we are using the controller portion which is responsible for opening
 *  windows are using to implement different function in this call you will see the instantiation of text fields and other try catch event
 *  used when opening and closing of windows. Here also we setting up the the prompt text of different input fields which we can use show the
 *  user what the input looks like.
 *  * *
 * *************************************************************************************************************************************/

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.TextFlow;

public class Controller implements Initializable{

	private int x = 1, bookingId = 1, serviceId = 1;
	private Connection dbConn = null;

	String newLine = System.getProperty("line.separator");

	// instantiation needs to be done in order to set the prompting texts and being able to use them
	@FXML
	public TextField lName = new TextField(),fName = new TextField(), pNumber = new TextField(), stNumber = new TextField(), Cname = new TextField(), pCode= new TextField(), pRovince= new TextField(), custId= new TextField(), bookType= new TextField(),
	bookDate = new TextField(),custEmail = new TextField();
	@FXML
	public TextField cMake = new TextField(), cModel = new TextField(), cYear = new TextField(), cEngineSize = new TextField(), cType = new TextField(), cKilometers = new TextField(), cCondition = new TextField(), cPrice = new TextField();
	@FXML
	public TextField cMake2 = new TextField(), cModel2 = new TextField(), cYear2 = new TextField(), cEngineSize2 = new TextField(), cType2 = new TextField(), cKilometers2 = new TextField(), cCondition2 = new TextField();
	@FXML
	public TextField cMake3 = new TextField(), cModel3 = new TextField(), cYear3 = new TextField(), cEngineSize3 = new TextField(), cType3 = new TextField();
	@FXML
	public TextField cPlateNum = new TextField(), cServiceId = new TextField();
	@FXML
	public TextFlow textFlow;
	@FXML
	public AnchorPane rootPane;
	@FXML
	public Button btnExit;
	@FXML
	public ImageView ivOne = new ImageView(), ivTwo = new ImageView();
	@FXML
	public RadioButton rBtnOne = new RadioButton(), rBtnTwo = new RadioButton();
	@FXML
	public ToggleGroup tg = new ToggleGroup();
	@FXML
	public TextArea ta = new TextArea(), ta2 = new TextArea();
	@FXML
	public TextField txtBookId = new TextField(), txtBookType = new TextField(), txtServiceId = new TextField(), txtServicePlate = new TextField();



	//--------------------------------------------------------------------------------------------------------------------------------
	//SALES BUTTON Functionality ------------ These comments apply to the others
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
			stage.setResizable(false);
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
		}

		//Add car information for booking with same id as customer information
		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			String sql = "INSERT INTO carBooking(id, make, model, year, engineSize, type, kilometers, condition) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps = dbConn.prepareStatement(sql);

			ps.setInt(1, bookingId);
			ps.setString(2, cMake2.getText());
			ps.setString(3, cModel2.getText());
			ps.setString(4, cYear.getText());
			ps.setString(5, cEngineSize2.getText());
			ps.setString(6, cType2.getText());
			ps.setInt(7, Integer.parseInt(cKilometers2.getText()));
			ps.setString(8, cCondition2.getText());

			ps.executeUpdate();
			ps.close();
			dbConn.close();

			System.out.println("Successfully written to database.");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//Remove booking from database
	public void removeBookingFromDB(ActionEvent event) {

		int idHolder = Integer.parseInt(txtBookId.getText());
		System.out.println(idHolder);

		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			String sql = "DELETE FROM booking WHERE id = ?;";
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps = dbConn.prepareStatement(sql);

			ps.setInt(1, idHolder);

			ps.executeUpdate();
			ps.close();
			dbConn.close();

			System.out.println("Successfully deleted from database.");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	//
	//TEST
	//--------------------------------------------------------------------------------------------------------------------------------
	//Add service to database
	public void addService(ActionEvent event) {

		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			String sql = "INSERT INTO service(id, make, model, year, engineSize, type, plateNumber) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps = dbConn.prepareStatement(sql);

			ps.setInt(1, Integer.parseInt(cServiceId.getText()));
			ps.setString(2, cMake3.getText());
			ps.setString(3, cModel3.getText());
			ps.setString(4, cYear3.getText());
			ps.setString(5, cEngineSize3.getText());
			ps.setString(6, cType3.getText());
			ps.setString(7, cPlateNum.getText());

			ps.executeUpdate();
			ps.close();
			dbConn.close();

			System.out.println("Successfully written to database.");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//Remove booking from database
	public void removeServiceFromDB(ActionEvent event) {

		int idHolder = Integer.parseInt(txtServiceId.getText());
		System.out.println(idHolder);

		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			String sql = "DELETE FROM service WHERE id = ?;";
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps = dbConn.prepareStatement(sql);

			ps.setInt(1, idHolder);

			ps.executeUpdate();
			ps.close();
			dbConn.close();

			System.out.println("Successfully deleted from database.");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//Add purchase to database
	public void save(ActionEvent event){

		//Email, id not applicable in this form, no proper input
		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");

			String sql = "INSERT INTO customer(id, firstName, lastName, phoneNumber, email, address, city, province, postalCode) VALUES(?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = dbConn.prepareStatement(sql);

			ps = dbConn.prepareStatement(sql);

			ps.setInt(1, 10);
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



	//--------------------------------------------------------------------------------------------------------------------------------
	//PurchaseButton functionality
	public void Purchase(ActionEvent e){
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("carpuarchase.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("CarPurchase");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();


		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void Payment(ActionEvent e){

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("payement.fxml"));

			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("ServiceWindow");
			stage.setScene(scene);
			stage.setResizable(false);

			stage.show();



		} catch(Exception e1) { }

	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//APPOINTMENT Button Functionality

	public void AppointmentW(ActionEvent e){
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("appointmentW.fxml"));

			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("CarPurchase");

			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//SERVICE WINDOW
	public void ServiceWindow(ActionEvent e){

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("Service.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("ServiceWindow");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		} catch(Exception e1) { }
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//ADD CAR

	public void addcar(ActionEvent event) throws IOException{

		Parent root = FXMLLoader.load(getClass().getResource("addcar.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("addcar");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.showAndWait();
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//REMOVER CAR
	public void Removecar(ActionEvent e){

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("removecar.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("ServiceWindow");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		} catch(Exception e1) { }
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//EXIT BUTTON
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
		stage.setResizable(false);
		stage.showAndWait();
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	//REMOVE BOOKING FUNCTIOLAITY

	public void Removebooking(ActionEvent e){

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("removebooking.fxml"));

			Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
			Stage stage = new Stage();
			stage.setTitle("ServiceWindow");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();



		} catch(Exception e1) { }

	}


	//--------------------------------------------------------------------------------------------------------------------------------
	//Used to determine which car is selected
	public void CheckCar(ActionEvent e) {

		RadioButton selectedRB = (RadioButton) tg.getSelectedToggle();

		if (selectedRB.equals(rBtnOne)) {
			x = 1;
			System.out.println("TOYOTA SELECTED");
		} else if (selectedRB.equals(rBtnTwo)) {
			x = 2;
			System.out.println("HONDA SELECTED");
		}

		//Refresh the text file with nothing
		PrintWriter pWriter;
		try {
			pWriter = new PrintWriter("var.txt");
			pWriter.print("");
			pWriter.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		//Write the new x variable to var.txt
		try {
			FileWriter writer = new FileWriter("var.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			bufferedWriter.write(Integer.toString(x));
			bufferedWriter.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@FXML
	private void Exits2(ActionEvent eff){
		((Stage)(((Button)eff.getSource()).getScene().getWindow())).close();
	}

	// setting the prompt text of the fields where information 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		lName.setPromptText("Last Name");
		bookDate.setPromptText("dd/mm/year");
		fName.setPromptText("First Name");
		pNumber.setPromptText("ex 416-000-0000");
		stNumber.setPromptText("ex 52");
		Cname.setPromptText("City name ex boston");
		pCode.setPromptText("Postal code");
		pRovince.setPromptText("ex Ontario ");
		custId.setPromptText("AUTO GENERATED");
		bookType.setPromptText("ex Service");
		bookDate.setPromptText("dd/mm/year");
		custEmail.setPromptText("johnsmith@sample.com");
		cMake.setPromptText("ex honda");
		cModel.setPromptText("ex accord");
		cYear.setPromptText("ex 1991");
		cEngineSize.setPromptText("Ex 4.0L");
		cType.setPromptText("ex sedan,suv ");
		cKilometers.setPromptText("ex1000000");
		txtBookId.setPromptText("ex1");
		txtBookType.setPromptText("ex service or sales");
		txtServiceId.setPromptText("ex000");
		txtServicePlate.setPromptText("000-0000");
		cMake2.setPromptText("ex honda");
		cModel2.setPromptText("ex accord");
		cYear2.setPromptText("ex 1991");
		cEngineSize2.setPromptText("Ex 4.0L");
		cType2.setPromptText("ex sedan,suv ");
		cKilometers2.setPromptText("ex1000000");
		cMake3.setPromptText("ex honda");
		cModel3.setPromptText("ex accord");
		cYear3.setPromptText("ex 1991");
		cEngineSize3.setPromptText("Ex 4.0L");
		cType3.setPromptText("ex sedan,suv ");
		cCondition.setPromptText("ex used or new");
		cCondition2.setPromptText("ex user or new");



		//Read the x variable from var.txt
		try {
			FileReader reader = new FileReader("var.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String varHolder;

			while ((varHolder = bufferedReader.readLine()) != null) {
				System.out.println(varHolder);
				x = Integer.parseInt(varHolder);

			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			System.out.println("x is: " + x);

			//Database stuff
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			Statement stmt = null;
			stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CARS;");

			//Move the index to the correct car
			for (int i = 0; i < x; i++) {
				rs.next();
			}

			int carId = rs.getInt("id");
			String carMake = rs.getString("make");
			String carModel = rs.getString("model");
			String carYear = rs.getString("year");
			String carEngineSize = rs.getString("engine_size");
			String carType = rs.getString("type");
			int carKm = rs.getInt("km");
			String carCondition = rs.getString("condition");
			int carPrice = rs.getInt("price");
			String carImg = rs.getString("picture");

			System.out.println(carId + " " + carMake + " " + carModel);

			cMake.setText(carMake);
			cModel.setText(carModel);
			cYear.setText(carYear);
			cEngineSize.setText(carEngineSize);
			cType.setText(carType);
			cKilometers.setText(Integer.toString(carKm));
			cCondition.setText(carCondition);
			cPrice.setText(Integer.toString(carPrice));


			rs.close();
			stmt.close();
			dbConn.close();

		} catch (Exception e) {

		}

		//Get latest booking id, add one to it to create a new id
		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			Statement stmt = null;
			stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM BOOKING;");

			//Get latest booking id, add one to it
			while (rs.next()) {
				bookingId = rs.getInt("id");
				bookingId++;
			}

			custId.setText(Integer.toString(bookingId));

			rs.close();
			stmt.close();
			dbConn.close();

		} catch (Exception e) { }

		//Load booking id's into textarea for remove booking
		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			Statement stmt = null;
			stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id,type FROM BOOKING;");

			//Get all booking id's and type's and output them to text area
			while (rs.next()) {

				String id = Integer.toString(rs.getInt("id"));
				String type = rs.getString("type");

				ta.setText(ta.getText() + "ID: " + id + "     " + " Type: " + type);
				ta.setText(ta.getText() + newLine);
			}

			rs.close();
			stmt.close();
			dbConn.close();

		} catch (Exception e) { }

		//Get latest service id, add one to it
		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			Statement stmt = null;
			stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM service;");

			//Get latest booking id, add one to it
			while (rs.next()) {
				serviceId = rs.getInt("id");
				serviceId++;
			}

			cServiceId.setText(Integer.toString(serviceId));

			rs.close();
			stmt.close();
			dbConn.close();

		} catch (Exception e) { }

		//Load service id's into textarea for remove service
		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			Statement stmt = null;
			stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id,plateNumber FROM SERVICE;");

			//Get all booking id's and type's and output them to text area
			while (rs.next()) {

				String id = Integer.toString(rs.getInt("id"));
				String plateNum = rs.getString("plateNumber");

				ta2.setText(ta2.getText() + "ID: " + id + "     " + " Type: " + plateNum);
				ta2.setText(ta2.getText() + newLine);
			}

			rs.close();
			stmt.close();
			dbConn.close();

		} catch (Exception e) { }

	}

}

