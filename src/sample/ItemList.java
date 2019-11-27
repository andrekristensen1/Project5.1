package sample;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemList {
    public Object item;
    Model m = Model.getInstance();
    ArrayList<String> items;

    public ItemList(){
        items = new ArrayList<>();
    }



    public ResultSet getItems(TextField searchOutput) throws SQLException {

        //Kør query når der trykkes på søgknappen
        PreparedStatement pstmt = m.retriever.selectpreparedstatement(m.getConnection());
        pstmt.setString(1, searchOutput.getText());
        ResultSet res = m.retriever.plainstatement(searchOutput.getText(), m.getConnection());
        return res;

    }


    public void displayItems(ResultSet res, ListView itemDisplay) throws SQLException {

        //listDisplay.setText(m.retriever.presentItem(res));
        itemDisplay.setItems(FXCollections.observableArrayList(m.retriever.presentItem(res)));

    }


   /* public void add(Object item) {

        this.add(item);


    }

   public void displayShoppingcart(Object item){



   }*/

    public void remove(int index) {


    }

    public int getItemCount() {
        return items.size();
    }

}


