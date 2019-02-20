insert into parada values ('11111111', 'C/ Santiago del arrozal 7');
insert into parada values ('11111112', 'C/ Petalo 2');
insert into parada values ('11111113', 'C/ San Cristobal 24');
insert into parada values ('11111114', 'C/ Periplo maldito 8');
insert into autobus values ('12134425');
insert into autobus_paradas values ('12134425', '11111111');
insert into autobus_paradas values ('12134425', '11111112');
insert into autobus_paradas values ('12134425', '11111113');
insert into autobus_paradas values ('12134425', '11111114');

insert into curso values ('148769', '1 primaria');
insert into grupo values ('179431', 'A', 148769);

insert into asignatura values ('100000', 'matematicas 1');
insert into asignatura values ('100001', 'lengua 1');
insert into asignatura values ('100002', 'conocimiento del medio 1');
insert into asignatura values ('100003', 'ingles 1');

insert into asignatura_grupo values ('100000', '179431');
insert into asignatura_grupo values ('100001', '179431');
insert into asignatura_grupo values ('100002', '179431');
insert into asignatura_grupo values ('100003', '179431');

insert into user values ('carsena', 'Serrano', 'Navia', 'Carlos', '1234', 'admin');
insert into user values ('fersena', 'Serrano', 'Navia', 'Fernando', '1234', 'admin');
insert into admin values ('fersena', 'fersena');
insert into admin values ('carsena', 'carsena');

insert into user values ('jureher', 'Reyes', 'Hernandez', 'Julia', '1234', 'profesor');
insert into user values ('clausepas', 'Serrano', 'Pastor', 'Claudia', '1234', 'profesor');
insert into profesor values ('jureher', 'jureher');
insert into profesor values ('clausepas', 'clausepas');

insert into profesor_asignaturas values ('jureher', '100000');
insert into profesor_asignaturas values ('jureher', '100001');
insert into profesor_asignaturas values ('clausepas', '100002');
insert into profesor_asignaturas values ('clausepas', '100003');

insert into user values ('frandiazvi', 'Diaz', 'de Vivar', 'Francisco', '1234', 'monitor');
insert into user values ('fegarruiz', 'Garcia', 'Ruiz', 'Federico', '1234', 'monitor');
insert into monitor values ('frandiazvi', '12134425', 'frandiazvi');
insert into monitor values ('fegarruiz', null, 'fegarruiz');

insert into alumno values('12345678', '1234567', 'Zamora', 'Peiro', 'Ester', '179431', '11111113');
insert into alumno values('12345679', '1345636', 'Corazon', 'Leon', 'Ricardo', '179431', '11111112');
insert into alumno values('12345680', '6536563', 'Cruz', 'Garcia', 'Sergio', '179431', '11111111');
insert into alumno values('12345674', '4674256', 'Mejilla', 'Jimenez', 'Carlos', '179431', '11111114');

insert into user values ('silzavi', 'Zamora', 'de Vivar', 'Silvia', '1234', 'padre');
insert into user values ('rismecal', 'Mejilla', 'Calvo', 'Risto', '1234', 'padre');
insert into user values ('sercopal', 'Corazon', 'Palpito', 'Sergio', '1234', 'padre');
insert into user values ('caacruz', 'Cruz', 'Amaya', 'Carolina', '1234', 'padre');
insert into padre values ('silzavi', '12345678', 'silzavi');
insert into padre values ('rismecal', '12345674', 'rismecal');
insert into padre values ('sercopal', '12345679', 'sercopal');
insert into padre values ('caacruz', '12345680', 'caacruz');

insert into falta values ('0000001', '2019-01-24', 'mi hij@ esta enganchado a un arbol, no va a poder ir', '12345678');

insert into mensaje values ('0000746', 'Falta de trabajo', 'Su hijo no hace los deberes nunca', 'rismecal', 'jureher');
insert into mensaje values ('0000002', 'No me hable asi usted', 'Tu diras lo que hace y deja de hacer mi hijo, ¡jah!', 'jureher', 'rismecal');

insert into post values ('00001', 'El jueves pasado los alumnos de nuestro colegio fueron seleccionados para participar en el torneo de matematicas JovenesGenios, un torneo famoso a nivel mundial donde solo los mas capaces pueden participar', 'SOMOS UNOS GENIOS', 'fersena');
insert into post values ('00002', 'El miercoles que viene saldremos a recoger hojas para contactar con la naturaleza. Nuestros alumnos podrán conocer las peculiaridades del otoño de una forma practica y divertida. ¿Alguno querrá dedicarse a esto de mayor? ¡Ya lo veremos! ', 'EXCURSION OTOÑAL', 'fersena');
