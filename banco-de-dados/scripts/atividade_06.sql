-- ATIVIDADE 06.1

SET SEARCH_PATH TO serratec_biblioteca;

-- Criar indice na tabela livro ;

CREATE INDEX idx_titulo_livro ON livro(titulo);

-- ATIVIDADE 06.2
-- Criar um indice na tabela emprestimo ;

CREATE INDEX idx_data_emprestimo ON emprestimo(data_emprestimo);

-- ATIVIDADE 06.3 ;
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

-- ATIVIDADE 06.4
-- Resposta:
-- Um indice em um banco de dados com muitas informacoes melhora a performance, pois, o programa ira
-- procurar o dado na tabela dentro do proprio indice e vai direto para a linha dele na tabela de origem,
-- poupando tempo na consulta. Em contrapartida, a performance é reduzida nos comando de UPDATE, DELETE,
-- INSERT, porque o INSERT tera que atualizar os dados dentro do incide ;

-- ATIVIDADE 06.5
-- Teste de performance ;

EXPLAIN ANALYZE
SELECT * FROM livro
WHERE titulo = 'As Correntes do Destino';