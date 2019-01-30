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
public class RumMenuController implements Initializable {

    @FXML private TableView<ViewDrink> rumTable;
    @FXML private ObservableList<String> drinks = FXCollections.observableArrayList();
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
        controller.initData(rumTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
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
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + rumTable.getSelectionModel().getSelectedItem().getName());
        
        if(rumTable.getSelectionModel().getSelectedItem().getName() == "Bermuda Triangle")
        {
            File file = new File("src/rumPictures/bermudatriangle.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(rumTable.getSelectionModel().getSelectedItem().getName() == "Brass Monkey")
        {
            File file = new File("src/rumPictures/brassmonkey.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(rumTable.getSelectionModel().getSelectedItem().getName() == "Daiquiri")
        {
            File file = new File("src/rumPictures/daiquiri.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(rumTable.getSelectionModel().getSelectedItem().getName() == "Huntsman")
        {
            File file = new File("src/rumPictures/huntsman.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(rumTable.getSelectionModel().getSelectedItem().getName() == "Little Devil")
        {
            File file = new File("src/rumPictures/littledevil.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(rumTable.getSelectionModel().getSelectedItem().getName() == "Rum Neat")
        {
            File file = new File("src/rumPictures/rumneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(rumTable.getSelectionModel().getSelectedItem().getName() == "Rum On The Rocks")
        {
            File file = new File("src/rumPictures/rumontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(rumTable.getSelectionModel().getSelectedItem().getName() == "Rum Shot")
        {
            File file = new File("src/rumPictures/rumshot.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(rumTable.getSelectionModel().getSelectedItem().getName() == "Ti-Punch")
        {
            File file = new File("src/rumPictures/tipunch.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Price"));
        
        this.viewDrinkButton.setDisable(true);
        
        rumTable.setItems(getDrinks());
     
    }    
    
}
