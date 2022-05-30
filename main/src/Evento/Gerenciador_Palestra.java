
package Evento;
import java.util.Random;
import java.util.Random;

import Evento.Evento;
import Evento.Palestra.Palestra;



public class Gerenciador_Palestra {

    static Random random = new Random();
    static long p = random.nextLong();
    public static void fim_palestra(Evento p1) throws Exception {
        if(p1.status != "Acabou")
        {
            throw new Exception("A palestra ainda não acabou!");
        }
        else
        {
            System.out.println("A palestra acabou: aqui está seu código para resgatar o certificado!");
            System.out.println(p);

        }
    }
}
