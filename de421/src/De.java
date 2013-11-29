public class De {
    private int NOMBRE_MAXIMUM_DE_FACE;
    private int valeurFace;

    public De() {
        NOMBRE_MAXIMUM_DE_FACE = 6;
        valeurFace = 1;
    }

    //lancer
    public void LancerDe(){
        valeurFace = (int) (Math.random()*NOMBRE_MAXIMUM_DE_FACE)+1;
    }

    public int LireValeur() {
        return valeurFace;
    }
}
