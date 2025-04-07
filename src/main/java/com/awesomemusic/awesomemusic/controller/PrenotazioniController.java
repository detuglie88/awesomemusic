package com.awesomemusic.awesomemusic.controller;

import com.awesomemusic.awesomemusic.api.PrenotazioniApi;
import com.awesomemusic.awesomemusic.model.*;
import com.awesomemusic.awesomemusic.service.PrenotazioneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrenotazioniController implements PrenotazioniApi {


    private final PrenotazioneService prenotazioneService;

    public PrenotazioniController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @Override
    public ResponseEntity<Void> aggiornaPrenotazione(Long id, StatoPrenotazioneRequest statoPrenotazioneRequest) {
        boolean aggiornato = prenotazioneService.aggiornaStatoPrenotazione(id, statoPrenotazioneRequest);
        return aggiornato ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<PrenotazioneResponse> creaPrenotazione(PrenotazioneRequest prenotazioneRequest) {
        PrenotazioneResponse response = prenotazioneService.creaPrenotazione(prenotazioneRequest);
        return ResponseEntity.status(201).body(response);
    }

    @Override
    public ResponseEntity<PrenotazioneResponse> ottieniPrenotazione(Long id) {
        PrenotazioneResponse response = prenotazioneService.ottieniPrenotazione(id);

        if(response!=null){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    public ResponseEntity<PrenotazioniResponse> ottieniPrenotazioni(StatoPrenotazione stato, SlotPrenotazione slot, Boolean ordinaPerDataInserimento) {
        PrenotazioniResponse response = prenotazioneService.ottieniPrenotazioni(stato, slot, ordinaPerDataInserimento);

        if(response!=null){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
