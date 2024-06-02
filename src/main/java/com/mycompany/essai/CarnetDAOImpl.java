/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.essai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CarnetDAOImpl implements CarnetDAO {

    private Connection connexion;

    public CarnetDAOImpl() {
        connexion = ConnexionBD.getInstance().getConnection();
    }
    @Override
    public void créerCarnet(String nom) {
        try (PreparedStatement statement = connexion.prepareStatement("INSERT INTO carnet_adresse (nom) VALUES (?)")) {
            statement.setString(1, nom);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Carnet> listerCarnets() {
         List<Carnet> carnets = new ArrayList<>();
        try (Statement statement = connexion.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM carnet_adresse");
            while (resultSet.next()) {
                Carnet carnet = new Carnet();
                carnet.setId(resultSet.getInt("id"));
                carnet.setNom(resultSet.getString("nom"));
                carnets.add(carnet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carnets;
    }
}
