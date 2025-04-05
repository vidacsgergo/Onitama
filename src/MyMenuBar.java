import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuBar extends JMenuBar implements ActionListener{
    JMenuItem exitItem;
    JMenuItem saveItem;
    Controller controller;
    JMenuItem mainMenuItem;

    JMenuItem helpItem;

    MyMenuBar(Controller controller){
        this.controller = controller;
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        mainMenuItem = new JMenuItem("Save & quit");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        helpItem = new JMenuItem("Rules");

        mainMenuItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        helpItem.addActionListener(this);


        fileMenu.add(mainMenuItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        helpMenu.add(helpItem);

        this.add(fileMenu);
        this.add(helpMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitItem){
            System.exit(0);
        }
        if(e.getSource() == saveItem){
            Main.setSave(true);
        }
        if(e.getSource() == mainMenuItem){
            Main.setSave(true);
            controller.game = false;
        }
        if (e.getSource() == helpItem){
            JOptionPane.showMessageDialog(null, "" +
                    "Onitama is a two-player, perfect information abstract game with a random starting set-up. " +
                            "\nOn a 5x5 board, both players start with five pawns on their side, with the main pawn in the middle.\n" +
                            "\n" +
                            "Each player has two open cards that each display a possible move for any of her pieces.\n " +
                            "There is a fifth card that cannot be used by either player.\n " +
                            "On a player's turn, she chooses one of her cards, moves one of her pieces according to the chosen card, then replaces the card she used with the fifth card. \n" +
                            "The other player then chooses one of his cards, moves accordingly, and exchanges that card with this fifth card — which is, of course, the card the first player just used.\n" +
                            "\n" +
                            "Moving onto one of the opponent's pawns removes that pawn from the game. \n" +
                            "Taking the opponent's main pawn, or moving your main pawn into your opponent's main pawn's starting space, wins you the game.",
                    "Rules:", JOptionPane.YES_NO_OPTION, new ImageIcon("information.png"));
        }
    }
}
