
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class UsuarioArquivo {
    private static File arquivo = new File("registroUsuario.dat");
    private static File logins = new File("logins.txt");
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
    public static void salva_login(String nome, String senha){
        String[] dados = null;
        try{
            FileReader fr = new FileReader(logins);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                String linha = br.readLine();
                dados = linha.split("/"); // [nome,senha]
                if (nome.equals(dados[0]) && senha.equals(dados[1])){
                    return; // impede salvar login repetido
                }
            }
            fr.close();
            br.close();
            
            FileWriter fw = new FileWriter(logins,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nome+"/");
            bw.write(senha);
            bw.newLine();
            bw.close();
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static boolean verifica_login(String nome, String senha){
        String[] dados = null;
        try{
            FileReader fr = new FileReader(logins);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                String linha = br.readLine();
                dados = linha.split("/"); // [nome,senha]
                if (nome.equals(dados[0]) && senha.equals(dados[1])){
                    return true;
                }
            }
            fr.close();
            br.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
