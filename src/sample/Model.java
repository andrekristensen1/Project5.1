package sample;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * En singleton klasse til vores JDBC objekt, så vi kun har en forbindelse til databasen.
 */

class Model {

    public JDBCConnection retriever;

    private Model() {                                                                                                    //Constructor
        retriever = new JDBCConnection();
    }

    static Model inst;

    /**
     * Metode der sikrer sig at der kun kan være et objekt af denne klasse.
     *
     * @return Model
     */

    static Model getInstance() {
        if (inst == null) {
            inst = new Model();
        }
        return inst;
    }

    /**
     * Metode der opretter forbindelse til en database i den givne url
     *
     * @return conn som er Connection objektet der forbinder til databasen
     * @throws SQLException
     */

    public Connection getConnection() throws SQLException {

        Connection conn = null;
        String url = "jdbc:sqlite:/Users/williamkilschowpetersen/Documents/5. Semester RUC/Software Development/databaser/PlanAndBuy.db";
        conn = this.retriever.connect(url);
        return conn;
    }

}