package com.rocha.guerrero.infrastructure.price.persistence.mapper;

import com.rocha.guerrero.domain.price.model.Price;
import com.rocha.guerrero.infrastructure.price.persistence.model.PriceEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceMapperTest {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    @Test
    void toDomain_whenHasSingleElement_thenMappingCorrectly() {
        var entity = new PriceEntity(1L,
                1L,
                LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                3,
                35455,
                1,
                new BigDecimal("30.50"),
                "EUR");
        var priceDomain = new Price(1L,
                1L,
                LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                3,
                35455,
                1,
                new BigDecimal("30.50"),
                "EUR");

        var result = PriceMapper.toDomain(entity);

        assertEquals(priceDomain, result);
    }

    @Test
    void toDomain_whenHasList_thenMappingCorrectly() {
        var entityList = List.of(
                new PriceEntity(1L,
                        1L,
                        LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                        LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                        3,
                        35455,
                        1,
                        new BigDecimal("30.50"),
                        "EUR"),
                new PriceEntity(2L,
                        1L,
                        LocalDateTime.parse("2020-06-14-15.00.00", formatter),
                        LocalDateTime.parse("2020-06-14-18.30.00", formatter),
                        2,
                        35455,
                        1,
                        new BigDecimal("25.45"),
                        "EUR"  )
        );
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
                        LocalDateTime.parse("2020-06-14-15.00.00", formatter),
                        LocalDateTime.parse("2020-06-14-18.30.00", formatter),
                        2,
                        35455,
                        1,
                        new BigDecimal("25.45"),
                        "EUR"  )
        );

        var result = PriceMapper.toDomain(entityList);

        assertEquals(priceDomainList, result);
    }

    @Test
    void toEntity_whenInvoke_thenMappingCorrectly() {
        var entity = new PriceEntity(1L,
                1L,
                LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                3,
                35455,
                1,
                new BigDecimal("30.50"),
                "EUR");
        var priceDomain = new Price(1L,
                1L,
                LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                3,
                35455,
                1,
                new BigDecimal("30.50"),
                "EUR");

        var result = PriceMapper.toEntity(priceDomain);

        assertEquals(entity, result);
    }
}