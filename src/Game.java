import java.util.ArrayList;

public class Game {

    private int numPlayers;
    private ArrayList<Bot> playerList;
    public DominoCollection pile;
    public ArrayList<Domino> mexicoTrain;
    public Domino center;

    public Game(ArrayList<Bot> playerList) {
        this.numPlayers = playerList.size();
        this.playerList = playerList;
    }
    public boolean allPlayersHaveDominoes() {
        for (Bot player : playerList) {
            if (player.numDominos <= 0) {
                return false;
            }
        }
        return true;
    }

    public void play() {
        pile = new DominoCollection();
        center = pile.getDouble();
         /* Deal 15 Dominoes to Each Player */
        while (playerList.get(0).numDominos < 15) {
            for (Bot player : playerList) {
                player.draw(pile);
            }
        }
        /* Build Train for each player */
        for (Bot player : playerList) {
            player.buildTrain(center);
        }

        while (allPlayersHaveDominoes() && pile.size() > 0) {
            for (Bot player : playerList) {
                player.turn();
            }
        }

    }


}
