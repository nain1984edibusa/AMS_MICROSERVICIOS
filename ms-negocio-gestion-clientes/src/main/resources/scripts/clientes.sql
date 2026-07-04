use db_ms_cliente;

create table tbl_cliente(
    cliente_id int not null auto_increment  primary key,
    razon_social varchar(260) not null unique,
    ruc char(15) not null unique,
    direccion varchar(400) not null,
    telefono varchar(20) null,
    correo varchar(60) null,
    estado char(1) default '1' not null 
);


