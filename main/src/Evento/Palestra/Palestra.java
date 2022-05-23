package Evento.Palestra;

import Evento.Evento;

public class Palestra extends Evento {
    public String tema;
    public Palestra(String tipo, int numero_maximo, float preco, float duracao, String data, String tema) {
        super(tipo, numero_maximo, preco, duracao, data);
        this.tema = tema;
    }
}
