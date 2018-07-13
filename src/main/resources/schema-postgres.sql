drop table if exists sondage_option_sondage;
drop table if exists question_compo;
drop table if exists Sondage;
drop table if exists option_sondage;
drop table if exists NOTE;
drop table if exists EXAMEN;
DROP TABLE IF EXISTS compo_quizz;
drop table if exists QUIZZ;
drop table if exists QUESTION_COMPO
drop table if exists OPTION_QUESTION;
drop table if exists QUESTION;
drop table if exists stagiaire;
drop table if exists classe;


CREATE TABLE classe (
  id serial primary key,
  nom varchar(75) NOT NULL
);

create table stagiaire (
  id serial primary key,
  nom varchar(75) not null,
  prenom varchar(75) not null,
  email varchar(75) not null,
  photo_url varchar(200) not null,
  id_classe BIGINT not null,
  FOREIGN KEY (id_classe) REFERENCES classe(id)
);

create table QUESTION (
  id serial primary key,
  titre VARCHAR(75)
);

create table OPTION_QUESTION (
  id serial primary key,
  libelle VARCHAR(75) not null,
  ok BIT(1) not null
);

create table QUESTION_COMPO (
  id serial primary key,
  id_opt BIGINT not null,
  id_que BIGINT not null,
  FOREIGN KEY (id_opt) REFERENCES OPTION_QUESTION(id),
  FOREIGN KEY (id_que) REFERENCES QUESTION(id)
);

create table QUIZZ(
	id serial primary key,
	titre varchar(75) not null
);

CREATE TABLE compo_quizz (
	id SERIAL PRIMARY KEY,
	idQuizz BIGINT,
	idQuestion BIGINT,
	FOREIGN KEY (idQuizz) REFERENCES QUIZZ(id),
	FOREIGN KEY (idQuestion) REFERENCES QUESTION(id)
);

CREATE TABLE EXAMEN(
	id serial primary key,
	titre VARCHAR(75) not null,
	id_quizz BIGINT not null,
	id_classe BIGINT not null,
	FOREIGN KEY (id_quizz) REFERENCES QUIZZ(id),
	FOREIGN KEY (id_classe) REFERENCES classe(id)
);


create table NOTE (
  id serial primary key,
  note_sur_20 DECIMAL(4,2) not null,
  id_stagiaire BIGINT not null,
  id_examen BIGINT not null,
  FOREIGN KEY (id_stagiaire) REFERENCES stagiaire(id),
  FOREIGN KEY (id_examen) REFERENCES EXAMEN(id)
);

CREATE TABLE option_sondage (
  id serial primary key,
  libelle varchar(75) NOT NULL,
  description varchar(150) NOT NULL
);

CREATE TABLE sondage (
  id serial primary key,
  classe_id bigint DEFAULT NULL,
  FOREIGN KEY (classe_id) REFERENCES classe (id)
);

CREATE TABLE sondage_option_sondage (
  id_sondage bigint DEFAULT NULL,
  id_option_sondage bigint DEFAULT NULL,
  FOREIGN KEY (id_option_sondage) REFERENCES option_sondage (id),
  FOREIGN KEY (id_sondage) REFERENCES sondage (id)
);
