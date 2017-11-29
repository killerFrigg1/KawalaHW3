package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TopNotLoggedInController {
	@FXML
	private Button logInButton;

	@FXML
	void logInStage() throws IOException {
		Main.logInStage();
	}

}
