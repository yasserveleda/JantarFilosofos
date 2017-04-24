
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yasser
 */
public class JantarFilosofos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        int numeroFilosofos = 3;
        Semaphore mutex1, mutex2, mutex3;
        ArrayList<Filosofo> lista = new ArrayList<>();
        
        mutex1 = new Semaphore(1);
        mutex2 = new Semaphore(1);
        mutex3 = new Semaphore(1);
        
        MesaDeJantar mesa = new MesaDeJantar();
        
        //Inserção dos filosofos dinamicos
        for(int k = 0; k< numeroFilosofos; k++){
            if(k == 0){
                lista.add(new Filosofo(k+1+"", mesa, new Semaphore(1), new Semaphore(1)));
            } else if( k == numeroFilosofos -1){
                lista.add(new Filosofo(k+1+"", mesa, lista.get(k-1).getGarfoDireito(), lista.get(0).getGarfoEsquerdo()));
            } else {
                lista.add(new Filosofo(k+1+"", mesa, lista.get(k-1).getGarfoDireito(), new Semaphore(1)));
            }
        }
        
        //Liberando os filosofos        
        for(int j=0; j < numeroFilosofos; j++){
          new Thread(lista.get(j)).start();
        }
        
        /*
        Filosofo filosofo1 = new Filosofo("1", mesa, mutex1, mutex2);
        Filosofo filosofo2 = new Filosofo("2", mesa, mutex2, mutex3);
        Filosofo filosofo3 = new Filosofo("3", mesa, mutex3, mutex1);
        Thread f1 = new Thread (filosofo1);
        f1.start();
        Thread f2 = new Thread (filosofo2);
        f2.start();
        Thread f3 = new Thread (filosofo3);
        f3.start();
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                //seu codigo aqui
                f1.interrupt();
                f2.interrupt();
                f3.interrupt();
                System.out.println("Terminou \n");
                System.out.println("1: "+filosofo1.getVezesComeu());
                System.out.println("2: "+filosofo2.getVezesComeu());
                System.out.println("3: "+filosofo3.getVezesComeu());
                System.exit(0);
            }
        }, 10000, 1000);
        */
    }
    
}
