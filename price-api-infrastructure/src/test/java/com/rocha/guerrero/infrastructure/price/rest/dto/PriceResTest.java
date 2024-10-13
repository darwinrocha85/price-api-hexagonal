package com.rocha.guerrero.infrastructure.price.rest.dto;

import com.rocha.guerrero.domain.price.model.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceResTest {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");


    @Test
    void toResponse_whenHasSingleElement_thenMappingCorrectly() {
        var priceDomain = new Price(1L,
                1L,
                LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                3,
                35455,
                1,
                new BigDecimal("30.50"),
                "EUR" );
        var priceRes = new PriceRes(1L,
                1L,
                LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                3,
                35455,
                1,
                new BigDecimal("30.50"),
                "EUR");

        var result = PriceRes.toResponse(priceDomain);

        assertEquals(priceRes, result);
    }

    @Test
    void toResponse_whenHasList_thenMappingCorrectly() {
        var priceDomainList = List.of(
                new Price(1L,
                        1L,
                        LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                        LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                        3,
                        35455,
                        1,
                        new BigDecimal("30.50"),
                        "EUR"),
                new Price(2L,
                        1L,
                        LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                        LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                        4,
                        35455,
                        1,
                        new BigDecimal("30.50"),
                        "EUR")
        );
        var priceResList = List.of(
                new PriceRes(1L,
                        1L,
                        LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                        LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                        3,
                        35455,
                        1,
                        new BigDecimal("30.50"),
                        "EUR"),
                new PriceRes(2L,
                        1L,
                        LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                        LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                        4,
                        35455,
                        1,
                        new BigDecimal("30.50"),
                        "EUR")
        );

        var result = PriceRes.toResponse(priceDomainList);

        assertEquals(priceResList, result);
    }

}