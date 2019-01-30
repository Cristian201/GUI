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
public class OnTheRocksController implements Initializable {

    @FXML private TableView<ViewDrink> onTheRocksTable;
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
        controller.initData(onTheRocksTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Vodka On The Rocks", "Highball", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/vodkaPictures/vodkaontherocks.jpg")));
        drinklist.add(new ViewDrink("Rum On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/rumPictures/rumontherocks.jpg")));
        drinklist.add(new ViewDrink("Gin On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/ginPictures/ginontherocks.jpg")));       
        drinklist.add(new ViewDrink("Triple Sec On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/tripleSecPictures/triplesecontherocks.jpg")));
        
        return drinklist;
    }
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + onTheRocksTable.getSelectionModel().getSelectedItem().getName());
        
        if(onTheRocksTable.getSelectionModel().getSelectedItem().getName() == "Vodka On The Rocks")
        {
            File file = new File("src/vodkaPictures/vodkaontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(onTheRocksTable.getSelectionModel().getSelectedItem().getName() == "Rum On The Rocks")
        {
            File file = new File("src/rumPictures/rumontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(onTheRocksTable.getSelectionModel().getSelectedItem().getName() == "Gin On The Rocks")
        {
            File file = new File("src/ginPictures/ginontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(onTheRocksTable.getSelectionModel().getSelectedItem().getName() == "Triple Sec On The Rocks")
        {
            File file = new File("src/tripleSecPictures/triplesecontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Price"));
        
        this.viewDrinkButton.setDisable(true);
        
        onTheRocksTable.setItems(getDrinks()); 
        
    }    
    
}
