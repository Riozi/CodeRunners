/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Coordonnee;

/**
 *
 * @author 59013-52-15
 */
public class CoordonneeDAO {
     
    public ArrayList<Coordonnee> getAll(){
            ArrayList<Coordonnee> list = new ArrayList<Coordonnee>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM COORDONNEE");
            while (result.next()) {
                list.add(new Coordonnee(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4)));
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
