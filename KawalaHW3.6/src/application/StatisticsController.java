package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StatisticsController implements Initializable {
	private double avgAge;
	private double avgHeigth;

	@FXML
	Label avgAgeLabel;
	@FXML
	Label avgHeigthLabel;
	@FXML
	Label howManyPplLabel;
	@FXML
	Button returnButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		howManyPplLabel.setText(Integer.toString(DataInputController.characters.size()));
		if (DataInputController.characters.size() > 0) {

			for (Character character : DataInputController.characters) {
				avgAge += character.getAge();
			}
			avgAge = avgAge / DataInputController.characters.size();
			System.out.println(avgAge);
			avgAgeLabel.setText(Double.toString(avgAge));

			for (Character character : DataInputController.characters) {
				avgHeigth += character.getHeight();
			}
			avgHeigth = avgHeigth / DataInputController.characters.size();
			System.out.println(avgHeigth);
			avgHeigthLabel.setText(Double.toString(avgHeigth));
		}
	}

	@FXML
	private void cancel() {
		Main.statisticsStage.close();
	}

}
