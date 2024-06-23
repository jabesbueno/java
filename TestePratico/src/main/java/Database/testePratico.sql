create database testePratico
    with
    owner = postgres
    encoding = 'UTF8';

create table tbUsuario(
	 idUsuario serial,
	 nome varchar(50),
	 email varchar(50),
	 senha varchar(70),
	 primary key (idUsuario)
 );

 create table tbFuncionario(
	 idFuncionario serial,
	 nome varchar(50),
	 dataAdmissao date,
	 salario float,
	 status varchar(10),
	 usuario integer,
	 primary key (idFuncionario),
	 foreign key (usuario) references tbUsuario (idUsuario)
 );
