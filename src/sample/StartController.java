package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class StartController extends ItemList {

    ItemList customerShoppingCart = new ItemList();
    ItemList ShopsItemList = new ItemList();


    @FXML
    TextField itemSearch;

    @FXML
    Button searchBtn;

    @FXML
    ListView shoppingCartView;

    @FXML
    ListView itemDisplay;

    @FXML
    Label subTotal;

    @FXML
    Label listSize;

    @FXML
    public void searchForItem(ActionEvent event) throws SQLException {
        ShopsItemList.displayItems(ShopsItemList.getItems(itemSearch), itemDisplay);
    }

    @FXML
    public void itemClickedAdd(MouseEvent mouseEvent) {
        if (itemDisplay.getSelectionModel().getSelectedItem() != null){                                                 //If statement håndterer at null ikke kan tilføjes til shoppingcart
            customerShoppingCart.items.add(itemDisplay.getSelectionModel().getSelectedItem());
            customerShoppingCart.updateShoppingcart(shoppingCartView, subTotal, listSize);
           }                                                                   
    }

    @FXML
    public void ItemClickedRemove(MouseEvent mouseEvent) {
        customerShoppingCart.items.remove(shoppingCartView.getSelectionModel().getSelectedItem());
        customerShoppingCart.updateShoppingcart(shoppingCartView, subTotal, listSize);
    }

    @FXML
    public void pay(ActionEvent event) throws IOException, SQLException {

        if (customerShoppingCart.items.size() != 0) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Payment.fxml"));
            AnchorPane newAnchor = loader.load();
            Scene payScene = new Scene(newAnchor);

            PaymentController controller = loader.getController();
            controller.getShoppingcartInfo(customerShoppingCart);
            //De to linjer nedenfor er nye
            m.closeConnection();
            m.clear();
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(payScene);
            app_stage.show();




            /*AnchorPane newAnchor = FXMLLoader.load(getClass().getResource("Payment.fxml"));                       //Opretter startPageParent og henter start-siden, som der skal skiftes til
            Scene startPageScene1 = new Scene(newAnchor);                                                               //Skaber en ny scene
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();                                //Henter information fra vores Stage til den nye Scene
            app_stage.setScene(startPageScene1);                                                                        //Viser den nye scene som er start-siden
            app_stage.show();*/

        }
    }


}
