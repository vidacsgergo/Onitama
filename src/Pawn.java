import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.Serializable;

public class Pawn extends JButton implements Serializable{
    private Position position;
    private String role;
    private boolean selected;
    private boolean potentionalMove;

    Border selectedBorder = BorderFactory.createLineBorder(Color.GREEN, 4);
    Border unSelectedBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    Border potentionalMoveBorder = BorderFactory.createLineBorder(Color.RED, 2);

    public Pawn(Position position, String role){
        //Attribútumok inicializálása
        this.position = position;
        this.role = role;
        this.selected = false;
        this.potentionalMove = false;

        //Kinézet
        this.setBorder(unSelectedBorder);
        this.setFocusable(false);
        this.setBackground(Color.WHITE);
        this.setActionCommand("button");

        //Ikonok beállítása
        switch(this.role){
            case "blackPawn":
                this.setIcon(new ImageIcon("./resources/" + "blackPawn.png"));
                break;
            case "blackKing":
                this.setIcon(new ImageIcon("./resources/" + "blackKing.png"));
                break;
            case "whitePawn":
                this.setIcon(new ImageIcon("./resources/" + "whitePawn.png"));
                break;
            case "whiteKing":
                this.setIcon(new ImageIcon("./resources/" + "whiteKing.png"));
                break;
            case "blank":
                this.setText(this.position.toString());
                break;
        }
    }
    //Ezt meg kell hívja majd az Actionlistener
    public void clicked(){
        selected = !selected;
        if (selected) this.setBorder(selectedBorder);
        else this.setBorder(unSelectedBorder);
    }

    //Setterek, getterek
    @Override
    public boolean isSelected() {
        return selected;
    }
    public Position getPosition() {
        return position;
    }
    public boolean getPotentialMove(){return potentionalMove;}
    public void setPotentionalMove(boolean potentionalMove) {
        this.potentionalMove = potentionalMove;
        if (potentionalMove) this.setBorder(potentionalMoveBorder);
        else this.setBorder(unSelectedBorder);
    }
    public void setPawnSelected (boolean b){
        this.selected = b;
    }
    public String getColor(){
        if (this.role.equals("whitePawn") || this.role.equals("whiteKing")) return "white";
        if (this.role.equals("blackPawn") || this.role.equals("blackKing")) return "black";
        return "blank";
    }
    public String getRole(){return this.role;}
    public void setRole(String role) {
        this.role = role;
    }
}
