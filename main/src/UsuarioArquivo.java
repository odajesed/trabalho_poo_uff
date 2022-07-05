
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;



public class UsuarioArquivo {
    private FileOutputStream arquivo;
    private ObjectOutputStream obj;

    private void abre_arquivo(){
        try{
            arquivo = new FileOutputStream("registroUsuario.dat");
            obj = new ObjectOutputStream(arquivo);
        }catch(Exception e){
            System.out.println("Erro ao abrir o arquivo!");
        }
    }
    
    public void inserir(Usuario u){
        abre_arquivo();
        try{
            obj.writeObject(u);
        }catch(Exception e){
            System.out.println("Erro ao escrever no arquivo!");
        }
    }
}
