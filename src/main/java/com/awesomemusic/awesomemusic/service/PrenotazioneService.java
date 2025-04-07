package com.awesomemusic.awesomemusic.service;

import com.awesomemusic.awesomemusic.model.*;
import com.awesomemusic.awesomemusic.repository.entity.Prenotazione;

import java.time.LocalDate;
import java.util.Optional;

public interface PrenotazioneService {

    public PrenotazioneResponse creaPrenotazione(PrenotazioneRequest prenotazioneRequest);
    PrenotazioneResponse ottieniPrenotazione(Long id);
    public boolean aggiornaStatoPrenotazione(Long id, StatoPrenotazioneRequest statoPrenotazioneRequest);
    public PrenotazioniResponse ottieniPrenotazioni(StatoPrenotazione stato, SlotPrenotazione slot, Boolean ordinaPerDataInserimento);
}
