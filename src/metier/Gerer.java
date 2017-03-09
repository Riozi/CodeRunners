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
public class Gerer {
    
    private int id_gite;
    private int id_individu;
    private Individu individu;

    public Gerer(int id_gite, int id_individu) {
        this.id_gite = id_gite;
        this.id_individu = id_individu;
        individu = new Individu();
    }

    public Gerer() {
        individu = new Individu();
    }

    public int getId_gite() {
        return id_gite;
    }

    public int getId_individu() {
        return id_individu;
    }

    public Individu getIndividu() {
        return individu;
    }

    public void setIndividu(Individu individu) {
        this.individu = individu;
    }
    
    
    
}
