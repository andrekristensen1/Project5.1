package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

public class StartController extends ItemList  {

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
    public void searchForItem(ActionEvent event) throws SQLException {

        displayItems(ShopsItemList.getItems(itemSearch), itemDisplay);


    }

    @FXML
    public void itemClickedAdd(MouseEvent mouseEvent) {
        //customerShoppingCart.add(itemDisplay.getSelectionModel().getSelectedItem());
        //shoppingCartView.setItems(FXCollections.observableArrayList(customerShoppingCart.add(itemDisplay.getSelectionModel().getSelectedItem())));

        customerShoppingCart.items.add(itemDisplay.getSelectionModel().getSelectedItem());
        customerShoppingCart.displayShoppingcart(shoppingCartView);

        System.out.println(customerShoppingCart.items.size());
        //System.out.println(customerShoppingCart.displayItemPrice(itemDisplay.getSelectionModel().getSelectedItem().toString()));
        System.out.println(customerShoppingCart.getSumTotal());
        subTotal.setText("Pris: " + String.valueOf(customerShoppingCart.getSumTotal()) + " kr. ");


    }
    @FXML
    public void ItemClickedRemove(MouseEvent mouseEvent) {

        customerShoppingCart.items.remove(itemDisplay.getSelectionModel().getSelectedItem());
        customerShoppingCart.displayShoppingcart(shoppingCartView);

        System.out.println(customerShoppingCart.items.size());
        System.out.println(customerShoppingCart.getSumTotal());
        subTotal.setText("Pris: " + String.valueOf(customerShoppingCart.getSumTotal()) + " kr. ");

    }
}
