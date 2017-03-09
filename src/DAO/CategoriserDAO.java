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

/**
 *
 * @author 59013-52-15
 */
public class CategoriserDAO {
   
    public ArrayList<Categoriser> getAll(){
            ArrayList<Categoriser> list = new ArrayList<Categoriser>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM CATEGORISER");
            while (result.next()) {
                list.add(new Categoriser(result.getInt(1), result.getInt(2)));
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
