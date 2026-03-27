-- Configurando o schema criado no scrip "CREATE" como o padrão para novos dados ;

SET SEARCH_PATH TO serratec_biblioteca;

-- Realizando a consulta de todos os livros cadastrados ;

SELECT * FROM livro;

select * from emprestimo;
-- Listando o nome do usuario e o titulo do livro que pegou emprestado ;
insert into emprestimo (id_usuario, id_livro, data_emprestimo, status)
	values (1, 1, '01/01/2025', 'emprestado');
SELECT
	u.nome AS "Nome",
	l.titulo AS "Titulo"
FROM usuario u
JOIN  emprestimo e ON e.id_usuario = u.id_usuario
JOIN livro l ON e.id_livro = l.id_livro;

-- Selecionando todos os emprestimos que ainda não foram devolvidos ;

SELECT
	u.nome AS "Nome",
	l.titulo AS "Titulo",
	e.status AS "Status"
FROM emprestimo e
JOIN usuario u ON e.id_usuario = u.id_usuario
JOIN livro l ON e.id_livro = l.id_livro
WHERE status = 'emprestado';

-- Listando todos os autores e os livros que escreveram ;

SELECT
	l.autor AS "Autor",
	l.titulo AS "Titulo"
FROM livro l;

-- Listando o historico de emprestimo dos usuarios

SELECT
    u.nome AS "Nome",
    COALESCE (l.titulo, 'Nenhum emprestimo realizado') AS "Titulo"
FROM usuario u
LEFT JOIN emprestimo e ON e.id_usuario = u.id_usuario
LEFT JOIN livro l ON e.id_livro = l.id_livro;

-- Listando total de livros cadastrados na biblioteca ;

SELECT COUNT(*) AS "Livros em Estoque" FROM livro;

-- Calculando a média de tempo de emprestimo ;

SELECT ROUND(AVG(data_devolucao - data_emprestimo), 1) AS "Tempo"
FROM emprestimo
WHERE data_devolucao IS NOT NULL

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

-- Listar o total de emprestimo de cada usuario agrupando por usuario ;

SELECT
	u.nome AS "Nome",
	COUNT(e.id_emprestimo) AS "Total de Emprestimos"
FROM usuario u
JOIN emprestimo e ON e.id_usuario = u.id_usuario
GROUP BY u.nome;

-- Listando a quantidade de livros por genero ;

SELECT
	genero AS "Genero",
	COUNT(l.titulo)
FROM livro l
GROUP BY l.genero
ORDER BY l.genero

-- Criando indice ;

CREATE INDEX idx_titulo_livro ON livro(titulo);
CREATE INDEX idx_data_emprestimo ON emprestimo(data_emprestimo);

-- Criando uma view para historico dos emprestimos;
CREATE VIEW vw_historico_emprestimos AS
SELECT
	u.nome AS "Nome",
	l.titulo AS "Titulo",
	TO_CHAR(e.data_emprestimo, 'DD/MM/YYYY') AS "Data do Emprestimo",
	TO_CHAR(e.data_devolucao, 'DD/MM/YYYY') AS "Data da Devolucao"
FROM usuario u
LEFT JOIN emprestimo e ON u.id_usuario = e.id_usuario
LEFT JOIN livro l ON e.id_livro = l.id_livro
ORDER BY e.data_emprestimo DESC;

-- Resposta a pergunta 4 na licao 6:
-- Um indice em um banco de dados com muitas informacoes melhora a performance, pois, o programa ira
-- procurar o dado na tabela dentro do proprio indice e vai direto para a linha dele na tabela de origem,
-- poupando tempo na consulta. Em contrapartida, a performance é reduzida nos comando de UPDATE, DELETE,
-- INSERT, porque o INSERT tera que atualizar os dados dentro do incide ;

-- Teste de performance ;

EXPLAIN  ANALYZE
SELECT * FROM livro
WHERE titulo = 'As Correntes do Destino'