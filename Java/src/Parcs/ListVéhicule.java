package Parcs;

import Véhicule.Véhicule;

import java.util.Collection;

/**
 * Cette Interface est utilisé pour obligier les classes qui héritent de la classe ParcDeBase a
 * définir une Collection ( pour accéder au méthodes relatives au Listes Dynamiques )
 */
public interface ListVéhicule {
      Collection<Véhicule> ListeImplémmenté();
}
/*********************************************Fin*****************************************************/