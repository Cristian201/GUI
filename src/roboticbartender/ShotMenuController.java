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
public class ShotMenuController implements Initializable {

    @FXML private TableView<ViewDrink> shotTable;
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
        controller.initData(shotTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
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
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + shotTable.getSelectionModel().getSelectedItem().getName());
        
        if(shotTable.getSelectionModel().getSelectedItem().getName() == "Kamikaze")
        {
            File file = new File("src/vodkaPictures/kamikaze.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(shotTable.getSelectionModel().getSelectedItem().getName() == "Lemon Drop Shot")
        {
            File file = new File("src/vodkaPictures/lemondropshot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(shotTable.getSelectionModel().getSelectedItem().getName() == "Vodka Shot")
        {
            File file = new File("src/vodkaPictures/vodkashot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(shotTable.getSelectionModel().getSelectedItem().getName() == "Rum Shot")
        {
            File file = new File("src/rumPictures/rumshot.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(shotTable.getSelectionModel().getSelectedItem().getName() == "Gin Shot")
        {
            File file = new File("src/ginPictures/ginshot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(shotTable.getSelectionModel().getSelectedItem().getName() == "Triple Sec Shot")
        {
            File file = new File("src/tripleSecPictures/triplesecshot.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        nameColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Price"));
        
        this.viewDrinkButton.setDisable(true);
        
        shotTable.setItems(getDrinks()); 
        
    }    
    
}
