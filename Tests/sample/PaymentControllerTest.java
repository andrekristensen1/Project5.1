package sample;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.*;
public class PaymentControllerTest extends Payment {


    Model m = Model.getInstance();
    Connection conn;
    Payment customerPayment = new Payment();


    {
        try {
            conn = m.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void finalPayBtn() throws SQLException {

        float newStoreBanlance = 10100;
        customerPayment.executeUpdateBalance(newStoreBanlance, 2);
        float storeResult = retrieveBalance(2);
        assertEquals(storeResult, newStoreBanlance, 0);


        float newCustomerBalance = 10100;
        customerPayment.executeUpdateBalance(newCustomerBalance, 2);
        float customerResult = retrieveBalance(2);
        assertEquals(customerResult, newCustomerBalance, 0);


    }
}