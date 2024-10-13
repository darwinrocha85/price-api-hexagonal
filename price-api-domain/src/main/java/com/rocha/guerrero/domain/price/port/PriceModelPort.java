package com.rocha.guerrero.domain.price.port;

import com.rocha.guerrero.domain.price.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceModelPort {
    List<Price> findAllRate(long brandId, long productId, LocalDateTime applicationDate);
}
