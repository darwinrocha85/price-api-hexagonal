package com.rocha.guerrero.infrastructure.price.rest.dto;

import com.rocha.guerrero.domain.price.model.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCreateReqTest {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    @Test
    void toDomain_whenInvoke_thenMappingCorrectly() {
        var createReq = new PriceCreateReq(
                1L,
                LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                3,
                35455,
                1,
                new BigDecimal("30.50"),
                "EUR");
        var priceDomain = new Price(null,
                1L,
                LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                3,
                35455,
                1,
                new BigDecimal("30.50"),
                "EUR");

        var result = PriceCreateReq.toDomain(createReq);

        assertEquals(priceDomain, result);
    }
}