DROP TABLE IF EXISTS compo_quizz;
drop table if exists EXAMEN_COMPO;
drop table if exists EXAMEN;
drop table if exists sondage_option_sondage;
drop table if exists Sondage;
drop table if exists classe;
drop table if exists NOTE;
drop table if exists duel;
drop table if exists stagiaire;
DROP TABLE IF EXISTS quizz;
DROP TABLE IF EXISTS question;

drop table if exists option_sondage;




create table stagiaire (
  id serial primary key,
  nom varchar(75) not null,
  prenom varchar(75) not null,
  email varchar(75) not null,
  photo_url varchar(200) not null
);

CREATE TABLE classe (
  id serial primary key,
  nom varchar(20) NOT NULL
);

create table quizz(
	id serial primary key,
	titre varchar(255) not null
);


CREATE TABLE question (
	id SERIAL PRIMARY KEY,
	titre VARCHAR(75) not null
);

CREATE TABLE compo_quizz (
	id SERIAL PRIMARY KEY,
	idQuizz BIGINT UNSIGNED,
	idQuestion BIGINT UNSIGNED,
	FOREIGN KEY (idQuizz) REFERENCES quizz(id),
	FOREIGN KEY (idQuestion) REFERENCES question(id)
);

CREATE TABLE EXAMEN(
	id serial primary key,
	titre VARCHAR(75) not null,
	id_quizz BIGINT UNSIGNED not null,
	id_classe BIGINT UNSIGNED not null,
	FOREIGN KEY (id_quizz) REFERENCES quizz(id),
	FOREIGN KEY (id_classe) REFERENCES CLASSE(id)
);


create table NOTE (
  id serial primary key,
  note_sur_20 DECIMAL(4,2) not null,
  id_stagiaire BIGINT UNSIGNED not null,
  FOREIGN KEY (id_stagiaire) REFERENCES stagiaire(id)
);

create table EXAMEN_COMPO (
  id serial primary key,
  exam_id BIGINT UNSIGNED not null,
  note_id BIGINT UNSIGNED not null,
  FOREIGN KEY (exam_id) REFERENCES EXAMEN(id),
  FOREIGN KEY (note_id) REFERENCES NOTE(id)
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

create table duel (
	id serial primary key,
	stagiairea_id bigint unsigned not null,
	stagiaireb_id bigint unsigned not null,
	quizz_id bigint unsigned not null,
	foreign key (stagiairea_id) references stagiaire(id),
	foreign key (stagiaireb_id) references stagiaire(id),
	foreign key (quizz_id) references quizz(id)
);
