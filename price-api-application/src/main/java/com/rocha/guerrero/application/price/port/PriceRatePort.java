package com.rocha.guerrero.application.price.port;

import com.rocha.guerrero.domain.price.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRatePort {

    List<Price> findAllRate(long brandId, long productId, LocalDateTime applicationDate);
}
