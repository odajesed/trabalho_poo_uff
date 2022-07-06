
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;



public class UsuarioArquivo {
    private static FileOutputStream arquivo;
    private static ObjectOutputStream obj;

    private static void abre_arquivo(){
        try{
            arquivo = new FileOutputStream("registroUsuario.dat");
            obj = new ObjectOutputStream(arquivo);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void inserir(Usuario u){
        abre_arquivo();
        try{
            obj.writeObject(u);
        }catch(Exception e){
            System.out.println(e.getMessage()); // mensagem de erro = Usuario (?)
        }
    }
}
