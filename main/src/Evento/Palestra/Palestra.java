

package Evento.Palestra;

import Evento.Evento;

import java.util.Random;


public class Palestra extends Evento {
    public String tema;
    private static final Random gerador = new Random();

    Palestrante palestrante;
    Random random = new Random();
    long p = random.nextLong();
    public Palestra(String tipo, int numero_maximo, float preco, float duracao, String data, int horario, String tema, Palestrante palestrante, String status) {
        super(tipo, numero_maximo, preco, duracao, data, horario,status);
        this.tema = tema;
        this.palestrante = palestrante;
        this.status = status;
    }

    public void fim_palestra() throws Exception {
        if(this.status != "Acabou")
        {
            throw new Exception("A palestra ainda não acabou!");
        }
        else
        {
            System.out.println("A palestra acabou: aqui está seu código para resgatar o certificado!");
            System.out.println(p);

        }
    }
}
