import java.util.*;

public class Robot extends Player{

    public Robot(String color, List<Card> hand){
        super(color, hand);
    }
    public void move(Controller controller){
        try{
            Thread.sleep(500);
        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        Table table = controller.getTable();
        table.disableButtons();

        table.resetAllBorders();

        Map<Pawn, Pawn> moves = new HashMap<>();
        Map<Pawn, Pawn> attackingMoves = new HashMap<>();

        //Bábu választása
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                if(table.getXY(x, y).getColor().equals(this.color)){
                    for (Card card : hand){
                        for (Position move : card.getMoves()){
                            if (this.color.equals("white")){
                                int x1 = table.getXY(x,y).getPosition().getX() + move.getX();
                                int y1 = table.getXY(x,y).getPosition().getY() + move.getY();
                                if (table.getXY(x1, y1) != null && !(table.getXY(x1, y1).getColor().equals("white"))){
                                    if (table.getXY(x1, y1).getColor().equals("black")){
                                        attackingMoves.put(table.getXY(x, y), table.getXY(x1, y1));
                                    }else
                                        moves.put(table.getXY(x, y), table.getXY(x1, y1));
                                }
                            }
                            if (this.color.equals("black")){
                                int x1 = table.getXY(x,y).getPosition().getX() + move.getX();
                                int y1 = table.getXY(x,y).getPosition().getY() - move.getY();
                                if (table.getXY(x1, y1) != null && !(table.getXY(x1, y1).getColor().equals("black"))){
                                    if (table.getXY(x1, y1).getColor().equals("white")){
                                        attackingMoves.put(table.getXY(x, y), table.getXY(x1, y1));
                                    }else
                                        moves.put(table.getXY(x, y), table.getXY(x1, y1));
                                }
                            }
                        }
                    }
                }
            }
        }
        //ha passzolnia kell
        if (moves.isEmpty()){
            controller.hasMoved = true;
            System.out.println("pass");
        }
        Random random = new Random();
        int  idx = 0;
        int chosenMove;
        //ha le tud ütni egy ellenfelet
        if(!(attackingMoves.isEmpty())){
            chosenMove = random.nextInt(0,attackingMoves.size());
            for(Pawn a : attackingMoves.keySet()){
                if (idx == chosenMove && !controller.hasMoved){
                    controller.winCheck(a, attackingMoves.get(a));
                    controller.changePawns(a, attackingMoves.get(a));
                    controller.hasMoved = true;
                }
                idx++;
            }
        }else{
            //Random választása a lépések közül
            idx = 0;
            chosenMove = random.nextInt(0, moves.size());
            for (Pawn p : moves.keySet()){
                if (idx == chosenMove && !controller.hasMoved){
                    controller.winCheck(p, moves.get(p));
                    controller.changePawns(p, moves.get(p));
                    controller.hasMoved = true;
                }
                idx++;
            }
        }
        table.resetAllBorders();
        controller.selectedPawn = null;
        controller.selectedCard = null;
    }

}
