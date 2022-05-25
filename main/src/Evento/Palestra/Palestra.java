package Evento.Palestra;

import Evento.Evento;

import java.util.ArrayList;

public class Palestra extends Evento {
    public String tema;
    Palestrante palestrante;
    public Palestra(String tipo, int numero_maximo, float preco, float duracao, String data, String tema, Palestrante palestrante) {
        super(tipo, numero_maximo, preco, duracao, data);
        this.tema = tema;
        this.palestrante = palestrante;
    }
}
