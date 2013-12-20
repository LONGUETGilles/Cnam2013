public class PartieBataille {

    private Paquet pioche;
    private Joueur j1;
    private Joueur j2;

    public PartieBataille() {
        System.out.println("Initialisation de la partie de Bataille...");
        pioche = new Paquet("paquet52");

        j1 = new Joueur("gilou");
        j2 = new Joueur("Sido");
    }

    public void distribuerLesCartes(){
        while (!(pioche.getSize()==0)){               // les 2 joueurs reçoivent tour à tour une carte jusqu'à la fin du paquet initiale
            j1.recupereUneCarte(pioche.tirerUneCarteAleatoire());
            j2.recupereUneCarte(pioche.tirerUneCarteAleatoire());
        }

        if ((j1.aCombiendeCarte() + j2.aCombiendeCarte() != 52)) System.out.println("Erreur : Distribution foirée");
    }

    public void JouerUnePartie(){
        do {
            jouerUnTour();
            j1.perdu = (j1.aCombiendeCarte()==0);
            j2.perdu = (j2.aCombiendeCarte()==0);

        }while (!(j1.perdu) && !(j2.perdu));

        if (j1.aCombiendeCarte()==0){
            System.out.println();
            System.out.println(j1.getName() + " perdu...");
            System.out.println(j2.getName() + " gagné!!!");
        }
        else{
            System.out.println();
            System.out.println(j2.getName() + " perdu...");
            System.out.println(j1.getName() + " gagné!!!");
        }

    }

    private void jouerUnTour(){
        chacunSortUneCarte();

        if (testBataille()) jouerUneBataille();
        else {
            quiGagne(j1, j2);
        }

        /*System.out.print(j1.getName() + " a " + j1.tailleDePaquet() + " cartes, ");          test pour verrifier que l'on ne perd pas des cartes
        System.out.print(j2.getName() + " a " + j2.tailleDePaquet() + " cartes, ");
        System.out.println("paquet : " + (j1.tailleDePaquet()+j2.tailleDePaquet()));*/
    }
    private void chacunSortUneCarte(){
        j1.jeu.ajouteUneCarte(j1.tireUneCarte(0));
        j2.jeu.ajouteUneCarte(j2.tireUneCarte(0));

        System.out.println(j1.getName() + " : " + j1.jeu.getTitre(j1.jeu.getSize()-1));
        System.out.println(j2.getName() + " : " + j2.jeu.getTitre(j2.jeu.getSize()-1));
    }
    private boolean testBataille() {
        return (j1.jeu.lireCarteDuDessus().estEgalA(j2.jeu.lireCarteDuDessus()));
    }

    private void jouerUneBataille(){

        System.out.println("---------- BATAILLE ----------");

        if (j1.perdu == (j1.aCombiendeCarte()<=2)) j2.recupereLesCartes(j1.jeu);
        if (j2.perdu == (j2.aCombiendeCarte()<= 2)) j1.recupereLesCartes(j2.jeu);

        else {
            // on ajoute une carte retournée sur chaques tas
            chacunSortUneCarte();

            // on rejoue dessus
            chacunSortUneCarte();

            if (testBataille()) jouerUneBataille();
            else {
                quiGagne(j1, j2);
            }
        }
    }

    private void quiGagne(Joueur j1, Joueur j2) {
        if (j1.jeu.lireCarteDuDessus().estSuperieurA(j2.jeu.lireCarteDuDessus())) j1.recupereLesCartes(j2.jeu);
        else j2.recupereLesCartes(j1.jeu);
    }
}
