public class PartieDeLoto {

    private int nbrDeTirage;
    private CombinaisonDeBoules maGrille;
    private Boulier boulier;


    public PartieDeLoto(int i, int i1, int i2, int i3, int i4, int i5){

        nbrDeTirage = 0;

        maGrille = new CombinaisonDeBoules();
        maGrille.add(i);
        maGrille.add(i1);
        maGrille.add(i2);
        maGrille.add(i3);
        maGrille.add(i4);
        maGrille.add(i5);
        maGrille.triLesBoules();

        boulier = new Boulier();

    }

    public void LancerUnTour(){
        System.out.println("Partie initialisée...");
        boolean gagne = false;

        while (!gagne){
            nbrDeTirage++;
            CombinaisonDeBoules tirage = boulier.getTirage();
            gagne = maGrille.estEgal(tirage);

        }

    }




    public int combienDeTiragePourGagner(){
        return nbrDeTirage;
    }

}
