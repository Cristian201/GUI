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
public class TripleSecMenuController implements Initializable {

    @FXML private TableView<ViewDrink> tripleSecTable;
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
        controller.initData(tripleSecTable.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList<ViewDrink> getDrinks()
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
    
    public void userClickedOnList()
    {
        this.viewDrinkButton.setDisable(false);
        selectedDrink.setText("Selected Drink:\n" + tripleSecTable.getSelectionModel().getSelectedItem().getName());
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Chelsea Sidecar")
        {
            File file = new File("src/tripleSecPictures/chelseasidecar.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Cosmopolitan")
        {
            File file = new File("src/tripleSecPictures/cosmopolitan.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }        
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Flying Dutchman")
        {
            File file = new File("src/tripleSecPictures/flyingdutchman.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }       
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Ginny Cosmo")
        {
            File file = new File("src/tripleSecPictures/ginnycosmo.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }  
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Kamikaze")
        {
            File file = new File("src/tripleSecPictures/kamikaze.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }    
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Lemon Drop Martini")
        {
            File file = new File("src/tripleSecPictures/lemondropmartini.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }   
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Little Devil")
        {
            File file = new File("src/tripleSecPictures/littledevil.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        }   
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Triple Sec Neat")
        {
            File file = new File("src/tripleSecPictures/triplesecneat.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        } 
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Triple Sec On The Rocks")
        {
            File file = new File("src/tripleSecPictures/triplesecontherocks.jpg");
            Image image = new Image(file.toURI().toString());
            images.setImage(image);
        } 
        
        if(tripleSecTable.getSelectionModel().getSelectedItem().getName() == "Triple Sec Shot")
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
        
        tripleSecTable.setItems(getDrinks());            
    }    
    
}
