package P03;
import java.util.Stack;
import java.util.Collections.shuffle;

public class Deck {
    //Constructor
    public Deck() {
        this.deck = new Stack<Card>();

        for(Suit suit: Suit.values()) {
            for(int i = Rank.MIN; i<=Rank.MAX; i++) {
                Rank rank = new Rank(i);
                Card card = new Card(rank, suit);

                deck.push(card);
            }
        }
    }

    // public class Exception DeckEmpty() {

    // }
    //Methods
    public void shuffle() {

    }

    public Card deal() {

    }

    public boolean isEmpty() {
        if(deck.empty() == true) return true;
        else return false;
    }
    //Fields
    private Stack<Card> deck;
}
