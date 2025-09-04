drop database if exists sistema_gestion_tareas;
create database sistema_gestion_tareas;
use sistema_gestion_tareas;

create table profesores (
    id_profesor int auto_increment,
    nombre varchar(256) not null,
    apellido varchar(256) not null,
    correo varchar(256) not null,
    constraint pk_profesores primary key (id_profesor)
);

create table estudiantes (
    id_estudiante int auto_increment,
    nombre varchar(256) not null,
    correo varchar(256) not null,
    contraseña varchar(256) not null,
    constraint pk_estudiantes primary key (id_estudiante)
);

create table cursos (
    id_curso int auto_increment,
    nombre varchar(256) not null,
    descripcion text,
    id_profesor int not null,
    constraint pk_cursos primary key (id_curso),
    constraint fk_profesores foreign key (id_profesor) references profesores(id_profesor)
);

create table estudiantes_cursos (
    id_estudiante_curso int auto_increment,
    id_estudiante int not null,
    id_curso int not null,
    constraint pk_estud_cursos primary key (id_estudiante_curso),
    constraint fk_estudiantes foreign key (id_estudiante) references estudiantes(id_estudiante),
    constraint fk_cursos foreign key (id_curso) references cursos(id_curso)
);

create table tareas (
    id_tarea int auto_increment,
    titulo varchar(256) not null,
    descripcion text,
    fecha_entrega datetime not null,
    id_curso int not null,
    constraint pk_tareas primary key (id_tarea),
    constraint fk_t_cursos foreign key (id_curso) references cursos(id_curso)
);

create table entregas (
    id_entrega int auto_increment,
    fecha_entrega datetime not null,
    calificacion decimal(5,2),
    id_tarea int not null,
    id_estudiante int not null,
    constraint pk_entregas primary key (id_entrega),
    constraint fk_tareas foreign key (id_tarea) references tareas(id_tarea),
    constraint fk_e_estudiantes foreign key (id_estudiante) references estudiantes(id_estudiante)
);

insert into profesores (nombre, apellido, correo) values
('carlos', 'mendoza', 'cmendoza@universidad.edu'),
('lucia', 'ramirez', 'lramirez@universidad.edu'),
('miguel', 'torres', 'mtorres@universidad.edu'),
('ana', 'gutierrez', 'agutierrez@universidad.edu'),
('javier', 'lopez', 'jlopez@universidad.edu');

insert into estudiantes (nombre, correo) values
('maria garcia', 'mgarcia@estudiante.edu'),
('juan perez', 'jperez@estudiante.edu'),
('sofia martinez', 'smartinez@estudiante.edu'),
('david hernandez', 'dhernandez@estudiante.edu'),
('laura diaz', 'ldiaz@estudiante.edu');

insert into cursos (nombre, descripcion, id_profesor) values
('cálculo i', 'introducción al cálculo diferencial', 1),
('programación básica', 'fundamentos de programación en python', 2),
('literatura española', 'estudio de la literatura española del siglo xx', 3),
('historia universal', 'panorama general de la historia mundial', 4),
('biología general', 'conceptos básicos de biología', 5);

insert into estudiantes_cursos (id_estudiante, id_curso) values
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 4), (2, 5),
(3, 2), (3, 3), (3, 4),
(4, 1), (4, 3), (4, 5),
(5, 2), (5, 4), (5, 5);

insert into tareas (titulo, descripcion, fecha_entrega, id_curso) values
('ejercicios de límites', 'resolver los ejercicios 1-20 del capítulo 2', '2024-06-15 23:59:00', 1),
('programa hola mundo', 'crear un programa que imprima "hola mundo" en python', '2024-06-10 23:59:00', 2),
('ensayo sobre garcía márquez', 'ensayo de 1000 palabras sobre cien años de soledad', '2024-06-20 23:59:00', 3),
('línea del tiempo revolución francesa', 'crear una línea del tiempo de la revolución francesa', '2024-06-12 23:59:00', 4),
('reporte de laboratorio', 'reporte del experimento de fotosíntesis', '2024-06-18 23:59:00', 5);

insert into entregas (fecha_entrega, calificacion, id_tarea, id_estudiante) values
('2024-06-14 22:30:00', 95.0, 1, 1),
('2024-06-09 21:45:00', 48.5, 2, 1),
('2024-06-13 23:15:00', 85.0, 1, 2),
('2024-06-19 20:00:00', 0, 3, 3),
('2024-06-11 19:30:00', 78.0, 4, 4),
('2024-06-17 18:45:00', 0, 5, 5);