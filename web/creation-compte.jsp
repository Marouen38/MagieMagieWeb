<%-- 
    Document   : creation-compte
    Created on : 13 juil. 2018, 15:28:32
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    </head>
    <body>
        <h1>formulaire d'inscription</h1>
        <form method="post">
  <div class="form-group">
    <label for="exampleFormControlFile1">choisir votre pseudo</label>
    <input type="text" class="form-control-file" name='pseusdo' id="exampleFormControlFile1">
  </div>
           <div class="form-group">
    <label for="exampleFormControlFile1">choisir votre avatar</label>
    <input type="file" class="form-control-file" id="exampleFormControlFile1">
  </div>

        <button type="submit" class="btn btn-primary">confirmer</button>
        </form>     
    </body>
</html>
