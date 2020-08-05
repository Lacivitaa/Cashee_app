package cashee_money_helper;

public class GastoMes extends Gasto {
	
	public GastoMes(String desc, double valor) {
		super(desc, valor);
	}

	String exp;
	int qntdmes;
	
	public double valorTotal(int valor) {
		return valor * this.qntdmes;
	}
}
