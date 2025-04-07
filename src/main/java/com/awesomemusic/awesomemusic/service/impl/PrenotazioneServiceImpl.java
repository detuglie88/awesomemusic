package com.awesomemusic.awesomemusic.service.impl;

import com.awesomemusic.awesomemusic.model.*;
import com.awesomemusic.awesomemusic.repository.PrenotazioneRepository;
import com.awesomemusic.awesomemusic.repository.entity.Prenotazione;
import com.awesomemusic.awesomemusic.service.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneServiceImpl(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public PrenotazioneResponse creaPrenotazione(PrenotazioneRequest prenotazioneRequest) {

        LocalDate oggi = LocalDate.now();
        if (prenotazioneRequest.getData().isBefore(oggi)) { // TODO andrebbe definito un arco temporale per i 3 slot in modo da controllare anche l'orari ma potrebbe essere un evolutiva
            throw new IllegalArgumentException(
                    String.format("La data %s è precedente a oggi (%s)",
                            prenotazioneRequest.getData(), oggi)
            );
        }
        Prenotazione prenotazioneEntity = Prenotazione.builder()
                .nome(prenotazioneRequest.getNome())
                .data(prenotazioneRequest.getData())
                .slot(prenotazioneRequest.getSlot().getValue())
                .stato( StatoPrenotazione.IN_ATTESA.getValue())
                .dataInserimento(LocalDateTime.now())
                .build();

        prenotazioneEntity = prenotazioneRepository.save(prenotazioneEntity);

        PrenotazioneResponse response = new PrenotazioneResponse();
        response.setPrenotazione(getPrenotazione(prenotazioneEntity));
        return response;
    }

    public PrenotazioneResponse ottieniPrenotazione(Long id) {
        Optional<Prenotazione> prenotazioneOpt = prenotazioneRepository.findById(id);

        if(prenotazioneOpt.isPresent()){
            Prenotazione prenotazioneEntity = prenotazioneOpt.get();

            PrenotazioneResponse response = new PrenotazioneResponse();
            response.setPrenotazione(getPrenotazione(prenotazioneEntity));
            return response;
        } else {
            return null;
        }
    }



    public boolean aggiornaStatoPrenotazione(Long id, StatoPrenotazioneRequest statoPrenotazioneRequest) {
        // lo stato della prenotazione può essere aggiornato solo se è in stato "in attesa"

        // recupero la prenotazione
        Optional<Prenotazione> prenotazioneOpt = prenotazioneRepository.findById(id);
        if (prenotazioneOpt.isPresent()) {
            Prenotazione prenotazione = prenotazioneOpt.get();
            //verifico lo stato
            if(StatoPrenotazione.IN_ATTESA.equals(StatoPrenotazione.fromValue(prenotazione.getStato()))){
                prenotazione.setStato(statoPrenotazioneRequest.getStato().getValue());
                prenotazioneRepository.save(prenotazione);
                return true;
            }
        }
        return false;
    }

    @Override
    public PrenotazioniResponse ottieniPrenotazioni(StatoPrenotazione stato, SlotPrenotazione slot, Boolean ordinaPerDataInserimento) {
        List<Prenotazione> prenotazioni = null;

        if(stato!=null && slot!=null){
            prenotazioni = prenotazioneRepository.findByStatoAndSlot(stato.getValue(), slot.getValue());
        } else if(stato!=null){
            prenotazioni = prenotazioneRepository.findByStato(stato.getValue());
        } else if(slot!=null){
            prenotazioni = prenotazioneRepository.findBySlot(slot.getValue());
        } else {
            prenotazioni = prenotazioneRepository.findAll();
        }

        if(ordinaPerDataInserimento==null){
            ordinaPerDataInserimento = Boolean.FALSE;
        }


        PrenotazioniResponse response = new PrenotazioniResponse();
        response.setPrenotazioni(getPrenotazioni(prenotazioni, ordinaPerDataInserimento));
        return response;
    }



    private com.awesomemusic.awesomemusic.model.Prenotazione getPrenotazione(Prenotazione prenotazioneEntity) {
        com.awesomemusic.awesomemusic.model.Prenotazione prenotazione = new com.awesomemusic.awesomemusic.model.Prenotazione();
        prenotazione.setId(prenotazioneEntity.getId());
        prenotazione.setNome(prenotazioneEntity.getNome());
        prenotazione.setData(prenotazioneEntity.getData());
        prenotazione.setSlot(SlotPrenotazione.fromValue(prenotazioneEntity.getSlot()));
        prenotazione.setStato(StatoPrenotazione.fromValue(prenotazioneEntity.getStato()));
        prenotazione.setDataInserimento(prenotazioneEntity.getDataInserimento().atOffset(ZoneOffset.UTC));
        return prenotazione;
    }

    private List<com.awesomemusic.awesomemusic.model.Prenotazione> getPrenotazioni(List<Prenotazione> prenotazioni, boolean ordinaPerDataInserimento) {
        List<com.awesomemusic.awesomemusic.model.Prenotazione> prenotazioniList = new ArrayList<>();

        prenotazioni.stream()
                .map(this::getPrenotazione)
                .sorted((p1, p2) -> ordinaPerDataInserimento ? p1.getDataInserimento().compareTo(p2.getDataInserimento()) : p1.getData().compareTo(p2.getData()) )
                .forEach(prenotazioniList::add);

        return prenotazioniList;
    }
}