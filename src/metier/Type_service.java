/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author 59013-52-15
 */
public class Type_service {
    
    private int id_type_service;
    private String type_service;

    public Type_service(int id_type_service, String type_service) {
        this.id_type_service = id_type_service;
        this.type_service = type_service;
    }

    public int getId_type_service() {
        return id_type_service;
    }

    public String getType_service() {
        return type_service;
    }
    
}
