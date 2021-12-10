package Parcs;
import Véhicule.*;

import java.util.ArrayList;
import java.util.HashSet;
/**
 * Parc2 est une extension de la classe ParcDeBase en implemantant une HashSet
 */
public class Parc2 extends ParcDeBase {

    @Override
    public HashSet<Véhicule> ListeImplémmenté() {
        HashSet<Véhicule> cars = new HashSet<>();
        // Ajout de quelques voitures pour le test du programme
        cars.add(new Véhicule("Class-S", "Mercedes", "218TUN8008", Etat.Disponible));
        cars.add(new Véhicule("CX3", "Mazda", "118TUN3209", Etat.Disponible));
        cars.add(new Véhicule("Cayman", "Porsche", "82LUX1998", Etat.Disponible));
        cars.add(new Véhicule("206", "Peogeot", "11TUN1038", Etat.Réparation));
        cars.add(new Véhicule("A3", "Audi", "221TUN771", Etat.Loué));
        cars.add(new Véhicule("4C", "Alpha Romeo", "199TUN5210", Etat.Loué));

        return cars;
    }
    // Quand on va appeler cette classe, on va avoir acces a  toutes les méthode de la classe parent
    // ParcDeBase.
}
