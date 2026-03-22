# <img src="https://www.svgrepo.com/show/286859/database.svg" alt="data base" width="45"> Banco de Dados | SERRATEC

Este diretório contém todo material produzido durante às aulas da disciplina *'Banco de Dados'*.

Os exercícios da aula 1 respondi abaixo em texto e a modelagem de atividade desta aula se encontra [aqui](./docs/modelagem-drawio) no formato .pdf .


## <img src="https://www.svgrepo.com/show/263515/book.svg" alt="Icon book" width="30"> Aula 1 (Introdução e Modelagem)
### 1. Entidades para um sistema financeiro (pensei em um sistema financeiro de uma igreja):
`Membro`, `Receita`, `Despesa`, `Categoria`, `Centro de Custo`, `Dizimo`, `Tipo Receita`, `Tipo Despesa`, `Usuario`, `Log_Auditoria`;
### 2. Entidades de biblioteca com atributos
- Membro:`id_membro`, `nome`, `endereco`, `telefone`, `email`
- Livro: `id_livro`, `nome`, `autor`, `categoria`, `editora`
- Emprestimo: `id_emprestimo`, `data`, `fk_membro`, `fk_livro`, `fk_usuario`
### 3. Normalização (Caso Cliente) 
- Identificar problemas de normalização na seguinte tabela: 
	- Cliente: `id`, `nome`, `telefone`, `email`, `endereço`, `produto_comprado`, `valor_compra`
	Nesta tabela existem atributos multivalorados, como: `telefone` e `endereco`. Também foi verificado que não há a necessidade dos campos `produto_comprado` e `valor_compra` na entidade Cliente. Isso criaria vários registros desnecessários.
	
	Solução: Criar uma nova entidade para os telefones, uma para os endereços, uma para os pedidos realizados, uma para os produtos e uma para os itens do pedido.
	
### 4. Relacionamento E-commerce (1:N e N:M)
- 1:N (Um para muitos): Um pedido pode conter muitos produtos;
- N:M (Muitos para muitos): Muitos produtos podem estar em muitos pedidos;
### 5. Modelagem Pessoa x Automóvel
- Conceitual: `Pessoa(id_pessoa, nome, telefone, endereco)`, `automovel(id_automovel, model, fk_pessoa)`
- Lógico: 
	- Uma pessoa pode ser responsável por muitos automóveis;
	- Um automóvel pode conter muitos responsáveis;


## <img src="https://www.svgrepo.com/show/261919/database.svg" alt="Icon database" width="30"> Aula 2: Esquema de Banco de Dados (DDL)

Criei um banco de dados para um sistema de biblioteca. O banco de dados foi estruturado em Postgresql e está hospedado no **Supabase**. Ele contém as seguintes tabelas:
- livro: Armazena o acervo
- usuario: Cadastro de leitores com CPF único
- emprestimo: Faz a ligação N:M entre usuários e livros, controlando o status


### <img src="https://www.svgrepo.com/show/375831/key.svg" alt="Icon key" width="30"> Como executar

Para visualizar o código que usei, copie o conteúdo do arquivo [script.biblioteca.sql](./scripts/script.biblioteca.sql), cole no Query Tool do seu SGBD e execute na ordem em que aparecem.


### <img src="https://www.svgrepo.com/show/271927/tools-and-utensils-laptop.svg" alt="Icon tools" width="30"> Tecnologias Utilizadas

<p align="left">
	<img src ="https://upload.wikimedia.org/wikipedia/commons/9/9c/IntelliJ_IDEA_Icon.svg" alt="IntelliJ IDEA Logo" width="30">
	<img src="https://upload.wikimedia.org/wikipedia/commons/f/f4/R_%281%29ds.png" alt="Postgresql Logo" width="30">
	<img src="https://upload.wikimedia.org/wikipedia/commons/4/46/Pop%21_OS_Icon.svg" alt="!Pop_Os Logo" width="30">
</p>
---
