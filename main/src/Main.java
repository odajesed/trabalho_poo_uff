import Evento.Evento;
import Evento.EventoArquivo;
import Evento.Jogo.Jogo;
import Evento.Palestra.Palestra;
import Evento.Palestra.Palestrante;
import Evento.Show.Artista;
import Evento.Show.Show;
import Evento.Gerenciador_Palestra;
import Evento.StatusEvento;

public class Main {
    public static void main(String[] args) throws Exception {
        Artista a1 = new Artista("a","a",13);
        Evento s1 = new Show("show 1","a",5,500,1,"a",1,a1,StatusEvento.AGUARDANDO);
        //Evento.adicionar_evento(s1);
        
        Artista a2 = new Artista("a2","a2",14);
        Evento s2 = new Show("show 2","a2",5,500,1,"a2",1,a2,StatusEvento.AGUARDANDO);
        //Evento.adicionar_evento(s2);

        Palestrante p1 = new Palestrante("a","a");
        Evento pale1 = new Palestra("palestra 1","a",5,1,1,"a",1,"a",p1,StatusEvento.AGUARDANDO);
        //Evento.adicionar_evento(pale1);

        Usuario u1 = new Usuario("Jorge","11",10000);
        UsuarioArquivo.inserir(u1);
        
        Evento.cria_arquivo();
        Evento.imprimir_eventos();
        //Evento.remover_evento(s1);
        //Evento.atualiza_avaliacao(pale1, 2);
        //Evento.imprimir_eventos();

        //Gerenciador_Palestra.fim_palestra(pale1);
        u1.compra_evento(s1);
        u1.compra_evento(s1);
        u1.compra_evento(pale1);
        u1.compra_evento(s1);
        u1.compra_evento(pale1);
        u1.imprimir_historico();
    }
}
