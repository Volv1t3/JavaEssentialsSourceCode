# Instalación del Entorno y Configuración de Materiales

<p>Esta sección te prepara para el inicio del curso. Con esto, veremos la instalación de nuestro IDE de confianza, IntelliJ IDEA Community Edition, así como la descarga de los archivos del curso y su carga en el entorno para que puedas trabajar con ellos. Asimismo, veremos cómo descargar una versión de la máquina virtual de Java, de un proveedor autorizado dentro del entorno.
<br/>
<br/>
Para cada una de estas secciones, la documentación ya incluye un hyperlink a cada una. Si todavía no has configurado nada de tu editor ni de tu entorno, es mejor que sigas todos los pasos.</p>

## Instalación del IDE

<p><format color="OrangeRed">OJO: </format> el video es un poco largo (lo siento), pero te muestro varios aspectos de Java rápidamente, asi como del entorno para que podamos 
empezar el curso el día indicado.
Si bien esto puede ser un poco tedioso, no tienes que verlo si prefieres instalar el programa a tu manera, o seguir la documentación adicional por 
debajo del video. De cualquier manera gracias por tu inscripción, ¡nos vemos en el curso!</p>

<video src="https://youtu.be/TXK_7zZgW4g"/>
<p>Para instalar el entorno podemos intentar trabajar de dos maneras: una descargándolo directamente desde la página de JetBrains o utilizando una herramienta de JetBrains llamada <code>JetBrains Toolbox</code>. Esta segunda opción nos permite descargar directamente el entorno en su versión <b>Community</b>, la cual es gratis para nuestro tipo de uso. Mientras que la opción de descargarlo a través del sistema de JetBrains involucra descargar <code>IntelliJ IDEA Ultimate</code>, el cual tiene un tiempo de uso gratis de 30 días.
<br/><br/>
Para este curso, por motivos de simplicidad de instalación, se opta por mostrar la forma de instalación del entorno a través de <code>JetBrains Toolbox</code>.</p>

<procedure>
<tabs>
<tab title="1. Instalar JetBrains Toolbox">
<p>Para instalar el programa de JetBrains que facilitará la instalación del entorno, debemos primero ingresar a nuestro navegador de confianza y seguir los siguientes pasos.</p>
<list style="decimal">
<li>
Una vez abierto nuestro navegador, nos dirigimos a la siguiente página web <a href="https://www.jetbrains.com/toolbox-app/">y descargamos el instalador del aplicativo</a>.
</li>
<li>Luego de la descarga, ejecutamos el instalador y hacemos clic en el botón indicado para instalar el programa.</li>
<li>Una vez instalado, el programa se abrirá automáticamente en la esquina inferior derecha de nuestra computadora y se quedará abierto en nuestra barra de tareas. En esta sección podemos ver todos los entornos de JetBrains que existen. (Claro está que algunos son de pago como CLion o IntelliJ IDEA Ultimate).</li>
</list>

<img src="https://www.jetbrains.com/toolbox-app/img/1_en-us.png"/>
</tab>
<tab title="2. Instalar IntelliJ IDEA">
<p>Instalar el entorno de desarrollo es incluso mucho más fácil que instalar JetBrains Toolbox. Para esto, lo único que debemos hacer es buscar el entorno dentro del listado de entornos disponibles.</p>
<list style="decimal">
<li>El entorno que buscamos debe, en su nombre, tener la palabra Community Edition. Si instalamos este entorno, entonces no tendremos problemas con tiempos de prueba y lo podremos usar en nuestro curso. Aunque no se espera que escriban código durante el curso, la capacidad de correrlo en su máquina es muy importante.

![ReferenciaDeIDEAInstalar.png](ReferenciaDeIDEAInstalar.png)
</li>
<li>El programa se encargará de descargar, instalar y configurar las dependencias necesarias para su funcionamiento en nuestro sistema de manera automática, procediendo a mostrarlo en el listado superior de entornos instalados una vez haya completado el proceso.
</li>
</list>
</tab>
</tabs>
</procedure>

<p>Una vez descargado el aplicativo, al abrirlo nos mostrará una pestaña simple con botones para abrir proyectos, crear proyectos o pestañas para modificar nuestro entorno antes de iniciar y añadir plugins externos. Aunque es recomendable configurar el editor e instalar ciertos plugins como <code>Amazon Q</code> para trabajo con inteligencia artificial, el foco de la siguiente sección será la instalación de un compilador en sí.</p>

## Instalación de una Distribución de la JVM

<p>La JVM, o Java Virtual Machine (entrando un poco en tema del curso), es el sistema en el cual se corre cualquier código escrito en Java. No se preocupen por comprender este tema en este momento, lo analizaremos más adelante en materia del curso. Simplemente es necesario comprender que para trabajar con Java <b>es necesario una JVM</b>.
<br/>
<br/> 
Gracias al desarrollo previo por JetBrains para sus IDEs, especialmente aquellos diseñados para una sola familia de lenguajes como es IDEA, la instalación de compiladores se puede hacer tanto al crear un nuevo proyecto como en uno ya iniciado en pocos pasos. A continuación, detallo ambos procesos por si acaso alguien ya se adentró a probar el entorno.</p>

<procedure>
<tabs>
<tab title="Instalar JVM en un Nuevo Proyecto">
<p>Generalmente, las JVMs que descarga IntelliJ se guardan dentro de tu sistema operativo, por lo que si descargamos una al crear un proyecto, podremos descargar otra fácilmente siguiendo estos pasos en el caso de requerir otra versión de Java para un proyecto.
<br/><br/>
Independientemente del proceso que se siga, el curso trabajará con la versión de Java 21, una versión probada y estable que se usa en las clases de estructuras de datos actualmente.</p>
<list style="decimal">
<li> Una vez abierto el entorno, hacemos clic en <code>crear un nuevo proyecto</code>, o alternativamente en <code>File -> New -> Project</code>. Luego de entrar en esta pestaña, tendremos un diálogo que se parecerá a este:
<img alt="DialogCreateNewProject.png" src="DialogCreateNewProject.png"/>
Con este diálogo abierto, podemos configurar varias opciones de nuestro proyecto, o en su caso, si solo queremos
descargar entornos, podemos dejar todo con los parámetros normales y modificar la sección de <b>JDK</b>.
</li>
<li> <p>La sección de <b>JDK</b>, como pudieron notar en mi caso, incluye ya un compilador de Amazon que tiene su 
propio SDK y la JVM de la distribución de Amazon para mi proyecto. En su caso, puede que aparezca sin ningún nombre o sin configuración.
<br/>
<br/>
En el caso de no tener un JDK seleccionado, su descarga es tan fácil como <code>JDK -> Download JDK </code>.
</p>
<img alt="JDKDownloadJDK.png" src="JDKDownloadJDK.png"/>
<p>
Y una vez desplegado este menú, entrar en la sección indicada para descargar una versión de JDK que necesitemos. El menú
es bastante intuitivo y permite seleccionar la versión, proveedor y la ubicación de descarga. En mi caso, siempre los
dejo en la ubicación por defecto para que cualquier proyecto los pueda encontrar, y en momentos de migración de datos
esto sea más fácil.</p>
</li>
<li>En la sección de Download JDK, seleccionamos los siguientes parámetros: Version=21, Vendor= Amazon Corretto 21.0.
5 y dejamos la ubicación de descarga en la normal del sistema, tal como se muestra en la imagen.
<img alt="JDKDownloadPage.png" src="JDKDownloadPage.png"/>
</li>
</list>
</tab>
<tab title="Instalar JVM en un Proyecto Existente">
<p>Si ya te adentraste dentro del entorno y aún no has instalado una JVM para tu proyecto, entonces puedes seguir los pasos detallados a continuación para su instalación.</p>
<list style="decimal">
<li> En la <b>esquina superior derecha</b>, hacemos clic izquierdo en el ícono de engranaje y buscamos la pestaña <code>Project Structure... o Estructura del Proyecto...</code>.
<img alt="ProjectViewOne.png" src="ProjectViewOne.png"/>
</li>
<li> Una vez dentro de este menú, en la primera pestaña encontraremos una opción titulada <code>Project</code>, donde uno de sus campos indica el SDK seleccionado en el sistema. En mi caso, como acabo de crear el proyecto, me aparece <b>NO SDK</b>.
<img alt="ProjectViewThree.png" src="ProjectViewThree.png"/>
Una vez en esta sección, realizamos el procedimiento usado en la creación de un proyecto. Ingresamos rápidamente
a <code>SDK -> Add SDK -> Download SDK </code> y seleccionamos los mismos parámetros para proveedor y versión (
Java 21 (21.0.5), de Amazon Corretto).
<img alt="ProjectViewFour.png" src="ProjectViewFour.png"/>
Una vez descargado, el proyecto se configurará con la versión actual del SDK, y las librerías incluidas aparecerán en la
esquina inferior izquierda de nuestro entorno, bajo el nombre de <code>external libraries</code>.
</li>
</list>
</tab>
</tabs>
</procedure>

<p>Independientemente del proceso de instalación tomado, el JDK se guarda dentro de nuestro sistema, lo que facilita su reuso para proyectos personales o para configurar nuestro entorno en la siguiente sección, cargando el proyecto.</p>

## Configuración del Material del Curso

<p>El material del curso que presentaremos en esta sección tiene que ver con los archivos fuente que se les proporcionará para su estudio futuro y referencia en la forma básica de trabajar con Java. En este sentido, el contenido está orientado a utilizar solo las librerías base de Java y solo requiere de una versión de Java igual a la versión usada para el desarrollo del proyecto o superior, es decir, podemos trabajar con estos archivos si tenemos Java 21 en adelante.
<br/><br/>
El proceso de carga del proyecto es sencillo y requiere simplemente de descargar el archivo .zip que contiene todo el material, descomprimir y cargar. Sin embargo, los pasos para este proceso se detallan a continuación también.</p>
<procedure>
<tabs>
<tab title="Configuración del Material">
<list style="decimal">
<li>En primera instancia, si no te llegó el correo con los archivos a tu correo, puedes encontrar el archivo .zip con los documentos del curso en el siguiente link <a href="https://estudusfqedu-my.sharepoint.com/:u:/g/personal/sarellanoj_estud_usfq_edu_ec/EaVx9xPw99JNp70EHoQbmqkB5lsP1A4Fdcwh9oP0xim4Xw?e=DQvSIw">y descargarlos</a>.</li>
<li>Una vez descargados los archivos y descomprimidos en una ubicación en tu computadora, puedes cargarlos en IntelliJ tanto desde la pestaña principal si no has creado ningún proyecto, o desde el entorno buscando la opción <code>File -> Open </code> y buscando la ubicación de los archivos. Luego de encontrarlos, simplemente los cargamos en el sistema y el proyecto debe configurarse casi automáticamente.<br/>
<format color="OrangeRed">Puede que en esta sección el programa indique que el SDK no está configurado. Si ya lo descargaste, sigue los mismos pasos detallados en la sección anterior, solo que no descargues el entorno, selecciona uno de los autodetectados por el IDE.</format>
</li>
<li>Con el archivo cargado en nuestro sistema y el SDK configurado para nuestro proyecto, puede que te solicite cargar un <code>Proyecto Maven</code>. En esta sección <b>es importante que permitas al sistema cargar el proyecto Maven</b>. Esta es una manera de compartir y manejar automáticamente código en Java a través de un Build System parecido a los de C++. No es necesaria ninguna acción adicional por tu parte, solo permitir que cargue.
</li>
</list>
</tab>
</tabs>
</procedure>
<p>Con el código cargado y el compilador configurado, podemos correr nuestro primer archivo de prueba <code>HelloJava.java</code>, el cual, además de introducir el formato de comentarios en el programa y los que se utilizarán en el curso, presenta un main fácil de correr que nos dará la información de nuestro compilador si este se configuró correctamente.
<br/><br/>
Una corrida en mi sistema produce el siguiente output:</p>
<procedure>
<p>Para el siguiente código del archivo <code>HelloJava.java</code>:</p>
<code-block lang="Java">
Hello World
A continuación se imprimen algunos de los valores conocidos 
de la JVM
Java Vendor Name = Amazon.com Inc.
Java Virtual Machine Name = OpenJDK 64-Bit Server VM
Java Version = 21.0.5

Process finished with exit code 0
</code-block>
<p>De aquí en adelante, trabajaré con este sistema, mostrando código y output en bloques diferenciables para el curso en su totalidad.</p>
</procedure>