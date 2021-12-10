package Véhicule;

/**
 * Cette classe represente une véhicule.
 */
public class Véhicule {

    // Déclaration des attributs
    private String marque;
    private String constructeur;
    private String immatricule;
    private Etat etat;

    // Déclaration du constructeur parametré
    public Véhicule(String marque, String constructeur, String immatricule, Etat etat) {
        this.marque = marque;
        this.constructeur = constructeur;
        this.immatricule = immatricule;
        this.etat = etat;
    }

    // Déclaration du constructeur non parametré
    public Véhicule() {
    }


    // les accesseurs d'attributs

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * Redéfinir La méthode toString sert a définir au programme comment afficher au console les
     * objet de cette classe.
     * On utilise la méthode format de la classe String pour formatter l'output.
     */
    @Override
    public String toString() {
        String formattedMarque = String.format("%-20s %20s","Marque :",this.marque);
        String formattedConstructeur = String.format("%-20s %20s","Constructeur :",this.constructeur);
        String formattedImmatricule = String.format("%-20s %20s","Immatricule :",this.immatricule);
        String formattedEtat = String.format("%-20s %20s","Etat :",this.etat);
        return "----------------Véhicule-----------------\n"+
                formattedMarque+"\n" +
                formattedConstructeur+"\n"+
                formattedImmatricule+"\n"+
                formattedEtat+"\n"+
                "-----------------------------------------\n";

    }

    /**
     * Override hashCode method:
     * cette methode est utilisé pour hasher l'immatricule d'une véhicule,
     * puisque cette derniere est supposé unique, la méthode equals utilissera ce hashCode.
     * @return
     */
    @Override
    public int hashCode() {
        return this.getImmatricule().hashCode();
    }

    /**
     * Override method equals :
     * cette methode est utilisé pour comparer un object donné en parrametre avec une instance
     * de la classe véhicule (this) , equals sera utilisé par HashSet pour verifier l'existance
     * d'une véhicule dans la collection.
     * Ceci résouds le problème de "contains" avec les Classe ayant des memes attributs mais une référence
     * mémoire différente.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }
}
/*********************************************Fin*****************************************************/