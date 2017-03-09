/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 59013-52-15
 */
public class Periode_tarif {
    
    private int id_periode_tarif;
    
    // ATTENTION IL FAUT IMPLEMENTER LA CLASSE MADATE DE FRANCOIS DANS LES OUTILS
    
    private StringProperty date_debut;
    private StringProperty date_fin;

    public Periode_tarif(int id_periode_tarif, String date_debut, String date_fin) {
        this.id_periode_tarif = id_periode_tarif;
        this.date_debut = new SimpleStringProperty(date_debut);
        this.date_fin = new SimpleStringProperty(date_fin);
    }
    
    public Periode_tarif() {
        date_debut = new SimpleStringProperty();
        date_fin = new SimpleStringProperty();
    }

    public int getId_periode_tarif() {
        return id_periode_tarif;
    }

    public String getDate_debut() {
        return date_debut.get();
    }
    
    public StringProperty date_debutProperty() {
        return date_debut;
    }
    
    public void setDate_debut(String date_debut){
        this.date_debut.set(date_debut);
    }
    

    public String getDate_fin() {
        return date_fin.get();
    }
    
    public StringProperty date_finProperty() {
        return date_fin;
    }
    
    public void setDate_fin(String date_fin){
        this.date_fin.set(date_fin);
    }
    
}
