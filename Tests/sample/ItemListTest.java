package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.junit.Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ItemListTest {


    @Test
    public void newCartShouldHaveZero(){

        ItemList cart = new ItemList();
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