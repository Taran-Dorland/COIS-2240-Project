package sample;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ServicesWindow {

    public static void addCar(String title, String message) { //should probably not make it static for security

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
        Label carLabel = new Label("Car ID:");
        GridPane.setConstraints(carLabel, 0, 0);

        Label numLabel = new Label ("Car number: ");
        GridPane.setConstraints(numLabel, 0, 1);

        Label typeLabel = new Label ("Car type: ");
        GridPane.setConstraints(typeLabel, 0, 2);

        Label ownerLabel = new Label ("Owner name: ");
        GridPane.setConstraints(ownerLabel, 0, 3);


        //Name Input
        TextField carInput = new TextField();
        carInput.setPromptText("xxxxxx-xxxxx");
        GridPane.setConstraints(carInput, 1, 1);

        //user Input
        TextField numInput = new TextField();
        numInput.setPromptText("Numbers only");
        GridPane.setConstraints(numInput, 1, 0);

        //Password Input
        TextField typeInput = new TextField();
        typeInput.setPromptText("booking type");
        GridPane.setConstraints(typeInput, 1, 2);

        //Password Input
        TextField ownerInput = new TextField();
      ownerInput.setPromptText("John Smith");
        GridPane.setConstraints(ownerInput, 1, 3);



        //Login
        Button loginButton = new Button("ADD information");
        GridPane.setConstraints(loginButton, 1, 8);

        Button goBackToservices = new Button("GO BACK to SALES");
        GridPane.setConstraints(goBackToservices, 1, 9);
        goBackToservices.setOnAction(e -> window.close());


        //Add everything to grid
        grid.getChildren().addAll(numLabel,carLabel, typeLabel, ownerLabel,  numInput, ownerInput, carInput, typeInput,  loginButton, goBackToservices);

        Scene scene = new Scene(grid, 400, 400);
        window.setScene(scene);

        window.showAndWait();

    }

    public static void removeCar(String title, String message) { //sorry i have no clue how to do this
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //this forces the user to complete the window,so they cant go back
        window.setTitle(title);
        window.setMinHeight(400);

        Label servicesLabel = new Label();
        servicesLabel.setText(message);

        VBox serviceLay = new VBox(20);
        serviceLay.getChildren().addAll(servicesLabel);

        Scene serviceScene = new Scene(serviceLay);
        window.setScene(serviceScene);
        window.showAndWait();

    }

    public static void editCar(String title, String message) {


    Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //this forces the user to complete the window,so they cant go back
        window.setTitle(title);
        window.setMinHeight(400);
        window.setMinWidth(400);

        Label servicesLabel = new Label();
        servicesLabel.setText(message);


        VBox serviceLay = new VBox(20);
        serviceLay.getChildren().addAll(servicesLabel);
        Scene serviceScene = new Scene(serviceLay);
        window.setScene(serviceScene);
        window.showAndWait();
}
}
