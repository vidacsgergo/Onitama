import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class GameFrame extends JFrame{
    Player playerWhite;
    Player getPlayerBlack;
    JPanel rightDeck;
    Table table;

    public GameFrame(Controller controller, Player playerWhite, Player playerBlack){

        this.table = controller.getTable();
        this.playerWhite = playerWhite;
        this.getPlayerBlack = playerBlack;

        ImageIcon icon = new ImageIcon("./resources/" + "icon.png");
        this.setIconImage(icon.getImage());
        this.setTitle("Onitama");

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        this.add(playerWhite.handPanel);
        this.add(this.table);
        this.add(playerBlack.handPanel);

        this.setJMenuBar(new MyMenuBar(controller));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1920,1080));
        this.pack();
        this.setVisible(true);
    }
}
