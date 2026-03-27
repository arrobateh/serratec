-- Criando um novo schema ;

CREATE SCHEMA IF NOT EXISTS serratec_biblioteca
	AUTHORIZATION postgres;
	

-- Definindo o novo esquema como padrão para novos dados ;

SET SEARCH_PATH TO serratec_biblioteca;

-- Criando as tabelas ;

CREATE TABLE livro (
    id_livro SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(200) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    quantidade_estoque INT NOT NULL
);

CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(200) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    endereco VARCHAR(400) NOT NULL
);

CREATE TYPE status AS ENUM ('emprestado', 'devolvido');

CREATE TABLE emprestimo (
    id_emprestimo SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL, -- chave estrangeira para a tabela usuario
    id_livro INT NOT NULL, -- chave estrangeira para a tabela livro
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    status status NOT NULL, -- 'emprestado' ou 'devolvido',

    CONSTRAINT fk_usuario_emprestimo -- definindo a chave estrangeira para a tabela usuario
        FOREIGN KEY (id_usuario)
			REFERENCES usuario (id_usuario),

    CONSTRAINT fk_livro_emprestimo -- definindo a chave estrangeira para a tabela livro
        FOREIGN KEY (id_livro)
			REFERENCES livro (id_livro)
);
        
ALTER TABLE livro -- adicionando a coluna editora à tabela livro
    ADD COLUMN editora VARCHAR(100) NOT NULL;