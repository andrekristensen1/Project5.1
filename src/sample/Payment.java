package sample;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    //Dette er nyt
    public void updateBalance(int index1, Float newBalance, int index2, int profileID) throws SQLException {


                 PreparedStatement update = m.retriever.updateBalanceProfile(m.getConnection());
                 update.setFloat(index1, newBalance);
                 update.setInt(index2, profileID);
                 update.executeUpdate();
    }
}
