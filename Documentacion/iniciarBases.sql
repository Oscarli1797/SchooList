insert into parada values ('11111111', 'C/ Santiago del arrozal 7');
insert into parada values ('11111112', 'C/ Petalo 2');
insert into parada values ('11111113', 'C/ San Cristobal 24');
insert into parada values ('11111114', 'C/ Periplo maldito 8');
insert into autobus values ('12134425');
insert into autobus_paradas values ('12134425', '11111111');
insert into autobus_paradas values ('12134425', '11111112');
insert into autobus_paradas values ('12134425', '11111113');
insert into autobus_paradas values ('12134425', '11111114');

insert into grupo values ('179431', '1 primaria', 'A');

insert into asignatura values ('100000', 'matematicas 1');
insert into asignatura values ('100001', 'lengua 1');
insert into asignatura values ('100002', 'conocimiento del medio 1');
insert into asignatura values ('100003', 'ingles 1');

insert into asignatura_grupo values ('100000', '179431');
insert into asignatura_grupo values ('100001', '179431');
insert into asignatura_grupo values ('100002', '179431');
insert into asignatura_grupo values ('100003', '179431');

insert into usuario values ('Admin', 'carsena', 'Serrano',  'Navia', 'mail@noresponse.com','Carlos', '1234', null);
insert into usuario values ('Admin', 'fersena', 'Serrano', 'Navia',  'mail@noresponse.com', 'Fernando', '1234', null);

insert into usuario values ('Profesor', 'jureher', 'Reyes', 'Hernandez', 'mail@noresponse.com', 'Julia', '1234', null);
insert into usuario values ('Profesor', 'clausepas', 'Serrano', 'Pastor', 'mail@noresponse.com', 'Claudia', '1234', null);

insert into usuario values ('Monitor', 'frandiazvi', 'Diaz', 'de Vivar', 'mail@noresponse.com', 'Francisco', '1234', '12134425');
insert into usuario values ('Monitor', 'fegarruiz', 'Garcia', 'Ruiz','mail@noresponse.com', 'Federico', '1234', null);

insert into usuario_asignaturas values ('jureher', '100000');
insert into usuario_asignaturas values ('jureher', '100001');
insert into usuario_asignaturas values ('clausepas', '100002');
insert into usuario_asignaturas values ('clausepas', '100003');

insert into usuario values ('Padre', 'silzavi', 'Zamora', 'de Vivar', 'mail@noresponse.com', 'Silvia', '1234', null);
insert into usuario values ('Padre', 'rismecal', 'Mejilla', 'Calvo', 'mail@noresponse.com', 'Risto', '1234', null);
insert into usuario values ('Padre', 'sercopal', 'Corazon', 'Palpito', 'mail@noresponse.com','Sergio', '1234', null);
insert into usuario values ('Padre', 'caacruz', 'Cruz', 'Amaya', 'mail@noresponse.com', 'Carolina', '1234', null);

insert into alumno values('12345678', '1234567', 'Zamora', 'Peiro', 'Ester', '179431', 'rismecal', '11111113');
insert into alumno values('12345679', '1345636', 'Corazon', 'Leon', 'Ricardo', '179431', 'rismecal', '11111112');
insert into alumno values('12345680', '6536563', 'Cruz', 'Garcia', 'Sergio', '179431', 'sercopal', '11111111');
insert into alumno values('12345674', '4674256', 'Mejilla', 'Jimenez', 'Carlos', '179431', 'caacruz', '11111114');

insert into falta values ('0000001', '2019-01-24', 'mi hij@ esta enganchado a un arbol, no va a poder ir', '12345678');

insert into mensaje values ('0000746', 'Falta de trabajo',  '2019-01-24', 'Su hijo no hace los deberes nunca', 'rismecal', 'jureher');
insert into mensaje values ('0000002', 'No me hable asi usted', '2019-01-24', 'Tu diras lo que hace y deja de hacer mi hijo, ¡jah!', 'jureher', 'rismecal');

insert into post values ('00001',  '2019-05-24','El jueves pasado los alumnos de nuestro colegio fueron seleccionados para participar en el torneo de matematicas JovenesGenios, un torneo famoso a nivel mundial donde solo los mas capaces pueden participar', 'SOMOS UNOS GENIOS', 'fersena');
insert into post values ('00002', '2019-06-20','El miercoles que viene saldremos a recoger hojas para contactar con la naturaleza. Nuestros alumnos podrán conocer las peculiaridades del otoño de una forma practica y divertida. ¿Alguno querrá dedicarse a esto de mayor? ¡Ya lo veremos! ', 'EXCURSION OTOÑAL', 'fersena');
