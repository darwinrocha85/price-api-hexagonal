package com.rocha.guerrero.domain.price.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(
        Long id,
        long brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        int priceList,
        long productId,
        int priority,
        BigDecimal price,
        String currency)
{
}
