package P03;

public class Rank {
    //Constructor
    public Rank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }

    //Fields
    public static final int MIN = 0;
    public static final int MAX = 9;
    private int rank;
}
