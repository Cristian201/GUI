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
public class VodkaMenuController implements Initializable {  
    
    @FXML private TableView<ViewDrink> vodkaTable;
    @FXML private Label selectedDrink;
    @FXML private Button viewDrinkButton;
    @FXML private ImageView images;
    @FXML private TableColumn<ViewDrink, String> nameColumn;
    @FXML private TableColumn<ViewDrink, String> priceColumn;
    
    public void backButtonWasPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SpiritSelection.fxml"));
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
        controller.initData(vodkaTable.getSelectionModel().getSelectedItem());
        
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
        drinklist.add(new ViewDrink("Cape Cod", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/vodkaPictures/capecod.jpg")));
        drinklist.add(new ViewDrink("Cosmopolitan", "Martini", "No", "Yes", "No", "Medium", "Martini", 5.00, new Image("file:src/vodkaPictures/cosmopolitan.jpg")));
        drinklist.add(new ViewDrink("Hawaiian Sunset", "Highball", "Yes", "Yes", "Yes", "Weak", "Cocktail", 5.00, new Image("file:src/vodkaPictures/hawaiiansunset.jpg")));
        drinklist.add(new ViewDrink("Huntsman", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/vodkaPictures/huntsman.jpg")));
        drinklist.add(new ViewDrink("Kamikaze", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/vodkaPictures/kamikaze.jpg")));
        drinklist.add(new ViewDrink("Lemon Drop Martini", "Martini", "No", "Yes", "No", "Strong", "Martini", 8.00, new Image("file:src/vodkaPictures/lemondropmartini.jpg")));
        drinklist.add(new ViewDrink("Lemon Drop Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/vodkaPictures/lemondropshot.jpg")));
        drinklist.add(new ViewDrink("Madras", "Highball", "Yes", "No", "No", "Weak", "Mixed Drink", 5.00, new Image("file:src/vodkaPictures/madras.jpg")));
        drinklist.add(new ViewDrink("Orange Crush", "Highball", "Yes", "No", "No", "Strong", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/orangecrush.jpg")));
        drinklist.add(new ViewDrink("Screwdriver", "Highball", "Yes", "No", "No", "Medium", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/screwdriver.jpg")));
        drinklist.add(new ViewDrink("Sparkling Vodka Cranberry", "Highball", "Yes", "No", "Yes", "Medium", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/sparklingvodkacranberry.jpg")));
        drinklist.add(new ViewDrink("Vodka Collins", "Highball", "Yes", "Yes", "Yes", "Medium", "Cocktail", 6.50, new Image("file:src/vodkaPictures/vodkacollins.jpg")));
        drinklist.add(new ViewDrink("Vodka Cranberry", "Highball", "Yes", "No", "No", "Medium", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/vodkacranberry.jpeg")));
        drinklist.add(new ViewDrink("Vodka Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/vodkaPictures/vodkaneat.jpg")));
        drinklist.add(new ViewDrink("Vodka On The Rocks", "Highball", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/vodkaPictures/vodkaontherocks.jpg")));
        drinklist.add(new ViewDrink("Vodka Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/vodkaPictures/vodkashot.jpg")));
        
        return drinklist;
    }
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + vodkaTable.getSelectionModel().getSelectedItem().getName());
        
        if("Bloody Nightmare".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/bloodynightmare.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Brass Monkey".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/brassmonkey.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Cape Cod".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/capecod.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Cosmopolitan".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/cosmopolitan.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Hawaiian Sunset".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/hawaiiansunset.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Huntsman".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/huntsman.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Kamikaze".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/kamikaze.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Lemon Drop Martini".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/lemondropmartini.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Lemon Drop Shot".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/lemondropshot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Madras".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/madras.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Orange Crush".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/orangecrush.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Screwdriver".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/screwdriver.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Sparkling Vodka Cranberry".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/sparklingvodkacranberry.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Collins".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkacollins.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Cranberry".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkacranberry.jpeg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Neat".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkaneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka On The Rocks".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkaontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Shot".equals(vodkaTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkashot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {       

        nameColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Price"));
        
        this.viewDrinkButton.setDisable(true);
        
        vodkaTable.setItems(getDrinks());
        
        
    }    
    
}
