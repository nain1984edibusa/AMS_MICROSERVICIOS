use db_ms_usuarios;

create table tbl_usuario(
    id int not null auto_increment  primary key,
    nombre varchar(260) not null unique,
    apellido varchar(60) null
);


