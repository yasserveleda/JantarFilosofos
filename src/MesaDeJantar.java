
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yasser
 */
public class MesaDeJantar {
    private Semaphore controle;
    private Random gerador;
    
    public MesaDeJantar(){
        controle = new Semaphore(1);
        gerador = new Random();
    }

    public boolean comer(String f){
        System.out.println("Filosofo "+f+" Comendo");
        //Tempo de comer
        try {
            int time = gerador.nextInt(3);
            time = time*1000;
            //Thread.sleep(2000);
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean pensar(String f){
        System.out.println("Filosofo "+f+" Pensando");
        //Tempo de pensar
        try {
            int time = gerador.nextInt(6);
            time = time*1000;
            //Thread.sleep(5000);
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
