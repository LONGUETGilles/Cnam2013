public class Boulier {

    public CombinaisonDeBoules getTirage() {

        CombinaisonDeBoules tirage = new CombinaisonDeBoules();

        for (int i = 0; i < 6; i++) {

            boolean added;
            do {
                added = tirage.add(tireUneBoule());
            } while (!added);

        }

        return tirage;
    }

    private int tireUneBoule() {
        return (int) (Math.random() * 49) + 1;
    }

}
