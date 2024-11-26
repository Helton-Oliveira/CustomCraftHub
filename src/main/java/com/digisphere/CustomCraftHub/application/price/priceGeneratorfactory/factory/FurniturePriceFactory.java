package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.FurniturePriceCalculator;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.IPriceCalculator;

public class FurniturePriceFactory extends ProductPriceFactory{

    @Override
    public IPriceCalculator calculateProductPrice() {
        return new FurniturePriceCalculator();
    }

}
