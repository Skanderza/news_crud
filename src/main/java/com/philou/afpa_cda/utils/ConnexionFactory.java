package com.philou.afpa_cda.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author philou
 */
public class ConnexionFactory {
    
    private String dbUrl;
    private String dbUser;
    private String dbPass;
     
    public Connection getConnexion(){
        
        Connection maConnexion = null;

        try {
            maConnexion = DriverManager.getConnection(getDbUrl(), getDbUser(), getDbPass());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return maConnexion;
        
    } 
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * @return the dbUrl
     */
    public String getDbUrl() {
        return dbUrl;
    }

    /**
     * @param dbUrl the dbUrl to set
     */
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    /**
     * @return the dbUser
     */
    public String getDbUser() {
        return dbUser;
    }

    /**
     * @param dbUser the dbUser to set
     */
    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    /**
     * @return the dbPass
     */
    public String getDbPass() {
        return dbPass;
    }

    /**
     * @param dbPass the dbPass to set
     */
    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }
    
}
