package sample;

import javafx.scene.control.TextField;
import org.junit.Test;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class StartControllerTest extends ItemList {


    Model m = Model.getInstance();
    Connection conn;


    {
        try {
            conn = m.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchForItem() throws SQLException {

        ResultSet expected = m.retriever.plainstatement("Rugbrød", conn);
        ArrayList<String> myTest = m.retriever.presentItem(expected);
        String expextedResult = "Herkules Kohberg: 15.75 kr";
        assertEquals(myTest.get(0), expextedResult);
        System.out.println(myTest.get(0));
        System.out.println(expextedResult);
    }

    @Test
    public void itemClickedAdd() throws SQLException {
        ArrayList<String> customerShoppingcartTest = new ArrayList<>();
        ResultSet expected = m.retriever.plainstatement("Rugbrød", conn);
        ArrayList<String> itemListTest = m.retriever.presentItem(expected);

        customerShoppingcartTest.add(itemListTest.get(0));
        assertEquals(customerShoppingcartTest.get(0), itemListTest.get(0));
        System.out.println(customerShoppingcartTest.get(0));
        System.out.println(itemListTest.get(0));




    }

    @Test
    public void itemClickedRemove() {
    }
}