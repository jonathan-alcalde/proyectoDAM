
--borrar base de datos
drop database empresa if exist;

--crear base de datos
create database empresa;
use empresa;
--crear tablas
create table sedes(
	codsede tinyint not null,
	localidad varchar2(50) not null,
	provincia varchar2(30) not null
);

create table departamentos(
	coddepto varchar2(2) primary key not null,
	nomdepto varchar2(15) not null,
	codsede tinyint
);

create table  empleados(
	codemple varchar2(4) primary key not null,
	nombre varchar2(20) not null,
	apellido varchar2(35) not null,
	fecha_alta date not null,
	oficio varchar2(15) not null,
	superior varchar2(4),
	salariomes dec(6,2) not null,
	comision dec(5,2),
	coddepto varchar2(2)
);
--añadir foreign key
alter table departamentos add foreign key(codsede) references sedes(codsede);
alter table empleados add foreign key(coddepto) references departamentos(coddepto);

--Introducir datos tabla sedes
INSERT INTO Sedes VALUES (1,'SEVILLA','SEVILLA'),
(2,'MADRID','MADRID'),
(3,'BARCELONA','BARCELONA'),
(4,'BILBAO','VIZCAYA'),
(5,'SANTANDER','CANTABRIA'),
(6,'TORRELAVEGA','CANTABRIA');
COMMIT;

--Introducir datos tabla departamentos
INSERT INTO Departamentos VALUES (10,'CONTABILIDAD',1);
INSERT INTO Departamentos VALUES (20,'INVESTIGACION',2);
INSERT INTO Departamentos VALUES (30,'VENTAS',3);
INSERT INTO Departamentos VALUES (40,'PRODUCCION',4);
INSERT INTO Departamentos VALUES (50,'DESARROLLO WEB',NULL);
INSERT INTO Departamentos VALUES (51,'SISTEMAS',NULL);
INSERT INTO Departamentos VALUES (52,'DESARROLLO WEB',5);
COMMIT;

--Introducir datos tabla empleados
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7369",'UNAI','SANCHEZ','EMPLEADO',"7902",'1990/12/17',1040,NULL,20);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7499",'ALEX','ARROYO','VENDEDOR',"7698",'1990/02/20',1500,390,30);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7521",'NOA','SALA','VENDEDOR',"7698",'1991/02/22',1625,650,30);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7566",'BENIGNO','JIMENEZ','DIRECTOR',"7839",'1991/04/02',2900,550.50,20);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7654",'SEVERINO','MARTIN','VENDEDOR',"7698",'1991/09/29',1600,120,30);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7698",'ALVARO','NEGRO','DIRECTOR',"7839",'1991/05/01',3005,550.50,30);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7699",'LAILA','BLANCO','DIRECTOR',"7839",'1991/05/01',3005,550.50,52);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7782",'FRANCISCO','CEREZO','DIRECTOR',"7839",'1991/06/09',2885,550.50,10);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7788",'AICHA','GIL','ANALISTA',"7566",'1991/11/09',3000,NULL,20);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7839",'NOEL','REY','PRESIDENTE',NULL,'1991/11/17',4100,750.50,10);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7844",'FERRAN','TOVAR','VENDEDOR',"7698",'1991/09/08',1350,0,30);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7876",'ISMAEL','ALONSO','EMPLEADO',"7788",'1991/09/23',1430,NULL,20);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7900",'HIPOLITO','JIMENO','EMPLEADO',"7698",'1991/12/03',1335,NULL,30);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7902",'ELIAS','FERNANDEZ','ANALISTA',"7566",'1991/12/03',3000,NULL,20);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("7934",'ADRIA','RUIZ','EMPLEADO',"7782",'1992/01/23',1690,NULL,10);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("8844",'DIONISIA','HARRISON','PROGRAMADOR',"7698",'1991/09/08',1350,0,52);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("8845",'LAURA','MORRISON','PROGRAMADOR',"7698",'1991/09/08',1350,0,52);
INSERT INTO Empleados(codemple,nombre,apellido,oficio,superior,fecha_alta,salariomes,comision,coddepto) VALUES ("8846",'GEMMA','BENDER','PROGRAMADOR',"7698",'1991/09/08',1350,0,52);
COMMIT;
--3
select * from sedes;
select * from departamentos order by nomdepto;
select nombre, apellido,fecha_alta, salariomes from empleados where coddepto = 30;
select nombre, apellido,salariomes,comision, oficio from empleados where comision is not null;
select nombre, apellido,salariomes,comision, oficio from empleados where comision is not null order by comision desc limit 5;
select * from empleados where superior is null;
select nombre, apellido, oficio,salariomes as salario_base, comision ,(salariomes + ifnull(0 , comision) as salario  from empleados where coddepto = 20 order by salario asc;
select concat_ws(' ', nombre, apellidos) as empleado, oficio, SUM(salariomes) + SUM(comision) as salario from empleados where coddepto = 20 and salariomes + comision > 1500; 