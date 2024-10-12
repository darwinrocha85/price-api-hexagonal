package com.rocha.guerrero.infrastructure.price.rest.controller;

import com.rocha.guerrero.application.price.port.PriceInteractionPort;
import com.rocha.guerrero.infrastructure.price.rest.dto.PriceCreateReq;
import com.rocha.guerrero.infrastructure.price.rest.dto.PriceRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prices")
public class PriceController {
    private final PriceInteractionPort port;

    public PriceController(PriceInteractionPort port) {
        this.port = port;
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

}
