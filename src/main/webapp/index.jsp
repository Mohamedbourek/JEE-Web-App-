<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.essai.CarnetDAO" %>
<%@ page import="com.mycompany.essai.CarnetDAOImpl"%>
<%@ page import="com.mycompany.essai.Carnet"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Carnets d'Adresses</title>
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

        form {
            margin-bottom: 20px;
        }

        input[type="text"], input[type="submit"] {
            padding: 10px;
            margin-bottom: 10px;
            width: 100%;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .card {
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 15px;
            margin-bottom: 20px;
            background-color: #fff;
        }

        .card a {
            text-decoration: none;
            color: #333;
        }

        .card:hover {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Gestion des Carnets d'Adresses</h1>

        <h2>Créer un Nouveau Carnet d'Adresses</h2>
        <form action="create_carnet.jsp" method="post">
            <label for="nomCarnet">Nom du Carnet:</label>
            <input type="text" id="nomCarnet" name="nomCarnet" required>
            <input type="submit" value="Créer Carnet">
        </form>

        <h2>Liste des Carnets d'Adresses</h2>
        <% 
            CarnetDAO carnetDAO = new CarnetDAOImpl();
            List<Carnet> carnets = carnetDAO.listerCarnets(); 
            for (Carnet carnet : carnets) { 
        %>
            <div class="card">
                <h3><a href="view_carnet.jsp?IdCarnet=<%=carnet.getId()%>"><%=carnet.getNom()%></a></h3>
            </div>
        <% } %>
    </div>
</body>
</html>
