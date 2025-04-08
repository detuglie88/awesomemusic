package com.awesomemusic.awesomemusic.controller;


import com.awesomemusic.awesomemusic.AwesomeMusicApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_CLASS;

@SpringBootTest(classes= AwesomeMusicApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j(topic = "target")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Sql(scripts = {"classpath:setup.sql"}, executionPhase = BEFORE_TEST_CLASS)
public class PrenotazioniControllerTest extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String basePath() {
        return "http://localhost:" + port + "/awesomemusic/v1";
    }

    @Test
    @Order(1)
    public void ottieniPrenotazioniTest(TestInfo testInfo) throws Exception{
        String url = basePath() + "/prenotazioni";
        ResponseEntity<String> risposta = restTemplate.getForEntity(url, String.class);

        log.info("URL richiesto: " + url);
        log.info("Risposta ricevuta: " + risposta.getBody());

        assertThat(risposta.getStatusCodeValue()).isEqualTo(200);

        String expectedResponse = mapJsonToString(testInfo, "response");
        JSONAssert.assertEquals(expectedResponse, risposta.getBody(), true);
    }

    @Test
    @Order(2)
    public void creaPrenotazioneTest() {
        String url = basePath() + "/prenotazioni";
        String jsonRequest = "{ \"nome\": \"Danilo\", \"data\": \"2025-12-11\", \"slot\": \"MATTINA\" }";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequest, headers);

        ResponseEntity<String> risposta = restTemplate.postForEntity(url, requestEntity, String.class);

        log.info("URL richiesto: " + url);
        log.info("Risposta ricevuta: " + risposta.getBody());

        assertThat(risposta.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    @Order(3)
    public void ottieniPrenotazioneTest(TestInfo testInfo) throws Exception{
        String url = basePath() + "/prenotazioni/81";
        ResponseEntity<String> risposta = restTemplate.getForEntity(url, String.class);

        log.info("URL richiesto: " + url);
        log.info("Risposta ricevuta: " + risposta.getBody());

        assertThat(risposta.getStatusCodeValue()).isEqualTo(200);

        String expectedResponse = mapJsonToString(testInfo, "response");
        JSONAssert.assertEquals(expectedResponse, risposta.getBody(), true);
    }

    @Test
    @Order(4)
    public void aggiornaPrenotazioneTest() {
        String url = basePath() + "/prenotazioni/81";
        String jsonRequest = "{ \"stato\": \"APPROVATA\" }";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequest, headers);

        ResponseEntity<String> risposta = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, String.class);

        log.info("URL richiesto: " + url);
        log.info("Risposta ricevuta: " + risposta.getBody());

        assertThat(risposta.getStatusCodeValue()).isEqualTo(200);
    }


    @Test
    @Order(5)
    public void ottieniPrenotazioneTest_2(TestInfo testInfo) throws Exception{
        String url = basePath() + "/prenotazioni/81";
        ResponseEntity<String> risposta = restTemplate.getForEntity(url, String.class);

        log.info("URL richiesto: " + url);
        log.info("Risposta ricevuta: " + risposta.getBody());

        assertThat(risposta.getStatusCodeValue()).isEqualTo(200);

        String expectedResponse = mapJsonToString(testInfo, "response");
        JSONAssert.assertEquals(expectedResponse, risposta.getBody(), true);
    }
}