import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[]args){





        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Semaphore semafory[] = new Semaphore[4];
                for(int a = 0;a < 4;a++){
                    semafory[a] = new Semaphore(1);
                }
                JFrame frame = new JFrame("Table");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setPreferredSize(new Dimension(1000,700));
                frame.setResizable(false);
                Plac plac = new Plac(semafory);
                frame.add(plac);

//                try {
//                    wait(15000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("poczekalem");



                //Wyswietla komponent
                frame.pack();
                frame.setVisible(true);


                Magazyn tab[] = new Magazyn[4];
                for(int a = 0;a < 4;a++){
                    tab[a] = new Magazyn(1 , plac , semafory[0]);
                }
                for(int a = 0;a < 4;a++){
                    tab[a].start();
                }

            }});



    }
}