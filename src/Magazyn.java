import javax.swing.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Magazyn extends Thread{

    static int liczbaWatkow=0;
    static volatile  boolean wybieranie[] = new boolean[5];
    static volatile int numerek[] = new int [5];
    int numer;
    int tryb;
    int zasoby;
    Plac plac;
    Semaphore s;
    Magazyn( int tryb , Plac plac , Semaphore s){
        this.s = s;
        numer = liczbaWatkow;
        liczbaWatkow++;
        wybieranie[numer] = false;
        numerek[numer] = 0;
        this.tryb = tryb;
        zasoby = 100;
        this.plac = plac;
    }
    void dzialanieSynchr()  {
        for(int a = 1;;a++){
            this.sekcjaWlasna();
            wybieranie[numer] = true;
            numerek[numer] = Math.max(Math.max(Math.max(Math.max(numerek[0], numerek[1]), numerek[2]), numerek[3] ), numerek[4])+1;//Arrays.stream(numerek).max().getAsInt() + 1;
            wybieranie[numer] = false;
            for(int j = 0; j<5; j++){
                while(wybieranie[j]){
                    ;
                }
                while(numerek[j] != 0 && mniejszyNiz(j,numer)){
                    ;
                }
            }

            sekcjaKrytyczna(a);

            numerek[numer] = 0;
        }
    }
    boolean mniejszyNiz(int j,int n){
        if(j == n)
            return j<n;
        else return numerek[j] < numerek[n];


    }
    @Override
    public void run() {
        if(tryb%2 == 1)
            this.dzialanieSynchr();
        else
            this.dzialanieNiesynchr();

    }

    void sekcjaKrytyczna(int a)  {
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("jade do magazynu " + numer);
        switch (numer){
            case 0:
                plac.jedzA();
                break;
            case 1:
            plac.jedzB();
            break;
            case 2:
              plac.jedzC();
                break;
            case 3:
                plac.jedzD();
                break;
        }




    }

    void sekcjaWlasna(){
        Random generator = new Random();

        try {

            Magazyn.sleep(generator.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void dzialanieNiesynchr(){

        for(int a = 1;;a++){
            this.sekcjaWlasna();
            this.sekcjaKrytyczna(a);
        }

    }
}
