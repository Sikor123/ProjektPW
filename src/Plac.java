import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

public class Plac extends JPanel  {

    private Image hurtownia;
    private Image magazyn;
    private Image forklif;
    private Image magazynf;
    private Image forkliff;
    int x  , y ;

    Timer timer;




    public Plac( ) {

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


        timer = new Timer(3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // czyJedzie.czyjaKolej

            }
        });

        timer.start();
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
//        if(lewyWozek == true)
//            g.drawImage(forklif,x,y, 100 , 50,null);
//        else
//            g.drawImage(forkliff,x,y, 100 , 50,null);
//        // g.drawImage(forklif,300,250, 100 , 50,null);//srodekLewa
////        g.drawImage(forkliff,600,250, 100 , 50,null);//srodekprawa
////        g.drawImage(forklif,150,200, 100 , 50,null);//lewaGora
////        g.drawImage(forklif,150,550, 100 , 50,null);//lewydol
////        g.drawImage(forklif,700,200, 100 , 50,null);//prawaGora
////        g.drawImage(forklif,700,550, 100 , 50,null);//prawyDol
    }}


//    public void jedzA ()  {
//        x = 300;
//        y = 250;
//
//        timer = new Timer(3, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(dojechal[0] == false){
//                    if(x > 150)
//                        x = x - 1;
//                    else if(y > 200)
//                        y -= 1;
//                    else if(x == 150 && y == 200)
//                    {
//
//                        lewyWozek = false;
//                    }
//                }else
//                {
//
//                    if(y < 250)
//                        y += 1;
//                    else if(x <300)
//                        x = x + 1;
//                    else if(x == 300 && y == 250)
//                    {
//
//                        System.out.println("Koniec");
//                        timer.stop();
//
//                    }
//
//                }
//                repaint();
//            }
//        });
//        timer.start();
//    }
//
//    public void jedzB ()
//    {
//        timer = new Timer(3, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(dojechal[1] == false){
//                    if(y < 550)
//                        y += 1;
//                    else if (x > 150)
//                        x = x - 1;
//                    else if(x == 150 && y == 550)
//                    {
//                        dojechal[1] = true;
//                        lewyWozek = false;
//                    }
//                }else
//                {
//
//                    if(x <300)
//                        x++;
//                    else if (y > 250)
//                        y --;
//
//
//
//                }
//                repaint();
//            }
//        });
//        timer.start();
//    }
//    public void jedzC ()
//    {
//        lewyWozek = false;
//        x = 600;
//        y = 250;
//        timer = new Timer(3, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(dojechal[0] == false){
//                    if(x < 700)
//                        x++;
//                    else if(y > 200)
//                        y--;
//                    else if(x == 700 && y == 200)
//                    {
//                        dojechal[0] = true;
//                        lewyWozek = true;
//                    }
//                }else
//                {
//
//                    if(y < 250)
//                        y += 1;
//                    else if(x >600)
//                        x--;
//
//
//                }
//                repaint();
//            }
//        });
//        timer.start();
//    }
//    public void jedzD ()
//    {
//        x = 600;
//        y = 250;
//        lewyWozek = false;
//        timer = new Timer(3, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(dojechal[1] == false){
//                    if(y < 550)
//                        y ++;
//                    else if (x < 700)
//                        x++;
//                    else if(x == 700 && y == 550)
//                    {
//                        dojechal[1] = true;
//                        lewyWozek = true;
//                    }
//                }else
//                {
//                    if(x >600)
//                        x--;
//                    else if (y > 250)
//                        y --;
//                    else if(x == 600 && y == 250)
//                        timer.stop();
//                }
//                repaint();
//            }
//        });
//        timer.start();
//    }
//
//
//
//}
