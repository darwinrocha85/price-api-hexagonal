package com.rocha.guerrero.application.price.adapter;

import com.rocha.guerrero.application.price.port.PriceInteractionPort;
import com.rocha.guerrero.application.price.port.PricePort;
import com.rocha.guerrero.application.price.port.PriceRatePort;
import com.rocha.guerrero.domain.price.model.Price;
import com.rocha.guerrero.domain.price.repository.PriceRepository;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;
import java.util.List;

@Singleton
public class FindPriceRateAdapter implements PriceRepository{

    private final PriceRatePort priceRatePort;

    public FindPriceRateAdapter(PriceRatePort priceRatePort) {
        this.priceRatePort = priceRatePort;
    }

    public List<Price> findAllRate(Long brandId, Long productId, LocalDateTime applicationDate) {
        return priceRatePort.findAllRate(brandId, productId, applicationDate);
    }

}
