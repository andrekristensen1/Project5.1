package sample;

import javafx.scene.control.Label;

public class Payment {

    public void setSubtotal(Label subTotal, ItemList customerShoppingcart){
        subTotal.setText( " At betale: " + String.valueOf(customerShoppingcart.getSumTotal()) + " kr");
    }
}
