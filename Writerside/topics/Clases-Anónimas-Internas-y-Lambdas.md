# OOP - Clases Anónimas, Internas y Lambdas

> Un componente fundamental en el desarrollo de aplicaciones, y en general, en el desarrollo como programador en Java
> es el conocimiento de las clases anónimas, internas y métodos lambdas. Estos se usan a menudo dentro de las clases 
> y métodos referentes a estructuras de datos en Java, archivos, etc. Es muy important conocer la diferencia entre 
> estas tres, no solo por su versatilidad, sino por su capacidad de simplificar el proceso de desarrollo

<p> En Java, una gran parte del trabajo se realizan en archivos que, por definición, no pueden contener más de una 
clase pública que compartir con otros archivos, paquetes, módulos, etc. Sin embargo, también existen herramientas en 
Java destinadas a permitir la creación, extensión y transmisión de código y clases sin tener que declararlas dentro 
del mismo archivo, más bien, declarándolas dentro de la clase original. Estas son las llamadas <code>clases 
internas</code> <br/><br/>
Asimismo, algunas secciones de Java, especialmente aquellas relacionadas con las colecciones han desarrollado métodos 
cuyo prototipo solicita una instancia de una clase abstracta o una interface (ver sección anterior para los 
requerimientos individuales de estas estructuras), en estas secciones, si el código no es útil para todo el programa 
se puede trabajar con <code>clases anónimas</code>, proveyendo de una implementación para estas estructuras sin 
tener que declararlas dentro del mismo archivo u otro aparte, disminuyendo la complejidad de nuestra codebase y 
manteniendo la legibilidad del código.
<br/><br/>
En tercer lugar, Java también permite, al igual que en C++, el uso de métodos Lambda, es decir código anónimo no 
relacionado con una clase sino con un cuerpo de función especifico que se puede compartir. Estos son especialmente 
útiles para incrementar aún más la legibilidad de nuestro código en secciones en donde hayamos enviado una clase 
anónima. Es más, en IntelliJ, existen herramientas internas que te ayudan a reducir una clase anónima en un método 
lambda y luego un <code>method reference</code>.<br/><br/>
En esta sección, estudiaremos las reglas estructurales de estas metodologías de trabajo, y algunos ejemplos de su 
uso con clases relacionadas con el manejo de estructuras de datos.
</p>

## Clases Internas
<p> Como se estableció anteriormente, una clase interna es una variación sobre la declaración de una clase básica 
que se declara <code>dentro de una clase de tipo top-level-class</code>. Es decir, estas clases se declaran dentro 
de la única clase pública del archivo. Esto quiere decir que está sujeta a modificadores de acceso propio, los 
cuales le pueden permitir instanciación, o no, etc.
<br/><br/>
En este caso, la diferencia clave de este tipo de clases con otras es que <code> están sujetas a una clase externa, 
por tanto, pueden ser instanciadas o no, algo que no se puede hacer con clases secundarias en un archivo
</code>. Para comprender este proceso, en primera instancia revisemos algunos de los requerimientos (tal como en la 
anterior sección), con respecto a su definición, contenido y modificadores.
</p>

<procedure>
<tabs>
<tab title="Reglas Con Respecto a su Definición">
<list>
<li><b><format color="CornFlowerBlue">Definición e Implementación General</format></b>: Una clase interna, se define 
como una clase cuyo cuerpo, métodos, y parámetros se encuentran dentro de una <code>top-level-class</code>. Esto 
quiere decir que está sujeto a las reglas de visibilidad de los modificadores de acceso con los que se la defina. 
Asimismo, sus contenidos siguen sujetos a las reglas de visibilidad internas de <code>sus propios modificadores 
internos para campos o métodos</code>.
<br/>
En este sentido, una clase interna se puede considerar como un parámetro interno de una clase general, la cual puede 
o no ser instanciada, asi como puede o no ser visible por fuera de su clase general.
<br/>
El siguiente bloque de código muestra como implementar una serie de clases de este estilo, manejando modificadores 
de acceso.

```Java
//... en el archivo TopLevelClassA.java
package OOP_Examples;

// Clase de nivel superior
public class TopLevelClassA {
    // Clase interna pública
    /*
     * Esta clase puede ser usada dentro 
     * de otros archivos solo a traves de 
     * una instancia de la clase superior
    */
    public class A1 {
        //... cuerpo aqui
    }
    
    // Clase interna privada
    /*
     * Esta clase no puede ser usada dentro 
     * de otros archivo solo se puede usar 
     * dentro de la clase superior
    */
    private class A2 {
        //... cuerpo aqui
    }
    
    // Clase interna protegida
    /*
     * Esta clase puede ser usada dentro de 
     * otros archivos donde existan clases 
     * que hayan extendidoa a la clase
     * superior
    */
    protected class A3 {
        //... cuerpo aqui
    }

    // Clase interna estática
    /*
     * Esta clase puede ser instanciada dentro de 
     * otros archivos independiente de la creacion 
     * de otra instancia de la clase superior
    */
    public static class A4 {
    }
    
    // Clase interna estática final
    /*
     * Esta clase puede ser instanciada dentro de 
     * otros archivos independientemente como una 
     * clase estática, y su contenido no puede ser modificado
     */
    public static final class A5 {
        //... cuerpo aquí
    }
    
    // Clase interna pública final
    /*
     * Esta clase puede ser usada dentro de otros 
     * archivos a través de una instancia de la clase 
     * superior, pero su contenido no puede ser modificado
     */
    public final class A6 {
        //... cuerpo aquí
    }
}

```
</li> 
<li><b><format color="CornFlowerBlue">Herencia de Clases Internas y Entre Clases</format></b>: Las clases internas, 
al ser clases normales solo que en un marco de visibilidad diferente, <code>pueden tanto implementar una o 
varias interfaces, asi como extender una clase</code>. Si bien las clases externas pueden intentar extender una 
clase interna de otra clase <code>la extensión (herencia) de una clase externa de una clase interna se basa en las 
siguientes reglas
</code>
<list style="alpha-lower">
    <li>Una clase externa top-level-class puede acceder a una clase interna de otra y extenderla solo si es 
<code>public y static</code>, si esta cuenta con el modificador <code>final</code>, aunque sea estática y publica 
no puede ser extendida</li>
    <li>Una clase externa top-level-class no puede acceder a clases que solo tengan el modificador de acceso 
<code>public</code>, y no puede extenderla al ser una clase que depende de una instancia de la clase externa en la 
que fue definida</li>
</list>
<p> El siguiente ejemplo muestra un claro ejemplo de extensión de clases internas por parte de otras externas asi como extension en clases internas </p>
<br/>

```Java

//... en el archivo TopLevelClassB.java
package OOP_Examples;

// Clase de nivel superior
public class TopLevelClassB {

    // Clase interna pública y estática
    /*
     * Esta clase puede ser usada dentro de otros 
     * archivos debido a su visibilidad pública y 
     * no está limitada por una instancia de l
     * a clase superior.
     */
    public static class B1 {
        // Cuerpo de la clase
        private int value;

        public B1(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}

//... en el archivo ExternalClass.java
// Clase externa que extiende a la clase interna estática
/*
 * Este ejemplo utiliza una extensión válida, ya que 
 * la clase interna es pública y estática en la clase 
 * superior original.
 */
class ExternalClass extends TopLevelClassB.B1 {

    public ExternalClass(int value) {
        super(value);
    }

    // Clase interna privada
    /*
     * Esta clase interna de ExternalClass implementa Comparable 
     * y extiende SortedList. Solo es visible y accesible dentro 
     * de ExternalClass debido a su modificador privado.
     */
    private class InnerComparable 
                extends SortedList 
                implements Comparable<InnerComparable> {
        private String name;

        public InnerComparable(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(InnerComparable other) {
            return this.name
            .compareToIgnoreCase(other.getName());
        }

        @Override
        public void sort() {
            //! Metodo proveniente de sorted list
        }
        
        @Override
        public String toString() {
            return "InnerComparable{name='" + name + "'}";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || 
                this.getClass() != obj.getClass()) {
                return false;
            }
            InnerComparable that = (InnerComparable) obj;
            return this.name != null ? 
                    this.name.equalsIgnoreCase(that.name) 
                    : that.name == null;
        }
    }
}

// Clase abstracta SortedList para mostrar extensión
/*
 * Ejemplo de una superclase utilizada en el ejemplo anterior.
 */
abstract class SortedList {
    public abstract void sort();
}
```
</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a su Contenido">
<list>
<li><b><format color="CornFlowerBlue">Contenido de las Clases Internas</format></b>: Las clases internas, al igual que las clases normales, pueden contener diferentes elementos. Estos incluyen atributos, métodos, constructores, inicializadores e incluso otras clases internas. A continuación, se enumeran las reglas específicas respecto al contenido de una clase interna:

<ul>
    <li><b>Atributos:</b>
        <ul>
            <li>Pueden ser de cualquier nivel de acceso: <code>public</code>, <code>private</code>, <code>protected</code>, o con acceso por defecto.</li>
            <li>Pueden ser <b>estáticos</b> o <b>no estáticos</b>, dependiendo del tipo de clase interna.</li>
            <li>Los atributos <b>estáticos</b> solo están permitidos dentro de clases internas <b>estáticas</b>.</li>
        </ul>
    </li>
    <li><b>Métodos:</b>
        <ul>
            <li>Pueden ser de cualquier nivel de acceso: <code>public</code>, <code>private</code>, <code>protected</code>, o con acceso por defecto.</li>
            <li>Pueden ser definidos como <b>abstractos</b>, <b>finales</b> o <b>estáticos</b>. En el caso de 
definir métodos abstractos <code>se requiere definir a la clase interna como una clase abstracta</code></li>
            <li>Los métodos <b>estáticos</b> solo están permitidos dentro de clases internas <b>estáticas</b>.</li>
        </ul>
    </li>
    <li><b>Constructores:</b>
        <ul>
            <li>Son definidos para inicializar los objetos de la clase interna.</li>
            <li>El alcance del constructor depende del modificador de acceso (<code>public</code>, <code>private</code>, etc.) asignado.</li>
        </ul>
    </li>
    <li><b>Inicializadores estáticos y no estáticos:</b>
        <ul>
            <li>Los inicializadores <b>estáticos</b> solo pueden usarse dentro de clases internas <b>estáticas</b>.</li>
        </ul>
    </li>
    <li><b>Clases internas anidadas:</b>
        <ul>
            <li>Una clase interna puede anidar otra clase interna.</li>
            <li>Estas clases anidadas siguen las mismas reglas de visibilidad que aplican para las clases de nivel superior.</li>
        </ul>
    </li>
</ul>
</li>
</list>
</tab>
</tabs>
</procedure>
<p> Dado que el contenido y la definición de estas clases son cuasi similares a las definiciones presentadas en la 
sección anterior, para las reglas de definición (incluídas las reglas de nombramiento y declaración) siguen las 
mismas pautas presentadas anteriormente. <br/><br/>
Cabe destacar que una clase interna, aunque tenga este nombre, no solo tiene que ser una clase, puede ser una clase 
abstracta, enumeración, interface, Record, etc. Esto se demuestra en el siguiente ejemplo.</p>

```Java


//... en el archivo TopLevelClassB.java
package OOP_Examples;

// Clase de nivel superior
public class TopLevelClassB {

    // Clase interna pública y estática
    /*
     * Esta clase puede ser usada dentro de otros 
     * archivos debido a su visibilidad pública y 
     * no está limitada por una instancia de la clase superior.
     */
    public static class B1 {
        private int value;

        public B1(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    //Clase publica
    public class B2{
        //... algunos metodos
    }

    // Enumeración protegida
    /*
     * Esta enumeración tiene un acceso protegido,
     * lo que significa que solo es accesible dentro del 
     * paquete o mediante herencia.
     */
    protected enum StatusDelProceso {
        PROCESO_ACTIVO("Proceso está activo"),
        PROCESO_INACTIVO("Proceso está inactivo"),
        PROCESO_ESTADO_DESCONOCIDO
            ("Estado del proceso es desconocido");

        private final String description;

        private StatusDelProceso(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    // Interfaz con acceso privado
    /*
     * Esta es una interface privada cuyo acceso
     * esta limitado a la clase externa y su cuerpo
     */
    private interface Validator {
        boolean esValido(int value);
    }
}

//... en el archivo ExternalClass.java
// Clase externa que extiende a la clase interna estática
/*
 * Este ejemplo utiliza una extensión válida, ya que 
 * la clase interna es pública y estática en la clase 
 * superior original.
 */
class ExternalClass extends TopLevelClassB.B1 {

    public ExternalClass(int value) {
        super(value);
    }

    private class InnerComparable 
               
                implements Comparable<InnerComparable> {
        private String name;

        public InnerComparable(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(InnerComparable other) {
            return this.name
            .compareToIgnoreCase(other.getName());
        }

        @Override
        public void sort() {
            //! Metodo proveniente de sorted list
        }
        
        @Override
        public String toString() {
            return "InnerComparable{name='" + name + "'}";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || 
                this.getClass() != obj.getClass()) {
                return false;
            }
            InnerComparable that = (InnerComparable) obj;
            return this.name != null ? 
                    this.name.equalsIgnoreCase(that.name) 
                    : that.name == null;
        }
    }
    
    
    // Interface publica y estatica Speedometer
    public static interface Speedometer {
        int getSpeed();

        void setSpeed(int speed);

        default void displaySpeed() {
            System.out.println("Velocidad actual: " 
            + getSpeed() + " km/h");
        }
    }
}



```
<p>El trabajo con clases internas es muy visto en algunas librerías en donde el contenido de interfaces o 
enumeraciones se quieran controlar. En nuestro código para el curso, la librería estática <code>Colorizer</code>, 
incluye dos enumeraciones públicas, estáticas, internas que permiten delimitar las opciones de colores que se pueden 
usar en una consola de Windows.
</p>
<p> Como último dato de este tipo de clases es importante revisar como usarlas dentro de un archivo. Su instanciación no tiene el mismo formato que las clases normales, ya que en general estas clases dependen de una clase externa. </p>

```Java
package OOP_Examples;

import OOP_Examples.TopLevelClassB;

//... en el archivo TestRunner.java
/*
 * Esta clase se encarga de mostrar la manera 
 * de instancia clases internas fuera de la 
 * clase en donde fueron definidas y fuera
 * de este archivo.
*/
public class TestRunner {

    // Ejemplo de definición de un parámetro 
    // del tipo de la clase interna estática
    private TopLevelClassB.B1 parametroClaseInterna; 

    public TestRunner(TopLevelClassB.B1 parametroClaseInterna) {
        this.parametroClaseInterna = parametroClaseInterna;
    }

    public TopLevelClassB.B1 getParametroClaseInterna() {
        return parametroClaseInterna;
    }

    public static void main(String[] args) {
        // Creación de una instancia local 
        // de la clase interna estática
        TopLevelClassB.B1 instanciaLocal =
                                new TopLevelClassB.B1(10);
        System.out.println(
         "El valor de la instancia local es: " +
         instanciaLocal.getValue()); // Imprime: 10

        /*
         * Tomemos como ejemplo que exista otra clase
         * no estatica dentro de TopLevelClassB. Si 
         * este fuera el caso para instanciarla 
         * siempre requerimos tener una instancia de 
         * la clase externa        
        */
        TopLevelClass instance = new TopLevelClass();
        TopLevelClass.B2 instanceB2 = 
                     instance.new B2();
    }
}
```
## Clases Anónimas
<p> Las clases anónimas son un nivel superior en la modularización de código a la que se busca llegar en esta 
sección. Si bien ya vimos como podemos definir varias clases dentro de un mismo archivo, en algunas secciones de 
código, como en <code>Collection.sort() o Arrays.sort()</code>, existen sobrecargas de métodos que permiten ingresar 
no solo una colección de datos o un arreglo, sino que tambíen una instancia de una interface, generalmente de tipo 
<code>Comparator</code>, para usar como la base de la comparativa de ordenamiento.
<br/><br/>
Ahora bien, anteriormente habíamos revisado como definir instancias de la interface Comparator mediante clases en 
sus propios archivos, pero si nuestro código requiere hacer un ordenamiento una vez, o máximo dós veces con un 
criterio, tal vez no es necesario tener una clase externa.
<br/><br/>
Si bien podríamos definir una clase interna pública y estática que solo sea instanciada cuando necesitemos pasar un 
critério extra a un algoritmo de ordenamiento, podemos reducir el código y los archivos de nuestro proyecto si 
usamos clases anónimas, claro, esto siempre y cuando el código que vayamos a implementar no lo queramos usar en tras 
secciones del código, ya que no son clases que se pueden crear más de una vez a menos que la definamos como clase 
interna o <code>variable</code>.
<br/><br/>
Antes de pasar a ejemplos de código, es importante analizar algunas de las características esenciales de las 
clases anónimas.
</p>

<procedure>
<tabs>
<tab title="Reglas Con Respecto a su Definición">
<list>
<li><b><format color="CornFlowerBlue">Definición e Implementación General</format></b>: Una clase anónima es una 
clase que no tiene un nombre explícito, y se crea principalmente para sobrescribir métodos existentes o implementar 
interfaces o clases abstractas dentro de un cuerpo de código. Estas clases directamente extienden una clase abstracta o 
implementan una interfaz, pero su uso está limitado al bloque donde son definidas.
<br/>
En lugar de declarar una clase completa, se usa una clase anónima para instanciar y redefinir o implementar comportamiento dentro de un solo lugar.
<br/>
El siguiente bloque de código muestra un ejemplo simple donde se define y utiliza una clase anónima para implementar una interfaz.

```Java
//... en el archivo ExampleWithAnonymousClass.java

package OOP_Examples;

// Ejemplo con clases anónimas
public class ExampleWithAnonymousClass {
    public static void main(String[] args) {
        // Implementación de una 
        // interfaz con una clase anónima
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Ejecutando una clase anónima!");
            }
        };
        runnable.run();

        // Uso en un método
        ExampleWithAnonymousClass example = 
                new ExampleWithAnonymousClass();
        example.performAction(new Action() {
            @Override
            public void execute() {
                System.out.println(
                "Acción ejecutada desde" +
                " una clase anónima!");
            }
        });
    }

    public void performAction(Action action) {
        action.execute();
    }
    
    
}

// Interfaz para el ejemplo
interface Action {
    void execute();
}

//... en el archivo ArrayAndArrayListSorting.java
package OOP_Examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayAndArrayListSorting {
    public static void main(String[] args) {
        // Ejemplo con un array
        Integer[] numbersArray = {5, 2, 8, 1, 3};

        // Ordenando el array usando un Comparator 
        // con una clase anónima
        Arrays.sort(numbersArray, 
              new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, 
                                   Integer o2) {
                    return o1 - o2;
                }
              }
        );

        System.out.println("Array " + 
        " ordenado en ascendente:");
        for (int num : numbersArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Ejemplo con ArrayList
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Banana");
        stringList.add("Apple");
        stringList.add("Cherry");
        stringList.add("Mango");

        // Ordenando el ArrayList usando 
        // un Comparator con una clase anónima
        Collections.sort(stringList, 
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, 
                                       String s2) {
                        // Orden ascendente basado 
                        // en orden lexicográfico
                        return s1.compareTo(s2); 
                    }
                }
        );

        System.out.println("ArrayList" + 
        " ordenado en ascendente:");
        for (String str : stringList) {
            System.out.print(str + " ");
        }
        System.out.println();

        // Ordenamiento en orden 
        // descendente para demostrar flexibilidad
        Arrays.sort(numbersArray, 
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, 
                                       Integer o2) {
                        // Orden descendente
                        return o2 - o1; 
                    }
                }
        );

        System.out.println("Array ordenado en descendente:");
        for (int num : numbersArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        Collections.sort(stringList, 
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, 
                                       String s2) {
                        // Orden descendente 
                        // basado en orden
                        // lexicográfico
                        return s2.compareTo(s1); 
                    }
                }
        );

        System.out.println("ArrayList" + 
        " ordenado en descendente:");
        for (String str : stringList) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}

```
</li>
<li><b><format color="CornFlowerBlue">Características de las Clases Anónimas</format></b>: Las clases anónimas tienen varias características clave que definen su comportamiento:
<list style="alpha-lower">
    <li>Son creadas en el momento de la instanciación y no tienen un nombre explícito.</li>
    <li>Pueden extender una única clase o implementar una única interfaz a la vez.</li>
    <li>No pueden contener métodos o constructores explícitos, ya que su cuerpo se inicializa directamente al momento de crearlas.</li>
    <li>Están limitadas al ámbito en el que son definidas, lo que hace que su uso sea exclusivo del bloque en donde son declaradas.</li>
    <li>Si acceden a variables externas, esas variables deben ser efectivamente finales o declaradas como <code>final</code>.</li>
</list>
</li>
</list>
</tab>
<tab title="Reglas Con Respecto a su Contenido">
<list>
<li><b><format color="CornFlowerBlue">Contenido de las Clases Anónimas</format></b>: A diferencia de las clases normales o internas, las clases anónimas tienen las siguientes restricciones en cuanto a su contenido:
<ul>
    <li><b>Métodos:</b>
        <ul>
            <li>Pueden sobrescribir e implementar los métodos de la interfaz o clase abstracta
que 
implementan.</li>
            <li>No pueden declarar nuevos métodos fuera de los sobrescritos.</li>
        </ul>
    </li>
    <li><b>Constructor implícito:</b>
        <ul>
            <li>No pueden definir constructores explícitos. En su lugar, el constructor de la clase padre o interfaz es llamado implícitamente mediante los argumentos proporcionados al instanciar la clase anónima.</li>
        </ul>
    </li>
    <li><b>Restricciones de ámbito:</b>
        <ul>
            <li>No pueden usarse fuera del bloque o método donde han sido creadas.</li>
            <li>Solo pueden acceder a variables externas si estas son <code>final</code> o efectivamente finales.</li>
        </ul>
    </li>
</ul>
</li>
</list>
</tab>
</tabs>
</procedure>
<p>Dentro de los snippets de código anteriores, hemos mostrado como trabajar con estas en un modelo de trabajo de 
ordenamiento, así como su declaración en forma de variables. En los archivos del curso general, existen más ejemplos 
de su utilización que se puede revisar.
</p>

## Métodos Lambda
<p> El último paso en nuestra reducción de código y archivos en nuestra base, es la utilización de métodos Lambda. 
En C++, usualmente no se revisa este tema porque su declaración es compleja y sale del enfoque del curso. Sin 
embargo, tanto para cursos de Java y estructuras de datos, se utilizan estos tipos de métodos en ciertos contextos, 
como desarrollo y manejo de aplicaciones con interfáz gráfica, o en aplicaciones que trabajen con estructuras de 
datos internas de Java. <br/><br/>
En fin, el conocimiento de estos métodos en Java, su definición y aplicabilidad es muy útil para pasar de clases, a 
clases anónimas y en fin a métodos anónimos capaces de reducir implementaciones de archivos enteros a pocas líneas, 
especialmente en <code>interfaces funcionales</code>.
<br/><br/>
Es de vital importancia destacar que <code>por su naturaleza reductiva, los métodos lambda se pueden utilizar solo 
en interfaces funcionales donde el prototipo del método se pueda deducir de los parámetros indicados.
</code>
<br/><br/>
Por este motivo, en los ejemplos del curso y en los ejemplos de esta sección se utilizan interfaces funcionales como 
<code>Comparable, Comparator, Runnable, etc.</code>, asi como algunas interfaces propias demostrativas. Antes de 
pasar a código, conviene revisar algúnas de las características primordiales de este tipo de declaraciones.
</p>
<procedure>
<tabs>
<tab title="Reglas Con Respecto a su Definición">
<list>
<li><b><format color="CornFlowerBlue">Definición e Implementación General</format></b>: Un método lambda es una expresión que permite definir y representar el comportamiento de una interfaz funcional (una interfaz que solo tiene un único método abstracto). Los métodos lambda se introdujeron en Java 8 y están diseñados para simplificar el código, hacer que la programación sea más concisa, y facilitar la programación funcional al estilo de Java.
<br/>
Un método lambda elimina la necesidad de crear clases anónimas para implementar interfaces funcionales y se define utilizando el símbolo de flecha (<code>-></code>) que separa los parámetros de la expresión o cuerpo del método.
<br/>
El siguiente bloque de código muestra cómo implementar métodos lambda simplificando el uso de clases anónimas cuando trabajamos con interfaces funcionales.

```Java
//... en el archivo ExampleWithLambda.java
package OOP_Examples;

import java.util.function.Consumer;

public class ExampleWithLambda {
    public static void main(String[] args) {
        // Ejemplo de uso de métodos lambda 
        // con una interfaz funcional (Runnable)
        Runnable runnable = () -> 
                System.out.println(
                        "Ejecutando con un" 
                        + " método lambda!");
        runnable.run();

        // Uso con una interfaz 
        // funcional personalizada
        Action action = () -> 
                System.out.println(
                    "Acción ejecutada con un" 
                    + " método lambda!");
        action.execute();

        // Uso con interfaces 
        // funcionales predefinidas 
        // (Ejemplo: Consumer de Java)
        Consumer<String> consumer = message -> 
                   System.out.println("Mensaje recibido: " 
                   + message);
        consumer.accept("Hola, mundo con Lambda!");
    }

    // Interfaz funcional personalizada (un único método abstracto)
    @FunctionalInterface
    interface Action {
        void execute();
    }
}
```
</li>
<li><b><format color="CornFlowerBlue">Características de los Métodos Lambda</format></b>: Los métodos lambda tiene varias características fundamentales que los definen:
<list style="alpha-lower">
    <li>Solo pueden implementarse con interfaces funcionales (que contengan solo un método abstracto).</li>
    <li>La sintaxis es concisa y no requiere definir clases o métodos separados.</li>
    <li>El tipo de los parámetros puede inferirse automáticamente, aunque es posible declararlo explícitamente.</li>
    <li>Pueden implementarse para cualquier interfaz funcional personalizada o interfaces funcionales predefinidas (del paquete <code>java.util.function</code>).</li>
    <li>El cuerpo del método lambda puede contener una sola expresión o un bloque de múltiples líneas, dependiendo de la complejidad requerida. Si contiene una sola expresión, no necesita la palabra clave <code>return</code>.</li>
    <li>No pueden acceder a variables externas a menos que estas sean <code>final</code> o efectivamente finales.</li>
</list>
</li>
</list>
</tab>
<tab title="Reglas Con Respecto a su Contenido">
<list>
<li><b><format color="CornFlowerBlue">Contenido de los Métodos Lambda</format></b>: Los métodos lambda son definidos para implementar de manera eficiente el comportamiento de una interfaz funcional y presentan las siguientes reglas respecto a su contenido:
<ul>
    <li><b>Métodos:</b>
        <ul>
            <li>Permiten implementar el único método abstracto de la interfaz funcional asociada.</li>
            <li>El cuerpo del método lambda puede ser:
                <ul>
                    <li><i>Una sola expresión:</i> Si la implementación es simple, como un cálculo o una operación de impresión.</li>
                    <li><i>Un bloque de varias líneas:</i> Si la implementación requiere múltiples instrucciones o lógica compleja. En este caso, se requiere explícitamente envolver el código en llaves (<code>{}</code>).</li>
                </ul>
            </li>
        </ul>
    </li>
    <li><b>Parámetros:</b>
        <ul>
            <li>Los parámetros del método lambda corresponden a los parámetros del método abstracto en la interfaz funcional.</li>
            <li>No es necesario incluir tipos explícitos si Java puede inferirlos del contexto.</li>
            <li>Para un único parámetro, los paréntesis pueden omitirse en la definición.</li>
            <li>Si no hay parámetros, deben incluirse paréntesis vacíos (<code>()</code>).</li>
        </ul>
    </li>
    <li><b>Variables capturadas:</b>
        <ul>
            <li>Las variables externas usadas dentro de un método lambda deben ser final o efectivamente final.</li>
            <li>Las lambdas no pueden declarar su propio constructor ni métodos adicionales.</li>
        </ul>
    </li>
</ul>
</li>
</list>
</tab>
</tabs>
</procedure>
<p> Adicional al ejemplo anterior, este snippet de código muestra la manera de definir varias líneas de código en un mismo método lambda y las variaciones de escritura tanto de parámetros como de cuerpos del método. </p>

```Java

//... en el archivo EjemplosOrdenamientoConLambdas.java

package OOP_Examples;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EjemplosOrdenamientoConLambdas {
    public static void main(String[] args) {
        // Ejemplo de ordenamiento de un 
        // array utilizando lambdas
        Integer[] numerosArray = {5, 2, 9, 1, 7};

        // Lambda con tipo de parámetro explícito
        Arrays.sort(numerosArray, 
                    (Integer a, Integer b) -> a - b);
        System.out.println("Array ordenado (ascendente): " 
        + Arrays.toString(numerosArray));

        // Lambda sin tipo de parámetro 
        // explícito (usando inferencia)
        Arrays.sort(numerosArray, (a, b) -> b - a);
        System.out.println("Array ordenado (descendente): " 
        + Arrays.toString(numerosArray));

        // Ejemplo de ordenamiento de un 
        // ArrayList utilizando lambdas
        List<String> lista = new ArrayList<>();
        Collections.addAll(lista, "plátano", 
            "manzana", "naranja", "mango", "durazno");
        
        // Lambda con cuerpo de bloque 
        // y retorno explícito
        Collections.sort(lista, 
                (String s1, String s2) -> {
                    return s1.compareTo(s2);
                }
        );
        System.out.println("Lista ordenada (alfabética): " 
                                                 + lista);

        // Lambda con una sola expresión 
        // (sin necesidad de {} o return)
        Collections.sort(lista, (s1, s2) -> s2.compareTo(s1));
        System.out.println("Lista ordenada" + 
                    " (alfabética inversa): " 
                                    + lista);

        // Ejemplo utilizando la interfaz Runnable
        Runnable lambdaCorta = () 
            -> System.out.println("¡Ejecutando una" 
                                + " lambda corta!");

        Runnable lambdaMultiLinea = () -> {
            System.out.println(
                "Esta es la primera línea de" + 
                    " una lambda con múltiples líneas.");
            System.out.println("Esta es la segunda" 
                + " línea de una lambda con múltiples líneas.");
        };

        lambdaCorta.run();
        lambdaMultiLinea.run();
    }
}
```

<p>Esto ha sido todo con respecto a este tipo de declaraciónes, en la siguiente sección revisaremos el contenido 
relacionado con genéricos para acabar la sección de programación orientada a objetos.</p>

