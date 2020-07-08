import java.util.ArrayList;

public class Run {
    public static void main(String args[]) {
        DominoCollection pack = new DominoCollection();
        Bot elaine = new Bot("Elaine");
        for (int i=0; i<15; i++) {
            elaine.draw(pack);
        }

        //Graph<Domino> g = elaine.convertToGraph(elaine.getHand(), pack.getDouble());
        elaine.buildTrain(pack.getDouble());

//        System.out.println(g.toString());



    }
}
