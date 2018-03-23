package application;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class MainMain extends Application {

    Stage window;
    Scene scene1, scene2, salesScene, servicesScene, appointmentScene;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //labels
        Label label1 = new Label("Welcome to N.B.T.K auto!");
        Label servicesLabel = new Label("Welcome to services");
        Label salesLabel = new Label("Welcome to sales");
        Label appointmentLabel = new Label("Welcome to the appoinment centre");
        //buttons
        //Button button1 = new Button("Go to scene 2");
        Button serviceButton = new Button("Services ");
        Button salesButton = new Button("Sales");
        Button appointmentButton = new Button ("Appointments");
       //button actions
       // button1.setOnAction(e -> window.setScene(scene2));
        serviceButton.setOnAction(e -> window.setScene(servicesScene)); //services button
        salesButton.setOnAction(e -> window.setScene(salesScene));
        appointmentButton.setOnAction(e -> window.setScene(appointmentScene));

        //Layout 1 - children laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,  salesButton, serviceButton, appointmentButton);
        layout1.setAlignment(Pos.CENTER);
        scene1 = new Scene(layout1, 400, 400);


        //Button 2
        Button button2 = new Button(" GO BACK TO DEALER ");

        button2.setOnAction(e -> window.setScene(scene1));

//        //Layout 2
//        StackPane layout2 = new StackPane();
//        layout2.setAlignment(Pos.CENTER);
//        layout2.getChildren().addAll( button2);
//        scene2 = new Scene(layout2, 600, 300);
        //Services
         VBox servicesLayout = new VBox (20);
         Button addCarButton = new Button ("ADD CAR");
         addCarButton.setOnAction(e -> ServicesWindow.addCar("Services", "This is the add car window"));
         Button removeCarButton = new Button("REMOVE CAR");
         removeCarButton.setOnAction(e -> ServicesWindow.removeCar("Services","This is the romve car window"));
         Button editCarButton = new Button ("EDIT CAR");
         editCarButton.setOnAction(e -> ServicesWindow.editCar("Services", "This is the edit car window"));
         Button goBackButton = new Button ("GO BACK TO DEALER");
         goBackButton.setOnAction(e -> window.setScene(scene1));//I thought about having just one go back but it didnt work
         servicesLayout.getChildren().addAll(servicesLabel, addCarButton, removeCarButton, editCarButton, goBackButton);
         servicesLayout.setAlignment(Pos. CENTER);
         servicesScene = new Scene(servicesLayout, 400, 400);



         //sales
        VBox salesLayout = new VBox(20);
        Button checkInventoryButton= new Button ("CHECK CAR INVENTORY");
        checkInventoryButton.setOnAction(e -> SalesWindow.InventoryCheck("Sales window","CAR INVENTORY"));
        Button goBackButton2 = new Button ("GO BACK TO DEALER");
        goBackButton2.setOnAction(e -> window.setScene(scene1));
        salesLayout.getChildren().addAll(salesLabel, checkInventoryButton, goBackButton2);
        salesLayout.setAlignment(Pos.CENTER);
        salesScene = new Scene(salesLayout, 400, 400);



        //appontments
        VBox appointmentLayout = new VBox (20);
        Button addbookingButton = new Button ("ADD BOOKING");
        addbookingButton.setOnAction(e -> AppointmentWindow.addAppointment("Appointment", "Please add an appointment"));
        Button removeBookingButton = new Button("REMOVE BOOKING");
        removeBookingButton.setOnAction(e -> AppointmentWindow.removeAppointment("Appointment", "Remove and appointment"));
        Button editBookingButton = new Button ("EDIT BOOKING");
        editBookingButton.setOnAction(e -> AppointmentWindow.editAppointment("Appointment","Edit an apointment"));
        Button searchBookingButton = new Button ("SEARCH BOOKING");
        searchBookingButton.setOnAction(e -> AppointmentWindow.searchAppointment("Appointment", "Search for a appointment"));
        Button goBackButton3 = new Button ("GO BACK TO DEALER");
        goBackButton3.setOnAction(e -> window.setScene(scene1));
        appointmentLayout.getChildren().addAll(appointmentLabel, addbookingButton, removeBookingButton, editBookingButton, searchBookingButton, goBackButton3);
        appointmentLayout.setAlignment(Pos.CENTER);
        appointmentScene = new Scene(appointmentLayout, 400, 400);

        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Title Here");
        window.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
