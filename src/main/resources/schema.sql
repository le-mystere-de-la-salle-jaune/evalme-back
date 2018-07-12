DROP TABLE IF EXISTS quizz;

CREATE TABLE quizz (
  id SERIAL PRIMARY KEY,
  titre VARCHAR(75) not null
);

CREATE TABLE compo_quizz (
	idQuizz BIGINT UNSIGNED,
	idQuestion BIGINT UNSIGNED
	FOREIGN KEY (idQuizz) REFERENCES Quizz(id)
	FOREIGN KEY (idQuestion) REFERENCES Question(id)
);