
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
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int i;
        int numeroFilosofos = 4;
        ArrayList<Filosofo> lista = new ArrayList<>();

        
        MesaDeJantar mesa = new MesaDeJantar();
        
        //Inserção dos filosofos dinamicos
        for(int k = 0; k< numeroFilosofos; k++){
            if(k == 0){
                lista.add(new Filosofo(k+1+"", mesa, new Semaphore(1), new Semaphore(1)));
                System.out.println("Filosofo " + (k+1));
            } else if( k == numeroFilosofos -1){
                lista.add(new Filosofo(k+1+"", mesa, lista.get(k-1).getGarfoDireito(), lista.get(0).getGarfoEsquerdo()));
                System.out.println("Filosofo " + (k+1));
            } else {
                lista.add(new Filosofo(k+1+"", mesa, lista.get(k-1).getGarfoDireito(), new Semaphore(1)));
                System.out.println("Filosofo " + (k+1));
            }
        }
        System.out.println("-- Filosofos Criados --\n");
        Thread.sleep(1000);

        //Liberando os filosofos
        for(int j=0; j < numeroFilosofos; j++){
          new Thread(lista.get(j)).start();
        }
        
        Thread.sleep(10000);
        
        for(int j=0; j < numeroFilosofos; j++){
          lista.get(j).setChave();
        }
        
        System.out.println("-- Fim do Jantar --\n");
        Thread.sleep(3000);
        
        System.out.println("-- Resultados --");
        for(int j=0; j < numeroFilosofos; j++){
            System.out.println("Filosofo "+lista.get(j).getNome()+" comeu: "+lista.get(j).getVezesComeu());
            System.out.println("Filosofo "+lista.get(j).getNome()+" pensou: "+lista.get(j).getVezesPensou());
        }
        
    }
    
}
