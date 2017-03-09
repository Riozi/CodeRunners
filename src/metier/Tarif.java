/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;


/**
 *
 * @author 59013-52-15
 */
public class Tarif {
    
    private int id_tarif;
    private FloatProperty montant;
    private int id_gite;
    private int id_saison;
    private Saison saison;
   
    public Tarif(int id_tarif, Float montant, int id_gite, int id_saison) {
        this.id_tarif = id_tarif;
        this.montant = new SimpleFloatProperty(montant);
        this.id_gite = id_gite;
        this.id_saison = id_saison;
        saison = new Saison();
    }
    
    public Tarif() {
       saison = new Saison();
       montant = new SimpleFloatProperty();
    }

    public int getId_tarif() {
        return id_tarif;
    }

    public Float getMontant() {
        return montant.get();
    }
    
    public FloatProperty montantProperty() {
        return montant;
    }
    
    public void setMontant(Float montant){
        this.montant.set(montant);
    }

    public int getId_gite() {
        return id_gite;
    }

    public int getId_saison() {
        return id_saison;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    


}
