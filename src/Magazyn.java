import java.util.Random;

public class Magazyn extends Thread{

    static int liczbaWatkow=0;
    static volatile  boolean wybieranie[] = new boolean[5];
    static volatile int numerek[] = new int [5];
    int numer;
    int tryb;
    int zasoby;
    Magazyn( int tryb){
        numer = liczbaWatkow;
        liczbaWatkow++;
        wybieranie[numer] = false;
        numerek[numer] = 0;
        this.tryb = tryb;
        zasoby = 100;
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

    void sekcjaKrytyczna(int a) {
        System.out.println("jade do magazynu " + numer);
        try {
            Magazyn.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
