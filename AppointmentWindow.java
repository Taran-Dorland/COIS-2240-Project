package sample;

import javafx.application.*;
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

//        //phone Input
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

            isInt(userInput, userInput.getText());
            //validateEmail(emailInout, emailInput.getText());
            //IsPhone(phoneInput, phoneInput.getText());
            //isDate(dateInput, dateInput.getText());;


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
}
