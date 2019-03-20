package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;

interface TaxCalculator {
    TaxInfoForCountry calculate(ProductType productType);

}
