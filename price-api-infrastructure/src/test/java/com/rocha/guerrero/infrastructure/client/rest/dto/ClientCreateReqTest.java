package com.rocha.guerrero.infrastructure.price.rest.dto;

import com.rocha.guerrero.domain.price.model.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCreateReqTest {

    @Test
    void toDomain_whenInvoke_thenMappingCorrectly() {
        var createReq = new PriceCreateReq("test", "test2");
        var priceDomain = new Price(null, "test", "test2");

        var result = PriceCreateReq.toDomain(createReq);

        assertEquals(priceDomain, result);
    }
}