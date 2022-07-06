package Evento;

import jdk.jfr.Event;

import java.util.ArrayList;

public abstract class Evento { // nao podem existir 2 eventos com o mesmo nome
    private String nome;
    public String tipo;
    public int numero_maximo;
    public int vagas = 0;
    public float preco;
    public float duracao;
    private String data;
    public int horario;
    public StatusEvento status;
    private float avaliacao_media;

    private ArrayList<Float> avaliacoes = new ArrayList<Float>(); // salva todas as avaliacoes que esse evento recebeu
    private static ArrayList<Evento> eventos = new ArrayList<Evento>(20); // lista usada para armazenar todos os eventos cadastrados
    
    public Evento(String nome, String tipo, int numero_maximo, float preco,float duracao, String data,int horario, StatusEvento status)
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
    public static void cria_arquivo(){
        EventoArquivo.cria_arquivo();
    }
    public static void atualiza_avaliacao(Evento e, float n){
        EventoArquivo.atualiza_avaliacao(e, n);
    }
    public static void adicionar_evento(Evento evento)
    {
        eventos.add(evento);
        EventoArquivo.inserir(evento);
    }
    public static void remover_evento(Evento evento){
        eventos.remove(evento);
        EventoArquivo.remover(evento);
    }
    public static void imprimir_eventos()
    {
        EventoArquivo.listar();
    }
    public float calc_avaliacao_media(float n){ // recebe a nota 'n' do usuario e a usa para calcular a nova media de avaliacao do evento
        avaliacoes.add(n);
        float soma = 0;
        for (float e : avaliacoes){
            soma += e;
        }
        avaliacao_media = soma/avaliacoes.size();
        return avaliacao_media;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @return the avaliacao_media
     */
    public float getAvaliacao_media() {
        return avaliacao_media;
    }
}
