/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnhembiOnibus;

import java.util.Scanner;

/**
 *
 * @author Gabriela
 */
public class Principal {

	public static void main(String[] args) {
		Scanner menuScanner = new Scanner(System.in);
		int[] janela = new int[24];
		int[] corredor = new int[24];
		int menu = 0;

		while (menu != 3) {
			System.out.println("MENU - VENDA DE PASSAGENS");
			System.out.println("1. Vender passagem");
			System.out.println("2. Mapa de ocupação");
			System.out.println("3. Encerrar");
			menu = menuScanner.nextInt();

			if (menu == 1) {
				escolherAssento();
			}else if(menu == 2){
				mostrarMapaAssentos();
			}
		}
		
		System.out.println("Saindo do sistema");
		System.exit(0);
	}
	
	private static void escolherAssento(){
		System.out.println("Escolha o seu assento");
//		Scanner poltrona = new Scanner(System.in);
//		Scanner posicao = new Scanner(System.in);
//		
//		System.out.println("Digite o número da poltrona (1-24)");
//		int escolhapoltrona = poltrona.nextInt();
//		
//		System.out.println("Deseja janela (J) ou corredor(C)?");
//		String escolhaposicao = posicao.next();
//		int pos = escolhapoltrona - 1;
//
//		if (pos < 24 && "J".equals(escolhaposicao)) {
//			if (janela[pos] == 0) {
//				janela[pos] = 1;
//				System.out.println("Venda efetivada");
//			} else {
//				System.out.println("Poltrona ocupada");
//
//			}
//			i = i + i;
//		}
//
//		if (pos >= 24 && "C".equals(escolhaposicao)) {
//		} else if (janela[pos] == 0) {
//			janela[pos] = 1;
//			System.out.println("Venda efetivada");
//		} else {
//			System.out.println("Poltrona ocupada");
//
//		}
//		i = i + i;
	}
	
	private static void mostrarMapaAssentos(){
		System.out.println("Mostrando mapa assentos:");
	}
}