package com.rocha.guerrero.infrastructure.price.rest.controller;

import com.rocha.guerrero.application.price.adapter.FindPriceRateAdapter;
import com.rocha.guerrero.application.price.port.PriceInteractionPort;
import com.rocha.guerrero.infrastructure.price.rest.dto.PriceCreateReq;
import com.rocha.guerrero.infrastructure.price.rest.dto.PriceRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("prices")
public class PriceController {
    private final PriceInteractionPort port;
    private final FindPriceRateAdapter findPriceUseCase;

    @Autowired
    public PriceController(PriceInteractionPort port, FindPriceRateAdapter findPriceUseCase) {
        this.port = port;
        this.findPriceUseCase = findPriceUseCase;
    }

    @PostMapping()
    public ResponseEntity<PriceRes> create(@RequestBody PriceCreateReq priceToCreate) {
        var price= port.create(PriceCreateReq.toDomain(priceToCreate));
        return ResponseEntity.status(HttpStatus.CREATED).body(PriceRes.toResponse(price));
    }

    @GetMapping()
    public List<PriceRes> getAll() {
        return PriceRes.toResponse(port.findAll());
    }

    @GetMapping("rates")
    public List<PriceRes> getRates(@RequestParam("applicationDate") String applicationDate,
                                   @RequestParam("productId") Long productId,
                                   @RequestParam("brandId") Long brandId) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime dateTime = LocalDateTime.parse(applicationDate, formatter);

        return PriceRes.toResponseRate(findPriceUseCase.findAllRate(brandId, productId, dateTime));
    }

}
