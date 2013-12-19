
public class Carte {
    // Couleur
    private String titre;
    // valeur
    private int valeur;

    public Carte(int value, String title){          // constructeur de la carte
        titre = title;
        valeur = value;
    }

    public boolean estSuperieurA(Carte c){          // la carte est elle supérieur?
        return  (this.valeur > c.valeur);
    }

    public boolean estEgalA(Carte c){                // la carte est elle egale?
        return  (this.valeur == c.valeur);
    }

    public String getTitre(){

        return titre;
    }
}
