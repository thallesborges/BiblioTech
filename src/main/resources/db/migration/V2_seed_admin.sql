-- Dados gerados por Script Aleatório do 4devs
INSERT INTO enderecos (logradouro, numero, bairro, cidade, cep)
VALUES ('Rua Antônio Augusto Cardoso',
        742,
        'Presidente Roosevelt',
        'Uberlândia',
        '38401122'
       );

INSERT INTO usuarios (nome, cpf, data_nascimento, email, telefone, endereco_id, senha, data_cadastro, data_atualizacao)
VALUES ('Thalles Borges',
        '23499764679',
        to_date('05/05/2002', 'DD/MM/YYYY'),
        'thalles_borges@bibliotech.com',
        '34987649511',
        1,
        '$2a$12$Mxo9pmO7OHSKBpi8w0QjSuIuRpa5Tc.ssN4IlTauMW43r4Ck3l2la',
        NOW(),
        NOW()
       );

INSERT INTO usuario_perfis(usuario_id, perfil)
VALUES (1, 'ADMIN');

