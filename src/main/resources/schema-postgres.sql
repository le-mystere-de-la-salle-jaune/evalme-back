drop table if exists stagiaire;
drop table if exists classe;

create table classe (
  id serial primary key,
  nom varchar(75) not null
);

create table stagiaire (
  id serial primary key,
  nom varchar(75) not null,
  prenom varchar(75) not null,
  email varchar(75) not null,
  photo_url varchar(200) not null,
  id_classe bigint unsigned,
  foreign key (id_classe) references classe(id)
);

