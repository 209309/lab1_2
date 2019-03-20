package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class DefaultTaxCalculator implements TaxCalculator {

    @Override public Money calculateTaxValue(Money net, BigDecimal ratio) {
        Money taxValue = net.multiplyBy(ratio);
        return taxValue;
    }
}
