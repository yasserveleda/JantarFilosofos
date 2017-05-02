
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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
        int i;
        int numeroFilosofos = 3;
        
        System.out.println("Digite o número de filosofos: ");
        Scanner teclado = new Scanner(System.in);
        
        numeroFilosofos = teclado.nextInt();
        
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
        
        System.out.println("Digite o tempo em segundos: ");
        int timer = teclado.nextInt();
        
        System.out.println("-- Jantar --");

        //Liberando os filosofos
        for(int j=0; j < numeroFilosofos; j++){
          new Thread(lista.get(j)).start();
        }
        //Setando o tempo em segundos
        Thread.sleep(timer*1000);
        
        for(int j=0; j < numeroFilosofos; j++){
          lista.get(j).setChave();
        }
        
        System.out.println("-- Fim do Jantar --\n");
        //Tempo para setar as chaves
        Thread.sleep(3000);
        
        System.out.println("-- Resultados --");
        for(int j=0; j < numeroFilosofos; j++){
            System.out.println("Filosofo "+lista.get(j).getNome()+" comeu: "+lista.get(j).getVezesComeu());
            System.out.println("Filosofo "+lista.get(j).getNome()+" pensou: "+lista.get(j).getVezesPensou());
        }
        
    }
    
}
