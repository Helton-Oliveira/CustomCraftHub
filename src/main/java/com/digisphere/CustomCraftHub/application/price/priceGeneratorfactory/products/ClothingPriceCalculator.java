package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products;

import com.digisphere.CustomCraftHub.application.price.utils.ReadFile;

import java.util.List;
import java.util.Map;

public class ClothingPriceCalculator implements IPriceCalculator{
    private List<Double> priceList;

    @Override
    public Double calculateFinalPrice(Map<String, String> materials) {

        Double totalValueWithoutProfit = 0.0;
        for (Double price : priceList) {
            totalValueWithoutProfit += price;
        }

        return totalValueWithoutProfit * (1 + 0.25);
    }

    public void setPriceList(List<Double> priceList) {
        this.priceList = priceList;
    }
}
