Create database AgenciaDeViagens;
use AgenciaDeViagens;

create table cliente(
email varchar(40) unique not null primary key,
senha int not null,
nome varchar(40)
);

create table cadastroDestino(
id int not null auto_increment primary key,
CEPOrigem int,
nome varchar(40),
email varchar(40),
CEPDestino int,
valorPassagem double
);

create table destinos(
CEPDestino int not null unique primary key,
nomeDestino varchar(40),
valorPassagem double
);

alter table cadastrodestino add foreign key(email) references cliente(email);
alter table destinos add foreign key(CEPDestino) references cadastroDestino(CEPDestino);