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
public class Commune {

   
    
      
    private Integer code_insee;
    private Float latitude;
    private Float longitude;
    private Integer code_postal;
    private String id_departement;
    private StringProperty nom_commune;
    private Departement departement;
    
   public Commune(Integer code_insee, String nom_commune) {
        this.code_insee = code_insee;
        this.nom_commune = new SimpleStringProperty(nom_commune);
    }

    public Commune() {
        nom_commune = new SimpleStringProperty();
        departement = new Departement();
    }
    
    public Commune(Integer code_insee, String nom_commune,  Float latitude, Float longitude, Integer code_postal, String id_departement) {
        this.code_insee = code_insee;
        this.latitude = latitude;
        this.longitude = longitude;
        this.code_postal = code_postal;
        this.id_departement = id_departement;
        this.nom_commune = new SimpleStringProperty(nom_commune);
    }
  
     public Integer getCode_insee() {
        return code_insee;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Integer getCode_postal() {
        return code_postal;
    }

    public String getId_departement() {
        return id_departement;
    }

    @Override
    public String toString()
    {
	return nom_commune.get();
    }
    
    public StringProperty nom_communeProperty() {
        return nom_commune;
    }
    
    public String getNom_commune() {
        return nom_commune.get();
    }

    public void setNom_commune(String nom_commune) {
        this.nom_commune.set(nom_commune);
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Departement getDepartement() {
        return departement;
    }
    
    
    
    
}
