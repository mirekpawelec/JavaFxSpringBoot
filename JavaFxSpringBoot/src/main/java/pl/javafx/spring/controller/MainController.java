package pl.javafx.spring.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.fxml.Initializable;
import pl.javafx.spring.config.StageManager;
import pl.javafx.spring.model.enums.FxmlView;

@Controller
public class MainController implements Initializable {

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void showPersonAdd() {
		stageManager.switchScene(FxmlView.PERSON_ADD);
	}

	public void showPersonList() {
		stageManager.switchScene(FxmlView.PERSON_LIST);
	}
}
