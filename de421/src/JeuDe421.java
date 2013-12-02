import java.util.ArrayList;

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

        ArrayList<Joueur> listeJoueurs;
        listeJoueurs = new ArrayList<Joueur>();
        listeJoueurs.add(j1);
        listeJoueurs.add(j2);
        listeJoueurs.add(j3);
        listeJoueurs.add(j4);



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
