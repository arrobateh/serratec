# <img src="https://www.svgrepo.com/show/286859/database.svg" alt="O ícone é composto por um cilindro vertical dividido em três seções horizontais sobrepostas. Essa representação remete aos antigos discos rígidos (HDDs) físicos, onde os dados eram armazenados em pratos magnéticos. Cada camada é separada por linhas curvas que acompanham a perspectiva elíptica do topo, reforçando a ideia de profundidade e volume (aspecto 3D). A parte superior é uma elipse sólida, que define a perspectiva de visualização de cima e de lado. A imagem utiliza um preto sólido (monocromático) sobre um fundo transparente." width="45"> Banco de Dados | SERRATEC

Este diretório contém todo material produzido durante às aulas da disciplina *'Banco de Dados'*.

Os exercícios da aula 1 respondi abaixo em texto e a modelagem de atividade desta aula se encontra [aqui](./docs/modelagem-drawio "Link que leva ao diretório onde estão salvos os arquivos da modelagem em formato pdf") no formato .pdf .


## <img src="https://www.svgrepo.com/show/263515/book.svg" alt="A imagem mostra um ícone universal de um livro azul, com folhas brancas. O livro está fechado. Ao fundo está uma imagem em formato circular, de cor laranja escuro. Na direção sudoeste do livro há uma sombra fraca. Na parte de baixo do livro está saindo uma ponta do marca texto na cor laranja escuro" width="30"> Aula 1 (Introdução e Modelagem)
### 1. Entidades para um sistema financeiro (pensei em um sistema financeiro de uma igreja):
`Membro`, `Receita`, `Despesa`, `Categoria`, `Centro de Custo`, `Dizimo`, `Tipo Receita`, `Tipo Despesa`, `Usuario`, `Log_Auditoria`;
### 2. Entidades de biblioteca com atributos
-  Membro:`id_membro`, `nome`, `endereco`, `telefone`, `email`
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


## <img src="https://www.svgrepo.com/show/261919/database.svg" alt="A imagem apresenta um representação de um banco de dados, com 4 formas circulares sobrepostas umas ás outras. Há linhas cinzas que separam esses círculos. Dentro de cada circulo, ao lado direito, possui dois círculos pequenos que simulam lampadas de ligado e desligado. Á frente dos círculos há uma lupa, com lente azul e corpo cor de grafite(cinza escuro). Ao funco há uma forma circular rosa escuro" width="30"> Aula 2: Esquema de Banco de Dados (DDL)

Criei um banco de dados para um sistema de biblioteca. O banco de dados foi estruturado em Postgresql e está hospedado no **Supabase**. Ele contém as seguintes tabelas:
- livro: Armazena o acervo
- usuario: Cadastro de leitores com CPF único
- emprestimo: Faz a ligação N:M entre usuários e livros, controlando o status


### <img src="https://www.svgrepo.com/show/375831/key.svg" alt="Essa imagem apresenta um fundo circular laranja escuro, quase marrom. No centro no círculo há uma chave da cor branca e uma sombra atrás dela na cor preto com opacidade bem fraca" width="30"> Como executar

Todos os scripts das atividades estão [aqui](./scripts)


### <img src="https://www.svgrepo.com/show/271927/tools-and-utensils-laptop.svg" alt="Icon tools" width="30"> Tecnologias Utilizadas

<p align="left">
	<a href="https://www.jetbrains.com/idea/" </a>
	<img src="https://upload.wikimedia.org/wikipedia/commons/9/9c/IntelliJ_IDEA_Icon.svg"
	alt="A base da imagem é um quadrado com bordas levemente arredondadas. Ele apresenta um gradiente vibrante que transita entre tons de roxo, magenta, laranja e azul escuro. Sobre o fundo colorido, há uma forma preta sólida que parece enquadrar o centro. Ela possui um recorte estilizado, lembrando uma abertura de câmera ou um elemento de design abstrato que foca a atenção no meio. No centro, há um cursor de digitação branco (um subtraço ou underscore) posicionado ao lado de um espaço vazio, evocando a ideia de uma linha de comando ou de escrita de código. No canto inferior esquerdo, estão as letras IJ em uma fonte branca, sem serifa e minimalista. Elas representam as iniciais do software. O design segue a estética atual da JetBrains: geométrica, moderna e com cores neon contrastando com fundos escuros."
	title="IntelliJ IDEA Ultimate"
	width="30">
	<a href="https://www.postgresql.org" </a>
	<img src="https://upload.wikimedia.org/wikipedia/commons/f/f4/R_%281%29ds.png"
	alt="Essa imagem apresenta um fundo branco com a cabeça de um elefante. A cor do elefante é azul claro e linhas brancas desenham seu rosto. O elefante possui duas presas. Abaixo da imagem do elefante está o texto postgre, escrito com fonte sem serifa na cor preto, e sql, escrito sem serifa na cor azul claro." 
	title ="Postgresql"
	width="30">
	<a href="https://system76.com/pop/" </a>
	<img src="https://upload.wikimedia.org/wikipedia/commons/4/46/Pop%21_OS_Icon.svg"alt="O foco principal é um círculo preenchido com uma cor ciano (ou azul-turquesa) vibrante. Dentro do círculo, a palavra pop! está escrita em letras minúsculas. A fonte é robusta, arredondada e de cor branca, o que cria um alto contraste com o fundo azul. O caractere exclamação é um elemento chave, dando personalidade ao nome e reforçando a ideia de algo impactante ou explosivo (como o som de um pop). O ícone segue a tendência de flat design (design plano), sem sombras complexas ou gradientes exagerados, facilitando a leitura em diferentes tamanhos de tela."
	title="!Pop_OS"
	width="30">
	<a href="https://supabase.com" <a/>
	<img src="https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/supabase-icon.png"
	alt="O elemento central é uma representação estilizada de um raio. Ele é formado por duas formas geométricas principais que não se tocam completamente, criando uma sensação de dinamismo e energia. O design é composto por ângulos agudos e linhas retas, o que confere um aspecto tecnológico, preciso e moderno. A disposição das duas partes do raio sugere sutilmente a letra S, que é a inicial do nome da marca (Supabase). O ícone utiliza uma cor verde esmeralda vibrante (ou verde neon) sobre um fundo que, no arquivo original, costuma ser transparente ou preto. Esse verde é a cor característica da identidade visual da marca."
	title="Supabase"
	width="30">
</p>
---
