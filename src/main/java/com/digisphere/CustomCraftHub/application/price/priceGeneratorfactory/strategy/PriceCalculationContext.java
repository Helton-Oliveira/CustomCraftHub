package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.strategy;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.ClothingPriceFactory;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.FurniturePriceFactory;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.ProductPriceFactory;

import java.util.Map;

public class PriceCalculationContext implements IPriceCalculationContext{
    private ProductPriceFactory strategy;

    @Override
    public ProductPriceFactory getPriceFactory(Map<String, String> data) {
        if (data.get("category").equalsIgnoreCase("furniture")) setStrategy(new FurniturePriceFactory());
        if (data.get("category").equalsIgnoreCase("clothing")) setStrategy(new ClothingPriceFactory());
        return strategy;
    }

    private void setStrategy(ProductPriceFactory strategy) {
        this.strategy = strategy;
    }
}
