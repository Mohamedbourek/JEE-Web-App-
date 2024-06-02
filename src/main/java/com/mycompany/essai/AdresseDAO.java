/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.essai;

import com.mycompany.essai.Adresse;
import java.util.List;

public interface AdresseDAO {
    void ajouterAdresse(Adresse adresse , int carnetAdresseId);
    void supprimerAdresse(int id,int carnetAdresseId);
 List<Adresse> listerAdresses(int carnetAdresseId);    

}
