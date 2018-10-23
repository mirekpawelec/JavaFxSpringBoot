package pl.javafx.spring.config;

import java.util.Objects;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.javafx.spring.model.enums.FxmlView;

public class StageManager {
	private SpringFXMLLoader springFXMLLoader;
	private Stage primaryStage;

	public StageManager(SpringFXMLLoader springFXMLLoader, Stage primaryStage) {
		this.springFXMLLoader = springFXMLLoader;
		this.primaryStage = primaryStage;
	}

	public void switchScene(FxmlView view) {
		Parent rootNode = loadView(view);
		show(rootNode, view.getTitle());
	}

	private Parent loadView(FxmlView view) {
		Parent rootNode = null;
		try {
			rootNode = springFXMLLoader.load(view.getPath());
			Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
		} catch (Exception e) {
			System.out.println("B��d podczas �adownai pliku fxml: " + view.getPath());
		}
		return rootNode;
	}

	private void show(Parent rootNode, String title) {
		Scene scene = prepareScene(rootNode);
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	private Scene prepareScene(Parent rootNode) {
		Scene scene = primaryStage.getScene();
		if (scene == null) {
			scene = new Scene(rootNode);
		}
		scene.setRoot(rootNode);
		return scene;
	}
}
