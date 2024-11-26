package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.ClothingPriceCalculator;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products.IPriceCalculator;
import com.digisphere.CustomCraftHub.application.price.utils.ReadFile;

import java.util.List;
import java.util.Map;

public class ClothingPriceFactory extends ProductPriceFactory{
    @Override
    public IPriceCalculator createPriceCalculator(Map<String, String> materials) {
        List<Double> priceList = ReadFile.read("clothingPriceList.json", materials);
        var factory = new ClothingPriceCalculator();
        factory.setPriceList(priceList);
        return factory;
    }
}
