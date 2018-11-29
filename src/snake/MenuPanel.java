package snake;

import javax.swing.*;


public class MenuPanel {

    public static MenuPanel menuPanel;

        public static JFrame f = new JFrame("Main menu");

        static Thread thread = new Thread();

        static int timeElapsed = 0;


    public static synchronized void main(String[] args) throws InterruptedException{




        MenuRenderer menuRenderer = new MenuRenderer();
        f.add(menuRenderer);
        f.setVisible(true);
        f.setResizable(true);
        f.setSize(805,700);
        f.addKeyListener(new MenuRenderer());


        thread.start();


        for (int i=0; i<50000; i++){
            thread.sleep(1000);
            timeElapsed=i;
//            if (Snake.snake.gameOver==false || Snake.snake.paused==true){
//                timeElapsed=i--;
//            }

        }




        }



        // COULDN'T GET 'WHILE' LOOP TO WORK; THROWED NULL POINTER EXCEPTION EVEN WITH THE SAME CONDITIONS
        // AS IN THE 'FOR' LOOP

//        while (Snake.snake.gameOver!=true || Snake.snake.paused!=true){
//            timeElapsed++;
//        }






    }





