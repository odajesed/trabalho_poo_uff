import Evento.Evento;
import Evento.Jogo.Jogo;
import Evento.Palestra.Palestra;
import Evento.Show.Artista;
import Evento.Show.Show;


public class Main {
    public static void main(String[] args) {
        Artista a1 = new Artista("a","a",13);
        Evento s1 = new Show("a",5,1,1,"a",a1);


        Evento.adicionar_evento(s1);
        Evento.imprimir_lista();

    }
}