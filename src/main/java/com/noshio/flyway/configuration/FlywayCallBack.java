package com.noshio.flyway.configuration;

import com.noshio.flyway.flywaycallback.UserCount;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
public class FlywayCallBack implements Callback {

    @Autowired
    private UserCount userCount;
    private JdbcTemplate jdbcTemplate;

    public FlywayCallBack(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean supports(Event event, Context context) {
        switch (event.name()) {
            case "BEFORE_EACH_MIGRATE":
            case "AFTER_MIGRATE":
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean canHandleInTransaction(Event event, Context context) {
        return false;
    }

    @Override
    public void handle(Event event, Context context) {
        switch (event.name()) {
            case "BEFORE_EACH_MIGRATE":
                log.info("About to run AfterMigration");
                userCount.beforeEachMigrate(jdbcTemplate);
                break;
            case "AFTER_MIGRATE":
                log.info("About to run AfterMigration");
                userCount.afterEachMigration(jdbcTemplate);
                break;
        }
    }
}
