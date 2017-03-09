/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Tarif;

/**
 *
 * @author 59013-52-15
 */
public class TarifDAO {
     public ArrayList<Tarif> getAll(){
            ArrayList<Tarif> list = new ArrayList<Tarif>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM TARIF");
            while (result.next()) {
                list.add(new Tarif(result.getInt(1), result.getFloat(2), result.getInt(3), result.getInt(4)));
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
