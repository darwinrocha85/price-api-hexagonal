package com.rocha.guerrero.domain.price.repository;

import com.rocha.guerrero.domain.price.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findAllRate(Long brandId, Long productId, LocalDateTime applicationDate);
}
