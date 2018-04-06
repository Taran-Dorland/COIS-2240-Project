package application;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

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

@SuppressWarnings("unused")
public class FormValidation {

	public static boolean textFieldNotEmpty(TextField i) {
		boolean r = false;
		if(i.getText() !=null && !i.getText().isEmpty()) {
			r=true;
		}
		return r;
	}
	
	public static boolean textFieldNotEmpty(TextField i, Label l, String sValidationText) {
		boolean r = true;
		String c = null;
		if(!textFieldNotEmpty(i)) {
			r = false;
			c = sValidationText;
		}
		l.setText(c);
		return r;
	}
}
	

