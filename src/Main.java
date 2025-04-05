import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static boolean save = false;
    static int state = 0;
    public static void setState(int i){
        state = i;
    }
    public static void setSave(boolean save) {
        Main.save = save;
    }

    public static void main(String[] args) {

        Controller controller = null;
        CardDeck cardDeck;
        Player playerWhite = null;
        Player playerBlack = null;
        Launcher launcher = new Launcher();

        while (state == 0) {
            setState(launcher.getState());
        }
        launcher.dispose();
        //Új játék
        if (state == 1){
            controller = new Controller();
            cardDeck = new CardDeck(controller);
            controller.fifthCard = cardDeck.getRandomCard();

            String selected = new SelectPlayers().getSelected();

            switch (selected){
                case "Player vs. Player":
                    playerWhite = new Human("white", cardDeck.deal());
                    playerBlack = new Human("black", cardDeck.deal());
                    break;
                case "Player vs. Bot":
                    playerWhite = new Human("white", cardDeck.deal());
                    playerBlack = new Robot("black", cardDeck.deal());
                    break;
                case "Bot vs. Bot":
                    playerWhite = new Robot("white", cardDeck.deal());
                    playerBlack = new Robot("black", cardDeck.deal());
                    break;
                default:
                    playerWhite = new Human("white", cardDeck.deal());
                    playerBlack = new Human("black", cardDeck.deal());
                    break;
            }
            state = 3;
        }
        //Mentés betöltése
        if (state == 2){
            try{
                FileInputStream f = new FileInputStream("save.txt");
                ObjectInputStream in = new ObjectInputStream(f);
                controller = (Controller)in.readObject();
                playerWhite = (Player) in.readObject();
                playerBlack = (Player) in.readObject();
                in.close();

                if (controller.lastMoved.equals("white")){
                    controller.hasMoved = true;
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }catch (ClassNotFoundException c){
                System.out.println(c.getMessage());
            }
            controller.game = true;
            state = 3;
        }
        //Maga a játék
        if (state == 3){
            GameFrame gameFrame = new GameFrame(controller, playerWhite, playerBlack);

            while(controller.game){
                //reset
                for(Card c : playerWhite.hand){
                    c.setBorder(c.unSelectedBorder);
                    c.selected = false;
                }
                //lépés
                while(!controller.hasMoved){
                    if (save)
                        save(controller, playerWhite, playerBlack);
                    if (!controller.game) break;
                    playerWhite.move(controller);
                }
                if (controller.selectedCard != null && controller.fifthCard != null)
                    controller.changeCards(controller.selectedCard, controller.fifthCard);
                controller.hasMoved = false;

                if (controller.game){
                    //reset
                    for(Card c : playerBlack.hand){
                        c.setBorder(c.unSelectedBorder);
                        c.selected = false;
                    }
                    //lépés
                    while (!controller.hasMoved){
                        if (save)
                            save(controller, playerWhite, playerBlack);
                        if (!controller.game) break;
                        playerBlack.move(controller);
                    }
                    if (controller.selectedCard != null && controller.fifthCard != null)
                        controller.changeCards(controller.selectedCard, controller.fifthCard);
                    controller.hasMoved = false;
                }
            }
            if (save) save(controller, playerWhite, playerBlack);
            state = 0;
            gameFrame.dispose();
            Main.main(null);
        }
    }
    public static void save(Controller controller, Player white, Player black){
        try{
            FileOutputStream f = new FileOutputStream("save.txt");
            ObjectOutputStream out =  new ObjectOutputStream(f);
            out.writeObject(controller);
            out.writeObject(white);
            out.writeObject(black);
            out.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        setSave(false);
    }
}