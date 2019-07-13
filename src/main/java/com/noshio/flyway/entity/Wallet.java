package com.noshio.flyway.entity;

import com.noshio.flyway.status.CurrencyCode;
import com.noshio.flyway.status.WalletStatus;
import com.noshio.flyway.status.WalletType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "wallet")
public class Wallet {
    //db column names definition
    private static final String WALLET_ID = "id";
    private static final String WALLET_STATUS = "status";
    private static final String WALLET_TYPE = "type";
    private static final String WALLET_CURRENCY_CODE = "currency_code";
    //entity object definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = WALLET_ID, insertable = false, updatable = false)
    private long id;
    @Column(name = WALLET_STATUS)
    private WalletStatus status;
    @Column(name = WALLET_TYPE)
    private WalletType type;
    @Column(name = WALLET_CURRENCY_CODE)
    private CurrencyCode currencyCode;
}
