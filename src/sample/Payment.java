package sample;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment {

    Model m = Model.getInstance();

    /**
     * Finder en float fra vores Label subTotal
     *
     * @param subTotal Label
     * @return
     */

    public float returnSubTotal(Label subTotal){
       String value = subTotal.getText();                                                                               //En String der indeholder information fra vores Label
       float finalValue = Float.valueOf(value.replaceAll("[^\\d.]", " "));                           //Erstatter alle non-numeriske karakterer med ingenting og lægger værdien i en float
       return finalValue;                                                                                               // Returnerer værdien
    }

    public Float retrieveBalance (int profileID) throws SQLException {
        ResultSet BalanceResultSet = m.retriever.getBalanceStatement(profileID, m.getConnection());                     //Kører getBalanceStatement fra vores JDBCConnnection, med profileID som parameter og får et Resultset med balance fra en profil
        Float Balance = BalanceResultSet.getFloat(1);                                                       //Finder balancen i ResultSettet og lægger den i en float
        m.closeConnection();                                                                                            //Lukker connection til databasen
        BalanceResultSet.close();                                                                                       //Lukker ResultSet

        return Balance;                                                                                                 //Returnere Balancen som Float
    }

    public Float calculateNewBalanceCustomer(Float balance, Float subTotal){
        Float newBalance = balance - subTotal;                                                                          //Fratrækker en Float fra en anden
        return newBalance;                                                                                              //Returnerer resultatet af regnestykket
    }

    public Float calculateNewBalanceStore(Float balance, Float subTotal){
        Float newBalance = balance + subTotal;                                                                          //Lægger en Float til en anden
        return newBalance;                                                                                              //Returnerer resultatet af regnestykket
    }

    public void executeUpdateBalance(Float newBalance, int profileID) throws SQLException {
        m.retriever.updateBalance(m.getConnection(), newBalance, profileID);                                            //Kører updateBalance metoden fra vores JDBCConnection
        m.closeConnection();                                                                                            //Lukker connection til databasen
        
    }

}
