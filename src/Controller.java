
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;


public class Controller implements ActionListener, Serializable{

    Table table;
    Card selectedCard;
    Card fifthCard;
    Pawn selectedPawn;
    String lastMoved = "black";
    boolean hasMoved;
    boolean game;
    boolean gameOver;

    public Controller(){
        table = new Table(this);
        hasMoved = false;
        game = true;
    }
    public void winCheck(Pawn selectedPawn, Pawn clickedPawn){
        //Ha leüti a királyt
        if (clickedPawn.getRole().equals("whiteKing")){
            //Nyert a fekete
            game = false;
            JOptionPane.showMessageDialog(null, "Black won!", "Game finished", JOptionPane.PLAIN_MESSAGE);
        }else if (clickedPawn.getRole().equals("blackKing")){
            //Nyert a fehér
            game = false;
            JOptionPane.showMessageDialog(null, "White won!", "Game finished", JOptionPane.PLAIN_MESSAGE);
            //Ha beért a kezdőpontra
        }else if (clickedPawn.getPosition().toString().equals("20") && selectedPawn.getRole().equals("blackKing")){
            //nyert a fekete
            game = false;
            JOptionPane.showMessageDialog(null, "Black won!", "Game finished", JOptionPane.PLAIN_MESSAGE);
        }else if (clickedPawn.getPosition().toString().equals("24") && selectedPawn.getRole().equals("whiteKing")){
            //nyert a fehér
            game = false;
            JOptionPane.showMessageDialog(null, "White won!", "Game finished", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void pawnAction(Pawn clickedPawn){
        //Ha ténylegesen végbemegy a lépés
        if(clickedPawn.getPotentialMove() && selectedPawn != null){
            lastMoved = selectedPawn.getColor();
            hasMoved = true;
            winCheck(selectedPawn, clickedPawn);
            //lépés
            changePawns(selectedPawn, clickedPawn);
            //reset
            if (selectedPawn != null) selectedPawn.clicked();

            selectedPawn = null;
            table.resetAllBorders();
        }else
            table.resetRedBorders();

        if (clickedPawn == selectedPawn){
            selectedPawn.clicked();
            selectedPawn = null;
        }else {
            if (selectedPawn != null) {
                selectedPawn.clicked();
            }
            selectedPawn = clickedPawn;
            selectedPawn.clicked();
        }
        table.resetRedBorders();
    }
    public void cardAction(Card clickedCard){
        table.resetRedBorders();
        if(clickedCard == selectedCard){
            selectedCard.clicked();
            selectedCard = null;
        }else{
            if (selectedCard != null) selectedCard.clicked();
            selectedCard = clickedCard;
            selectedCard.clicked();
            table.resetRedBorders();
        }
        if (hasMoved) changeCards(selectedCard, fifthCard);
    }
    public void changeCards(Card selectedCard, Card fifthCard){
        String tempName = selectedCard.getName();
        List<Position> tempMoves = selectedCard.getMoves();
        ImageIcon  tempWhiteIcon = selectedCard.whiteIcon;
        ImageIcon tempBlackIcon = selectedCard.blackIcon;

        //SelectedCard átállítása a fifthCardra
        selectedCard.setName(fifthCard.getName());
        selectedCard.moves = fifthCard.getMoves();
        selectedCard.whiteIcon = fifthCard.whiteIcon;
        selectedCard.blackIcon = fifthCard.blackIcon;
        selectedCard.updateIcon(selectedCard.color);
        selectedCard.setSelected(false);

        //FifthCard beállítása
        fifthCard.setName(tempName);
        fifthCard.moves = tempMoves;
        fifthCard.whiteIcon = tempWhiteIcon;
        fifthCard.blackIcon = tempBlackIcon;
        fifthCard.setColor(null);
        fifthCard.setSelected(false);

    }
    public void changePawns(Pawn p1, Pawn p2){
        p2.setRole(p1.getRole());
        p1.setRole("blank");

        p2.setIcon(p1.getIcon());
        p2.setText(null);
        p1.setIcon(null);
        p1.setText(p1.getPosition().toString());

        table.resetAllBorders();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("button")){
            pawnAction((Pawn)e.getSource());
        }else if (e.getActionCommand().equals("card")){
            cardAction((Card)e.getSource());
        }
    }
    public Table getTable(){return table;}
}
