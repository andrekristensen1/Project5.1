package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch(args);
        
        /*Model m = Model.getInstance();
        Connection conn = null;


        
        
        try {

            conn = m.getConnection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Which item do you want to get?");
            String ItemScanner = scanner.next();
            PreparedStatement pstmt = m.retriever.selectpreparedstatement(conn);
            pstmt.setString(1, ItemScanner);
            ResultSet res = m.retriever.plainstatement(ItemScanner, conn);
            System.out.println(m.retriever.presentItem(res));
            pstmt.close();

        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
        
    }

}
