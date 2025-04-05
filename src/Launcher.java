import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher extends JFrame implements ActionListener{

    JButton newGameButton;
    JButton loadButton;
    JButton exitButton;

    int state = 0;
    Launcher(){

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1,10,10));
        buttonPanel.setPreferredSize(new Dimension(600,400));

        this.setLayout(new FlowLayout());

        newGameButton = new JButton("New Game");
        loadButton = new JButton("Load");
        exitButton = new JButton("Exit");

        newGameButton.setActionCommand("newGame");
        loadButton.setActionCommand("load");
        exitButton.setActionCommand("exit");

        newGameButton.addActionListener(this);
        loadButton.addActionListener(this);
        exitButton.addActionListener(this);

        newGameButton.setBackground(Color.WHITE);
        loadButton.setBackground(Color.WHITE);
        exitButton.setBackground(Color.WHITE);

        newGameButton.setFont(new Font("American TypeWriter", Font.BOLD, 25));
        loadButton.setFont(new Font("American TypeWriter", Font.BOLD, 25));
        exitButton.setFont(new Font("American TypeWriter", Font.BOLD, 25));


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonPanel.add(newGameButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(exitButton);

        this.add(buttonPanel);

        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(1920,1080));
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "newGame":
                state = 1;
                break;
            case "load":
                state = 2;
                break;
            case"exit":
                System.exit(0);
        }
    }

    public int getState(){
        System.out.print("");
        return state;
    }
}
