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

    /**
     * Henter balancenn fra en given profil og returnerer et ResultSet med denne information
     * @param profileID profilen hvis balance skal findes
     * @param conn forbindelse til databasen
     * @return res
     * @throws SQLException
     */
   public ResultSet getBalanceStatement(int profileID, Connection conn) throws SQLException{
        String query = " select BankAccount.Balance AS Balance from BankAccount" +                                      //Find balancen hvor profilID er lige med param
                " Where ProfileID = '" + profileID + "'";

        Statement stmt = null;                                                                                          //Kreerer et statement
        ResultSet res = null;                                                                                           //Kreerer et ResultSet
        stmt = conn.createStatement();                                                                                  //Sætter vores Statement til at være lig med forbindelsen til databasen
        res = stmt.executeQuery(query);                                                                                 //Sætter vores ResultSet lig med resultatet af den eksekverede query
        return res;                                                                                                     //Returnerer result
    }

    /**
     * Indsætter en ny balance i en given profil
     * @param conn forbindelse til databasen
     * @param newBalance den nye balance
     * @param profileID profilID
     */
   public void updateBalance(Connection conn, Float newBalance, int profileID) {
    try{
        String updateSql = "UPDATE BankAccount SET Balance = ? " + "WHERE ProfileID = ? " ;                             //Updaterer balancen til newBalance, hvor profilID er lig med profileID fra param
        PreparedStatement stmt = conn.prepareStatement(updateSql);                                                      //Kreerer et PreparedStatement
        stmt.setFloat(1, newBalance);                                                                    //Sætter balance i vores query til at være lig med newBalance fra param
        stmt.setInt(2, profileID);                                                                       //Sætter ProfileID i vores query til at være lig ProfileID fra param
         //int rowAffected = stmt.executeUpdate();
        int result = stmt.executeUpdate();                                                                              //Kreerer en int med mængden af påvirkede rows i databasen og udfører opdaterinngenn
        System.out.println("Update Succesful:" + result);                                                               //Printer påvirkede rows i GUI
    } catch (SQLException e) {
        e.printStackTrace();                                                                                            //Printer stacktrace på SQLException hvis metoden fejler
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