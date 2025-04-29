package com.dobval.open_info_hub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.*;

/**
 * Explicit configuration to ensure JPA repositories and entities are detected.
 */
@Configuration
@ComponentScan(basePackages = "com.dobval.open_info_hub")
@EnableJpaRepositories(basePackages = "com.dobval.open_info_hub.repositories")
@EntityScan(basePackages = "com.dobval.open_info_hub.entities")
public class JpaConfig {
	@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .setName("testdb;MODE=PostgreSQL")  // optional: emulate Postgres syntax
            .build();
    }
}
