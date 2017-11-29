package application;

import java.io.IOException;
import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	private static Stage logInStage;
	private static String username;
	private static boolean administrator;
	private static String[] users = { "Administrator", "Użytkownik" };
	static Stage addANewCharacterStage;
	static Stage statisticsStage;

	@Override
	public void start(Stage primaryStage) throws IOException {
		Main.primaryStage = primaryStage;
		primaryStage.setTitle("Kawala, HW3");
		setMainLayout();
		setTopNotLoggedIn();
		setDataInputScene();
	}

	private void setDataInputScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("DataInput.fxml"));
		mainLayout.setCenter(loader.load());
	}

	static void setTopNotLoggedIn() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("TopNotLoggedIn.fxml"));
		mainLayout.setTop(loader.load());
	}

	private void setMainLayout() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MainLayout.fxml"));
		mainLayout = loader.load();
		primaryStage.setScene(new Scene(mainLayout));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void logInStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("LogInStage.fxml"));
		logInStage = new Stage();
		logInStage.initModality(Modality.WINDOW_MODAL);
		logInStage.initOwner(primaryStage);
		logInStage.setScene(new Scene(loader.load()));
		logInStage.setTitle("Zaloguj się");
		logInStage.showAndWait();
	}

	public static void logIn(String username, String password) throws IOException {
		if (Arrays.asList(users).contains(username)) {
			if (password.equals("password")) {
				Main.setUsername(username);
				if (username.equals("Administrator")) {
					Main.setAdministrator(true);
					System.out.println("Przyznano ci uprawnienia administratora");
				}
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("TopLoggedIn.fxml"));
				mainLayout.setTop(loader.load());
				Main.logInStage.close();
			} else {
				System.out.println("Podałeś złe hasło");
			}
		} else {
			System.out.println("Nie ma takiego użytkownika");
		}

	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Main.username = username;
	}

	public static boolean isAdministrator() {
		return administrator;
	}

	public static void setAdministrator(boolean administrator) {
		Main.administrator = administrator;
	}

	public static void addANewCharacterStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("AddANewCharacter.fxml"));
		addANewCharacterStage = new Stage();
		addANewCharacterStage.initModality(Modality.WINDOW_MODAL);
		addANewCharacterStage.initOwner(primaryStage);
		addANewCharacterStage.setScene(new Scene(loader.load()));
		addANewCharacterStage.setTitle("Dodaj pracownika");
		addANewCharacterStage.showAndWait();
	}

	public static void statisticsStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Statistics.fxml"));
		statisticsStage = new Stage();
		statisticsStage.initModality(Modality.WINDOW_MODAL);
		statisticsStage.initOwner(primaryStage);
		statisticsStage.setScene(new Scene(loader.load()));
		statisticsStage.setTitle("Statystyki");
		statisticsStage.showAndWait();
	}
}
