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
import metier.Service;

/**
 *
 * @author 59013-52-01
 */
public class ServiceDAO {
    
                
        public ArrayList<Service> getAll(){
            ArrayList<Service> list = new ArrayList<Service>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT id_service, id_type_service, nom_service  FROM SERVICE");
            while (result.next()) {
                list.add(new Service(result.getInt(1), result.getInt(2), result.getString(3)));
            }
            result.close();
            stm.close();
            connection.getConnection().close();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return list;
        }
        
        public ArrayList<Service> getServiceGite(int idGite){
            ArrayList<Service> list = new ArrayList<Service>();
        try {
            Connect connection = new Connect();
            Statement stm = connection.getConnection().createStatement();
            ResultSet result = stm.executeQuery("SELECT nom_service FROM SERVICE JOIN POSSEDER ON SERVICE.id_service = POSSEDER.id_service JOIN "
                    + "GITE ON POSSEDER.id_gite = GITE.id_gite WHERE GITE.id_gite = '" + idGite + "'");
            while (result.next()) {
                Service service = new Service();
                service.setNom_service(result.getString(1));
                list.add(service);
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
