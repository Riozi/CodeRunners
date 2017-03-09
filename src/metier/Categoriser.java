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
public class Categoriser {
    
    private int id_type_individu;
    private int id_individu;
    private Type_individu type_individu;

    public Categoriser(int id_type_individu, int id_individu) {
        this.id_type_individu = id_type_individu;
        this.id_individu = id_individu;
        type_individu = new Type_individu();
    }

    public Categoriser() {
        type_individu = new Type_individu();
    }
    

    public int getId_type_individu() {
        return id_type_individu;
    }

    public int getId_individu() {
        return id_individu;
    }

    public Type_individu getType_individu() {
        return type_individu;
    }

    public void setType_individu(Type_individu type_individu) {
        this.type_individu = type_individu;
    }
    
}
