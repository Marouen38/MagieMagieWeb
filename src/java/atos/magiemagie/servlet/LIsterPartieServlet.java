/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.servlet;

import atos.magiemagie.Partie;
import atos.magiemagie.servicenew.PartieService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "LIsterPartie", urlPatterns = {"/lister-partie"})
public class LIsterPartieServlet extends HttpServlet {

    private PartieService service = new PartieService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Partie> listes =service.listerPartieNonDemarees();
        req.setAttribute("liste", listes );
        req.getRequestDispatcher("lister-Partie.jsp").forward(req, resp);
   
        
    }

       
        
        
        

}
