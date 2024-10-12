package com.rocha.guerrero.infrastructure.price.persistence.mapper;

import com.rocha.guerrero.domain.price.model.Price;
import com.rocha.guerrero.infrastructure.price.persistence.model.PriceEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceMapperTest {

    @Test
    void toDomain_whenHasSingleElement_thenMappingCorrectly() {
        var entity = new PriceEntity(1L, "test", "test2");
        var priceDomain = new Price(1L, "test", "test2");

        var result = PriceMapper.toDomain(entity);

        assertEquals(priceDomain, result);
    }

    @Test
    void toDomain_whenHasList_thenMappingCorrectly() {
        var entityList = List.of(
                new PriceEntity(1L, "test", "test2"),
                new PriceEntity(2L, "name", "lastname")
        );
        var priceDomainList = List.of(
                new Price(1L, "test", "test2"),
                new Price(2L, "name", "lastname")
        );

        var result = PriceMapper.toDomain(entityList);

        assertEquals(priceDomainList, result);
    }

    @Test
    void toEntity_whenInvoke_thenMappingCorrectly() {
        var entity = new PriceEntity(1L, "test", "test2");
        var priceDomain = new Price(1L, "test", "test2");

        var result = PriceMapper.toEntity(priceDomain);

        assertEquals(entity, result);
    }
}