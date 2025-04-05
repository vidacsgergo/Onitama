import java.util.List;

public class Human extends Player{

    public Human(String color, List<Card> hand){
        super(color, hand);
    }
    public void move(Controller controller){

        Table table = controller.getTable();
        Pawn selectedPawn = controller.selectedPawn;
        Card selectedCard = controller.selectedCard;

        table.enableButtons();

        if (selectedPawn != null && !selectedPawn.getColor().equals(this.color)){
            controller.selectedPawn.clicked();
            controller.selectedPawn = null;
        }
        if (selectedCard != null && !selectedCard.getColor().equals(this.color)){
            controller.selectedCard.clicked();
            controller.selectedCard = null;
        }

        if (selectedPawn != null && selectedCard != null){
            if (selectedCard.getColor().equals("white")){
                for (Position move : selectedCard.getMoves()){
                    //a kijelölt bábu + a lépés koordinátái
                    int x = selectedPawn.getPosition().getX() + move.getX();
                    int y = selectedPawn.getPosition().getY() + move.getY();
                    if (table.getXY(x, y) != null && !table.getXY(x, y).getColor().equals("white")){
                        table.getXY(x, y).setPotentionalMove(true);
                    }
                }
            }else if(selectedCard.getColor().equals("black")){
                for (Position move : selectedCard.getMoves()){
                    //a kijelölt bábu + a lépés koordinátái
                    int x = selectedPawn.getPosition().getX() + move.getX();
                    int y = selectedPawn.getPosition().getY() - move.getY();
                    if (table.getXY(x, y) != null && !table.getXY(x, y).getColor().equals("black")){
                        table.getXY(x, y).setPotentionalMove(true);
                    }
                }
            }
        }else table.resetRedBorders();
    }
}
