

package Evento.Palestra;

import Evento.Evento;
import Evento.StatusEvento;
import java.util.Random;


public class Palestra extends Evento {
    public String tema;
    private static final Random gerador = new Random();

    Palestrante palestrante;

    public Palestra(String nome, String tipo, int numero_maximo, float preco, float duracao, String data, int horario, String tema, Palestrante palestrante, StatusEvento status) {
        super(nome,tipo, numero_maximo, preco, duracao, data, horario,status);
        this.tema = tema;
        this.palestrante = palestrante;
        this.status = status;
    }


}

