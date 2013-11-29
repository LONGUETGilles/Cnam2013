public class Gobelet {

    public De de1;
    public De de2;
    public De de3;

    De[] des = new De[3];


    public  Gobelet(){
        de1 = new De();
        de2 = new De();
        de3 = new De();


        des[0] = de1;
        des[1] = de2;
        des[2] = de3;
    }


    public void lancer(){

        for (De d : des) {
            d.LancerDe();
        }

    }

    public boolean VerifGobelet(){
        if (!((SommeDesDes(des))==7)) return false;
        return  (ATonUn4(des));
    }

    private int SommeDesDes(De[] des){
        return (des[0].LireValeur() + des[1].LireValeur() + des[2].LireValeur());
    }

    private boolean ATonUn4(De[] des){
        for (De d: des){
            if (d.LireValeur() == 4) return true;
        }
        return false;
    }

    public int[] RetourValeursDes(){
        int[] valeursDes = new int[3];

        for (int v= 0; v<3; v++) {
            valeursDes[v] = des[v].LireValeur();
        }
        return valeursDes;
    }
}