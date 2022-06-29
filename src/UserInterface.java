import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    JFrame window;

    JPanel gameScreen;

    // neues Panel
    JPanel startScreen;

    public UserInterface() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setTitle("VierGewinnt");
        window.setResizable(false);
    }

    private void initializeGameScreen() {

        int labelHeight = 50;
        int buttonHeight = 50;
        int chipWidth = Board.chipDiameter;

        for (int column = 0; column < Game.COLUMNS; column++) {
            JButton button = new JButton("\u2193" );
            int yPosition = 5 + labelHeight + 10;
            button.setBounds((column * chipWidth)+ (column * Board.spacing) + 120, yPosition, chipWidth, buttonHeight);
            int targetColumn = column;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Game.playChip(targetColumn);
                }
            });

            button.setVisible(true);
            gameScreen.add(button);
        }


        JButton newGameButton = new JButton("Neues Spiel");
        newGameButton.setBounds(680, 510, 100, 50);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.startNewGame();
                state = 1;

            }



        });
        newGameButton.setVisible(true);
        gameScreen.add(newGameButton);


        Board board = new Board();
        board.setBounds(0,0,800,600);
        gameScreen.add(board);
    }

    private void initializeStartScreen() {
        // Fuege start  Button hinzu
        StartBackground background = new StartBackground();
        background.setBounds(0,0,800,600);
        startScreen.add(background);
        // button add action

    }
    public void initialize() {

//        gameScreen = new JPanel();
//        gameScreen.setLayout(null);
//        initializeGameScreen();
//
//        window.add(gameScreen);

        // startScreen am window adden
        startScreen = new JPanel();
        startScreen.setLayout(null);
        initializeStartScreen();

        window.add(startScreen);
        window.setVisible(true);
    }
}