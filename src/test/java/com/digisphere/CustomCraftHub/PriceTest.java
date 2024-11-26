package com.digisphere.CustomCraftHub;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.ClothingPriceFactory;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.FurniturePriceFactory;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.ProductPriceFactory;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.strategy.IPriceCalculationContext;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.strategy.PriceCalculationContext;
import com.digisphere.CustomCraftHub.application.price.useCase.IShowPrice;
import com.digisphere.CustomCraftHub.application.price.useCase.ShowPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @Test
    @DisplayName("Deve precificar produto de acordo com escolhas do usuario")
    void price() {
        IPriceCalculationContext priceFactory = new PriceCalculationContext();

        Map<String, String> data = Map.of(
                "category", "furniture",
                "mdf", "branco_fosco",
                "mesa", "pequena",
                "ferragens", "puxadores",
                "acabamentos", "verniz_fosco"
        );

        IShowPrice product = new ShowPrice(priceFactory);
        Double getPrice = product.execute(data);

        System.out.println(getPrice);
        assertThat(getPrice <= 0).isFalse();
    }

    @Test
    @DisplayName("Deve precificar produto de acordo com escolhas do usuario")
    void priceOfFurnitureMaterials() {

        Map<String, String> materials = Map.of(
                "mdf", "branco_fosco",
                "mesa", "pequena",
                "ferragens", "puxadores",
                "acabamentos", "verniz_fosco"
        );

        ProductPriceFactory factory = new FurniturePriceFactory();
        Double finalPrice = factory.calculatePrice(materials);

        System.out.println(finalPrice);
        assertThat(finalPrice <= 0).isFalse();
    }

    @Test
    @DisplayName("Deve precificar produto de acordo com escolhas do usuario")
    void priceOfClothingMaterials() {

        Map<String, String> materials = Map.of(
                "tecidos", "poliester",
                "camisa", "m",
                "botoes", "simples"
        );

        ProductPriceFactory factory = new ClothingPriceFactory();
        Double finalPrice = factory.calculatePrice(materials);

        System.out.println(finalPrice);
        assertThat(finalPrice <= 0).isFalse();
    }
}
