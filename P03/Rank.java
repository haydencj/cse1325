public class Rank {
    //Constructor
    public Rank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.valueOf(rank); // "" + rank;
    }

    //Fields. Static fields are intialized in-line, so they aren't in the constructor.
    public static final int MIN = 0; 
    public static final int MAX = 9;
    private int rank;
}
