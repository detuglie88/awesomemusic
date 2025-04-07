package com.awesomemusic.awesomemusic.repository;

import com.awesomemusic.awesomemusic.repository.entity.Prenotazione;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByStatoAndSlot(String stato, String stato1);

    List<Prenotazione> findByStato(String value);

    List<Prenotazione> findBySlot(String value);

}