package com.rocha.guerrero.application.price.adapter;

import com.rocha.guerrero.application.price.port.PricePort;
import com.rocha.guerrero.domain.price.model.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PriceInteractionAdapterTest {

    private final PricePort pricePort = mock(PricePort.class);
    private final PriceInteractionAdapter sut = new PriceInteractionAdapter(pricePort);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    @Test
    void create_whenInvoke_thenCallCreateFromCreatePort() {
        var price = new Price(1L,
                1L,
                LocalDateTime.parse("2020-06-14-00.00.00", formatter),
                LocalDateTime.parse("2020-12-31-23.59.59", formatter),
                1,
                35455,
                0,
                new BigDecimal("35.50"),
                "EUR");

        sut.create(price);

        verify(pricePort).create(price);
    }

    @Test
    void create_whenPortReturnPrice_thenReturnCorrectly() {
        var price = new Price(1L,
                1L,
                LocalDateTime.parse("2020-06-14-00.00.00", formatter),
                LocalDateTime.parse("2020-12-31-23.59.59", formatter),
                1,
                35455,
                0,
                new BigDecimal("35.50"),
                "EUR");
        var priceExpected = new Price(1L, price.brandId(),
                price.startDate(),
                price.endDate(),
                price.priceList(),
                price.productId(),
                price.priority(),
                price.price(),
                price.currency());
        doReturn(priceExpected).when(pricePort).create(price);

        var result = sut.create(price);

        assertEquals(priceExpected, result);
    }

    @Test
    void findAll_whenInvoke_thenCallFindAllCreatePort() {
        sut.findAll();

        verify(pricePort).findAll();
    }

    @Test
    void findAll_whenPortReturnElements_thenReturnCorrectly() {
        var expectedList = List.of(
                new Price(1L,
                        1L,
                        LocalDateTime.parse("2020-06-14-00.00.00", formatter),
                        LocalDateTime.parse("2020-12-31-23.59.59", formatter),
                        1,
                        35455,
                        0,
                        new BigDecimal("35.50"),
                        "EUR"),
                new Price(2L,
                        1L,
                        LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                        LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                        3,
                        35455,
                        1,
                        new BigDecimal("30.50"),
                        "EUR")
        );
        doReturn(expectedList).when(pricePort).findAll();

        var result = sut.findAll();

        assertEquals(expectedList, result);
    }

}