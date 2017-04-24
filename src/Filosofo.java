
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
public class Filosofo implements Runnable{
    private MesaDeJantar mesa;
    private int comeu, pensou;
    private Semaphore garfoEsquerdo, garfoDireito;
    private String nome;
    
    public Filosofo(String nome, MesaDeJantar mesa, Semaphore esquerdo, Semaphore direito){
        this.nome = nome;
        this.mesa = mesa;
        comeu = 0;
        pensou = 0;
        garfoEsquerdo = esquerdo;
        garfoDireito = direito;
    }
    
    public Semaphore getGarfoEsquerdo(){
        return garfoEsquerdo;
    }
    
    public Semaphore getGarfoDireito(){
        return garfoDireito;
    }
    
    public int getVezesComeu(){
        return comeu;
    }
    
    @Override
    public void run() {
       
       while(true){
        //Tentativa de pegar o garfo direito
        if(garfoDireito.tryAcquire()){
            //Tentativa de pegar o garfo esquerdo
            if(garfoEsquerdo.tryAcquire()){
                //Pegou 2 garfos e esta comendo
                mesa.comer(nome);
                comeu++;
                garfoEsquerdo.release();
                garfoDireito.release();
                
            } else {
                //Soltar garfo direito
                garfoDireito.release();
                
            }
         } else {
            //Garfos ocupados
            mesa.pensar(nome);
         }
       }
        
    }

    void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
