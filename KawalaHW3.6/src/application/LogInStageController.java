package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LogInStageController {
	@FXML
	TextField username;
	@FXML
	TextField password;
	@FXML
	Button logInButton;
	@FXML
	Button cancelButton;

	@FXML
	void logIn() throws IOException {
		Main.logIn(username.getText(), password.getText());
	}
}
