package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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

        displayItems(ShopsItemList.getItems(itemSearch), itemDisplay);


    }

    @FXML
    public void itemClickedAdd(MouseEvent mouseEvent) {
        //If statement håndterer at null ikke kan tilføjes til shoppingcart
        if (itemDisplay.getSelectionModel().getSelectedItem() != null){
            customerShoppingCart.items.add(itemDisplay.getSelectionModel().getSelectedItem());
            customerShoppingCart.updateShoppingcart(shoppingCartView, subTotal, listSize);
           }
    }

    @FXML
    public void ItemClickedRemove(MouseEvent mouseEvent) {
        customerShoppingCart.items.remove(shoppingCartView.getSelectionModel().getSelectedItem());
        customerShoppingCart.updateShoppingcart(shoppingCartView, subTotal, listSize);
    }
}
