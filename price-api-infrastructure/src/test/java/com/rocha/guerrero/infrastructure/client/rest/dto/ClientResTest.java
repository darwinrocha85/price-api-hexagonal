package com.rocha.guerrero.infrastructure.price.rest.dto;

import com.rocha.guerrero.domain.price.model.Price;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceResTest {

    @Test
    void toResponse_whenHasSingleElement_thenMappingCorrectly() {
        var priceDomain = new Price(1L, "test", "test2");
        var priceRes = new PriceRes(1L, "test", "test2");

        var result = PriceRes.toResponse(priceDomain);

        assertEquals(priceRes, result);
    }

    @Test
    void toResponse_whenHasList_thenMappingCorrectly() {
        var priceDomainList = List.of(
                new Price(1L, "test", "test2"),
                new Price(2L, "name", "lastname")
        );
        var priceResList = List.of(
                new PriceRes(1L, "test", "test2"),
                new PriceRes(2L, "name", "lastname")
        );

        var result = PriceRes.toResponse(priceDomainList);

        assertEquals(priceResList, result);
    }

}