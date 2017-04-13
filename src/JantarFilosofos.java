
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
        int numeroFilosofos = 2;
        Semaphore mutex1, mutex2, mutex3;
        
        mutex1 = new Semaphore(1);
        mutex2 = new Semaphore(1);
        mutex3 = new Semaphore(1);
        
        
        MesaDeJantar mesa = new MesaDeJantar();
        //Filosofo f1 = new Filosofo(mesa, mutex1, mutex2);
        
        Thread f1 = new Thread (new Filosofo("1", mesa, mutex1, mutex2));
        f1.start();
        
        Thread f2 = new Thread (new Filosofo("2", mesa, mutex1, mutex2));
        f2.start();
        
        Thread f3 = new Thread (new Filosofo("3", mesa, mutex1, mutex2));
        f3.start();
        
        //Filosofo f2 = new Filosofo(mesa, mutex2, mutex3);
        //Filosofo f3 = new Filosofo(mesa, mutex3, mutex1);
        
    }
    
}
