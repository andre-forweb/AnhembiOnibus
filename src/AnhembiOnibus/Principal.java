/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnhembiOnibus;

import java.util.Scanner;
import java.lang.Character;

/**
 *
 * @author Gabriela
 */
public class Principal {
	public static void main(String[] args) {
		Scanner menuScanner = new Scanner(System.in);
		int totalAssentos = 24;
		int[] assentosJanela = new int[totalAssentos];
		int[] assentosCorredor = new int[totalAssentos];
		int menu = 0;
		
		while (true) {
			exibirMenu();
			menu = menuScanner.nextInt();

			if (menu == 3){
				System.out.println("Saindo do sistema");
				break;
				
			} else if (menu == 2) {
				mostrarMapaAssentos("Janela", assentosJanela);
				mostrarMapaAssentos("Corredor", assentosCorredor);
				
			}else if(menu == 1){
				int numeroPoltrona;
				char tipoPoltrona;
				boolean assentosLivres;
				
				if(!verificarAssentosLivres(assentosCorredor, assentosJanela)){
					System.out.println("\n-- Ônibus Lotado --\n");
					continue;
				}
				
				do {
					System.out.println("Digite o número da poltrona (1-" + totalAssentos + ")");
					numeroPoltrona = menuScanner.nextInt();
					
					if(numeroPoltrona < 1 || numeroPoltrona > totalAssentos){
						System.out.println("Número inválido");
						continue;
					}
					
					break;
				} while(true);
				
				do {
					System.out.println("Deseja janela (J) ou corredor(C)?");
					tipoPoltrona = Character.toUpperCase(menuScanner.next().charAt(0));
					
					if(tipoPoltrona != 'J' && tipoPoltrona != 'C'){
						System.out.println("Opção inválida");
						continue;
					}
					
					break;
				} while(true);
				
				assentosLivres = verificarAssentosLivres(assentosCorredor, assentosJanela);
				
				if(tipoPoltrona == 'J'){
					assentosJanela = venderPassagem(assentosJanela, numeroPoltrona, assentosLivres);
				} else {
					assentosCorredor = venderPassagem(assentosCorredor, numeroPoltrona, assentosLivres);
				}
				continue;

			} // fim if menu
		} // fim do loop
		
		menuScanner.close();
	}
	
	private static void mostrarMapaAssentos(String title, int[] assentos)
	{
		String[] statusPoltrona = {"Livre", "Ocupada"};
		
		System.out.println("\nMapa de assentos para: " + title);
		
		for(int i = 0; i < assentos.length; i++){
			System.out.println("Poltrona " + (i+1) + " - " + statusPoltrona[assentos[i]]);
		}
	}
	
	private static void exibirMenu()
	{
		System.out.println("\nMENU - VENDA DE PASSAGENS");
		System.out.println("1. Vender passagem");
		System.out.println("2. Mapa de ocupação");
		System.out.println("3. Encerrar");
	}
	
	private static boolean verificarAssentosLivres(int[] assentosJanela, int[] assentosCorredor)
	{
		boolean assentoLivre = false;
		int posicao = 0;
		
		while(posicao < assentosJanela.length && !assentoLivre){
			if(assentosJanela[posicao] == 0 || assentosCorredor[posicao] == 0){
				assentoLivre = true;
				break;
			}
			posicao++;
		}
		
		return assentoLivre;
	}
	
	public static int[] venderPassagem(int[] assentos, int numeroPoltrona, boolean assentosLivres)
	{
		if(assentos[numeroPoltrona-1] == 0){
			assentos[numeroPoltrona-1] = 1;
			System.out.println("\n-- Venda efetivada --\n");
		} else {
			if(assentosLivres){
				System.out.println("\n-- Poltrona Ocupada --\n");
			} else {
				System.out.println("\n-- Ônibus Lotado --\n");
			}
		}
		
		return assentos;
	}	
}