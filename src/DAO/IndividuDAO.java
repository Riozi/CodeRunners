/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Individu;


/**
 *
 * @author 59013-52-15
 */
public class IndividuDAO {
    public ArrayList<Individu> getAll(){
            ArrayList<Individu> list = new ArrayList<Individu>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM INDIVIDU");
            while (result.next()) {
                list.add(new Individu(result.getInt(1), result.getString(2), result.getString(3)));
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
