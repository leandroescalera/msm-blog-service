package bo.com.example.msas.blog.config;

import io.swagger.v3.oas.models.OpenAPI;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.logging.Level;

/**
 * @author leandro.escalera
 */

@Log
@Configuration
@PropertySources({
  @PropertySource("classpath:data.properties")})
public class Config {

  public static final Level LOG_LEVEL = Level.INFO;

//  @Autowired
//  private OpenAPI openAPI;
//
//  @Value("${spring.application.name}")
//  private String applicationName;
//
//  @Bean
//  public void customApi30() {
//    openAPI.getInfo().setTitle(applicationName);
//    openAPI.getInfo().setDescription("Gestión de clientes en onboarding");
//    openAPI.getInfo().setVersion("gateway");
//  }
}
