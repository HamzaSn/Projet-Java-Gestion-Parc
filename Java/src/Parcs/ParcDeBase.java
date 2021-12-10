package Parcs;

import Véhicule.*;

import java.util.*;

/**
 * ParcDeBase est un classe abstraite qui contient les methodes de gestion du parc
 * et qui implemente L'interface ListVéhicule pour obliger les classes qui vont l'utiliser
 * a définir une type de Collection, dans le cas de ce projet soit une ArrayListe soit une HashSet
 */
public abstract class ParcDeBase implements ListVéhicule{

    // ArrayList et Hashset sont des Collection, càd ils implementent l'interface Collection
    public Collection<Véhicule> listVéhicule;

    // ce constructeur affecte la liste de retour de a méthode implémenté, a la liste de cette classe.
    public ParcDeBase() {
        this.listVéhicule = ListeImplémmenté(); // cette méthode est accessible grace au que la classe (this) ParcDeBase
                                                // implémente l'interface ListVéhicule.
    }


    /**
     * Methode pour afficher Le nombre total des voitures dans le parc
     */
    public void AfficheTotale(){
        System.out.println(this.listVéhicule.size());
    }


    /**
     * Cette méthode sert a ajouter une véhicule (initialisé) dans la structure de données
     * @param  v Véhicule
     * Affiche un message d'erreurs en cas ou l'ajout n'est pas possible.
     */
    public void ajouterVéhicule(Véhicule v){
        if(listVéhicule.contains(v)){
            listVéhicule.add(v);
            System.out.println("Véhicule ("+v.getImmatricule()+") ajouté avec succès !");
        } else {
            System.out.println("Véhicule ("+v.getImmatricule()+") éxistante !");
        }

    }


    /**
     * Cette Méthode permet a un utilisateur de saisir au clavier les information d'une véhicule et l'ajouter
     * a la liste.
     */
    public void saisieVéhicule(){
        String marque;
        String constructeur;
        String immatricule;
        Etat etat = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir marque :");
        marque = sc.nextLine();
        System.out.println("Saisir constructeur :");
        constructeur = sc.nextLine();
        while(true){
            System.out.println("Saisir immatricule :");
            immatricule = sc.nextLine().replace(" ","").toUpperCase();
            if(listVéhicule.contains(new Véhicule(null,null,immatricule,null))){
                System.out.println("Véhicule existante");
            } else {
                break;
            }
        }

        while (true){
            HashMap<String,Etat> etats = new HashMap<>();
            etats.put("1",Etat.Disponible);
            etats.put("2",Etat.Loué);
            etats.put("3",Etat.Réparation);
            StringBuilder etatMessage  = new StringBuilder();
            etats.forEach((k,v) -> etatMessage.append("- "+k+":"+v + "\n") );
            System.out.println("Choisissez état : \n" + etatMessage);
            String etatString = sc.nextLine().toLowerCase();
            if(!etats.containsKey(etatString)){
                System.out.println("Etat invalid");
                continue;
            }
            etat = etats.get(etatString);
            break;
        }

        Véhicule newVehicule = new Véhicule(marque,constructeur,immatricule,etat);
         this.listVéhicule.add(newVehicule);


        System.out.println("Véhicule ajouté avec succès");

    }


    /**
     * Affiche la totalité des véhicules dans la liste
     */
    public void afficher(){
        for(Véhicule v : listVéhicule){
            System.out.println(v);
        }
    }


    /**
     * Affichage des véhicules ayant l'état disponible dans la liste
     */
    public void afficherVehiculesDisponibles(){
        for(Véhicule v : listVéhicule){
            if(v.getEtat() == Etat.Disponible){
                System.out.println(v);
            }
        }
    }


    /**
     * Affichage des véhicules qui sont loué dans la liste
     */
    public void afficherVehiculesLoué(){
        for(Véhicule v : listVéhicule){
            if(v.getEtat() == Etat.Loué){
                System.out.println(v);
            }
        }
    }


    /**
     * Affichage des véhicules ayant l'état Réparation dans la liste
     */
    public void afficherVehiculesReparation(){
        for(Véhicule v : listVéhicule){
            if(v.getEtat() == Etat.Réparation){
                System.out.println(v);
            }
        }
    }


    /**
     * Une méthode qui permet de modifier l'etat d'une véhicule existante dans la liste
     * prend comme arguments une série d'immatricule et un Etat
     * @param immatricule String
     * @param nvEtat Etat
     * @return vrai si la véhicule éxiste dans la liste et faux sinon, affiche ainsi un message de succès
     * en cas ou l'etat a jour et un msg d'echec en cas ou il s'agit du meme etat.
     */
    public boolean modifierEtat(String immatricule, Etat nvEtat){
        boolean exist = false;
        Véhicule vehicule = new Véhicule();
        for(Véhicule v : listVéhicule){
            if(v.getImmatricule().equals(immatricule)){
                exist = true;
                vehicule = v;
            }
        }
        if(!exist){
            System.out.println("Modification impossible, véhicule inexistante");
        } else {
            if (!vehicule.getEtat().equals(nvEtat.toString())){
                vehicule.setEtat(nvEtat);
                System.out.println("Etat de la véhicule("+vehicule.getImmatricule()+") a été mis a jour avec succès : " + nvEtat);
            } else {
                System.out.println("Etat de la véhicule("+vehicule.getImmatricule()+") est deja : " + nvEtat);
            }

        }
        return exist;
    }


    /**
     * Une méthode pour la supression d'une véhicule de la liste
     * @param immatricule String
     */
    public void supprimerVehicule(String immatricule){
      Véhicule vehicule = new Véhicule(null,null,immatricule,null);
      if(listVéhicule.contains(vehicule)){
            Iterator i = listVéhicule.iterator();
          while(i.hasNext()){
               Véhicule v = (Véhicule) i.next();
              if(v.getImmatricule().equals(immatricule)){
                  listVéhicule.remove(v);
                  System.out.println("Suppression effectué");
                  break;
              }
          }



      } else {
          System.out.println("Véhicule inéxistante");
      }
    }
}
/*********************************************Fin*****************************************************/