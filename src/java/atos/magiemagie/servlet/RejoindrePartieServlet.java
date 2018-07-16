/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.servlet;

import atos.magiemagie.Joueur;
import atos.magiemagie.servicenew.JoueurService;
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
@WebServlet(name = "RejoindrePartie", urlPatterns = {"/rejoindre-partie"})
public class RejoindrePartieServlet extends HttpServlet {

    private JoueurService service = new JoueurService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("rejoindre-Partie.jsp").forward(req, resp);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idPartie = Long.parseLong(req.getParameter("rejoindrePartie"));
        long idJoueur = (long) req.getSession().getAttribute("JoueurID");

     Joueur joueur = service.rechercherParId(idJoueur);
     
    }
    
}
