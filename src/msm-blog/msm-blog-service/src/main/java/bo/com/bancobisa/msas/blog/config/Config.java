package bo.com.bancobisa.msas.blog.config;



import lombok.extern.java.Log;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

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

  @Autowired
  private OpenAPI openAPI;

  @Value("${spring.application.name}")
  private String applicationName;

  @Bean
  public void customApi30() {
    openAPI.getInfo().setTitle(applicationName);
    openAPI.getInfo().setDescription("Gestión de clientes en Tinka");
    openAPI.getInfo().setVersion("magenta");
  }
}
