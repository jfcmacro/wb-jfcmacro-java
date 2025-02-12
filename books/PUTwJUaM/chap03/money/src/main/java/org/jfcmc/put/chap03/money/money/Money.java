package org.jfcmc.put.chap03.money.money;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Money {
    @Getter private final int amount;
    @Getter private final String currency;
}
