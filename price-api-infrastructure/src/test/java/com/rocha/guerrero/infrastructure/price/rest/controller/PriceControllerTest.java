package com.rocha.guerrero.infrastructure.price.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocha.guerrero.application.price.port.PriceInteractionPort;
import com.rocha.guerrero.domain.price.model.Price;
import com.rocha.guerrero.infrastructure.price.rest.dto.PriceCreateReq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PriceInteractionPort port;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");


    @BeforeEach
    public void setUp() {

        port.deleteAll();
        List<Price> entities = Arrays.asList(
                PriceCreateReq.toDomain(new PriceCreateReq(
                        1L,
                        LocalDateTime.parse("2020-06-14-00.00.00", formatter),
                        LocalDateTime.parse("2020-12-31-23.59.59", formatter),
                        1,
                        35455,
                        0,
                        new BigDecimal("35.50"),
                        "EUR"
                )),
                PriceCreateReq.toDomain(new PriceCreateReq(
                        1L,
                        LocalDateTime.parse("2020-06-14-15.00.00", formatter),
                        LocalDateTime.parse("2020-06-14-18.30.00", formatter),
                        2,
                        35455,
                        1,
                        new BigDecimal("25.45"),
                        "EUR"  )),
                PriceCreateReq.toDomain(new PriceCreateReq(
                        1L,
                        LocalDateTime.parse("2020-06-15-00.00.00", formatter),
                        LocalDateTime.parse("2020-06-15-11.00.00", formatter),
                        3,
                        35455,
                        1,
                        new BigDecimal("30.50"),
                        "EUR")),
                PriceCreateReq.toDomain(new PriceCreateReq(
                        1L,
                        LocalDateTime.parse("2020-06-15-16.00.00", formatter),
                        LocalDateTime.parse("2020-12-31-23.59.59", formatter),
                        4,
                        35455,
                        1,
                        new BigDecimal("38.95"),
                        "EUR" ))
        );
        port.saveAll(entities);


    }

    @Test
    public void testGetPrice() throws Exception {
        int productId = 35455;
        int brandId = 1;

        // dates to validate
        List<String> dateList = new ArrayList<>();
        dateList.add("2020-06-14-10.00.00");
        dateList.add("2020-06-14-16.00.00");
        dateList.add("2020-06-14-21.00.00");
        dateList.add("2020-06-15-10.00.00");
        dateList.add("2020-06-16-21.00.00");

        // urls to validate
        List<String> urls = new ArrayList<>();
        urls.add("/prices/rates?applicationDate=2020-06-14-10.00.00&productId=35455&brandId=1"); //test 1
        urls.add("/prices/rates?applicationDate=2020-06-14-16.00.00&productId=35455&brandId=1"); //test 2
        urls.add("/prices/rates?applicationDate=2020-06-14-21.00.00&productId=35455&brandId=1"); //test 3
        urls.add("/prices/rates?applicationDate=2020-06-15-10.00.00&productId=35455&brandId=1"); //test 4
        urls.add("/prices/rates?applicationDate=2020-06-16-21.00.00&brandId=1&productId=35455"); // test 5

        for(int index = 0; index < urls.size(); index++) {

            MvcResult mvcResult = mockMvc.perform(get(urls.get(index)))
                    .andExpect(status().isOk())
                    .andReturn();

            String jsonResponse = mvcResult.getResponse().getContentAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            System.out.println("Se inicia las pruebas del test " + (index+1));
            for (JsonNode itemObject: rootNode) {


                System.out.println(itemObject.toString());
                boolean isBrandId = itemObject.get("brandId").asInt() == brandId;
                if(!isBrandId) {
                    throw new AssertionError("La cadena del grupo no coincide");
                }

                boolean isProductId = itemObject.get("productId").asInt() == productId;
                if(!isProductId) {
                    throw new AssertionError("El producto no coincide");
                }

                String startDate1 = itemObject.get("startDate").asText();
                String endDate1 = itemObject.get("endDate").asText();

                boolean isBetween = isBetween(dateList.get(index), startDate1, endDate1);
                if (!isBetween) {
                    throw new AssertionError("La fecha no está entre las fechas de inicio y fin del primer objeto");
                }

            }
            System.out.println("Se finaliza exitosamente las pruebas del test " + (index+1));
        }
    }

    @Test
    public void testPriceNotFound() throws Exception {
        mockMvc.perform(get("/api/prices/{id}", 999))
                .andExpect(status().isNotFound());
    }

    private static boolean isBetween(String dateToValidateStr, String startDateStr, String endDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");


        // Convertimos las fechas de String a LocalDateTime
        LocalDateTime dateToValidate = LocalDateTime.parse(dateToValidateStr, formatterInput);
        LocalDateTime startDate = LocalDateTime.parse(startDateStr, formatter);
        LocalDateTime endDate = LocalDateTime.parse(endDateStr, formatter);

        // Verificamos si la fecha está entre startDate y endDate
        return !dateToValidate.isBefore(startDate) && !dateToValidate.isAfter(endDate);
    }
}

