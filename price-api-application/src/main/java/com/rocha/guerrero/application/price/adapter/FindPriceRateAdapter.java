package com.rocha.guerrero.application.price.adapter;

import com.rocha.guerrero.application.price.port.PriceRatePort;
import com.rocha.guerrero.domain.price.model.Price;
import com.rocha.guerrero.domain.price.port.PriceModelPort;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;
import java.util.List;

@Singleton
public class FindPriceRateAdapter implements PriceModelPort{

    private final PriceRatePort priceRatePort;

    public FindPriceRateAdapter(PriceRatePort priceRatePort) {
        this.priceRatePort = priceRatePort;
    }

    public List<Price> findAllRate(long brandId, long productId, LocalDateTime applicationDate) {
        return priceRatePort.findAllRate(brandId, productId, applicationDate);
    }

}
