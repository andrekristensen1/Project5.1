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
import java.sql.SQLException;
import java.util.ArrayList;


public class PaymentController extends Payment {



    StartController startController = new StartController();
    ItemList customerShoppingcart = new ItemList();
    Payment customerPayment = new Payment();

    @FXML
    Label subTotal;

    @FXML
    ListView finalShoppingcart;

    /**
     * Returnerer til indkøbssiden
     * @param event når der klikkes på <-- knappen
     * @throws IOException
     */

    @FXML
    public void startReturn(ActionEvent event) throws IOException {
        AnchorPane newAnchor = FXMLLoader.load(getClass().getResource("start.fxml"));                             //Opretter startPageParent og henter start-siden, som der skal skiftes til
        Scene startPageScene1 = new Scene(newAnchor);                                                                   //Skaber en ny scene
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();                                    //Henter information fra vores Stage til den nye Scene
        app_stage.setScene(startPageScene1);                                                                            //Viser den nye scene som er start-siden
        app_stage.show();
    }

    /**
     * Fratrækker prisen fra brugerens saldo, og lægger prisen til butikkens saldo
     * @param event når der trykkes på færdiggør betaling
     * @throws SQLException
     */

    @FXML
    public void finalPayBtn(ActionEvent event) throws SQLException, IOException {
        Float updatedBalanceCustomer = customerPayment.calculateNewBalanceCustomer                                      //Kreerer en Float som er kundens nye balance vha calculateNewBalanceCustomer og retrieveBalance
                (customerPayment.retrieveBalance(1), customerPayment.returnSubTotal(subTotal));
        Float updatedBalanceStore = customerPayment.calculateNewBalanceStore                                            //Kreerer en Float som er Butikkens nye balance vha calculateNewBalanceStore og retrieveBalance
                (customerPayment.retrieveBalance(2), customerPayment.returnSubTotal(subTotal));
        System.out.println(updatedBalanceCustomer);                                                                     //Printer den nye balance i GUI
        System.out.println(updatedBalanceStore);                                                                        //Printer den nye balance i GUI
        customerPayment.executeUpdateBalance(updatedBalanceCustomer, 1);                                       //Kører executeUpdateBalance med den nye balance for kunden hvor profilID er 1
        customerPayment.executeUpdateBalance(updatedBalanceStore, 2);                                          //Kører executeUpdateBalance med den nye balance for butikken hvor profilID er 2
        AnchorPane newAnchor = FXMLLoader.load(getClass().getResource("Receipt.fxml"));                          //Opretter startPageParent og henter start-siden, som der skal skiftes til
        Scene startPageScene1 = new Scene(newAnchor);                                                                   //Skaber en ny scene
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();                                    //Henter information fra vores Stage til den nye Scene
        app_stage.setScene(startPageScene1);                                                                            //Viser den nye scene som er start-siden
        app_stage.show();


    }

    /**
     * Viser indkøbsliste og subtotal i GUI
     * @param shoppingCart
     */

    public void getShoppingcartInfo(ItemList shoppingCart){
        subTotal.setText("Sum total: " + String.valueOf(shoppingCart.getSumTotal()));                                   //Sætter subTotal Label til at være prisen på indkøbet
        shoppingCart.displayShoppingcart(finalShoppingcart);                                                            //Viser indkøbslisten i ListView
    }














}
