import java.util.List;

import javax.swing.JOptionPane;

public class ClienView extends UsuarioView {

	private Cuenta cuenta;
	
	public ClienView(Usuario model, Cuenta cuenta) {
		super(model);
		this.cuenta = cuenta;
	}
	
	private void ShowAccountInfo() {
		JOptionPane.showMessageDialog(null, 
				String.format(
						"Your current: %s \n"
						+ " balance: %s %s", 
				cuenta.getNroCuenta(), cuenta.getSaldo(), cuenta.getMoneyType()));
	}
	
	@Override
	public void ShowMenu(CancellationToken token) {
		ShowAccountInfo();
		
		OpcionesCliente[] options = model.Menu();
		OpcionesCliente selection = (OpcionesCliente) JOptionPane.showInputDialog(null, "Menu", null, 0, null, options, options[0]);
		
		switch (selection) {
			case Exit: {
				token.cancel();
				return;
			}
			case Depositar: {
				double value = Double.parseDouble((String) JOptionPane.showInputDialog("Enter value"));
				cuenta.depositar(value);
				break;
			}
			case Retirar: {
				double value = Double.parseDouble((String) JOptionPane.showInputDialog("Enter value"));
				cuenta.retirar(value);
				break;
			}
			case Transferir: {
				int id = Integer.parseInt(
						(String) JOptionPane.showInputDialog("Enter transfer account id"));
				double value = Double.parseDouble((String) JOptionPane.showInputDialog("Enter value"));
				cuenta.transferir(value, id);
				break;
			}
			case NuevaCuenta: {
				var client = cuenta.getClient();
				MoneyType[] types = new MoneyType[] { MoneyType.EU, MoneyType.USD, MoneyType.Rub };
				MoneyType moneyType = (MoneyType) JOptionPane.showInputDialog(
						null, "Menu", null, 0, null, types, types[0]);
				
				client.setCuenta(new Cuenta(0, client, moneyType));
				break;
			}
			case ElegirCuenta: {
				List<Cuenta> userAccounts = Cuenta.FindAllClientAccounts(cuenta.getClient());
				if (userAccounts.size() <= 1) {
					Main.ThrowUIMessage("You have only one account");
					return;
				}
				
				Cuenta currentCuenta = (Cuenta) JOptionPane.showInputDialog(
						null, "Menu", null, 0, null, userAccounts.toArray(), userAccounts.get(0));
				
				currentCuenta.getClient().setCuenta(currentCuenta);
				
				break;
			}
			case LogOut: {
				model = null;
				cuenta = null;
				return;
			}
		}

	}
}
