package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataInputController {
	static ObservableList<Character> characters = FXCollections.observableArrayList();

	@FXML
	Button addButton;
	@FXML
	Button removeButton;
	@FXML
	Button statisticsButton;
	@FXML
	TableView<Character> tableView;
	@FXML
	TableColumn<Character, String> nameColumn;
	@FXML
	TableColumn<Character, String> ageColumn;
	@FXML
	TableColumn<Character, String> heightColum;
	@FXML
	TableColumn<Character, String> professionColumn;
	@FXML
	TableColumn<Character, String> raceColumn;

	@FXML
	private void removeCharacter() {
		if (Main.isAdministrator()) {
			ObservableList<Character> charactersSelected;
			charactersSelected = tableView.getSelectionModel().getSelectedItems();
			characters.removeAll(charactersSelected);
		} else {
			System.out.println("Nie posiadasz odpowiednich uprawnień");
		}
	}

	public void initialize() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
		heightColum.setCellValueFactory(new PropertyValueFactory<>("height"));
		professionColumn.setCellValueFactory(new PropertyValueFactory<>("profession"));
		raceColumn.setCellValueFactory(new PropertyValueFactory<>("race"));
		tableView.setItems(characters);
	}

	@FXML
	public void addANewCharacterStageController() throws IOException {
		if (Main.isAdministrator())
			Main.addANewCharacterStage();
		else {
			System.out.println("Nie posiadasz odpowiednich uprawnień");
		}
	}

	public static ObservableList<Character> createANewCharacter(String name, int age, int height, String profession,
			String race) {
		characters.add(new Character(name, age, height, profession, race));
		Main.addANewCharacterStage.close();
		return characters;
	}

	@FXML
	public void getStatisticsController() throws IOException {
		Main.statisticsStage();
	}

}
