package dev.sye.mcpdemo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
public class CursosService {

    private static final Logger log = LoggerFactory.getLogger(CursosService.class);
    private List<Cursos> cursos = new ArrayList<>();

    @Tool(name = "mcp_get_cursos", description = "Devuelve la lista de cursos")
    public List<Cursos> getCursos() {
        return cursos;
    }

    @Tool(name = "mcp_get_curso", description = "Devuelve el curso por titulo")
    public Cursos getCursos(String titulo) {
        return cursos.stream().filter(curso -> curso.titulo().equals(titulo)).findFirst().orElse(null);
    }
    
    @PostConstruct
    public void init() {
        log.info("CursosService init");
        cursos.add(new Cursos("Spring", "https://spring.io"));
        cursos.add(new Cursos("Spring Boot", "https://spring.io/projects/spring-boot"));
        cursos.add(new Cursos("Spring Cloud", "https://spring.io/projects/spring-cloud"));
    }
    
}
