package com.rocha.guerrero.domain.price.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(
        Long id,
        Long brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        int priceList,
        long productId,
        int priority,
        BigDecimal price,
        String currency)
{
}
