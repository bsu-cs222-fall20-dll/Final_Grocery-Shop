package edu.bsu.cs222.finalProject.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CartUIController
{
    public AnchorPane rootPane;

    @FXML
    String storeNameStored;

    public void launchOrderConfirmUI() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/orderConfirm.fxml"));
        Parent root = loader.load();
        OrderConfirmController orderConfirmController = loader.getController();
        //send data here
        orderConfirmController.setStoreName(storeNameStored);

        rootPane.getChildren().setAll( root ); }

    public void launchStoreUI() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/storeUI.fxml"));
        Parent root = loader.load();
        StoreUIController store = loader.getController();

        //send data here
        sendDataToStore( store );

        rootPane.getChildren().setAll( root );
    }

    public void sendDataToStore(StoreUIController store) throws IOException {
        store.setStoreNameFromCart( storeNameStored );
        store.populateTableWithItems( storeNameStored );
    }

    public void setStoreName(String storeName)
    { this.storeNameStored = storeName; }
}