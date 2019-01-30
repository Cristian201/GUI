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
public class MartiniMenuController implements Initializable {

    @FXML private TableView<ViewDrink> martiniTable;
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
        controller.initData(martiniTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
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
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + martiniTable.getSelectionModel().getSelectedItem().getName());
        
        if(martiniTable.getSelectionModel().getSelectedItem().getName() == "Cosmopolitan")
        {
            File file = new File("src/vodkaPictures/cosmopolitan.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }

        if(martiniTable.getSelectionModel().getSelectedItem().getName() == "Huntsman")
        {
            File file = new File("src/vodkaPictures/huntsman.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(martiniTable.getSelectionModel().getSelectedItem().getName() == "Lemon Drop Martini")
        {
            File file = new File("src/vodkaPictures/lemondropmartini.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(martiniTable.getSelectionModel().getSelectedItem().getName() == "Daiquiri")
        {
            File file = new File("src/rumPictures/daiquiri.png");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(martiniTable.getSelectionModel().getSelectedItem().getName() == "Little Devil")
        {
            File file = new File("src/rumPictures/littledevil.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(martiniTable.getSelectionModel().getSelectedItem().getName() == "Chelsea Sidecar")
        {
            File file = new File("src/ginPictures/chelseasidecar.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(martiniTable.getSelectionModel().getSelectedItem().getName() == "Gimlet")
        {
            File file = new File("src/ginPictures/gimlet.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(martiniTable.getSelectionModel().getSelectedItem().getName() == "Ginny Cosmo")
        {
            File file = new File("src/ginPictures/ginnycosmo.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ViewDrink, String>("Price"));
        
        this.viewDrinkButton.setDisable(true);
        
        martiniTable.setItems(getDrinks()); 
        
    }    
    
}
