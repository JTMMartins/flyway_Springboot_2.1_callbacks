package com.noshio.flyway.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_user")
public class User {
    //db column names definition
    private static final String USER_ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL_ADDRESS = "email";
    private static final String WALLET_ID = "wallet_id";
    //entity object definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = USER_ID, insertable = false, updatable = false)
    private long id;

    @Column(name = FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = LAST_NAME, nullable = false)
    private String lastName;

    @Column(name = EMAIL_ADDRESS, nullable = false, unique = true)
    private String email;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = WALLET_ID, nullable = false, updatable = false)
    private Wallet wallet;
}
