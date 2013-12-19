public class Joueur {

    private  String nom;

    private Paquet paquet;     // paquet du joueur

    public Paquet jeu;    // jeu du joueur (cartes sur table)

    public boolean perdu;

    public Joueur(String name) {
        nom = name;

        paquet = new Paquet();

        jeu = new Paquet();

        perdu = false;

        System.out.println("le joueur : " + getName() + " a été créé.");
    }

    public  String getName(){      // obtenir le nom du joueur
        return nom;
    }

    public void recupereLesCartes(Paquet jeuAdverses){       // ajoute une liste de cartes à son paquet
        int totalCartesRecup = 0;
        for (int i = jeu.getSize(); i>0; i--) {
            //System.out.println("jeu " + i + " " + jeu.getSize());
            paquet.ajouteUneCarte(jeu.tireUneCarte(i-1));
        }
        for (int j = jeuAdverses.getSize(); j>0; j--) {
            //System.out.println("carte adv"+ j + " " + jeuAdverses.getSize());
            paquet.ajouteUneCarte(jeuAdverses.tireUneCarte(j-1));
        }
    }

    public void recupereUneCarte(Carte c){       // ajoute une carte à son paquet
        this.paquet.ajouteUneCarte(c);
    }

    public Carte tireUneCarte(int index){        // retire la carte du dessus du paquet
        return paquet.tireUneCarte(0);
    }

    public int tailleDePaquet(){      // renvoi la taille du paquet du joueur
        return this.paquet.getSize();
    }
}
