//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.etitc.sistemas.programacion.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource({"classpath:application.properties"})
@ComponentScan(
        basePackages = {"co.edu.etitc.sistemas.programacion"}
)
@EnableJdbcRepositories(
        basePackages = {"co.edu.etitc.sistemas.programacion"}
)
public class AppConfig implements WebMvcConfigurer {
    public AppConfig() {
    }

    @Bean
    public DataSource dataSource() {
        try {
            Files.createDirectories(Path.of("./data"));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el directorio ./data", e);
        }

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:file:./data/db-biblioteca");
        return dataSource;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/static/**"}).addResourceLocations(new String[]{"classpath:/static/"});
    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedHeaders(new String[]{"*"}).allowedMethods(new String[]{"*"}).allowedOrigins(new String[]{"http://localhost:8080"});
    }
}
