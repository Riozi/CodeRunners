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
public class Dependre {
    
    private int id_tarif;
    private int id_gite;
    private int id_periode_tarif;
    private Periode_tarif periode_tarif;
    private Tarif tarif;

    public Dependre(int id_tarif, int id_gite, int id_periode_tarif) {
        this.id_tarif = id_tarif;
        this.id_gite = id_gite;
        this.id_periode_tarif = id_periode_tarif;
        periode_tarif = new Periode_tarif();
        tarif = new Tarif();
    }
    
    public Dependre() {
        periode_tarif = new Periode_tarif();
        tarif = new Tarif();
    }

    public int getId_tarif() {
        return id_tarif;
    }

    public int getId_gite() {
        return id_gite;
    }

    public int getId_periode_tarif() {
        return id_periode_tarif;
    }
    
    public Periode_tarif getPeriode_tarif() {
        return periode_tarif;
    }
    
    public void setPeriode_tarif(Periode_tarif periode_tarif){
        this.periode_tarif = periode_tarif;
    }
    
    public void setTarif(Tarif tarif){
        this.tarif = tarif;
    }

    public Tarif getTarif() {
        return tarif;
    }
    
     
     
     
    
    
}
