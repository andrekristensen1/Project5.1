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

/**
 * Controller til at Login funktion
 */
public class LoginController implements Initializable {

    @FXML
    TextField username;
    @FXML
    PasswordField password;

    /**
     * Metode til handling ved tryk på loginknappen.
     *
     * @param event tryk på loginknap
     * @throws IOException
     */
    @FXML
    public void login(ActionEvent event) throws IOException {

        if (username.getText().equals("admin") && password.getText().equals("admin")) {

            System.out.println("Log in");
            Parent startPageParent = FXMLLoader.load(getClass().getResource("start.fxml"));                       //Opretter startPageParent og henter start-siden, som der skal skiftes til
            Scene startPageScene = new Scene(startPageParent);                                                          //Skaber en ny scene
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();                                //Henter information fra vores Stage til den nye Scene
            app_stage.setScene(startPageScene);                                                                         //Viser den nye scene som er start-siden
            app_stage.show();

        }

    }

    /**
     * Metode der skal håndtere registrering af ny bruger. ikke færdig
     *
     * @param event
     */
    @FXML
    public void signUp(ActionEvent event) {

        System.out.println("Sign up");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}