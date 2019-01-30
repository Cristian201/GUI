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
public class AllDrinksMenuController implements Initializable {

    @FXML private TableView<ViewDrink> allDrinksTable;
    @FXML private ObservableList<String> drinks = FXCollections.observableArrayList();
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
        controller.initData(allDrinksTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
    {
        ObservableList<ViewDrink> drinklist = FXCollections.observableArrayList();
        // Vodka
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
        // Rum
        drinklist.add(new ViewDrink("Bermuda Triangle", "Highball", "Yes", "No", "No", "Medium", "Cocktail", 6.50, new Image("file:src/rumPictures/bermudatriangle.jpg")));
        drinklist.add(new ViewDrink("Brass Monkey", "Highball", "Yes", "No", "No", "Weak", "Cocktail", 5.00, new Image("file:src/rumPictures/brassmonkey.jpg")));
        drinklist.add(new ViewDrink("Daiquiri", "Martini", "No", "Yes", "No", "Medium", "Martini", 6.50, new Image("file:src/rumPictures/daiquiri.png")));
        drinklist.add(new ViewDrink("Huntsman", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/rumPictures/huntsman.jpg")));
        drinklist.add(new ViewDrink("Little Devil", "Martini", "No", "Yes", "No", "Strong", "Martini", 6.50, new Image("file:src/rumPictures/littledevil.jpg")));
        drinklist.add(new ViewDrink("Rum Neat", "Rock", "No", "No", "No", "Medium", "Neat", 6.50, new Image("file:src/rumPictures/rumneat.jpg")));
        drinklist.add(new ViewDrink("Rum On The Rocks", "Rock", "Yes", "No", "No", "Medium", "On The Rocks", 6.50, new Image("file:src/rumPictures/rumontherocks.jpg")));
        drinklist.add(new ViewDrink("Rum Shot", "Shot", "No", "Yes", "No", "Strong", "Shot", 5.00, new Image("file:src/rumPictures/rumshot.png")));
        drinklist.add(new ViewDrink("Ti-Punch", "Rock", "Yes", "No", "No", "Medium", "Cocktail", 6.50, new Image("file:src/rumPictures/tipunch.png")));
        // Gin
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
        // Triple Sec
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
        // Other
        drinklist.add(new ViewDrink("Orange Cranberry", "Highball", "Yes", "No", "No", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/orangecranberry.jpg")));
        drinklist.add(new ViewDrink("Orange Juice", "Highball", "Yes", "No", "No", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/orangejuice.jpg")));       
        drinklist.add(new ViewDrink("Orange Soda", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/orangesoda.png")));
        drinklist.add(new ViewDrink("Sunshine Fizz", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/sunshinefizz.jpg")));
        drinklist.add(new ViewDrink("Cranberry Juice", "Highball", "Yes", "No", "No", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/cranberryjuice.jpg")));
        drinklist.add(new ViewDrink("Cranberry Soda", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/cranberrysoda.png")));
        drinklist.add(new ViewDrink("Soda Water", "Highball", "Yes", "No", "Yes", "Weak", "Mixed Drink", 5.00, new Image("file:src/weakPictures/sodawater.jpg")));

        return drinklist;
    }
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + allDrinksTable.getSelectionModel().getSelectedItem().getName());
        
        // Vodka
        if("Bloody Nightmare".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/bloodynightmare.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Brass Monkey".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/brassmonkey.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Cape Cod".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/capecod.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Cosmopolitan".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/cosmopolitan.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Hawaiian Sunset".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/hawaiiansunset.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Huntsman".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/huntsman.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Kamikaze".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/kamikaze.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Lemon Drop Martini".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/lemondropmartini.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Lemon Drop Shot".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/lemondropshot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Madras".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/madras.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Orange Crush".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/orangecrush.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Screwdriver".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/screwdriver.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Sparkling Vodka Cranberry".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/sparklingvodkacranberry.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Collins".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkacollins.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Cranberry".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkacranberry.jpeg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Neat".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkaneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka On The Rocks".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkaontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Vodka Shot".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/vodkashot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        // Rum
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Bermuda Triangle")
        {
            File file = new File("src/rumPictures/bermudatriangle.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Brass Monkey")
        {
            File file = new File("src/rumPictures/brassmonkey.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Daiquiri")
        {
            File file = new File("src/rumPictures/daiquiri.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Huntsman")
        {
            File file = new File("src/rumPictures/huntsman.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Little Devil")
        {
            File file = new File("src/rumPictures/littledevil.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Rum Neat")
        {
            File file = new File("src/rumPictures/rumneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Rum On The Rocks")
        {
            File file = new File("src/rumPictures/rumontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Rum Shot")
        {
            File file = new File("src/rumPictures/rumshot.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Ti-Punch")
        {
            File file = new File("src/rumPictures/tipunch.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        // Gin
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Chelsea Sidecar")
        {
            File file = new File("src/ginPictures/chelseasidecar.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }

        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Flying Dutchman")
        {
            File file = new File("src/ginPictures/flyingdutchman.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Gimlet")
        {
            File file = new File("src/ginPictures/gimlet.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Gin and Cranberry")
        {
            File file = new File("src/ginPictures/ginandcranberry.jpeg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Gin Neat")
        {
            File file = new File("src/ginPictures/ginneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Gin On The Rocks")
        {
            File file = new File("src/ginPictures/ginontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Gin Shot")
        {
            File file = new File("src/ginPictures/ginshot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Ginny Cosmo")
        {
            File file = new File("src/ginPictures/ginnycosmo.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Little Devil")
        {
            File file = new File("src/ginPictures/littledevil.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Singapore Sling")
        {
            File file = new File("src/ginPictures/singaporesling.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Tom Collins")
        {
            File file = new File("src/ginPictures/tomcollins.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        // Triple Sec
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Chelsea Sidecar")
        {
            File file = new File("src/tripleSecPictures/chelseasidecar.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Cosmopolitan")
        {
            File file = new File("src/tripleSecPictures/cosmopolitan.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }        
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Flying Dutchman")
        {
            File file = new File("src/tripleSecPictures/flyingdutchman.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }       
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Ginny Cosmo")
        {
            File file = new File("src/tripleSecPictures/ginnycosmo.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }  
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Kamikaze")
        {
            File file = new File("src/tripleSecPictures/kamikaze.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }    
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Lemon Drop Martini")
        {
            File file = new File("src/tripleSecPictures/lemondropmartini.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }   
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Little Devil")
        {
            File file = new File("src/tripleSecPictures/littledevil.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }   
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Triple Sec Neat")
        {
            File file = new File("src/tripleSecPictures/triplesecneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        } 
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Triple Sec On The Rocks")
        {
            File file = new File("src/tripleSecPictures/triplesecontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        } 
        
        if(allDrinksTable.getSelectionModel().getSelectedItem().getName() == "Triple Sec Shot")
        {
            File file = new File("src/tripleSecPictures/triplesecshot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }         
        
        // Other
        if("Orange Cranberry".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/orangecranberry.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Orange Juice".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/orangejuice.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Orange Soda".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/orangesoda.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Sunshine Fizz".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/sunshinefizz.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Cranberry Juice".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/cranberryjuice.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Cranberry Soda".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/cranberrysoda.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Soda Water".equals(allDrinksTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/sodawater.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Price"));
        allDrinksTable.setColumnResizePolicy(allDrinksTable.CONSTRAINED_RESIZE_POLICY);
        
        this.viewDrinkButton.setDisable(true);
        
        allDrinksTable.setItems(getDrinks());  
    }    
    
}
