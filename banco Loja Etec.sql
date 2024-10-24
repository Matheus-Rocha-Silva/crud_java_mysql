/*Banco de Dados de Matheus Rocha da matéria CRUD*/

-- Criação de tabela db Loja Etec
create database dblojaetec;
-- Comando de Uso da tabela 
use dblojaetec;
-- consulta de tabelas
show tables;

-- Tabela de usuários
create table usuarios(
iduser int primary key auto_increment,
usuario varchar(50) not null,
fone varchar(15),
login varchar(15) not null unique,
senha varchar(15) not null
);

-- Inserção de registros na tabela Usuários
insert into usuarios (usuario, fone, login, senha) values 
('Sebastião', '4002-8922', 'seba tião', 'seba1234'), ('Ana Luisa', '3482-4892', 'ana lua', 'ana2244'),
('João Feijão', '6542-9023', 'Joãozinho', 'feijão2020'), ('Carlos Doido', '2040-4321', 'carlinhos', 'doido123'),
('Vittorino da Cunha', '9020-2526', 'Da Cunha', 'cunha2255'), ('José Amaro', '4986-9023', 'Zé Amaro', 'ze446'),
('Lula Holanda', '3291-0932', 'Lula', 'lulinha171'), ('Raintaine', '7849-9232', 'Raintaine', 'rant342'),
('Clubin', '9403-0923', 'Sr Clubin', 'clubin231'), ('Clarice Lispector', '9040-8402', 'Lispector', 'lis2245');

-- consulta de registros da tabela Usuários
select * from usuarios;


-- Criação de Tabela Clientes
create table clientes(
idcli int primary key auto_increment,
nomecli varchar(50) not null,
endcli varchar(100),
fonecli varchar(15) not null,
emailcli varchar(50)
);

-- Inserção de registros na tabela Clientes
insert into clientes (nomecli, endcli, fonecli, emailcli) values
('Adamastor','Casa do Baralho','4982-2842','adamas@gmail.com'),('Silvio Santos','Morrinhos','4893-2834','silvinho@gmail.com'),
('Gaben Newell','xique-xique Bahia','4832-2834','gabenewell@msn.com'),('Pelé','Rua dos Carijós','3942-2983','kingofzapzap@hotmail.com'),
('Jorginho','Rua Frederico Moura','3942-2834','jorginho@gmail.com'),('Zezinho','Avenida Desembargador M','8439-2934','zezinho@hotmail.com'),
('Isabela','Rua Maria Luísa do Val Penteado','9340-2834','isinha@gmail.com'),('Arthur Sousa','Avenida Rio Branco','3942-3842','arthurzinho@gmail.com'),
('Alan Ferrieria','Rua Arlindo Nogueira','3480-2933','alanzoka@gmail.com'),('Luciano','Rua Arlindo Nogueira','3948-2834','cappuccino@gmail.com');

-- Consulta das informações da tabela Clientes
select * from clientes;

-- Criação da tabela Ordem de Serviço
create table ordem_servico(
os int primary key auto_increment,
data_os timestamp default current_timestamp,
equipamento varchar(150) not null,
defeito varchar(150) not null,
servico varchar(150),
tecnico varchar(30),
valor decimal(10,2),
idcli int not null,
foreign key(idcli) references clientes(idcli)
);

-- Inserção de dados na tabela Ordem de Serviço
/*OBS: no atributo data_os o "timestamp default current_timestamp" é um tipo específico que puxa a data atual da sua máquina,
portanto, ao criar os registros não há necessidade de inserir data, dessa forma o atributo pode ser desconsiderado sem problema nenhum*/

insert into ordem_servico (equipamento, defeito, servico, tecnico, valor, idcli) values
('Impressora', 'Papel preso', 'Limpeza e ajuste', 'João Silva', 150.00, 1),
('Computador', 'Não liga', 'Troca de fonte', 'Maria Oliveira', 300.00, 2),
('Projetor', 'Imagem desfocada', 'Calibração', 'Carlos Santos', 200.00, 4),
('Notebook', 'Superaquecendo', 'Limpeza interna', 'Ana Pereira', 250.00, 3),
('Monitor', 'Sem sinal', 'Verificação de cabos', 'Lucas Almeida', 100.00, 6),
('Máquina de café', 'Não liga', 'Substituição de fusível', 'Fernanda Costa', 80.00, 7),
('Ar-condicionado', 'Vazamento', 'Reparo de vazamento', 'Roberto Lima', 400.00, 5),
('Televisão', 'Tela quebrada', 'Troca de tela', 'Paula Rocha', 900.00, 9),
('Geladeira', 'Não está refrigerando', 'Verificação de compressor', 'André Martins', 350.00, 8),
('Console de videogame', 'Não lê jogos', 'Limpeza da lente', 'Juliana Mendes', 120.00, 10);

-- Consulta de dados da tabela Ordem de Serviços
select * from ordem_servico;