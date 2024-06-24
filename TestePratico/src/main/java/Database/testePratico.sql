create database testePratico
    with
    owner = postgres
    encoding = 'UTF8'
    lc_collate = 'c'
    lc__ctype = 'c'
    locale_provider = 'libc'
    tablespace = pg_default
    connection limit -1
    is_template = false;

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
	 dataAdmissao varchar(10),
	 salario float,
	 status varchar(10),
	 usuario integer,
	 primary key (idFuncionario),
	 foreign key (usuario) references tbUsuario (idUsuario)
 );
