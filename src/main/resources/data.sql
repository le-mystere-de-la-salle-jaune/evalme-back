insert into stagiaire(nom, prenom, email, photo_url)
  values ('Clopin', 'Claudine', 'bribri@hotmail.fr', 'https://www.valeursactuelles.com/sites/default/files/styles/image_article/public/2018-01/brigitte%20macron%20sipa.jpg?itok=0G8jRPfF');

insert into stagiaire(nom, prenom, email, photo_url)
  values ('Lupin', 'Patrick', 'lp@gmail.com', 'https://odgers-prod-neu-cdn-tm-endpoint.azureedge.net/media/1351/patrik-kvikant.jpg' );
  
 insert into NOTE(note_sur_20, id_stagiaire) values (12, 1);
 insert into NOTE(note_sur_20, id_stagiaire) values (15, 2);
 
 insert into CLASSE(nom) values('D12');
 
 insert into QUIZZ(titre) values ('Les animeaux de la forêt');

insert into EXAMEN(titre,id_quizz,id_classe) values ('Quiz D12 animeaux de la forêts', 1, 1) ;

insert into EXAMEN_COMPO(exam_id,note_id) values (1,1);
insert into EXAMEN_COMPO(exam_id,note_id) values (1,2);