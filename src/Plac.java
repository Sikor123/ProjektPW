import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Plac extends JPanel  {

    private Image hurtownia;
    private Image magazyn;
    private Image forklif;
    private Image magazynf;
    private Image forkliff;
    int x  , y ;
    boolean dojechal = false;
    boolean lewyWozek = true;
    Timer timer;
    Semaphore[] semaphores;
    Random generator = new Random();



    public Plac(Semaphore[] semaphores ) {
        this.semaphores = semaphores;
        //this.wozek = wozek;
        //timer = new Timer(5 , this);
        ImageIcon ii = new ImageIcon("hurtownia.jpg");
        hurtownia = ii.getImage();
        ii = new ImageIcon("warehouse.png");
        magazyn = ii.getImage();
        ii = new ImageIcon("forklif.png");
        forklif = ii.getImage();
        ii = new ImageIcon("warehousef.png");
        magazynf = ii.getImage();
        ii = new ImageIcon("forkliff.png");
        forkliff = ii.getImage();





    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setSize(1000,700);

        drawTable(g);





    }

    private void drawTable(Graphics g){

        g.drawImage(hurtownia,400,200,200,200 ,null);
        g.drawImage(magazyn,50,50,200,200,null);
        g.drawImage(magazyn,50,400,200,200,null);
        g.drawImage(magazynf,700,50,200,200,null);
        g.drawImage(magazynf,700,400,200,200,null);
        if(lewyWozek == true)
            g.drawImage(forklif,x,y, 100 , 50,null);
        else
            g.drawImage(forkliff,x,y, 100 , 50,null);
//        // g.drawImage(forklif,300,250, 100 , 50,null);//srodekLewa
////        g.drawImage(forkliff,600,250, 100 , 50,null);//srodekprawa
////        g.drawImage(forklif,150,200, 100 , 50,null);//lewaGora
////        g.drawImage(forklif,150,550, 100 , 50,null);//lewydol
////        g.drawImage(forklif,700,200, 100 , 50,null);//prawaGora
////        g.drawImage(forklif,700,550, 100 , 50,null);//prawyDol
    }


    public void jedzA ()  {
        x = 300;
        y = 250;
        dojechal = false;
        lewyWozek = true;

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if(dojechal == false){
                        if(x > 150)
                            x = x -5;
                        else if(y > 200)
                            y -= 5;

                        if(x == 150 && y == 200)
                        {
                            dojechal = true;
                            if(generator.nextInt(100) < 5) {
                                System.out.println("Czekam na dostawe do magazynu 0");
                            try {
                                TimeUnit.MILLISECONDS.sleep(generator.nextInt(5000));
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }

                        }
                        }



                    }
                    else{
                        lewyWozek = false;



                        if(y < 250)
                            y += 5;
                        else if(x <300)
                            x = x + 5;
                        else if(x == 300 && y == 250)
                        {

                            System.out.println("Koniec");
                            semaphores[0].release();
                            timer.stop();
                        }
                    }
                repaint();
            }
        });
        timer.start();
    }

    public void jedzB ()
    {
        x = 300;
        y = 250;
        dojechal = false;
        lewyWozek = true;
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dojechal == false) {
                    if (y < 550)
                        y += 5;
                    else if (x > 150)
                        x = x - 5;
                    if(y == 550 && x == 150)
                    {
                        dojechal = true;
                        if(generator.nextInt(100) < 5) {
                            System.out.println("Czekam na dostawe do magazynu 1");
                            try {
                                TimeUnit.MILLISECONDS.sleep(generator.nextInt(5000));
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }

                        }
                    }

                }else{
                    lewyWozek = false;
                    if(x <300)
                        x+=5;
                    else if (y > 250)
                        y -=5;
                    else if(x == 300 && y == 250)
                    {
                        System.out.println("Koniec");
                        timer.stop();
                        semaphores[0].release();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    public void jedzC ()
    {

        x = 600;
        y = 250;
        dojechal = false;
        lewyWozek = false;
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dojechal == false) {
                    if (x < 700)
                        x+=5;
                    else if (y > 200)
                        y-=5;
                        if(x == 700 && y == 200)
                        {
                            dojechal = true;
                            if(generator.nextInt(100) < 5) {
                                System.out.println("Czekam na dostawe do magazynu 2");
                                try {
                                    TimeUnit.MILLISECONDS.sleep(generator.nextInt(5000));
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }

                            }

                        }

                }else{
                    lewyWozek = true;
                    if(y < 250)
                        y += 5;
                    else if(x >600)
                        x-=5;
                    else if(x == 600 && y == 250)
                    {
                        System.out.println("Koniec");
                        timer.stop();
                        semaphores[0].release();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    public void jedzD ()
    {
        x = 600;
        y = 250;
        dojechal = false;
        lewyWozek = false;
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dojechal == false) {
                    if (y < 550)
                        y+=5;
                    else if (x < 700)
                        x+=5;
                    else if(x == 700 && y == 550)
                    {
                        dojechal = true;
                        if(generator.nextInt(100) < 5) {
                            System.out.println("Czekam na dostawe do magazynu 3");
                            try {
                                TimeUnit.MILLISECONDS.sleep(generator.nextInt(5000));
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }

                        }
                    }
                } else {
                    lewyWozek = true;
                    if(x >600)
                        x-=5;
                    else if (y > 250)
                        y -=5;
                    else if(x == 600 && y == 250){
                        timer.stop();
                        semaphores[0].release();}
                }
                repaint();
            }
        });
        timer.start();
    }



}
