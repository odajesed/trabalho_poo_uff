import Evento.Evento;
import Evento.Jogo.Jogo;
import Evento.Palestra.Palestra;
import Evento.Palestra.Palestrante;
import Evento.Show.Artista;
import Evento.Show.Show;


public class Main {
    public static void main(String[] args) throws Exception {
        Artista a1 = new Artista("a","a",13);
        Evento s1 = new Show("a",5,500,1,"a",1,a1,"A");

        Palestrante p1 = new Palestrante("a","a");
        Evento pale1 = new Palestra("a",5,1,1,"a",1,"a",p1,"Acabou");

        Usuário u1 = new Usuário("11",10000);

        ((Palestra) pale1).fim_palestra();
        u1.compra_evento(s1);
        u1.imprimir_lista();




    }
}