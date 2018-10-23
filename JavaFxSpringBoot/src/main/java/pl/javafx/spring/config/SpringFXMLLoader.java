package pl.javafx.spring.config;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringFXMLLoader {
	@Autowired
	private ResourceBundle resource;
	@Autowired
	private ApplicationContext context;
	
//	public Parent load() {
//		
//	}
}
