
public enum OpcionesCliente {
	Transferir("Transferir"),
	Depositar("Depositar"),
	Retirar("Retirar"),
	
	Login("Login"),
	Register("Register"),
	Exit("Exit")
	;
	
	private String stringValue;
	
	private OpcionesCliente(String value) {
		stringValue = value;
	}

}
