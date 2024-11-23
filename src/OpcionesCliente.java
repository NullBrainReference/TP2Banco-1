
public enum OpcionesCliente {
	Transferir("Transferir"),
	Depositar("Depositar"),
	Retirar("Retirar"),
	
	NuevaCuenta("Nueva Cuenta"),
	ElegirCuenta("Elegir Cuenta"),
	
	Login("Login"),
	Register("Register"),
	Exit("Exit"),
	LogOut("Log Out")
	;
	
	private String stringValue;
	
	private OpcionesCliente(String value) {
		stringValue = value;
	}

}
