import java.util.ArrayList;
import java.util.Stack;


public class Bot {
    public String name;
    public boolean isOpen;
    private ArrayList<Domino> hand;
    public ArrayList<Domino> train;
    public int numDominos;

    public Bot(String name) {
        this.name = name;
        this.isOpen = false;
        hand = new ArrayList<Domino>();
    }
    public void turn() {

    }
    public ArrayList<Domino> getHand() {
        return hand;
    }
    public Graph<Domino> convertToGraph(ArrayList<Domino> train, Domino starter) {
        Graph<Domino> g = new Graph<>();

        // Add verticies and edges to the graph
        boolean hasConnection = false;
        for (int i=0; i < train.size(); i++) {
            hasConnection=false;
            g.addVertex(train.get(i));
            for (int j=0; j < train.size(); j++) {
                if (i != j) {
                    if (train.get(i).matches(train.get(j))) {
                        hasConnection = true;
                        g.addEdge(train.get(i), train.get(j), false);
                    }
                }
            }
            if (train.get(i).matches(starter)) {
                hasConnection=true;
                g.addEdge(train.get(i), starter, true);
            }
            if (!hasConnection) {
                g.addVertex(train.get(i));
            }
        }


        return g;
    }
    public void buildTrain(Domino starter) {
        Graph<Domino> g = convertToGraph(this.hand, starter);
        Domino next = starter;
        Stack<Domino> s = new Stack<Domino>();
        s.push(next);

        /* Build graph of dominos */

        /* Build Train from the Starter */
        while (!s.empty()) {
            next = s.pop();
            if (!next.hasVisited()) {
                next.visit();
                System.out.println(next.toString() + " ");

                // For each edge in domino : push domino onto stack
                for (Domino edge : g.getEdge(next)) {
                    if (!edge.hasVisited()) {
                        s.push(edge);
                    }

                }

            }

        }


    }
    public void draw(DominoCollection pack) {
        hand.add(pack.draw());
    }

}
