package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.sql.*;
import java.util.ArrayList;

public class JDBCConnection {


    //URL'en til når vi skal bruge den
    //String url = "jdbc:sqlite:/Users/bruger/Desktop/RUC/5. semester/Software Development/Plan&Buy.db";

    private String message;

    /**
     * Kalder en connection metode som returnerer et connection objekt.
     *          Dette objekt skaber en connection til vores URL
     * @param url
     * @return
     * @throws SQLException
     */

    public Connection connect(String url)
            throws SQLException {

        return DriverManager.getConnection(url);
    }

    /**
     * Forhindrer SQL injections
     * @param conn
     * @return
     * @throws SQLException
     */

    public PreparedStatement selectpreparedstatement(Connection conn)
            throws SQLException {
        String query = " select Item.ItemName AS ItemName, item.ItemBrand AS ItemBrand, Item.price AS price from Item" +
                " Where ItemType = ? ";
        PreparedStatement selectpstmt = null;
        selectpstmt = conn.prepareStatement(query);
        return selectpstmt;
    }

    /**
     * Query der specificerer hvor dataen skal hentes i databasen
     * @param ItemType
     * @param conn
     * @return
     * @throws SQLException
     */



    //Søgealgoritme her!
    public ResultSet plainstatement(String ItemType, Connection conn)
            throws SQLException {
        String query = " select Item.ItemName AS ItemName, item.ItemBrand AS ItemBrand, Item.price AS price from Item" +
                       " Where ItemType = '" + ItemType + "'";
        Statement stmt = null;
        ResultSet res = null;
        stmt = conn.createStatement();
        res = stmt.executeQuery(query);
        return res;
    }

    /**
     * Metode der præsenterer den indhentede data fra databasen
     * @param res
     * @return
     * @throws SQLException
     */
    public ArrayList presentItem(ResultSet res)
            throws SQLException {
        ArrayList<String> itemList = new ArrayList<>();

        if (res == null)
            System.out.println("No records");

        while (res != null & res.next()) {

            String foundItem = res.getString("ItemName");
            String foundPrice = res.getString("Price");
            String foundBrand = res.getString("ItemBrand");
            message = (foundBrand + " " + foundItem + ": " + foundPrice);
            itemList.add(message);



        }
        return itemList;
    }

    public float findItemPrice(String chosenItem){
        float itemPrice =0;
        //Fix nedenstående hardcode
        String itemPriceString = chosenItem.substring(chosenItem.length()-5);
        itemPrice = Float.parseFloat(itemPriceString);
        return itemPrice;
    }

}