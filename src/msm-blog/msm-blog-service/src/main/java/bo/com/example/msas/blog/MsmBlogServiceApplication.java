package bo.com.example.msas.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"bo.com.example"})
public class MsmBlogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsmBlogServiceApplication.class, args);
	}

}
