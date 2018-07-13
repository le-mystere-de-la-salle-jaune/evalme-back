
SET FOREIGN_KEY_CHECKS=0;

drop table if exists classe;
drop table if exists stagiaire;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE classe (
  id serial primary key,
  nom varchar(20) NOT NULL
);

create table stagiaire (
  
	id serial primary key,
  
	nom varchar(75) not null,
  
	prenom varchar(75) not null,
  
	email varchar(75) not null,
  
	photo_url varchar(200) not null
,  
	id_classe BIGINT UNSIGNED,
  
	FOREIGN KEY (id_classe) REFERENCES classe(id)

);


