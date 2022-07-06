/*
    O ARQUIVO NÃO ESTÁ SENDO USADO COMO ARMAZENAMENTO PRINCIPAL DOS DADOS DE UM EVENTO, E SIM COMO UM MEIO DE SALVAR AS AVALIACOES DE CADA EVENTO
*/
package Evento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EventoArquivo {
    private static File arquivo = new File("registroEvento.txt");
    
    public static void cria_arquivo(){
        try{
            arquivo.createNewFile();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void inserir(Evento c){
        try{
            FileWriter fw = new FileWriter(arquivo,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(c.getNome()+"/");
            bw.write(c.getAvaliacao_media()+"/");
            bw.write(c.getData());
            bw.newLine();
            bw.close();
            fw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void inserir(String nome, float avaliacaoMedia, String data){
        try{
            FileWriter fw = new FileWriter(arquivo,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nome+"/");
            bw.write(avaliacaoMedia+"/");
            bw.write(data);
            bw.newLine();
            bw.close();
            fw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void remover(Evento evento){
        String[] dados = null;
        ArrayList<String> salvar = new ArrayList<String>();
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                String linha = br.readLine();
                dados = linha.split("/"); // [nome,avaliacao,data]
                if (!evento.getNome().equals(dados[0])){
                    salvar.add(linha);
                }
            }
            fr.close();
            br.close();
            
            FileWriter fw = new FileWriter(arquivo);
            fw.close(); // apaga o conteudo do arquivo
            
            FileWriter fw2 = new FileWriter(arquivo,true);
            BufferedWriter bw = new BufferedWriter(fw2);
            
            System.out.println(salvar.size());
            for (int i=0; i<salvar.size(); i++){
                bw.write(salvar.get(i));
                bw.newLine();
            }
            bw.close();
            fw2.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void atualiza_avaliacao(Evento evento, float n){ // 'n' é a nota do usuario para aquele evento
        float novaNota = evento.calc_avaliacao_media(n);
        String[] dados = null;
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                String linha = br.readLine();
                dados = linha.split("/"); // [nome,avaliacao,data]
                if (evento.getNome().equals(dados[0])){
                    break;
                }
            }
            fr.close();
            br.close();
            
            remover(evento);
            inserir(dados[0],novaNota,dados[2]);
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void listar(){
        String[] dados = null;
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("NOME / AVALIAÇÃO / DATA");
            while(br.ready()){
                String linha = br.readLine();
                dados = linha.split("/"); // [nome,avaliacao,data]
                System.out.print(dados[0]+" / ");
                System.out.print(dados[1]+" / ");
                System.out.println(dados[2]+" / ");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
