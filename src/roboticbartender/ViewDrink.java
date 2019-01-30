/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roboticbartender;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author crist
 */
public class ViewDrink {
    private SimpleStringProperty Name, Glass, Ice, Shake, Carbonated, Strength, Type;
    private Double price;
    private Image image;

    public ViewDrink(String Name, String Glass, String Ice, String Shake, String Carbonated, String Strength, String Type, Double price, Image picture) 
    {
        this.Name = new SimpleStringProperty(Name);
        this.Glass = new SimpleStringProperty(Glass);
        this.Ice = new SimpleStringProperty(Ice);
        this.Shake = new SimpleStringProperty(Shake);
        this.Carbonated = new SimpleStringProperty(Carbonated);
        this.Strength = new SimpleStringProperty(Strength);
        this.Type = new SimpleStringProperty(Type);
        this.price = price;
        this.image = picture;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name = new SimpleStringProperty(Name);
    }

    public String getGlass() {
        return Glass.get();
    }

    public void setGlass(String Glass) {
        this.Glass = new SimpleStringProperty(Glass);
    }

    public String getIce() {
        return Ice.get();
    }

    public void setIce(String Ice) {
        this.Ice = new SimpleStringProperty(Ice);
    }

    public String getShake() {
        return Shake.get();
    }

    public void setShake(String Shake) {
        this.Shake = new SimpleStringProperty(Shake);
    }

    public String getCarbonated() {
        return Carbonated.get();
    }

    public void setCarbonated(String Carbonated) {
        this.Carbonated = new SimpleStringProperty(Carbonated);
    }

    public String getStrength() {
        return Strength.get();
    }

    public void setStrength(String Strength) {
        this.Strength = new SimpleStringProperty(Strength);
    }

    public String getType() {
        return Type.get();
    }

    public void setType(String Type) {
        this.Type = new SimpleStringProperty(Type);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
