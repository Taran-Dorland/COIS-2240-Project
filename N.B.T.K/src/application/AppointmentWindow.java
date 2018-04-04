package application;


import java.sql.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.control.*;

public class AppointmentWindow {


	private static Connection dbConn = null;


	public static void addAppointment(String title, String message) { //should probably not make it static for security

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //this forces the user to complete the window,so they cant go back
		window.setTitle(title);
		window.setMinHeight(400);
		window.setMinWidth(400);

		//GridPane with 10px padding around edge
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		//---------------------------------------------------------


		//Add auto-generating event id
		//Add description

		//---------------------------------------------------------



		//Name Label - constrains use (child, column, row)
		Label nameLabel = new Label("User ID:");
		GridPane.setConstraints(nameLabel, 0, 0);

		Label dateLabel = new Label ("date: ");
		GridPane.setConstraints(dateLabel, 0, 1);

		Label typeLabel = new Label ("booking type: ");
		GridPane.setConstraints(typeLabel, 0, 2);

		Label phoneLabel = new Label ("Phone number: ");
		GridPane.setConstraints(phoneLabel, 0, 3);

		Label emailLabel = new Label ("email: ");
		GridPane.setConstraints(emailLabel, 0, 4);

        Label emailLabel2 = new Label ("email2: ");
        GridPane.setConstraints(emailLabel2, 0, 4);
		//Name Input
		TextField dateInput = new TextField();
		GridPane.setConstraints(dateInput, 1, 1);

		//user Input
		TextField userInput = new TextField();
		GridPane.setConstraints(userInput, 1, 0);

		//type Input
		TextField typeInput = new TextField();
		GridPane.setConstraints(typeInput, 1, 2);

		//phone Input
		TextField phoneInput = new TextField();
		GridPane.setConstraints(phoneInput, 1, 3);

		//email Input
		TextField emailInput = new TextField();
		GridPane.setConstraints(emailInput, 1, 4);

		//Login
		Button loginButton = new Button("ADD information");
		GridPane.setConstraints(loginButton, 1, 8);

		dateInput.setPromptText(" dd/mm/yyyy ");
		userInput.setPromptText(" Numbers only ");
		typeInput.setPromptText(" booking type ");
		phoneInput.setPromptText(" 555-555-5555 ");
		emailInput.setPromptText(" johnsmith@sample.com ");

		loginButton.setOnAction(e -> {

			//Aquire values from text fields
			int custID = Integer.parseInt(userInput.getText());
			String bookingType = typeInput.getText();
			String bookingDesc = "";
			String bookingDate = dateInput.getText();
			String bookingEmail = emailInput.getText();
			String bookingPhone = phoneInput.getText();

			try {
				//Use values and insert into database
				dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");

				String sql = "INSERT INTO booking(id, type, description, date, email, phoneNumber) VALUES(?,?,?,?,?,?)";

				PreparedStatement ps = dbConn.prepareStatement(sql);

				ps = dbConn.prepareStatement(sql);
				ps.setInt(1, custID);
				ps.setString(2, bookingType);
				ps.setString(3, bookingDesc);
				ps.setString(4, bookingDate);
				ps.setString(5, bookingEmail);
				ps.setString(6, bookingPhone);

				ps.executeUpdate();

				dbConn.close();

			} catch (Exception e2) {
				System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
				System.exit(0);
			}


			//isInt(userInput, userInput.getText());
			//validateEmail(emailInout, emailInput.getText());
			//IsPhone(phoneInput, phoneInput.getText());
			//isDate(dateInput, dateInput.getText());;
		});

		Button goBackToAppointment = new Button("GO BACK to SALES");
		GridPane.setConstraints(goBackToAppointment, 1, 9);
		goBackToAppointment.setOnAction(e -> window.close());

		//Add everything to grid
		grid.getChildren().addAll(nameLabel,dateLabel, typeLabel, phoneLabel, emailLabel, emailLabel2, userInput, dateInput,phoneInput, emailInput,typeInput,  loginButton , goBackToAppointment);

		Scene scene = new Scene(grid, 400, 400);
		window.setScene(scene);

		window.showAndWait();
	}
	public static boolean isInt(TextField input, String message ) {

		try {
			int ID = Integer.parseInt(message);
			return true;
		} catch (NumberFormatException e) {

			return false;
		}

	}
	// private boolean validateEmail(TextField input2, String message){

	// }



	public static void removeAppointment(String title, String message) { //should probably not make it static for security

		Stage window2 = new Stage();
		window2.initModality(Modality.APPLICATION_MODAL); //this forces the user to complete the window,so they cant go back
		window2.setTitle(title);
		window2.setMinHeight(400);
		window2.setMinWidth(400);

		Label servicesLabel = new Label();
		servicesLabel.setText(message);

		VBox serviceLay = new VBox(20);
		serviceLay.getChildren().addAll(servicesLabel);

		Scene serviceScene = new Scene(serviceLay);
		window2.setScene(serviceScene);
		window2.showAndWait();
	}

	public static void editAppointment(String title, String message) { //sorry i have no clue how to do this
		Stage window3 = new Stage();
		window3.initModality(Modality.APPLICATION_MODAL); //this forces the user to complete the window,so they cant go back
		window3.setTitle(title);
		window3.setMinHeight(400);

		Label servicesLabel = new Label();
		servicesLabel.setText(message);

		VBox serviceLay = new VBox(20);
		serviceLay.getChildren().addAll(servicesLabel);

		Scene serviceScene = new Scene(serviceLay);
		window3.setScene(serviceScene);
		window3.showAndWait();

	}

	public static void searchAppointment(String title, String message) {


		Stage window4 = new Stage();
		window4.initModality(Modality.APPLICATION_MODAL); //this forces the user to complete the window,so they cant go back
		window4.setTitle(title);
		window4.setMinHeight(400);

		Label servicesLabel = new Label();
		servicesLabel.setText(message);

		VBox serviceLay = new VBox(20);
		serviceLay.getChildren().

		addAll(servicesLabel);

		Scene serviceScene = new Scene(serviceLay);
		window4.setScene(serviceScene);
		window4.showAndWait();
	}

	//overide the for the prompt
	public void initialize (URL arg0, ResourceBundle arg1) {

	}
}
