<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.essai.Adresse" %>
<%@ page import="com.mycompany.essai.AdresseDAOImpl" %>
<%@ page import="com.mycompany.essai.AdresseDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Vue du carnet d'adresses</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 800px;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h1, h2 {
                color: #333;
                text-align: center;
            }

            .back-link {
                display: block;
                text-align: center;
                margin-bottom: 20px;
                text-decoration: none;
                color: #4caf50;
                transition: color 0.3s;
            }

            .back-link:hover {
                color: #45a049;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                padding: 10px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #f2f2f2;
                color: #333;
            }

            .btn {
                background-color: #4caf50;
                text-align: center;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                text-decoration: none;
                display: inline-block;
                transition: background-color 0.3s;
            }

            .btn:hover {
                background-color: #45a049;
            }
            .link {
                color: #4caf50;
                text-decoration: none;
                transition: color 0.3s;
            }

            .link:hover {
                color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Vue du carnet d'adresses</h1>
            <%
                int carnetAdresseId = Integer.parseInt(request.getParameter("IdCarnet"));
                AdresseDAO adresseDAO = new AdresseDAOImpl();
                List<Adresse> adresses = adresseDAO.listerAdresses(carnetAdresseId);
            %>

            <h2>Liste des adresses :</h2>
            <a href="ajouterAdresse.jsp?IdCarnet=<%= carnetAdresseId %>"><button class="btn">Ajouter une nouvelle adresse</button></a>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Nom de rue</th>
                    <th>Numéro de rue</th>
                    <th>Ville</th>
                    <th>Nom Personne</th>
                    <th>Action</th>
                </tr>
                <% for (Adresse adresse : adresses) { %>
                <tr>
                    <td><%= adresse.getId() %></td>
                    <td><%= adresse.getNomRue() %></td>
                    <td><%= adresse.getNumeroRue() %></td>
                    <td><%= adresse.getVille() %></td>
                    <td><%= adresse.getNomPersonne() %></td>
                    <td>
                        <form action="adresse" method="POST"> 
                            <input type="hidden" name="adresseId" value="<%= adresse.getId() %>" /> 
                            <input type="hidden" name="IdCarnet" value="<%= carnetAdresseId %>" /> 
                            <input type="hidden" name="action"  value="supprimer">
                            <input type="submit" class="btn" value="Supprimer" />
                        </form>
                    </td>
                </tr>
                <% } %>
            </table>
            <a href="index.jsp" class="back-link">Retour à la liste des carnets</a>
        </div>
    </body>
</html>
