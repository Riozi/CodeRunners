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
import metier.Departement;

/**
 *
 * @author 59013-52-01
 */
public class DepartementDAO {
    
    public ArrayList<Departement> getAll(){
            ArrayList<Departement> list = new ArrayList<Departement>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM DEPARTEMENT");
            while (result.next()) {
                list.add(new Departement(result.getString(1), result.getString(2), result.getInt(3)));
            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return list;
        }
    
   public ArrayList<Departement> getAllRegion(int id){
            ArrayList<Departement> list = new ArrayList<Departement>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM DEPARTEMENT where id_region = " + id);
            while (result.next()) {
                list.add(new Departement(result.getString(1), result.getString(2), result.getInt(3)));
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
