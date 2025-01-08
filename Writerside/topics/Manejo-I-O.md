# Manejo I/O

>Conociendo la forma de trabajar con excepciones, con bloques de código cuyos métodos pueden lanzar excepciones, e 
> inclusive bloques de código cuyo formato permite al programa manejar la creación de recursos para su utilización 
> en Java. 
> Estamos casi al final de los aspectos más importantes y esenciales de Java, ahora nos queda en esta 
> sección revisar el manejo de archivos.


## Input y Output Hacia Archivos: Fundamentos

<p>En Java trabajo con archivos se concentra directamente en las clases, interfaces (a discutirse en secciones 
siguientes), y excepciones localizadas en el paquete</p> <code>java.io.*</code>, en donde las estructuras 
jerarquicas internas muestran una clara diferencia entre dos tipos de archivos y su manejo. En primera instancia, 
Java permite el manejo, y diferencia entre archivos binarios y archivos basados en texto.
<br/><br/>
Los archivos binarios en Java, generalmente se trabajan para serializar datos de una aplicación, o para guardar 
valores sin ningún formato y solo en su expresión interna de bits. Si bien estos pueden ser útiles, hasta cierto 
punto el trabajo con archivos se centra en el análisis de archivos de texto. Este segundo bloque de archivos, 
corresponde a todo archivo con un formato específico, por ejemplo aquellos derivados del format ASCII como son 
<code>.txt, .csv, .json, .xml, .html, .css, etc.</code>Esta clase de archivos pueden ser manejados fácilmente en Java 
base, pero siempre hay que recalcar que existen librerías específicas para el trabajo con estos archivos cuyo 
análisis cae fuera del marco de estudio de este curso.
<br/> <br/>
Dentro del contenido del curso, manejaremos en su mayoría los archivos de texto y los lectores y escritores de archivos
con formato dentro de Java. Para esta sección, además, analizaremos algunas clases adicionales que nos ayudan en el 
manejo de archivos así como la diferencia entre ambos tipos de I/O.

### Binary I/O VS Text I/O
<p> En Java se diferencia entre dos tipos de formatos para manejo de archivos externos, binary y text. Binary 
corresponde a aquellos archivos cuyo formato interno, encoding, y en general contenidos, no pueden ser comprendidos 
fácilmente por un lector de archivos como Notas, porque contiene códigos de bits cuya estructura no se puede 
traducir directamente hacia ASCII. Podemos pensar en este grupo de igual forma que se trabaja en consola. Los 
caracteres ASCII son imprimibles tanto en código como en consola, pero cuando los códigos de bits o valores numéricos representativos de un 
caracter, no están dentro del código ASCII, podemos notar que la consola imprime 
caracteres erróneos, o inclusive sin sentido. 
<br/> <br/>
En este sentido, el binary IO que nosotros trabajamos tiene una separación clara de los archivos con formato 
prestablecido, como aquellos basados en texto (.txt, .csv, etc.), dado a que no tienen un encoding que permita a un 
programa editor de texto analizarlos.</p>
<p> Por su parte, los archivos de texto tienden a tener internamente un modelo de encoding, y generalmente son archivos con un formato preestablecido y legible por el ser humano, y editores de texto. La diferencia en Java está en que las clases para manejo de estos archivos se encuentran en una jerarquía paralela, cuyas clases construyen sobre binary I/O para darle al programa una conversion automática de ingresos, pasando directamente de binario a texto y viceversa, abstrayendo el proceso. </p>
<p> Para comprender de una mejor manera ambos procesos, la siguiente table muestra cinco diferencias claves entre ambos 
modelos </p>
<procedure>
<table>
<tr>
<th>Comparativa</th>
<th>Binary I/O</th>
<th>Text I/O</th>
</tr>
<tr>
<td>Formato</td>
<td>Archivos en formato binario que no son fácilmente legibles por humanos.</td>
<td>Archivos en formato texto que son legibles y editables por humanos.</td>
</tr>
<tr>
<td>Uso Principal</td>
<td>Serialización o almacenamiento de datos sin formato específico.</td>
<td>Manejo de datos estructurados y legibles como JSON, XML, CSV, etc.</td>
</tr>
<tr>
<td>Encoding</td>
<td>No requiere encoding específico, trabaja directamente con bits.</td>
<td>Requiere encoding como UTF-8 o ASCII para su correcta interpretación.</td>
</tr>
<tr>
<td>Velocidad</td>
<td>Es generalmente más rápido debido a la ausencia de conversiones adicionales.</td>
<td>Puede ser más lento debido a las conversiones necesarias entre texto y binario.</td>
</tr>
<tr>
<td>Reusabilidad</td>
<td>Difícil de reutilizar o editar manualmente sin herramientas específicas.</td>
<td>Fácilmente reutilizable y editable por humanos o editores de texto.</td>
</tr>
</table>
</procedure>
<p> Una vez revisada la diferencia entre archivos binarios y con formato, y la diferencia en su trabajo, podemos 
adentrarnos a revisar en un overview rápido, las distintas clases helper que nos permiten manejar con archivos en Java. </p>

### Helper Clases para I/O en Java
<p> En Java, en paralelo con las clases que existen para el manejo concreto de archivos en lo que corresponde a 
escritura y lectura de estos. Existen varias clases añadidas cuyo objetivo es ayudarnos a comunicarnos con el 
sistema operativo. En específico, Java se encarga de abstraer la comunicación con el sistema de archivos dentro del 
sistem operativo que usemos, informado solo de errores mediante excepciones como <code>FileNotFoundException o 
SecurityException</code>, errores que pueden ocurrir cuando tratamos de acceder a un archivo inexistente, o cuando 
accedemos a nu archivo con privilegios de seguridad elevados, respectivamente.
<br/> <br/>
Dentro de estas clases adicionales que Java contiene se encuentran tres importantes que analizaremos </p>
<code> File (java.nio.File.Files y java.io.File), Path (java.nio.File) y Paths (java.nio.File)
</code>.


#### File Classes
<p>En Java las clases <b>File de java.io y de java.nio</b> presentan varios métodos helper que nos permiten trabajar 
con archivos y conocer sobre sus datos internos. Por ejemplo, la clase <b>File de java.io</b> incluye métodos útiles 
para determinar si un archivo puede ser ejecutado, si puede ser escrito, si es directorio, permite crear archivos 
temporales, nuevos archivos, etc.
<br/><br/>
Sin lugar a duda es una clase util para arrancar con el manejo de archivos, y siempre tiene métodos que pueden ser 
de mucha utilidad a la hora de analizar archivos del usuario o para crear aplicaciones que manejen archivos en 
tiempo real.
<br/><br/>
En contraste la clase <b>Files de java.nio</b>, presenta varios métodos nuevos para trabajar con streams de 
informacion y de directorios, contiene en su totalidad métodos públicos estáticos que permiten manejar tanto 
archivos, como directorios en Java para su posterior análisis.
<br/><br/>
Para comprender su funcionalidad es importante analizar bloques de código de cada una de estas clases
</p>
<procedure>
<tabs>
<tab title="Java.io.File">
<code-block lang="Java">
package io_examples;

import java.io.File;

public class IOExampleOne {
public static void main(String[] args) {
// Ruta del archivo
String rutaArchivo = System
.getProperty("user.home");

        // Crear una instancia de File
        try {
            File archivo = new File(rutaArchivo);

            // Intentar acceder al archivo y usar los métodos informativos
            if (archivo.exists()) {
                System.out.println("El archivo existe.");
                System.out.println("Nombre del archivo: " 
                        + archivo.getName());
                System.out.println("Ruta absoluta: " 
                        + archivo.getAbsolutePath());
                System.out.println("Es un directorio: " 
                        + archivo.isDirectory());
                System.out.println("Es un archivo: " 
                        + archivo.isFile());
                System.out.println("¿Se puede leer?: " 
                        + archivo.canRead());
                System.out.println("¿Se puede escribir?: " 
                        + archivo.canWrite());
                System.out.println("¿Es ejecutable?: " 
                        + archivo.canExecute());
                System.out.println("Tamaño del archivo (en bytes): " 
                        + archivo.length());
                System.out.println("Última modificación: " 
                        + archivo.lastModified());
            } else {
                System.out.println("El archivo no " 
                        + "existe en la ruta especificada.");
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error " +
                    "al acceder al archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // Listar todos los directorios
    // y archivos en la carpeta del archivo
    public static void listarArchivosYDirectorios(File archivo) {
        if (archivo.isDirectory()) {
            File[] archivos = archivo.listFiles();
            if (archivos != null && archivos.length > 0) {
                System.out.println("Contenido del directorio " +
                        archivo.getName() + ":");
                for (File f : archivos) {
                    System.out.println((f.isDirectory() ? 
                            "[Directorio] " : "[Archivo] ") 
                            + f.getName());
                }
            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("La ruta especificada " +
                    "no es un directorio.");
        }
    }

    // Renombrar un archivo o directorio
    public static void renombrarArchivo(File archivo, String nuevoNombre) {
        File archivoRenombrado = new 
                File(archivo.getParent(), nuevoNombre);
        if (archivo.renameTo(archivoRenombrado)) {
            System.out.println("Archivo renombrado " +
                    "exitosamente a: " + nuevoNombre);
        } else {
            System.out.println("Error al " +
                    "renombrar el archivo.");
        }
    }

    // Crear un nuevo directorio
    public static void crearDirectorio(String rutaDirectorio) {
        File nuevoDirectorio = new File(rutaDirectorio);
        if (nuevoDirectorio.mkdirs()) {
            System.out.println("Directorio " +
                    "creado exitosamente: " + rutaDirectorio);
        } else {
            System.out.println("Error al crear el " +
                    "directorio, posiblemente ya exista.");
        }
    }
}
</code-block>
</tab>
<tab title="Java.nio.File.Files">

```Java
package io_examples;

public class IOExampleTwo{

import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Stream;

public class IOExampleTwo {
public static void main(String[] args) {
// Ruta del directorio base desde user.home
String rutaBase = System.getProperty("user.home");

        try {
            Path path = Paths.get(rutaBase);

            // Verificar si el path existe
            if (Files.exists(path)) {
                System.out.println("La ruta existe.");
                
                // Verificar si es un archivo o un directorio
                if (Files.isDirectory(path)) {
                    System.out.println("Es un directorio.");
                    listarArchivosDirectorio(path);
                } else {
                    System.out.println("Es un archivo.");
                    System.out.println("Tamaño del archivo" 
                     +  "(en bytes): " + Files.size(path));
                }
                System.out.println("Última modificación: " 
                    + Files.getLastModifiedTime(path));
                System.out.println("¿Se puede leer?: " 
                    + Files.isReadable(path));
                System.out.println("¿Se puede escribir?: " 
                    + Files.isWritable(path));
                System.out.println("¿Es ejecutable?: " 
                    + Files.isExecutable(path));
            } else {
                System.out.println("La ruta no existe" 
                + " en el sistema de archivos.");
            }

            // Crear un directorio de prueba dentro del path base
            crearDirectorio(
                        Paths.get(rutaBase + "/nuevo_directorio"));

        } catch (IOException e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Listar los archivos y directorios dentro de un directorio dado
    public static void listarArchivosDirectorio(Path directorio) {
        try (Stream<Path> paths = Files.list(directorio)) {
            System.out.println("Contenido del directorio: " 
            + directorio.getFileName());
            paths.forEach(path -> {
                System.out.println((Files.isDirectory(path) 
                ? "[Directorio] " : "[Archivo] ") 
                + path.getFileName());
            });
        } catch (IOException e) {
            System.err.println(
            "Error al listar el contenido del directorio: " 
            + e.getMessage());
        }
    }

    // Crear un nuevo directorio
    public static void crearDirectorio(Path nuevoDirectorio) {
        try {
            Files.createDirectories(nuevoDirectorio);
            System.out.println("Directorio" + 
                " creado exitosamente: " + nuevoDirectorio);
        } catch (IOException e) {
            System.err.println("Error al" + 
                " crear el directorio: " + e.getMessage());
        }
    }

    // Renombrar un archivo o directorio
    public static void renombrarArchivo
                (Path archivo, String nuevoNombre) {
        try {
            Path nuevoPath = archivo
                    .resolveSibling(nuevoNombre);
            Files.move(archivo, nuevoPath);
            System.out.println("Archivo renombrado" +
            " exitosamente a: " + nuevoNombre);
        } catch (IOException e) {
            System.err.println("Error al renombrar" + 
            " el archivo: " + e.getMessage());
        }
    }

    // Eliminar un archivo o directorio
    public static void eliminarArchivo(Path archivo) {
        try {
            Files.delete(archivo);
            System.out.println("Archivo eliminado" 
                + " exitosamente: " + archivo);
        } catch (IOException e) {
            System.err.println("Error al eliminar" + 
                " el archivo: " + e.getMessage());
        }
    }

}



}
```
</tab>
</tabs>
</procedure>
<p>Luego de haber revisado estos dos bloques de código, la diferencia entre ambos recae en sus métodos y en la forma 
de trabajo de estos en varios métodos. Generalmente, la forma de trabajo de Java.io.File es mucho mas simple y al ser 
una clase con métodos básicos, puede ser un poco limitante a la hora de adentrarse en proyectos grandes de análisis 
y manejo de archivos. Por otra parte, la clase Java.nio.File.Files presenta métodos mucho más seguros y complejos, 
con excepciones cuando algo sucede incorrectamente, en lugar de booleanos como maneja Java.io.Files.
<br/><br/>
Al final la decision con respecto a usar uno o el otro puede ser visto en la siguiente tabla comparativa.
</p>
<procedure>
    <table>
        <tr>
            <th>Comparativa</th>
            <th>Java.io.File</th>
            <th>Java.nio.file.Files</th>
        </tr>
        <tr>
            <td>Diseño de la API y Compleción</td>
            <td>Proporciona capacidades básicas para manejar archivos y carpetas.</td>
            <td>API moderna y completa con soporte para operaciones avanzadas de manejo de archivos.</td>
        </tr>
        <tr>
            <td>Representación de rutas</td>
            <td>Utiliza cadenas de texto (<code>String</code>) para representar rutas.</td>
            <td>Utiliza la clase <code>Path</code>, que es más flexible y representativa para manejar rutas.</td>
        </tr>
        <tr>
            <td>Manejo de errores</td>
            <td>Devuelve valores booleanos (<code>true</code> o <code>false</code>) que indican éxito o fallo.</td>
            <td>Lanza excepciones (<code>IOException</code>, etc.) para mayor claridad al manejar errores.</td>
        </tr>
        <tr>
            <td>Soporte para Streams</td>
            <td>No ofrece soporte para Streams.</td>
            <td>Soporte completo para Streams, por ejemplo, <code>Files.lines()</code> para leer archivos como flujo.</td>
        </tr>
        <tr>
            <td>Recorrido de directorios</td>
            <td>Requiere implementar recursión manual para recorrer directorios.</td>
            <td>Ofrece APIs como <code>Files.walk()</code> y <code>Files.walkFileTree()</code> para recorrer directorios fácilmente.</td>
        </tr>
        <tr>
            <td>Soporte para enlaces simbólicos</td>
            <td>No tiene soporte para enlaces simbólicos.</td>
            <td>Maneja enlaces simbólicos con métodos como <code>Files.isSymbolicLink()</code>.</td>
        </tr>
        <tr>
            <td>Operaciones de I/O (renombrar, eliminar, copiar)</td>
            <td>Operaciones básicas como renombrar y eliminar archivos, pero copiar requiere implementación manual.</td>
            <td>Métodos incorporados como <code>Files.copy()</code>, <code>Files.move()</code> y <code>Files.delete()</code> simplifican estas acciones.</td>
        </tr>
        <tr>
            <td>Acceso a metadatos de archivos</td>
            <td>Acceso limitado a atributos como tamaño (<code>length()</code>) y última modificación (<code>lastModified()</code>).</td>
            <td>Acceso avanzado a metadatos mediante <code>Files.getAttribute()</code>, soporta diversos atributos personalizados.</td>
        </tr>
        <tr>
            <td>Seguridad en entornos multi-hilo</td>
            <td>No es seguro para hilos.</td>
            <td>Al utilizar <code>Path</code> y operaciones modernas, es más seguro para entornos multi-hilo.</td>
        </tr>
    </table>
</procedure>
<p>Una vez revisado este concepto tan fundamental de los archivos y su manejo, es momento de analizar la segunda 
parte (de nuevo agrupada en un mismo conjunto de análisis, con el tema de <b>Paths y Path</b>, dos clases muy útiles,
usadas para representar direcciones de archivos en el sistema de Java.
</p>

#### Path Classes
<p> En el entorno de Java la clase Path (Java.nio.File.Path) y la clase Paths (java.nio.File.Paths), son clases que se utilizan para ubicar un archivo dentro del sistema de archivos manejado por 
el sistema operativo donde se ejecute el código, esto entonces garantiza que las direcciones sean independientes del separador de archivos por ejemplo, o si el sistema reconoce una estructura de UNIX/Windows o Linux. 
<br/><br/>
De esta manera, logramos tener un código cuyo mecanismo de trabajo abstrae la forma en la que se manejan los archivo 
dentro del sistema operativo. Asi, reducimos la posibilidad de error al tratar de formar direcciones de archivos 
manualmente como se hacia con tipo String.
<br/><br/>
En lugar de esto, nuestros programas utilizan una interface simple de trabajo que nos facilita el trabajo con 
archivos de la siguiente manera
</p>
<procedure>
<tabs>
<tab title="Paths y Path en un mismo ejemplo">

```Java
package io_examples;
// Ejemplo de uso de java.nio.file.Path
// y java.nio.file.Paths

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Locale;
import java.util.stream.Stream;

public class IOExampleThree {

    public static void main(String[] args) {
        try {
            // Obtener el directorio del 
            // usuario basado en su idioma
            String userHome = 
                    System.getProperty("user.home");
            String documentsDir;
            String downloadsDir;

            // Verificar idioma local para usar 
            // nombres correctos de carpetas
            if (Locale.getDefault()
                .getLanguage().equals("es")) {
                documentsDir = Paths.get(userHome, 
                "Documentos").toString(); 
                downloadsDir = Paths.get(userHome, 
                "Descargas").toString(); 
            } else {
                documentsDir = Paths.get(userHome, 
                "Documents").toString(); 
                downloadsDir = Paths.get(userHome,
                "Downloads").toString(); // inglés
            }

            // Crear objetos Path para los directorios
            Path documentosPath = Paths.get(documentsDir);
            Path descargasPath = Paths.get(downloadsDir);
            Path inicioUsuarioPath = Paths.get(userHome);

            System.out.println("Contenido del" +
            " directorio usuario: " + userHome);
                //! Requiere un archivo creado con una String
            listarContenidoConFile(new File(userHome));
                //! Requiere un Path ya que usa Files (nueva API)
            listarContenidoConFiles(inicioUsuarioPath);

            System.out.println("\nContenido del" +
            " directorio de Documentos: " + documentsDir);
            listarContenidoConFile(new File(documentsDir));
            listarContenidoConFiles(documentosPath);

            System.out.println("\nContenido del" +
            " directorio de Descargas: " + downloadsDir);
            listarContenidoConFile(new File(downloadsDir));
            listarContenidoConFiles(descargasPath);

        } catch (Exception e) {
            System.err.println("Ocurrió un error: " 
            + e.getMessage());
        }
    }

    // Listar contenido con la clase java.io.File
    public static void listarContenidoConFile(File directorio) {
        if (directorio.exists() && directorio.isDirectory()) {
            System.out.println("*** Usando java.io.File ***");
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    System.out.println((archivo
                    .isDirectory() 
                    ? "[Directorio] " : "[Archivo] ")
                    + archivo.getName());
                }
            } else {
                System.out.println("El directorio está" 
                + " vacío o no se puede acceder.");
            }
        } else {
            System.out.println("El directorio" +
            "  especificado no existe o no es válido.");
        }
    }

    // Listar contenido con la clase java.nio.file.Files
    public static void listarContenidoConFiles(Path directorio) {
        System.out.println("*** Usando java.nio.file.Files ***");
        try (Stream<Path> paths = Files.list(directorio)) {
            paths.forEach(path -> {
                System.out.println((Files.isDirectory(path) 
                ? "[Directorio] " : "[Archivo] ") 
                + path.getFileName());
            });
        } catch (NoSuchFileException e) {
            System.out.println("El directorio" + 
            " especificado no existe.");
        } catch (IOException e) {
            System.err.println("Error al listar contenido: " 
            + e.getMessage());
        }
    }

}
```
</tab>   
</tabs>
</procedure>
<p>Como se puede notar, el trabajo con un sistema mucho más robusto como es Java.nio.Path es sencillo y provee de un 
mecanismo unido con Paths para trabajar con direcciones sencillamente dentro del sistema, permitiendo formar 
direcciones en el sistema sin tener en cuenta los separadores del sistema que pueden causar problemas al buscar 
archivos. 
<br/><br/>
Para cerrar esta sección interna, la siguiente tabla compara estas estructuras junto con el mecanismo de la clase 
Java.io.File que usaba strings para representar direcciones de archivos.
</p>
<procedure>
    <table>
        <tr>
            <th>Comparativa</th>
            <th>String (Java.io.File)</th>
            <th>Java.nio.file.Path & Paths</th>
        </tr>
        <tr>
            <td>Representación</td>
            <td>Se trata de simples cadenas de texto (<code>String</code>) que representan rutas de archivos o directorios.</td>
            <td>Utiliza la clase <code>Path</code>, que representa una ruta como un objeto rico con métodos específicos.</td>
        </tr>
        <tr>
            <td>Creación de Rutas</td>
            <td>Se crean directamente con un string, p. ej., <code>new File("ruta")</code>.</td>
            <td>Rutas creadas mediante <code>Paths.get()</code>, que devuelve un objeto <code>Path</code>.</td>
        </tr>
        <tr>
            <td>Facilidad de Manejo</td>
            <td>Depende de la manipulación manual de cadenas, lo que puede ser propenso a errores.</td>
            <td>Ofrece métodos modernos como <code>resolve()</code> y <code>normalize()</code> para trabajar fácilmente con rutas.</td>
        </tr>
        <tr>
            <td>Comprobación de Existencia</td>
            <td>Verificación mediante métodos básicos como <code>exists()</code> en el objeto <code>File</code>.</td>
            <td>Incorpora <code>Files.exists()</code>, que se puede usar directamente sobre un objeto <code>Path</code>.</td>
        </tr>
        <tr>
            <td>Separador de Rutas</td>
            <td>Necesita manejar manualmente separadores de rutas específicos del sistema, como <code>\</code> o <code>/</code>.</td>
            <td>Automáticamente adapta los separadores al sistema subyacente utilizando <code>FileSystems.getDefault()</code>.</td>
        </tr>
        <tr>
            <td>Soporte para Operaciones Complejas</td>
            <td>Limitado a operaciones básicas como obtener el nombre o el directorio padre.</td>
            <td>Soporta operaciones avanzadas como comprobar rutas relativas y absolutas mediante <code>Path.isAbsolute()</code> y <code>Path.toAbsolutePath()</code>.</td>
        </tr>
        <tr>
            <td>Inmutabilidad</td>
            <td><code>File</code> no es estrictamente inmutable, ya que permite cambios en ciertos atributos.</td>
            <td>Rutas <code>Path</code> son completamente inmutables.</td>
        </tr>
        <tr>
            <td>Iteración</td>
            <td>No provee un mecanismo directo para iterar carpetas.</td>
            <td>Permite iterar carpetas mediante <code>Path.iterator()</code>.</td>
        </tr>
    </table>
</procedure>

<p>Con esta breve vista a las clases helper que tiene Java para el manejo de archivos, podemos pasar a analizar los 
métodos de lectura y escritura de archivos, tanto binario como en formato de texto</p>

## Input y Output Hacia Archivos: Métodos de trabajo

### Text I/O 
<p> Para trabajar en un sistema con archivos de tipo texto, es decir con un encoding tipo ASCII o UTF-8, Java ha 
diseñado varias clases que nos permiten obviar el paso de conversion de binario (ya que todo archivo está guardado en binario) hacia Strings. De esta forma, para este tipo de archivos Java presenta una jerarquía de clases completa que nos permite manejar archivos de texto fácilmente y con ayudas extras detrás en el sistema. </p>

#### Jerarquía Writer
<p> En Java el manejo de archivos con formato se maneja a través de dos jerarquías de clases distintas, 
<code>Jerarquía Writer y Jerarquía Reader</code>, estas dos jerarquías de clases implementan capacidades 
extra sobre los lectores de archivos binarios de Java y nos permiten convertir aisladamente los bits leídos por la 
JVM directamente en texto (Strings en la mayoría de los casos) sin tener que hacer una conversión explícita a 
través de un método.
<br/><br/>
En esta primera instancia, analizaremos la jerarquía de clases Writer, la cual incluye varios escritores a archivos. 
La siguiente imagen muestra la jerarquía en su tamaño general, aunque de estas clases (por la extensión del curso), 
no podamos revisar todos.
</p>
<procedure>

![JerarquiaWriter.png](JerarquiaWriter.png)
</procedure>
<p> Las clases presentadas anteriormente, tienen en cuenta una jerarquía que nace de la clase abstracta Writer  se 
manejan en diversas implementaciones que son de gran utilidad para poder trabajar con archivos, en específico, 
aquellas clases escritoras que más se utilizan son.</p>
<list columns="2">
<li><b><format color="CornFlowerBlue">FileWriter</format></b>: Clase usada para escribir directamente a un archivo 
codificando bits enviados con un encoding especificado en creación o con el default del sistema.
<br/>
Esta clase permite escribir hacia archivos de una manera prolija con métodos de escritura <code>write()</code>.
</li> 
<li><b><format color="CornFlowerBlue">PrintWriter</format></b>: Clase usada para escribir directamente a un archivo 
pero como si fuera una salida a consola, es decir, <code>con métodos similares a los de System.out</code>, dando la 
facilidad de escribir líneas, líneas sin salto, saltos de línea solos, formatos, etc. <br/> 
Esta clase es muy útil al iniciar el análisis de archivos, ya que permite escribir con formatos completos</li>   
<li><b><format color="CornFlowerBlue">BufferedWriter</format></b>: Una clase que se usa generalmente para envolver a 
a un FileWriter u otros Writers para mejorar su performance de escritura, esto ya que no escriben todo el tiempo 
directamente, solo en ciertos intervalos mediante un buffer interno. 
<br/>
Esta es una clase muy útil cuando tenemos un objeto writer cuya forma de trabajo sea una escritura contínua hacia el 
archivo.
</li>   
<li><b><format color="CornFlowerBlue">StringWriter</format></b>: Clase que permite escribir hacia un archivo de una 
manera en la que se escriba una sola String, como si fuera un buffer (un StringBuffer) que contiene todas las 
modificaciones del texto. Al implementarse sobre un StringBuffer, es mucho más seguro y eficiente, asímismo permite 
modificacioes en entornos de programación multi-hilo, etc.
en un solo  </li> 
</list>
<p> Una vez analizados el medio de trabajo de estas clases, el siguiente ejemplo presenta el mecanismo de trabajo para primero crear un archivo y luego escribir diferentes secciones representativas mediante cada uno de estos Writers. </p>
<procedure>
<tabs>
<tab title="Jerarquía Writer">

```Java
package io_examples;


package io_examples;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOExampleFour {
public static void main(String[] args) {
// Ruta del archivo que será creado
Path rutaArchivo = Paths.get("src/main/resources"
                        ,"ejemplo_escritura.txt");

        // Intentar crear el archivo
        try {
            if (!Files.exists(rutaArchivo)) {
                Files.createFile(rutaArchivo);
                System.out.println("Archivo creado" + 
                " exitosamente: " 
                + rutaArchivo.toString());
            } else {
                //! Limpiamos el archivo
                new FileWriter(rutaArchivo.toFile(), 
                false).close(); 
                System.out.println("El archivo ya existe: "
                + rutaArchivo.toString());
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " 
            + e.getMessage());
            return;
        }

        // Verificar si el archivo existe antes de trabajar con el
        if (Files.exists(rutaArchivo)) {
            // Escribir datos al archivo utilizando 
            // diferentes Writers
            try (FileWriter fileWriter = new 
                        FileWriter(rutaArchivo.toFile(), true);
                 PrintWriter printWriter = 
                        new PrintWriter(new 
                            FileWriter(rutaArchivo.toFile()
                                                  , true));
                 BufferedWriter bufferedWriter = 
                        new BufferedWriter(
                            new FileWriter(
                            rutaArchivo.toFile(), true))) 
            {

                // Mensajes informativos 
                // y escritura con FileWriter
                fileWriter.write("Escribiendo con FileWriter: [");
                for (int i = 0; i < 10; i++) {
                    fileWriter.write(i + 
                               (i < 9 ? ", " : "]\n"));
                }

                // Mensajes informativos 
                // y escritura con PrintWriter
                printWriter.print("Escribiendo" + 
                        " con PrintWriter: ");
                printWriter.print("[");
                for (int i = 0; i < 10; i++) {
                    printWriter.print(i + 
                                (i < 9 ? ", " : "]\n"));
                }

                // Mensajes informativos 
                // y escritura con BufferedWriter
                bufferedWriter.write("Escribiendo" + 
                                " con BufferedWriter: [");
                for (int i = 0; i < 10; i++) {
                    bufferedWriter.write(i + 
                                   (i < 9 ? ", " : "]\n"));
                }

            } catch (IOException e) {
                System.err.println("Error al escribir" + 
                " en el archivo: " + e.getMessage());
            }

            // Escritura con StringWriter
            try (StringWriter stringWriter = 
                    new StringWriter()) {
                stringWriter.write("Escribiendo" + 
                             " con StringWriter: [");
                for (int i = 0; i < 10; i++) {
                    stringWriter.write(i + 
                                 (i < 9 ? ", " : "]\n"));
                }

                // Escribir el contenido 
                // del StringWriter en el archivo
                try (FileWriter fileWriter = 
                        new FileWriter(
                            rutaArchivo.toFile(), true)) {
                    fileWriter.write(stringWriter.toString());
                }
            } catch (IOException e) {
                System.err.println("Error al escribir" + 
                " en el archivo con StringWriter: " 
                + e.getMessage());
            }

        } else {
            System.err.println("El archivo no" + 
                        " pudo ser encontrado.");
        }
    }

}

```
</tab>
</tabs>
</procedure>
<p>Como se puede ver en el snippet de código anterior, tenemos un formato similar para escribir en cada uno de estas 
clases, solo que en algunas de estas tenemos que manejar de alguna forma los saltos de página (caso de FileWriter), 
como este ejemplo es sencillo, no se nota la necesidad de escribir varios saltos de línea.
</p>

#### Jerarquía Reader
<p> La jerarquía writer es la otra parte de las clases de Java que se tienen para el manejo de archivos que tienen un formato de texto. Una vez que sabemos escribir a estos archivos es importante también leer de ellos, y para esto están todas las clases de la jerarquía Reader, que se muestran a continuación </p>
<procedure>

![JerarquiaReader.png](JerarquiaReader.png)
</procedure>
<p> De las clases que se muestran en la jerarquía anterior, se analizarán en este curso </p>
<code>StringReader, LineNumberReader y FileReader </code> <p>, las cuales nos 
van a permitir 
demostrar la manera de leer archivos y las facilidades que presentan estas a la hora de analizar el contenido de 
estos en nuestros programas. Pero como se realizó en la anterior sección, es importante analizar de manera breve los 
beneficios de cada una de estas clases. </p>
<list columns="3">
<li><b><format color="CornFlowerBlue">StringReader</format></b>: Clase que permite leer un archivo de tal manera que 
todo el contenido de este se carga en una sola String interna. Es decir, el contenido es una cadena entera, en el 
cual nos podemos desplazar por caracteres o por saltos. 
<br/>
Usualmente se usa esta clase en conjunción con un BufferedReader, el cual nos permita leer por líneas, y no nos 
obligue a leer un número específico de posiciones cada vez.
</li> 
<li><b><format color="CornFlowerBlue">LineNumberReader</format></b>: Una clase que permite la lectura de líneas de 
un archivo manteniendo un registro de la linea en la que el lector se encuentra y el número de la misma con respecto 
del archivo. Esto facilita el movimiento de arriba y hacia abajo en un archivo mediante el número de la línea y no 
por saltos.
<br/>
Esta clase se puede usar por su cuenta dado su manera de trabajo.
</li> 
<li><b><format color="CornFlowerBlue">FileReader</format></b>: Clase que permite la lectura de una serie de 
caracteres desde un archivo hacia un buffer interno. Esta clase se encarga de transformar los caracteres así como 
las otras clases mostradas anteriormente. La idea de esta clase es que puede ser usada con un LineNumberedReader o 
un BufferedReader. No se recomienda usar sola.
</li> 
</list>
<p> El siguiente bloque de código muestra las funcionalidades generales de estos lectores con el mismo archivo de prueba usado en el bloque anterior </p>
<procedure>
<tabs>
<tab title="Jerarquía Reader">
<code-block lang="Java">
    package io_example;
    
    import java.io.*;
    
    public class IOExampleFive {
    public static void main(String[] args) {
    // Ruta del archivo para lectura
    File archivo = new
    File(
    "src/main/resources/ejemplo_escritura.txt");
    
            // Verificar si el archivo existe
            if (!archivo.exists()) {
                System.err.println("El archivo no existe: " 
                + archivo.getAbsolutePath());
                return;
            }
    
            // Leer el archivo usando las 
            // diferentes clases Reader
                //! Usamos FileReader
            System.out.println(
                         "=== Leyendo archivo con FileReader ===");
            try (FileReader fileReader = new FileReader(archivo)) {
                int c;
                while ((c = fileReader.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (IOException e) {
                System.err.println(
                "Error al leer el archivo con FileReader: " 
                + e.getMessage());
            }
    
            System.out.println(
                    "\n\n=== Leyendo archivo con BufferedReader ===");
            try (BufferedReader bufferedReader = 
                    new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.err.println(
                "Error al leer el archivo con BufferedReader: " 
                + e.getMessage());
            }
    
            System.out.println(
                    "\n\n=== Leyendo archivo con StringReader ===");
    
            try {
                // Cargar todo el contenido 
                // del archivo en un String usando 
                // Files.readString
                String contenido = Files.readString(archivo.toPath());
                // Usar StringReader para leer el contenido y cargarlo en 
                // un BufferedReader
                try (StringReader stringReader = 
                        new StringReader(contenido);
                     BufferedReader bufferedReader = 
                        new BufferedReader(stringReader)) {
                    String linea;
                    while ((linea = 
                            bufferedReader.readLine()) != null) {
                        System.out.println(linea);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al leer" + 
                " el archivo con StringReader: " 
                + e.getMessage());
            }
    
            System.out.println("
            \n\n=== Leyendo archivo con LineNumberReader ===");
            try (LineNumberReader lineNumberReader = 
                new LineNumberReader(new FileReader(archivo))) {
                String linea;
                while ((linea = lineNumberReader.readLine()) != null) {
                    System.out.printf("Línea %d: \s\n", lineNumberReader
                    .getLineNumber(), linea);
                }
            } catch (IOException e) {
                System.err.println(
                "Error al leer el archivo con LineNumberReader: " 
                + e.getMessage());
            }
        }
    
    }
</code-block>

</tab>
</tabs>
</procedure>
<p>Con los ejemplos de lectura y escritura de esta sección, hemos notado las bases de como leer y escribir hacia 
archivos en este programa, asi como la manera de crear archivos y manejarlos. La siguiente sección se encargará de 
mostrar como se trabaja con archivos en binario</p>

### Binary I/O
<p> El segundo y menos utilizado en términos del curso es el tipo de lectura de archivos en binario. Usuálmente se 
utiliza para serializar datos, clases, o el estado de un programa en un formato que no permita la fácil conversión 
del mismo hacia un formato legible y su modificación indebida. Este en general es un tipo de concepto que se analiza 
en el tema de serialización de datos de programación de apps, más no en una clase introductoria o estructuras de 
datos. <br/><br/>
No obstante, es importante cubrir ambos tipos de archivos para mantener el nivel de este curso.</p>

#### Jerarquía OutputStream
<p> Dentro de las clases existentes en Java para trabajar con archivos de tipo binario, es clave destacar la 
jerarquía del OutputStream la cual es extendida hasta cierto punto mediante otras clases para la lectura de archivos 
con formato. No obstante, estas clases son muy útiles para analizar archivos en binario. A continuación se establece 
un listado de las clases más comunes de esta jerarquía y sus usos. 
</p>
<list columns="2">
<li><b><format color="CornFlowerBlue">FileOutputStream</format></b>: Clase base para manejar la escritura de datos 
binarios directamente en un archivo, byte por byte. 
<br/>
Puede ser usada sola, pero se recomienda combinar con un <code>BufferedOutputStream</code> para mejorar el 
rendimiento al procesar grandes volúmenes de datos.
</li> 
<li><b><format color="CornFlowerBlue">BufferedOutputStream</format></b>: Clase que envuelve a un <code>FileOutputStream</code> para ofrecer mayor eficiencia mediante un buffer de escritura. 
<br/>
Evita múltiples accesos directos al sistema de archivos, acumulando los datos en memoria antes de escribirlos en el archivo.
</li>
<li><b><format color="CornFlowerBlue">DataOutputStream</format></b>: Clase que permite escribir datos primitivos 
(boolean, int, char, double, etc.) en un formato binario de manera estructurada.
<br/>
Generalmente, se utiliza encima de un <code>FileOutputStream</code> o un <code>BufferedOutputStream</code> para 
facilitar la escritura de tipos de datos predefinidos.
</li>
<li><b><format color="CornFlowerBlue">ObjectOutputStream</format></b>: Clase avanzada que se utiliza para serializar objetos completos y escribirlos en un archivo binario. 
<br/>
Requiere que las clases de los objetos implementen <code>Serializable</code>. Se usa frecuentemente junto con un 
<code>FileOutputStream</code>.
</li>
</list>
<p> Una vez analizado este tipo de archivos, podemos revisar un poco de código para estos tipos de escritores de archivos </p>
<procedure>
<tabs>
<tab title="Jerarquía OutputStream">

```Java
package io_example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOExampleSix {
    public static void main(String[] args) {
        // Ruta del archivo para escritura binaria
        File file = 
            new File("src/main/resources/binary_output.dat");
        try {
            // Crear el archivo si no existe
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Archivo creado" + 
                    " exitosamente: " 
                    + file.getAbsolutePath());
                } else {
                    System.out.println("No se pudo" + 
                    " crear el archivo.");
                    return;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al crear" + 
            " el archivo: " + e.getMessage());
            return;
        }
        // Escritura de datos binarios usando 
        // diferentes tipos de OutputStreams
        System.out.println(
        "\n=== Escribiendo datos con diferentes Writers ===");
        // 1. Escribir bytes directamente con FileOutputStream
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(
                "Escribir con FileOutputStream.\n"
                .getBytes());
            System.out.println("Datos escritos" + 
            " con FileOutputStream.");
        } catch (IOException e) {
            System.err.println("Error al escribir" +
            " con FileOutputStream: " 
            + e.getMessage());
        }
        // 2. Mejorar eficiencia con BufferedOutputStream
        try (BufferedOutputStream bos = 
                new BufferedOutputStream(
                    new FileOutputStream(file, true))) {
            bos.write("Escribir con BufferedOutputStream.\n"
                .getBytes());
            System.out.println("Datos escritos con "+ 
                            " BufferedOutputStream.");
        } catch (IOException e) {
            System.err.println("Error al escribir" 
            + " con BufferedOutputStream: " 
            + e.getMessage());
        }
        // 3. Escritura de datos primitivos 
        // con DataOutputStream
        try (DataOutputStream dos = 
                    new DataOutputStream(
                    new BufferedOutputStream(
                    new FileOutputStream(file, true)))) {
            dos.writeInt(42); // Un entero
            dos.writeDouble(3.14159); // Un número flotante
            // Una cadena
            dos.writeUTF("Texto a través de DataOutputStream.\n"); 
            System.out.println("Datos primitivos" + 
            " escritos con DataOutputStream.");
        } catch (IOException e) {
            System.err.println("Error al escribir"+
            " con DataOutputStream: " + e.getMessage());
        }
        // 4. Serialización de objetos 
        // con ObjectOutputStream
        try (ObjectOutputStream oos = 
                new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(file, true)))) {
            List< String > exampleList = new ArrayList<>();
            exampleList.add("Elemento 1");
            exampleList.add("Elemento 2");
            exampleList.add("Elemento 3");
            // Serializar una lista de objetos
            oos.writeObject(exampleList); 
            System.out.println("Objeto serializado"+
            " y escrito con ObjectOutputStream.");
        } catch (IOException e) {
            System.err.println("Error al escribir"+ 
            " con ObjectOutputStream: " 
            + e.getMessage());
        }

        System.out.println(
        "\n=== Escritura binaria completada ===");
    }
}
```
</tab>
</tabs>
</procedure>

#### Jerarquía InputStream
<p> La siguiente jerarquía, y la última de nuestro análisis de las bases del manejo de archivos en Java es la jerarquía InputStream, la cual se usa para leer archivos de tipo binario. Las siguientes son las principales clases que se usan en esta jerarquía </p>
<list columns="2">
<li><b><format color="CornFlowerBlue">FileInputStream</format></b>: Clase para leer datos binarios directamente desde un archivo, byte por byte.
<br/>
Ideal para leer datos crudos, como archivos de imagen, audio o cualquier formato no textual.
<br/>
Puede usarse directamente o combinado con un <code>BufferedInputStream</code> para mejorar el rendimiento.
</li>
<li><b><format color="CornFlowerBlue">BufferedInputStream</format></b>: Clase que mejora la eficiencia de las lecturas al usar un buffer para almacenar temporalmente los datos leídos.
<br/>
Reduce el número de accesos al disco o al sistema de archivos, ofreciendo mayores velocidades al leer grandes cantidades de datos.
<br/>
Usualmente envuelve a un <code>FileInputStream</code>.
</li>
<li><b><format color="CornFlowerBlue">DataInputStream</format></b>: Clase para leer datos primitivos (como <code>int</code>, <code>double</code>, <code>boolean</code>, etc.) desde un flujo de entrada binario de forma estructurada.
<br/>
Típicamente se combina con un flujo subyacente como <code>FileInputStream</code> o <code>BufferedInputStream</code>.
<br/>
Útil para leer datos que fueron escritos usando un <code>DataOutputStream</code>.
</li>
<li><b><format color="CornFlowerBlue">ObjectInputStream</format></b>: Clase que permite de-serializar objetos previamente escritos en un flujo binario.
<br/>
Lee y reconstruye objetos que fueron serializados usando <code>ObjectOutputStream</code>. 
<br/>
Requiere que las clases de los objetos implementen <code>Serializable</code>.
<br/>
Es muy útil para persistencia de datos o transmisión de objetos entre aplicaciones.
</li>
</list>
<p> Las clases mencionadas anteriormente nos permiten desarrollar el siguiente ejemplo </p>
<procedure>
<tabs>
<tab title="Jerarquía InputStream">

```Java
package io_example;

import java.io.*;
import java.util.List;

public class IOExampleSeven {
    public static void main(String[] args) {

        // Ruta del archivo para lectura binaria
        File file = 
            new File("src/main/resources/binary_output.dat");

        // Verificar si el archivo existe y no está vacío
        if (!file.exists() || file.length() == 0) {
            System.err.println(
                "El archivo no existe o está vacío: " 
                + file.getAbsolutePath());
            return;
        }

        System.out.println(
            "\n=== Leyendo datos con diferentes Readers ===");

        // 1. Leer bytes directamente con FileInputStream
        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println(
                "\n> Leyendo datos crudos"+ 
                " con FileInputStream:");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println(
                    "\nDatos leídos con FileInputStream.");
        } catch (IOException e) {
            System.err.println(
                    "Error al leer con FileInputStream: " 
                    + e.getMessage());
        }

        // 2. Mejorar eficiencia con BufferedInputStream
        try (BufferedInputStream bis = new BufferedInputStream(
                                    new FileInputStream(file))) {
            System.out.println(
                "\n> Leyendo datos" + 
                    " con BufferedInputStream:");
            int data;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println(
                    "\nDatos leídos con BufferedInputStream.");
        } catch (IOException e) {
            System.err.println(
            "Error al leer con BufferedInputStream: " 
            + e.getMessage());
        }

        // 3. Leer datos estructurados con DataInputStream
        try (DataInputStream dis = 
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream(file)))) {
            System.out.println("\n> Leyendo datos" + 
                    "primitivos con DataInputStream:");
            // Verificar si hay datos disponibles
            while (dis.available() > 0) { 
                int intValue = dis.readInt();
                double doubleValue = dis.readDouble();
                String stringValue = dis.readUTF();

                System.out.println("Entero leído: " 
                + intValue);
                System.out.println("Double leído: " 
                + doubleValue);
                System.out.println("Cadena leída: " 
                + stringValue);
            }
            System.out.println("Datos primitivos leídos" +
                " con DataInputStream.");
        } catch (IOException e) {
            System.err.println(
            "Error al leer con DataInputStream: " 
            + e.getMessage());
        }

        // 4. Deserializar objetos con ObjectInputStream
        try (ObjectInputStream ois = 
                new ObjectInputStream(
                    new BufferedInputStream(
                        new FileInputStream(file)))) {
            System.out.println("\n> Leyendo objeto" +
                " serializado con ObjectInputStream:");
            Object obj = ois.readObject();
            if (obj instanceof List) {
                List<String> exampleList = (List<String>) obj;
                System.out.println("Lista de objetos deserializada:");
                exampleList.forEach(System.out::println);
            }
            System.out.println(
                    "Objeto leídos con ObjectInputStream.");
        } catch (EOFException eof) {
            System.out.println(
                "Fin del archivo alcanzado" + 
                " durante la deserialización.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(
                "Error al leer con ObjectInputStream: " 
                + e.getMessage());
        }

        System.out.println(
            "\n=== Lectura binaria completada ===");
    }
}
```
</tab>
</tabs>
</procedure>






