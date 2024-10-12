package com.rocha.guerrero.application.price.adapter;

import com.rocha.guerrero.application.price.port.PricePort;
import com.rocha.guerrero.domain.price.model.Price;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class PriceInteractionAdapterTest {

    private final PricePort pricePort = mock(PricePort.class);
    private final PriceInteractionAdapter sut = new PriceInteractionAdapter(pricePort);

    @Test
    void create_whenInvoke_thenCallCreateFromCreatePort() {
        var price = new Price(null, "name", "lastName");

        sut.create(price);

        verify(pricePort).create(price);
    }

    @Test
    void create_whenPortReturnPrice_thenReturnCorrectly() {
        var price = new Price(null, "name", "lastName");
        var priceExpected = new Price(1L, price.name(), price.lastName());
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
                new Price(1L, "name", "lastName"),
                new Price(2L, "name", "lastName")
        );
        doReturn(expectedList).when(pricePort).findAll();

        var result = sut.findAll();

        assertEquals(expectedList, result);
    }

}