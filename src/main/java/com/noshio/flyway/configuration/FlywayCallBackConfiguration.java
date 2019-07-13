package com.noshio.flyway.configuration;

import org.flywaydb.core.api.callback.Callback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class FlywayCallBackConfiguration {

    @Bean
    public Callback flyWayCallBack(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return new FlywayCallBack(jdbcTemplate);
    }

}
