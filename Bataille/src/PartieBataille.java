public class PartieBataille {

    private Paquet pioche;
    private Joueur j1;
    private Joueur j2;

    public PartieBataille() {
        System.out.println("Initialisation de la partie de Bataille...");
        pioche = new Paquet();

        j1 = new Joueur("gilou");
        j2 = new Joueur("Sido");


    }

    public void distribuerLesCartes(){

        initialisationDeLaPioche();

        repartitionDeLaPioche();
    }

    private void initialisationDeLaPioche(){             // fabrique le paquet initiale de 52 cartes
        pioche.creerPaquet52();

        if (pioche.getSize() != 52) System.out.println("erreur : taille de pioche non correcte");
    }

    private void repartitionDeLaPioche(){
        while (!(pioche.getSize()==0)){               // les 2 joueurs reçoivent tour à tour une carte jusqu'à la fin du paquet initiale
            j1.recupereUneCarte(pioche.getCarteAleatoire());
            j2.recupereUneCarte(pioche.getCarteAleatoire());
        }

        if ((j1.tailleDePaquet() + j2.tailleDePaquet() != 52)) System.out.println("Erreur : Distribution foirée");
    }

    public void JouerUnePartie(){
        do {
            jouerUnTour();
            j1.perdu = (j1.tailleDePaquet()==0);
            j2.perdu = (j2.tailleDePaquet()==0);

        }while (!(j1.perdu) && !(j2.perdu));

        if (j1.tailleDePaquet()==0){
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
            if (j1.jeu.lireCarteDuDessus().estSuperieurA(j2.jeu.lireCarteDuDessus())) j1.recupereLesCartes(j2.jeu);
            else {
                if (j2.jeu.lireCarteDuDessus().estSuperieurA(j1.jeu.lireCarteDuDessus())) j2.recupereLesCartes(j1.jeu);
            }
        }

        j1.jeu.removeAll();
        j2.jeu.removeAll();

        /*System.out.print(j1.getName() + " a " + j1.tailleDePaquet() + " cartes, ");          test pour verrifier que l'on ne perd pas des cartes
        System.out.print(j2.getName() + " a " + j2.tailleDePaquet() + " cartes, ");
        System.out.println("paquet : " + (j1.tailleDePaquet()+j2.tailleDePaquet()));*/
    }

    private boolean testBataille() {
        return (j1.jeu.lireCarteDuDessus().estEgalA(j2.jeu.lireCarteDuDessus()));
    }

    private void jouerUneBataille(){

        System.out.println("          BATAILLE!!!!");

        if ((j1.tailleDePaquet()<=2) || (j2.tailleDePaquet()<=2)){
            j1.perdu = (j1.tailleDePaquet()<=2);
            j2.perdu = (j2.tailleDePaquet()<= 2);
        }
        else {
            // on ajoute une carte retournée sur chaque tas
            chacunSortUneCarte();

            // on rejoue dessus
            chacunSortUneCarte();

            if (testBataille()) jouerUneBataille();
            else {
                if (j1.jeu.lireCarteDuDessus().estSuperieurA(j2.jeu.lireCarteDuDessus())) j1.recupereLesCartes(j2.jeu);
                else {
                    if (j2.jeu.lireCarteDuDessus().estSuperieurA(j1.jeu.lireCarteDuDessus())) j2.recupereLesCartes(j1.jeu);
                }
            }
        }
    }

    private void chacunSortUneCarte(){
        j1.jeu.ajouteUneCarte(j1.tireUneCarte(0));
        j2.jeu.ajouteUneCarte(j2.tireUneCarte(0));

        System.out.println(j1.getName() + " : " + j1.jeu.getTitre(j1.jeu.getSize()-1));
        System.out.println(j2.getName() + " : " + j2.jeu.getTitre(j2.jeu.getSize()-1));
    }


}
