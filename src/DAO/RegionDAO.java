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
import metier.Region;

/**
 *
 * @author 59013-52-01
 */
public class RegionDAO {
            
        public ArrayList<Region> getAll(){
            ArrayList<Region> list = new ArrayList<Region>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM REGION");
            while (result.next()) {
                list.add(new Region(result.getInt(1), result.getString(2)));
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
