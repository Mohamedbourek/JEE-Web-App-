package com.mycompany.essai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/carnet_adresse";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "";
    
    private static ConnexionBD instance;
    private Connection connexion;
    
    private ConnexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static ConnexionBD getInstance() {
        if (instance == null) {
            instance = new ConnexionBD();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connexion;
    }
}
