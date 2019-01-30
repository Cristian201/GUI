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
public class WeakDrinkMenuController implements Initializable {

    @FXML private TableView<ViewDrink> weakTable;
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
        controller.initData(weakTable.getSelectionModel().getSelectedItem());
        
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
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + weakTable.getSelectionModel().getSelectedItem().getName());
        
        if("Bloody Nightmare".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/bloodynightmare.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Brass Monkey".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/brassmonkey.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Cape Cod".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/capecod.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Hawaiian Sunset".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/hawaiiansunset.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Madras".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/vodkaPictures/madras.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Singapore Sling".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/ginPictures/singaporesling.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Orange Cranberry".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/orangecranberry.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Orange Juice".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/orangejuice.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Orange Soda".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/orangesoda.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Sunshine Fizz".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/sunshinefizz.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Cranberry Juice".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/cranberryjuice.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Cranberry Soda".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
        {
            File file = new File("src/weakPictures/cranberrysoda.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if("Soda Water".equals(weakTable.getSelectionModel().getSelectedItem().getName()))
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
        weakTable.setColumnResizePolicy(weakTable.CONSTRAINED_RESIZE_POLICY);
        
        this.viewDrinkButton.setDisable(true);
        
        weakTable.setItems(getDrinks());    
    }    
    
}
