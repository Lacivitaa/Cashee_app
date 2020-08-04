package cashee_money_helper;

import java.util.Scanner;

public class Funcionalidades {
	Scanner sc = new Scanner(System.in);
	public int menuPrincipal() 
	{
		int resp = 0;
		while (resp > 3 || resp < 1) {
			System.out.println("Seja-bem vindo ao Cashee, seu organizador de gastos pessoais, mantenha tudo anotado e continue a economizar");
			System.out.println("===========================================================================================================");
			System.out.println("Menu de opções:");
			System.out.println("1 - Adicionar gastos");
			System.out.println("2 - Visualizar gastos");
			System.out.println("3 - Fechar");
			System.out.print("Sua escolha: ");
			resp= sc.nextInt();
			System.out.println("====================================== Versão 0.1 (Alpha) =================================================");
		}
		return resp;
	}
}
