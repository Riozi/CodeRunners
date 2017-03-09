/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Type_individu;

/**
 *
 * @author 59013-52-15
 */
public class Type_individuDAO {
     public ArrayList<Type_individu> getAll(){
            ArrayList<Type_individu> list = new ArrayList<Type_individu>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM TYPE_INDIVIDU");
            while (result.next()) {
                list.add(new Type_individu(result.getInt(1), result.getString(2)));
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
