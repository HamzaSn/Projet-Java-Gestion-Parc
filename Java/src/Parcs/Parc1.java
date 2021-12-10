package Parcs;

import Véhicule.*;

import java.util.ArrayList;


/**
 * Parc1 est une extension de la classe ParcDeBase en implemantant une ArrayList
 * Cette classe héritent donc les méthode de ParcDeBase.
 * Puisque ParcDeBase implémente l'interface ListVéhicule il sera donc nécessaire de redéfinir
 * la méthode de l'interface qui renvoie une Collection
 *
 * dans le cas de Parc1, on souhaite renvoyer un ArrayList
 */
public class Parc1 extends ParcDeBase {

    @Override
    public ArrayList<Véhicule> ListeImplémmenté() {
        ArrayList<Véhicule> cars = new ArrayList<>();
        // On peut se contenter de ca, Mais pour avoir quelques véhicules pour le test du programme
        // on va ajouter comme configuration initiale des véhicules a la Liste
        cars.add(new Véhicule("Class-S", "Mercedes", "218TUN8008", Etat.Disponible));
        cars.add(new Véhicule("CX3", "Mazda", "118TUN3209", Etat.Disponible));
        cars.add(new Véhicule("Cayman", "Porsche", "82LUX1998", Etat.Disponible));
        cars.add(new Véhicule("206", "Peogeot", "11TUN1038", Etat.Réparation));
        cars.add(new Véhicule("A3", "Audi", "221TUN771", Etat.Loué));
        cars.add(new Véhicule("4C", "Alpha Romeo", "199TUN5210", Etat.Loué));

        return cars;
    }
    // Quand on va appeler cette classe, on va avoir acces a  toutes les méthode de la classe parent ParcDeBase.
}
/*********************************************Fin*****************************************************/