package sample;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment {

    Model m = Model.getInstance();



    public float returnSubTotal(Label subTotal){
       String value = subTotal.getText();
       float finalValue = Float.valueOf(value.replaceAll("[^\\d.]", " "));
       return finalValue;
    }

    public Float retrieveBalance (int profileID) throws SQLException {
        ResultSet BalanceResultSet = m.retriever.getBalanceStatement(profileID, m.getConnection());
        Float Balance = BalanceResultSet.getFloat(1);
        //den er ny nedenfor
        m.closeConnection();
        BalanceResultSet.close();

        return Balance;
    }

    public Float calculateNewBalanceCustomer(Float balance, Float subTotal){
        Float newBalance = balance - subTotal;
        return newBalance;
    }

    public Float calculateNewBalanceStore(Float balance, Float subTotal){
        Float newBalance = balance + subTotal;
        return newBalance;
    }

    public void executeUpdateBalance(Float newBalance, int profileID) throws SQLException {
        m.retriever.updateBalance(m.getConnection(), newBalance, profileID);
        m.closeConnection();
        
    }

}
