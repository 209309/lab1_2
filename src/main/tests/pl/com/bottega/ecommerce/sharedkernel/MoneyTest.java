package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class MoneyTest {

    private Money money;
    private Money moneyTwo;

    @Before
    public void setUp() {
    }

    @Test
    public void shouldReturnTrueIfFirstIsGreater() {
        money = new Money(5);
        moneyTwo = new Money(0);
        Assert.assertThat(true, is(money.greaterThan(moneyTwo)));
    }

    @Test
    public void shouldReturnFalseIfFirstIsLesser() {
        money = new Money(0);
        moneyTwo = new Money(5);
        Assert.assertThat(false, is(money.greaterThan(moneyTwo)));
    }

    @Test
    public void shouldReturnFalseIfEqual() {
        money = new Money(5);
        moneyTwo = new Money(5);
        Assert.assertThat(false, is(money.greaterThan(moneyTwo)));
    }

    @Test
    public void shouldReturnFalseIfFirstIsGrater() {
        money = new Money(5);
        moneyTwo = new Money(0);
        Assert.assertThat(false, is(money.lessThan(moneyTwo)));
    }

    @Test
    public void shouldReturnTrueIfAreEqual() {
        money = new Money(5);
        moneyTwo = new Money(5);
        Assert.assertThat(true, is(money.lessOrEquals(moneyTwo)));
    }

    @Test
    public void shouldReturnTenEuro() {
        money = new Money(5);
        moneyTwo = new Money(5);
        Assert.assertThat("10.00 €", is(money.add(moneyTwo).toString()));
    }

    @Test
    public void shouldReturnZeroEuro() {
        money = new Money(5);
        moneyTwo = new Money(5);
        Assert.assertThat("0.00 €", is(money.subtract(moneyTwo).toString()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfCurrenciesAreDifferent() {
        money = new Money(5, "EUR");
        moneyTwo = new Money(5, "PL");
        money.add(moneyTwo);
    }
}