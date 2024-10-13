package com.rocha.guerrero.infrastructure.price.rest.dto;

import com.rocha.guerrero.domain.price.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceCreateReq(long brandId,
                             LocalDateTime startDate,
                             LocalDateTime endDate,
                             int priceList,
                             long productId,
                             int priority,
                             BigDecimal price,
                             String currency) {
    public static Price toDomain(PriceCreateReq price) {
        return new Price(
                null,
                price.brandId,
                price.startDate,
                price.endDate,
                price.priceList,
                price.productId,
                price.priority,
                price.price,
                price.currency
        );
    }
}
