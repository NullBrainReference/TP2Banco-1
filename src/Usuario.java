import java.util.LinkedList;

public abstract class Usuario {
	private String nombre;
	private String dni;
	private String contrasena;
	
	private static LinkedList<Usuario> usuarios;
	
	public Usuario(String nombre, String dni, String contrasena) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public static LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}
	public static void setUsuarios(LinkedList<Usuario> usuarios) {
		Usuario.usuarios = usuarios;
	}
	
	public static Usuario Register(String nombre, String dni, String contrasena) {
		
		if (dni == null) {
			Main.ThrowUIMessage("DNI is empty");
			return null;
		}
		
		for (Usuario usuario : usuarios) {
			if (usuario.dni.equals(dni))
				return null;
		}
		
		if (nombre == null) {
			Main.ThrowUIMessage("Name is empty");
			return null;
		}
		if (nombre.length() == 0) {
			Main.ThrowUIMessage("Name is empty");
			return null;
		}
		
		if (dni.length() == 0) {
			Main.ThrowUIMessage("DNI is empty");
			return null;
		}
		
		if (contrasena == null) {
			Main.ThrowUIMessage("pass is empty");
			return null;
		}
		if (contrasena.length() <= 5) {
			Main.ThrowUIMessage("pass has to have 6 or mor chars");
			return null;
		}
		
		
		var user = new Cliente(nombre, dni, contrasena, contrasena, new Cuenta(0, 0));
		usuarios.add(user);
		
		Main.ThrowUIMessage("User created!");
		
		return user;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", contrasena=" + contrasena + "]";
	}
	
	public void Login() {
	
	}
	public abstract OpcionesCliente[] Menu();

}
