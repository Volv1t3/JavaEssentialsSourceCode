# Java VS C++

> Ahora que tenemos nuestro sistema configurado, es importante tomarnos un tiempo para detallar algunas distinciones
> importantes que podemos hacer de Java en comparación con C++, un lenguaje que han estudiado hasta el momento. <br/>
> En este sentido, este documento tiene el objetivo de detallar una serie de beneficios que Java tiene sobre C++ en el
> desarrollo de software.

<p>
Java y C++ son ambos lenguajes de alto nivel desarrollados con el fin de, con diversos puntos a favor y en contra, mejorar la experiencia del programador y facilitar el desarrollo en varios campos.
Por su parte, C++ se ha convertido en un lenguaje fuertemente usado en aplicaciones de tiempo real, que requieren un manejo de recursos limitado y controlado, etc.
C++ ha sido utilizado en videojuegos, sistemas embebidos, desarrollo de sistemas operativos, motores gráficos y software de alto rendimiento en general.
<br/>
<br/>
Por su parte, Java es un lenguaje multiplataforma, autocontenido y eficiente, cuyo manejo de recursos y sistema de memoria y ejecución le han permitido pasar a ser una aplicación de uso estándar en áreas como el desarrollo de backend web, aplicaciones de nivel empresarial, aplicaciones de escritorio, bases de datos e, inclusive, en aplicaciones de alto rendimiento como es el IDE en el que desarrollamos el curso.
La familia de lenguajes, frameworks, aplicativos y proyectos desarrollados en Java es extensa y cuenta con librerías para trabajo desde consola hasta inteligencia artificial.
<br/><br/>
Sin duda, ambos lenguajes tienen sus fortalezas.
También es importante admitir que ambos tienen falencias, pero para fines educativos, sin duda, Java es mucho más amigable y facilita el trabajo en cursos como son los de estructuras de datos.
</p>

## Cuadro comparativo entre Java y C++ por aspecto

<p>
Sin lugar a duda, existen dos bandos entre ambos lenguajes.
Existen quienes consideran que la simplificación que hace Java oscurece el trabajo interno del computador y nos separa de la máquina, abstrayendo la forma de trabajar con el sistema operativo de la máquina.
Pero también existen aquellos que consideran esto un aspecto positivo, dado que reduce los puntos de error humano que pueden tener las aplicaciones desarrolladas en Java.
En fin, discutir esto puede ser el tópico de una charla entera, pero en nuestro caso nos quedaremos con el siguiente cuadro comparativo. 
</p>
<procedure>
<table>
<tr>
    <th><b><format color="CornflowerBlue">Comparativa</format></b></th>
    <th><b><format color="CornflowerBlue">C++</format></b></th>
    <th><b><format color="CornflowerBlue">Java</format></b></th>
</tr>
<tr>
    <td>Manejo de Memoria</td>
    <td><list columns="1"><li>
    <p>Sin duda, uno de los problemas más graves en C++ hasta las versiones superiores como 18, 20 o 23.</p>
    </li>
    <li><p>En C++, la misma apertura que tiene el lenguaje para el manejo de memoria dinámico y manual puede incrementar la posibilidad de errores de lógica y estructura que dejen a nuestro programa abierto a actores maliciosos.</p></li>
    <li>El manejo de memoria puede aumentar el nivel de complejidad de una aplicación, aumentando el tiempo de desarrollo.</li>
    </list></td>
    <td><list>
    <li>
    <p>En Java, el manejo de memoria está bloqueado por el sistema de ejecución, la JVM.
Es decir, los programas en Java usualmente no trabajan con memoria preasignada como es el Stack, ya que la JVM utiliza memoria de tipo Heap para guardar casi todo lo que escribimos en Java.</p>
    </li> 
    <li>En Java, además de su entorno de ejecución aislado de la memoria principal del computador, el lenguaje en sí cuenta con un <code>Garbage Collector</code> que se encarga de limpiar cualquier objeto sin uso, liberando memoria.</li>
    </list></td>
</tr>
<tr>
    <td>Portabilidad</td>
    <td><list>
    <li>
    <p>C++ no es un lenguaje portable por naturaleza.
Al ser un lenguaje compilado y al pasar por una etapa de <code>linking</code>, los programas de C++ forman un nexo con el sistema operativo en el formato de sus ejecutables.</p>
    </li>
    <li>
<p>Como C++ depende de los ejecutables del sistema operativo en donde se corran, estos se vuelven inservibles en otro sistema, forzando a los usuarios a usar archivos intermedios <b>.o</b> para lograr una transferencia de información.</p></li>
    <li><p>Dado esto, para hacer que una aplicación en C++ sea transferible se requiere crear un <b>instalador para un sistema operativo</b>.</p></li>
    </list>
    </td>
    <td>
    <list>
    <li><p>Java, por defecto, es un lenguaje que tiene dos pasos: interpretación y compilación. Por tanto, los archivos de Java pueden ser compartidos en su etapa intermedia <code>(los archivos .class)</code>, los cuales pueden ser ejecutados por cualquier máquina virtual de Java (JVM) en cualquier sistema operativo.</p></li>
    <li><p>Generalmente, a Java se le conoce como el <code>Compile Once - Run Anywhere</code> language, dado su facilidad para generar código intermedio, transferible y fácilmente interpretable.</p></li>
</list>
    </td>
</tr>
<tr>
    <td>Entorno Empresarial</td>
    <td><list>
    <li><p>Aunque C++ cuenta con un gran número de librerías tanto de la comunidad, empresariales, así como algunas producidas por organizaciones, la forma de trabajar con estas es complicada.
Puede ser que la librería te pida que compiles tú mismo su código, usando herramientas como <code>CMake o Make</code>, o puede proporcionarte los <code>.o</code>.
</p></li>
<li><p>Adicionalmente, el trabajo con build systems y package managers en C++ es complicado, ya que no existe un estándar más allá del sistema <code>VCPKG</code> de Microsoft, el cual no tiene un soporte tan amplio y funciona mucho mejor con sus entornos.
</p></li>
</list></td>
<td><list>
<li>En Java, el trabajo con paquetes externos está centralizado y regulado por organizaciones como Apache, OpenJDK, Gluon, etc., las cuales se encargan de estandarizar librerías para Java.
Package managers como Maven o Gradle han sido desarrollados y tienen funcionalidades a la par con NPM para JavaScript o PIP para Python. 
</li>
<li>Java, al ser un lenguaje preferido por la industria, tiene una gran cantidad de librerías desarrolladas por empresas de software mundiales, como Amazon, IBM, Google, Meta, etc.
Estas librerías facilitan el trabajo con varios servicios como la nube, pruebas unitarias, etc., así como el desarrollo de aplicaciones a nivel industrial.</li>
</list></td>
</tr>
<tr>
<td>
Programación Orientada a Objetos
</td>
<td><list>
<li>
<p>
C++ se destaca por ser un lenguaje multiparadigma que, además de la programación orientada a objetos, permite combinar estilos como la programación funcional y la programación estructurada.
Sin embargo, esta flexibilidad en ocasiones puede introducir complejidad en los diseños orientados a objetos, ya que el lenguaje no obliga a los desarrolladores a seguir estrictamente este paradigma, lo que puede llevar a la mezcla de enfoques en un mismo proyecto.
</p>
</li>
<li>
<p>
La ausencia de un sistema de recolección automática de memoria (<code>Garbage Collection</code>) como en otros lenguajes puede dificultar la gestión de objetos en C++.
Los desarrolladores deben preocuparse explícitamente por asignar y liberar memoria para los objetos, lo que puede derivar en problemas comunes como fugas de memoria (<i>memory leaks</i>) o errores de referencia a memoria liberada (<i>dangling pointers</i>), complicando aún más los diseños orientados a objetos.
</p>
</li>
</list></td>
<td><list>
<li><p>
En el caso de Java, su diseño original, y todas las mejoras que han venido desde sus primeras versiones, se han manejado en un formato de <code>programación orientada a objetos</code>.
En Java, es muy común ver que las clases que uno ve como básicas son objetos cuya estructura jerárquica es mucho más grande de lo que fácilmente se ve.
</p></li>
<li>Java en sí tiene todo un entorno de clases, keywords y componentes que facilitan increíblemente el desarrollo de aplicaciones orientadas a objetos, a través de sus jerarquías de clases, modularidad y compartimentalización de datos en nuestras clases.
A la hora de ver los archivos, notaremos que todo en Java es un objeto, y todo archivo es un descriptor de una clase. 
</li>
</list></td>
</tr>
<tr>
<td>Origen</td>
<td>C++ surge como una idea de un Superset de C, bajo el nombre original de "C with classes", este lenguaje estaba 
basado fuertemente en Simula, un lenguaje de programación orientado a la simulación. El trabajo en C++, desarrollado 
por <code>Bjarne Stroustrup </code> inicio en el año 1979 hasta el año 1985 cuando fue publicado como 
lenguaje comercial.
</td>

<td> Java surge como un proyecto interno en la empresa Sun Microsystems (cuyo aporte al lenguaje todavía se puede 
notar en algunas librerías de Java!) con el objetivo de diseñar un lenguaje con la capacidad de ser utilizado en 
dispositivos digitales como televisiones. El desarollo del lenguaje comenzó en el año 1991 por 
<code>James Gosling, Mike Sheridan y Patrick Naughton</code>. Este equipo de ingenieros de Sun diseño en 
primera instancia el lenguaje para sistemas embedidos, pero su  desarrollo fue tal que se convirtió en un lenguaje 
multiparadigma rápidamente, teniendo su primera version en 1996.
</td>
</tr>
</table>
</procedure>
<p>Una vez descritas una de las características más destacables de Java y su clara diferencia con C++, es momento de adentrarnos en el lenguaje y sus características.
El resto de esta sección incluye un análisis a la par de lo que se ve en un curso base de C++. 
<br/><br/>
Bienvenidos a Java!
</p>