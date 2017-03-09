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
public class Joindre {
    
    private int id_individu;
    private int id_periode_dispo;
    private int id_horaire_dispo;

    public Joindre(int id_individu, int id_periode_dispo, int id_horaire_dispo) {
        this.id_individu = id_individu;
        this.id_periode_dispo = id_periode_dispo;
        this.id_horaire_dispo = id_horaire_dispo;
    }

    public int getId_individu() {
        return id_individu;
    }

    public int getId_periode_dispo() {
        return id_periode_dispo;
    }

    public int getId_horaire_dispo() {
        return id_horaire_dispo;
    }
    
}
