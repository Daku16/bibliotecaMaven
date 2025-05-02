package co.edu.etitc.sistemas.programacion;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "co.edu.etitc.sistemas.programacion")
@EnableJdbcRepositories(basePackages = "co.edu.etitc.sistemas.programacion")
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();

        dataSource.setUrl("jdbc:h2:file:./resources/schema.db");

        return dataSource;
    }
}