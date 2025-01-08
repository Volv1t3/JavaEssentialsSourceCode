# Excepciones

> Una vez analizadas la mayoría de las estructuras de control incluidas en Java, sus tipos de datos, ejemplos de 
> código normales y hasta cierto punto el trabajo con tema de usuarios. Es momento de volver a nuestros programas 
> mucho más resilientes, y para esto debemos manejar excepciones.

<p>Las excepciones en cualquier lenguaje son marcas de error las cuales son usadas por compiladores, traductores, o 
build systems, para informar de errores dentro del código o durante su ejecución.
<br/><br/>
En Java, cuando un programa viola las normás internas de la JVM o del Java Programming Language, la JVM utiliza 
errores, lanzados en forma de excepciones para informar al usuario de los errores encontrados en el programa y la 
localizacion de los mismos con respecto al código fuente. 
<br/><br/>
En general, las excepciones en Java se manejan dentro de dos grandes grupos, aquellas que son revisadas 
estadísticamente 
durante la escritura del código y el compilador puede revisar durante compilación son conocidas como Checked 
Exceptions. Este grupo de excepciones se caracteriza por estar declaradas dentro de los métodos de varias clases, y 
deben ser manejados dentro del programa usando bloques <code>try-catch</code>, para que el programa <b>siquiera 
pueda compilar</b>.
<br/><br/>
El otro grupo de excepciones son aquellas cuyo estado surge solo cuando existen problemás durante la ejecución de un 
programa, como una division para cero, o un acceso fuera de los límites de un arreglo al extraer información de 
este. Este tipo de excepciones, dadas por errores de lógica o de ejecución del sistema o la JVM, se conocen como 
Unchecked Exceptions, y en general no puede ser todo el tiempo previstas por el programador, ya que son situaciones, 
valga la redundancia, excepcionales. 
<br/><br/>
Para entender esto, debemos analizar la jerarquía de excepciones en Java
</p>

## Jerarquía Java Exception

<p>Dentro del lenguaje de Java, bajo la clase <code>Objet</code>, tenemos la clase 
<code>Throwable</code>, la clase Throwable es la raíz de toda la jerarquía de clases relacionadas con 
Excepciones y Errores. En general, todas las Excepciones y los Errores que pueden ocurrir durante la compilación, o 
ejecución del código son hijas de la clase <code>Exception</code>, y generalmente ese espera que el programa pueda 
recuperarse de 
ese tipo de excepciones.
<br/><br/>
Dentro de las excepciones existen los dos grupos anteriormente mencionados, <code>Checked and Unchecked 
Exceptions</code>. Dentro de las clases internas del lenguaje, la separación entre ambos está dado por la clase 
padre de cada grupo. <code>Checked Exceptions tienen como padre la clase Exception</code>, mientras 
que <code>Unchecked Exceptions tienen como padre la clase RuntimeException</code>.
<br/><br/>
Para comprender la diferencia entre ambas es importante tomarnos un segundo para analizar la literatura de estas
</p>

### Java Checked Exceptions
<p>Las <b>Checked Exceptions</b> en Java, se identifican por su clase padre, como se ha mencionado, es decir se las 
identifica al tener como padre <code>Exception</code>. La mayoría de estas clases tienen como objetivo darle a 
conocer al usuario antes de que el código corra, durante compilación o durante un análisis estático por parte del 
entorno, que esta clase de excepciones pueden suceder y permitirle atraparlas y corregirlas en un bloque catch.
<br/><br/>
Segun la documentación de Java, es recomendable declarar aquellas excepciones que sean creadas por el usuario a 
traves de la clase <b>Exception</b>, para que el compilador logre analizar estas, antes de correr y el usuario pueda 
aprovechar el sistema de revision durante compilación del lenguaje.
<br/><br/>
Adicionalmente, el sistema de Java está diseñado para que cada método de la librería estándar que se utilice tenga 
establecido en su contrato (a través de la keyword <code>throws</code> las excepciones de este tipo que el 
programador debe solucionar antes de ejecución mediante bloques catch.
</p>
<p>Ejemplos de este tipo de excepciones son muchos, pero <code>se ven en varias clases de Java.IO y Java.NIO
</code>, donde el manejo con archivos tienen siempre excepciones de tipo <code>java.lang.IOException</code>, cuyo 
tipo es Checked y siempre requiere un manejo prioritario.</p>
<procedure>
<p>El listado a continuación muestra varios ejemplos de Excepciones de tipo Checked</p>
<list columns="2">
<li><b><format color="CornFlowerBlue">FileNotFoundException</format></b>:Marca que el proceso de apertura de un 
archivo a fallado. 
</li> 
<li><b><format color="CornFlowerBlue">IOException</format></b>: Marca que ha ocurrido un error en operaciones I/O</li>
<li><b><format color="CornFlowerBlue">ClassNotFoundException</format></b>: Marca que no se pudo encontrar una 
definición para una clase cuyo nombre se quiso cargar por la JVM</li> 
<li><b><format color="CornFlowerBlue">SQLException</format></b>: Marca que ha ocurrido un error durante el manejo de una base de datos</li> 
<li><b><format color="CornFlowerBlue">ParseException</format></b>: Marca que ha ocurrido un error durante el parsing de una cadena hacia un formato requerido</li> 
<li><b><format color="CornFlowerBlue">InterruptedException</format></b>: Marca que ha ocurrido un problema en durante el manejo de hilos en un programa multi-hilo</li> 
<li><b><format color="CornFlowerBlue">MalformedURLException</format></b>: Marca que se ha ingresado un URL incorrecto</li> 
</list>
</procedure>

### Unchecked Exceptions
<p>Las <b>Unchecked Exceptions</b> en Java, se identifican por su clase padre, como se ha mencionado anteriormente, 
es decir se las identifica al tener como padre <code>RuntimeException o alguna clase derivada</code>. La 
mayoria de estas clases no se conocen durante la escritura, análisis estático, o compilación del programa, y solo 
ocurren cuando un error grave se da durante la ejecución del código.
<br/><br/>
Segun la documentación oficial de Java <code>The unchecked exception classes are the run-time 
exception classes and the error classes</code> esto quiere decir que en un programa, las unchecked exceptions 
son todos aquellos errores que suceden por errores de lógica o errores graves de la JVM o del sistema operativo. 
<br/><br/>
<code>Error</code>, mencionado en la documentación anterior es un tipo de <code>Throwable</code> el cual representa 
una situación en el que el programa no puede volver a recuperarse, como errores en la JVM
<br/><br/>
Ejemplos de este tipo de Excepciones se dan mucho en programas donde se recepta entradas de consola del usuario y se 
intentan convertir sin tener en cuenta el tipo de dato de entrada. Si la clase no puede ser convertida, o si el dato 
ingresado no es el correcto pueden resultar en errores de conversion, etc. Asimismo, durante divisiones o durante 
uso de variables si se han dejado como null.
<br/><br/>Algunos ejemplos de estas excepciones se exponen aquí
</p>
<procedure>
<list columns="2">
<li><b><format color="CornFlowerBlue">ArithmeticException</format></b>: Marca uqe ha ocurrido un problema en el 
manejo aritmético del programa, como divisiones para cero.</li> 
<li><b><format color="CornFlowerBlue">ArrayStoreException</format></b>: Marca que se ha intentado almacenar el tipo de dato incorrecto dentro de un arreglo.</li> 
<li><b><format color="CornFlowerBlue">ClassCastException</format></b>: Marca que se ha intentado convertir un objeto a una subclase del cual no es una instancia.</li> 
<li><b><format color="CornFlowerBlue">EnumConstantNotPresentException</format></b>: Marca que una aplicación trato 
de acceder a una constante de una enumeración que no existe.</li> 
<li><b><format color="CornFlowerBlue">IllegalArgumentException</format></b>: Marca que un método ha recibido un 
parámetro illegal.</li> 
<li><b><format color="CornFlowerBlue">IllegalStateException</format></b>: Marca que un método ha sido invocado en un estado de la aplicación ilegal, es decir, la aplicación o la JVM no están en el estado apropiado para realizar esta llamada.</li> 
</list>
</procedure>

## Bloques Try-Catch

<p>La forma del lenguaje, al igual que en C++, de defenderse de las excepciones es a través de los bloques try-catch.
Estos pueden definir uno o varios caminos de manejo de excepciones dependiendo de las excepciones lanzadas dentro de 
su cuerpo.
<br/><br/>
Se pueden usar uno o varios en un nested try-catch block, por lo que se utiliza mucho en el trabajo de archivos para 
manejar y lanzar excepciones internas para el manejo de estados en aplicativos I/O. 
<br/><br/>
Dentro de Java, a diferencia de C++, se introduce una nueva parte al bloque normal de try-catch, la clausula 
<code>finally</code>, que se ejecuta al finalizar todo el código dentro del bloque try, e <code>inclusive 
si se lanzan excepciones dentro del código, este bloque se ejecuta siempre.</code>
<br/><br/>
La razón de existencia de este nuevo bloque de código es que en Java existen los llamados recursos, los recursos son 
clases que interactúan con el sistema operativo y se espera que se los cierre en algún momento. Por ejemplo un 
archivo se abre para lectura y luego se cierra para que el sistema operativo maneje los cambios y todo se abstraiga, 
en ámbitos de consola, el input de consola lo realiza un scanner cuyos recursos son compartidos con el sistema, como 
es entrada de teclado, etc., y, por tanto, requiere liberar esos recursos.
<br/><br/>
En un programa donde no exista un bloque finally y los recursos no se cierren están infringiendo con las normativas 
del lenguaje. Es por este motivo que Java creo los <code>try-with-resources statements</code>, que son 
bloques try-catch con recursos cuyo cierre se encarga directamente el lenguaje para evitar problemás de fuga de
recursos.
<br/><br/> 
En esta sección, discutiremos los tres tipos de bloques try-catch, <code>try-catch, try-catch-finally, y 
try-with-resources</code>.
</p>

### Try-catch Statements
<p>La estructura básica de manejo de excepciones, que tiene un correspondiente directo en C++, es el bloque 
try-catch que se usa en ambos lenguajes. Su estructura sintáctica es la misma. Iniciamos con un bloque try, seguido 
de uno o varios bloques catch con diferentes excepciones. 
<br/><br/>
Cuando definimos más de una excepción es importante tener en cuenta el tipo de excepción <code>(Checked o 
Unchecked)</code>, y la asociatividad que tienen algunos tipos de clases dentro de estas jerarquías, por ejemplo 
<code>IllegalThreadStateException</code> siendo una clase hija de <code>IllegalArgumentException</code>. Esto porque en Java, y en especial en 
los bloques try-catch las excepciones se manejan como si fueran un caso switch. <br/><br/>
<code>Siempre se espera 
ir de 
los 
más general a lo particular
</code>, es decir, si un bloque puede lanzar un <code>IllegalArgumentException</code>, un 
<code>IOException</code>, y otras que no 
sabemos, 
debemos definir bloques de código primero para <code>IOException</code>, luego para 
<code>IllegalArgumentException</code>,  seguido de 
<code>si queremos</code>, bloques catch para <code>Exception y RuntimeException</code> adicionalmente.
<br/><br/>
A continuación se establecen tres ejemplos que demuestran el trabajo con diversos bloques de código y las 
excepciones que pueden lanzar
</p>
<procedure>
<tabs>
<tab title="Try-Catch Block I">
<code-block lang="Java">
package exception_example;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionExampleOne{

    public static void main(String[] args){

        try /*Abrimos el bloque try como en C++*/{
            //! Abrimos un archivo en Java que no existe
            Scanner scanner = new
                    Scanner(new File("archivo/no/existe.txt"));

        }catch (FileNotFoundException fileNotFoundException){
            //! Bloque Catch del archivo que no existe
            System.out.println("Error:" +
                    "FileNotFoundException Thrown: solucioando "
                    + "con un catch");
            System.out.println
                        (fileNotFoundException.getMessage());
        }
    }
}
</code-block>
</tab>
<tab title="Try-Catch Block II">
<code-block lang="Java">
package exception_example;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ExceptionExampleTwo{

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Por favor ingrese un número entero:");

            // Intentamos convertir el input del usuario a un int
            int numero = scanner.nextInt();
            System.out.println("El número ingresado es: " + numero);

        } catch (InputMismatchException inputMismatchException) {
            //! Bloque Catch: Argumento no válido para la conversión
            System.out.println("Error: IllegalArgumentException lanzada.");
            System.out.println(inputMismatchException.getLocalizedMessage());

        } catch (IllegalStateException illegalStateException) {
            //! Bloque Catch: Estado del scanner ilegal
            System.out.println("Error: IllegalStateException lanzada.");
            System.out.println(illegalStateException.getCause().getMessage());

        } catch (NoSuchElementException noSuchElementException){
            //! Bloque Catch: No hay más elementos en el input
            System.out.println("Error: NoSuchElementException lanzada.");
            System.out.println(noSuchElementException.getMessage());
        }
        catch (RuntimeException runtimeException) {
            //! Bloque Catch para todas las excepciones RuntimeException adicionales
            System.out.println("Error: RuntimeException lanzada.");
            runtimeException.printStackTrace();
        }

    }
}
</code-block>
</tab>
<tab title="Try-Catch Block III">
<code-block lang="Java">
package exception_example;

public class ExceptionExampleThree {

public static void main(String[] args) {

        try {
            // Arreglo con tamaño 
            // incorrecto para 
            // forzar ArrayStoreException
            Object[] array = 
                new String[5];
            array[0] = 10; // Error

            // Casteo incorrecto 
            // para ClassCastException
            Object obj = 
                Integer.valueOf(42);
            String str = 
                (String) obj; // Error

            // Acceso a constante de 
            // enumeración inexistente para 
            // EnumConstantNotPresentException
            TestEnum enumValue = 
                TestEnum.valueOf(
                    "NON_EXISTENT_ENUM");

        } catch (ArrayStoreException 
                    arrayStoreException) {
            // Bloque Catch: Error
            System.out.println(
                "Error: ArrayStoreException.");
            System.out.println(arrayStoreException
                                .getMessage());

        } catch (ClassCastException 
                    classCastException) {
            // Bloque Catch: Error
            System.out.println(
                "Error: ClassCastException.");
            System.out.println(classCastException
                                .getMessage());

        } catch (EnumConstantNotPresentException 
                    enumException) {
            // Bloque Catch: Error
            System.out.println(
                "Error: EnumConstantNot");
            System.out.println(enumException
                                .getMessage());

        } catch (RuntimeException 
                    runtimeException) {
            // Bloque Catch adicional
            System.out.println(
                "Error: RuntimeException.");
            runtimeException.printStackTrace();

        } catch (Exception exception) {
            // Bloque Catch genérico
            System.out.println(
                "Error: Excepción general.");
            exception.printStackTrace();
        }
    
    }

} 
</code-block>
</tab>
</tabs>
</procedure>
<p>Ahora bien, aunque esta es la forma base de escritura de bloques try-catch, y esta es la forma base que puede ser 
usada para transformar código de C++ en código de Java. Java incluye funcionalidades extra que nos permiten manejar 
mucho mejor recursos, ya no memoria.
</p>

### Try-catch-finally Statements
<p>Los bloques try-catch-finally, son un nuevo tipo de bloques para manejo de excepciones incluidos en Java, los
cuales se usan mucho cuando se trabaja con recursos dentro de una aplicación. En lugar de manejar memoria, ahora en
Java se maneja mucho lo que es recursos del sistema operativo, como archivos, o permisos como ingresos por teclado
para la lectura de consola con System.in. Para entender esto mejor es ideal revisar que son los recursos en Java</p>


#### Recursos en Java
<procedure>
<i>En Java, todo aspecto ajeno a la memoria (lo que se puede encargar el garbage collector), como son archivos, 
conexiones a bases de datos, puertos en el sistema, conexiones con periféricos, etc., son considerados recursos por 
su naturaleza de ser limitados.<br/><br/>
Se recomienda cerrar estos recursos para que puedan volver a ser usados por el sistema operativo, u otras secciónes 
de nuestro código si es necesario.</i>
</procedure>

<p>En ese sentido, los bloques try-catch-finally nos sirven mucho para poder organizar el uso de recursos dentro de 
nuestros programas, prever y solucionar errores durante la apertura o utilización de los mismos y su cierre para 
evitar problemás con el sistema operativo como errores en los descriptores de archivos o conexiones a bases de datos 
todavia abiertas.
<br/><br/>
La estructura de estos bloques es clara, y fácil de recordar, simplemente se debe añadir al final de nuestro 
try-catch block original, un nuevo bloque de código después de la palabra reservada <code>finally</code>. 
Claro esta, que al ser una añadidura dentro de nuestra lógica general de manejo de excepciones es importante tomar 
en cuenta algunos detalles de su implementación.
</p>
<procedure>
<tabs>
<tab title="Reglas del bloque finally en un try-catch-finally block">
<list style="alpha-lower">
<li><b><format color="CornFlowerBlue">Orden de ejecución</format></b>: Siempre se ejecuta primero el bloque 
<code>try</code>, este puede terminar o lanzar una excepción. Si se lanza una excepción, esta pasa a un <code> bloque 
catch</code> Si este bloque catch logra frenar la excepción entonces el bloque finally se ejecuta. Si no lo logra, el bloque 
finally igual se ejecuta solo que el programa termina abruptamente.
<br/>
En este sentido, el bloque finally no se adhiere a las normás de <code>excepción sin manejo -> programa termina 
abruptamente</code>, sino que se ejecuta por sobre la excepción y al final el programa se cae
</li>
<li><b><format color="CornFlowerBlue">Uso del bloque Finally</format></b>: En general, el bloque finally se usa para 
cerrar recursos, estos pueden ser archivos, descriptores de archivos, conexiones a bases de datos, etc.</li> 
<li><b><format color="CornFlowerBlue">Requiere de un Try-Catch Block</format></b>: El bloque finally no puede 
existir sin un bloque try-catch anterior a este.</li> 
<li><b><format color="CornFlowerBlue">Excepciones en un Finally Block</format></b>: Si se lanza una excepción en un 
bloque finally esta se comporta de la misma manera que las anteriores, causando una excepción más que se reporta en el sistema</li> 
</list>
</tab>
</tabs>
</procedure>
<p>Habiendo definido las utilidades de este bloque y en general sus reglas, procedemos a detallar algunos ejemplos 
de código útiles para ejemplificar su uso</p>
<procedure>
<tabs>
<tab title="Try-catch-finally Block I">

```Java
package exception_examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionExampleFour{

    public static void main(String[] args) {
        // Declaramos el scanner fuera del try-catch
        Scanner scanner = null; 

        try {
            // Intentamos abrir un archivo que no existe
            File file = new File("non_existent_file.txt");
            scanner = new Scanner(file);

            // Leemos contenido del archivo 
            // (no se ejecutará porque el archivo no existe)
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            // Capturamos la excepción cuando el archivo 
            // no es encontrado
            System.out.println(
            "Error: El archivo no fue encontrado.");
            System.out.println(fileNotFoundException.getMessage());
        } finally {
            // Cerramos el scanner si fue inicializado correctamente
            if (scanner != null) {
                scanner.close();
                System.out.println(
                "Recurso Scanner cerrado correctamente.");
            }
        }
    }
}
```
</tab><tab title="Try-catch-finally Block II">

```Java
package exception_example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ExceptionExampleFive{
    private static void readFileAndPrintLines(Integer numOfLines){
        Scanner fileScanner = null;
            try {
                fileScanner = new Scanner
                            (new File("RESOURCE_FILE_A.txt"))
                //! Con el objeto abierto es momento 
                de leer un cierto numero de lineas de el
                int counter = 0;
                while (counter < numOfLines){
                    if (fileScanner.hasNextLine()){
                        System.out.println(
                        "Linea Leida por el Scanner"+ 
                        " [" + counter + "] : " 
                        + fileScanner.nextLine());
                        counter++;
                    }
                    else{
                        System.out.println(
                        Colorizer.colorWithCyanLetters(
                        "Error: No hay más lineas para leer"));
                        break;
                    }
                }
            }catch (FileNotFoundException fileNotFoundException){
                System.out.println(Colorizer.colorWithCyanLetters(
                "Error: FileNotFoundException (archivo no encontrado)" 
                + " fue lanzado en el método readFileAndPrintLines." + 
                " Solucionado con un catch"));
                ExceptionsPartOne
                .extractorDeInformacionDeError(fileNotFoundException);
            }
            finally {
                System.out.println(Colorizer.colorWithYellowLetters(
                "El programa ha finalizado su ejecución, por tanto" +
                        " el Scanner se ha cerrado"));
            }
        }

    }
```
</tab>
<tab title="Try-catch-finally Block III">

```Java
package exception_example;

public class ExceptionExampleSix{

Scanner inputScanner = null; // Scanner to ask user for input
Scanner fileScanner = null; // Scanner to read file

        try {
            // Ask user for a file path
            inputScanner = new Scanner(System.in);
            System.out.println(
            "Por favor, introduzca la ruta del archivo:");
            String filePath = inputScanner.nextLine();

            // Create a File object
            File file = new File(filePath);

            // Check if the file exists
            if (!file.exists()) {
                throw new IllegalStateException(
                "Error: El archivo no existe"+
                " en la ruta proporcionada.");
            }

            // Open the file and read its contents
            fileScanner = new Scanner(file);
            System.out.println("Contenido del archivo:");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IllegalStateException illegalStateException) {
            System.out.println(
            "Error: " + illegalStateException.getMessage());
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(
            "Error: No se pudo abrir el archivo. "+
            " excepción encontrada: ");
            System.out.println(fileNotFoundException.getMessage());
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println(
            "Error: No se pudo leer nada por consola." + 
            " excepción encontrada: ");
            System.out.println(noSuchElementException.getMessage());
        } catch(SecurityException securityException){
           System.out.println("Error: No se pudo acceder al archivo."+ 
           " excepción encontrada: ");
           System.out.println(securityException.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error: excepción encontrada: ");
            System.out.println(e.getMessage());
        }  finally {
            // Close scanners if initialized
            if (inputScanner != null) {
                inputScanner.close();
            }
            if (fileScanner != null) {
                fileScanner.close();
                System.out.println(
                "Recurso Scanner cerrado correctamente.");
            }
        }
    }

}
}
```
</tab>
</tabs>
</procedure>
<p>Si bien este tipo de bloques es util cuando nosotros tenemos pocos recursos, uno o dos y no tienen una 
dependencia directa, esto se complica cuando algunos recursos dependen de otros (e.j., el manejo de archivos de Java 
depende no solo de una dirección de un archivo sino que también del archivo en sí, y de un lector).
<br/><br/>
En estos casos, hay tantos puntos posibles de error, que uno como programador no puede analizar todos y prever todas 
las posibles combinaciones de errores (que tal si el archivo se abre, pero hay un problema de la JVM al generar el 
lector/escritor al archivo. Que tal si el archivo existe, pero el sistema de Java no puede comunicarse con el sistema 
operativo y no logra abrir el archivo), en estos casos, se utiliza un nuevo tipo de bloque try-catch, el famoso 
<code>Try-with-Resources block</code>
</p>

### Try-with-Resources block
<p>Este último de los tipos de try-with-Resources es el que más veremos dentro del curso y es el que más he usado 
para el diseño de los programas y métodos demostrativos tanto de excepciones como de manejo de archivos. <br/><br/> 
En general, el manejo de recursos en Java no se hace directamente llamando al método <code>.close()</code> de cada 
uno de los recursos que hemos generado, sino que esto se delega a la máquina virtual de java (JVM) para que durante 
la ejecución, si todo sale bien se cierren automáticamente, y si algo sale male también.
<br/><br/>
Los bloques Try-with-Resources se definen de la siguiente manera en la documentación oficial de Java</p>
<procedure>
<i>A try-with-resources statement is parameterized with variables (known as resources) that are initialized before 
execution of the <code>try</code> block and closed automatically <b>in the reverse order from which they were 
initialized</b></i>
</procedure>
<p>De esta definición, podemos extraer dos puntos importantes.</p>
<list columns="2">
<li><b><format color="CornFlowerBlue">Apertura de los Recursos</format></b>: Los recursos se inicializan 
automaticamente antes de correr el bloque Try, esto significa que los recursos de este programa se inicializan de una manera que puede terminar en errores*</li>
<li><b><format color="CornFlowerBlue">Cerrado Automático en Reversa</format></b>: Este es un dato muy importante, ya 
que usualmente la manera en la que es estructuran los resource-blocks en Java es de menor a mayor, es decir, primero el archivo, luego el reader de ese archivo, y luego el buffered reader, por ejemplo. O en otros casos, primero el archivo, luego el escritor, luego el buffered writer.</li> 
</list>
<p>Sin duda, la utilidad más grande de este tipo de bloques es la tranquilidad que da por el cierre y la 
inicializacion de recursos automáticamente. Lo que reduce las probabilidades de error en un programa que requiera de 
entradas de datos, manejo de conexiones a bases de datos, manejo de archivos, streams de información, etc.
<br/><br/>
Es importante notar dos aspectos adicionales sobre los recursos de este tipo que nos pueden servir para establecer 
nuestros propios try-with-resources blocks</p>
<list columns="2">
<li><b><format color="CornFlowerBlue">Recursos Efectivamente Finales</format></b>: Todos los recursos que se 
generan dentro de este bloque se establecen como efectivamente finales, si no fueron declarados como finales 
explicitamente. Adicionalmente, como los bloques lambda, las variables externas que se usan aquí también deben ser 
efectivamente finales o finales.</li>
<li><b><format color="CornFlowerBlue">Cierre de Recursos Fail-safe</format></b>: En el sistema de 
try-with-resources, durante la inicialización, si uno de los recursos falla en su inicialización, el resto luego de 
este no se inicializan, y los anteriores a este se cierran automáticamente, efectivamente volviendo a este tipo de 
try-catch blocks fail-safe.
</li> 
</list>
<p>Una vez definidas estas propiedades de los try-with-resources blocks, es important revisar un poco de código con 
el que podamos evaluar su estructura</p>
<procedure>
<tabs>
<tab title="Try-with-Resources Block I">
<code-block lang="Java">
package exception_examples;
import java.io.*;

public class ExceptionExampleSeven{
    public static void main(String[] args){
        try ( /*Formato de Declaracion de Recursos*/
             Scanner inputScanner = new Scanner(System.in);
             Scanner fileScanner = new 
                Scanner(new File("nonexistent_file.txt"));
        ) {
            System.out.println("Contenido del archivo:");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error:" + 
                    " Archivo no encontrado" +
                    ". Excepción capturada: ");
            System.out.println(
                        fileNotFoundException.getMessage());
        } catch (IllegalStateException illegalStateException) {
            System.out.println("Error:" + 
                " Excepción de estado ilegal capturada: ");
            System.out.println(illegalStateException.getMessage());
        } catch (SecurityException securityException) {
            System.out.println("Error: Permisos insuficientes" + 
            " para acceder al archivo. Excepción capturada: ");
            System.out.println(securityException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Error: Excepción inesperada" 
            + " capturada: ");
            System.out.println(runtimeException.getMessage());
        }
    }
}
</code-block>
</tab>
<tab title="Try-with-Resources Block II">
<code-block lang="Java">
package exception_examples;
import java.io.*;

public class ExceptionExampleEight{
    
    public static void main(String[] args){
        
        try (
            FileReader fileReader = new FileReader("nonexistent_file.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            System.out.println("Contenido del archivo:");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error: Archivo no encontrado. Excepción encontrada: ");
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println("Error: Ocurrió un problema de E/S. Excepción encontrada: ");
            System.out.println(ioException.getMessage());
        } catch (SecurityException securityException) {
            System.out.println("Error: Permisos insuficientes para acceder al archivo. Excepción encontrada: ");
            System.out.println(securityException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Error: Excepción inesperada capturada: ");
            System.out.println(runtimeException.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta");
        }
    }
}
</code-block>
</tab>
<tab title="Try-With-Resource Block III">

```Java
package exception_examples;
import java.io.*;

public class ExceptionExampleNine{

public static void main(String[] args) {
try (Scanner inputScanner = new Scanner(System.in)) {
System.out.println("Por favor ingrese la" +
" dirección de una carpeta:");
String folderPath = inputScanner.nextLine();
File folder = new File(folderPath);

            if (folder.exists() && folder.isDirectory()) { 
                try (Stream<File> filesStream = 
                     Arrays.stream(Objects.
                             requireNonNull(folder.listFiles()))) { 
                    System.out.println("Archivos en la carpeta:");
                    filesStream
                    .forEach(file -> 
                    System.out.println(file.getName()));
                } catch (SecurityException securityException) {
                    System.out.println("Error:" + 
                    " Permisos insuficientes " 
                    +"para acceder a la carpeta. "+
                    " Excepción capturada:");
                    System.out.println(
                            securityException.getMessage());
                } catch (RuntimeException runtimeException) {
                    System.out.println("Error: Excepción " +
                            "inesperada capturada en el stream:");
                    System.out.println(
                            runtimeException.getMessage());
                }
            } else {
                System.out.println("La dirección indicada " +
                        "no corresponde a una carpeta " +
                        "válida o no existe.");
            }
        } catch (IllegalStateException illegalStateException) {
            System.out.println(
            "Error: Excepción de estado ilegal capturada:");
            System.out.println(illegalStateException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println(
            "Error: Excepción inesperada capturada:");
            System.out.println(runtimeException.getMessage());
        }

    }
}
```
</tab>
</tabs>
</procedure>
