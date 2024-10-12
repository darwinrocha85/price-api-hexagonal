package com.rocha.guerrero.infrastructure.price.persistence.mapper;

import com.rocha.guerrero.domain.price.model.Price;
import com.rocha.guerrero.infrastructure.price.persistence.model.PriceEntity;

import java.util.List;

public class PriceMapper {

    private PriceMapper() {}
    public static Price toDomain(PriceEntity entity) {
        return new Price(entity.getId(),
                entity.getBrandId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceList(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrency()
                );
    }
    public static List<Price> toDomain(List<PriceEntity> entityList) {
        return entityList.stream().map(PriceMapper::toDomain).toList();
    }
    public static PriceEntity toEntity(Price price) {
        return new PriceEntity(price.id(),
                price.brandId(),
                price.startDate(),
                price.endDate(),
                price.priceList(),
                price.priority(),
                price.price(),
                price.currency());
    }
    public static List<PriceEntity> toEntity( List<Price> priceList) {
        return priceList.stream().map(PriceMapper::toEntity).toList();
    }
}
