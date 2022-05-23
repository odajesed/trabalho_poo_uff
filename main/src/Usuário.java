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


}
