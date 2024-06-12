package org.example;

public class Aluno implements Comparable<Aluno>{
    private String nome;
    private int matricula;
    private String curso;
    private float media;

    @Override
    public int compareTo(Aluno a) {
        return Float.compare(this.media, a.getMedia());
    }

    public void mostraInfo(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Curso: " + this.curso);
        System.out.println("Média: " + this.media + "\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
}
