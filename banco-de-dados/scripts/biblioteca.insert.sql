-- Configurando o schema criado no scrip "CREATE" como o padrão para novos dados ;

SET SEARCH_PATH TO serratec_biblioteca;

-- Inserindo dados da tabela 'livro' ;

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('As Correntes do Destino', 'Helio', 'Biografia', 12, 'Forjas de Efesto');

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('O Fantasma de Esparta: Ascensao e Queda', 'Oraculo de Delfoso', 'Epico', 5, 'Pergaminhos de Atena');

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('Manual de Sobrevivencia no Tartaro', 'Atreus', 'Guia', 9, 'Abismo de Hades');

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('A Traicao do Olimpo', 'Gaia', 'Suspense', 19, 'Raizes');

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('O Lobo e o Garoto: Licoes de Caca', 'Kratos', 'Sobrevivencia', 15, 'Bosque Selvagem');

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('Ragnarok: O Crepusculo Inevitavel', 'Mimir', 'Profecia', 100, 'Olho de Odin');

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('A Cancao de Faye', 'Atreus', 'Poesia', 3, 'Jotunheim Edicoes');

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('Ouro e Sangue: A Historia dos Huldra', 'Sindri e Brok', 'Engenharia', 20, 'Sindicato dos Anoes');

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('Pelos Olhos das Valquirias', 'Sigrun', 'Estrategia', 2, 'Valhalla');

INSERT INTO livro(titulo, autor, genero,quantidade_estoque, editora)
	VALUES ('O Estrangeiro de Helheim', 'Baldur', 'Drama', 7, 'Niflheim');

-- Inserindo 5 registros na tabela usuario ;

INSERT INTO usuario(nome, cpf, email, telefone, endereco)
	VALUES ('Kratos', '00000000100', 'kr@sparta.br', '11900000001', 'Bosque Selvagem');

INSERT INTO usuario(nome, cpf, email, telefone, endereco)
	VALUES ('Atreus', '00000000200', 'lo@loki.as', '11900000002', 'Cabana de Faye');

INSERT INTO usuario(nome, cpf, email, telefone, endereco)
	VALUES ('Mimir', '00000000300', 'mi@wisdow.eye', '11900000003', 'Pico de Midgard');

INSERT INTO usuario(nome, cpf, email, telefone, endereco)
	VALUES ('Freya', '00000000400', 'fr@vanir.mg', '11900000004', 'Bosque da Bruxa');

INSERT INTO usuario(nome, cpf, email, telefone, endereco)
	VALUES ('Thor', '00000000500', 'th@mjonir.as', '11900000005', 'Salões Bilskirnir');

-- Vinculando o emprestimo de um livro a um usuario ;

INSERT INTO emprestimo(id_usuario, id_livro, data_emprestimo, status)
	VALUES(3, 7, '04/14/1543', 'emprestado');

-- Deletando o usuario que possui um emprestimo ;
DELETE FROM usuario
	WHERE id_usuario = 3; -- Nao sera possivel deletar o usuario, pois, viola as regras de chave estrangeira ;
	
-- Repondendo a questão 5 da atividade 03 ;
-- Explicar a diferenca entre DELETE FROM e TRUNCATE TABLE:
-- DELETE FROM exclui todas as linhas e mantém a tabela ainda válida;
-- TRUNCATE TABLE apaga todos os dados de uma tabela e "reseta" os id's, além de ser executado de forma mais rápida;
-- Fonte: 	https://www.postgresql.org/docs/18/sql-delete.html
--			https://www.postgresql.org/docs/18/sql-truncate.html
