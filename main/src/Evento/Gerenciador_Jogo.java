
package Evento;

import Evento.Evento;
import Evento.Jogo.*;


public class Gerenciador_Jogo {
    
    public void fim_jogo(Jogo j, Time t1, Time t2,int g1, int g2) throws Exception{
        
        if (j.status.equals("Acabou!")){
            System.out.println("Esse jogo já foi encerrado!");
            
        }else throw new Exception("O jogo ainda não acabou!");
        
        if (g1 > g2){
            System.out.println(t1.nome + " ganhou!\nPlacar: " + g1 + "x" + g2);
        }
        else if (g2 < g1){
            System.out.println(t2.nome + " ganhou!\nPlacar: " + g1 + "x" + g2);
        }
        else System.out.println("O jogo terminou empatado!\nPlacar: " + g1 + "x" + g2);
    }
}
