package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TopLoggedInController implements Initializable {
	@FXML
	Label label;
	@FXML
	private Button logOutButton;

	@FXML
	void logOut() throws IOException {
		Main.setAdministrator(false);
		Main.setTopNotLoggedIn();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (Main.isAdministrator()) {
			label.setText(
					"Jesteś zalogowany jako " + Main.getUsername() + ". " + "Przyznano ci uprawnienia administratora.");
		} else {
			label.setText("Jesteś zalogowany jako " + Main.getUsername() + ". "
					+ "Nie przyznano ci uprawnień administratora.");
		}
	}

}
