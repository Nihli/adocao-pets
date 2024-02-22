CREATE TABLE abrigo(
    id INT AUTO_INCREMENT NOT NULL UNIQUE,
    nome VARCHAR(200) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email  VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE pet(
    id INT AUTO_INCREMENT NOT NULL UNIQUE,
    especie VARCHAR(40) NOT NULL,
    raca VARCHAR(100) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    personalidade VARCHAR(255) NOT NULL,
    idade TINYINT NOT NULL,
    peso  FLOAT NOT NULL,
    id_abrigo INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_abrigo) REFERENCES abrigo(id)
);