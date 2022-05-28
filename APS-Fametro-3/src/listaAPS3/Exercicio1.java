package listaAPS3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
	1. Crie um algoritmo que ajude o DETRAN a saber, o total de recursos que foram arrecadados 
	com a aplicação de multas de trânsito. O algoritmo deve ler as seguintes informações para 
	cada motorista: 
	-O número da carteira de motorista (de 1 a 4327) 
	-Número de multas; 
	-Valor da cada uma das multas. 
	  o total de recursos 
	arrecadados (somatório de todas as multas). O algoritmo deverá imprimir também o número 
	da carteira do motorista que obteve o maior número de multas.
*/
public class Exercicio1 {
	public static void main(String[] args) {
		int cartaMotorista, quantidadeMultas = 0, quantidadeMotoristas;
		double valorMulta;
		String convert;
		Scanner dado = new Scanner(System.in);

		System.out.println("Quantos motoristas deveram ser analisados?");
		quantidadeMotoristas = dado.nextInt();
		int[] motorista = new int[quantidadeMotoristas];

		for (int count = 0; count < quantidadeMotoristas; count++) {
			System.out.println("Qual o numero da carteira do usuario?");
			cartaMotorista = dado.nextInt();
			
			if (!(cartaMotorista >= 1 && cartaMotorista <= 4327)) {
				while (true) {
					System.out.println("Digite um numero de habilitação valido. (1-4327)");
					cartaMotorista = dado.nextInt();
					if (cartaMotorista >= 1 && cartaMotorista <= 4327) {
						motorista[count] = cartaMotorista;
						break;
					}
				}
			}else {
				motorista[count] = cartaMotorista;
			}
		}
		double valorTotalMultas = 0;
		ArrayList<Integer> numeroMultas = new ArrayList<Integer>();
		
		for(int i = 0;i < motorista.length;i++){
			System.out.println("Quantas multas o motorista " + motorista[i] +" possui?");
			quantidadeMultas = dado.nextInt();
			numeroMultas.add(quantidadeMultas);
		}
		Collections.sort(numeroMultas);
		Collections.reverse(numeroMultas);
		
		//System.out.println(numeroMultas);
		
		int quantidadeMultas1 = numeroMultas.get(0);
		
		double[][] usuarioMultas = new double[quantidadeMotoristas][quantidadeMultas1];
		
		for(int i = 0;i < motorista.length;i++){
			for (int count = 0; count < quantidadeMultas; count++) {
				System.out.println("Qual o valor da "+(count+1)+" multa do usuario "+motorista[i]);
				convert = dado.next().replace(",", ".");
				valorMulta = Double.parseDouble(convert);
				valorTotalMultas += valorMulta;
				usuarioMultas[i][count] = valorMulta ;
			}
		}
		dado.close();
	}
}

/*
 * falta adaptar o tamanho do array para quantidade de multas de cada usuario***
 * atualmente esta do tamanho do motorista que tiver mais multa , gerandoi codigo inútil**
 * *seguindo orientaçoes todo o arquivo deve estar na mesma classe , sem trabalhar com metodos**
