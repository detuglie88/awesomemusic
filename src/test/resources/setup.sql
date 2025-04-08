--  CREATE DATABASE awesome_music_test WITH owner postgres;

--  CREATE SCHEMA public;

-- DROP TABLE prenotazione;
--
-- CREATE TABLE prenotazione (
--   id BIGSERIAL PRIMARY KEY,
--   nome VARCHAR(255) NOT NULL,
--   data DATE NOT NULL,
--   slot VARCHAR(20) CHECK (slot IN ('MATTINA', 'POMERIGGIO', 'SERA')),
--   stato VARCHAR(20) CHECK (stato IN ('IN_ATTESA', 'APPROVATA', 'RIFIUTATA')) DEFAULT 'IN_ATTESA',
--   data_inserimento TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
-- );
-- CREATE INDEX idx_prenotazione_data ON prenotazione(data);
-- CREATE INDEX idx_prenotazione_stato ON prenotazione(stato);
-- CREATE INDEX idx_prenotazione_data_inserimento ON prenotazione(data_inserimento);




TRUNCATE TABLE prenotazione RESTART IDENTITY;

-- Prenotazioni del 2025-04-04
INSERT INTO prenotazione (nome, data, slot, stato, data_inserimento) VALUES
('Mario Rossi', '2025-04-04', 'MATTINA', 'RIFIUTATA', '2025-04-03 11:00:00'),
('Francesco Rossi', '2025-04-04', 'MATTINA', 'RIFIUTATA', '2025-04-03 11:05:00'),
('Aldo Rossi', '2025-04-04', 'MATTINA', 'RIFIUTATA', '2025-04-03 11:10:00'),
('Maria Rossi', '2025-04-04', 'MATTINA', 'RIFIUTATA', '2025-04-03 11:15:00'),
('Danilo Rossi', '2025-04-04', 'MATTINA', 'RIFIUTATA', '2025-04-03 11:20:00'),
('Alessia Rossi', '2025-04-04', 'MATTINA', 'RIFIUTATA', '2025-04-03 11:30:00'),
('Giorgio Rossi', '2025-04-04', 'MATTINA', 'RIFIUTATA', '2025-04-03 11:30:05'),
('Monica Rossi', '2025-04-04', 'MATTINA', 'RIFIUTATA', '2025-04-03 11:30:10'),
('Teresa Rossi', '2025-04-04', 'MATTINA', 'RIFIUTATA', '2025-04-03 11:30:12');

-- Prenotazioni pomeridiane del 2025-04-04
INSERT INTO prenotazione (nome, data, slot, stato, data_inserimento) VALUES
('Mario Rossi', '2025-04-04', 'POMERIGGIO', 'RIFIUTATA', '2025-04-03 11:00:00'),
('Francesco Rossi', '2025-04-04', 'POMERIGGIO', 'RIFIUTATA', '2025-04-03 11:05:00'),
('Aldo Rossi', '2025-04-04', 'POMERIGGIO', 'RIFIUTATA', '2025-04-03 11:10:00'),
('Maria Rossi', '2025-04-04', 'POMERIGGIO', 'RIFIUTATA', '2025-04-03 11:15:00'),
('Danilo Rossi', '2025-04-04', 'POMERIGGIO', 'RIFIUTATA', '2025-04-03 11:20:00'),
('Alessia Rossi', '2025-04-04', 'POMERIGGIO', 'RIFIUTATA', '2025-04-03 11:30:00'),
('Giorgio Rossi', '2025-04-04', 'POMERIGGIO', 'RIFIUTATA', '2025-04-03 11:30:05'),
('Monica Rossi', '2025-04-04', 'POMERIGGIO', 'RIFIUTATA', '2025-04-03 11:30:10'),
('Teresa Rossi', '2025-04-04', 'POMERIGGIO', 'RIFIUTATA', '2025-04-03 11:30:12');

-- Prenotazioni serali del 2025-04-04
INSERT INTO prenotazione (nome, data, slot, stato, data_inserimento) VALUES
('Mario Rossi', '2025-04-04', 'SERA', 'RIFIUTATA', '2025-04-03 11:00:00'),
('Francesco Rossi', '2025-04-04', 'SERA', 'RIFIUTATA', '2025-04-03 11:05:00'),
('Aldo Rossi', '2025-04-04', 'SERA', 'RIFIUTATA', '2025-04-03 11:10:00'),
('Maria Rossi', '2025-04-04', 'SERA', 'RIFIUTATA', '2025-04-03 11:15:00'),
('Danilo Rossi', '2025-04-04', 'SERA', 'RIFIUTATA', '2025-04-03 11:20:00'),
('Alessia Rossi', '2025-04-04', 'SERA', 'RIFIUTATA', '2025-04-03 11:30:00'),
('Giorgio Rossi', '2025-04-04', 'SERA', 'RIFIUTATA', '2025-04-03 11:30:05'),
('Monica Rossi', '2025-04-04', 'SERA', 'RIFIUTATA', '2025-04-03 11:30:10'),
('Teresa Rossi', '2025-04-04', 'SERA', 'RIFIUTATA', '2025-04-03 11:30:12');

-- Prenotazioni del 2025-04-05
INSERT INTO prenotazione (nome, data, slot, stato, data_inserimento) VALUES
('Mario Rossi', '2025-04-05', 'MATTINA', 'APPROVATA', '2025-04-03 11:00:00'),
('Francesco Rossi', '2025-04-05', 'MATTINA', 'APPROVATA', '2025-04-03 11:05:00'),
('Aldo Rossi', '2025-04-05', 'MATTINA', 'APPROVATA', '2025-04-03 11:10:00'),
('Maria Rossi', '2025-04-05', 'MATTINA', 'APPROVATA', '2025-04-03 11:15:00'),
('Danilo Rossi', '2025-04-05', 'MATTINA', 'APPROVATA', '2025-04-03 11:20:00'),
('Alessia Rossi', '2025-04-05', 'MATTINA', 'APPROVATA', '2025-04-03 11:30:00'),
('Giorgio Rossi', '2025-04-05', 'MATTINA', 'APPROVATA', '2025-04-03 11:30:05'),
('Monica Rossi', '2025-04-05', 'MATTINA', 'APPROVATA', '2025-04-03 11:30:10'),
('Teresa Rossi', '2025-04-05', 'MATTINA', 'APPROVATA', '2025-04-03 11:30:12');

-- Prenotazioni pomeridiane del 2025-04-05
INSERT INTO prenotazione (nome, data, slot, stato, data_inserimento) VALUES
('Mario Rossi', '2025-04-05', 'POMERIGGIO', 'APPROVATA', '2025-04-03 11:00:00'),
('Francesco Rossi', '2025-04-05', 'POMERIGGIO', 'APPROVATA', '2025-04-03 11:05:00'),
('Aldo Rossi', '2025-04-05', 'POMERIGGIO', 'APPROVATA', '2025-04-03 11:10:00'),
('Maria Rossi', '2025-04-05', 'POMERIGGIO', 'APPROVATA', '2025-04-03 11:15:00'),
('Danilo Rossi', '2025-04-05', 'POMERIGGIO', 'APPROVATA', '2025-04-03 11:20:00'),
('Alessia Rossi', '2025-04-05', 'POMERIGGIO', 'APPROVATA', '2025-04-03 11:30:00'),
('Giorgio Rossi', '2025-04-05', 'POMERIGGIO', 'APPROVATA', '2025-04-03 11:30:05'),
('Monica Rossi', '2025-04-05', 'POMERIGGIO', 'APPROVATA', '2025-04-03 11:30:10'),
('Teresa Rossi', '2025-04-05', 'POMERIGGIO', 'APPROVATA', '2025-04-03 11:30:12');

-- Prenotazioni serali del 2025-04-05
INSERT INTO prenotazione (nome, data, slot, stato, data_inserimento) VALUES
('Mario Rossi', '2025-04-05', 'SERA', 'APPROVATA', '2025-04-03 11:00:00'),
('Francesco Rossi', '2025-04-05', 'SERA', 'APPROVATA', '2025-04-03 11:05:00'),
('Aldo Rossi', '2025-04-05', 'SERA', 'APPROVATA', '2025-04-03 11:10:00'),
('Maria Rossi', '2025-04-05', 'SERA', 'APPROVATA', '2025-04-03 11:15:00'),
('Danilo Rossi', '2025-04-05', 'SERA', 'APPROVATA', '2025-04-03 11:20:00'),
('Alessia Rossi', '2025-04-05', 'SERA', 'APPROVATA', '2025-04-03 11:30:00'),
('Giorgio Rossi', '2025-04-05', 'SERA', 'APPROVATA', '2025-04-03 11:30:05'),
('Monica Rossi', '2025-04-05', 'SERA', 'APPROVATA', '2025-04-03 11:30:10'),
('Teresa Rossi', '2025-04-05', 'SERA', 'APPROVATA', '2025-04-03 11:30:12');

-- Prenotazioni del 2025-04-06
INSERT INTO prenotazione (nome, data, slot, stato, data_inserimento) VALUES
('Mario Rossi', '2025-04-06', 'MATTINA', 'IN_ATTESA', '2025-04-03 11:00:00'),
('Francesco Rossi', '2025-04-06', 'MATTINA', 'IN_ATTESA', '2025-04-03 11:05:00'),
('Aldo Rossi', '2025-04-06', 'MATTINA', 'IN_ATTESA', '2025-04-03 11:10:00'),
('Maria Rossi', '2025-04-06', 'MATTINA', 'IN_ATTESA', '2025-04-03 11:15:00'),
('Danilo Rossi', '2025-04-06', 'MATTINA', 'IN_ATTESA', '2025-04-03 11:20:00'),
('Alessia Rossi', '2025-04-06', 'MATTINA', 'IN_ATTESA', '2025-04-03 11:30:00'),
('Giorgio Rossi', '2025-04-06', 'MATTINA', 'IN_ATTESA', '2025-04-03 11:30:05'),
('Monica Rossi', '2025-04-06', 'MATTINA', 'IN_ATTESA', '2025-04-03 11:30:10'),
('Teresa Rossi', '2025-04-06', 'MATTINA', 'IN_ATTESA', '2025-04-03 11:30:12');

-- Prenotazioni pomeridiane del 2025-04-06
INSERT INTO prenotazione (nome, data, slot, stato, data_inserimento) VALUES
('Mario Rossi', '2025-04-06', 'POMERIGGIO', 'IN_ATTESA', '2025-04-03 11:00:00'),
('Francesco Rossi', '2025-04-06', 'POMERIGGIO', 'IN_ATTESA', '2025-04-03 11:05:00'),
('Aldo Rossi', '2025-04-06', 'POMERIGGIO', 'IN_ATTESA', '2025-04-03 11:10:00'),
('Maria Rossi', '2025-04-06', 'POMERIGGIO', 'IN_ATTESA', '2025-04-03 11:15:00'),
('Danilo Rossi', '2025-04-06', 'POMERIGGIO', 'IN_ATTESA', '2025-04-03 11:20:00'),
('Alessia Rossi', '2025-04-06', 'POMERIGGIO', 'IN_ATTESA', '2025-04-03 11:30:00'),
('Giorgio Rossi', '2025-04-06', 'POMERIGGIO', 'IN_ATTESA', '2025-04-03 11:30:05'),
('Monica Rossi', '2025-04-06', 'POMERIGGIO', 'IN_ATTESA', '2025-04-03 11:30:10'),
('Teresa Rossi', '2025-04-06', 'POMERIGGIO', 'IN_ATTESA', '2025-04-03 11:30:12');

-- Prenotazioni serali del 2025-04-06
INSERT INTO prenotazione (nome, data, slot, stato, data_inserimento) VALUES
('Mario Rossi', '2025-04-06', 'SERA', 'IN_ATTESA', '2025-04-03 11:00:00'),
('Francesco Rossi', '2025-04-06', 'SERA', 'IN_ATTESA', '2025-04-03 11:05:00'),
('Aldo Rossi', '2025-04-06', 'SERA', 'IN_ATTESA', '2025-04-03 11:10:00'),
('Maria Rossi', '2025-04-06', 'SERA', 'IN_ATTESA', '2025-04-03 11:15:00'),
('Danilo Rossi', '2025-04-06', 'SERA', 'IN_ATTESA', '2025-04-03 11:20:00'),
('Alessia Rossi', '2025-04-06', 'SERA', 'IN_ATTESA', '2025-04-03 11:30:00'),
('Giorgio Rossi', '2025-04-06', 'SERA', 'IN_ATTESA', '2025-04-03 11:30:05'),
('Monica Rossi', '2025-04-06', 'SERA', 'IN_ATTESA', '2025-04-03 11:30:10'),
('Teresa Rossi', '2025-04-06', 'SERA', 'IN_ATTESA', '2025-04-03 11:30:12');


