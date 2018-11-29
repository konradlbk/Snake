package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScoresRenderer extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);

    private JFrame menuFrame = MenuPanel.f;

    private JFrame scoreFrame = Scores.f;


    private Image background;

    ImageIcon bg = new ImageIcon("out/production/Snake/snake/scorePage.png");


    public ScoresRenderer(){

        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 270;


        background=bg.getImage();

        g.drawImage(background, 0, 0, this);

        Font f = new Font("serif", Font.PLAIN, 18);

        g.setColor(Color.BLACK);
        g.setFont(f);

        try {
            File file = new File("out/production/Snake/snake/scores.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(".* \\d*")){

                    String[] splitted = line.split("\\s+");
                    for (int i=0; i<splitted.length; i++){

                        if (i % 2 !=0){
                            String points = splitted[i];
                            g.drawString(points, 460, y+50);

                        }

                        if (i % 2==0){
                            String players = splitted[i];
                            g.drawString(players, 250, y+50);

                        }
                    }

                }
                y+=40;


            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code==KeyEvent.VK_ESCAPE){
            menuFrame.setVisible(true);
            scoreFrame.setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
