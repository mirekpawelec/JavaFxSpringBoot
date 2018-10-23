package pl.javafx.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.javafx.spring.config.StageManager;
import pl.javafx.spring.model.enums.FxmlView;

@SpringBootApplication
public class Main extends Application {

	protected ConfigurableApplicationContext context;
	protected StageManager stageManager;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		context = getSpringBootApplicationContext();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stageManager = context.getBean(StageManager.class, primaryStage);
		displayScene();
	}

	@Override
	public void stop() throws Exception {
		context.stop();
	}

	protected void displayScene() {
		stageManager.switchScene(FxmlView.MAIN);
	}

	private ConfigurableApplicationContext getSpringBootApplicationContext() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
		String[] args = getParameters().getRaw().stream().toArray(String[]::new);
		return builder.run(args);
	}

}
