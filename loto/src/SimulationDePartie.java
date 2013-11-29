public class SimulationDePartie {
    private PartieDeLoto partieDeLoto;
    private  int resultat;

    public SimulationDePartie() {
        partieDeLoto = new PartieDeLoto(5, 3, 32, 7, 12, 4);
        resultat=0;
    }

    public void simule(int nombreDePartie){
        int nombreDeTour = 0;
        for (int i =0; i< nombreDePartie; i++){
            partieDeLoto.LancerUnTour();
            nombreDeTour = nombreDeTour + partieDeLoto.combienDeTiragePourGagner();
            //System.out.println(partieDeLoto.combienDeTiragePourGagner());

        }
        resultat = nombreDeTour/nombreDePartie;

    }

   public void AfficherResultat(){
        System.out.println("Il a fallut en moyenne "+resultat+" tirages pour que notre grille sorte au loto...");

   }
}