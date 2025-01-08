# Bases del Lenguaje

> En este documento, vamos a revisar algunas de las bases teóricas requeridas para comprender el código que
> revisaremos en secciones posteriores.
> En general, el contenido que analizaremos en esta sección es puramente
> teórico hasta próximas secciones.
> No obstante, es importante conocerlo, ya que los IDEs de Java trabajan mucho con
> estándares de Java conocidos.

<p>Java es uno de los lenguajes con más aceptación e impacto a nivel mundial. Su aplicabilidad en la industria y el 
desarrollo que ha tenido durante sus años en el mercado han llevado a que se creen, desde su concepción, varios 
estándares de trabajo. Y, así como en C++, paradigmas y normas del lenguaje que se mantienen y forman parte de la 
base técnica del lenguaje.
<br/>
<br/>
En este sentido, normativas como la declaración de variables, tipos de dato, nombramiento de archivo, manejo de 
objetos, modificadores de acceso, entre otras características, requieren un poco de atención previo al trabajo 
directo con código.
</p>

## Módulos y Paquetes

<p>
Uno de los fuertes de Java a comparación con C++ (y una característica que ha sido planteada como añadidura 
necesaria en nuevas versiones de C++), es su modularización de código explícita, que fue implementada en la versión 
9 de Java. La modularización de código en Java permite agrupar código relativamente relacionado entre sí en una caja,
un grupo de clases y recursos que definen una API pública y una serie de clases que se abren al exterior del paquete.
<br/>
<br/>
En otras palabras, <i>los módulos de Java son un sistema de agrupación de recursos, clases y descriptores que 
permiten aislar código. Para esto, se utilizan APIs que permiten la comunicación del exterior con ciertas partes del 
módulo mas no todo.</i>
<br/><br/>
Dentro de esta estructura existen varios tipos de archivos adicionales que se utilizan para hacerla funcionar. Si 
exploran su IDE podrán encontrar nociones de estos como <code>Package-info.java o Module-info.java </code>, archivos 
que se pueden crear en el entorno para facilitar el trabajo con estas estructuras.
<br/><br/>
No obstante, la base necesaria para el trabajo de Java en un curso como este, o en un curso de estructuras de datos 
son los <code>Packages</code>.
</p>

### Packages

<p>Los paquetes se definen como <i>grupos de tipos relacionados, los cuales facilitan el manejo de nombres, reducen la 
probabilidad de conflictos de nombres, violaciones de acceso, etc. 
</i> Estas agrupaciones pueden contener diferentes clases, interfaces, anotaciones, enumeraciones. 
<br/><br/>
Podemos pensar fácilmente en los namespaces de C++, o en su defecto en una caja. Una caja puede contener varios 
objetos (algo así como un Vector), pero estos objetos no siempre tienen que ser del mismo tipo. Por ejemplo, un 
paquete puede contener dos clases distintas <code>ClassA.java y ClassB.java</code>, sin ningún problema, e inclusive 
si otro paquete tiene una clase <code>ClassB.java</code>, al tener dos paquetes los problemas de los nombres se 
eliminan. Consideremos esto:
</p>
<procedure>
<p>En Java podemos tener dos paquetes</p>
<code-block lang="Markdown">
    Package PackageOne;
        |-> Class A;
        |-> Class B;
    Package PackageTwo;
        |-> Class B;
</code-block>
<p>Si tenemos este tipo de estructuras, para Java no es un problema que existan dos clases con el mismo nombre, ya 
que el simple hecho de que tengan un paquete diferente las diferencia a nivel de compilación, lo que nos facilita el 
trabajo con clases iguales (Claro está que esto tampoco es recomendado).
</p>
</procedure>
<p>Para declarar paquetes en Java basta con haber creado un proyecto con IntelliJ. Estos son obligatorios ya que 
nuestro programa siempre crea un módulo base para nuestro proyecto con el nombre indicado en la pestaña de creación 
de un proyecto. <format color="OrangeRed">OJO: no todos los profesores trabajan con este sistema, si tomas 
clases con Fausto Pasmay, no utilices paquetes en tu trabajo, escribe todo en el paquete general.</format>
<br/>
<br/>
Con ese disclaimer fuera del camino, podemos escribir nuestro primer paquete.</p>
<procedure>
<p><format color="CornflowerBlue">Primer Paquete con una clase</format></p>

```Java
package com.eVolvLabs.I_JavaLangBasics;

public class Main{
    public static void main(String[] args){
        System.out.println("Hello From Package" +
                            "I_JavaLangBasics!");
    }
}
```

<p>Luego de haber mostrado este ejemplo, es importante escribir algunas de las normas básicas del trabajo con 
Paquetes</p>
<list style="alpha-lower">
<li><b><format color="CornFlowerBlue">Nombramiento de Paquetes</format></b>: <p>Los paquetes en producción se 
escriben con su nombre en minúsculas, usualmente con el dominio de la compañía al revés en minúsculas (e.j. 
com.eVolvLabs ...
<br/><br/>
Si el nombre incluye menciones a tipos de datos de Java, como int, o caracteres ilegales como '-' o números, se debe 
remplazarlos
con un '_' y luego escribir el nombre original.
</p></li> 
<li><b><format color="CornFlowerBlue">Colisiones de Paquetes</format></b>: <p>Si el nombre de un paquete colisiona con otro, los nombres deben ser ajustados por el desarrollador. El lenguaje no permite colisiones de este tipo dentro del sistema,
solo clases con el mismo nombre en diferentes paquetes.</p></li> 
<li><b><format color="CornFlowerBlue">Formato de Importe</format></b>: <p>Al importar una clase o un grupo de clases,
o inclusive <code>al definir una clase dentro de un paquete</code>, la línea que declara el paquete 
debe ser la primera en aparecer. <br/><br/>
Por otro lado, al importar de un paquete, ya sea una clase o varias, se debe escribir todo el nombre desde la base 
del paquete. Por ejemplo, en nuestro código tendríamos:
</p>
<procedure>
<code-block lang="Java">
package com.evolvlabs.I_JavaLangBasics;
/*Esta línea define el paquete, siempre al inicio del archivo*/

/*Ejemplo de importe de datos vemos que si lo leyéramos en
otro sentido sería
https://evolvlabs.com/IV_Extras/Colorizer */
import com.evolvlabs.IV_Extras.Colorizer;
/*Esta línea importa todos los archivos dentro del paquete java.util*/
import java.util.*;

public class Main{
public static void main(String[] args){
/*En el código podemos usar esta clase */
System.out.println(Colorizer
.color("A continuación se imprimen algunos de los valores conocidos de la JVM",
Colorizer.Color.GREEN_BOLD));

    }

}```
</code-block>
</procedure>
<p>No es necesario preocuparse de estos conceptos en este momento, veremos ejemplos más adelante del formato de 
importe.</p>
</li> 
<li><b><format color="CornFlowerBlue">No existe Jerarquía de Paquetes</format></b>: <p>Si bien en algunos casos, el 
formato de importe usado en Java podría dar a parecer que existen jerarquías dentro de paquetes, estos formatos de 
importe solo determinan una relación entre paquetes, como por ejemplo aquellos dentro de Java.util en donde Java.util es un paquete y Java.util.Stream es otro muy diferente.</p></li> 
</list>
</procedure>

## Everything-as-an-Object

<p>En Java, como pudieron haber notado por el simple hecho de la definición de los códigos anteriores, 
<code>todo es un objeto</code>. Desde el código que escribo en un archivo main, a la clase System que se usa 
para imprimir algo a la consola, hasta el propio archivo donde se escribe el código que corre el otro código, que 
llama a más código, etc! 
<br/><br/>
Aunque parezca confuso en un principio, la forma de trabajar de Java es muy clara, estructurada y comprensible una 
vez que estudiamos el porqué de este hecho. Todo en Java es una clase por el hecho de que se haya diseñado como un 
lenguaje orientado a objetos desde su inicio, es decir, el lenguaje no fue diseñado como en C++ para soportar 
archivos simples con un main y su estructura. Para Java, la estructura de los archivos es importante, como se 
menciona en su definición</p>
<procedure>
<i>The Java Programming language is a general-purpose, concurrent, class-based, object-oriented language[...]</i>
</procedure>
<p>Adicionalmente, Java fue diseñado para tolerar definiciones al mismo tiempo qué prototipos, es decir, en el mismo 
archivo uno define el nombre y el cuerpo de una clase, método o variable. No existen los dobles archivos como en C++,
lo que facilita el control de archivos, compilación JIT, y organización.
<br/><br/>
En Java, cada archivo define una clase cuyo nombre tiene que ser exactamente el mismo del archivo para que este sea 
detectado por el compilador y manejado correctamente. <code>Si bien se pueden declarar clases adicionales 
(como privadas) en el mismo archivo, esta práctica no se recomienda a menos que puedan ser implementadas como clases 
internas.
</code>
</p>
<p>Con base en estos datos, surge la duda de entonces cómo realmente funciona el lenguaje, ya que si estamos 
escribiendo una clase, ¿por qué puede correr un main que es un método dentro de una clase? No tenemos un programa 
cliente para esta clase. 
<br/><br/>
Lo cierto es que, si bien no existe este programa cliente, una clase para que pueda ser ejecutada independientemente 
de otros archivos, debe tener entre sus métodos un método con un prototipo singular <code>public static 
void main(String[] args)</code>, el cual le dice al compilador que esta clase tiene un método main que puede ser 
llamado por él para correr el código contenido en este bloque.
</p>
<procedure>
<i>No es necesario tener un main en todos los archivos de Java (en los de esta sección siempre hay uno para poder 
ver que sucede con el código escrito). Otras clases no presentarán este método. <br/><br/>
<format color="OrangeRed">No obstante, si se planea correr por consola cualquier archivo, <b> <format color="OrangeRed">debe 
existir un main</format></b></format></i>
</procedure>
<p>Adicionalmente, es importante destacar que todo lo que nosotros tomamos como un archivo header más en C++, tiene 
su equivalente en una clase dentro de Java. Por ejemplo, el manejo de consola se realiza con la clase 
<code>System</code>, dentro de la cual <code>.in, .out, .err </code> son instancias de <i>otras clases</i> 
que permiten al programa leer de y escribir hacia la consola. A lo largo del curso notaremos que casi todo en Java 
requiere una clase específica o una combinación de varias.</p>

## Lenguaje Fuertemente Tipado

<p>Java es lenguaje cuya propia especificación lo especifica como un lenguaje fuertemente tipado, desde variables 
hasta tipos de retorno, parámetros para genéricos, parámetros de funciones hasta el tipo de un archivo (class, 
interface, abstract class, enum, etc.) son requeridos por el lenguaje en cualquier declaración que se realize. 
<br/><br/>
Esto se da porque el lenguaje realiza un compile-time type check dado que requiere estos tipos durante la 
escritura del código. De esta manera, el lenguaje se defiende de errores de tipos durante ejecución a través de sus 
requerimientos de escritura de tipos.<br/><br/>
En java existen ciertos datos importantes a destacar sobre la utilización de tipos en el lenguaje</p>
<procedure>
<p>Normativas sobre Escritura de Tipos y Su Utilización</p>
<list style="alpha-lower">
<li><b><format color="CornFlowerBlue">Limitación de Valores para Variables</format></b>: <p>En general, la 
utilizacion de este tipado a la hora de definir variables, métodos y parámetros, limita los valores posibles que 
puede tomar una variable, efectivamente ayudando a reducir posibles errores de conversion, etc.</p></li> 
<li><b><format color="CornFlowerBlue">Todas las variables deben llevar un tipo</format></b>: <p>Toda variable en 
Java debe tener un tipo de dato asignado antes de su nombre, todo método debe tener un tipo de retorno antes de su 
nombre y cada parámetro en la misma forma.<br/><br/>
Esta regla se rompe únicamente si una variable se declara usando la keyword <code>var</code></p></li> 
<li><b><format color="CornFlowerBlue">No existen las conversiones implícitas</format></b>: <p>En Java, cualquier 
tipo de conversion se realiza a través de una conversion de tipo <code>(Tipo) variable</code>, similar a la 
que se usa en C o en C++ base. Estas se deben declarar directamente en el lenguaje y pueden causar excepciones.
<br/><br/>
Esta regla se rompe únicamente si una variable se pasa de un tipo primitivo a un tipo envolvente.</p> 
</li> 
</list>
</procedure>

## Modificadores de Acceso

<p>Los modificadores de acceso son primordiales en Java, estos se utilizan para delimitar clases, objetos, métodos, 
etc. Por lo general se declaran al inicio de las variables, de las clases y de los miembros. Java mantiene las 
mismas reglas que C++ en el caso de visibilidad de miembros en clases ordinarias y en estructuras de OOP.
<br/><br/>
Revisemos un ejemplo de código que recompile todos los datos presentados hasta el momento
</p>
<procedure>
<code-block lang="Java">
package com.evolvlabs.I_JavaLangBasics;

import java.lang.System;
import java.util.*;

//! Esto debe estar escrito en el archivo Ejemplo.java

public /*Modificador de acceso para la clase mas visible
del archivo*/
class Ejemplo{
    private int varOne = 10;
    protected double varTwo = 10.2;
    public String varThree = "11.5";

    //! Modificador de accesso que determina a este metodo
    //! como publico y estatico
    public static void main(String[] args){
        System.out.println(varThree);
    }
}

//! Otra clase dentro del mismo archivo, implícitamente declarada
//! como privada
class EjemploDos{;}

</code-block>
</procedure>
<p>Los modificadores de acceso nos ayudarán a controlar el flujo de información, y la exposición que nuestros 
metodos, variables y parámetros en Java pueden tener. Esto será muy util en el caso de la programación OOP, en los 
primeros ejemplos de nuestro curso no es tan necesario tener estos conceptos en cuenta</p>

## Verbose Exceptions
<p>Java es un lenguaje cuyo sistema se basa en dos grupos de excepciones claras, aquellas que son evaluadas 
estaticamente y durante compilación por el compilador, llamadas  <code>Checked  Exceptions</code>, y aquellas 
que no se revisan y 
pueden desencadenar en problemas durante la ejecución, <code>Unchecked Exceptions</code><br/><br/>
Mas adelante revisaremos a detalle el manejo de excepciones en Java, sus formatos y como identificarlas durante 
ejecucion y escritura del código. No obstante, es importante notar que en Java los mensajes de error son 
generalmente bastante descriptivos de las clases que se vieron afectadas por un error, y nos facilitan un análisis 
jerarquico de las zonas de error en nuestro programa</p>