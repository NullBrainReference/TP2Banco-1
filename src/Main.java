import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		//Usuario.getUsuarios();
		Usuario user = null;
		while(true) {
			
			while(user == null) {
				OpcionesCliente[] options = new OpcionesCliente[] {OpcionesCliente.Login, OpcionesCliente.Register, OpcionesCliente.Exit};
				OpcionesCliente selection = (OpcionesCliente) JOptionPane.showInputDialog(null, "Log in or Sign in", null, 0, null, options, options[0]);
				
				switch (selection) {
					case Login: {
						user = Login();
						break;
					}
					case Register: {
						user = Register();
						break;
					}
					case Exit: {
						return;
					}
				}
			}
			
			
			
			
		}
		
	}
	
	public static Usuario Login() {
	 
		return new Cliente(null, null, null, null, null);
	}
	
	public static Usuario Register() {
		String name = (String) JOptionPane.showInputDialog("Enter name");
		String dni = (String) JOptionPane.showInputDialog("Enter dni");
		String pass = (String) JOptionPane.showInputDialog("Enter password");
		
		return Usuario.Register(name, dni, pass);
		//Usuario.getUsuarios()
	}
	
	public static void ThrowUIMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
}
