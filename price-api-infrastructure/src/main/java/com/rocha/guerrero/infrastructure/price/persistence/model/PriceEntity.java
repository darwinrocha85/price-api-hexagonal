package com.rocha.guerrero.infrastructure.price.persistence.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id")
    private long brandId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private int priceList;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "priority")
    private int priority;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "curr")
    private String currency;

    public PriceEntity() {}

    public PriceEntity(Long id,
                       long brandId,
                       LocalDateTime startDate,
                       LocalDateTime endDate,
                       int priceList,
                       long productId,
                       int priority,
                       BigDecimal price,
                       String currency) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceEntity that = (PriceEntity) o;
        return Objects.equals(price, that.price) &&
                Objects.equals(id, that.id) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(brandId, that.brandId) &&
                Objects.equals(startDate, that.startDate);
    }

    // Sobreescribe el método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, productId, brandId, price, startDate);
    }
}
