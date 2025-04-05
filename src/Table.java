import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Table extends JPanel implements Serializable{
    private Pawn[][] table;
    private Controller controller;

    public Table(Controller controller){
        table = new Pawn[5][5];
        this.controller = controller;

        //Layout beállítása
        this.setLayout(new GridLayout(5,5, 5, 5));
        this.setPreferredSize(new Dimension(700, 700));

        //tábla inicializálása
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                if (y == 0){
                    if (x == 2){
                        table[x][y] = new Pawn(new Position(x, y), "whiteKing");
                    }else{
                        table[x][y] = new Pawn(new Position(x, y), "whitePawn");
                    }
                }else if (y == 4){
                    if (x == 2){
                        table[x][y] = new Pawn(new Position(x, y), "blackKing");
                    }else{
                        table[x][y] = new Pawn(new Position(x, y), "blackPawn");
                    }
                }else{
                    table[x][y] = new Pawn(new Position(x, y), "blank");
                }
            }
        }
        //bábuk frame-hez adása
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                this.add(table[x][y]);
                table[x][y].addActionListener(controller);
            }
        }
    }
    public void resetRedBorders(){
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                if (!table[x][y].isSelected()){
                    table[x][y].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    table[x][y].setPotentionalMove(false);
                }
            }
        }
    }
    public void resetAllBorders(){
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                table[x][y].setPawnSelected(false);
                table[x][y].setPotentionalMove(false);
                table[x][y].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            }
        }
    }

    public Pawn getXY(int x, int y){
        if (x <= 4 && x >= 0){
            if (y <= 4 && y >= 0){
                return table[x][y];
            }
        }
        return null;
    }

    public void enableButtons(){
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                table[x][y].setEnabled(true);
            }
        }
    }
    public void disableButtons(){
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                table[x][y].setEnabled(false);
            }
        }
    }
}
