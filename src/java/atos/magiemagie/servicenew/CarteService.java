/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.servicenew;

import atos.magiemagie.Carte;

import atos.magiemagie.Joueur;
import atos.magiemagie.dao.CarteDAO;
import atos.magiemagie.dao.JoueurDAO;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Administrateur
 */
public class CarteService {
    
    private JoueurDAO joueurDao =new JoueurDAO();
    private CarteDAO dao = new CarteDAO();

    public List<Carte> listerCartesParJoueurId(long joueurId) {

        return dao.listerCartesParJoueurId(joueurId);

    }

    public void changerProprietaire(long idNouveauProprietaire, long idCarte) {
        //on récupère la carte avec l'id
        Carte c=dao.rechercherCarteParSOnId(idCarte);

        //recupere le nouveau proprio par son  id 
        Joueur joueur = joueurDao.rechercherParID(idNouveauProprietaire);
        
        //on change le proprietaire de cette carte
        c.setJoueur(joueur);
        joueur.getCartes().add(c);
 
        
        //on met a jour la carte a l'aide du dao
        dao.modifier(c);

       
    }

    public long carteIdAleatoireChezUnJoueur(long idJoueur) {
        //on recupere les cartes du joueur
        List<Carte> cartes= dao.listerCartesParJoueurId(idJoueur);
        
        //on prend une carte aleatoire parmis ses cartes
       int indice = cartes.size();
       Random r = new Random();
        int indiceAleatoire = r.nextInt(indice);
        Carte c = cartes.get(indiceAleatoire);
       
        //on renvoie son id
        
        long idCarte = c.getId() ;
        
        return idCarte;
    }

    public void modifier(Carte carteAPrendre) {
        dao.modifier(carteAPrendre);
    }

}
