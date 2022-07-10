
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;



public class UsuarioArquivo {
    private static File arquivo = new File("registroUsuario.dat");
    private static FileOutputStream fos;
    private static ObjectOutputStream obj;

    private static void abre_arquivo(){
        try{
            fos = new FileOutputStream(arquivo);
            obj = new ObjectOutputStream(fos);
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
