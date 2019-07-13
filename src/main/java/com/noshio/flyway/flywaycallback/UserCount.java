
package com.noshio.flyway.flywaycallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCount {

    public void beforeEachMigrate(JdbcOperations jdbcTemplate) {
        Long userCount = jdbcTemplate.queryForObject("select count(*) from user_user", Long.class);
        log.info("++++++++ THE NUMBER OF USER BEFORE MIGRATE IS {} ++++++++", userCount);
        log.info("Finished executing BeforeMigrate...");
    }

    public void afterEachMigration(JdbcOperations jdbcTemplate){
        Long userCount = jdbcTemplate.queryForObject("select count(*) from user_user", Long.class);
        log.info("++++++++ THE NUMBER OF USER AFTER EACH MIGRATE IS {} +++++++", userCount);
        log.info("Finished executing AfterMigrate...");
    }
}


