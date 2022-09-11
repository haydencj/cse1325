package P03;
import java.util.Stack;
import java.util.Collections;

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

    public class DeckEmpty extends IndexOutOfBoundsException {
        public DeckEmpty(String errorMessage) {
            super(errorMessage);
        }
    }
    //Methods
    public Card deal() {
        if(deck.empty() == true ) throw new DeckEmpty("Deck is empty.");
        else return deck.pop();
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }

    public boolean isEmpty() {
        if(deck.empty() == true) return true;
        else return false;
    }
    //Fields
    private Stack<Card> deck;
}
