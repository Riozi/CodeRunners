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
public class Coordonnee {
    
    private int id_coordonnee;
    private StringProperty coordonnee;
    private int id_individu;
    private int id_type_coordonnee;
    private Type_coordonnee type_coordonnee;

    public Coordonnee(int id_coordonnee, String coordonnee, int id_individu, int id_type_coordonnee) {
        this.id_coordonnee = id_coordonnee;
        this.coordonnee = new SimpleStringProperty(coordonnee);
        this.id_individu = id_individu;
        this.id_type_coordonnee = id_type_coordonnee;
        type_coordonnee = new Type_coordonnee();
    }

    public Coordonnee() {
        coordonnee = new SimpleStringProperty();
        type_coordonnee = new Type_coordonnee();
    }

    public Type_coordonnee getType_coordonnee() {
        return type_coordonnee;
    }

    public void setType_coordonnee(Type_coordonnee type_coordonnee) {
        this.type_coordonnee = type_coordonnee;
    }

    public int getId_coordonnee() {
        return id_coordonnee;
    }

    public String getCoordonnee() {
        return coordonnee.get();
    }
    
    public StringProperty getCoordonneeProperty() {
        return coordonnee;
    }
    
    public void setCoordonnee(String coordonnee){
        this.coordonnee.set(coordonnee);
    }

    public int getId_individu() {
        return id_individu;
    }

    public int getId_type_coordonnee() {
        return id_type_coordonnee;
    }
    
}
