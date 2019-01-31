/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roboticbartender;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author crist
 */
public class ViewDrinkScreenController implements Initializable {
    
    private ViewDrink selectedDrink;
    
    @FXML private Label nameLabel;
    @FXML private Label glassLabel;
    @FXML private Label iceLabel;
    @FXML private Label shakeLabel;
    @FXML private Label carbonatedLabel;
    @FXML private Label strengthLabel;
    @FXML private Label typeLabel;
    @FXML private Label priceLabel;
    @FXML private ImageView image;
    
    
    public void initData(ViewDrink drink)
    {
        selectedDrink = drink;
        nameLabel.setText(selectedDrink.getName());
        glassLabel.setText(selectedDrink.getGlass());
        iceLabel.setText(selectedDrink.getIce());
        shakeLabel.setText(selectedDrink.getShake());
        carbonatedLabel.setText(selectedDrink.getCarbonated());
        strengthLabel.setText(selectedDrink.getStrength());
        typeLabel.setText(selectedDrink.getType());
        priceLabel.setText(selectedDrink.getPrice().toString());
        image.setImage(selectedDrink.getImage());
    }
    
    public void logOutButtonWasPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public void backButtonWasPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("DrinksMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public void viewOrderButtonWasPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ViewOrderScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public void addToOrderButtonWasPushed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ViewOrderScreen.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        
        ViewOrderScreenController controller = loader.getController();
        controller.initData(selectedDrink);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
