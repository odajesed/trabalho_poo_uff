package Evento.Jogo;

import Evento.Evento;

public class Jogo extends Evento {
    public Jogo(String tipo, int numero_maximo, float preco, float duracao, String data) {
        super(tipo, numero_maximo, preco, duracao, data);
    }
}
