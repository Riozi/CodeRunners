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
public class Type_individu {
    
    private int id_type_individu;
    private StringProperty type_individu;

    public Type_individu(int id_type_individu, String type_individu) {
        this.id_type_individu = id_type_individu;
        this.type_individu = new SimpleStringProperty(type_individu);
    }

    public Type_individu() {
        type_individu = new SimpleStringProperty();
    }
    

    public int getId_type_individu() {
        return id_type_individu;
    }

    public String getType_individu() {
        return type_individu.get();
    }
    
    public StringProperty Type_individuProperty() {
        return type_individu;
    }
    
    public void setType_individu(String type_individu){
        this.type_individu.set(type_individu);
    }
    
}
