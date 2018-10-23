package pl.javafx.spring.config;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javafx.stage.Stage;

@Configuration
public class ApplicationConfig {

	@Autowired
	private SpringFXMLLoader springFXMLLoader;

	@Bean
	public ResourceBundle resourceBundle() {
		return ResourceBundle.getBundle("app");
	}

	@Bean
	@Lazy(value = true)
	public StageManager stageManager(Stage stage) {
		return new StageManager(springFXMLLoader, stage);
	}
}
