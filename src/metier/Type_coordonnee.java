/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 59013-52-15
 */
public class Type_coordonnee {
    
    private int id_type_coordonnee;
    private StringProperty type_coordonnee;

    public Type_coordonnee(int id_type_coordonnee, String type_coordonnee) {
        this.id_type_coordonnee = id_type_coordonnee;
        this.type_coordonnee = new SimpleStringProperty(type_coordonnee);
    }

    public Type_coordonnee() {
        type_coordonnee = new SimpleStringProperty();
    }
    

    public int getId_type_coordonnee() {
        return id_type_coordonnee;
    }

    public String getType_coordonnee() {
        return type_coordonnee.get();
    }
    
    public StringProperty type_coordonneeProperty() {
        return type_coordonnee;
    }
    
    public void setType_coordonnee(String type_coordonnee){
        this.type_coordonnee.set(type_coordonnee);
    }
    
}
