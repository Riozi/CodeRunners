/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Gerer;


/**
 *
 * @author 59013-52-15
 */
public class GererDAO {
    
      public ArrayList<Gerer> getAll(){
            ArrayList<Gerer> list = new ArrayList<Gerer>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM GERER");
            while (result.next()) {
                list.add(new Gerer(result.getInt(1), result.getInt(2)));
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
