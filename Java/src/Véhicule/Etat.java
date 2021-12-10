package Véhicule;

/**
 * Une véhicule dans le parc de l'agence peut avoir 3 état possible,
 * on peut donc définir une enum
 * Un type énuméré est un type de données comportant en ensemble fini d'états
 */
public enum Etat {Disponible, Loué, Réparation}

// Cette méthode va sérvir a simplifié le syntax
// exemple : vehicule.setEtat(Etat.Disponible);
// ca permet donc d'éliminer la redandance si on souhaite
// controler les état a mettre a jour a chaque fois.