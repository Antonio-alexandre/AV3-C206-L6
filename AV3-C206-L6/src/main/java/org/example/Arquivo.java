package org.example;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public void escrever(Aluno aluno){
        // Importando as classes que nos permitirão escrever no Arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;


        try {
            // Recebe o nome do arquivo
            os = new FileOutputStream("Alunos.txt",true); // Arquivo
            // Mostra em qual arquivo será escrito
            osw = new OutputStreamWriter(os);
            // Permite que edite o arquivo
            bw = new BufferedWriter(osw);

            // Escrevendo os dados no arquivo
            bw.write("****ALUNOS****" + "\n");
            bw.write(aluno.getNome() + "\n");
            bw.write(aluno.getMatricula() + "\n");
            bw.write(aluno.getCurso() + "\n");
            bw.write(aluno.getMedia() + "\n");

        } catch (IOException e) {
            System.out.println("ERRO: "+e);
        }finally{
            // Fechando a entrada de dados
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public ArrayList<Aluno> ler(){
        // Criando array list que armazena os alunos encontrados no arquivo
        ArrayList<Aluno> encontrou = new ArrayList<>();

        // Estruturas para a leitura dos dados
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String linhaLer; // Auxiliar que servirá como ponteiro para o arquivo

        try{
            is = new FileInputStream("Alunos.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);


            // Posiciando o cursor no inicio do Arquivo
            linhaLer = br.readLine();

            // Verificando e executando enquanto tiver informações no txt
            while(linhaLer!=null){
                // Verificando se encontramos a flag que indica um aluno
                if(linhaLer.contains("****ALUNOS****")){
                    // Criando um aluno auxiliar
                    Aluno aux = new Aluno();

                    // Lendo as informações do aluno
                    aux.setNome(br.readLine());
                    aux.setMatricula(Integer.parseInt(br.readLine()));
                    aux.setCurso(br.readLine());
                    aux.setMedia(Float.parseFloat(br.readLine()));


                    // Adicionando o aluno na lista de alunos encontrados no arquivo
                    encontrou.add(aux);
                }
                linhaLer = br.readLine();
            }
        }catch(Exception e){
            System.out.println("ERRO: "+e);
        }finally{
            try{
                br.close();
            }catch(Exception e){
                System.out.println("ERRO: "+e);
            }
        }
        return encontrou;
    }
}