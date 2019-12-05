package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.sql.*;
import java.util.ArrayList;

/**
 * En klasse til at arbejde med databasen og køre querys
 */

public class JDBCConnection {

    private String message;

    /**
     * Kalder en connection metode som returnerer et connection objekt.
     * Dette objekt skaber en connection til vores URL
     *
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
     *
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
     *
     * @param ItemType
     * @param conn
     * @return
     * @throws SQLException
     */


    //Søgealgoritme her!
    public ResultSet plainstatement(String ItemType, Connection conn)
            throws SQLException {
        String query = " select Item.ItemName AS ItemName, item.ItemBrand AS ItemBrand, Item.price AS price, Item.ItemQuantity AS Quantity from Item" +
                " Where ItemType = '" + ItemType + "'";
        Statement stmt = null;
        ResultSet res = null;
        stmt = conn.createStatement();
        res = stmt.executeQuery(query);
        return res;
    }

   public ResultSet getBalanceStatement(int profileID, Connection conn) throws SQLException{
        String query = " select BankAccount.Balance AS Balance from BankAccount" +
                " Where ProfileID = '" + profileID + "'";

        Statement stmt = null;
        ResultSet res = null;
        stmt = conn.createStatement();
        res = stmt.executeQuery(query);
        return res;
    }


   public void updateBalance(Connection conn, Float newBalance, int profileID) {


    try{
        String updateSql = "UPDATE BankAccount SET Balance = ? " + "WHERE ProfileID = ? " ;
        PreparedStatement stmt = conn.prepareStatement(updateSql);
        stmt.setFloat(1, newBalance);
        stmt.setInt(2, profileID);
         //int rowAffected = stmt.executeUpdate();
        int result = stmt.executeUpdate();
        System.out.println("Update Succesful:" + result);
    } catch (SQLException e) {
        e.printStackTrace();
    }


   }


    /**
     * Metode der præsenterer den indhentede data fra databasen
     *
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
            message = (foundItem + " " + foundBrand + ": " + foundPrice + " kr");
            itemList.add(message);
        }
        return itemList;
    }
   
}