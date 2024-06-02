<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une adresse - Carnet d'adresses</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 500px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Ajouter une adresse</h1>
        <form action="adresse" method="POST">
            <label for="nomRue">Nom de la rue :</label>
            <input type="text" id="nomRue" name="nomRue">
            <label for="numeroRue">Numéro de la rue :</label>
            <input type="text" id="numeroRue" name="numeroRue">
            <label for="ville">Ville :</label>
            <input type="text" id="ville" name="ville">
            <label for="nomPersonne">Nom de la personne :</label>
            <input type="text" id="nomPersonne" name="nomPersonne">
            <input type="hidden" name="IdCarnet" value="<%= request.getParameter("IdCarnet") %>">
            <input type="hidden" name="action" value="ajouter">
            <input type="submit" value="Ajouter">
        </form>
    </div>
</body>
</html>
