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