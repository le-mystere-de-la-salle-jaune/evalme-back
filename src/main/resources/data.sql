insert into stagiaire(nom, prenom, email, photo_url)
  values ('Clopin', 'Brigitte', 'bribri@hotmail.fr', 'https://www.valeursactuelles.com/sites/default/files/styles/image_article/public/2018-01/brigitte%20macron%20sipa.jpg?itok=0G8jRPfF');

insert into stagiaire(nom, prenom, email, photo_url)
  values ('Lupin', 'Patrick', 'lp@gmail.com', 'https://odgers-prod-neu-cdn-tm-endpoint.azureedge.net/media/1351/patrik-kvikant.jpg' );
  
insert into stagiaire(nom, prenom, email, photo_url)
  values ('Lupin', 'Patrick', 'lp@gmail.com', 'https://odgers-prod-neu-cdn-tm-endpoint.azureedge.net/media/1351/patrik-kvikant.jpg' );
  
insert into stagiaire(nom, prenom, email, photo_url)
  values ('Lupin', 'Patrick', 'lp@gmail.com', 'https://odgers-prod-neu-cdn-tm-endpoint.azureedge.net/media/1351/patrik-kvikant.jpg' );

insert into stagiaire(nom, prenom, email, photo_url) values ('Abitbol', 'Georges', 'mondedemerde@clas.se', 'abitbol.jpg');
insert into stagiaire(nom, prenom, email, photo_url) values ('Porc', 'Francis', 'dudeleesport@afes.fr', 'porc.jpg');
insert into stagiaire(nom, prenom, email, photo_url) values ('Mansoif', 'Gérard', 'gerard.mansoif@wanadoo.fr', 'mansoif.jpg');

insert into NOTE(note_sur_20, id_stagiaire) values (12, 3);
insert into NOTE(note_sur_20, id_stagiaire) values (15, 4);
 
insert into CLASSE(nom) values('D12');


INSERT INTO quizz(titre) values ('Les animaux de la forêt');
INSERT INTO quizz(titre) VALUES ('Géographie');
INSERT INTO quizz(titre) VALUES ('Mathématiques');
INSERT INTO question(titre) VALUES ('Qui est Clovis?');
INSERT INTO question(titre) VALUES ('Quel animage vole le plus vite?');
INSERT INTO compo_quizz(idQuizz, idQuestion) VALUES (1, 1);
INSERT INTO compo_quizz(idQuizz, idQuestion) VALUES (1, 2);
INSERT INTO compo_quizz(idQuizz, idQuestion) VALUES (2, 1);  
INSERT INTO compo_quizz(idQuizz, idQuestion) VALUES (2, 2);


insert into EXAMEN(titre,id_quizz,id_classe) values ('Quiz D12 animaux de la forêts', 1, 1) ;

insert into EXAMEN_COMPO(exam_id,note_id) values (1,1);
insert into EXAMEN_COMPO(exam_id,note_id) values (1,2);

INSERT INTO classe ( nom ) values ('D11');
INSERT INTO classe ( nom ) values ('D12');
INSERT INTO classe ( nom ) values ('D13');
INSERT INTO classe ( nom ) values ('D14');

INSERT INTO option_sondage(libelle, description) VALUES ('libelle sondage 1','description du sondage numéro 1');
INSERT INTO option_sondage(libelle, description) VALUES ('libelle sondage 2','description du sondage numéro 2');
INSERT INTO option_sondage(libelle, description) VALUES ('libelle sondage 3','description du sondage numéro 3');
INSERT INTO option_sondage(libelle, description) VALUES ('libelle sondage 4','description du sondage numéro 4');
INSERT INTO option_sondage(libelle, description) VALUES ('libelle sondage 5','description du sondage numéro 5');
INSERT INTO option_sondage(libelle, description) VALUES ('libelle sondage 6','description du sondage numéro 6');
INSERT INTO option_sondage(libelle, description) VALUES ('libelle sondage 7','description du sondage numéro 7');

INSERT INTO sondage(classe_id) VALUES (1);
INSERT INTO sondage(classe_id) VALUES (2);
INSERT INTO sondage(classe_id) VALUES (3);
INSERT INTO sondage(classe_id) VALUES (1);

INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (1,3);
INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (1,5);
INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (1,7);

INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (2,1);
INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (2,4);
INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (2,7);

INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (3,2);
INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (3,6);

INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (4,1);

INSERT INTO sondage_option_sondage ( id_sondage, id_option_sondage ) VALUES (4,7);

insert into duel(stagiairea_id, stagiaireb_id, quizz_id) values (1, 2, 1);
insert into duel(stagiairea_id, stagiaireb_id, quizz_id) values (1, 2, 2);
insert into duel(stagiairea_id, stagiaireb_id, quizz_id) values (1, 2, 3);
insert into duel(stagiairea_id, stagiaireb_id, quizz_id) values (1, 3, 1);
insert into duel(stagiairea_id, stagiaireb_id, quizz_id) values (1, 3, 2);
insert into duel(stagiairea_id, stagiaireb_id, quizz_id) values (1, 3, 3);
insert into duel(stagiairea_id, stagiaireb_id, quizz_id) values (2, 3, 1);
insert into duel(stagiairea_id, stagiaireb_id, quizz_id) values (2, 3, 2);
insert into duel(stagiairea_id, stagiaireb_id, quizz_id) values (2, 3, 3);
