-- ATIVIDADE 05.1
-- Listando total de livros cadastrados na biblioteca ;

SET SEARCH_PATH TO serratec_biblioteca;

SELECT COUNT(*) AS "Livros em Estoque" FROM livro;

-- ATIVIDADE 05.2
-- Calculando a média de tempo de emprestimo ;

SELECT ROUND(AVG(data_devolucao - data_emprestimo), 1) AS "Tempo"
FROM emprestimo
WHERE data_devolucao IS NOT NULL;

-- ATIVIDADE 05.3
-- Listando o livro mais antigo e o mais recente ;
-- Livro mais antigo ;

SELECT
	titulo AS "Titulo",
	autor AS "Autor",
	EXTRACT (YEAR FROM ano_publicacao) AS "Ano de Publicacao"
FROM livro
	WHERE ano_publicacao = (SELECT MIN(ano_publicacao) from livro);
	
--Livro mais recente; 

SELECT
	titulo AS "Titulo",
	autor AS "Autor",
	EXTRACT (YEAR FROM ano_publicacao) AS "Ano de Publicacao"
FROM livro
	WHERE ano_publicacao = (SELECT MAX(ano_publicacao) from livro);

-- ATIVIDADE 05.4
-- Listar o total de emprestimo de cada usuario agrupando por usuario ;

SELECT
	u.nome AS "Nome",
	COUNT(e.id_emprestimo) AS "Total de Emprestimos"
FROM usuario u
LEFT JOIN emprestimo e ON e.id_usuario = u.id_usuario
GROUP BY u.nome
ORDER BY "Total de Emprestimos" DESC;

-- ATIVIDADE 05.5
-- Listando a quantidade de livros por genero ;

SELECT
	genero AS "Genero",
	COUNT(l.titulo) AS "Quantidade em Estoque"
FROM livro l
GROUP BY l.genero
ORDER BY "Quantidade em Estoque" DESC;