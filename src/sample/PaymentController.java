package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class PaymentController extends Payment {



    StartController startController = new StartController();
    ItemList customerShoppingcart = new ItemList();
    Payment customerPayment = new Payment();



    @FXML
    Label subTotal;

    @FXML
    ListView finalShoppingcart;



    @FXML
    public void startReturn(ActionEvent event) throws IOException {
        AnchorPane newAnchor = FXMLLoader.load(getClass().getResource("start.fxml"));                             //Opretter startPageParent og henter start-siden, som der skal skiftes til
        Scene startPageScene1 = new Scene(newAnchor);                                                                   //Skaber en ny scene
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();                                    //Henter information fra vores Stage til den nye Scene
        app_stage.setScene(startPageScene1);                                                                            //Viser den nye scene som er start-siden
        app_stage.show();
    }

    @FXML
    public void finalPayBtn(ActionEvent event) {

    }

    public void getShoppingcartInfo(ItemList shoppingCart){

        subTotal.setText("Sum total: " + String.valueOf(shoppingCart.getSumTotal()));
        shoppingCart.displayShoppingcart(finalShoppingcart);
    }













}
