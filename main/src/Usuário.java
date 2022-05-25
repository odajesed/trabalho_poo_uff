import Evento.Evento;

import java.util.ArrayList;

public class Usuário {

    String cpf;
    float saldo;

    // O usuário só pode se inscrever em 5 eventos por CPF!

    ArrayList<Evento> lista_de_eventos = new ArrayList<Evento>(5);

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

    public void imprimir_lista()
    {
        for(int i =0; i< this.lista_de_eventos.size(); i++)
        {
            System.out.println(this.lista_de_eventos.get(i));
        }
    }
    public void compra_evento(Evento evento)
    {
        //Erro caso nao tenho saldo
        saldo -= evento.preco;
        this.lista_de_eventos.add(evento);
    }

}
