import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Card extends JButton implements Serializable{
    String name;
    String color;
    boolean selected;
    List<Position> moves = new ArrayList<>();
    ImageIcon whiteIcon;
    ImageIcon blackIcon;

    Border selectedBorder = BorderFactory.createLineBorder(Color.GREEN, 4);
    Border unSelectedBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

    public Card(String name, String color){
        this.name = name;
        this.selected = false;
        this.setActionCommand("card");
        this.color = color;
        this.whiteIcon = new ImageIcon(name+"White.png");
        this.blackIcon = new ImageIcon(name+"Black.png");
        this.setBackground(Color.WHITE);
        this.setFocusable(false);

        switch (this.name){
            case "crab":
                this.moves.add(new Position(2, 0));
                this.moves.add(new Position(-2, 0));
                this.moves.add(new Position(0, 1));
                break;
            case "dragon":
                this.moves.add(new Position(1,-1));
                this.moves.add(new Position(-1, -1));
                this.moves.add(new Position(2, 1));
                this.moves.add(new Position(-2, 1));
                break;
            case "bear":
                this.moves.add(new Position(-1,1));
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(1,-1));
                break;
            case "boar":
                this.moves.add(new Position(1, 0));
                this.moves.add(new Position(-1,0));
                this.moves.add(new Position(0,1));
                break;
            case "cobra":
                this.moves.add(new Position(1,1));
                this.moves.add(new Position(-1,0));
                this.moves.add(new Position(1,-1));
                break;
            case "crane":
                this.moves.add(new Position(1,-1));
                this.moves.add(new Position(-1,-1));
                this.moves.add(new Position(0,1));
                break;
            case "dog":
                this.moves.add(new Position(-1,1));
                this.moves.add(new Position(-1,0));
                this.moves.add(new Position(-1,-1));
                break;
            case "eel":
                this.moves.add(new Position(-1,1));
                this.moves.add(new Position(-1,-1));
                this.moves.add(new Position(1,0));
                break;
            case "elephant":
                this.moves.add(new Position(-1,1));
                this.moves.add(new Position(-1,0));
                this.moves.add(new Position(1,1));
                this.moves.add(new Position(1, 0));
                break;
            case "fox":
                this.moves.add(new Position(1,0));
                this.moves.add(new Position(1,1));
                this.moves.add(new Position(1,-1));
                break;
            case "frog":
                this.moves.add(new Position(-2,0));
                this.moves.add(new Position(-1,1));
                this.moves.add(new Position(1,-1));
                break;
            case "giraffe":
                this.moves.add(new Position(0,-1));
                this.moves.add(new Position(2,1));
                this.moves.add(new Position(-2,1));
                break;
            case "goose":
                this.moves.add(new Position(-1,1));
                this.moves.add(new Position(-1,0));
                this.moves.add(new Position(1,-1));
                this.moves.add(new Position(1,0));
                break;
            case "horse":
                this.moves.add(new Position(-1,0));
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(0,-1));
                break;
            case "iguana":
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(-2,1));
                this.moves.add(new Position(1,-1));
                break;
            case "kirin":
                this.moves.add(new Position(0,-2));
                this.moves.add(new Position(-1,2));
                this.moves.add(new Position(1,2));
                break;
            case "mantis":
                this.moves.add(new Position(0,-1));
                this.moves.add(new Position(-1,1));
                this.moves.add(new Position(1,1));
                break;
            case "monkey":
                this.moves.add(new Position(1,1));
                this.moves.add(new Position(1,-1));
                this.moves.add(new Position(-1,-1));
                this.moves.add(new Position(-1, 1));
                break;
            case "mouse":
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(1,0));
                this.moves.add(new Position(-1,-1));
                break;
            case "otter":
                this.moves.add(new Position(-1,1));
                this.moves.add(new Position(1,-1));
                this.moves.add(new Position(2,0));
                break;
            case "ox":
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(0,-1));
                this.moves.add(new Position(1,0));
                break;
            case "panda":
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(1,1));
                this.moves.add(new Position(-1,-1));
                break;
            case "phoenix":
                this.moves.add(new Position(-1,1));
                this.moves.add(new Position(-2,0));
                this.moves.add(new Position(1,1));
                this.moves.add(new Position(2,0));
                break;
            case "rabbit":
                this.moves.add(new Position(-1,-1));
                this.moves.add(new Position(1,1));
                this.moves.add(new Position(2,0));
                break;
            case "rat":
                this.moves.add(new Position(-1,0));
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(1,-1));
                break;
            case "rooster":
                this.moves.add(new Position(-1,0));
                this.moves.add(new Position(-1,-1));
                this.moves.add(new Position(1,0));
                this.moves.add(new Position(1,1));
                break;
            case "sable":
                this.moves.add(new Position(-2,0));
                this.moves.add(new Position(-1,-1));
                this.moves.add(new Position(1,1));
                break;
            case "seaSnake":
                this.moves.add(new Position(-1,-1));
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(2,0));
                break;
            case "tanuki":
                this.moves.add(new Position(-1,-1));
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(2,1));
                break;
            case "tiger":
                this.moves.add(new Position(0,-1));
                this.moves.add(new Position(0,2));
                break;
            case "turtle":
                this.moves.add(new Position(-2,0));
                this.moves.add(new Position(-1,-1));
                this.moves.add(new Position(1,-1));
                this.moves.add(new Position(2, 0));
                break;
            case "viper":
                this.moves.add(new Position(-2,0));
                this.moves.add(new Position(0,1));
                this.moves.add(new Position(1,-1));
                break;

        }
    }

    //Karbantartja az ikonokat
    public void updateIcon(String color){
        if (color.equals("white")){
            this.setIcon(whiteIcon);
            this.setColor("white");
        }else{
            this.setIcon(blackIcon);
            this.setColor("black");
        }
    }
    public void clicked(){
        this.selected = !this.selected;
        if (this.selected) this.setBorder(selectedBorder);
        else this.setBorder(unSelectedBorder);
    }
    public List<Position> getMoves(){
        return moves;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
