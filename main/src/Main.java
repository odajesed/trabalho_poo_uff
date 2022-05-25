import Evento.Evento;
import Evento.Jogo.Jogo;
import Evento.Palestra.Palestra;
import Evento.Palestra.Palestrante;
import Evento.Show.Artista;
import Evento.Show.Show;


public class Main {
    public static void main(String[] args) {
        Artista a1 = new Artista("a","a",13);
        Evento s1 = new Show("a",5,1,1,"a",a1);

        Palestrante p1 = new Palestrante("a","a");
        Evento pale1 = new Palestra("a",5,1,1,"a","a",p1);

        Usuário u1 = new Usuário("11",1000);
        u1.compra_evento(s1);
        u1.imprimir_lista();




    }
}