package com.noshio.flyway.flywaycallback.before;

import com.noshio.flyway.flywaycallback.CallBackStrategy;
import com.noshio.flyway.flywaycallback.UserCount;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

@Slf4j
@Component("beforeValidate")
public class BeforeValidate implements CallBackStrategy {
    @Override
    public boolean execute(Event event, Context context, JdbcOperations jdbcOperations) {
        log.info("Running strategy for event beforeValidate");
        log.info("++++++++ THE NUMBER OF USERS CURRENTLY IS {} ++++++++", UserCount.count(jdbcOperations));
        return true;
    }
}
