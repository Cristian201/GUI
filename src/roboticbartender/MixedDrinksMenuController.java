/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roboticbartender;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author crist
 */
public class MixedDrinksMenuController implements Initializable {

    @FXML private TableView<ViewDrink> mixedDrinksTable;
    @FXML private ObservableList<String> drinks = FXCollections.observableArrayList();
    @FXML private Label selectedDrink;
    @FXML private Button viewDrinkButton;
    @FXML private ImageView images;
    @FXML private TableColumn<ViewDrink, String> nameColumn;
    @FXML private TableColumn<ViewDrink, String> priceColumn;
    
    public void backButtonWasPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TypeMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
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
    
    public void viewDrinkButtonWasPushed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ViewDrinkScreen.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        
        ViewDrinkScreenController controller = loader.getController();
        controller.initData(mixedDrinksTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Cape Cod", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/vodkaPictures/capecod.jpg")));
        drinklist.add(new ViewDrink("Gin and Cranberry", "Highball", "Yes", "No", "No", "Medium", "Mixed Drink", 6.50, new Image("file:src/ginPictures/ginandcranberry.jpeg")));        
        drinklist.add(new ViewDrink("Madras", "Highball", "Yes", "No", "No", "Weak", "Mixed Drink", 5.00, new Image("file:src/vodkaPictures/madras.jpg")));
        drinklist.add(new ViewDrink("Orange Crush", "Highball", "Yes", "No", "No", "Strong", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/orangecrush.jpg")));
        drinklist.add(new ViewDrink("Screwdriver", "Highball", "Yes", "No", "No", "Medium", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/screwdriver.jpg")));
        drinklist.add(new ViewDrink("Sparkling Vodka Cranberry", "Highball", "Yes", "No", "Yes", "Medium", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/sparklingvodkacranberry.jpg")));        
        drinklist.add(new ViewDrink("Vodka Cranberry", "Highball", "Yes", "No", "No", "Medium", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/vodkacranberry.jpeg")));
        drinklist.add(new ViewDrink("Singapore Sling", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/ginPictures/singaporesling.jpg")));
        
        return drinklist;
    }
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + mixedDrinksTable.getSelectionModel().getSelectedItem().getName());
        
        if(mixedDrinksTable.getSelectionModel().getSelectedItem().getName() == "Cape Cod")
        {
            File file = new File("src/vodkaPictures/capecod.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }

        if(mixedDrinksTable.getSelectionModel().getSelectedItem().getName() == "Madras")
        {
            File file = new File("src/vodkaPictures/madras.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(mixedDrinksTable.getSelectionModel().getSelectedItem().getName() == "Orange Crush")
        {
            File file = new File("src/vodkaPictures/orangecrush.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(mixedDrinksTable.getSelectionModel().getSelectedItem().getName() == "Screwdriver")
        {
            File file = new File("src/vodkaPictures/screwdriver.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(mixedDrinksTable.getSelectionModel().getSelectedItem().getName() == "Sparkling Vodka Cranberry")
        {
            File file = new File("src/vodkaPictures/sparklingvodkacranberry.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(mixedDrinksTable.getSelectionModel().getSelectedItem().getName() == "Vodka Cranberry")
        {
            File file = new File("src/vodkaPictures/vodkacranberry.jpeg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(mixedDrinksTable.getSelectionModel().getSelectedItem().getName() == "Gin and Cranberry")
        {
            File file = new File("src/ginPictures/ginandcranberry.jpeg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(mixedDrinksTable.getSelectionModel().getSelectedItem().getName() == "Singapore Sling")
        {
            File file = new File("src/ginPictures/singaporesling.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Price"));
        
        this.viewDrinkButton.setDisable(true);
        
        mixedDrinksTable.setItems(getDrinks()); 
        
    }    
    
}
