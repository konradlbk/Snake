package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class MenuRenderer extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);


    JFrame frame = MenuPanel.f;
    private Image background, arrow;
    ImageIcon bg = new ImageIcon("out/production/Snake/snake/gfx/menu.png");

    ImageIcon selector = new ImageIcon("out/production/Snake/snake/gfx/selector.png");

    int x=135, y=335, vely=333;
    public MenuRenderer(){

        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        background=bg.getImage();

        g.drawImage(background, 0, 0, this);


        arrow=selector.getImage();

        g.drawImage(arrow, 135, y, this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code==KeyEvent.VK_S && y<473){
            System.out.println("Button Pressed");
            down();
        }
        if (code==KeyEvent.VK_W && y>335){
            System.out.println("Up");
            up();
        }
        if (code==KeyEvent.VK_ENTER && y==335){


            Snake.snake = new Snake();
            frame.setVisible(false);


        }

        if (code==KeyEvent.VK_ENTER && y==491){
            System.exit(0);
        }

        if (code==KeyEvent.VK_ENTER && y==413){
            Scores.scores = new Scores();
            frame.setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void down(){
        vely=78;
       y+=vely;
    }

    public void up(){
        vely=-78;
        y+=vely;
    }
}
