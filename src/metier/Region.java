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
 * @author 59013-52-01
 */
public class Region {
    
    private Integer id_region;
    private StringProperty nom_region;

    public Region(Integer id_region, String nom_region) {
        this.id_region = id_region;
        this.nom_region = new SimpleStringProperty(nom_region);
    }

    public Region() {
        nom_region = new SimpleStringProperty();
    }

    public Integer getId_region() {
        return id_region;
    }

    public String getNom_region() {
        return nom_region.get();
    }
    
    public StringProperty nom_regionProperty() {
        return nom_region;
    }
    
     @Override
    public String toString()
    {
	return nom_region.get();
    }

    public void setNom_region(String nom_region) {
        this.nom_region.set(nom_region);
    }
    
}
