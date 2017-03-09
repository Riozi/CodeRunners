/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Connect;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import metier.Commune;

/**
 *
 * @author 59013-52-01
 */
public class CommuneDAO {
     
    public ArrayList<Commune> getAll(){
            ArrayList<Commune> list = new ArrayList<Commune>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM COMMUNE");
            while (result.next()) {
                list.add(new Commune(result.getInt(1), result.getString(2), result.getFloat(3), result.getFloat(4), result.getInt(5), result.getString(6)));
            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return list;
        }
    
    public ArrayList<Commune> getAllCommuneRegion(int id){
            ArrayList<Commune> list = new ArrayList<Commune>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT code_insee, nom_commune, latitude, longitude, code_postal, COMMUNE.id_departement FROM COMMUNE JOIN"
                    + " DEPARTEMENT ON COMMUNE.id_departement = DEPARTEMENT.id_departement where id_region = " + id);
            while (result.next()) {
                list.add(new Commune(result.getInt(1), result.getString(2), result.getFloat(3), result.getFloat(4), result.getInt(5), result.getString(6)));
            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return list;
        }
    
    public ArrayList<Commune> getAllCommuneDepartement(String id){
            ArrayList<Commune> list = new ArrayList<Commune>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT code_insee, nom_commune, latitude, longitude, code_postal, COMMUNE.id_departement FROM COMMUNE JOIN "
                    + "DEPARTEMENT ON COMMUNE.id_departement = DEPARTEMENT.id_departement where COMMUNE.id_departement = '" + id + "'");
            while (result.next()) {
                list.add(new Commune(result.getInt(1), result.getString(2), result.getFloat(3), result.getFloat(4), result.getInt(5), result.getString(6)));
            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return list;
        }
    
    
}
