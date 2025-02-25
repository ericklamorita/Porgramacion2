/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.helper.pckg;

import app.model.pckg.Car;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class databaseHelper {

    Connection conn;

    public databaseHelper() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/PriceAutoSales", "root", "Admin$1234");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(databaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            //Logger.getLogger(databaseHelper.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public boolean validateLogin(String email, String pwd) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email = '" + email + "' AND pwd = '" + pwd + "' AND user_status = 1;";
            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                return true;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(databaseHelper.class.getName()).log(Level.ERROR, null, ex);
        }
        return false;
    }

    public ResultSet getCars() throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM cars;";
            ResultSet resultset = statement.executeQuery(sql);
            return resultset;
        } catch (SQLException ex) {
            //Logger.getLogger(databaseHelper.class.getName()).log(Level.ERROR, null, ex);
        }
        return null;
    }

     public ResultSet getbrands() throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM brands;";
            ResultSet resultset = statement.executeQuery(sql);
            return resultset;
        } catch (SQLException ex) {
            //Logger.getLogger(databaseHelper.class.getName()).log(Level.ERROR, null, ex);
        }
        return null;
                }
     
      public ResultSet getmodels() throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM models;";
            ResultSet models = statement.executeQuery(sql);
            return models;
        } catch (SQLException ex) {
            //Logger.getLogger(databaseHelper.class.getName()).log(Level.ERROR, null, ex);
        }
        return null;
                }
     
     
     
    public ResultSet getfueltype() throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM fueltype;";
            ResultSet fueltype = statement.executeQuery(sql);
            return fueltype;
        } catch (SQLException ex) {
            //Logger.getLogger(databaseHelper.class.getName()).log(Level.ERROR, null, ex);
        }
        return null;
                }
   
     
     
     
    public boolean saveCar(Car car) throws SQLException {
        try {
            //otra forma
            PreparedStatement predStatement = 
            conn.prepareStatement("INSERT INTO cars (brand, model, man_year, color, cc_engine, fuelType, mileage, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            
            predStatement.setString(1, car.Brand);
            predStatement.setString(2, car.Model);
            predStatement.setInt(3, car.Year);
            predStatement.setString(4, car.Color);
            predStatement.setString(5, car.Engine);
            predStatement.setString(6, car.FuelType);
            predStatement.setInt(7, car.Mileage);
            predStatement.setString(8, "");
            
            predStatement.executeUpdate();    
            
            return true;
            
        } catch (SQLException ex) {
            //Logger.getLogger(databaseHelper.class.getName()).log(Level.ERROR, null, ex);
            return false;
        }        
    }
}
