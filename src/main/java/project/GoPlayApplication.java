package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class GoPlayApplication implements WebMvcConfigurer {

	public static final String STATIC = "/static/**";
	public static final String CLASSPATH_STATIC = "classpath:/static/";

	public static void main(String[] args) {
		SpringApplication.run(GoPlayApplication.class, args);
	}

	/**
	 * ResourceLocations
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(STATIC).addResourceLocations(CLASSPATH_STATIC);
	}
}
