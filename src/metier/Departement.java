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
public class Departement {

  
    private String id_departement;
    private StringProperty nom_departement;
    private Integer id_region;
    private Region region;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
     public Departement(String id_departement, String nom_departement, Integer id_region) {
        this.id_departement = id_departement;
        this.nom_departement = new SimpleStringProperty(nom_departement);
        this.id_region = id_region;
    }

    public Departement() {
        nom_departement = new SimpleStringProperty();
        region = new Region();
    }
     
     
     
  public String getId_departement() {
        return id_departement;
    }

    public String getNom_departement() {
        return nom_departement.get();
    }
    
    public StringProperty Nom_departementProperty() {
        return nom_departement;
    }

    public Integer getId_region() {
        return id_region;
    }
    
    @Override
    public String toString()
    {
	return nom_departement.get();
    }

    public void setNom_departement(String nom_departement) {
        this.nom_departement.set(nom_departement);
    }

}
