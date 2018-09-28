<%-- 
    Document   : lista-pacientes
    Created on : 27/09/2018, 21:02:09
    Author     : Yury Cavalcante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, senacpi.hospitaltades.dao.*, senacpi.hospitaltades.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacientes</title>
    </head>
    <%
    List<Paciente> pacientes = (List<Paciente>) request.getAttribute("PACIENTES");
    %>
    <body>
        <%= pacientes %>
    </body>
</html>
