package pl.javafx.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class Main extends Application{

	protected ConfigurableApplicationContext context;
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void init() throws Exception {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
		String[] args = getParameters().getRaw().stream().toArray(String[]::new);
		context = builder.run(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}

	@Override
	public void stop() throws Exception {

	}
	
}
