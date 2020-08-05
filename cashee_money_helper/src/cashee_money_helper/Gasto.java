package cashee_money_helper;

public class Gasto {
	private String desc;
	private double valor;
	
	public Gasto(String desc, double valor) {
		this.valor = valor;
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
