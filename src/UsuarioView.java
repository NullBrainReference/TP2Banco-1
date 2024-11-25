import javax.swing.JOptionPane;

public abstract class UsuarioView {
	protected Usuario model;
	
	public UsuarioView(Usuario model) {
		this.model = model;
	}
	
	
	public boolean IsLoggedIn() {
		if (model == null)
			return false;
		
		return true;
	}
	
	public void LogOut() {
		model = null;
	}
	
	public abstract void ShowMenu(CancellationToken token); 
	
	public static Usuario Register() {
		String name = (String) JOptionPane.showInputDialog("Enter name");
		String dni = (String) JOptionPane.showInputDialog("Enter dni");
		String pass = (String) JOptionPane.showInputDialog("Enter password");
		
		return Usuario.Register(name, dni, pass);
	}
	
	public static Usuario Login() {
		String dni = (String) JOptionPane.showInputDialog("Enter dni");
		String pass = (String) JOptionPane.showInputDialog("Enter password");
		
		return Usuario.Login(dni, pass);
	}
}
