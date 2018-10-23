package pl.javafx.spring.config;

import java.io.IOException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

@Component
public class SpringFXMLLoader {
	private ResourceBundle resourceBundle;
	private ApplicationContext context;

	@Autowired
	public SpringFXMLLoader(ResourceBundle resourceBundle, ApplicationContext context) {
		this.resourceBundle = resourceBundle;
		this.context = context;
	}

	public Parent load(String fxmlUrl) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(context::getBean);
		loader.setResources(resourceBundle);
		loader.setLocation(getClass().getResource(fxmlUrl));
		return loader.load();
	}
}
