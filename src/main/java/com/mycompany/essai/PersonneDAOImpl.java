/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.essai;

import com.mycompany.essai.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneDAOImpl implements PersonneDAO {

    private Connection connexion;

    public PersonneDAOImpl() {
        connexion = ConnexionBD.getInstance().getConnection();
    }

    @Override
    public void ajouterPersonne(Personne personne) {
        String sql = "INSERT INTO personne (nom) VALUES (?)";
        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setString(1, personne.getNom());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerPersonne(Personne personne) {
        String sql = "DELETE FROM personne WHERE nom = ?";
        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setString(1, personne.getNom());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

   

    
}
