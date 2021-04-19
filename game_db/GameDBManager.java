/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rhys Van Rooyen, Student ID: 19049569
 */
public class GameDBManager {

    private final static String GAME_DB_USERNAME = "pdc";
    private final static String GAME_DB_PASSWORD = "pdc";
    private final static String DB_URL = "jdbc:derby://localhost:1527/WhoWantsToBeAMillionaireDB; create=true";
    private static Connection dbConnection;

    public GameDBManager() {
    }

    public static void connectToDB() {
        try {
            dbConnection = DriverManager.getConnection(DB_URL, GAME_DB_PASSWORD, GAME_DB_USERNAME);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public static void disconnectFromDB() {
        if(dbConnection == null) {
            return;
        }
        
        try {
            dbConnection.close();
        } catch(SQLException e) {
            System.err.println(e);
        }
    }
}