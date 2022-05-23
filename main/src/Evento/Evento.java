package Evento;

import jdk.jfr.Event;

public abstract class Evento {
    public String tipo;
    public int numero_maximo;
    public int vagas = 0;
    public float preco;
    public float duracao;
    public String data;

    public Evento(String tipo, int numero_maximo, float preco,float duracao, String data)
    {
        this.tipo = tipo;
        this.numero_maximo = numero_maximo;
        this.preco = preco;
        this.duracao = duracao;
        this.data = data;
    }

    public int get_vagas_restantes() {
        return numero_maximo - vagas;

        // NUMERO MAX = 50
        // VAGAS = 10
        // Logo, vagas restantes são 50-10 = 40
    }

    //Toda vez que comprar evento adiciona +1 em vagas

}
