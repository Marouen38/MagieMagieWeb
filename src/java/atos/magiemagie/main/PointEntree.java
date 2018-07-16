/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.main;

import atos.magiemagie.Carte;
import atos.magiemagie.Joueur;
//import static atos.magiemagie.Joueur.pseudo;
import atos.magiemagie.Partie;
import atos.magiemagie.servicenew.CarteService;
import atos.magiemagie.servicenew.JoueurService;
import atos.magiemagie.servicenew.PartieService;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrateur
 */
public class PointEntree {

    private PartieService partieService = new PartieService();
    private JoueurService joueurService = new JoueurService();
    private CarteService carteService = new CarteService();

    Scanner scan = new Scanner(System.in);

    public void menuPrincipale() {

        String choix;
        do {
            System.out.println("menu principale(");
            System.out.println("------------");
            System.out.println("1.lister les partiesnom demarrées");
            System.out.println("2.créer une partie");
            System.out.println("3.rejoindre parties");
            System.out.println("4.demmarer parties");
            System.out.println("Q.quitter");
            System.out.print("votre choix>");

            choix = scan.nextLine();

            switch (choix) {
                case "1":
                    List<Partie> parties = partieService.listerPartieNonDemarees();
                    System.out.println("-----------------");
                    System.out.println("Liste des parties");
                    for (Partie p : parties) {
                        System.out.println(p.getNom() + " " + p.getId());
                    }
                    System.out.println("-----------------");
                    break;
                case "2":
                    System.out.print("veuillez aficher le nom  de la pertie à creer:");
                    String nomLaPartie = scan.nextLine();
                    partieService.creerNouvellePartie(nomLaPartie);

                    break;
                case "3":
                    System.out.print("veuillez citer  la partie à rejoindre:");
                    long numLaPartie = Long.valueOf(scan.nextLine());
                    System.out.println("veuillez entrez votre pseudo");
                    String nomJoueur = scan.nextLine();
                    joueurService.rejoindrePartie(nomJoueur, "avatar", numLaPartie);
//                    ecranJeu(numLaPartie,pseudo);
                    break;

                case "4":
                    System.out.println("veuillez afficher la partie à demmarer");
                    long numLaPartieADemmarer = Long.valueOf(scan.nextLine());
                    joueurService.demarerPartie(numLaPartieADemmarer);
                    jeuDemarre(numLaPartieADemmarer);
                    break;
                case "Q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix inconnue");

            }
        } while (!choix.equals("Q"));

        //Object nextElement = choix.nextElement();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PointEntree m = new PointEntree();
        m.menuPrincipale();

    }
    

    private long choisirVictime(long idPartie) {

        List<Joueur> joueurs = joueurService.listerJoueur(idPartie);
        for (Joueur j : joueurs) {
            System.out.println("veuillez aficher l'id de joueur");

        }
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        return Long.parseLong(s);

    }
    
    
    
    

    private void jeuDemarre(long idpartie) {
        Scanner scan = new Scanner(System.in);
        String sc ;
        long idVictime;
        long cibleId; 
        while (true) {
            Joueur joueurMain = joueurService.joueurQuiALaMain(idpartie);
            List<Carte> cartes = carteService.listerCartesParJoueurId(joueurMain.getId());
            System.out.println("Les cartes de " + joueurMain.getPseudo());

            for (Carte c : cartes) {
                System.out.println(c.getTypeCarte());
            }
            System.out.println("");
            System.out.println("1.selectionner les cartes");
            System.out.println("2.passer son tour");
            System.out.println("Q- Quit");
            String choix = scan.nextLine();
            switch (choix) {
                case "1":
                    System.out.println("quelle sort voulez vous lancer");
                    System.out.println("1.invisiblilité");
                    System.out.println("2.philtre d'amour");
                    System.out.println("3.hypnose");
                    System.out.println("4.divination");
                    System.out.println("5.sommeil-profond");
                    choix = scan.nextLine();
                    switch (choix) {
                        case "1":

                            //lancer invisibilité
                            partieService.sortInvisibilite(joueurMain, idpartie);
                            break;

                        case "2":

                            //lancer philtre d'amour
                            System.out.println("Choisissez votre cible:");

                            // Afficher ici ts joueurs
                            sc = scan.nextLine();
                            cibleId = Long.parseLong(sc);
                            partieService.sortPhiltreDAmour(joueurMain, cibleId);
                            break;

                        case "3":

                            //lancer hyponose
//                            scan = new Scanner(System.in);
                            sc = scan.nextLine();
                            idVictime= Long.parseLong(sc);
                            partieService.sortHypnose(idpartie, joueurMain, idVictime);
                            break;

                        case "4":

                            //lancer divination
                            partieService.sortDivination(joueurMain);
                            break;

                        case "5":
                            System.out.println("choisir votre victime");
                            //sommeil profond
                           
                           // scan = new Scanner(System.in);
                            sc = scan.nextLine();
                            idVictime = Long.parseLong(sc);
                            partieService.sortSommeilProfond(idVictime);

                            break;

                    }
                case "q":
                    return;
            }

        }
    }

}
