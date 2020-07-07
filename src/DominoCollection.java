import java.util.*;

public class DominoCollection {
    public ArrayList<Domino> pack;
    private final Random randomGenerator;



    public DominoCollection() {
        pack = new ArrayList<Domino>();
        randomGenerator = new Random();

        boolean canAdd = false;
        for (int i=0; i<=12; i++) {
            for (int j=0; j<=12; j++) {
                if (i == j || i == 0) {
                    canAdd = true;
                }
                if (canAdd) {
                    Domino newDomino = new Domino(i, j);
                    pack.add(newDomino);
                }
                if (j==12) {
                    canAdd = false;
                }
            }
        }

    }
    public void shuffle() {
        Collections.shuffle(pack);
    }
    public Domino draw() {
        int index = randomGenerator.nextInt(pack.size());
        return pack.remove(index);
    }
    public Domino getDouble() {
        for (int i=0; i<pack.size(); i++){
            if (pack.get(i).isDouble()) {
                return pack.remove(i);
            }
        }
        return null;

    }
    public int size() {
        return pack.size();
    }
}
