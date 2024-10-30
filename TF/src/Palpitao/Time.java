package Palpitao;

public class Time {
    String nome;
    int pontos;
    
public Time(String nome) {
    this.nome = nome;
    this.pontos = 0;
}

public int getPontos() {
    return pontos;
}

public void adicionarPontos(int pontos) {
    this.pontos += pontos;


}
}
