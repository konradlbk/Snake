package snake;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {

    public Image background;
    public Image snakePartSecond;
    public Image water;
    public Image cherryIcon;
    public Image rockIcon;
    public Image snakeHeadDown;
    public Image snakeHeadUp;
    public Image snakeHeadLeft;
    public Image snakeHeadRight, snakePart, snakeTailUp, snakeTailDown, snakeTailLeft, snakeTailRight, snakePartUpDown, snakePartLeftRight;

    public static Color green = new Color(1666073);
        ImageIcon iic = new ImageIcon("out/production/Snake/snake/gfx/cherry.png");
        ImageIcon rockIc = new ImageIcon("out/production/Snake/snake/gfx/rock.png");
        ImageIcon iisd = new ImageIcon("out/production/Snake/snake/gfx/snakeDown.png");
        ImageIcon iisu = new ImageIcon("out/production/Snake/snake/gfx/snakeUp.png");
        ImageIcon iisl = new ImageIcon("out/production/Snake/snake/gfx/snakeLeft.png");
        ImageIcon iisr = new ImageIcon("out/production/Snake/snake/gfx/snakeRight.png");
        ImageIcon iisp = new ImageIcon("out/production/Snake/snake/gfx/snakePart2.png");
        ImageIcon snake2 = new ImageIcon("out/production/Snake/snake/gfx/snakePart2.png");
        ImageIcon iistu = new ImageIcon("out/production/Snake/snake/gfx/snakeTailUp.png");
        ImageIcon iistd = new ImageIcon("out/production/Snake/snake/gfx/snakeTailDown.png");
        ImageIcon iistl = new ImageIcon("out/production/Snake/snake/gfx/snakeTailLeft.png");
        ImageIcon iistr = new ImageIcon("out/production/Snake/snake/gfx/snakeTailRight.png");
        ImageIcon upDown = new ImageIcon("out/production/Snake/snake/gfx/snakePartUpDown.png");
        ImageIcon leftRight = new ImageIcon("out/production/Snake/snake/gfx/snakePartLeftRight.png");
        ImageIcon bg = new ImageIcon("out/production/Snake/snake/gfx/sand.png");
        ImageIcon wr = new ImageIcon("out/production/Snake/snake/gfx/water.png");
    Font f2 = new Font("serif", Font.BOLD, 32);


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Toolkit.getDefaultToolkit().sync();
        Snake snake = Snake.snake;
        water=wr.getImage();

        g.drawImage(water,0,0,this);

        background=bg.getImage();
        g.drawImage(background, 30, 30, this);


            g.setColor(Color.green);

            // SETING APPROPRIATE SNAKE's TAIL AND HEAD PNGs TO CURRENT SNAKE POSITION IN GAME
        for (Point point : snake.snakeParts){
            snakePartSecond = snake2.getImage();
            snakePart=iisp.getImage();

            if (!point.equals(snake.snakeParts.get(0)) && snake.dir ==0){


                    snakePartUpDown=upDown.getImage();
                    g.drawImage(snakePartSecond, point.x * snake.SCALE*13, point.y * snake.SCALE*13, this);





            } else if (point.equals(snake.snakeParts.get(0)) && snake.dir ==0 && snake.snakeParts.get(0).x==snake.head.x){
                snakeTailUp=iistu.getImage();
                g.drawImage(snakeTailUp, point.x * snake.SCALE*13, point.y * snake.SCALE*13, this);

            }

            if (!point.equals(snake.snakeParts.get(0)) && snake.dir ==1 ){

                snakePartUpDown=upDown.getImage();
                g.drawImage(snakePartSecond, point.x * snake.SCALE*13, point.y * snake.SCALE*13, this);

            } else if (point.equals(snake.snakeParts.get(0)) && snake.dir ==1 && snake.snakeParts.get(0).x==snake.head.x){
                snakeTailDown=iistd.getImage();
                g.drawImage(snakeTailDown, point.x * snake.SCALE*13, point.y * snake.SCALE*13, this);

            }

            if (!point.equals(snake.snakeParts.get(0)) && snake.dir ==2){

                snakePartLeftRight=leftRight.getImage();

                g.drawImage(snakePartSecond, point.x * snake.SCALE*13, point.y * snake.SCALE*13, this);
            } else if (point.equals(snake.snakeParts.get(0)) && snake.dir ==2 && snake.snakeParts.get(0).y==snake.head.y){
                snakeTailLeft=iistl.getImage();
                g.drawImage(snakeTailLeft, point.x * snake.SCALE*13, point.y * snake.SCALE*13, this);

            }

            if (!point.equals(snake.snakeParts.get(0)) && snake.dir ==3){

                snakePartLeftRight=leftRight.getImage();
                g.drawImage(snakePartSecond, point.x * snake.SCALE*13, point.y * snake.SCALE*13, this);
            } else if (point.equals(snake.snakeParts.get(0)) && snake.dir ==3 && snake.snakeParts.get(0).y==snake.head.y){
                snakeTailRight=iistr.getImage();
                g.drawImage(snakeTailRight, point.x * snake.SCALE*13+1, point.y * snake.SCALE*13, this);

            }

        }
        if (snake.dir ==1){
        snakeHeadDown=iisd.getImage();
        g.drawImage(snakeHeadDown, snake.head.x*snake.SCALE*13-2, snake.head.y*snake.SCALE*13, this);
        }

        if (snake.dir ==0){
            snakeHeadUp=iisu.getImage();
            g.drawImage(snakeHeadUp, snake.head.x*snake.SCALE*13-4, snake.head.y*snake.SCALE*13, this);
        }

        if (snake.dir ==2){
            snakeHeadLeft=iisl.getImage();
            g.drawImage(snakeHeadLeft, snake.head.x*snake.SCALE*13, snake.head.y*snake.SCALE*13-3, this);
        }

        if (snake.dir ==3){
            snakeHeadRight=iisr.getImage();
            g.drawImage(snakeHeadRight, snake.head.x*snake.SCALE*13-1, snake.head.y*snake.SCALE*13-3, this);
        }

        if (snake.paused==true){
            g.setFont(f2);
            g.setColor(Color.white);

            g.drawString("Paused", 330,350);
        }

        if (snake.gameOver ==true){
            g.setFont(f2);
            g.setColor(Color.white);

            g.drawString("Game Over", 290,350);
        }


        cherryIcon = iic.getImage();
        rockIcon = rockIc.getImage();
        for (Point rockPoint : snake.rocks){
            g.drawImage(rockIcon, rockPoint.x*snake.SCALE*13, rockPoint.y*snake.SCALE*13, this);


        }

        g.drawImage(cherryIcon, snake.cherry.x*snake.SCALE*13, (snake.cherry.y*snake.SCALE*13)-10, this);

        Font f = new Font("serif", Font.PLAIN, 18);
        g.setColor(Color.white);
        g.setFont(f);
        g.drawString("Score:" + snake.score + "   Taillength: " + snake.tailLength + "   Time: " + MenuPanel.timeElapsed, 250, 20);

    }

}
