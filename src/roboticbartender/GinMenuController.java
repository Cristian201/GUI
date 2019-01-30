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
public class GinMenuController implements Initializable {
    
    @FXML private TableView<ViewDrink> ginTable;
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
        controller.initData(ginTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
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
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + ginTable.getSelectionModel().getSelectedItem().getName());
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Chelsea Sidecar")
        {
            File file = new File("src/ginPictures/chelseasidecar.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }

        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Flying Dutchman")
        {
            File file = new File("src/ginPictures/flyingdutchman.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Gimlet")
        {
            File file = new File("src/ginPictures/gimlet.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Gin and Cranberry")
        {
            File file = new File("src/ginPictures/ginandcranberry.jpeg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Gin Neat")
        {
            File file = new File("src/ginPictures/ginneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Gin On The Rocks")
        {
            File file = new File("src/ginPictures/ginontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Gin Shot")
        {
            File file = new File("src/ginPictures/ginshot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Ginny Cosmo")
        {
            File file = new File("src/ginPictures/ginnycosmo.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Little Devil")
        {
            File file = new File("src/ginPictures/littledevil.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Singapore Sling")
        {
            File file = new File("src/ginPictures/singaporesling.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(ginTable.getSelectionModel().getSelectedItem().getName() == "Tom Collins")
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
        
        ginTable.setItems(getDrinks());
    }    
    
}
