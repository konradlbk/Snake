package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Snake implements ActionListener, KeyListener {

    public static Snake snake;

    public JFrame menuFrame = MenuPanel.f;

    public final String SEPARATOR = " ";


    int timeElapsed = 0;

    private JFrame jFrame;

    private JFrame textFrame;

    private JTextField textField;

    private JButton button;


    private JLabel jLabel;




    private RenderPanel renderPanel;
    private Timer timer = new Timer(5, this);


    public ArrayList<Point> snakeParts = new ArrayList<Point>();


    public ArrayList<Point> rocks = new ArrayList<Point>();


    private Image cherryIcon;

    public  final int UP=0, DOWN=1, LEFT=2, RIGHT=3, SCALE=2;



    public  int ticks = 0, dir =DOWN, score, tailLength, time;

    private float speed;


    public Point head, cherry, rock;


    private Random random;


    public boolean gameOver = false;


    public boolean paused = false;


    private Dimension dim;

    String word = "Cos tam";

    public void startGame(){


        gameOver =false;


        paused=false;

        dir =DOWN;

        score=0;
        tailLength=5;

        speed=18;

        snakeParts.clear();

        rocks.clear();

        head=new Point(4,4);

        random = new Random();
        cherry = new Point(random.nextInt(25-1+1)+1,random.nextInt(22-1+1)+1);
        for (int i=0; i<=4; i++){
        rock = new Point(random.nextInt(25-1+1)+1,random.nextInt(22-1+1)+1);
        rocks.add(rock);
        }
        for (int i = 0; i< tailLength; i++){

            snakeParts.add(new Point(head.x, head.y));
        }

        timer.start();




}


    public Snake(){
        dim=Toolkit.getDefaultToolkit().getScreenSize();
        jFrame = new JFrame("Snake");
        jFrame.setVisible(true);
        jFrame.setSize(805,727);
        jFrame.setLocation(dim.width/2 - jFrame.getWidth()/2, dim.height/2 - jFrame.getHeight()/2);
        jFrame.add(renderPanel = new RenderPanel());
        jFrame.setResizable(true);
        jFrame.addKeyListener(this);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        startGame();
        }



    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        ticks++;




        if (ticks % speed ==0 && head !=null && gameOver != true && !paused){
           // time++;
            snakeParts.add(new Point(head.x, head.y));
            if (dir ==UP)
                if (head.y - 1 >= 1 && noTailAt(head.x, head.y-2))
            head=new Point(head.x, head.y-1);
                else
                    gameOver =true;

            if (dir ==DOWN)
                if (head.y < 25 && noTailAt(head.x, head.y+2))
                head=new Point(head.x, head.y+1);
                else
                    gameOver =true;

            if (dir ==LEFT)
                if (head.x-1>=1 && noTailAt(head.x-2, head.y))
                    head=new Point(head.x -1, head.y);

                else
                    gameOver =true;

            if (dir ==RIGHT)
                if (head.x< 29 && noTailAt(head.x+2, head.y)){
                    word="zmiana";
                    head=new Point(head.x +1, head.y);

                }
                else
                    gameOver =true;


            for (int i=0; i < rocks.size(); i++){
            if (head.equals(rocks.get(i))){
                gameOver =true;
            }

            }

            if (snakeParts.size() > tailLength){
                snakeParts.remove(0);
            }
            if (cherry != null){
                System.out.println(head.x + ", " + head.y);
                if (head.equals(cherry)){
                    score+= 10;
                    tailLength++;
                    if (score==30){
                        speed--;
                    }
                    if (score==80){
                        speed--;
                    }
                    if (score==130){
                        speed--;
                    }
                    if (score==170){
                        speed--;
                    }
                    if (score==220){
                        speed--;
                    }
                    if (score==250){
                        speed--;
                    }
                    if (score==280){
                        speed--;
                    }
                    if (score==310){
                        speed--;
                    }
                    if (score==340){
                        speed--;
                    }
                    cherry.setLocation(random.nextInt(25-1+1)+1,random.nextInt(22-1+1)+1);
                    if (cherry.equals(rock)){
                        cherry.setLocation(random.nextInt(25-1+1)+1,random.nextInt(22-1+1)+1);

                    }
                }
            }

            if (gameOver ==true){
                textFrame = new JFrame("Score");
                textFrame.setLayout(new GridBagLayout());
                textField = new JTextField(20);
                textFrame.setSize(350,200);
                button = new JButton("Add");

                textFrame.add(textField);
                button.setSize(40,40);
                textFrame.add(button);
                textFrame.setVisible(true);
                String scoreToWrite = Integer.toString(score);


                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                        File file = new File("out/production/Snake/snake/scores.txt");
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                        bufferedWriter.write(textField.getText());
//                        bufferedWriter.close();
                        bufferedWriter.append(SEPARATOR);
                        bufferedWriter.append(scoreToWrite);
                        bufferedWriter.append("\n");
                        bufferedWriter.close();
                        textFrame.setVisible(false);

                        }catch (IOException ioe){
                            ioe.printStackTrace();
                        }
                    }
                });







            }
        }

    }


    public boolean noTailAt(int x, int y) {

        for (Point point : snakeParts){
            if (point.equals(new Point(x, y))){
                System.out.println("colided");
                gameOver =true;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException, InterruptedException {


        snake=new Snake();


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();

        if (i==KeyEvent.VK_A && dir != RIGHT){
            dir =LEFT;
        }
        if (i==KeyEvent.VK_D && dir != LEFT){
            dir =RIGHT;
        }
        if (i==KeyEvent.VK_W && dir != DOWN){
            dir =UP;
        }
        if (i==KeyEvent.VK_S && dir != UP){
            dir =DOWN;
        }
        if(i==KeyEvent.VK_SPACE){
            if (gameOver){
            startGame();

            }else {
                paused = !paused;
            }
        }

        if (i==KeyEvent.VK_ESCAPE) {
            menuFrame.setVisible(true);
            jFrame.setVisible(false);


        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
