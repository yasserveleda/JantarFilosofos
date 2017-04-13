
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
    
    public MesaDeJantar(){
        controle = new Semaphore(1);
    }
    
    public boolean comer(String f){
        System.out.println("Filosofo "+f+" Comendo");
        return true;
    }
    
    public boolean pensar(String f){
        System.out.println("Filosofo "+f+" Pensando");
        return true;
    }
}
