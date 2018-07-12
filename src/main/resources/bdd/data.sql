drop table if exists personne;

create table classe(
  id serial primary key,
  nom varchar(75) not null,
  idStagiaire double(10) not null
);