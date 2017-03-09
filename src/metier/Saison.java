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
public class Saison {
    
    private int id_saison;
    private StringProperty nomSaison;

    public Saison(int id_saison, String nomSaison) {
        this.id_saison = id_saison;
        this.nomSaison = new SimpleStringProperty(nomSaison);
    }
    
    public Saison() {
        nomSaison = new SimpleStringProperty();
    }

    public int getId_saison() {
        return id_saison;
    }

    public String getSaison() {
        return nomSaison.get();
    }
    
    public StringProperty saisonProperty() {
        return nomSaison;
    }
    public void setSaison(String nomSaison) {
        this.nomSaison.set(nomSaison);
    }
    


    
}
