-- Povoamento sisat.Pessoa

DELETE FROM consultanutricional;
DELETE FROM papel_pessoa;
DELETE FROM paciente;
DELETE FROM papel;
DELETE FROM pessoa;
DELETE FROM servidor;


-- inserir pessoas
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (1,'04657895612','administr@dor.com',TRUE,'admin','administrador','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'M', '1992-12-01', '(88) 9999-9999'); --senha: admin
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (2,'02154789632','nutricao@ufc.br', TRUE, 'nutricao', 'nutricao','da0e5f5143c3444c5683d515cefbb1f773888ed1d5bf1ca720c515129d56820a', 'M', '1969-07-09', '(84) 3286-9475'); --senha: nutricao
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (3,'14569823654','atendente@ufc.br',TRUE, 'atendente', 'atendente','7ea0aa86f787883153cd4280868e337224f6c2b7b4e6afb7ca766b477e7a7a14', 'M', '1978-9-6', '(85) 9548-5136'); --senha: atendente
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (4,'54789625698','aluno@ufc.br',TRUE, 'aluno', 'aluno','a21d6f3803f0491c32444ef91a0836be243cc4da5186357e805b7009a5b0669b', 'M', '1990-06-18', '(88) 8897-9547'); --senha: aluno
 --senha: test
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (5,'13475437715','newtoncarneiro@bol.com',TRUE,'marcelo','Marcelo Newton Carneiro','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'M', '1989-5-5', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (6,'64880952701','rogerioldossantos@hotmail.com',TRUE,'rogerio','Rogério Luiz dos Santos','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'M', '1985-4-26', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (7,'22536189450','fabioeloi@gmail.com',TRUE,'fabio','Fabio Fernando Eloi Pinto','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'M', '1995-8-4', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (8,'39223842676','talitafma@hotmail.com',TRUE, 'talita','Talita Ferreira Marques Aguiar','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'F', '1989-12-12', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (9,'11886210179','narapacheco@yahoo.com.br',TRUE,'nara','Nara Pacheco Pereira','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'F', '1994-9-27', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (10,'32613628950', 'eloisa.oliveira@gmail.com',TRUE, 'eloisa','Eloisa Helena Ribeiro Olivieria','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'F', '1996-02-21', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (11,'99427343081','thalespb@bol.com',TRUE, 'thales','Thales Paulo Batista','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'M', '1974-03-28', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (12,'20363070351','marceloramos@yahoo.com.br',TRUE,'marcelo','Marcelo Ramos Tejo Salgado','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'M', '1990-08-15', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (13,'03916037043','leolordello@gmail.com',TRUE, 'leonardo','Leonardo Lordello de Melo','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'M', '1989-11-16', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (14,'79373259119','flavianycfaria@yahoo.com.br',TRUE,'flaviany','Flaviany Custódio Faria','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'F', '1988-1-21', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (15,'054869751234', 'felipesilva@gmail.com', TRUE, 'felipesm','Felipe da Silva Marinho', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'M', '1986-6-24', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (16,'48181972122','gabi_silva@bol.com',TRUE,'gabriela','Gabriela Madureira da Silva','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'F', '1950-7-26', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (17,'99737368157','helano_carioca@gmail.com',TRUE,'helano','Helano Carioca Freitas','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'M', '1992-10-6', '(88) 9876-5432');
INSERT INTO pessoa (id, cpf, email, habilitado, login, nome, password, sexo, dataNascimento, telefone) VALUES (18,'37717176733','hernadessouzasilva@hotmail.com',TRUE,'hernandes','Hernandes Cerqueira de Souza Silva','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'M', '1991-01-01', '(88) 9876-5432');


--inserir papeis

INSERT INTO papel(id, nome) VALUES (1, 'ROLE_ADMINISTRADOR');
INSERT INTO papel(id, nome) VALUES (2, 'ROLE_NUTRICAO');
--INSERT INTO papel(id, nome) VALUES (3, 'ROLE_ATENDENTE');
INSERT INTO papel(id, nome) VALUES (4, 'ROLE_ALUNO');


--atribuir pessoas aos papeis
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (1, 1);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (2, 2);
--INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (3, 3);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (4, 4);

INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (5, 2);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (6, 2);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (7, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (8, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (9, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (10, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (11, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (12, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (13, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (14, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (15, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (16, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (17, 4);
INSERT INTO papel_pessoa(pessoa_id, papel_id) VALUES (18, 4);
