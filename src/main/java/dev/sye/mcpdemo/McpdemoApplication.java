package dev.sye.mcpdemo;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpdemoApplication.class, args);
	}

	@Bean
	public List<ToolCallback> toolCallbacks(CursosService cursosService) {
		return List.of(ToolCallbacks.from(cursosService));
	}

}
