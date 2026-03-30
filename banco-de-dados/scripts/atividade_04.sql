-- ATIVIDADE 04.1 ;

-- Configurando o schema criado no scrip "CREATE" como o padrão para novos dados ;

SET SEARCH_PATH TO serratec_biblioteca;

-- Realizando a consulta de todos os livros cadastrados ;

SELECT * FROM livro;

-- ATIVIDADE 04.2 ;

-- Vinculando um usuario a um emprestimo ;

INSERT INTO emprestimo (id_usuario, id_livro, data_emprestimo, status);
	VALUES (1, 1, '01/01/2025', 'emprestado');

-- Listar o nome do usuario e o titulo de livro de todos os emprestimos realizados ;

SELECT
	u.nome AS "Nome",
	l.titulo AS "Titulo"
FROM usuario u
JOIN  emprestimo e ON e.id_usuario = u.id_usuario
JOIN livro l ON e.id_livro = l.id_livro;

-- ATIVIDADE 04.3 ;
-- Selecionando todos os emprestimos que ainda não foram devolvidos ;

SELECT
	u.nome AS "Nome",
	l.titulo AS "Titulo",
	e.status AS "Status"
FROM emprestimo e
JOIN usuario u ON e.id_usuario = u.id_usuario
JOIN livro l ON e.id_livro = l.id_livro
WHERE status = 'emprestado';

-- ATIVIDADE 04.4
-- Listando todos os autores e os livros que escreveram ;

SELECT
	l.autor AS "Autor",
	l.titulo AS "Titulo"
FROM livro l;

-- ATIVIDADE 04.5 ;
-- Listando o historico de emprestimo dos usuarios

SELECT
    u.nome AS "Nome",
    COALESCE (l.titulo, 'Nenhum emprestimo realizado') AS "Titulo"
FROM usuario u
LEFT JOIN emprestimo e ON e.id_usuario = u.id_usuario
LEFT JOIN livro l ON e.id_livro = l.id_livro;
