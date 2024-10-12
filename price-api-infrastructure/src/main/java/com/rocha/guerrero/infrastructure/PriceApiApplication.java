package com.rocha.guerrero.infrastructure;

import com.rocha.guerrero.application.price.port.PriceInteractionPort;
import com.rocha.guerrero.infrastructure.price.rest.dto.PriceCreateReq;
import com.rocha.guerrero.domain.price.model.Price;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PriceApiApplication  implements CommandLineRunner {

	private final PriceInteractionPort port;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    public PriceApiApplication(PriceInteractionPort port) {
        this.port = port;
    }

    public static void main(String[] args) {
		SpringApplication.run(PriceApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		List<Price> entities = Arrays.asList(
				PriceCreateReq.toDomain(new PriceCreateReq(
						1L,
						LocalDate.parse("2020-06-14-00.00.00", formatter),
						LocalDate.parse("2020-12-31-23.59.59", formatter),
						1,
						0,
						new BigDecimal("35.50"),
						"EUR"
				)),
				PriceCreateReq.toDomain(new PriceCreateReq(
						1L,
						LocalDate.parse("2020-06-14-15.00.00", formatter),
						LocalDate.parse("2020-06-14-18.30.00", formatter),
						2,
						1,
						new BigDecimal("25.45"),
						"EUR"  )),
				PriceCreateReq.toDomain(new PriceCreateReq(
						1L,
						LocalDate.parse("2020-06-15-00.00.00", formatter),
						LocalDate.parse("2020-06-15-11.00.00", formatter),
						3,
						1,
						new BigDecimal("30.50"),
						"EUR")),
				PriceCreateReq.toDomain(new PriceCreateReq(
						1L,
						LocalDate.parse("2020-06-15-16.00.00", formatter),
						LocalDate.parse("2020-12-31-23.59.59", formatter),
						4,
						1,
						new BigDecimal("38.95"),
						"EUR" ))
		);
		port.saveAll(entities);
	}
}
