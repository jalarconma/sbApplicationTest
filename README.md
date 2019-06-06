# sbApplicationTest

Pasos de instalación:

1. Instalar NodeJs > 5.0.0
2. Instalar Postgres

 2.1 Crear un usuario
 
  CREATE USER conexia WITH PASSWORD 'conexia';
  
 2.2 Crear la base de datos
 
  CREATE DATABASE conexia OWNER conexia;
  
 2.3
  \connect conexia

 2.4
 
  DROP SCHEMA public;
  CREATE SCHEMA public AUTHORIZATION conexia;

 2.5
 
  ALTER SCHEMA public OWNER TO conexia;

3. clonar el repositorio
4. para ejecutar el servidor en la carpeta: mejor-cocina-application/builds/libs, se encuentra el .JAR del
   servidor. Ejecutelo.
5. Instalar angular con el comando: npm install -g @angular/cli
6. en la carpeta del repositorio: mejor-cocina-frontend, ejecutar el comando: ng serve
7. en navegador Chrome, dirigirse a la dirección que indique en alterior comando al completar de ejecutarse.

ESO ES TODO :D!!!!

Pasos para trabajar localmente en el proyecto:

1. Instalar NodeJs > 5.0.0
2. Instalar Postgres

 2.1 Crear un usuario
 
  CREATE USER conexia WITH PASSWORD 'conexia';
  
 2.2 Crear la base de datos
 
  CREATE DATABASE conexia OWNER conexia;
  
 2.3
  \connect conexia

 2.4
 
  DROP SCHEMA public;
  CREATE SCHEMA public AUTHORIZATION conexia;

 2.5
 
  ALTER SCHEMA public OWNER TO conexia;

3. clonar el repositorio
4. dirigirse a la carpeta raiz del proyecto y ejecutar el comando: gradlew cleanEclipse eclipse compileJava
5. Abrir Eclipse IDE
6. importar el projecto como proyecto gradle ya existente, seleccionar la opción de traer proyectos anidados
7. Ejecutar el archivo MejorCocinaApplication, este arranca el servidor en el puerto 8080 local.
8. en la carpeta del repositorio: mejor-cocina-frontend, ejecutar el comando: ng serve
9. en navegador Chrome, dirigirse a la dirección que indique en alterior comando al completar de ejecutarse.

ESO ES TODO :D!!!!


