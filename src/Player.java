import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

public abstract class Player implements Serializable{
    String color;
    List<Card> hand;
    JPanel handPanel;

    public Player(String color, List<Card> hand){
        this.color = color;
        this.hand = hand;

        handPanel = new JPanel(new GridLayout(2, 1));
        handPanel.setPreferredSize(new Dimension(250, 700));

        for (Card c : hand){
            handPanel.add(c);
            c.updateIcon(this.color);
        }
        handPanel.setBackground(Color.WHITE);
    }
    abstract void move(Controller controller);
    public void addCard(Card card){
        hand.add(card);
    }
    public Card removeCard(int idx){
        return hand.remove(idx);
    }
}
