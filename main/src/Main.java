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
        //EventoArquivo.inserir(s1);

        Palestrante p1 = new Palestrante("a","a");
        Evento pale1 = new Palestra("palestra 1","a",5,1,1,"a",1,"a",p1,StatusEvento.AGUARDANDO);
        //EventoArquivo.inserir(pale1);

        Usuario u1 = new Usuario("Jorge","11",10000);
        
        EventoArquivo.cria_arquivo();
        EventoArquivo.listar();
        //EventoArquivo.remover(s1);
        EventoArquivo.atualiza_avaliacao(pale1, 2);
        EventoArquivo.listar();

        //Gerenciador_Palestra.fim_palestra(pale1);
        u1.compra_evento(s1);
        u1.compra_evento(s1);
        u1.compra_evento(pale1);
        u1.compra_evento(s1);
        u1.compra_evento(pale1);
        u1.imprimir_historico();
    }
}
