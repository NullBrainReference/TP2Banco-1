
public class Admin extends Usuario {

	public Admin(String nombre, String dni, String contrasena) {
		super(nombre, dni, contrasena);
	}

	@Override
	public OpcionesCliente[] Menu() {
		return new OpcionesCliente[] { 
				OpcionesCliente.History,
				OpcionesCliente.Exit,
				OpcionesCliente.LogOut};
	}

	@Override
	public UsuarioView getView() {
		// TODO Auto-generated method stub
		return new AdminView(this);
	}

}
