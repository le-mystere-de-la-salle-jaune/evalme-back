drop table if exists sondage_option_sondage;
drop table if exists Sondage;
drop table if exists option_sondage;
drop table if exists classe;

CREATE TABLE classe (
  id serial primary key,
  nom varchar(20) NOT NULL
);

CREATE TABLE option_sondage (
  id serial primary key,
  libelle varchar(75) NOT NULL,
  description varchar(150) NOT NULL
);

CREATE TABLE sondage (
  id serial primary key,
  classe_id bigint(20) UNSIGNED DEFAULT NULL,
  FOREIGN KEY (classe_id) REFERENCES classe (id)
);

CREATE TABLE sondage_option_sondage (
  id_sondage bigint(20) UNSIGNED DEFAULT NULL,
  id_option_sondage bigint(20) UNSIGNED DEFAULT NULL,
  FOREIGN KEY (id_option_sondage) REFERENCES option_sondage (id),
  FOREIGN KEY (id_sondage) REFERENCES sondage (id)
);
