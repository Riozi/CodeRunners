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
public class Service {
    
    private Integer id_service;
    private Integer id_type_service;
    private StringProperty nom_service;
    
    public Service(Integer id_service, Integer id_type_service, String nom_service){
        this.id_service = id_service;
        this.id_type_service = id_type_service;
        this.nom_service = new SimpleStringProperty(nom_service);
    }
    
    public Service(){
        nom_service = new SimpleStringProperty();
    }
    
    public Integer getId_service()
    {
	return id_service;
    }
    
    public Integer getId_type_service()
    {
	return id_type_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service.set(nom_service);
    }
    
    public String getNom_service(){
        return nom_service.get();
    }
    
    public StringProperty nom_serviceProperty(){
        return nom_service;
    }

    @Override
    public String toString()
    {
	return nom_service.get();
    }
    
    
    
}
