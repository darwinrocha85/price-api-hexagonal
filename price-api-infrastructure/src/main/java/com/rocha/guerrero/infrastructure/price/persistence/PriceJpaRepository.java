package com.rocha.guerrero.infrastructure.price.persistence;

import com.rocha.guerrero.infrastructure.price.persistence.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {}
