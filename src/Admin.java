
public class Admin extends Usuario {

	public Admin(String nombre, String dni, String contrasena) {
		super(nombre, dni, contrasena);
	}

	@Override
	public Opciones[] Menu() {
		return new Opciones[] { 
				Opciones.History,
				Opciones.Exit,
				Opciones.LogOut};
	}

	@Override
	public UsuarioView getView() {
		// TODO Auto-generated method stub
		return new AdminView(this);
	}

}
