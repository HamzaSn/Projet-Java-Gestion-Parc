package Main;

import Parcs.*;
import Véhicule.*;

import java.util.HashMap;
import java.util.Scanner;


/**
 * Ceci est une application qui assure la gestion d’une  agence de location de voitures.
 * cette classe App.java permet a l'utilisateur d'interagir avec l'application pour manipuler et gerer
 * les véhicules dans les parcs (ArrayList,HashSet) de l'agence.
 */

public class App {
    public static void main(String[] args) {
        // ArrayList
        Parc1 parc1 = new Parc1();
        // HashSet
        Parc2 parc2 = new Parc2();

        Scanner sc = new Scanner(System.in);
        String choix = "7";
        menu_principale:
        while (!choix.equals("q")) {

            if (choix.equals("7")) {
                System.out.println("Choisissez une option :");
                System.out.println("1 - Gestion du Parc de l’Agence (ArrayList)");
                System.out.println("2 - Gestion du Parc de l’Agence (HashSet)");
                System.out.println("q - Quitter");

                choix = sc.next();
            }

            if (choix.equals("1") || choix.equals("2")) { // si choix egale a 1 ou 2
                ParcDeBase parc = choix.equals("1") ? parc1 : parc2; // si choix 1 on utilise le parc1 , si 2 on utilise parc2
                System.out.println("\n----------------Type de liste de véhicules au parc : "+parc.listVéhicule.getClass().getName() + "---------------\n");
                System.out.println("Gestion du Parc de l’Agence(" + (choix.equals("1") ? "ArrayList" : "HashSet") + ")");
                System.out.println("3 - Ajouter nouvelle véhicule :");
                System.out.println("4 - Modifier état de véhicule :");
                System.out.println("5 - Supprimer véhicule :");
                System.out.println("6 - Consulter Parc :");
                System.out.println("7 - Retour vers menu principale");
                System.out.println("q - Quitter");
                choix = sc.next();

                switch (choix) {
                    case "3":
                        parc.saisieVéhicule();

                        break;

                    case "4":
                        modifier:
                        while (true) {
                            System.out.println("Saisir numéro d'immatricule de la véhicule a modifier");
                            parc.listVéhicule.forEach((e) -> System.out.println("- " + e.getImmatricule()));
                            System.out.println("0 - Retour");
                            System.out.println("q - Quitter");
                            sc.nextLine();
                            String imm = sc.nextLine();

                            if (imm.equals("0") || imm.equals("q")) {
                                if (imm.equals("q")) {
                                    break menu_principale;
                                }
                                break modifier;
                            }
                            HashMap<String, Etat> etats = new HashMap<>();
                            etats.put("1", Etat.Disponible);
                            etats.put("2", Etat.Loué);
                            etats.put("3", Etat.Réparation);
                            StringBuilder etatMessage = new StringBuilder();
                            etats.forEach((k, v) -> etatMessage.append("- " + k + ": " + v + "\n"));
                            System.out.println("Choisissez nouveau état : \n" + etatMessage);
                            String nouveauEtat = sc.next();
                            if (etats.containsKey(nouveauEtat)) {
                                if (parc.modifierEtat(imm, etats.get(nouveauEtat))) {
                                    break;
                                }
                            }
                        }
                        break;

                    case "5":
                        System.out.println("Saisir numéro d'immatricule de la véhicule pour supprimer");
                        parc.listVéhicule.forEach((e) -> System.out.println("- " + e.getImmatricule()));
                        System.out.println("0 - Retour");
                        System.out.println("q - Quitter");
                        sc.nextLine();
                        String imm = sc.nextLine();
                        parc.supprimerVehicule(imm);
                        break;

                    case "6":
                        if (parc instanceof Parc2) {
                            parc.afficher();
                        } else {
                            chercher_loop:
                            while (true) {
                                HashMap<String, Object> etats = new HashMap<>();
                                etats.put("1", Etat.Disponible);
                                etats.put("2", Etat.Loué);
                                etats.put("3", Etat.Réparation);
                                etats.put("4", "Afficher toute les véhicules");

                                StringBuilder etatMessage = new StringBuilder();
                                etats.forEach((k, v) -> etatMessage.append("- " + k + ": " + v + "\n"));
                                System.out.println("Chercher par état : \n" + etatMessage);


                                String chercherEtat = sc.next();
                                if (etats.containsKey(chercherEtat)) {
                                    switch (chercherEtat) {
                                        case "1":
                                            parc.afficherVehiculesDisponibles();
                                            break;

                                        case "2":
                                            parc.afficherVehiculesLoué();
                                            break;

                                        case "3":
                                            parc.afficherVehiculesReparation();
                                            break;

                                        case "4":
                                            parc.afficher();
                                            break;

                                        default:
                                            break;
                                    }
                                    break chercher_loop;
                                } else {
                                    System.out.println("Choix invalid");
                                }
                            }
                        }
                        break;

                    case "7":
                        choix = "7";
                        continue menu_principale;


                    case "q":
                        break menu_principale;
                }
                choix = parc instanceof Parc1 ? "1" : "2";


            } else if(choix.equals("q")) { // sinon si choix egale a Quitter
                continue menu_principale;
            } else { // sinon si choix invalid
                System.out.println("Choix invalid");
                choix = "7";
            }
        }
        System.out.println("Au revoir");
    }
}
/*********************************************Fin*****************************************************/