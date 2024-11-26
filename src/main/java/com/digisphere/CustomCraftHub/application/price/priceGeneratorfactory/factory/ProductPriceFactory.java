package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.IPriceCalculator;

public abstract class ProductPriceFactory {
    public abstract IPriceCalculator calculateProductPrice();

    public Double calculate() {
        return calculateProductPrice().calculateFinalPrice();
    }

}
