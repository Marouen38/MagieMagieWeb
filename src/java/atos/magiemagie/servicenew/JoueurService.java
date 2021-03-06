/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.servicenew;

import atos.magiemagie.Carte;
import atos.magiemagie.Joueur;
import atos.magiemagie.Partie;
import atos.magiemagie.dao.CarteDAO;
import atos.magiemagie.dao.JoueurDAO;
import atos.magiemagie.dao.PartieDAO;
import java.util.List;
import java.util.Random;



public class JoueurService {
    
    

    private JoueurDAO daojoueur = new JoueurDAO();
    private PartieDAO daopartie = new PartieDAO();
    private CarteDAO daocarte = new CarteDAO();
    
    
    
    public List<Joueur>  listerAutresJoueurDePartie(long joueurId,long partieId){
        
        
        return daojoueur.listerAutresJoueurDePartie(joueurId,partieId);
        
    } 

    public Joueur rejoindrePartie(String pseudo, String avatar, long idPartie) {
        //recherche si le joueur existe déjà
        Joueur joueur = daojoueur.rechercherParPseudo(pseudo);

        if (joueur == null) {
            //le joueur n'existe pas 
            joueur = new Joueur();
            joueur.setPseudo(pseudo);

        }
        joueur.setAvatar(avatar);
        joueur.setEtat(Joueur.EtatJoueur.N_A_PAS_LA_MAIN);
        joueur.setOdre(daopartie.ordreSuivant(idPartie));
        //Associe le joueur à la partie et vice versa(JPA relations bidirectionnels
        Partie partie = daopartie.rechercherParId(idPartie);
        joueur.setPartie(partie);
        List<Joueur> listeJoueurs = partie.getJoueurs();
        listeJoueurs.add(joueur);
        if (joueur.getId() == null) {//nouveau
            daojoueur.ajouter(joueur);
        } else { //existe déjà
            daojoueur.modifier(joueur);

        }
        return joueur;
    }

    public void demarerPartie(long idPartie) {

        //recherche la partie par son Id
        Partie p = daopartie.rechercherParId(idPartie);

        //declencher un erreur s'il y'a moin de deux joueur
        /*
        if (p.getJoueurs().size() < 2) {
            throw new RuntimeException("la partie ne peut pas etre demmarer");
        }*/
        //passer le joueur d'odre 0 a l'etat A_LA_MAIN
        Joueur j = daojoueur.rechercherJOueurOrdre0ParPartieId(idPartie);
        j.setEtat(Joueur.EtatJoueur.A_LA_MAIN);
        daojoueur.modifier(j);

        //donner 7 cartes au hazard a chaque joueur
        for (Joueur jboucle : daopartie.listerJoueurs(idPartie)) {
            for (int i = 0; i < 7; i++) {
                ajouterCarte(jboucle, randomCarte());
            }

        }

    }

    public void piocherCarte(long idJoueur) {
        ajouterCarte(daojoueur.rechercherParID(idJoueur), randomCarte());

    }

    public boolean joueurALesCartes(long idJoueur, Carte.TypeCarte type1, Carte.TypeCarte type2) {
        return daocarte.joueurAlesCartes(idJoueur, type1, type2);
    }

    public  Carte randomCarte() {

        Carte.TypeCarte[] tabTypesCartes = Carte.TypeCarte.values();

        Random r = new Random();
        int n = r.nextInt(tabTypesCartes.length);
        Carte c = new Carte();
        c.setTypeCarte(tabTypesCartes[n]);

        return c;

    }

    private void ajouterCarte(Joueur j, Carte c) {
        c.setJoueur(j);

        daocarte.ajouterCarte(c);

    }

    public Joueur joueurQuiALaMain(long idPartie) {
        return daojoueur.recupereJoueurALaMAin(idPartie);
    }

    public List<Joueur> listerJoueur(long idPartie) {
        return daopartie.listerJoueurs(idPartie);
    }

    public Joueur rechercherParId(long cibleId) {

        return daojoueur.rechercherParID(cibleId);

    }
    public Joueur ajouterJoueur(String pseudo,String avatar){
        Joueur joueur = new Joueur();
        joueur.setAvatar(avatar);
        joueur.setPseudo(pseudo);
        daojoueur.ajouter(joueur);
        
        return joueur;
    }
    public void ajouterPartieIdAJoueur(Joueur joueur, long partieId){
        //recupere la partie via l'ID
        Partie partie = daopartie.rechercherParId(partieId);
        //ajoute la partie au joueur
        joueur.setPartie(partie);
        //enrejister les modifications
        daojoueur.modifier(joueur);
        
    }
}


