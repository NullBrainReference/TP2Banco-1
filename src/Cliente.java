
public class Cliente extends Usuario{
	private String tipo;
	private Cuenta cuenta;
	public Cliente(String nombre, String dni, String contrasena, String tipo, Cuenta cuenta) {
		super(nombre, dni, contrasena);
		this.tipo = tipo;
		this.cuenta = cuenta;
	}
	public Cliente(String nombre, String dni, String contrasena, String tipo) {
		super(nombre, dni, contrasena);
		this.tipo = tipo;
		this.cuenta = new Cuenta(0, this);
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	@Override
	public String toString() {
		return "Cliente [tipo=" + tipo + ", cuenta=" + cuenta + "]";
	}
	
	@Override
	public OpcionesCliente[] Menu() {
		return new OpcionesCliente[] { 
				OpcionesCliente.Transferir,
				OpcionesCliente.Retirar, 
				OpcionesCliente.Depositar,
				OpcionesCliente.History,
				OpcionesCliente.NuevaCuenta,
				OpcionesCliente.ElegirCuenta, 
				OpcionesCliente.Exit,
				OpcionesCliente.LogOut};
	}
	
	@Override
	public UsuarioView getView() {
		return new ClienView(this, getCuenta());
	}
	
	
}
