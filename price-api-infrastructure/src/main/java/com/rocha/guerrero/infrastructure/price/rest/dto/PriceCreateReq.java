package com.rocha.guerrero.infrastructure.price.rest.dto;

import com.rocha.guerrero.domain.price.model.Price;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PriceCreateReq(Long brandId,
                             LocalDate startDate,
                             LocalDate endDate,
                             int priceList,
                             int priority,
                             BigDecimal price,
                             String currency) {
    public static Price toDomain(PriceCreateReq price) {
        return new Price(null,
                            price.brandId,
                            price.startDate,
                            price.endDate,
                            price.priceList,
                            price.priority,
                            price.price,
                            price.currency
        );
    }
}
