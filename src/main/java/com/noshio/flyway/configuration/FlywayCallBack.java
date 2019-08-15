package com.noshio.flyway.configuration;

import com.noshio.flyway.flywaycallbackstrategy.CallBackStrategy;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FlywayCallBack implements Callback {

    private JdbcOperations jdbcTemplate;

    @Autowired
    Map<String, CallBackStrategy> callBackStrategies = new HashMap<>();


    public FlywayCallBack(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean supports(Event event, Context context) {
        int a =0;
        switch (event.name()) {
            case "BEFORE__MIGRATE":
            case "BEFORE_VALIDATE":
            case "AFTER_MIGRATE":
            case "AFTER_VALIDATE":
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
        if (callBackStrategies.containsKey(event.getId())) {
            callBackStrategies.get(event.getId()).execute(event, context, jdbcTemplate);
        }
    }
}


