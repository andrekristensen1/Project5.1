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

    /**
     * Metode der kører getItems fra vores ItemList klasse og viser resultatet af en søgning
     * @param event når der klikkes på Søg knappen
     * @throws SQLException
     */
    @FXML
    public void searchForItem(ActionEvent event) throws SQLException {
        ShopsItemList.displayItems(ShopsItemList.getItems(itemSearch), itemDisplay);                                    //ListView til venstre bliver fyldt med resultatet af søgeord
    }

    /**
     * Metode der tilføjer et element til kunndens indkøbsliste, og opdatere indkøbslisten
     * @param mouseEvent Når der klikkes på et element i Listviewet
     */

    @FXML
    public void itemClickedAdd(MouseEvent mouseEvent) {
        if (itemDisplay.getSelectionModel().getSelectedItem() != null){                                                 //If statement håndterer at null ikke kan tilføjes til shoppingcart
            customerShoppingCart.items.add(itemDisplay.getSelectionModel().getSelectedItem());                          //Når der trykkes på et element i ListViewet til venste tilføjes det til indkøbslisten
            customerShoppingCart.updateShoppingcart(shoppingCartView, subTotal, listSize);                              //Opdaterer indkøbsliste, subtotal og størrelsen på indkøbslisten
           }                                                                   
    }

    /**
     * Når der klikkes på noget i indkøbslisten skal det fjernes, og derefter skal
     * indkøblisten opdateres
     * @param mouseEvent når der klikkes på et element i ListViewet til venstre
     */

    @FXML
    public void ItemClickedRemove(MouseEvent mouseEvent) {
        customerShoppingCart.items.remove(shoppingCartView.getSelectionModel().getSelectedItem());                      //Fjerner det valgte element fra ListViewet til venste
        customerShoppingCart.updateShoppingcart(shoppingCartView, subTotal, listSize);                                  //Opdaterer indkøbsliste, subtotal og størrelsen på indkøbslisten
    }

    /**
     * Metode der åbner betalingssiden.
     * @param event når der trykkes på betal knappen
     * @throws IOException
     * @throws SQLException
     */

    @FXML
    public void pay(ActionEvent event) throws IOException, SQLException {

        if (customerShoppingCart.items.size() != 0) {                                                                   //Hvis indkøbslisten ikke er tom
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Payment.fxml"));
            AnchorPane newAnchor = loader.load();
            Scene payScene = new Scene(newAnchor);
            PaymentController controller = loader.getController();
            controller.getShoppingcartInfo(customerShoppingCart);
            m.closeConnection();                                                                                        //Lukker forbindelsen til databasen
            m.clear();                                                                                                  //Rydder vores Singleton, så der kan kreeres en ny
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();                                //Åbner den nye scene
            app_stage.setScene(payScene);
            app_stage.show();


        }
    }


}
