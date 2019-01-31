/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roboticbartender;

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
import javafx.scene.control.ComboBox;
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
public class DrinksMenuController implements Initializable {

    @FXML private ComboBox ingredientBox;
    @FXML private ComboBox strengthBox;
    @FXML private ComboBox typeBox;
    
    @FXML private TableView<ViewDrink> everythingTable;
    @FXML private Label selectedDrink;
    @FXML private Button viewDrinkButton;
    @FXML private ImageView images;
    @FXML private TableColumn<ViewDrink, String> nameColumn;
    @FXML private TableColumn<ViewDrink, String> priceColumn;
    
    public void backButtonWasPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("CustomerMenu.fxml"));
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
        controller.initData(everythingTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
   
    public ObservableList<ViewDrink> getVodkaDrinks()
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
    
    public ObservableList<ViewDrink> getRumDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Bermuda Triangle", "Highball", "Yes", "No", "No", "Medium", "Cocktail", 6.50, new Image("file:src/rumPictures/bermudatriangle.jpg")));
        drinklist.add(new ViewDrink("Brass Monkey", "Highball", "Yes", "No", "No", "Weak", "Cocktail", 5.00, new Image("file:src/rumPictures/brassmonkey.jpg")));
        drinklist.add(new ViewDrink("Daiquiri", "Martini", "No", "Yes", "No", "Medium", "Martini", 6.50, new Image("file:src/rumPictures/daiquiri.png")));
        drinklist.add(new ViewDrink("Huntsman", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/rumPictures/huntsman.jpg")));
        drinklist.add(new ViewDrink("Little Devil", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/rumPictures/littledevil.jpg")));
        drinklist.add(new ViewDrink("Rum Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/rumPictures/rumneat.jpg")));
        drinklist.add(new ViewDrink("Rum On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/rumPictures/rumontherocks.jpg")));
        drinklist.add(new ViewDrink("Rum Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/rumPictures/rumshot.png")));
        drinklist.add(new ViewDrink("Ti-Punch", "Rock", "Yes", "No", "No", "Medium", "Cocktail", 6.50, new Image("file:src/rumPictures/tipunch.png")));
        
        return drinklist;
    }
    
    public ObservableList<ViewDrink> getGinDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Chelsea Sidecar", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/ginPictures/chelseasidecar.jpg")));
        drinklist.add(new ViewDrink("Flying Dutchman", "Rock", "Yes", "No", "No", "Strong", "Cocktail", 6.50, new Image("file:src/ginPictures/flyingdutchman.jpg")));
        drinklist.add(new ViewDrink("Gimlet", "Martini", "No", "Yes", "No", "Medium", "Martini", 6.50, new Image("file:src/ginPictures/gimlet.jpg")));
        drinklist.add(new ViewDrink("Gin and Cranberry", "Highball", "Yes", "No", "No", "Medium", "Mixed Drink", 6.50, new Image("file:src/ginPictures/ginandcranberry.jpeg")));
        drinklist.add(new ViewDrink("Gin Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/ginPictures/ginneat.jpg")));
        drinklist.add(new ViewDrink("Gin On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/ginPictures/ginontherocks.jpg")));
        drinklist.add(new ViewDrink("Gin Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/ginPictures/ginshot.jpg")));
        drinklist.add(new ViewDrink("Ginny Cosmo", "Martini", "No", "Yes", "No", "Medium", "Martini", 5.00, new Image("file:src/ginPictures/ginnycosmo.jpg")));
        drinklist.add(new ViewDrink("Little Devil", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/ginPictures/littledevil.jpg")));
        drinklist.add(new ViewDrink("Singapore Sling", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/ginPictures/singaporesling.jpg")));
        drinklist.add(new ViewDrink("Tom Collins", "Highball", "yes", "Yes", "Yes", "Medium", "Cocktail", 6.50, new Image("file:src/ginPictures/tomcollins.jpg")));
        
        return drinklist;
    }
    
    public ObservableList<ViewDrink> getTripleSecDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Chelsea Sidecar", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/tripleSecPictures/chelseasidecar.jpg")));
        drinklist.add(new ViewDrink("Cosmopolitan", "Martini", "No", "Yes", "No", "Medium", "Martini", 5.00, new Image("file:src/tripleSecPictures/gimlet.jpg")));
        drinklist.add(new ViewDrink("Flying Dutchman", "Rock", "Yes", "No", "No", "Strong", "Cocktail", 6.50, new Image("file:src/tripleSecPictures/flyingdutchman.jpg")));
        drinklist.add(new ViewDrink("Ginny Cosmo", "Martini", "No", "Yes", "No", "Medium", "Martini", 5.00, new Image("file:src/tripleSecPictures/ginnycosmo.jpg")));
        drinklist.add(new ViewDrink("Kamikaze", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/tripleSecPictures/kamikaze.jpg")));
        drinklist.add(new ViewDrink("Lemon Drop Martini", "Martini", "No", "Yes", "No", "Strong", "Martini", 8.00, new Image("file:src/tripleSecPictures/lemondropmartini.jpg")));
        drinklist.add(new ViewDrink("Little Devil", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/tripleSecPictures/littledevil.jpg")));
        drinklist.add(new ViewDrink("Triple Sec Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/tripleSecPictures/triplesecneat.jpg")));
        drinklist.add(new ViewDrink("Triple Sec On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/tripleSecPictures/triplesecontherocks.jpg")));
        drinklist.add(new ViewDrink("Triple Sec Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/tripleSecPictures/triplesecshot.jpg")));
        
        return drinklist;
    }
    
     public ObservableList<ViewDrink> getWeakDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Bloody Nightmare", "Highball", "Yes", "No", "No", "Weak", "Cocktail", 5.00, new Image("file:src/vodkaPictures/bloodynightmare.jpg")));
        drinklist.add(new ViewDrink("Brass Monkey", "Highball", "Yes", "No", "No", "Weak", "Cocktail", 5.00, new Image("file:src/vodkaPictures/brassmonkey.png")));
        drinklist.add(new ViewDrink("Cape Cod", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/vodkaPictures/capecod.jpg")));
        drinklist.add(new ViewDrink("Hawaiian Sunset", "Highball", "Yes", "Yes", "Yes", "Weak", "Cocktail", 5.00, new Image("file:src/vodkaPictures/hawaiiansunset.jpg")));
        drinklist.add(new ViewDrink("Madras", "Highball", "Yes", "No", "No", "Weak", "Mixed Drink", 5.00, new Image("file:src/vodkaPictures/madras.jpg")));
        drinklist.add(new ViewDrink("Singapore Sling", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/ginPictures/singaporesling.jpg")));
        drinklist.add(new ViewDrink("Orange Cranberry", "Highball", "Yes", "No", "No", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/orangecranberry.jpg")));
        drinklist.add(new ViewDrink("Orange Juice", "Highball", "Yes", "No", "No", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/orangejuice.jpg")));       
        drinklist.add(new ViewDrink("Orange Soda", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/orangesoda.png")));
        drinklist.add(new ViewDrink("Sunshine Fizz", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/sunshinefizz.jpg")));
        drinklist.add(new ViewDrink("Cranberry Juice", "Highball", "Yes", "No", "No", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/cranberryjuice.jpg")));
        drinklist.add(new ViewDrink("Cranberry Soda", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/cranberrysoda.png")));
        drinklist.add(new ViewDrink("Soda Water", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/sodawater.jpg")));

        
        return drinklist;
    }
     
    public ObservableList<ViewDrink> getMediumDrinks()
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
    
    public ObservableList<ViewDrink> getStrongDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Huntsman", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/vodkaPictures/huntsman.jpg")));
        drinklist.add(new ViewDrink("Kamikaze", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/vodkaPictures/kamikaze.jpg")));
        drinklist.add(new ViewDrink("Lemon Drop Martini", "Martini", "No", "Yes", "No", "Strong", "Martini", 8.00, new Image("file:src/vodkaPictures/lemondropmartini.jpg")));
        drinklist.add(new ViewDrink("Lemon Drop Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/vodkaPictures/lemondropshot.jpg")));
        drinklist.add(new ViewDrink("Orange Crush", "Highball", "Yes", "No", "No", "Strong", "Mixed Drink", 6.50, new Image("file:src/vodkaPictures/orangecrush.jpg")));
        drinklist.add(new ViewDrink("Vodka Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/vodkaPictures/vodkashot.jpg")));
        drinklist.add(new ViewDrink("Little Devil", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/rumPictures/littledevil.jpg")));
        drinklist.add(new ViewDrink("Rum Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/rumPictures/rumshot.png")));
        drinklist.add(new ViewDrink("Chelsea Sidecar", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/ginPictures/chelseasidecar.jpg")));
        drinklist.add(new ViewDrink("Flying Dutchman", "Rock", "Yes", "No", "No", "Strong", "Cocktail", 6.50, new Image("file:src/ginPictures/flyingdutchman.jpg")));
        drinklist.add(new ViewDrink("Gin Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/ginPictures/ginshot.jpg")));
        drinklist.add(new ViewDrink("Triple Sec Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/tripleSecPictures/triplesecshot.jpg")));
        
        return drinklist;
    }
    
    public ObservableList<ViewDrink> getCocktailDrinks()
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
    
    public ObservableList<ViewDrink> getMartiniDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Cosmopolitan", "Martini", "No", "Yes", "No", "Medium", "Martini", 5.00, new Image("file:src/vodkaPictures/cosmopolitan.jpg")));
        drinklist.add(new ViewDrink("Huntsman", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/vodkaPictures/huntsman.jpg")));
        drinklist.add(new ViewDrink("Lemon Drop Martini", "Martini", "No", "Yes", "No", "Strong", "Martini", 8.00, new Image("file:src/vodkaPictures/lemondropmartini.jpg")));
        drinklist.add(new ViewDrink("Daiquiri", "Martini", "No", "Yes", "No", "Medium", "Martini", 6.50, new Image("file:src/rumPictures/daiquiri.png")));
        drinklist.add(new ViewDrink("Little Devil", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/rumPictures/littledevil.jpg")));
        drinklist.add(new ViewDrink("Chelsea Sidecar", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/ginPictures/chelseasidecar.jpg")));
        drinklist.add(new ViewDrink("Gimlet", "Martini", "No", "Yes", "No", "Medium", "Martini", 6.50, new Image("file:src/ginPictures/gimlet.jpg")));
        drinklist.add(new ViewDrink("Ginny Cosmo", "Martini", "No", "Yes", "No", "Medium", "Martini", 5.00, new Image("file:src/ginPictures/ginnycosmo.jpg")));
        
        return drinklist;
    }
    
    public ObservableList<ViewDrink> getMixedDrinks()
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
    
     public ObservableList<ViewDrink> getOnTheRocksDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Vodka On The Rocks", "Highball", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/vodkaPictures/vodkaontherocks.jpg")));
        drinklist.add(new ViewDrink("Rum On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/rumPictures/rumontherocks.jpg")));
        drinklist.add(new ViewDrink("Gin On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/ginPictures/ginontherocks.jpg")));       
        drinklist.add(new ViewDrink("Triple Sec On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/tripleSecPictures/triplesecontherocks.jpg")));
        
        return drinklist;
    }
     
    public ObservableList<ViewDrink> getNeatDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Vodka Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/vodkaPictures/vodkaneat.jpg")));
        drinklist.add(new ViewDrink("Rum Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/rumPictures/rumneat.jpg")));
        drinklist.add(new ViewDrink("Gin Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/ginPictures/ginneat.jpg")));
        drinklist.add(new ViewDrink("Triple Sec Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/tripleSecPictures/triplesecneat.jpg")));
        
        return drinklist;
    }
    
    public ObservableList<ViewDrink> getShotDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        drinklist.add(new ViewDrink("Kamikaze", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/vodkaPictures/kamikaze.jpg")));
        drinklist.add(new ViewDrink("Lemon Drop Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/vodkaPictures/lemondropshot.jpg")));
        drinklist.add(new ViewDrink("Vodka Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/vodkaPictures/vodkashot.jpg")));
        drinklist.add(new ViewDrink("Rum Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/rumPictures/rumshot.png")));
        drinklist.add(new ViewDrink("Gin Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/ginPictures/ginshot.jpg")));
        drinklist.add(new ViewDrink("Triple Sec Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/tripleSecPictures/triplesecshot.jpg")));
        
        return drinklist;
    }
    
    public void ingredientBoxWasUpdated()
    {               
        if(ingredientBox.getValue().toString() == "Vodka")
            everythingTable.setItems(getVodkaDrinks());
        else if(ingredientBox.getValue().toString() == "Rum")
            everythingTable.setItems(getRumDrinks());
        else if(ingredientBox.getValue().toString() == "Gin")
            everythingTable.setItems(getGinDrinks());
        else if(ingredientBox.getValue().toString() == "Triple Sec")
            everythingTable.setItems(getTripleSecDrinks());
    }
    
    public void ingredientBoxWasClicked()
    {
        everythingTable.getItems().clear();
        strengthBox.getSelectionModel().clearSelection();
        typeBox.getSelectionModel().clearSelection();
        images.setImage(null);
        this.viewDrinkButton.setDisable(true); 
    }
    
    public void strengthBoxWasUpdated()
    {        
        if(strengthBox.getValue().toString() == "Weak")
            everythingTable.setItems(getWeakDrinks());
        else if(strengthBox.getValue().toString() == "Medium")
            everythingTable.setItems(getMediumDrinks());
        else if(strengthBox.getValue().toString() == "Strong")
            everythingTable.setItems(getStrongDrinks());
    }
    
    public void strengthBoxWasClicked()
    {
        everythingTable.getItems().clear();
        ingredientBox.getSelectionModel().clearSelection();
        typeBox.getSelectionModel().clearSelection();
        images.setImage(null);
        this.viewDrinkButton.setDisable(true); 
    }
    
    public void typeBoxWasUpdated()
    {        
        if(typeBox.getValue().toString() == "Cocktail")
            everythingTable.setItems(getCocktailDrinks());
        else if(typeBox.getValue().toString() == "Martini")
            everythingTable.setItems(getMartiniDrinks());
        else if(typeBox.getValue().toString() == "Mixed Drinks")
            everythingTable.setItems(getMixedDrinks());
        else if(typeBox.getValue().toString() == "On The Rocks")
            everythingTable.setItems(getOnTheRocksDrinks());
        else if(typeBox.getValue().toString() == "Neat")
            everythingTable.setItems(getNeatDrinks());
        else if(typeBox.getValue().toString() == "Shot")
            everythingTable.setItems(getShotDrinks());
    }
    
    public void typeBoxWasClicked()
    {
        everythingTable.getItems().clear();
        strengthBox.getSelectionModel().clearSelection();
        ingredientBox.getSelectionModel().clearSelection();
        images.setImage(null);
        this.viewDrinkButton.setDisable(true);
    }
    
    public void userClickedOnTable()
    {
        this.viewDrinkButton.setDisable(false);
        images.setImage(everythingTable.getSelectionModel().getSelectedItem().getImage());        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Price"));
        
        this.viewDrinkButton.setDisable(true);  
        
        ingredientBox.getItems().addAll("Vodka","Rum","Gin", "Triple Sec");
        strengthBox.getItems().addAll("Weak","Medium","Strong");
        typeBox.getItems().addAll("Cocktail","Martini","Mixed Drinks", "On The Rocks", "Neat", "Shot");
    }    
    
}
