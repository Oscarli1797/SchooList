[FASE 1](#fase-1)


[Integrantes del equipo de desarrollo](#integrantes-del-equipo-de-desarrollo)



# SchooList
Web de colegio que tiene como objetivo la facilitación de la gestión de alumnos, además de informar sobre el colegio. 
Al formar parte de la organización se podrá iniciar sesión como monitor de autobus, profesor, padres o administrador, y dependiendo del tipo de usuario tendrá ciertas funcionalidades disposibles.

#FASE 1:

## Funcionalidad pública:
Consulta del portal de posts del colegio con noticias sobre la organización, información de eventos, horarios, profesores, información de comidas, etc.

## Funcionalidad privada:
#### Monitor de autobús:
Puede controlar el flujo de alumnos que entran y salen del bus, asegurándose de que sean recogidos/dejados en el lugar correspondiente. Podrá iniciar sesión en la página para acceder a la tabla de alumnos de su bus (actualizada día a día) y consultar cuáles van a clase, además de información extra como la parada.

#### Profesor: 
Controla la asistencia a clase y puede poner mensajes (positivos :D o negativos D:) en los alumnos de su clase. Además, publicará las notas de las evaluaciones.

#### Padres: 
Podrá consultar la asistencia de su hijo, comunicarse con los profesores e informar de la no asistencia de su hijo a clase, ya sea en un día, varios o durante ciertas horas.

#### Administrador: 
Podrá actualizar los posts de la página del colegio, además de añadir o eliminar alumnos, profesores, monitores y otros administradores a la base de datos.

## Entidad
- Profesor: tipo de usuario.
- Monitor de autobús: tipo de usuario.
- Padre: tipo de usuario.
- Administrador: tipo de usuario.
- Autobús: tiene asignada una ruta (con sus paradas), un monitor y los niños que debe transportar.
- Alumno: encapsula la información de un alumno (nombre, bus, clase, DNI etc.).
- Gestor de asistencia: gestiona la base de datos para modificar la asistencia de los alumnos en fechas específicas.
- Gestor de mensajes: administra los mensajes entre profesores y padres.
- Artículo: contiene un texto con información sobre el colegio.
- Gestor del portal: permite al administrador gestionar los posts.

## Funcionalidades del servicio interno: 
- Recibimiento de e-mail a la cuenta de correo enlazada con el usuario cuando reciba una notificación.

## Integrantes del equipo de desarrollo

#### Ángel Cabanilles Gomar
E-mail:  a.cabanilles@alumnos.urjc.es

Github: [Angelitorl](https://github.com/Angelitorl)

#### Daniel de la Peña González
E-mail: d.delapenago@alumnos.urjc.es

Github: [Danielonio](https://github.com/Danielonio)

#### Germán Matilla Jiménez
E-mail: g.matilla@alumnos.urjc.es

Github: [MaJiGerman](https://github.com/MaJiGerman)


##  Herramientas utilizadas

#### [SchooList Trello](https://trello.com/b/7ewuiHVz/schoolist)

