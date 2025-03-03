package org.jfcmc.put.chap03.money.money;

import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for Money Class
 */
public class MoneyTest {

    @Test
    void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10, "USD");

        assertThat(money.getAmount()).isEqualTo(10);
        assertThat(money.getCurrency()).isEqualTo("USD");
    }
}
