public class Joueur {

    private String nom;
    private int score;

    public Joueur(String nomJoueur) {
        nom = nomJoueur;
        score = 0;
    }


    // jouer un tour

    public void JouerUnTour(Gobelet gobelet){
        // lancer les dés
        gobelet.lancer();
        if (gobelet.VerifGobelet()) {
            System.out.print(GetNom()+" ");
            for (int d : gobelet.RetourValeursDes()){
                System.out.print(d);
            }
            System.out.println();
            score++;
        }

    }


    public String GetNom(){
        return nom;
    }


    public boolean asTuGagne() {
        return (score==5);
    }

}
