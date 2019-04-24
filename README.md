# Índice

+ [FASE 1: Tema de la web y principales entidades](#fase-1---tema-de-la-web-y-principales-entidades)
+ [FASE 2: Aplicación web con base de datos en local](#fase-2---aplicaci%c3%b3n-web-con-base-de-datos-en-local)
+ [FASE 3: Aplicación web con base de datos en MySQL](#fase-3---aplicaci%c3%b3n-web-con-base-de-datos-en-mysql)
+ [FASE 4: Aplicación web con balanceo de carga](#fase-4---aplicaci%c3%b3n-web-con-balanceo-de-carga)


[Integrantes del equipo de desarrollo](#integrantes-del-equipo-de-desarrollo)


# SchooList
Web de colegio que tiene como objetivo la facilitación de la gestión de alumnos, además de informar sobre el colegio. 
Al formar parte de la organización se podrá iniciar sesión como monitor de autobus, profesor, padres o administrador, y dependiendo del tipo de usuario tendrá ciertas funcionalidades disposibles.

# FASE 1 - Tema de la web y principales entidades

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

# FASE 2 - Aplicación web con base de datos en local

En esta fase se especificarán el diagrama de navegación de la aplicación, el papel de cada una de las páginas de las que está compuesto, el diagrama E/R de la base datos y el diagrama UML del modelo de datos. Puesto que se trata de un proyecto en constante evolución el diseño de las páginas serán modificadas, al igual, algunas funcionalidades puede que sean añadidas o eliminadas dependiendo del desarrollo del proyecto y las necesidades que pretende suplir.

## Diagrama de navegación:

Diagrama de navegación donde podemos observar las diferentes páginas que componen la parte del cliente. El portal de información compone la parte pública y el resto forma la parte privada donde, dependiendo del tipo de usuario que seamos, se mostrará nuestro espacio.

![](/Documentacion/Diagrama_de_navegacion.png?raw=true)

## Páginas principales:

#### Login

El usuario introducirá su nombre de usuario único y la constraseña asociada a ella. Actualmente el login es una página en sí misma, pero la intención es que en un futuro sea un pop-up que forma parte del portal de información.

![](/Documentacion/capturas_fase2/login.PNG?raw=true)

#### Home/Portal de información

Desde esta página se podrá acceder al login y se mostrarán los diferentes posts de noticias del colegio. Actualmente, para acelerar el proceso de desarrollo, se puede acceder a las diferentes páginas de usuario.

![](/Documentacion/capturas_fase2/home.PNG?raw=true)

#### Admin

Página privada de admin donde podrá crear un nuevo usuario (ya sea profesor, padre, monitor o admin), un nuevo alumno y modificar los posts del portal de información (crear, editar y eliminar).

![](/Documentacion/capturas_fase2/admin.PNG?raw=true)

#### Profesor

Página privada de profesor donde podrá consultar los alumnos atendiendo las diferentes asignaturas que imparte, consultar quienes faltan, crear faltas de asistencia y ponerse en contacto con los padres de los alumnos.

![](/Documentacion/capturas_fase2/profesor.PNG?raw=true)

#### Padre

Página privada de padre donde podrá consultar información diversa de su descendiente, informar de una ausencia, consultar faltas de asistencia y ponerse en contacto con profesores. 

![](/Documentacion/capturas_fase2/padre.PNG?raw=true)

#### Monitor

Página privada de monitor donde se mostrará el autobús que debe controlar, la ruta que seguirá, los alumnos que viajarán en eñ bus y dónde baja cada uno.

![](/Documentacion/capturas_fase2/monitor.PNG?raw=true)

#### Mail

Página privada que puede ser accedida por padres y profesores donde se puede enviar un correo a otro usuario de tipo profesor o padre.

![](/Documentacion/capturas_fase2/mail.PNG?raw=true)

## Diagrama E/R

Este diagrama muestra cómo se relacionan las diferentes entidades de la base de datos para poder desarrollar toda la funcionalidad de la página.

![](/Documentacion/er.jpg?raw=true)


## Diagrama UML

Diagrama que muestra las relaciones entre las diferentes clases utilizadas en la aplicación, incluyendo la cardinalidad de las mismas y los controladores utilizados para implementar la interactividad.

![](/Documentacion/diagrama_uml.png?raw=true)


# FASE 3 - Aplicación web con base de datos en MySQL
## Páginas principales:

#### Login

Página pública que cumple la función de iniciar sesión.
![](/Documentacion/capturas_fase3/login.PNG?raw=true)

#### Home/Portal de información

Página principal pública que muestra los posts de la escuela.
![](/Documentacion/capturas_fase3/home.PNG?raw=true)

#### Admin

Página privada accesible únicamente por los usuarios con permisos de administrador.
![](/Documentacion/capturas_fase3/admin.PNG?raw=true)

#### Profesor

Página privada accesible únicamente por los usuarios con permisos de profesor.
![](/Documentacion/capturas_fase3/profesor.PNG?raw=true)

#### Padre

Página privada accesible únicamente por los usuarios con permisos de padre.
![](/Documentacion/capturas_fase3/padre.PNG?raw=true)

#### Monitor

Página privada accesible únicamente por los usuarios con permisos de monitor.
![](/Documentacion/capturas_fase3/monitor.PNG?raw=true)

#### Mail

Página privada accesible únicamente por los usuarios con permisos de padre o profesor.
![](/Documentacion/capturas_fase3/mail.PNG?raw=true)

## Diagrama de clases y templates:
![](/Documentacion/diagramageneral.png?raw=true)

## Instrucciones para instalar:

### Antes de empezar:

- Instalar VirtualBox.
- Crear máquina virtual con SO Ubuntu Server.
- Crear usuario y contraseña del SO.

En primer lugar necesitaremos los ejecutables .jar de la aplicación y el servicio interno, además de la query para inicializar la base de datos de mysql en nuestra máquina virtual.
Para ello compartiremos una carpeta desde nuestra máquina host en la que meteremos los archivos anteriormente comentados.
En primer lugar iremos, desde VirtualBox, a "Configuración">"Shared folders">"Add new shared folder", asignaremos el path de la carpeta del host que queramos compartir y el nombre de la carpeta en nuestra máquina virtual. Una vez creado este enlace, desde la máquina virtual montamos la carpeta ejecutando el comando:
- sudo mount -t vboxsf shared .

Donde "shared" es el nombre de la carpeta de la máquina virtual y "." es la ruta donde crearla.

Posteriormente necesitaremos conectar los puertos 8443 de ambas máquinas para mostrar el output de la aplicación en el host. Para ello vamos a "Configuración">"Network", cambiamos "Attached to" a NAT y en "advanced" clickamos en "port forwarding", donde creamos un enlace entre el puerto 8443 del host y el 8443 del guest.

### Ejecución de aplicación en máquina virtual:
Para lograr la correcta ejecución de nuestra aplicación habrá que instalar Java y mySQL. Para ello, ejecutamos los siguientes comandos:

Instalar java:
- sudo apt-get update
- sudo apt-get install -y openjdk-8-jre

Instalar mysql:
- sudo apt-get install mysql-server

Crear base de datos:
- sudo mysql
- create database schoolistdb;

Crear usuario root:
- create user 'root'@'127.0.0.1'; 

Modificar la contraseña del usuario root para encajar con la dada en nuestra configuración de la aplicación:
- alter mysql.user 'root'@'localhost' identified with mysql_native_password by 'admin';

Ejecutar, dentro de mysql, para inicializar la base de datos:
- use schoolistdb;
- source [RUTA A ARCHIVO SQL]; 

Por último faltaría ejecutar los .jar que, asumiendo que estamos en la carpeta donde se localizan tan solo deberíamos ejecutar:
- sudo java -jar schoolist-0.0.1-SNAPSHOT.jar &
- sudo java -jar schoolist_email-0.0.1-SNAPSHOT.jar &

Una vez hecho esto ya tendríamos la aplicación funcionando en el puerto 8443.

## Protocolo de comunicación con el servicio interno

Recordemos que el servicio consiste en el envío de un email a los nuevos usuarios registrados en la plataforma, a los padres cuyos hijos han faltado a una clase o más sin justificar y a los padres y profesores que les llega un nuevo mensaje.

Para realizar la comunicación entre la aplicación y el servicio interno se hace uso de Sockets.
Para llevar a cabo la comunicación el servicio interno abre su puerto 7777 y espera una nueva conexión la cual, al llegar, crea un thread que ejecuta el código responsable de generar y enviar el email al usuario destino.

La estructura que siguen los datos enviados desde el socket es [direccionCorreo][tipoMensaje], la cual está conformada por un String que divide ambos parámetros por un salto de línea. Este primer parámetro determina la dirección de correo a la que se enviará el mensaje, el cual dependerá del tipo de mensaje que le llegue en el segundo parámetro.

Actualmente, la comunicación es unidireccional, pues no es necesario ningún tipo de respuesta por parte del servicio interno.

# FASE 4 - Aplicación web con balanceo de carga

## Diagrama de la Infraestructura de Docker 

![](/Documentacion/Dockers.png?raw=true)

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
#### [Draw.io](https://www.draw.io/)
#### [LayoutIt](https://www.layoutit.com)
