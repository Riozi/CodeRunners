/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Horaire_dispo;


/**
 *
 * @author 59013-52-15
 */
public class Horaire_dispoDAO {
    
      public ArrayList<Horaire_dispo> getAll(){
            ArrayList<Horaire_dispo> list = new ArrayList<Horaire_dispo>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM HORAIRE_DISPO");
            while (result.next()) {
                list.add(new Horaire_dispo(result.getInt(1), result.getInt(2), result.getInt(3)));
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
