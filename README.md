
---

   <h1>
      <img src="./readme-img/Inicio.png" alt="Foro alura" width="100" height="100"/>
      <p align="left">FORO ALURA</p>
      <p align="right">
         <img src="http://img.shields.io/static/v1?label=STATUS&message=EN DESARROLLO%20&color=RED&style=for-the-badge" #vitrinedev style="border-radius:25px"/>
      </p>
   </h1>

---

## Tópicos

- [Descripción del proyecto](#descripción-del-proyecto)

- [Funcionalidad](#funcionalidad)

- [Software de desarrollo](#software-de-desarrollo)

- [Codigo fuente](#codigo-fuente)

- [Abrir localmente](#abrir-localmente)

- [Desarrollado por](#desarrollado-por)

---

## Descripción del proyecto

<p align="justify">
Este proyecto se desarrolla con la finalidad de llevar al campo práctico los contenidos estudiados durante el desarrollo del curso de formación Java del programa Oracle Next Education ONE.
<br>
<br>
Crearemos una API REST usando Spring boot, nuestra API estará compuesta por tópicos sobre un curso específico, estos tópicos, así como las respuestas a estos serán creados por usuarios registrados.
<br>
<br>
Básicamente la funcionalidad de la API está basada en realizar un CRUD que se podrá realizar a cada entidad creada y que funciona así:

* Crear un nuevo registro.
* Mostrar todos registros.
* Mostrar un registro específico.
* Actualizar un registro.
* Eliminar un registro.

También contará con búsquedas personalizadas como:

* Búsqueda de un tópico por id de un curso.
* Búsqueda de un tópico o respuesta por id de un autor.
* Búsqueda de una respuesta por id de un tópico.
</p>

## Funcionalidad

<p align="justify"> Foro-Alura consta de cuatro entidades (Usuario, Curso, Topico, Respuesta) en las cuales podemos realizar acciones CRUD y en algunas de ellas búsquedas personalizadas, para esto contaremos con endpoints específicos que se encargaran de registrar las informaciones requeridas o simplemente ejecutar la acción necesaria, para una mejor comprensión se hace uso de Swagger para documentar la API.
<br>
<br>
<strong>Puesta en marcha</strong>

* Dar inicio al servidor de Spring boot.
* Ingresar en http://localhost:8085/doc/swagger-ui/index.html#/
* Abrir autenticacion-controller y generar el token para autenticarse ingresando usuario y contraseña como se muestra a continuación.
```json
{
   "nombre": "admin",
   "contrasena": "admin"
}
```
<div align="center">
<img src="./readme-img/token-generado.png" alt="Token generado" width="800" height="300"/>
</div>

* Buscar el botón authorize en la esquina superior derecha de la página e ingresar el token generado en autenticacion-controller.

<div align="center">
<img src="./readme-img/autenticacion.png" alt="Token generado" width="800" height="300"/>
</div>

*  Una vez autenticado podras usar cualquiera de los endpoints generados.
</p>

## Software de desarrollo

   |<a href="https://www.java.com" target="_blank"> <img src="./readme-img/JDK.svg" alt="JDK17-Java" width="100" hspace="10" vspace="10"/><strong>JDK 17.0.6</strong></a>|<a href="https://netbeans.apache.org/" target="_blank"> <img src="./readme-img/netbeans.svg" alt="NetBeans" width="60" hspace="25"/><strong>NetBeans IDE 14</strong></a>|<a href="https://plugins.netbeans.apache.org/catalogue/?id=4" target="_blank"> <img src="./readme-img/spring-boot.png" alt="NB SpringBoot" width="100" hspace="25" vspace="10"/><strong>NB SpringBoot</strong></a>|
   |------|------|------|
   |<a href="https://www.mysql.com/" target="_blank"> <img src="./readme-img/MySQL-.png" alt="MySql" width="70" hspace="25" vspace="10"/><strong>MySQL 8.0.32</strong></a>|<a href="https://swagger.io/" target="_blank"> <img src="./readme-img/Swagger.png" alt="Swagger" width="80" hspace="20" vspace="10"/><strong>Swagger</strong></a>|<a href="https://www.postman.com/" target="_blank"> <img src="./readme-img/postman.svg" alt="Postman" width="90" hspace="10" vspace="10"/><strong>Postman</strong></a>|

## Codigo fuente

   Foro-Alura esta desarrollado en java implementando Spring Boot.

   * [Repositorio](https://github.com/Roberthdj/Foro-Alura)
   * [Descargar Spring-01](https://github.com/Roberthdj/Foro-Alura/archive/refs/tags/foroAlura-Spring01.zip)
   * [Descargar Spring-02](https://github.com/Roberthdj/Foro-Alura/archive/refs/tags/foroAlura-Spring02.zip)

## Abrir localmente

Para correr Foro-Alura en tu máquina local:

* Determina donde quieres alojar el proyecto y clonalo en la ubicacion escojida:
   * git clone https://github.com/Roberthdj/Foro-Alura.git

* Con el IDE de tu preferencia procede a abrir el proyecto.
```
Netbeans.
1. Abrir el proyecto.
2. Dar click en el icono Clean and Build (Shift+F11) de la barra de herramientas o buscar en la barra de menú: 
      Run -> Clean and Build (Shift+F11) 
3. Verificar que este configuarada la clase main: 
      Run -> Set Project Configuration -> Customize -> Run -> MainClass

```
---

## Desarrollado por
[<img src="https://avatars.githubusercontent.com/u/120141795?v=4" width=125><br><sub>Roberth de Jesus Rodriguez Castro</sub>](https://github.com/roberthdj)

---
