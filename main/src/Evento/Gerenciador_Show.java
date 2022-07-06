package Evento;

import Evento.Jogo.Jogo;
import Evento.Jogo.Time;
import Evento.Show.Show;

public class Gerenciador_Show {
    public void fim_jogo(Show j) throws Exception{

        if (j.status == StatusEvento.EM_ANDAMENTO){
            System.out.println("O show de " + j.getNome() + " está acontecendo!");

        }
    }
}
