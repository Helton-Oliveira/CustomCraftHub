package com.digisphere.CustomCraftHub.application.price.useCase;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.strategy.IPriceCalculationContext;

import java.util.Map;

public class ShowPrice implements IShowPrice {
    private final IPriceCalculationContext context;

    public ShowPrice(IPriceCalculationContext context) {
        this.context = context;
    }

    @Override
    public Double execute(Map<String, String> data) {
        var factory = context.getPriceFactory(data);

        return factory.calculatePrice(data);
    }
}
