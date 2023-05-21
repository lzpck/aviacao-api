CREATE TABLE Passageiros (
                             CPF VARCHAR(11) PRIMARY KEY,
                             Nome VARCHAR(255),
                             Data_de_Nasc DATE,
                             Classificacao VARCHAR(255),
                             Milhas INT
);

INSERT INTO Passageiros VALUES ('11111111111', 'James Tiberius Kirk', '1933-10-01', 'VIP', 100);
INSERT INTO Passageiros VALUES ('22222222222', 'Spock', '1930-09-05', 'OURO', 100);
INSERT INTO Passageiros VALUES ('33333333333', 'Leonard McCoy', '1927-04-02', 'PRATA', 100);
INSERT INTO Passageiros VALUES ('44444444444', 'Montgomery Scott', '1922-08-08', 'OURO', 100);
INSERT INTO Passageiros VALUES ('55555555555', 'Nyota Uhura', '1934-11-20', 'OURO', 100);
INSERT INTO Passageiros VALUES ('66666666666', 'Hikaru Kato Sulu', '1931-10-21', 'BRONZE', 100);
INSERT INTO Passageiros VALUES ('77777777777', 'Jean-Luc Picard', '1960-07-20', 'VIP', 100);
INSERT INTO Passageiros VALUES ('88888888888', 'Wesley Crusher', '2010-10-01', 'ASSOCIADO', 100);