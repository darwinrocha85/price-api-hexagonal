package com.rocha.guerrero.infrastructure.price.rest.dto;

import com.rocha.guerrero.domain.price.model.Price;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PriceRes(Long id,
                       Long brandId,
                       LocalDate startDate,
                       LocalDate endDate,
                       int priceList,
                       int priority,
                       BigDecimal price,
                       String currency) {
    public static PriceRes toResponse(Price price) {
        return new PriceRes(price.id(), price.brandId(),
                price.startDate(),
                price.endDate(),
                price.priceList(),
                price.priority(),
                price.price(),
                price.currency());
    }
    public static List<PriceRes> toResponse(List<Price> prices) {
        return prices.stream().map(PriceRes::toResponse).toList();
    }
}
