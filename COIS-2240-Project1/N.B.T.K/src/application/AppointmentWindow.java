package application;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
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

		//Name Input
		TextField dateInput = new TextField();
		dateInput.setPromptText("dd/mm/yyyy");
		GridPane.setConstraints(dateInput, 1, 1);

		//user Input
		TextField userInput = new TextField();
		userInput.setPromptText("Numbers only");
		GridPane.setConstraints(userInput, 1, 0);

		//type Input
		TextField typeInput = new TextField();
		typeInput.setPromptText("booking type");
		GridPane.setConstraints(typeInput, 1, 2);

		//phone Input
		TextField phoneInput = new TextField();
		phoneInput.setPromptText("555-555-5555");
		GridPane.setConstraints(phoneInput, 1, 3);

		//email Input
		TextField emailInput = new TextField();
		emailInput.setPromptText("johnsmith@sample.com");
		GridPane.setConstraints(emailInput, 1, 4);

		//Login
		Button loginButton = new Button("ADD information");
		GridPane.setConstraints(loginButton, 1, 8);

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

			} catch (Exception e2) 
			{
				System.err.println(e2.getClass().getName() + ": " + e2.getMessage());
				System.exit(0);}  
			});


			
		

		Button goBackToAppointment = new Button("GO BACK to SALES");
		GridPane.setConstraints(goBackToAppointment, 1, 9);
		goBackToAppointment.setOnAction(e -> window.close());

		//Add everything to grid
		grid.getChildren().addAll(nameLabel,dateLabel, typeLabel, phoneLabel, emailLabel, userInput, dateInput,phoneInput, emailInput,typeInput,  loginButton , goBackToAppointment);

		Scene scene = new Scene(grid, 400, 400);
		window.setScene(scene);

		window.showAndWait();
	}
	public static boolean isInt(TextField input, String message ) {

		try {
			@SuppressWarnings("unused")
int ID = Integer.parseInt(message);
			return true;
		} catch (NumberFormatException e) {

			return false;
		}

	}
	public static boolean isValidEmailAddress(String bookingEmail) {

        String[] email = bookingEmail.split(""); // get individual characters of email address;
        if (email.length <= 5) { // check if length of email address is less than 3
            return false; // if lenght is less  than three return false
        }
        // checking if "@" is present
        boolean check = false;
        for (String i : email) {
            if (i.equals("@")) {
                check = true;
            }
        }
        if (!check) {
            return false;
        }
        //check is starting and ending cahracters of email is "." or "@"
        if ((email[0].equals("@")) || (email[email.length - 1].equals("@")) || (email[0].equals(".")) || email[email.length - 1].equals(".")) {
            // System.out.println("1");
            return false; // if engine characters is "." or "@" return false
        }
        // get the last four characters of the email address.
        String last4char = bookingEmail.substring(email.length - 4);
        // System.out.println(last4char);
        if (!last4char.equals(".com")) { // check if last foir characters of email address is ".com"
            //System.out.println("2");
            return false; // if not return false;
        }
        // check if the  fouth last character of email address is @ examole adawe@.com
        if (email[email.length - 5].equals("@")) {
            //System.out.println("3");
            return false;
        }

        return true;  // if all conditions are satisfied return true;
    }

    public static boolean isPasswordValid(String Password) {
        //  System.out.println("" + Password);
        boolean check = false;
        char[] pass = Password.toCharArray();

        // checking if the length of password is greater than 5
        if (pass.length < 5) {
            return false;
        }
        // System.out.println("lngth = " + pass.length);

        // checking if there are upper case letters in the password
        for (char i : pass) {

            // System.out.println("" + i + " ascii" + (int) i);
            if ((i >= 65 && i <= 90)) {
                check = true;
                break;
            }
        }
        //  System.out.println("" + check);
        if (!check) {
            // System.out.println("if there are no upper case letters return false");
            return false; // if there are no upper case letters return false
        }

        // checking if there are lower case letters in the password
        check = false;
        for (char i : pass) {

            if ((i >= 97 && i <= 122)) {
                check = true;
                break;
            }
        }
        if (!check) {
            // System.out.println("there are no lower case letters return false");
            return false; // if there are no lower case letters return false
        }

        check = false;
        // checking for special characters in password 
        for (char i : pass) {

            if ((i >= 33 && i <= 46) || (i >= 58 && i <= 64)) {
                check = true;
                break;
            }
        }
        if (!check) {
            //System.out.println(" if there are no special characters return false");
            return false; // if there are no special characters return false;
        }

        // checking if there are numerical characters in the password
        check = false;

        for (char i : pass) {

            if (i >= 48 && i <= 57) {
                check = true;
                break;
            }
        }
        if (!check) {
            //  System.out.println(" therea are no numerical characters in the password return false");
            return false; // if therea are no numerical characters in the password return false;
        }

        return true; // if there are lower case ,upper case,numerical,special characters, 
        //and password length is greater  5 return true
    }

    public boolean isPhoneNumberValid(String bookingPhone) {
        char[] UserId = bookingPhone.toCharArray();
        // check if user id is of length 10
        if (UserId.length != 10) {
            return false;
        } else {
            for (char i : UserId) {
                if (!(i >= 48 && i <= 57)) // Check if all the character in user name are nnumericals.
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUserIdValid(String custID) {
        char[] UserId = custID.toCharArray();
        // check if user id is of length 10
        if (UserId.length != 10) {
            return false;
        } else {
            for (char i : UserId) {
                if (!(i >= 48 && i <= 57)) // Check if all the character in user name are nnumericals.
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isDateValid(String bookingDate ) {

        // check if the length of dat is 10 (dd/mm/yyyy)
        if (bookingDate.length() != 10) {
            return false;
        } else {
            String[] div = bookingDate.split("/");
            if ((div.length) == 3) {
                try {
                    int date = Integer.parseInt(div[0]);
                    int month = Integer.parseInt(div[1]);
                    // int year = Integer.parseInt(div[2]);
                    if (!(date >= 1 && date <= 31) || !(month >= 1 && month <= 12)) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isUserInputValid(String userInput) {
        char[] input = userInput.toCharArray();

        for (char i : input) {
            if (!(i >= 48 && i <= 57)) {
                return false;
            }
        }
        return true;
    }



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
}
