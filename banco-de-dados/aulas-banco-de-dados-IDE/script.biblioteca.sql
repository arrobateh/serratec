create schema biblioteca;
create table biblioteca.livro (
                                  id_livro serial primary key,
                                  titulo varchar(200) not null,
                                  autor varchar(200) not null,
                                  genero varchar(100) not null,
                                  quantidade_estoque int not null
);

create table biblioteca.usuario (
                                    id_usuario serial primary key,
                                    nome varchar(200) not null,
                                    cpf varchar(14) not null unique,
                                    email varchar(200) not null unique,
                                    telefone varchar(20) not null,
                                    endereco varchar(400) not null
);

create type status as enum ('emprestado', 'devolvido');

create table biblioteca.emprestimo (
                                       id_emprestimo serial primary key,
                                       id_usuario int not null, -- chave estrangeira para a tabela usuario
                                       d_livro int not null, -- chave estrangeira para a tabela livro
                                       data_emprestimo date not null,
                                       data_devolucao date,
                                       status status not null, -- 'emprestado' ou 'devolvido'

                                       constraint fk_usuario_emprestimo -- definindo a chave estrangeira para a tabela usuario
                                           foreign key (id_usuario) references biblioteca.usuario (id_usuario)
                                               on delete cascade, -- definindo a ação de exclusão em cascata para manter a integridade referencial

                                       constraint fk_livro_emprestimo -- definindo a chave estrangeira para a tabela livro
                                           foreign key (id_livro) references biblioteca.livro (id_livro)
                                               on delete cascade); -- definindo a ação de exclusão em cascata para manter a integridade referencial

alter table biblioteca.livro -- adicionando a coluna editora à tabela livro
    add column editora varchar(100) not null;