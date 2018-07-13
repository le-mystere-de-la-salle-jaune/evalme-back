drop table if exists EXAMEN_COMPO;
drop table if exists EXAMEN;
drop table if exists CLASSE;
drop table if exists NOTE;
drop table if exists stagiaire;
drop table if exists QUIZZ;


create table stagiaire (
  id serial primary key,
  nom varchar(75) not null,
  prenom varchar(75) not null,
  email varchar(75) not null,
  photo_url varchar(200) not null
);

create table CLASSE (
  id serial primary key,
  nom varchar(75) not null
);

create table QUIZZ(
	id serial primary key,
	titre varchar(75) not null
);

CREATE TABLE EXAMEN(
	id serial primary key,
	titre VARCHAR(75) not null,
	id_quizz BIGINT UNSIGNED not null,
	id_classe BIGINT UNSIGNED not null,
	FOREIGN KEY (id_quizz) REFERENCES QUIZZ(id),
	FOREIGN KEY (id_classe) REFERENCES CLASSE(id)
);

create Table Concours(
	id serial primary key,
	titre varchar(75) not null
);

create Table Concours_stagiaire(
	id serial primary key,
	id_concours BIGINT UNSIGNED not null,
	id_stagiaire BIGINT UNSIGNED not null,
	FOREIGN KEY (id_concours) REFERENCES Concours(id),
	FOREIGN KEY (id_stagiaire) REFERENCES stagiaire(id)
);

create Table Concours_quizz(
	id serial primary key,
	id_concours BIGINT UNSIGNED not null,
	id_quizz BIGINT UNSIGNED not null,
	FOREIGN KEY (id_concours) REFERENCES Concours(id),
	FOREIGN KEY (id_quizz) REFERENCES QUIZZ(id)
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
