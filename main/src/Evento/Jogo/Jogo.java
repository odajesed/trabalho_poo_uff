package Evento.Jogo;

import Evento.Evento;
// METODO PRA VER SE O JOGO JA PASSOU, O RESULTADO
public class Jogo extends Evento {
    public Jogo(String tipo, int numero_maximo, float preco, float duracao, String data,int horario,String status) {
        super(tipo, numero_maximo, preco, duracao, data,horario,status);
    }
}
