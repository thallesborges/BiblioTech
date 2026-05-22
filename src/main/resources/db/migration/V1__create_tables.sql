CREATE TABLE enderecos (
    id SERIAL PRIMARY KEY,
    logradouro VARCHAR(200) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    cep CHAR(8) NOT NULL
);

CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(11) NOT NULL,
    endereco_id INTEGER NOT NULL,
    senha VARCHAR(255) NOT NULL,
    status VARCHAR(15) NOT NULL DEFAULT 'ATIVO',
    data_cadastro TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,

    CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES enderecos(id)
);

CREATE TABLE usuario_perfis (
    usuario_id INTEGER NOT NULL,
    perfil VARCHAR(15) NOT NULL,

    PRIMARY KEY (usuario_id, perfil),
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
)

CREATE TABLE livros (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    isbn CHAR(13) NOT NULL UNIQUE,
    editora VARCHAR(50) NOT NULL,
    ano_publicacao SMALLINT NOT NULL,
    genero VARCHAR(100) NOT NULL,
    total_exemplares INTEGER NOT NULL,
    exemplares_disponiveis INTEGER NOT NULL,
    ativo BOOLEAN NOT NULL,
    data_cadastro TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL
);

CREATE TABLE locacoes (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL,
    livro_id INTEGER NOT NULL,
    data_locacao DATE NOT NULL,
    data_prevista_devolucao DATE NOT NULL,
    data_devolucao_efetiva DATE,
    renovado BOOLEAN,
    status VARCHAR(20) NOT NULL,
    multa_valor NUMERIC(10, 2) DEFAULT NULL,
    data_pagamento_multa TIMESTAMP DEFAULT NULL,

    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_livro FOREIGN KEY (livro_id) REFERENCES livros(id)
);

CREATE TABLE autores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(100) NOT NULL
);

CREATE TABLE livros_autores (
    livro_id INTEGER NOT NULL,
    autor_id INTEGER NOT NULL,

    PRIMARY KEY (livro_id, autor_id),

    CONSTRAINT fk_livro FOREIGN KEY (livro_id) REFERENCES livros(id),
    CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES autores(id)
);

CREATE TABLE reservas (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL,
    livro_id INTEGER NOT NULL,
    data_reserva DATE NOT NULL,
    data_expiracao DATE NOT NULL,
    status VARCHAR(20) NOT NULL,

    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_livro FOREIGN KEY (livro_id) REFERENCES livros(id)
);
