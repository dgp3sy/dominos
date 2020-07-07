/**
 * A Domino object represents a single token in the game of Dominoes.
 * Each Domino token holds 2 numbers from 0-12.
 */
public class Domino {
    private int first;
    private int second;
    public boolean discovered; // Used for Depth first search

    /** Constructs a domino with the given two numbers on its two faces. */
    public Domino(int first, int second) {
        checkRange(first);
        checkRange(second);
        this.first = first;
        this.second = second;
        discovered = false;
    }

    /** Returns the first of the two numbers on this domino. */
    public int first() {
        return first;
    }

    /** Returns the second of the two numbers on this domino. */
    public int second() {
        return second;
    }

    /** Reverses the first and second number on this domino. */
    public void flip() {
        int temp = first;
        first = second;
        second = temp;
    }

    /**
     * Returns true if the given number is either the first or second number
     * on this domino.
     */
    public boolean contains(int number) {
        return first == number || second == number;
    }
    public boolean matches(Domino d) {
        return d.first() == this.first() || d.first() == this.second() || d.second() == this.second();
    }

    /**
     * Returns true if the domino is a double, thus eliciting a "Double Trouble"
     * @return boolean value
     */
    public boolean isDouble() {
        return first == second;
    }

    /**
     * Returns a String representation of this domino, such as "(3|5)".
     */
    public String toString() {
        return "(" + first + "|" + second + ")";
    }

    // throws an exception if the given number is not between 0 and 6 inclusive.
    private void checkRange(int d) {
        if (d < 0 || d > 12) {
            throw new IllegalArgumentException("dots out of range: " + d);
        }
    }
}