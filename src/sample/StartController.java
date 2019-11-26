package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class StartController extends Shoppingcart {

    Shoppingcart customerShoppingCart = new Shoppingcart();

    @FXML
    TextField itemSearch;

    @FXML
    Button searchBtn;

    @FXML
    Button addBtn;

    @FXML
    Button removeBtn;

    @FXML
    TextArea listDisplay;

    @FXML
    ListView itemDisplay;

    @FXML
    public void searchForItem(ActionEvent event) throws SQLException {
        displayItems(customerShoppingCart.getItems(itemSearch), itemDisplay);

    }

    public void itemClicked(MouseEvent mouseEvent) {
    }
}
