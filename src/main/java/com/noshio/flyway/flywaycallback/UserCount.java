package com.noshio.flyway.flywaycallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcOperations;

@Slf4j
public final class UserCount {

    private UserCount(){}

    public static Long count(JdbcOperations jdbcTemplate){
        Long userCount = 0L;
        try {
            userCount = jdbcTemplate.queryForObject("select count(*) from user_user", Long.class);
        }catch (Exception ex){
            log.error("Exception fetching from database");
        }
        return userCount;
    }
}


