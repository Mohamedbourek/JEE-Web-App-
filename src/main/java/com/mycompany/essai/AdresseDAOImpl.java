/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.essai;
import com.mycompany.essai.Adresse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresseDAOImpl implements AdresseDAO {

    private Connection connexion;

    public AdresseDAOImpl() {
        connexion = ConnexionBD.getInstance().getConnection();
    }

    @Override
    public void ajouterAdresse(Adresse adresse , int carnetAdresseId) {
        String sql = "INSERT INTO adresse (nom_rue, numero_rue, ville, personne_nom,carnet_adresse_id) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setString(1, adresse.getNomRue());
            statement.setInt(2, adresse.getNumeroRue());
            statement.setString(3, adresse.getVille());
            statement.setString(4, adresse.getNomPersonne());
             statement.setInt(5, carnetAdresseId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception
        }
    }

    @Override
    public void supprimerAdresse(int id,int carnetAdresseId) {
    String sql = "DELETE FROM adresse WHERE id = ? AND carnet_adresse_id = ? ";
    try (PreparedStatement statement = connexion.prepareStatement(sql)) {
        statement.setInt(1, id); 
        statement.setInt(2, carnetAdresseId);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


   
    @Override
    public List<Adresse> listerAdresses(int carnetAdresseId) {
        List<Adresse> adresses = new ArrayList<>();
        String query = "SELECT * FROM adresse WHERE carnet_adresse_id = ?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(query)) {
            preparedStatement.setInt(1, carnetAdresseId);
            System.out.println("query: " +query);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Adresse adresse = new Adresse();
                    adresse.setId(resultSet.getInt("id"));
                    adresse.setNomRue(resultSet.getString("nom_rue"));
                    adresse.setNumeroRue(resultSet.getInt("numero_rue"));
                    adresse.setVille(resultSet.getString("ville"));
                    adresse.setNomPersonne(resultSet.getString("personne_nom"));
                    adresses.add(adresse);
                    
                }
            }
           System.out.println("Adresses : "+adresses);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adresses;
    }

    

   
}
