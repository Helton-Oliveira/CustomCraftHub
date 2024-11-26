package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.strategy;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.ProductPriceFactory;

import java.util.Map;

public interface IPriceCalculationContext {
    ProductPriceFactory getPriceFactory(Map<String, String> data);
}
