package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.IPriceCalculator;
import com.digisphere.CustomCraftHub.application.price.utils.ReadFile;

import java.util.List;
import java.util.Map;

public abstract class ProductPriceFactory {
    protected abstract IPriceCalculator createPriceCalculator(Map<String, String> materials);

    public Double calculatePrice(Map<String, String> materials) {
        IPriceCalculator calculator = createPriceCalculator(materials);
        return calculator.calculateFinalPrice();
    }

    protected List<Double> readFile(String fileName, Map<String, String> materials) {
        return ReadFile.read(fileName, materials);
    }

}
