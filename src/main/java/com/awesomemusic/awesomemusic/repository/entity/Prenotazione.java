package com.awesomemusic.awesomemusic.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@Entity
@Table(name = "prenotazione")
@AllArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "slot")
    private String slot;

    @Column(name = "stato")
    private String stato;

    @Column(name = "data_inserimento")
    private LocalDateTime dataInserimento;

    public Prenotazione() {

    }
}
