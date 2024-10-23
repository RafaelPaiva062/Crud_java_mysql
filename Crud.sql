-- criar o banco de dados
create database dblojaetec;
drop database if exists dblojaetec;
-- selecionar o banco de dados
use dblojaetec;

-- criar a tabela usuarios
create table usuarios (
    iduser int primary key auto_increment,
    usuario varchar(50) not null,
    fone varchar(15),
    login varchar(15) not null unique,
    senha varchar(15) not null
);
-- Criar a tabela clientes
CREATE TABLE clientes (
    idcli INT PRIMARY KEY AUTO_INCREMENT,
    nomecli VARCHAR(50) NOT NULL,
    endcli VARCHAR(100),
    fonecli VARCHAR(15) NOT NULL,
    emailcli VARCHAR(50)
);

-- Criar a tabela ordem_servico
CREATE TABLE ordem_servico (
    os INT PRIMARY KEY AUTO_INCREMENT,
    data_os TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    equipamento VARCHAR(150) NOT NULL,
    defeito VARCHAR(150) NOT NULL,
    servico VARCHAR(150),
    tecnico VARCHAR(30),
    valor DECIMAL(10,2),
    idcli INT NOT NULL,
    FOREIGN KEY (idcli) REFERENCES clientes(idcli)
);


-- Inserir registros na tabela usuarios com ID
insert into usuarios (iduser, usuario, fone, login, senha) values (1, 'joão silva', '123456789', 'joao.silva', 'senha123');
insert into usuarios (iduser, usuario, fone, login, senha) values (2, 'maria oliveira', '987654321', 'maria.oliveira', 'senha456');
insert into usuarios (iduser, usuario, fone, login, senha) values (3, 'pedro santos', '456789123', 'pedro.santos', 'senha789');
insert into usuarios (iduser, usuario, fone, login, senha) values (4, 'ana pereira', '321654987', 'ana.pereira', 'senha101');
insert into usuarios (iduser, usuario, fone, login, senha) values (5, 'carlos almeida', '789321654', 'carlos.almeida', 'senha202');
insert into usuarios (iduser, usuario, fone, login, senha) values (6, 'larissa costa', '654987321', 'larissa.costa', 'senha303');
insert into usuarios (iduser, usuario, fone, login, senha) values (7, 'felipe rodrigues', '147258369', 'felipe.rodrigues', 'senha404');
insert into usuarios (iduser, usuario, fone, login, senha) values (8, 'julia fernandes', '963852741', 'julia.fernandes', 'senha505');
insert into usuarios (iduser, usuario, fone, login, senha) values (9, 'bruno lima', '258963147', 'bruno.lima', 'senha606');
insert into usuarios (iduser, usuario, fone, login, senha) values (10,
 'sofia mendes', '369147258', 'sofia.mendes', 'senha707');
-- Inserir registros na tabela clientes
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (1, 'Carlos Silva', 'Rua A, 123', '123456789', 'carlos@email.com');
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (2, 'Ana Costa', 'Avenida B, 456', '987654321', 'ana@email.com');
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (3, 'João Pereira', 'Praça C, 789', '456789123', 'joao@email.com');
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (4, 'Maria Oliveira', 'Rua D, 101', '321654987', 'maria@email.com');
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (5, 'Pedro Santos', 'Avenida E, 202', '654987321', 'pedro@email.com');
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (6, 'Sofia Mendes', 'Rua F, 303', '147258369', 'sofia@email.com');
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (7, 'Bruno Lima', 'Praça G, 404', '963852741', 'bruno@email.com');
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (8, 'Larissa Costa', 'Rua H, 505', '258963147', 'larissa@email.com');
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (9, 'Felipe Rodrigues', 'Avenida I, 606', '369147258', 'felipe@email.com');
INSERT INTO clientes (idcli, nomecli, endcli, fonecli, emailcli) VALUES (10, 'Julia Fernandes', 'Rua J, 707', '852369741', 'julia@email.com');
-- Inserir registros na tabela ordem_servico com ID
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (1, 'Computador', 'Não liga', 'Reparo de hardware', 'Pedro Santos', 250.00, 1);
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (2, 'Impressora', 'Atola papel', 'Limpeza e manutenção', 'Maria Oliveira', 80.00, 2);
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (3, 'Smartphone', 'Tela quebrada', 'Substituição de tela', 'Bru no Lima', 300.00, 3);
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (4, 'Notebook', 'Bateria não carrega', 'Troca de bateria', 'Sofia Mendes', 150.00, 4);
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (5, 'Desktop', 'Barulho estranho', 'Revisão geral', 'Larissa Costa', 200.00, 5);
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (6, 'Monitor', 'Sem sinal', 'Verificação de conexões', 'Felipe Rodrigues', 70.00, 6);
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (7, 'Router', 'Internet lenta', 'Configuração de rede', 'Julia Fernandes', 100.00, 7);
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (8, 'Console', 'Não liga', 'Diagnóstico e reparo', 'Pedro Santos', 400.00, 8);
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (9, 'Câmera', 'Foco automático falhando', 'Ajuste e limpeza', 'Ana Costa', 90.00, 9);
insert into ordem_servico (os, equipamento, defeito, servico, tecnico, valor, idcli) values (10, 'Teclado', 'Teclas não respondem', 'Substituição de teclas', 'Bruno Lima', 60.00, 10);
