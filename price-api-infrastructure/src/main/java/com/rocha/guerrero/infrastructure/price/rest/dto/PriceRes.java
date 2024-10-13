package com.rocha.guerrero.infrastructure.price.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rocha.guerrero.domain.price.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PriceRes(Long id,
                       long brandId,
                       LocalDateTime startDate,
                       LocalDateTime endDate,
                       int priceList,
                       long productId,
                       Integer priority,
                       BigDecimal price,
                       String currency) {

    public static PriceRes toResponse(Price price) {
        return new PriceRes(price.id(), price.brandId(),
                price.startDate(),
                price.endDate(),
                price.priceList(),
                price.productId(),
                price.priority(),
                price.price(),
                price.currency());
    }

    public static List<PriceRes> toResponse(List<Price> prices) {
        return prices.stream().map(PriceRes::toResponse).toList();
    }

    public static PriceRes toResponseRate(Price price) {
        return new PriceRes(
                price.id(),
                price.brandId(),
                price.startDate(),
                price.endDate(),
                price.priceList(),
                price.productId(),
                null,
                price.price(),
                null);
    }

    public static List<PriceRes> toResponseRate(List<Price> prices) {
        return prices.stream().map(PriceRes::toResponseRate).toList();
    }
}
