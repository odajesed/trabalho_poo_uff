import Evento.Evento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Usuário {

    String cpf;
    float saldo;
    int bonus = 0; //toda vez que o usuario realiza sua 5 compra consecutiva ele ganha um saldo extra
    
    // MAP COM TODOS OS EVENTOS JA COMPRADOS PELO USUARIO COM LIMITE DE 5 INGRESSOS POR EVENTO
    HashMap<String,Integer> historico_compras = new HashMap<String,Integer>();

    public Usuário(String cpf, float saldo)
    {
        this.saldo = saldo;
        this.cpf = cpf;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void add_to_historico_compras (Evento evento){
        if (historico_compras.get(evento.nome) != null){
            if(historico_compras.get(evento.nome) == 5){
                throw new IndexOutOfBoundsException("Vocẽ não pode comprar mais de 5 ingressos para o mesmo evento!");
            }else historico_compras.put(evento.nome, historico_compras.get(evento.nome) + 1);
        }else historico_compras.put(evento.nome, 1);
    }
    
    public void imprimir_historico(){
        System.out.println("\nVocê possui:");
        for(Map.Entry<String, Integer> entry : historico_compras.entrySet()) {
            String nome = entry.getKey();
            Integer num_ing = entry.getValue();
            System.out.println(num_ing+" ingressos para o evento "+nome);
        }
    }
    
    public void compra_evento(Evento evento) throws Exception {
        if(saldo - evento.preco < 0)
        {
            throw new Exception("Vocẽ não tem saldo!");
        }
        else {
            saldo -= evento.preco;
            bonus += 1;
            this.add_to_historico_compras(evento);
            if (bonus == 5){
                System.out.println("\n+30,00R$ de saldo bônus pela sua 5 compra conosco!");
                saldo += 30;
                bonus = 0;
            }
        }
    }
}
