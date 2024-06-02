/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.essai;

import com.mycompany.essai.Personne;
import com.mycompany.essai.PersonneDAO;
import com.mycompany.essai.PersonneDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/Personne")
public class PersonneServlet extends HttpServlet {
    private PersonneDAO personneDAO;

    public void init() throws ServletException {
        personneDAO = new PersonneDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ajouter":
                    ajouterPersonne(request, response);
                    break;
                case "supprimer":
                    supprimerPersonne(request, response);
                    break;
                default:
            }
        } else {
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void ajouterPersonne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Personne personne = new Personne();
         personne.setNom(request.getParameter("nom"));
        
        personneDAO.ajouterPersonne(personne);
        
        response.sendRedirect(request.getContextPath() + "/personne");
    }

    private void supprimerPersonne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
      //  Personne personne = new Personne(nom);
      //  personneDAO.supprimerPersonne(personne);
        
        response.sendRedirect(request.getContextPath() + "/personne");
    }

   

    
}
