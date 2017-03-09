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
public class Posseder {
    
    private int prix_service;
    private int id_gite;
    private int id_service;

    public Posseder(int prix_service, int id_gite, int id_service) {
        this.prix_service = prix_service;
        this.id_gite = id_gite;
        this.id_service = id_service;
    }

    public int getPrix_service() {
        return prix_service;
    }

    public int getId_gite() {
        return id_gite;
    }

    public int getId_service() {
        return id_service;
    }
    
    
}
