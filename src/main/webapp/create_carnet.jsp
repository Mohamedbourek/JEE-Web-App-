<%-- 
    Document   : create_carnet.jsp
    Created on : 24 mars 2024, 18:40:37
    Author     : NTIC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.essai.CarnetDAO" %>
<%@ page import="com.mycompany.essai.CarnetDAOImpl" %>

<%
    String nomCarnet = request.getParameter("nomCarnet");
    CarnetDAO carnetDAO = new CarnetDAOImpl();
    carnetDAO.créerCarnet(nomCarnet); 
    response.sendRedirect("index.jsp"); 
%>

