CREATE DATABASE voting;
USE voting;

CREATE TABLE questions (id INT AUTO_INCREMENT, questions_name VARCHAR(255), status INT, PRIMARY KEY (id));
CREATE TABLE variants (id INT AUTO_INCREMENT, people_like INT, variants_name VARCHAR(255),
  question_id INT, PRIMARY KEY (id), FOREIGN KEY (question_id) REFERENCES questions(id));