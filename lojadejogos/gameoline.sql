create database db_generation_game_online default character set utf8 default collate utf8_general_ci;

use db_generation_game_online;

create table tb_classe(
id int auto_increment,
nome varchar(15),
ataque_base int(4),
defesa_base int(4),
hp_base int(4),
primary key(id)
)default charset = utf8;

create table tb_personagem (
id int auto_increment,
nome varchar(10),
moral int(4),
defesa int(4),
ataque int(4),
hp int(4),
id_estrangeira int,
primary key(id),
foreign key(id_estrangeira) references tb_classe(id)
)default charset = utf8;

insert into tb_classe(nome,ataque_base,defesa_base,hp_base) values ("Tank",237,396,415);
insert into tb_classe(nome,ataque_base,defesa_base,hp_base) values ("Arqueiro",488,185,205);
insert into tb_classe(nome,ataque_base,defesa_base,hp_base) values ("Mago",215,327,390);
insert into tb_classe(nome,ataque_base,defesa_base,hp_base) values ("Guereirro",378,210,230);
insert into tb_classe(nome,ataque_base,defesa_base,hp_base) values ("Pike",389,202,332);

insert into tb_personagem(nome,moral,defesa,ataque,hp,id_estrangeira) values ("Filio",105,278,265,190,2);
insert into tb_personagem(nome,moral,defesa,ataque,hp,id_estrangeira) values ("Cieus",327,216,265,263,5);
insert into tb_personagem(nome,moral,defesa,ataque,hp,id_estrangeira) values ("Noezi",157,312,401,189,4);
insert into tb_personagem(nome,moral,defesa,ataque,hp,id_estrangeira) values ("Coypu",209,293,365,281,1);
insert into tb_personagem(nome,moral,defesa,ataque,hp,id_estrangeira) values ("Doymi",333,196,385,276,3);
insert into tb_personagem(nome,moral,defesa,ataque,hp,id_estrangeira) values ("Nianu",237,396,415,265,5);
insert into tb_personagem(nome,moral,defesa,ataque,hp,id_estrangeira) values ("Xiufe",257,376,256,235,2);
insert into tb_personagem(nome,moral,defesa,ataque,hp,id_estrangeira) values ("Ergas",198,219,312,459,3);

select * from tb_personagem where ataque > 200;

select * from tb_personagem where defesa > 150 and defesa < 200;

select * from tb_personagem where nome like "%c%";

select * from tb_personagem where id_estrangeira = 2;