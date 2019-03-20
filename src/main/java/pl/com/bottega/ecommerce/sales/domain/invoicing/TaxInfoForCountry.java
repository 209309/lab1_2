package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

public class TaxInfoForCountry {

    private BigDecimal ratio;
    private String description;

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
