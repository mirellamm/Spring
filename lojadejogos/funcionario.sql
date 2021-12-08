

create database db_empresa;

use db_empresa;

create table tb_funcionarios(
id int(4) auto_increment,
nome varchar(80) not null,
cpf bigint(11),
salario decimal(10,2),
telefone bigint(11),
primary key(id)
);

select * from tb_funcionarios;

insert into tb_funcionarios(nome,cpf,salario,telefone) values ("Vinicius",45678912300,295000,11987654123);
insert into tb_funcionarios(nome,cpf,salario,telefone) values ("Graziela",12345098765,189797,11987457123);
insert into tb_funcionarios(nome,cpf,salario,telefone) values ("Victor",456873290315,218900,11971632975);
insert into tb_funcionarios(nome,cpf,salario,telefone) values ("Hugo",16782957183,155000,11981743902);
insert into tb_funcionarios(nome,cpf,salario,telefone) values ("Vitoria",28015478912,201000,11999287645);

update tb_funcionarios set salario=2950 where id=1;
update tb_funcionarios set salario=1897 where id=2;
update tb_funcionarios set salario=2189 where id=3;
update tb_funcionarios set salario=1550 where id=4;
update tb_funcionarios set salario=2010 where id=5;

select * from tb_funcionarios where salario > 2000;
select * from tb_funcionarios where salario < 2000;