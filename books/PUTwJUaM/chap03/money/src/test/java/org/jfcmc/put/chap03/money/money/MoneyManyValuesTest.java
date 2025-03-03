package org.jfcmc.put.chap03.money.money;

// import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Unit test for Money Class
 */
public class MoneyManyValuesTest {

    private final static String VALID_CURRENCY = "USD";

    @ParameterizedTest
    @ValueSource(ints = { 10, 20, 50 })
    void constructorShouldSetAmountAndCurrency(int amount) {
        Money money = new Money(amount, "USD");

        assertThat(money.getAmount()).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource({"10, USD",
                "15, EUR",
                "50, CHF"})
    void constructorShouldSetAmountAndCurrency(int amount, String currency) {
        Money money = new Money(amount, currency);

        assertThat(money.getAmount()).isEqualTo(amount);
        assertThat(money.getCurrency()).isEqualTo(currency);
    }

    @ParameterizedTest
    @ValueSource(ints = { -12387, -5, -1 })
    void constructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                    new Money(invalidAmount, VALID_CURRENCY);
                });
    }
}
