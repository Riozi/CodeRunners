/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Periode_dispo;


/**
 *
 * @author 59013-52-15
 */
public class Periode_dispoDAO {
    
     public ArrayList<Periode_dispo> getAll(){
            ArrayList<Periode_dispo> list = new ArrayList<Periode_dispo>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM PERIODE_DISPO");
            while (result.next()) {
                list.add(new Periode_dispo(result.getInt(1), result.getString(2), result.getString(3)));
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
