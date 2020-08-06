package cashee_money_helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Funcionalidades {

	Scanner sc = new Scanner(System.in);
	
	private int meses;
	private double valor;
	private String desc;
	
	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	// M�todo respons�vel por inicializar o menu.
	public void menuPrincipal() throws IOException, InterruptedException {
		int resp = 0;
		while (resp > 3 || resp < 1) {
			System.out.println("===========================================================================================================");
			System.out.println("Seja-bem vindo ao Cashee, seu organizador de gastos pessoais, mantenha tudo anotado e continue a economizar");
			System.out.println("===========================================================================================================");
			System.out.println("Menu de op��es:");
			System.out.println("1 - Adicionar gastos");
			System.out.println("2 - Visualizar gastos");
			System.out.println("3 - Fechar");
			System.out.print("Sua escolha: ");
			resp = sc.nextInt();
			switch (resp) {
			case 1:
				menuAdicionar();
			case 2:
				menuVisualizar();
			}
			System.out.println("====================================== Vers�o 0.1 (Alpha) =================================================");
		}
	}

	// M�todo respons�vel por direcionar ao menu de "adicionar gastos".
	public int menuAdicionar() throws IOException, InterruptedException {
		int resp = 0;
		while (resp > 3 || resp < 1) {
			System.out.println("===========================================================================================================");
			System.out.println("Qual o tipo de gasto a ser adicionado ?");
			System.out.println("===========================================================================================================");
			System.out.println("Menu de op��es:");
			System.out.println("1 - Gasto mensal/Parcelado");
			System.out.println("2 - Gasto �nico");
			System.out.println("3 - Voltar");
			System.out.print("Sua escolha: ");
			resp = sc.nextInt();
			switch (resp) {
			case 1:
				menuGastoMes();
			case 2:
				menuGastoUnico();
			case 3:
				menuPrincipal();	
			}
		}
		return resp;
	}

	// M�todo respons�vel por adicionar um gasto parcelado.
	public void menuGastoMes() throws IOException, InterruptedException {
		System.out.println("===========================================================================================================");
		System.out.println("Qual o valor das parcelas ?");
		System.out.print("Valor: ");
		setValor(sc.nextDouble());
		System.out.println("===========================================================================================================");
		System.out.println("Qual a quantidade de meses ?");
		System.out.print("Quantidade de meses: ");
		setMeses(sc.nextInt());
		System.out.println("===========================================================================================================");
		System.out.println("Qual a descri��o do gasto ?");
		System.out.print("Descri��o do gasto: ");
		setDesc(sc.next());
		// Teste provis�rio
		salvarArq(getValor()*getMeses(), getDesc());
		menuAdicionar();
	}

	// M�todo respons�vel por adicionar um gasto �nico.
	public void menuGastoUnico() throws IOException, InterruptedException {
		System.out.println("===========================================================================================================");
		System.out.println("Qual o valor a ser adicionado ?");
		System.out.print("Valor: ");
		setValor(sc.nextDouble());
		System.out.println("===========================================================================================================");
		System.out.println("Qual a descri��o do gasto ?");
		System.out.print("Descri��o do gasto: ");
		setDesc(sc.next());
		salvarArq(getValor(), getDesc());
		menuAdicionar();
	}

	// M�todo respons�vel por mostrar todos os gastos do usu�rio.
	public void menuVisualizar() throws InterruptedException, IOException {
		System.out.println("===========================================================================================================");
		FileReader arq = new FileReader("dados.txt");
		BufferedReader lerArq = new BufferedReader(arq);
		String linha = lerArq.readLine();
		while (linha != null) {
			System.out.println(linha);
			linha = lerArq.readLine();
		}
		menuPrincipal();
		lerArq.close();
	}
	
	public void salvarArq(double valor, String desc) throws IOException {
		FileWriter pw = new FileWriter ("dados.txt", true);
		BufferedWriter bf = new BufferedWriter(pw);
		bf.write("Valor: " + valor + "|Descri��o: " + desc);
		bf.newLine();
		bf.close();
	}
}
