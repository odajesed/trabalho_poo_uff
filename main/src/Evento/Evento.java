package Evento;

import jdk.jfr.Event;

import java.util.ArrayList;

public abstract class Evento {
    public String nome;
    public String tipo;
    public int numero_maximo;
    public int vagas = 0;
    public float preco;
    public float duracao;
    public String data;
    public int horario;
    public String status;
    //ENUM
    //CLASSIFICACAO FLOAT;

    static ArrayList<Evento> eventos = new ArrayList<Evento>(20);
    public Evento(String nome, String tipo, int numero_maximo, float preco,float duracao, String data,int horario,String status)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.numero_maximo = numero_maximo;
        this.preco = preco;
        this.duracao = duracao;
        this.data = data;
        this.horario = horario;
        this.status = status;
    }

    public int get_vagas_restantes() {
        return numero_maximo - vagas;

        // NUMERO MAX = 50
        // VAGAS = 10
        // Logo, vagas restantes são 50-10 = 40
    }
    public static void adicionar_evento(Evento evento)
    {
        eventos.add(evento);
    }
    public static void imprimir_lista()
    {
        for(int i =0; i< eventos.size(); i++)
        {
            System.out.println(eventos.get(i));
        }
    }
    //Toda vez que comprar evento adiciona +1 em vagas

}
