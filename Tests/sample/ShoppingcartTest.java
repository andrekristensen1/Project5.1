package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.junit.Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ShoppingcartTest {


    @Test
    public void newCartShouldHaveZero(){

        Shoppingcart cart = new Shoppingcart();
        int result = cart.getItemCount();

        assertEquals(0, result);
    }


    @Test
    public void getItems() throws SQLException {

    }

    @Test
    public void displayItems() {
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
    }
}