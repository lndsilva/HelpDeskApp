CREATE DATABASE IF NOT EXISTS helpdesk_db;
USE helpdesk_db;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE chamados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    status VARCHAR(20) DEFAULT 'Aberto',
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Inserindo dados de teste (Senha em texto limpo para simplificar o escopo da aula)
INSERT INTO usuarios (email, senha) VALUES ('aluno@etec.sp.gov.br', '123456');
INSERT INTO usuarios (email, senha) VALUES ('professor@etec.sp.gov.br', '654321');

INSERT INTO chamados (usuario_id, titulo, descricao) VALUES (1, 'Internet caindo', 'O Wi-Fi da sala de aula desconecta a cada 5 minutos.');
INSERT INTO chamados (usuario_id, titulo, descricao) VALUES (1, 'Computador não liga', 'A máquina de bancada 04 não dá sinal de vida.');
INSERT INTO chamados (usuario_id, titulo, descricao) VALUES (2, 'Ar condicionado barulhento', 'O aparelho da sala 02 está fazendo muito barulho.');
