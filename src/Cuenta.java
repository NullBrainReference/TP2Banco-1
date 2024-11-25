import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Cuenta {
	private int nroCuenta;
	private double saldo;
	
	private MoneyType moneyType;
	
	private Cliente cliente;
	
	private LinkedList<Movimiento> movimientos = new LinkedList<Movimiento> ();
	
	private static LinkedList<Cuenta> cuentas = new LinkedList<Cuenta>();
	private static int lastId = 0;
	
	public Cuenta(double saldo, Cliente cliente) {
		super();
		this.nroCuenta = giveId();
		this.saldo = saldo;
		this.cliente = cliente;
		
		this.moneyType = MoneyType.USD;
		
		cuentas.add(this);
		//this.movimientos = movimientos;
	}
	public Cuenta(double saldo, Cliente cliente, MoneyType moneyType) {
		super();
		this.nroCuenta = giveId();
		this.saldo = saldo;
		this.cliente = cliente;
		
		this.moneyType = moneyType;
		
		cuentas.add(this);
		//this.movimientos = movimientos;
	}
	private static int giveId() {
		lastId++;
		return lastId;
	}
	public Cliente getClient() {
		return cliente;
	}
	public MoneyType getMoneyType() {
		return moneyType;
	}
	public int getNroCuenta() {
		return nroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public LinkedList<Movimiento> getMovimientos() {
		return movimientos;
	}
	
	public void depositar(double value) {
		if (value <= 0) {
			Main.ThrowUIMessage("Wrong value");
			return;
		}
		
		saldo += value;
		movimientos.add(new Movimiento(LocalDateTime.now(), "depositar", (int) value, cliente));
	}
	
	public void retirar(double value) {
		if (value <= 0) {
			Main.ThrowUIMessage("Wrong value");
			return;
		}
		if (value > saldo)
		{
			Main.ThrowUIMessage("Insufficient funds");
			return;
		}
		
		saldo -= value;
		movimientos.add(new Movimiento(LocalDateTime.now(), "retirar", (int) value, cliente));
	}
	
	public void transferir(double value, int nroCuenta) {
		if (value > saldo) {
			Main.ThrowUIMessage("Insufficient funds");
			return;
		}
		
		Cuenta cuentaTo = find(nroCuenta);
		if (cuentaTo == null) {
			Main.ThrowUIMessage("Not found");
			return;
		}
		if (cuentaTo.moneyType != moneyType) {
			Main.ThrowUIMessage("Your Account does not work with " + cuentaTo.moneyType);
			return;
		}
		
		saldo -= value;
		cuentaTo.saldo += value;
		
		movimientos.add(new Movimiento(LocalDateTime.now(), "transferir", (int) value, cuentaTo.cliente));
	}
	
	public String getHistory() {
		String history = "";
		
		for (Movimiento movimiento : movimientos) {
			history += movimiento.toString() + "\n";
		}
		
		return history;
	}
	
	public static List<Cuenta> FindAllClientAccounts(Cliente client){
		List<Cuenta> results = new LinkedList<Cuenta>();
		
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getClient() == client) {
				results.add(cuenta);
			}
		}
		
		return results;
	}
	
	public static Cuenta find(int nroCuenta) {
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getNroCuenta() == nroCuenta) {
				return cuenta;
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Cuenta [nroCuenta=" + nroCuenta + ", saldo=" + saldo + "]";
	}
}
