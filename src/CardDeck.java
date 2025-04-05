import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck{

    private List<Card> deck = new ArrayList<>();
    public CardDeck(Controller controller){
        deck.add(new Card("bear", null));
        deck.add(new Card("boar", null));
        deck.add(new Card("cobra", null));
        deck.add(new Card("crab", null));
        deck.add(new Card("crane", null));
        deck.add(new Card("dog", null));
        deck.add(new Card("dragon", null));
        deck.add(new Card("eel", null));
        deck.add(new Card("elephant", null));
        deck.add(new Card("fox", null));
        deck.add(new Card("frog", null));
        deck.add(new Card("giraffe", null));
        deck.add(new Card("goose", null));
        deck.add(new Card("horse", null));
        deck.add(new Card("iguana", null));
        deck.add(new Card("kirin", null));
        deck.add(new Card("mantis", null));
        deck.add(new Card("monkey", null));
        deck.add(new Card("mouse", null));
        deck.add(new Card("otter", null));
        deck.add(new Card("ox", null));
        deck.add(new Card("panda", null));
        deck.add(new Card("phoenix", null));
        deck.add(new Card("rabbit", null));
        deck.add(new Card("rat", null));
        deck.add(new Card("rooster", null));
        deck.add(new Card("sable", null));
        deck.add(new Card("seaSnake", null));
        deck.add(new Card("tanuki", null));
        deck.add(new Card("tiger", null));
        deck.add(new Card("turtle", null));
        deck.add(new Card("viper", null));

        for (Card c : deck){
            c.addActionListener(controller);
        }
    }

    public List<Card> deal(){
        Collections.shuffle(deck);
        List<Card> ret = new ArrayList<>();
        ret.add(deck.remove(0));
        ret.add(deck.remove(0));

        return ret;
    }
    public Card getRandomCard(){
        Collections.shuffle(deck);
        return deck.remove(0);
    }
}
