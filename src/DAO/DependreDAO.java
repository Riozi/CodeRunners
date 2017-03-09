/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Dependre;
import metier.Periode_tarif;
import metier.Saison;
import metier.Tarif;


/**
 *
 * @author 59013-52-15
 */
public class DependreDAO {
    
      public ArrayList<Dependre> getAll(){
            ArrayList<Dependre> list = new ArrayList<Dependre>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM DEPENDRE");
            while (result.next()) {
                list.add(new Dependre(result.getInt(1), result.getInt(2), result.getInt(3)));
            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return list;
        }
      
      public ArrayList<Dependre> getAll(int idGite){
            ArrayList<Dependre> list = new ArrayList<Dependre>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("exec dbo.sp_Afficher_Gite_Periode_Tarif '" + idGite + "'" );
            while (result.next()) {
                Dependre periodeTarif = new Dependre();
                periodeTarif.setPeriode_tarif(new Periode_tarif());
                periodeTarif.getPeriode_tarif().setDate_debut(result.getString(3));
                periodeTarif.getPeriode_tarif().setDate_fin(result.getString(4));
                periodeTarif.setTarif(new Tarif());
                periodeTarif.getTarif().setMontant(result.getFloat(1));
                periodeTarif.getTarif().setSaison(new Saison());
                periodeTarif.getTarif().getSaison().setSaison(result.getString(2));
             
                list.add(periodeTarif);
            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        }
}
