<%-- 
    Document   : _TEMPLATE
    Created on : 13 juil. 2018, 12:34:26
    Author     : Administrateur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="style.jsp"/>
</head>
<body class="pagination-centered">    
        <div id="container">
        <c:import url="creer-Partie.jsp"/>
        <c:import url="lister-Partie.jsp"/>
        <div id="contenu">PAGE D'ACCEUIL</div>
        <c:import url="partie.jsp"/>
        <c:import url="rejoindre-Partie.jsp"/>
        <c:import url="_JS.jsp"/>
    </div>
</body>
</html>
