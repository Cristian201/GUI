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
import javafx.scene.control.ListView;
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
public class MediumDrinkMenuController implements Initializable {

    @FXML private TableView<ViewDrink> mediumTable;
    @FXML private ObservableList<String> drinks = FXCollections.observableArrayList();
    @FXML private Label selectedDrink;
    @FXML private Button viewDrinkButton;
    @FXML private ImageView images;
    @FXML private TableColumn<ViewDrink, String> nameColumn;
    @FXML private TableColumn<ViewDrink, String> priceColumn;
    
    public void backButtonWasPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("StrengthMenu.fxml"));
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
        controller.initData(mediumTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Cosmopolitan", "Martini", "No", "Yes", "No", "Medium", "Martini", 5.00, new Image("file:src/vodkaPictures/cosmopolitan.jpg")));
        drinklist.add(new ViewDrink("Screwdriver", "Highball", "Yes", "No", "No", "Medium", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/screwdriver.jpg")));
        drinklist.add(new ViewDrink("Sparkling Vodka Cranberry", "Highball", "Yes", "No", "Yes", "Medium", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/sparklingvodkacranberry.jpg")));
        drinklist.add(new ViewDrink("Vodka Collins", "Highball", "Yes", "Yes", "Yes", "Medium", "Cocktail", 6.50, new Image("file:src/vodkaPictures/vodkacollins.jpg")));
        drinklist.add(new ViewDrink("Vodka Cranberry", "Highball", "Yes", "No", "No", "Medium", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/vodkacranberry.jpeg")));
        drinklist.add(new ViewDrink("Vodka Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/vodkaPictures/vodkaneat.jpg")));
        drinklist.add(new ViewDrink("Vodka On The Rocks", "Highball", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/vodkaPictures/vodkaontherocks.jpg")));
        drinklist.add(new ViewDrink("Bermuda Triangle", "Highball", "Yes", "No", "No", "Medium", "Cocktail", 6.50, new Image("file:src/rumPictures/bermudatriangle.jpg")));
        drinklist.add(new ViewDrink("Daiquiri", "Martini", "No", "Yes", "No", "Medium", "Martini", 6.50, new Image("file:src/rumPictures/daiquiri.png")));
        drinklist.add(new ViewDrink("Rum Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/rumPictures/rumneat.jpg")));
        drinklist.add(new ViewDrink("Rum On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/rumPictures/rumontherocks.jpg")));
        drinklist.add(new ViewDrink("Ti-Punch", "Rock", "Yes", "No", "No", "Medium", "Cocktail", 6.50, new Image("file:src/rumPictures/tipunch.png")));
        drinklist.add(new ViewDrink("Gimlet", "Martini", "No", "Yes", "No", "Medium", "Martini", 6.50, new Image("file:src/ginPictures/gimlet.jpg")));
        drinklist.add(new ViewDrink("Gin and Cranberry", "Highball", "Yes", "No", "No", "Medium", "Mixed Drink", 6.50, new Image("file:src/ginPictures/ginandcranberry.jpeg")));
        drinklist.add(new ViewDrink("Gin Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/ginPictures/ginneat.jpg")));
        drinklist.add(new ViewDrink("Gin On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/ginPictures/ginontherocks.jpg")));
        drinklist.add(new ViewDrink("Ginny Cosmo", "Martini", "No", "Yes", "No", "Medium", "Martini", 5.00, new Image("file:src/ginPictures/ginnycosmo.jpg")));
        drinklist.add(new ViewDrink("Tom Collins", "Highball", "yes", "Yes", "Yes", "Medium", "Cocktail", 6.50, new Image("file:src/ginPictures/tomcollins.jpg")));
        drinklist.add(new ViewDrink("Triple Sec Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/tripleSecPictures/triplesecneat.jpg")));
        drinklist.add(new ViewDrink("Triple Sec On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/tripleSecPictures/triplesecontherocks.jpg")));        
        
        return drinklist;
    }
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + mediumTable.getSelectionModel().getSelectedItem().getName());
        
        if("Cosmopolitan".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/cosmopolitan.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Screwdriver".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/screwdriver.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Sparkling Vodka Cranberry".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/sparklingvodkacranberry.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Collins".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkacollins.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Cranberry".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkacranberry.jpeg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Neat".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkaneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka On The Rocks".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkaontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Bermuda Triangle".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/rumPictures/bermudatriangle.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Daiquiri".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/rumPictures/daiquiri.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Rum Neat".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/rumPictures/rumneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Rum On The Rocks".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/rumPictures/rumontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Ti-Punch".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/rumPictures/tipunch.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Gimlet".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/ginPictures/gimlet.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Gin and Cranberry".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/ginPictures/ginandcranberry.jpeg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Gin Neat".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/ginPictures/ginneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Gin On The Rocks".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/ginPictures/ginontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Ginny Cosmo".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/ginPictures/ginnycosmo.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Tom Collins".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/ginPictures/tomcollins.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Triple Sec Neat".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/tripleSecPictures/triplesecneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        } 
        
        if("Triple Sec On The Rocks".equals(mediumTable.getSelectionModel().getSelectedItem().getName()))
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
        mediumTable.setColumnResizePolicy(mediumTable.CONSTRAINED_RESIZE_POLICY);
        
        this.viewDrinkButton.setDisable(true);
        
        mediumTable.setItems(getDrinks());  
    }    
    
}
