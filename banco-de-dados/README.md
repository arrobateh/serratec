# Banco de Dados | SERRATEC

Este diretório contém todo material produzido durante às aulas da disciplina *'Banco de Dados'*.

Os exercícios da aula 1 respondi abaixo em texto e a modelagem de atividade desta aula se encontra [aqui](https://github.com/arrobateh/serratec/tree/main/banco-de-dados/docs) no formato .pdf .
## Aula 1 (Introdução e Modelagem)
- 10 entidades para um sistema financeiro (pensei em um sistema financeiro de uma igreja): Membro, Receita, Despesa, Categoria, Centro de Custo, Dizimo, Tipo Receita, Tipo Despesa, Usuario, Log_Auditoria;
- 3 entidades com 5 atributos para um sistema de biblioteca: Membro(id_membro, nome, endereco, telefone, email), Livro(id_livro, nome, autor, categoria, editora), Emprestimo(id_emprestimo, data, fk_membro, fk,livro, fk_usuario);
- Identificar problemas de normalização seguinte tabela: Cliente(id, nome, telefone, email, endereço, produto_comprado, valor_compra):
	- Na entidade Cliente, o atributo "telefone" deve ser uma FK(Foreign Key), visto que o cliente pode possuir mais de um numero;
	    - Solução: Criar uma nova entidade para os telefones;
	- Na entidade Cliente, o atributo "endereco" deve ser uma FK(Foreign Key), visto que o cliente pode possuir mais de um endereco;
	    - Solução: Criar uma nova entidade para os endereços;
	- Na entidade Cliente, não há a necessidade de possuir o atributo "produto_comprado" e "valor_compra";
	    - Solução 1: Criar uma nova entidade para os pedidos realizados;
	    - Solução 2: Criar uma nova entidade para os produtos;
	    - Solução 3: Criar uma nova entidade para os itens do pedido, visto que um pedido pode conter muitos produtos;
    