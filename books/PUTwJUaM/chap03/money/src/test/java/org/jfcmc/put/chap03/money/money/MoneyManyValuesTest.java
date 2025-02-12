package org.jfcmc.put.chap03.money.money;

// import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
// import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for Money Class
 */
public class MoneyManyValuesTest {
    
    @ParameterizedTest
    @ValueSource(ints = { 10, 20, 50 })
    void constructorShouldSetAmountAndCurrency(int amount) {
	Money money = new Money(amount, "USD");

	assertThat(money.getAmount()).isEqualTo(amount);
    }
}
