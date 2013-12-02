import java.util.ArrayList;

public class Gobelet {

    public De de1;
    public De de2;
    public De de3;

    ArrayList<De> des ;


    public  Gobelet(){
        des = new ArrayList<De>();
        de1 = new De();
        de2 = new De();
        de3 = new De();


        des.add(de1);
        des.add(de2);
        des.add(de3);
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

    private int SommeDesDes(ArrayList<De> des){
        return (des.get(0).LireValeur() + des.get(1).LireValeur() + des.get(2).LireValeur());
    }

    private boolean ATonUn4(ArrayList<De> des){
        for (De d: des){
            if (d.LireValeur() == 4) return true;
        }
        return false;
    }

    public int[] RetourValeursDes(){
        int[] valeursDes = new int[3];

        for (int v= 0; v<3; v++) {
            valeursDes[v] = des.get(v).LireValeur();
        }
        return valeursDes;
    }
}