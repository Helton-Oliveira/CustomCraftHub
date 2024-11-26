package com.digisphere.CustomCraftHub;

import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.ClothingPriceFactory;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.FurniturePriceFactory;
import com.digisphere.CustomCraftHub.application.price.priceGeneratorfactory.factory.ProductPriceFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

   /* @Test
    @DisplayName("Deve precificar produto de acordo com escolhas do usuario")
    void price() {
        Map<String, String> data = new HashMap<>();

        IShowPrice product = new ShowPrice();
        Double getPrice = product.execute(data);

        assertThat(getPrice <= 0).isFalse();
    }*/

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
                "botoes", "simples"
        );

        ProductPriceFactory factory = new ClothingPriceFactory();
        Double finalPrice = factory.calculatePrice(materials);

        System.out.println(finalPrice);
        assertThat(finalPrice <= 0).isFalse();
    }
}
