package com.noshio.flyway.flywaycallbackstrategy;

import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.jdbc.core.JdbcOperations;

public interface CallBackStrategy {
    boolean execute(Event event, Context context, JdbcOperations jdbcOperations);
}
