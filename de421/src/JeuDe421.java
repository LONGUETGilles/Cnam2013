public class JeuDe421 {

    private Joueur j1;
    private Joueur j2;
    private Joueur j3;
    private Joueur j4;



    private Gobelet gobelet;

    public JeuDe421() {

        j1 = new Joueur("toto");
        j2 = new Joueur("tata");
        j3 = new Joueur("titi");
        j4 = new Joueur("tete");

        gobelet = new Gobelet();


    }

    public void JouerUnePartie(){

        Joueur[] listeJoueurs = new Joueur[4];
        listeJoueurs[0] = j1;
        listeJoueurs[1] = j2;
        listeJoueurs[2] = j3;
        listeJoueurs[3] = j4;



        boolean gagnant;
        gagnant = false;

        while (!gagnant){
            for (Joueur j : listeJoueurs){
                j.JouerUnTour(gobelet);
                gagnant = j.asTuGagne();
            }

        }

        for (Joueur j : listeJoueurs){
            if (gagnant == j.asTuGagne()) {
                System.out.println(j.GetNom() + " gagne !");
            }
        }

    }
}
