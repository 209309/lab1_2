package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public interface TextCalculator {
    String desc = "";

    static Money calculate(RequestItem item){
        Money net = item.getTotalCost();
        BigDecimal ratio = null;
        String desc = null;

        switch (item.getProductData()
                .getType()) {
            case FOOD:
                ratio = BigDecimal.valueOf(0.07);
                desc = "7% (F)";
                break;
            case STANDARD:
                ratio = BigDecimal.valueOf(0.23);
                desc = "23%";
                break;
            case DRUG:
                ratio = BigDecimal.valueOf(0.05);
                desc = "5% (D)";
                break;
            default:
                throw new IllegalArgumentException(item.getProductData()
                        .getType()
                        + " not handled");
        }

        return net.multiplyBy(ratio);
    }

}
