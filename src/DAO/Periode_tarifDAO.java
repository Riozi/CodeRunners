/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Periode_tarif;


/**
 *
 * @author 59013-52-15
 */
public class Periode_tarifDAO {
    
    // BIG WARNING|BIG WARNING|BIG WARNING|BIG WARNING|BIG WARNING|BIG WARNING|BIG WARNING|BIG WARNING|BIG WARNING|
    
    public ArrayList<Periode_tarif> getAll(){
            ArrayList<Periode_tarif> list = new ArrayList<Periode_tarif>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM PERIODE_TARIF");
            while (result.next()) {
                list.add(new Periode_tarif(result.getInt(1), result.getString(2), result.getString(3)));
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
