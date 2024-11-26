package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.FurniturePriceCalculator;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.IPriceCalculator;

import java.util.List;
import java.util.Map;

public class FurniturePriceFactory extends ProductPriceFactory{

    @Override
    public IPriceCalculator createPriceCalculator(Map<String, String> materials) {
        List<Double> priceList = this.readFile("furniturePriceList.json", materials);
        var factory = new FurniturePriceCalculator();
        factory.setPriceList(priceList);
        return factory;
    }

}
