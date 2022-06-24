package Evento.Show;

import Evento.Evento;

public class Show extends Evento {
    Artista artista;
    public Show(String nome,String tipo, int numero_maximo, float preco, float duracao, String data,int horario, Artista artista,String status) {
        super(nome,tipo, numero_maximo, preco, duracao, data,horario,status);
        this.artista = artista;
    }

}

