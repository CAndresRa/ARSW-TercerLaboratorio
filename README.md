# Manejo de sockets y servidores web

### Autor: Carlos Andrés Ramírez Torres
### Fecha: Miercoles, 10 de Junio del 2020
##### LOC/h: 2390/24 = 183.84 LOC/h

## Uso 

Para el desarrollo del proyecto se utilizo **Maven** como una herramienta para la construccion y gestion del mismo, el codigo fue desarrollado con el lenguaje de programación **Java**.

Utilizar `mvn package` para la generacion del fichero .jar con los .class compilados.

![Texto alternativo](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/build%20MVn.png)

Una vez realizado el `mvn pacakge` el codigo estara listo para ser utilizado bajo la siguiente estructura.

Existen 5 casos de uso para la ejecución del proyecto, los cuales son:

 * **Manejo de URL:** Permite reconocer y obtener detalladamente las parter principales de una Url.
 
 Para ejecutar este programa se debe realizar el siguiente comando en la terminal:
 
 `java -cp target/classes edu.escuelaing.arsw.app.App.urlManager.URLManager <URL>`
 
 por ejemplo:
 
 ![Texto alternativo](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/urlControl.png)
 
 * **Generador de archivos .html a partir de una URL:** mediante la Url de un sitio web, se escribe un archivo html que es guardado en directorio de resources del proyecto.
 
 * **Comunicacion Cliente - Servidor elevar al cuadrado:** Mediante el uso de sockets se establece una conexion cliente servidor, donde el cliente ingresa un numero, el cual es respondido por el servidor con la potencia del mismo, 
 Para ejecutar este programa se debe realizar el siguiente procedimiento:
 
    * Abrir dos terminales en el equipo.
  
    * Primera terminal: Ejecutar el siguiente comando 
    `java -cp target/classes edu.escuelaing.arsw.app.App.pow.EchoServerPow` 
    para inicializar el servidor.
  
    * Segunda terminal: Ejecutar el siguiete comando 
    `java -cp target/classes edu.escuelaing.arsw.app.App.pow.EchoClientPow` 
    para iniciar la conexion con el servidor.
  
Por ejemplo:
  
 ![Texto alternativo](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/Elevar%20al%20cuadrado%20Uso.png)
 
* **Comunicacion Cliente - Servidor Funciones Trigonometricas:** Mediante el uso de sockets se establece una conexion cliente servidor, donde el cliente puede seleccionar el tipo de funcion trigonometrica entre **Seno, Coseno y tangente** utilizando el comando **fun:sin, fun:cos, fun:tan** respectivamente, y enviando numeros para la evaluacion correspondiente por parte del servidor.

    * Abrir dos terminales en el equipo.
  
    * Primera terminal: Ejecutar el siguiente comando 
    `java -cp target/classes edu.escuelaing.arsw.app.App.trigonometricFunctions.EchoServerTrigonometric` 
    para inicializar el servidor.
  
    * Segunda terminal: Ejecutar el siguiete comando 
    `java -cp target/classes edu.escuelaing.arsw.app.App.trigonometricFunctions.EchoClientTrigonometric` 
    para iniciar la conexion con el servidor.

Por ejemplo:

![](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/Uso%20fun%20tri.png)

* **Servidor Web: Mostrar archivos existentes en el servidor:** Mediante una solicitud **GET** al servidor, se espera que retorne el archivo solicitado mediante el **path** de en la **url** del servidor, existen dos tipos de archivos en el servidor los cuales tienen la extension **.html** e imagenes de tipo **.png**.
   
Para iniciar el servidor web se debe realizar el siguiente comando desde la terminal del equipo:

`java -cp target/classes edu.escuelaing.arsw.app.App.httpServer.HttpServer`

Por ejemplo:

![](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/Uso%20http.png)

## Diagrama

![Texto alternativo](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/diagrama.png)

El diagrama muestra que un servidor web **HttpServer** es el encargado de habilitar el **localhost:35002** del mismo, mediante el browser se recibiran solicitudes de tipo **GET** y sera el encargado de responderlas con ayuda de la implementación en el back de la aplicación, el servidor web **HttpServer** crea una instancia de la clase concreta **BrowserService** la cual tendrá como finalidad instanciar el objeto solicitado por el cliente, mediante el uso de la interfaz **FileBrowser** que esta implmentado por las clases **HtmlFile** y **PngFile** que determinaran el retorno corresponiente de la solicitud del cliente.

## Pruebas de aceptación

* **Manejo de URL:**
![](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/urlControl.png)
* **Generador de archivos .html a partir de una URL:** 
![]()
* **Comunicacion Cliente - Servidor elevar al cuadrado:**
![](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/Uso%20y%20prueba%20de%20elevar%20al%20cuadrado.png)
* **Comunicacion Cliente - Servidor Funciones Trigonometricas:**
![](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/Uso%20y%20pruebas%20fun%20tri.png)
* **Servidor Web: Mostrar archivos existentes en el servidor:**
    * Prueba archivo **PNG**
   
    ![](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/java%20prueba.png)
    * Prueba archivo **.HTML**
    ![](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/pruebaHTML.png)
    * Prueba de **Archivo no encontrado**
    ![](https://github.com/CAndresRa/ARSW-TercerLaboratorio/blob/master/ImgReadme/PruebaNotFound.png)

 
