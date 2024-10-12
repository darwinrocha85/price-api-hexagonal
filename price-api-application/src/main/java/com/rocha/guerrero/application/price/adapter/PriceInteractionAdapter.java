package com.rocha.guerrero.application.price.adapter;

import com.rocha.guerrero.application.price.port.PriceInteractionPort;
import com.rocha.guerrero.application.price.port.PricePort;
import com.rocha.guerrero.domain.price.model.Price;
import com.rocha.guerrero.domain.price.repository.PriceRepository;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;
import java.util.List;

@Singleton
public class PriceInteractionAdapter implements PriceInteractionPort {
    private final PricePort port;

    public PriceInteractionAdapter(PricePort port) {
        this.port = port;
    }

    @Override
    public Price create(Price price) {
        return port.create(price);
    }

    @Override
    public List<Price> findAll() {
        return port.findAll();
    }

    @Override
    public void saveAll(List<Price> prices) { port.saveAll(prices); }

}
