/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Categoriser;
import metier.Commune;
import metier.Departement;
import metier.Gerer;
import metier.Gite;
import metier.Individu;
import metier.Region;
import metier.Type_individu;

/**
 *
 * @author 59013-52-15
 */
public class GiteDAO {

    public ArrayList<Gite> getAll() {
        ArrayList<Gite> list = new ArrayList<Gite>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM GITE");
            while (result.next()) {
                list.add(new Gite(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getInt(6), result.getInt(7), result.getInt(8)));
            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return list;
    }

    public ArrayList<Gite> getLike() {
        ArrayList<Gite> liste = new ArrayList<Gite>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("exec dbo.sp_Afficher_Gite_Liste");
            while (result.next()) {
                Gite nouveauGite = new Gite(result.getInt(1), result.getString(2));

                nouveauGite.setCommune(new Commune());
                nouveauGite.getCommune().setNom_commune(result.getString(4));

                nouveauGite.getCommune().setDepartement(new Departement());
                nouveauGite.getCommune().getDepartement().setNom_departement(result.getString(5));
                nouveauGite.getCommune().getDepartement().setRegion(new Region());

                nouveauGite.getCommune().getDepartement().getRegion().setNom_region(result.getString(6));

                liste.add(nouveauGite);
            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public Gite getLike(int idGite) {
        Gite giteSelect = new Gite();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("exec dbo.sp_Afficher_Gite_Detail '" + idGite + "'");
            while (result.next()) {
                Gite nouveauGite = new Gite(result.getInt(1), result.getString(2), result.getString(3), result.getInt(7), result.getInt(8), result.getInt(9), result.getInt(10), result.getInt(11));

                nouveauGite.setCommune(new Commune());
                nouveauGite.getCommune().setNom_commune(result.getString(4));
                nouveauGite.getCommune().setDepartement(new Departement());
                nouveauGite.getCommune().getDepartement().setNom_departement(result.getString(5));
                nouveauGite.getCommune().getDepartement().setRegion(new Region());
                nouveauGite.getCommune().getDepartement().getRegion().setNom_region(result.getString(6));
                nouveauGite.setGerer(new Gerer());
                nouveauGite.getGerer().setIndividu(new Individu());
                nouveauGite.getGerer().getIndividu().setNom_individu(result.getString(13));
                nouveauGite.getGerer().getIndividu().setPrenomom_individu(result.getString(14));
                nouveauGite.getGerer().getIndividu().setCategoriser(new Categoriser());
                nouveauGite.getGerer().getIndividu().getCategoriser().setType_individu(new Type_individu());
                nouveauGite.getGerer().getIndividu().getCategoriser().getType_individu().setType_individu(result.getString(12));
                giteSelect = nouveauGite;

            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giteSelect;
    }

}
