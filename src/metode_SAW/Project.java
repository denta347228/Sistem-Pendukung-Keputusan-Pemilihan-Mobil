/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode_SAW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hafizh Shafwan Rafa
 */
public class Project {
private Connection koneksi;
public Connection getKoneksi (){
        
        try {
           Class.forName("com.mysql.jdbc.Driver"); 
        }
        catch (ClassNotFoundException ex){
            
        }
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/car_evaluation1","root","");
            if (koneksi != null) {
                System.out.println("Berhasil koneksi");
            }
        }
        catch(SQLException ex){
            System.out.println("Koneksi gagal");
        }
     return koneksi;
        }
 
 
    public static void main(String[] args) {
         Project c = new Project ();
        Connection koneksi = c.getKoneksi();
    }
}
