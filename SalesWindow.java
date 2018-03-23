package sample;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SalesWindow {

    public static void InventoryCheck(String title, String message) { //should probably not make it static for security

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
