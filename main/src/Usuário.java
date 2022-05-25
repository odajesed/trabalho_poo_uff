import Evento.Evento;

import java.util.ArrayList;

public class Usuário {

    String cpf;
    float saldo;

    // O usuário só pode se inscrever em 5 eventos por CPF!
    // LISTA COM TODOS EVENTOS JA COMPRADOS PELO USUARIO E PROMOCAO POR COMPRA
    ArrayList<Evento> lista_de_eventos = new ArrayList<Evento>(5);

    public Usuário(String cpf, float saldo)
    {
        this.saldo = saldo;
        this.cpf = cpf;
    }


    public void add_to_lista_de_eventos(Evento evento)
    {
        if(lista_de_eventos.size() == 5)
        {
            throw new IndexOutOfBoundsException("Vocẽ já está inscrito em muitos eventos!");
        }
        else {
            lista_de_eventos.add(evento);
        }
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
    public void compra_evento(Evento evento) throws Exception {
        if(saldo - evento.preco < 0)
        {
            throw new Exception("Vocẽ não tem saldo!");
        }
        else {
            saldo -= evento.preco;
            this.add_to_lista_de_eventos(evento);
        }
    }

}
