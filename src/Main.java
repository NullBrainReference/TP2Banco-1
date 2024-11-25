import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Usuario.CreateDummyAccounts();
		//Usuario.getUsuarios();
		CancellationToken cancelToken = new CancellationToken();
		Usuario user = null;
		while(!cancelToken.wasCanceled()) {
			
			while(user == null) {
				Opciones[] options = new Opciones[] {Opciones.Login, Opciones.Register, Opciones.Exit};
				Opciones selection = (Opciones) JOptionPane.showInputDialog(null, "Log in or Sign in", null, 0, null, options, options[0]);
				
				switch (selection) {
					case Login: {
						user = UsuarioView.Login();
						break;
					}
					case Register: {
						user = UsuarioView.Register();
						break;
					}
					case Exit: {
						return;
					}
				}
			}
			
			var view = user.getView();
			view.ShowMenu(cancelToken);
			
			if (view.IsLoggedIn() == false) {
				user = null;
			}
		}
		
	}
	
	public static Usuario Login() {
		
		return Usuario.Login(null, null);
	}
	
//	public static Usuario Register() {
//		String name = (String) JOptionPane.showInputDialog("Enter name");
//		String dni = (String) JOptionPane.showInputDialog("Enter dni");
//		String pass = (String) JOptionPane.showInputDialog("Enter password");
//		
//		return Usuario.Register(name, dni, pass);
//		//Usuario.getUsuarios()
//	}
	
	public static void ThrowUIMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
}
