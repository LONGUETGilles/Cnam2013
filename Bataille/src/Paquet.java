import java.util.ArrayList;

public class Paquet {

    private ArrayList<Carte> paquet;

    public Paquet(){
        paquet = new ArrayList<Carte>();
    }

    public Paquet(String etat) {
        if (etat == "paquet52"){

            paquet = new ArrayList<Carte>();
            paquet.addAll(creerFamille("Coeur"));
            paquet.addAll(creerFamille("Trèfle"));
            paquet.addAll(creerFamille("Carreau"));
            paquet.addAll(creerFamille("Pique"));
        }
        else System.out.println("Erreur : création de paquet");

        if (paquet.size() != 52) System.out.println("erreur : taille de pioche non correcte");
    }

    public Carte tirerUneCarteAleatoire(){      //prendre une carte
        int index = (int)(Math.random() * paquet.size());
        Carte c;
           c = (paquet.get(index));
          // System.out.println(c.getTitre());
           paquet.remove(index);
        return  c;
    }

    public void ajouteUneCarte(Carte c){      // rajouter une carte
        paquet.add(c);
    }

    public int getSize(){       // savoir la taille du paquet
        return paquet.size();
    }

    public Carte tireUneCarte(int index) {      // Tire la carte du dessus du paquet
        Carte c;
        c= paquet.get(index);
        paquet.remove(index);
        return c;
    }

    public Carte lireCarteDuDessus() {      // Lit la carte du haut du paquet
        Carte c;
        c= paquet.get(paquet.size()-1);
        return c;
    }

    public String getTitre(int index){
        return paquet.get(index).getTitre();
    }

    public ArrayList<Carte> creerFamille(String famille) {
        ArrayList<Carte> familleDe;
        familleDe = new ArrayList<Carte>();

        familleDe.add(new Carte(2, "Deux de " + famille));
        familleDe.add(new Carte(3, "Trois de " + famille));
        familleDe.add(new Carte(4, "Quatre de " + famille));
        familleDe.add(new Carte(5, "Cinq de " + famille));
        familleDe.add(new Carte(6, "Six de " + famille));
        familleDe.add(new Carte(7, "Sept de " + famille));
        familleDe.add(new Carte(8, "Huit de " + famille));
        familleDe.add(new Carte(9, "Neuf de " + famille));
        familleDe.add(new Carte(10, "Dix de " + famille));
        familleDe.add(new Carte(11, "Valet de " + famille));
        familleDe.add(new Carte(12, "Dame de " + famille));
        familleDe.add(new Carte(13, "Roi de " + famille));
        familleDe.add(new Carte(14, "As de " + famille));

        return familleDe;
    }
}
