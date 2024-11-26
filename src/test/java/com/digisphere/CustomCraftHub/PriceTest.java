package com.digisphere.CustomCraftHub;

import com.digisphere.CustomCraftHub.application.price.useCase.IShowPrice;
import com.digisphere.CustomCraftHub.application.price.useCase.ShowPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @Test
    @DisplayName("Deve precificar produto de acordo com escolhas do usuario")
    void price() {
        Map<String, String> data = new HashMap<>();

        IShowPrice product = new ShowPrice();
        Double getPrice = product.execute(data);

        assertThat(getPrice <= 0).isFalse();
    }
}
