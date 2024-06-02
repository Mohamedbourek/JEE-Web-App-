/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.essai;

import com.mycompany.essai.Adresse;
import com.mycompany.essai.AdresseDAO;
import com.mycompany.essai.AdresseDAOImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/adresse")
public class AdresseServlet extends HttpServlet {
    private AdresseDAO adresseDAO;

    public void init() throws ServletException {
        adresseDAO = new AdresseDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ajouter":
                    ajouterAdresse(request, response);
                    break;
                case "supprimer":
                    supprimerAdresse(request, response);
                    break;
                default:
            }
        } 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }

    private void ajouterAdresse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int carnetAdresseId = Integer.parseInt(request.getParameter("IdCarnet"));
        Adresse adresse = new Adresse();
        adresse.setNomRue(request.getParameter("nomRue"));
        adresse.setNumeroRue(Integer.parseInt(request.getParameter("numeroRue")));
        adresse.setVille(request.getParameter("ville"));
        adresse.setNomPersonne(request.getParameter("nomPersonne"));
        
        
        adresseDAO.ajouterAdresse(adresse,carnetAdresseId);
        
        request.getRequestDispatcher("view_carnet.jsp").forward(request, response);
    }

    private void supprimerAdresse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        int AdresseId = Integer.parseInt(request.getParameter("adresseId"));
         int carnetAdresseId = Integer.parseInt(request.getParameter("IdCarnet"));
        adresseDAO.supprimerAdresse(AdresseId,carnetAdresseId);
        request.getRequestDispatcher("view_carnet.jsp").forward(request, response);
    }

    private void afficherListeAdresses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carnetAdresseId = Integer.parseInt(request.getParameter("IdCarnet"));
         System.out.println("ID Carnet d'adresse : " + carnetAdresseId);
        List<Adresse> adresses = adresseDAO.listerAdresses(carnetAdresseId);
        request.setAttribute("adresses", adresses);
        request.getRequestDispatcher("view_carnet.jsp").forward(request, response);
    }

  
}
