package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.ClothingPriceCalculator;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.IPriceCalculator;

public class ClothingPriceFactory extends ProductPriceFactory{
    @Override
    public IPriceCalculator calculateProductPrice() {
        return new ClothingPriceCalculator();
    }
}
