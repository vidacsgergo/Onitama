import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPlayers implements ActionListener {
    String[] options = {"Player vs. Player", "Player vs. Bot", "Bot vs. Bot"};
    String selected = "Player vs. Player";
    JComboBox comboBox;
    JOptionPane optionPane;
    public SelectPlayers(){
        comboBox = new JComboBox<>(options);
        comboBox.addActionListener(this);
        JOptionPane.showMessageDialog(null, comboBox, "Select gamemode:", JOptionPane.OK_CANCEL_OPTION);
    }
    public String getSelected(){
        return selected;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox){
            selected = (String) comboBox.getSelectedItem();
        }
    }
}
