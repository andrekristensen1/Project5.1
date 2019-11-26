package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    //Model m = Model.getInstance();
  //  Connection conn;

    @FXML
    TextField username;
    @FXML
    PasswordField password;

    //Metode til handling ved tryk på login knappen
    @FXML
    public void login(ActionEvent event) throws IOException {

        if (username.getText().equals("admin") && password.getText().equals("admin")) {

            System.out.println("Log in");
            //Opretter startPageParent og henter start-siden, som der skal skiftes til
            Parent startPageParent = FXMLLoader.load(getClass().getResource("start.fxml"));
            //Skaber en ny scene
            Scene startPageScene = new Scene(startPageParent);
            //Henter information fra vores Stage til den nye Scene
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //Viser den nye scene som er start-siden
            app_stage.setScene(startPageScene);
            app_stage.show();

        }

    }


    @FXML
    public void signUp(ActionEvent event) {

        System.out.println("Sign up");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}