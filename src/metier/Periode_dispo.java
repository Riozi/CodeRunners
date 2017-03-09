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
public class Periode_dispo {
    
    private int id_periode_dispo;
    private String jour_debut;
    private String jour_fin;

    public Periode_dispo(int id_periode_dispo, String jour_debut, String jour_fin) {
        this.id_periode_dispo = id_periode_dispo;
        this.jour_debut = jour_debut;
        this.jour_fin = jour_fin;
    }

    public int getId_periode_dispo() {
        return id_periode_dispo;
    }

    public String getJour_debut() {
        return jour_debut;
    }

    public String getJour_fin() {
        return jour_fin;
    }
    
    
}
