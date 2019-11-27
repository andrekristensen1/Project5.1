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
    Button addBtn;

    @FXML
    Button removeBtn;

    @FXML
    ListView shoppingCartView;

    @FXML
    ListView itemDisplay;

    @FXML
    public void searchForItem(ActionEvent event) throws SQLException {

        displayItems(ShopsItemList.getItems(itemSearch), itemDisplay);


    }

    public void itemClicked(MouseEvent mouseEvent) {
        //customerShoppingCart.add(itemDisplay.getSelectionModel().getSelectedItem());
        //shoppingCartView.setItems(FXCollections.observableArrayList(customerShoppingCart.add(itemDisplay.getSelectionModel().getSelectedItem())));

        System.out.println(customerShoppingCart.items.size());

        customerShoppingCart.items.add(itemDisplay.getSelectionModel().getSelectedItem());
        customerShoppingCart.displayShoppingcart(shoppingCartView);





    }
}
