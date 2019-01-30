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
public class CocktailMenuController implements Initializable {

    @FXML private TableView<ViewDrink> cocktailTable;
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
        controller.initData(cocktailTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Bloody Nightmare", "Highball", "Yes", "No", "No", "Weak", "Cocktail", 5.00, new Image("file:src/vodkaPictures/bloodynightmare.jpg")));
        drinklist.add(new ViewDrink("Brass Monkey", "Highball", "Yes", "No", "No", "Weak", "Cocktail", 5.00, new Image("file:src/vodkaPictures/brassmonkey.png")));
        drinklist.add(new ViewDrink("Hawaiian Sunset", "Highball", "Yes", "Yes", "Yes", "Weak", "Cocktail", 5.00, new Image("file:src/vodkaPictures/hawaiiansunset.jpg")));
        drinklist.add(new ViewDrink("Vodka Collins", "Highball", "Yes", "Yes", "Yes", "Medium", "Cocktail", 6.50, new Image("file:src/vodkaPictures/vodkacollins.jpg")));
        drinklist.add(new ViewDrink("Bermuda Triangle", "Highball", "Yes", "No", "No", "Medium", "Cocktail", 6.50, new Image("file:src/rumPictures/bermudatriangle.jpg")));
        drinklist.add(new ViewDrink("Ti-Punch", "Rock", "Yes", "No", "No", "Medium", "Cocktail", 6.50, new Image("file:src/rumPictures/tipunch.png")));
        drinklist.add(new ViewDrink("Flying Dutchman", "Rock", "Yes", "No", "No", "Strong", "Cocktail", 6.50, new Image("file:src/ginPictures/flyingdutchman.jpg")));
        drinklist.add(new ViewDrink("Tom Collins", "Highball", "yes", "Yes", "Yes", "Medium", "Cocktail", 6.50, new Image("file:src/ginPictures/tomcollins.jpg")));
        
        return drinklist;
    }
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + cocktailTable.getSelectionModel().getSelectedItem().getName());
        
        if(cocktailTable.getSelectionModel().getSelectedItem().getName() == "Bloody Nightmare")
        {
            File file = new File("src/vodkaPictures/bloodynightmare.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }

        if(cocktailTable.getSelectionModel().getSelectedItem().getName() == "Brass Monkey")
        {
            File file = new File("src/vodkaPictures/brassmonkey.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(cocktailTable.getSelectionModel().getSelectedItem().getName() == "Hawaiian Sunset")
        {
            File file = new File("src/vodkaPictures/hawaiiansunset.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(cocktailTable.getSelectionModel().getSelectedItem().getName() == "Vodka Collins")
        {
            File file = new File("src/vodkaPictures/vodkacollins.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(cocktailTable.getSelectionModel().getSelectedItem().getName() == "Bermuda Triangle")
        {
            File file = new File("src/rumPictures/bermudatriangle.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(cocktailTable.getSelectionModel().getSelectedItem().getName() == "Ti-Punch")
        {
            File file = new File("src/rumPictures/tipunch.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(cocktailTable.getSelectionModel().getSelectedItem().getName() == "Flying Dutchman")
        {
            File file = new File("src/ginPictures/ginshot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(cocktailTable.getSelectionModel().getSelectedItem().getName() == "Tom Collins")
        {
            File file = new File("src/ginPictures/tomcollins.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Price"));
        
        this.viewDrinkButton.setDisable(true);
        
        cocktailTable.setItems(getDrinks());  
        
    }    
    
}
