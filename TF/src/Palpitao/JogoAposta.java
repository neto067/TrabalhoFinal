package Palpitao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


class Jogador{
	String nome;
	int fichas = 50;
	List<Integer> fichasPalpite = new ArrayList<Integer>();
	List<String> timePalpite = new ArrayList<String>();
	int resultado;
	

public Jogador(String nome,int fichas) {
	this.nome = nome;
	this.fichas = fichas;
}	

public List<String> getTimePalpite() {
    return timePalpite;
}

public List<Integer> getFichasPalpite() {
	    return fichasPalpite;
	}

public int getResultado() {
    return resultado;
}

public void setResultado(int resultado) {
    this.resultado = resultado;

}
}


class jogo{
     static List<Integer> golsTime1 = new ArrayList<Integer>();
     static List<Integer> golsTime2 = new ArrayList<Integer>();
     
public List<Integer> getgolsTime1() {
 	    return golsTime1;
}

public List<Integer> getgolsTime2() {
	    return golsTime2;
	}
}

     

public class JogoAposta{
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	
	System.out.print("Informe o nome do Jogador 1: ");
		Jogador jogador1 = new Jogador(scanner.nextLine(), 50);

    System.out.print("Informe o nome do Jogador 2: ");
    	Jogador jogador2 = new Jogador(scanner.nextLine(), 50);
      
    	
    System.out.println("_______________");
        
    System.out.println("\nSejam bem-vindos " + jogador1.nome + " e " + jogador2.nome + "!");
    System.out.println("Vocês têm " + jogador1.fichas + " fichas para palpitar nos seus times escolhidos.");
     
        
    List<Time> times = new ArrayList<>();
    int numeroDeTimes;
        
    System.out.println("_______________");
        
    while (true) {	
    	System.out.print("\nEscolha o número de times para compor o campeonato (4 ou 8): ");
    		numeroDeTimes = scanner.nextInt();
            scanner.nextLine(); 

            if (numeroDeTimes == 4 || numeroDeTimes == 8) {
            	break;}
            
            else {
            	System.out.println("Número de times inválido. Escolha 4 ou 8.");}
        }
    
    
    System.out.println("\n");
        
        
    for(int i = 1; i <= numeroDeTimes; i++) {
    	System.out.print("Informe o nome do time " + i + ": ");
    	String nomeTime = scanner.nextLine();
    	
    	times.add(new Time(nomeTime));
        }
    
      
    System.out.println("_______________");
    System.out.println("\nPartidas do Campeonato:");
    System.out.println("_______________");
        
    
    Palpites(times, scanner, jogador1);
    
    System.out.println("_____________________");
    
    Palpites(times, scanner, jogador2);
		
	System.out.println("_____________________");

	 for (int i = 0; i < times.size(); i++) {
		for (int j = i + 1; j < times.size(); j++) {
			
			Time time1 = times.get(i);
	        Time time2 = times.get(j);

			System.out.println("\nResultado do jogo: " + times.get(i).nome + " X " + times.get(j).nome);
					
					
			System.out.print("Informe os gols do " + times.get(i).nome + ": ");
				int golsTimeUm = scanner.nextInt();
				jogo.golsTime1.add(golsTimeUm);
				
			System.out.print("Informe os gols do " + times.get(j).nome + ": ");
				int golsTimeDois = scanner.nextInt();
				jogo.golsTime2.add(golsTimeDois);
							
				
			if ( golsTimeUm > golsTimeDois) {
				
				time1.adicionarPontos(3);
	            System.out.println(times.get(i).nome + " venceu a partida!\n");
			} 
			
			else if(golsTimeDois > golsTimeUm) {
				
	        	time2.adicionarPontos(3);
	            System.out.println(times.get(j).nome + " venceu a partida!\n"); 
			}
			
			else {
				
	            time1.adicionarPontos(1);
	        	time2.adicionarPontos(1);
	            System.out.println("A partida terminou em empate.\n");
	       }
		}
	 }
	 
	 System.out.println("_____________________\n");
	 
	 System.out.println("Computação dos resultados: ");
	 
	 ResultadoFinal(jogador1, times);
	 
	 System.out.println("_____________________\n");
	    
	 ResultadoFinal (jogador2, times);
	 
	 System.out.println("_____________________\n");
	 
	 if(numeroDeTimes == 4) {
		 System.out.println("Numero de partidas = 6");
	 }
	 else if(numeroDeTimes == 8) {
		 System.out.println("Numero de partidas = 27");
	 }
	 
	 System.out.println("\nJogadores que participaram: "+ jogador1.nome + " e " + jogador2.nome + "\n");
	 
	 
	 if(jogador1.resultado > jogador2.resultado) {
		 System.out.println(jogador1.nome + ": " + jogador1.resultado );
		 System.out.println(jogador2.nome + ": " + jogador2.resultado );
		 System.out.println("\n" + jogador1.nome + " venceu!");
	 }
	 else if(jogador1.resultado < jogador2.resultado) {
		 System.out.println(jogador2.nome + ": " + jogador2.resultado );
		 System.out.println(jogador1.nome + ": " + jogador1.resultado );
		 System.out.println("\n" + jogador2.nome + " venceu!");
	 }
	 else {
		 System.out.println(jogador1.nome + ": " + jogador1.resultado );
		 System.out.println(jogador2.nome + ": " + jogador2.resultado );
		 System.out.println("Empate!");
	 }
	 
	
	 	times.sort((time1, time2) -> Integer.compare(time2.getPontos(), time1.getPontos()));  
	    System.out.println("\nLista e pontuação final dos times:");		
	
	    
	    for (Time time : times) {
	    	System.out.println("Time: " + time.nome + " - Pontos: " + time.getPontos());
	    }
	    
	    
	    
}


	private static void Palpites(List<Time> times, Scanner scanner, Jogador jogador) {
    		System.out.println("\nPalpites para o jogador " + jogador.nome + ":");
    		int fichasDisponiveis = 50;	
    		for (int i = 0; i < times.size(); i++) {
    				for (int j = i + 1; j < times.size(); j++) {

        			System.out.println("1-" + times.get(i).nome + " vs " + "2-" + times.get(j).nome);
    				System.out.print("Informe o palpite do time vencedor (1 ou 2): ");
    				int palpiteVencedor = scanner.nextInt();
    				
    				if(palpiteVencedor == 1) {
    				jogador.timePalpite.add(times.get(i).nome);
    				}
    				else if(palpiteVencedor == 2) {
    				jogador.timePalpite.add(times.get(j).nome);
    				}
    				
    				System.out.println("fichas disponiveis: " + fichasDisponiveis);
    				System.out.print("Informe o número de fichas para o palpite: ");
    				int fichasDepositadas = scanner.nextInt();
    				fichasDisponiveis -= fichasDepositadas;
    				jogador.fichasPalpite.add(fichasDepositadas);
    				
    				System.out.println("\n");
    				

    				if (palpiteVencedor != 1 && palpiteVencedor != 2) {
    					System.out.println("Palpite inválido. Tente novamente.");
    					break;
    				} else {  
    				}
                
    				jogador.fichas -= fichasDepositadas;
    	                   				
    			}}}

    private static void ResultadoFinal (Jogador jogador, List<Time> times){
    	int l=0;
    	int pontuacao = 0;
    	List<Integer> saldo = new ArrayList<Integer>();
   	 	List<Integer> resultado = new ArrayList<Integer>();
   	 	
   	 	System.out.println(jogador.nome +":\n");
    	
   	 	for (int i = 0; i < times.size(); i++) {
     		for (int j = i + 1; j < times.size(); j++) {
    			
    			System.out.println("1-" + times.get(i).nome + "[" + jogo.golsTime1.get(l) + "] vs " + "2-" + times.get(j).nome + "[" + jogo.golsTime2.get(l) + "]");
    			
    			if(times.get(i).nome == jogador.getTimePalpite().get(l)){
    				int saldoGol = jogo.golsTime1.get(l)- jogo.golsTime2.get(l);
    				saldo.add(saldoGol);
    			}
    			else if(times.get(j).nome == jogador.getTimePalpite().get(l)){
    				int saldoGol = jogo.golsTime2.get(l)- jogo.golsTime1.get(l);
    				saldo.add(saldoGol);
    			}
    			
    			int multiplicacaoPontos = jogador.fichasPalpite.get(l) * saldo.get(l);
    			resultado.add(multiplicacaoPontos);
    			
    			pontuacao += multiplicacaoPontos;
    			jogador.setResultado(pontuacao);
    			
    			System.out.println("Fichas indicadas " + jogador.getFichasPalpite().get(l) + " - Saldo de gols " + jogador.getTimePalpite().get(l) + ": " + saldo.get(l) + " = " + resultado.get(l) + "\n" );
    			l +=1;
    			}
    		}
   	 System.out.println("_____________________\n");
   	 	System.out.println("Pontuação Final " + jogador.nome +": " + pontuacao );
    	}
	}