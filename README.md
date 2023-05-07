<div align="left">
<h1><img src="https://github.com/Roberthdj/Hotel-Alura/blob/master/src/imagenes/Ha-100px.png" alt="hotel_alura" width="100" height="100"/>  FORO ALURA</h1> 
</div>

<hr>

<p align="center">
   <img src="http://img.shields.io/static/v1?label=STATUS&message=EN DESARROLLO%20&color=RED&style=for-the-badge" #vitrinedev/>
</p>

## Tópicos 

- [Descripción del proyecto](#descripción-del-proyecto)

- [Funcionalidades](#funcionalidades)

- [Aplicación](#aplicación)

- [Herramientas utilizadas](#herramentas-utilizadas)

- [Acceso al proyecto](#acceso-al-proyecto).

- [Abrir un proyecto local](#abrir-un-proyecto-local)

- [Desarrollado por](#desarrollado-por)

## Descripción del proyecto 

<p align="justify">
Este proyecto se desarrolla con la finalidad de llevar al campo práctico los contenidos estudiados durante el desarrollo del curso de formación Java del programa Oracle Next Education ONE.<br><br>
En el vamos a replicar a nivel de back end este proceso, y para eso crearemos una API REST usando Spring, nuestra API va a centrarse específicamente en los tópicos, y debe permitir a los usuarios:

- Crear un nuevo tópico
- Mostrar todos los tópicos creados
- Mostrar un tópico específico
- Actualizar un tópico
- Eliminar un tópico

Es lo que conocemos comúnmente como CRUD (CREATE, READ, UPDATE, DELETE) y es muy parecido con lo que desarrollamos en el Hotel Alura, pero ahora usando un framework que va a facilitar mucho nuestro trabajo un nuevo modelo de arquitectura de software conocido como REST.
</p>

* Sistema de autenticación de usuario para que solo usuarios pertenecientes al hotel consigan acceder al sistema.
* Permitir crear, editar y eliminar una reserva para los clientes.
* Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas.
* Registrar, editar y eliminar datos de los huéspedes.
* Calcular el valor de la reserva en base a la cantidad de días de la reserva y a una tasa diaria que puede ser asignada por ti y en la moneda local de tu país, por ejemplo, si tenemos una reserva de 3 días y el valor de nuestra diaria son 20$ debemos multiplicar esos 3 días por el valor de la diaria, lo que serían 60$, todo esto deberá ser hecho automáticamente y mostrado al usuario antes de guardar la reserva.
* Base de datos para almacenar todos los datos pedidos anteriormente.

## Funcionalidades
- <p align="justify"><strong>Funcionalidad 1: LOGIN</strong> <br>
   <p align="justify">Es el primer formulario con el que te encuentras al iniciar la aplicación, en el debes engresar un usuario y contraseña validos y te enviara al      menu de usuario donde encontraras las opciones para ingrsar al sistema de reservas o al sistema de busquedas.
   </p>
</p>

- <p align="justify"><strong>Funcionalidad 2: SISTEMA RESERVAS</strong> <br>
   <p align="justify">Se encarga de crear una nueva reserva en él se ingresan las fechas de CHECK-IN y CHECK-OUT ya sea eligiéndola del desplegable o manualmente          teniendo en cuenta el formato ‘yyyy-mm-dd’, también muestra el tipo de habitación y la forma de pago mediante listas desplegables, el valor a pagar por la reserva      se generará de forma automática al seleccionar la fecha de CHECK-OUT la cual debe ser mayor o igual a la fecha de CHECK-IN.
   </p>
</p>

- <p align="justify"><strong>Funcionalidad 3: REGISTRO HUESPED</strong> <br>
   <p align="justify">Al generarse una nueva reserva en esta se genera un identificador de forma automática, el cual es trasferido al REGISTRO HUESPED y se muestra        como Número de reserva, el usuario del sistema debe completar todos los campos restantes y confirmar la creación de la reserva, si se sale de REGISTRO HUESPED a        otro formulario o termina la ejecución del programa mediante el botón salir la reserva creada se eliminará de forma inmediata.
   </p>
</p>

- <p align="justify"><strong>Funcionalidad 4: SISTEMA DE BUSQUEDA</strong> <br>
      <p align="justify">Aquí se realizan las búsquedas usando como criterio de búsqueda el número de reserva para las reservas y del apellido para los huéspedes,           también es posible eliminar un registro de cualquiera de las opciones existentes seleccionando el registro y haciendo clic en el botón eliminar, para editar se         debe hacer doble clic en el campo del registro que se desee editar ingresar la nueva información y hacer clic fuera de la celda, pero dentro del registro,             luego de esto hacer clic en el botón editar.
      </p>
</p>

## Aplicación

<div align="center">

  <img src="https://github.com/Roberthdj/Hotel-Alura/blob/master/img-readme/Reserva.png" alt="netbeans" width="350" height="250"/>
  <img src="https://github.com/Roberthdj/Hotel-Alura/blob/master/img-readme/Huesped.png" alt="netbeans" width="350" height="250"/>
  <img src="https://github.com/Roberthdj/Hotel-Alura/blob/master/img-readme/Busqueda.png" alt="netbeans" width="350" height="250"/>  

</div>

###

## Herramentas utilizadas

- <a href="https://www.java.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> --> Ver. 19.0.1</a> 

- <a href="https://netbeans.apache.org/" target="_blank"> <img src="https://netbeans.apache.org/images/apache-netbeans.svg" alt="netbeans" width="40" height="40"/> --> NetBeans IDE 14</a>

- <a href="https://www.mysql.com/" target="_blank"> <img src="https://www.mysql.com/common/logos/logo-mysql-170x115.png" alt="netbeans" width="40" height="40"/> --> Ver. 8.0.32</a>

###

## Acceso al proyecto

Tu puedes acceder al [codigo fuente](https://github.com/Roberthdj/Hotel-Alura) del proyecto o descargar sus [etapas](https://github.com/Roberthdj/Hotel-Alura/tags) de desarrollo.

## Abrir un proyecto local

Para correr `Conversor Alura`en tu máquina local:

- Crea un nuevo proyecto de nombre ConvertidorAlura en el IDE que estes usando para trabajar, "asegurate de no crear un Main Class"

- Abre una terminal de git en la ubicacion donde se aloja el nuevo proyecto que creaste

- Inicializa el proyecto en la teminal con la linea: git init

- Conectate al repositorio remoto con la linea: git remote add origin https://github.com/Roberthdj/Hotel-Alura.git

- Luego la linea: git remote -v

- Finalmente ejecuta la linea: git pull origin master

Si todo va bien, tu nuevo proyecto se sincronizo correctamente con el repositorio!

### 
      Utilizando Mysql se debe crear la base de datos, solo se debe ejecutar el script hotel.sql que se encuentra en sqlDatabase, 
      para ingresar a la aplicación se utiliza uno de los dos usuarios creados con el script.
      
      Usuario:    admin
      Contraseña: admin

      Usuario:    usuario1
      Contraseña: 123456  

## Desarrollado por

[<img style ="border-radius: 20px" src="https://avatars.githubusercontent.com/u/120141795?s=400&u=1224e7aef9eef9f87a1598bd2168761487581ef4&v=4" width=115><br><sub>Roberth de Jesus Rodriguez Castro</sub>](https://github.com/roberthdj)
