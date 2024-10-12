package com.rocha.guerrero.domain.price.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Price(
        Long id,
        Long brandId,
        LocalDate startDate,
        LocalDate endDate,
        int priceList,
        int priority,
        BigDecimal price,
        String currency)
{
}
