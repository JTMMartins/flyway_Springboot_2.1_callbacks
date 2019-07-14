package com.noshio.flyway.flywaycallbackstrategy.after;

import com.noshio.flyway.flywaycallbackstrategy.CallBackStrategy;
import com.noshio.flyway.flywaycallbackstrategy.UserCount;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

@Slf4j
@Component("afterValidate")
public class AfterValidate implements CallBackStrategy {

    @Override
    public boolean execute(Event event, Context context, JdbcOperations jdbcOperations) {
        log.info("Running strategy for event afterValidate");
        log.info("++++++++ THE NUMBER OF USERS CURRENTLY IS {} ++++++++", UserCount.count(jdbcOperations));
        return true;
    }
}
