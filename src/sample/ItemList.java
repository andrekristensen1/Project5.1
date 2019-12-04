package sample;

import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Klasse med forskellige metoder til at styre en liste af Items (del af modellen)
 */
public class ItemList {
    //public Object item;
    Model m = Model.getInstance();
    ArrayList<Object> items;

    /**
     * Constructor som laver en arrayliste
     */
    public ItemList() {
        items = new ArrayList<>();
    }


    /**
     * @param searchOutput input fra brugeren
     * @return res som er et resultset med de varer der matcher brugerens input
     * @throws SQLException
     */
    public ResultSet getItems(TextField searchOutput) throws SQLException {
        PreparedStatement pstmt = m.retriever.selectpreparedstatement(m.getConnection());                               //Kør query når der trykkes på søgknappen
        pstmt.setString(1, searchOutput.getText());
        ResultSet res = m.retriever.plainstatement(searchOutput.getText(), m.getConnection());
        m.closeConnection();
        return res;
    }

    /**
     * Metode der viser de indhentede items i vores GUI
     *
     * @param res         resultset med varer som er hentet fra databasen
     * @param itemDisplay stedet hvor varerne skal vises i GUI
     * @throws SQLException
     */
    public void displayItems(ResultSet res, ListView itemDisplay) throws SQLException {
        itemDisplay.setItems(FXCollections.observableArrayList(m.retriever.presentItem(res)));
    }

    /**
     * Viser vores shoppingcart i GUI
     *
     * @param ShoppingCartDisplay stedet hvor shoppingcart skal vises
     */
    public void displayShoppingcart(ListView ShoppingCartDisplay) {
        ShoppingCartDisplay.setItems(FXCollections.observableList(this.items));
    }



    /*public float displayItemPrice(String chosenItem){

       float itemPrice = 0;
       itemPrice = m.retriever.findItemPrice(chosenItem);

       return itemPrice;

    }*/

    /**
     * Finder totalsummen på en liste af varer
     *
     * @return totalsummen
     */
    public float getSumTotal() {
            float sumTotal = 0;

            for (int i = 0; i < items.size(); i++) {
                sumTotal = sumTotal + this.findItemPrice(items.get(i).toString());
            }
            return sumTotal;
    }

    /**
     * Metode der opdaterer en liste af items. Viser den i GUI, opdaterer samlet pris og antal af items.
     *
     * @param shoppingCartView stedet hvor en liste af items skal vises i GUI
     * @param subTotal         Stedet hvor totalsummen skal vises i GUI
     * @param listSize         Stedet hvor antallet af items skal vises i GUI
     */

    public void updateShoppingcart(ListView shoppingCartView, Label subTotal, Label listSize) {
        this.displayShoppingcart(shoppingCartView);
        subTotal.setText("Pris: " + String.valueOf(this.getSumTotal()) + " kr. ");
        listSize.setText("Antal varer: " + this.items.size());
    }

    /**
     * Finder prisen på et item
     *
     * @param chosenItem et valgt item
     * @return pris som float
     */
    public float findItemPrice(String chosenItem) {
        float itemPrice = Float.valueOf(chosenItem.replaceAll("[^\\d.]", " "));
        return itemPrice;
    }


}


