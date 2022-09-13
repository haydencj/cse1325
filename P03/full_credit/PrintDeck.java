public class PrintDeck {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        while(deck.isEmpty() == false) System.out.print(deck.deal() + " ");
        System.out.println("");
        //deck.deal(); 
    }
    
}
