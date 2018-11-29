package snake;

import javax.swing.*;

public class Scores {

    public static Scores scores;

    public static JFrame f = new JFrame("Scores");

    public Scores() {
        ScoresRenderer scoresRenderer = new ScoresRenderer();
        f.add(scoresRenderer);
        f.setVisible(true);
        f.setResizable(true);
        f.setSize(805,700);
        f.addKeyListener(new MenuRenderer());
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        scores=new Scores();



    }

}
