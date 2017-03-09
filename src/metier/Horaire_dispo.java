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
public class Horaire_dispo {
    
    private int id_horaire_dispo;
    private int heure_debut;
    private int heure_fin;

    public Horaire_dispo(int id_horaire_dispo, int heure_debut, int heure_fin) {
        this.id_horaire_dispo = id_horaire_dispo;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
    }

    public int getId_horaire_dispo() {
        return id_horaire_dispo;
    }

    public int getHeure_debut() {
        return heure_debut;
    }

    public int getHeure_fin() {
        return heure_fin;
    }
    
}
