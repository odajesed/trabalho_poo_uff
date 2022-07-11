import Evento.Evento;
import Evento.StatusEvento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Usuario implements Serializable{

    private String nome;
    private String senha;
    private String cpf;
    private float saldo;
    private int bonus = 0; //toda vez que o usuario realiza sua 5 compra consecutiva ele ganha um saldo extra
    private HashMap<String,Integer> historico_compras = new HashMap<String,Integer>(); // MAP COM TODOS OS EVENTOS JA COMPRADOS PELO USUARIO COM LIMITE DE 5 INGRESSOS POR EVENTO

    public Usuario(String nome,String cpf, float saldo)
    {
        this.nome = nome;
        this.saldo = saldo;
        this.cpf = cpf;
        this.senha = "123"; // fixo para facilitar testes
        UsuarioArquivo.inserir(this);
        UsuarioArquivo.salva_login(nome, senha);
    }

    public float getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return cpf;
    }
    
    public int getBonus() {
        return bonus;
    }
    
    public String getNome() {
        return nome;
    }
    
    public HashMap<String,Integer> getHistorico_compras() {
        return historico_compras;
    }
    
    public void add_to_historico_compras (Evento evento){
        if (getHistorico_compras().get(evento.getNome()) != null){
            if(getHistorico_compras().get(evento.getNome()) == 5){
                throw new IndexOutOfBoundsException("Vocẽ não pode comprar mais de 5 ingressos para o mesmo evento!");
            }else getHistorico_compras().put(evento.getNome(), getHistorico_compras().get(evento.getNome()) + 1);
        }else getHistorico_compras().put(evento.getNome(), 1);
    }
    
    public void imprimir_historico(){
        System.out.println("\nVocê possui:");
        for(Map.Entry<String, Integer> entry : getHistorico_compras().entrySet()) {
            String nome = entry.getKey();
            Integer num_ing = entry.getValue();
            System.out.println(num_ing+" ingressos para o evento "+nome);
        }
    }
    
    public void add_saldo(float n){
        // naturalmente aqui teria um processo para receber o dinheiro do usuario antes adicionar a quantia no saldo
        saldo += n;
    }
    
    public void compra_evento(Evento evento){
        if(saldo - evento.preco < 0)
        {
            System.out.println("Você não tem saldo suficiente! Deseja adicionar mais saldo? (1)SIM (2)NÃO");
            Scanner teclado = new Scanner(System.in);
            int v = teclado.nextInt();
            if (v == 1){
                System.out.println("Qual quantia deseja adicionar?");
                int q  = teclado.nextInt();
                add_saldo(q);
            }
        }else if(evento.status != StatusEvento.AGUARDANDO){
            System.out.println("O prazo para compra desse evento já foi encerrado!");
        }else {
            saldo -= evento.preco;
            bonus += 1;
            evento.vagas += 1;
            this.add_to_historico_compras(evento);
            if (bonus == 5){
                System.out.println("\n+30,00R$ de saldo bônus pela sua 5 compra conosco!");
                saldo += 30;
                bonus = 0;
            }
        }
    }
}
