package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddANewCharacterController {
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField ageTextField;
	@FXML
	private TextField heightTextField;
	@FXML
	private TextField professionTextField;
	@FXML
	private TextField raceTextField;
	@FXML
	private Button addButton;
	@FXML
	private Button cancelButton;

	@FXML
	private void createANewCharacterController() {
		DataInputController.createANewCharacter(nameTextField.getText(), Integer.parseInt(ageTextField.getText()),
				Integer.parseInt(heightTextField.getText()), professionTextField.getText(), raceTextField.getText());
	}

	@FXML
	private void cancel() {
		Main.addANewCharacterStage.close();
	}

}
