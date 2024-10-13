package com.rocha.guerrero.infrastructure.price.persistence.adapter;

import com.rocha.guerrero.application.price.port.PriceRatePort;
import com.rocha.guerrero.domain.price.model.Price;
import com.rocha.guerrero.infrastructure.price.persistence.PriceJpaRepository;
import com.rocha.guerrero.infrastructure.price.persistence.mapper.PriceMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PriceRateJpaAdapter implements PriceRatePort {

    public PriceRateJpaAdapter(PriceJpaRepository repository) {
        this.repository = repository;
    }
    private final PriceJpaRepository repository;

    @Override
    public List<Price> findAllRate(long brandId, long productId, LocalDateTime applicationDate) {
        return PriceMapper.toDomain(repository.findAllRate(brandId,productId,applicationDate));
    }
}
