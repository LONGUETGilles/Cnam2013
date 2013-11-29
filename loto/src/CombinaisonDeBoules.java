public class CombinaisonDeBoules {

    private int[] boules;
    private int index;

    public CombinaisonDeBoules(){
        boules = new int[6];
        index = 0;
    }

    public boolean add(int i){
        if  (estContenue(i, boules)) {
             return false;
        }
         boules[index]= i;
         index++;
        return true;
    }


    public boolean estEgal(CombinaisonDeBoules autreCombinaison ){
        boolean gagne = true;

        for (int i = 0; i < boules.length; i++) {
            if (!estContenue(boules[i], autreCombinaison.boules)) {
                gagne = false;
            }
        }

        return gagne;
    }

    private boolean estContenue(int boule, int[] tirage){

        boolean contenue = false;

        for (int i = 0; i < tirage.length; i++) {
            if (boule == tirage[i]) {
                contenue = true;
            }
        }

        return contenue;
    }

}