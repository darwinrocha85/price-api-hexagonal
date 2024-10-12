package com.rocha.guerrero.infrastructure.price.persistence.adapter;

import com.rocha.guerrero.application.price.port.PricePort;
import com.rocha.guerrero.domain.price.model.Price;
import com.rocha.guerrero.infrastructure.price.persistence.PriceJpaRepository;
import com.rocha.guerrero.infrastructure.price.persistence.mapper.PriceMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceJpaAdapter implements PricePort {

    public PriceJpaAdapter(PriceJpaRepository repository) {
        this.repository = repository;
    }
    private final PriceJpaRepository repository;

    @Override
    public Price create(Price price) {
        return PriceMapper.toDomain(repository.save(PriceMapper.toEntity(price)));
    }

    @Override
    public List<Price> findAll() {
        return PriceMapper.toDomain(repository.findAll());
    }

    @Override
    public void saveAll(List<Price> prices) { repository.saveAll(PriceMapper.toEntity(prices)); }
}
