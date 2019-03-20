package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;

import java.math.BigDecimal;

public class DefaultTaxCalculatorImpl implements TaxCalculator {

    @Override public TaxInfoForCountry calculate(ProductType productType) {
        TaxInfoForCountry taxInfoForCountry = new TaxInfoForCountry();

        switch (productType) {
            case FOOD: {
                taxInfoForCountry.setRatio(new BigDecimal("0.07"));
                taxInfoForCountry.setDescription("7% (F)");
                break;
            }

            case STANDARD:
                taxInfoForCountry.setRatio(new BigDecimal("0.23"));
                taxInfoForCountry.setDescription("23%");
                break;

            case DRUG: {
                taxInfoForCountry.setRatio(new BigDecimal("0.05"));
                taxInfoForCountry.setDescription("5% (D)");
                break;
            }

            default: {
                throw new IllegalArgumentException(productType + " not handled");
            }
        }
        return taxInfoForCountry;
    }
}
