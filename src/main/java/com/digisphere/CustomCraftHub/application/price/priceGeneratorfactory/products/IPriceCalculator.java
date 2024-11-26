package com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.products;

import java.util.Map;

public interface IPriceCalculator {
    Double calculateFinalPrice(Map<String, String> materials);
}
