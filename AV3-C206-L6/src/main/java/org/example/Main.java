package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Arquivo arquivo = new Arquivo();

        int op = 0;

        do{
            System.out.println("Escolha a operação a ser realizada: ");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Listar alunos por media (menor à maior)");
            System.out.println("4 - Mostrar a quantidade de alunos existentes por curso");
            System.out.println("0 - Sair " + "\n");

            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    Aluno aluno = new Aluno();
                    System.out.println("Digite o nome do aluno: ");
                    aluno.setNome(sc.nextLine());

                    System.out.println("Digite a matricula do aluno: ");
                    int matricula = sc.nextInt();
                    try{
                        if(matricula <= 0){
                            throw new InfoInvalidaException("Nenhum aluno pode ter matricula menor ou igual a 0!");
                        }
                        else {
                            aluno.setMatricula(matricula);
                            sc.nextLine();
                        }
                    } catch(InfoInvalidaException e){
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.println("Digite o curso do aluno: ");
                    String curso = sc.nextLine();
                    try{
                        if(!curso.equals("Computação") && !curso.equals("Software") && !curso.equals("Telecomunicações")){
                            throw new InfoInvalidaException("Os alunos só podem pertencer aos seguintes cursos: Computação, Software ou Telecomunicações!");
                        }
                        else{
                            aluno.setCurso(curso);
                        }
                    }catch(InfoInvalidaException e){
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.println("Digite a média do aluno: ");
                    aluno.setMedia(sc.nextFloat());

                    arquivo.escrever(aluno);
                    break;
                case 2:
                    alunos = arquivo.ler();
                    for(Aluno a : alunos){
                        a.mostraInfo();
                    }
                    break;
                case 3:
                    alunos = arquivo.ler();

                    Collections.sort(alunos);

                    for(Aluno a : alunos){
                        a.mostraInfo();
                    }
                    break;
                case 4:
                    alunos = arquivo.ler();

                    int totalComp = 0;
                    int totalSoft = 0;
                    int totalTeleco = 0;

                    for(Aluno a : alunos){
                        if(a.getCurso().equals("Computação"))
                            totalComp++;
                        else if(a.getCurso().equals("Software"))
                            totalSoft++;
                        else
                            totalTeleco++;
                    }

                    System.out.println("Quantidade de produtos do curso de Computação: " + totalComp);
                    System.out.println("Quantidade de produtos do curso de Software: " + totalSoft);
                    System.out.println("Quantidade de produtos do curso de Telecomunicações: " + totalTeleco + "\n");
                    break;
                case 0:
                    System.out.println("Finalizando menu...");
                    break;
            }
        }while(op != 0);
    }
}