import Evento.Evento;
import Evento.EventoArquivo;
import Evento.Jogo.Jogo;
import Evento.Palestra.Palestra;
import Evento.Palestra.Palestrante;
import Evento.Show.Artista;
import Evento.Show.Show;
import Evento.Gerenciador_Palestra;
import Evento.StatusEvento;

import java.util.Scanner;

import static Evento.Evento.printar_neventos;

public class Main {
    public static void main(String[] args) throws Exception {
        // POPULANDO
        Artista a1 = new Artista("Radiohead","Rock",34000);
        Evento s1 = new Show("The Radio Tour","Rock",5000,350,2,"25 de Dezembro",15,a1,StatusEvento.AGUARDANDO);
        Evento.adicionar_evento(s1);
        Artista a2 = new Artista("The Strokes","Rock",14000);
        Evento s2 = new Show("Rock in Rio","Rock",15000,500,5,"12 de outubro",1,a2,StatusEvento.AGUARDANDO);
        Evento.adicionar_evento(s2);
        Palestrante p1 = new Palestrante("Boca09","Creche");
        Evento pale1 = new Palestra("Como ser um gênio?","Comédia",100,5,1,"10 de Setembro",10,"Comediante",p1,StatusEvento.AGUARDANDO);
        Evento.adicionar_evento(pale1);


        Evento.cria_arquivo();
        //Evento.remover_evento(s1);
        //Evento.atualiza_avaliacao(pale1, 2);
        //Evento.imprimir_eventos();

        //Gerenciador_Palestra.fim_palestra(pale1);






        Scanner sc1 = new Scanner(System.in);
        int numero = 1;
        String nome;
        String senha;
        System.out.println("                             ___ \n" +
                " _ __   ___  _ __ ___   ___  |__ \\\n" +
                "| '_ \\ / _ \\| '_ ` _ \\ / _ \\   / /\n" +
                "| | | | (_) | | | | | |  __/  |_| \n" +
                "|_| |_|\\___/|_| |_| |_|\\___|  (_)\n\n");
        nome = sc1.nextLine();
        System.out.print("\nSenha: ");
        senha = sc1.nextLine();

        Usuario user = new Usuario(nome,"113-534-235-09",10000);
        
        if (!UsuarioArquivo.verifica_login(nome, senha)){
            System.out.println("Login Inválido!");
            numero = -1;
        }

        int escolha = 0;
        while(numero == 1)
        {
            System.out.print(" _          _       \n" +
                    "| |    ___ (_) __ _ \n" +
                    "| |   / _ \\| |/ _` |\n" +
                    "| |__| (_) | | (_| |\n" +
                    "|_____\\___// |\\__,_|\n" +
                    "         |__/\n\n");
            System.out.println("_______________________________________");
            System.out.println("| 1 - Comprar um Evento               |");
            System.out.println("+_____________________________________+");
            System.out.println("| 2 - Todos eventos                   |");
            System.out.println("+_____________________________________+");
            System.out.println("| 3 - Informações do usuário          |");
            System.out.println("+_____________________________________+");
            System.out.println("| 4 - Avaliações dos eventos          |");
            System.out.println("+_____________________________________+");
            System.out.println("| 5 - Historico de eventos            |");
            System.out.println("+_____________________________________+");
            System.out.println("| 0 - Sair da interface               |");
            System.out.println("_______________________________________\n\n");
            escolha = sc1.nextInt();


            switch(escolha)
            {
                case 0:
                    numero = -1;
                    break;

                case 1:
                    while( escolha == 1)
                    {
                        int evento_compra = 0;
                        System.out.print(" _____                 _            \n" +
                                "| ____|_   _____ _ __ | |_ ___  ___ \n" +
                                "|  _| \\ \\ / / _ \\ '_ \\| __/ _ \\/ __|\n" +
                                "| |___ \\ V /  __/ | | | || (_) \\__ \\\n" +
                                "|_____| \\_/ \\___|_| |_|\\__\\___/|___/\n\n");
                        System.out.println(" Escolha qual evento comprar!   ");
                        Evento.printar_todoseventos();

                        evento_compra = sc1.nextInt();
                        user.compra_evento(printar_neventos(evento_compra -1));

                        break;
                    }
                case 2:
                    while( escolha == 2)
                    {
                        //Evento.printar_todoseventos();
                        Evento.imprimir_eventos();
                        System.out.println("\n");
                        System.out.println("+_____________________________________+");
                        System.out.println("| 9 - Retornar                        |");
                        System.out.println("+_____________________________________+");
                        System.out.println("| 0 - Sair da interface               |");
                        System.out.println("_______________________________________\n\n");
                        escolha = sc1.nextInt();
                        if(escolha == 0) numero = -1;
                        if(escolha == 9) break;
                        break;
                    }
                case 3:
                    while( escolha == 3)
                    {
                        System.out.println("Você é ->  "+ user.getNome()+ "\n");
                        System.out.println("Você tem ->  "+ user.getSaldo()+" reais de saldo.");

                        user.imprimir_historico();

                        System.out.println("+_____________________________________+");
                        System.out.println("| 9 - Retornar                        |");
                        System.out.println("+_____________________________________+");
                        System.out.println("| 0 - Sair da interface               |");
                        System.out.println("_______________________________________\n\n");
                        escolha = sc1.nextInt();
                        if(escolha == 0) numero = -1;
                        if(escolha == 9) break;
                        break;
                    }

                case 4:
                    while( escolha == 4) {
                        int ev = 0;
                        int nota = 0;
                        System.out.print("    _             _ _                       \n" +
                                "   / \\__   ____ _| (_) __ _  ___ __ _  ___  \n" +
                                "  / _ \\ \\ / / _` | | |/ _` |/ __/ _` |/ _ \\ \n" +
                                " / ___ \\ V / (_| | | | (_| | (_| (_| | (_) |\n" +
                                "/_/   \\_\\_/ \\__,_|_|_|\\__,_|\\___\\__,_|\\___/ \n\n");
                        System.out.println(" Qual evento deseja avaliar?   ");
                        Evento.printar_todoseventos();
                        ev = sc1.nextInt();
                        System.out.println(" De 1 - 5 quanto você da para o evento?   ");
                        nota = sc1.nextInt();
                        if (ev == 1) EventoArquivo.atualiza_avaliacao(s1, nota);///////////////////////
                        if (ev == 2) EventoArquivo.atualiza_avaliacao(s2, nota);
                        if (ev == 3) EventoArquivo.atualiza_avaliacao(pale1, nota);
                        System.out.println(" Sua avaliação foi salva!   ");
                        Evento.imprimir_eventos();
                        System.out.println("+_____________________________________+");
                        System.out.println("| 9 - Retornar                        |");
                        System.out.println("+_____________________________________+");
                        System.out.println("| 0 - Sair da interface               |");
                        System.out.println("_______________________________________\n\n");
                        
                        escolha = sc1.nextInt();
                        if (escolha == 0) numero = -1;
                        if (escolha == 9) break;
                        break;
                    }

                case 5:
                    while(escolha == 5)
                    {
                        user.imprimir_historico();
                        System.out.println("\n\n");
                        System.out.println("+_____________________________________+");
                        System.out.println("| 9 - Retornar                        |");
                        System.out.println("+_____________________________________+");
                        System.out.println("| 0 - Sair da interface               |");
                        System.out.println("_______________________________________\n\n");
                        escolha = sc1.nextInt();
                        if(escolha == 0) numero = -1;
                        if(escolha == 9) break;
                        break;
                    }
                break;

            }



        }







    }

}
