package com.rocha.guerrero.application.price.port;

import com.rocha.guerrero.domain.price.model.Price;

import java.util.List;

public interface PricePort {
    Price create(Price price);
    List<Price> findAll();
    void saveAll(List<Price> prices);
    void deleteAll();
}
