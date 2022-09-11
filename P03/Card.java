package P03;

public class Card {
    //Constructor
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.valueOf(rank) + suit;
    }
    //Fields
    private Rank rank;
    private Suit suit;
}
