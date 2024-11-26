package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products;

import java.util.List;
import java.util.Map;

public class FurniturePriceCalculator implements IPriceCalculator{

    private List<Double> priceList;

    @Override
    public Double calculateFinalPrice() {
        Double totalValueWithoutProfit = 0.0;
        for (Double price : priceList) {
            totalValueWithoutProfit += price;
        }
        return totalValueWithoutProfit * (1 + 0.30);
    }

    public void setPriceList(List<Double> priceList) {
        this.priceList = priceList;
    }
}
