import java.util.List;

import javax.swing.JOptionPane;

public class AdminView extends UsuarioView {

	public AdminView(Usuario model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ShowMenu(CancellationToken token) {
		OpcionesCliente[] options = model.Menu();
		OpcionesCliente selection = (OpcionesCliente) JOptionPane.showInputDialog(null, "Menu", null, 0, null, options, options[0]);
		
		switch (selection) {
			case Exit: {
				token.cancel();
				return;
			}
			case History: {
				int id = Integer.parseInt((String) JOptionPane.showInputDialog("Enter account id"));
				Cuenta cuenta = Cuenta.find(id);
				if (cuenta == null) {
					Main.ThrowUIMessage("Account of such id not found");
					return;
				}
				
				JOptionPane.showMessageDialog(null, cuenta.getHistory());
				
				break;
			}

			case LogOut: {
				LogOut();
				return;
			}
		}
		
	}

}
