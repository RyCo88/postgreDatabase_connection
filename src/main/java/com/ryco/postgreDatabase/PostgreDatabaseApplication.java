package com.ryco.postgreDatabase;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class PostgreDatabaseApplication implements CommandLineRunner {

    private final DataSource dataSource;

    public PostgreDatabaseApplication(final DataSource dataSource)  {
        this.dataSource = dataSource;
    }

	public static void main(String[] args) {
		SpringApplication.run(PostgreDatabaseApplication.class, args);
	}

    @Override
    public void run(final String... args) {
        log.info("Datasource: " + dataSource.toString());
        final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
        restTemplate.execute("select 1");
    }
}
