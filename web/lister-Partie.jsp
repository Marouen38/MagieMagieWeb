<%-- 
    Document   : lister-Partie
    Created on : 13 juil. 2018, 12:00:05
    Author     : Administrateur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
    <head>
        <meta charset="utf-8"/>
        <title>Cv de Chloe</title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Fugaz+One" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css"/>

    </head>
    <body>
        <header>
            <div>
                <i class="fas fa-user user"></i>
                <h2 class="nameUser">Nom Prénom</h2>
                <h1><i class="fas fa-magic magicL"></i> Magie Magie <i class="fas fa-magic magicR"></i></h1>
                <h2 class="titleListPartie">LISTE DES PARTIES</h2>
            </div>
        </header>
        <div class="main">
            <a href="<c:url value="CreerPartie"></c:url>"><button class="btnCreeP">Créer partie</button></a>
            <ul class="listePartie">
                <c:forEach items="${liste}" var="partie">
                    <li class="partie">
                        <h3>${partie.nom}</h3>
                        <p>${partie.joueurs.size()}</p>
                        <a href="<c:url value="rejoindre-partie"></c:url>">
                            <button class="btnCree" name="rejoindrePartie" value="${partie.id}">Rejoindre</button>
                        </a>

                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>