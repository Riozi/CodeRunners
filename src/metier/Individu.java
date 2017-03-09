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
public class Individu {
    
    private int id_individu;
    private StringProperty nom_individu;
    private StringProperty prenom_individu;
    private Categoriser categoriser;
    private Coordonnee coordonnee;

    public Individu(int id_individu, String nom_individu, String prenom_individu) {
        this.id_individu = id_individu;
        this.nom_individu = new SimpleStringProperty(nom_individu);
        this.prenom_individu = new SimpleStringProperty(prenom_individu);
        categoriser = new Categoriser();
        coordonnee = new Coordonnee();
    }

    public Individu() {
        categoriser = new Categoriser();
        nom_individu = new SimpleStringProperty();
        prenom_individu = new SimpleStringProperty();
        categoriser = new Categoriser();
        coordonnee = new Coordonnee();
    }
    

    public int getId_individu() {
        return id_individu;
    }

    public String getNom_individu() {
        return nom_individu.get();
    }
    
    public StringProperty nom_individuProperty() {
        return nom_individu;
    }
    
    public void setNom_individu(String nom_individu){
        this.nom_individu.set(nom_individu);
    }

    public String getPrenom_individu() {
        return prenom_individu.get();
    }
    
    public StringProperty prenom_individuProperty() {
        return prenom_individu;
    }
    
    public void setPrenomom_individu(String prenom_individu){
        this.prenom_individu.set(prenom_individu);
    }

    public Categoriser getCategoriser() {
        return categoriser;
    }

    public void setCategoriser(Categoriser categoriser) {
        this.categoriser = categoriser;
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }


    
    
    
}
