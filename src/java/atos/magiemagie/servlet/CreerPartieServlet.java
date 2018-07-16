/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.servlet;

import atos.magiemagie.Partie_;
import atos.magiemagie.servicenew.PartieService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "CreerPartie", urlPatterns = {"/CreerPartie"})
public class CreerPartieServlet extends HttpServlet {

    private PartieService service = new PartieService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Creer-Partie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        //recuperer le nom de la partie
        String partie =req.getParameter("partieName");
         
        //creer la partie
        service.creerNouvellePartie(partie);
        
        //stocker l'ID de la partie en session 
        req.getSession().setAttribute("partie_id", Partie_.id);
        
        //renvoie la vue rejoindre partie
        resp.sendRedirect("rejoindre-Partie");
    
    }

 

}
