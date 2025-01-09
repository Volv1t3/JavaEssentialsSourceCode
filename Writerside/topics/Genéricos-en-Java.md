# OOP - Genéricos en Java

> Este es el capítulo final de nuestra discusión de las bases de OOP en Java. Una vez que conocemos como declarar 
> varios componentes base de OOP en Java, como usar clases anónimas, internas o métodos lambdas, la idea es ahora 
> convertir nuestro código de específico a general. <br/><br/>
> En esta sección, vamos a analizar el proceso de generalizar mediante parámetros, clases y métodos genéricos, nuestro
> código de Java.

<p>Bienvenidos a esta última sección de programación orientada a objetos, en esta ocasión, vamos a realizar la forma 
de establecer y escribir <code>métodos, clases, interfaces, etc., genéricas</code>. Para esto, en primera instancias 
tenemos que analizar un ejercicio mental para evaluar la utilidad de este tipo de programación. Posteriormente, 
analizaremos ciertos argumentos relacionados con la forma de declaración, estructuración y reglas de uso de 
genéricos, para terminar con ejemplos de su uso.
<br/><br/>
Java, en su forma más básica, utiliza hasta genéricos para varios aspectos como estructuras de datos, manejo de 
programación funcional, interfaces funcionales, etc. La programación genérica está en varias partes de Java, y 
nosotros las usamos en nuestros ejemplos de la clase, como en los ejemplos de métodos lambdas, en donde usamos 
ArrayLists que requieren parámetros genéricos. <br/><br/>
Si bien este proceso es útil a la hora de declarar algúnas estructuras en Java, dado que la librería estándar fue 
diseñada de esta forma, en nuestras clases (hasta el momento a través de los ejemplos realizados) no hemos notado la 
necesidad de realizar métodos o inclusive clases genéricas.
<br/><br/>
No obstante, cuando desarrollamos algunas clases en estructuras de datos, o en general en aquellos programas que 
requieren trabajar con varios tipos de datos y aplicar sus métodos dependiendo de un tipo de dato, podemos usar 
genéricos para asegurar a nuestro programa con genéricos para que sus métodos puedan funcionar con tipos de datos 
variados, sin necesidad de usar referencias a una interface o clase abstracta base de un grupo de clases.
</p>

## Genéricos en Java - Conceptos Básicos
<p>En Java, el concepto de genéricos es muy útil dado que el compilador generalmente se encarga de, durante 
compilación, revisar el tipo de dato ingresado para un método o para una clase con respecto de los requerimientos 
declarados en los prototipos de estas estructuras. De esta manera, el compilador logra detectar errores durante 
compilación, e inclusive durante un análisis estático de nuestro código para determinar aquellos tipos de dato que 
puedan dar errores y comunicarlo para solucionarlo rápidamente.
<br/><br/>
De esta forma, al utilizar genéricos <code>el compilador nos puede ayudar a revisar la pertenencia de un tipo de 
dato usado, con respecto de un listado de tipos, o un tipo definido, para un método o clase, deteniendo errores y 
mejorando la seguridad en términos de uso de nuestro código.
</code>
<br/><br/>
Cuando queremos definir tipos de datos genéricos, o métodos genéricos, existen algúnas reglas y recomendaciones para 
su implementación y diseño. Además existen algúnas reglas definidas para los tipos de datos genéricos durante 
ejecución de nuestro código. El siguiente bloque informativo amplía sobre estas. 
</p>
<procedure>
<tabs>
<tab title="Reglas Con Respecto a su Definición">
<list>
<li><b><format color="CornFlowerBlue">Definición Básica</format></b>: El concepto de genéricos en Java hace 
referencia a métodos, clases, interfaces, etc., cuyo código se encuentra parametrizado con un tipo <code>no definido
</code> que debe ser ingresado por el usuario basado en las reglas definidas por el programador.
<br/>
Los genéricos pueden definirse de tal manera en la que el tipo de dato parametrizado tenga visibilidad global dentro 
de la clase, o con un alcance intermedio dentro de un método. El siguiente bloque de código muestra la forma base de 
declarar estructuras parametrizadas y métodos parametrizados.

```Java
//... en el archivo ClaseGenerica.java
package OOP_Examples;

public class ClaseGenerica<T> {
    //... Aqui se puede definir cualquier
    //... otro parametro, metodo o clase interna
    
    public static abstract class ClaseAbstractaGenerica<E, T>{
        //... Aqui puede ir su implementacion
    }
    
    /*
     * El tipo de dato no tiene que ser
     * una sola letra, puede ser una palabra
     * completa.
    */
    private interface InterfaceGenerica<Generic> {
        //... Aqui puede ir su implementacion
    }
    
    /*
     * EL tipo generico no tiene que ser solo uno,
     * puede haber uno o mas en la misma declaracion
     * siempre separados por coma.
    */
    private class ClaseGenericaDos<E, F, G>{
        //... Aqui puede ir su implementacion
    }
}
```
</li> 
<li><b><format color="CornFlowerBlue">Herencia de Clases Genéricas</format></b>: 
    En Java, las clases genéricas permiten herencia con ciertas reglas importantes dependiendo de si la clase derivada 
tiene su propia definición genérica o no:
   <ul>
       <li><b>Extender de una clase genérica con un tipo genérico definido:</b> 
       Si una clase derivada <code>extiende de una clase genérica</code>, esta <code>puede definir su propio tipo genérico o 
usar el tipo </code> genérico definido por la clase padre. Por ejemplo:
       
```Java
//... en el archivo BaseClase.java

package OOP_Examples;
// Clase padre con genérico
public class BaseClass<T> {
    //... Aqui puede entrar tu código.
}

//... en el archivo DerivedClass.java

package OOP_Examples;
// Clase hija con el mismo tipo genérico
public class DerivedClass<T> extends BaseClass<T> {
    //... Aqui puede entrar más código
}


//... en el archivo DerivedClassInteger.java

package OOP_Examples;
// Clase hija con un tipo genérico específico
public class DerivedClassInteger extends BaseClass<Integer> {
    //... Aqui puedes definir más código.
}
```
En este caso, la clase hija puede usar el genérico de la clase padre directamente o especificar el tipo real para limitar el alcance del genérico.
</li>

<li><b>Extender de una clase sin genérico desde una clase genérica:</b> 
Es posible que una clase genérica extienda de una clase que no define un tipo genérico. El tipo genérico de la clase 
hija será completamente independiente. El siguiente bloque de código presenta un ejemplo de como trabajar con 
herencia de clases no genéricas cuando se define clases genéricas.

```Java
//... en el archivo NonGenericBaseClass.java

package OOP_Examples;
// Clase padre no genérica
public class NonGenericBaseClass {
    //... código e implementación
}

//... en el archivo GenericDerivedClass.java

package OOP_Examples;
// Clase hija genérica
public class GenericDerivedClass<T> extends NonGenericBase {
    //... código e implementación
}
```
       
Aquí, el genérico `T` es exclusivo de la clase hija y no afecta a la clase padre.
</li>
</ul>
</li>
<li><b><format color="CornFlowerBlue">Herencia de Interfaces Genéricas</format></b>: 
    En Java, las interfaces genéricas permiten herencia e implementación con ciertas reglas importantes dependiendo de si la clase o interfaz derivada maneja tipos genéricos. Estas son algunas consideraciones clave:
<ul>
<li><b>Implementar una interfaz genérica con un tipo genérico definido:</b> 
       Cuando una clase implementa una interfaz genérica, puede especificar un tipo concreto para el genérico de la 
interfaz o declarar su propio genérico. En el siguiente ejemplo, se muestra el manejo de implementación de una 
interface genérica con o sin heredar el concepto de genérico en las clases implementadoras.

```Java
//... en el archivo GenericInterfaceDecl.java

package OOP_Examples;
// Interfaz genérica
public interface GenericInterfaceDecl<T> {
    void method(T value);
}

//... en el archivo ConcreteClassImpl.java

package OOP_Examples;
// Clase concreta especifica un tipo para T
public class ConcreteClassImpl 
               implements GenericInterfaceDecl<String> {
    @Override
    public void method(String value) {
        System.out.println("Valor: " + value);
    }
}

//... en el archivo GenericClassImpl.java

package OOP_Examples;
// Clase concreta declara su propio genérico
public class GenericClassImpl<T> 
        implements GenericInterfaceDecl<T> {
        
    @Override
    public void method(T value) {
        System.out.println("Valor: " + value);
    }
}
```

Aquí, `ConcreteClass` usa un tipo específico (`String`) para el parámetro genérico de la interfaz, mientras que 
`GenericClass` continúa siendo genérica y hereda el parámetro genérico `<T>` de la interfaz.
</li>
<li><b>Extender una interfaz genérica desde otra interfaz genérica:</b> 
Cuando una interfaz genérica extiende otra interfaz genérica, puede heredar el parámetro genérico de la interfaz 
padre o declarar nuevos parámetros genéricos propios. El siguiente bloque de código demuestra el manejo de 
interfaces genéricas, su implementación, y extensión.

```Java
//... en el archivo ParentGenericInterfaceDecl.java

package OOP_Examples;
// Interfaz genérica padre
public interface ParentGenericInterfaceDecl<T> {
    void parentMethod(T value);
}

//... en el archivo ChildGenericInterfaceDecl.java

package OOP_Examples;
// Interfaz genérica hija que usa el mismo tipo genérico
public interface ChildGenericInterfaceDecl<T> 
                 extends ParentGenericInterfaceDecl<T> {
      void childMethod(T value);
}

//... en el archivo AnotherChildGenericInterfaceDecl.java

package OOP_Examples;
// Interfaz genérica hija que extiende con un nuevo genérico
public interface AnotherChildGenericInterfaceDecl<X, Y> 
                    extends ParentGenericInterface<X> {
        
       void anotherChildMethod(Y value);
}
```

En este ejemplo, `ChildGenericInterfaceDecl` continúa usando el mismo parámetro genérico `<T>` de su interfaz padre, 
mientras que `AnotherChildGenericInterfaceDecl` añade un nuevo genérico `<Y>` además de heredar `<X>` de la interfaz padre.
</li>
<li><b>Implementar una interfaz genérica sin definir un genérico propio:</b> 
Es posible implementar una interfaz genérica en una clase concreta sin declarar un tipo genérico adicional. Esto se 
logra especificando un tipo concreto para la interfaz genérica durante la implementación. Ejemplo:

```Java
//... en el archivo GenericInterfaceDecl.java

package OOP_Examples;
// Interfaz genérica
public interface GenericInterfaceDecl<T> {
    void method(T value);
}

//... en el archivo NonGenericClassImpl.java

package OOP_Examples;
// Clase concreta implementa la interfaz sin un genérico
public class NonGenericClassImpl 
             implements GenericInterface<Integer> {
    @Override
    public void method(Integer value) {
        System.out.println("Valor: " + value);
    }
}
```
Aquí, `NonGenericClassImpl` elimina la necesidad de declarar un genérico propio al fijar `Integer` como el tipo para 
la interfaz genérica.
</li>
   </ul>
</li>
</list>
</tab>
<tab title="Reglas Con Respecto a su Contenido">
<list>
<li><b><format color="CornFlowerBlue">Contenido Permitido en Estructuras Genéricas</format></b>: En Java, las 
clases, interfaces o clases abstractas pueden contener en su cuerpo <code>métodos o parámetros genéricos</code>. 
No obstante, existen algunas reglas sobre el tipo y el alcance de los tipos genéricos, ya sean heredados o 
definidos en una clase. Por ahora, nos centraremos en las reglas de acceso de los tipos genéricos en clases e 
interfaces.
<ul>
<li><b>Instancias de tipos genéricos en parámetros internos (Clases Abstractas y Clases Base)</b>: 
Tanto clases como clases abstractas pueden contener parámetros cuyo tipo de dato sea el dato genérico. Como estas 
instancias se inicializan durante compilación, no existen problemáticas al definirlas. <code>No obstante, hay que 
tener en cuenta que por type erasure (a discutirse más adelante), las instancias genéricas no pueden verificarse 
en tiempo de ejecución.</code> En general, estas se declaran de la siguiente forma:
<br/>

```Java
//... en el archivo AbstractGenericClassDecl.java

OOP_Examples;
public abstract class AbstractGenericClassDecl<T> {
    
    // Instancia del tipo genérico permitida
    private T value; 

    public AbstractGenericClass(T value) {
        this.value = value;
    }

    // Métodos que usan el tipo genérico 
    // también son válidos
    public T getValue() { 
        return value;
    }
}
```
</li>

<li><b>Métodos con tipos genéricos adicionales</b>: 
En clases, interfaces, y clases abstractas, se pueden declarar métodos que definan sus propios tipos genéricos 
adicionales independientes del tipo genérico de la clase. Esto permite que algunos métodos trabajen con múltiples 
tipos de datos, independientemente del tipo base de la clase. Por ejemplo:

```Java
//... en el archivo AbstractGenericClassDecl.java

package OOP_Examples;
public abstract class AbstractGenericClassDecl<T> {
    public abstract T getValue();

    // Método con otro tipo genérico 
    // distinto al de la clase
    public <E> void genericMethod(E element) {
        System.out.println("Elemento genérico: " + element);
    }
}

//... en el archivo InterfaceWithMultipleTypesDecl.java

package OOP_Examples;

public interface InterfaceWithMultipleTypesDecl
            <TipoGenericoExterno> 
            extends Comparable<TipoGenericoExterno>{
    
    /*
     * Definimos un nuevo método interno con un tipo 
     * de dato generico adicional al de la interface
     * general. 
    */
    public abstract <TipoGenericoInterno> 
                        TipoGenericoInterno hacerAlgo();
}

//... en el archivo ClassWithMultipleTypesDecl.java

package OOP_Examples;

public class ClassWithMultipleTypesDecl
                                    <ParamOne> {
      public ParamOne parameterOneInstance;
      
      /*
       * Definimos un método que tome un parámetro 
       * adicional
      */
      public final <HelloParam> void 
                    say(HelloParam param) {
        System.out.println(param);              
      }
    
}
```
En este caso, `<E>` es independiente de `<T>`. Esto es completamente válido y ampliamente utilizado para mayor
flexibilidad.
</li>
</ul>
</li> 
<li><b><format color="CornFlowerBlue">Contenido Restringido en Estructuras Genéricas</format></b>: 
En Java, las clases, interfaces o métodos genéricos proporcionan flexibilidad y seguridad de tipos en tiempo de 
compilación. Sin embargo, hay ciertas limitaciones impuestas debido a la <code>type erasure</code> (eliminación de 
tipos genéricos en tiempo de ejecución) y características del lenguaje. A continuación, exploramos algunas restricciones importantes que deben tenerse en cuenta.
<ul>

<li><b>No se permiten tipos primitivos como parámetros genéricos</b>: 
Las estructuras genéricas en Java funcionan exclusivamente con tipos referenciales y no con tipos primitivos (como 
<code>int</code>, <code>double</code>, etc.). Esto se debe a que los tipos primitivos no son objetos y no pueden 
ser utilizados donde se requiere un tipo genérico.

```Java
// Error: no se permiten tipos primitivos
List<int> numeros; 
// Correcto: se usa la clase envolvente Integer
List<Integer> numeros; 
```
Para trabajar con tipos primitivos, es necesario usar clases envolventes como <code>Integer</code>,
<code>Double</code>, etc., o estructuras dedicadas, como <code>IntStream</code> en las API de Streams de Java.
</li>

<li><b>No se permite la creación de nuevas instancias genéricas</b>: 
No es posible hacer <code>new T()</code> en una clase genérica. Esto se debe a que, después de la eliminación de 
tipos, el parámetro de tipo genérico (<code>T</code>) no tiene un tipo concreto asociado en tiempo de ejecución. 

```Java
public class MiClase<T> {
    // Error: no se permite una creación directa
    T instancia = new T(); 
}
```

</li>

<li><b>Restricción en la creación de arreglos genéricos</b>: 
No se pueden crear arreglos directamente de tipos genéricos debido a la incompatibilidad entre generics y arrays 
bidireccionales. Los arreglos en Java son <i>reificables</i>, lo que significa que mantienen información sobre su 
tipo en tiempo de ejecución, mientras que los genéricos no lo hacen. La combinación de estas características podría 
causar problemas en tiempo de ejecución.

```Java
// Error: no permitido
T[] arreglo = new T[10]; 
```
</li>
<li><b>No se permiten miembros <code>static</code> del tipo genérico</b>: 
Un miembro estático pertenece a la clase y no a instancias concretas de esta. Dado que <code>T</code> se resuelve en 
tiempo de compilación y se elimina en tiempo de ejecución, no es posible declarar miembros estáticos que utilicen 
un tipo genérico.

```Java
//... en el archivo GenericClassDecl2.java

package OOP_Example;

public class GenericClassDecl2<T> {
    // Error: no permitido
    private static T dato; 
}
```
</li>

<li><b>No se permite el uso de <code>instanceof</code> con tipos genéricos</b>: 
No es posible verificar si un objeto es una instancia de un tipo genérico, ya que este desaparece después de la 
eliminación de tipos en tiempo de ejecución.

```Java
public boolean esTipo(T objeto) {
    // Error: no permitido
    return objeto instanceof T; 
}
```
</li>

<li><b>No se pueden usar genéricos en excepciones</b>: 
Los tipos genéricos no se pueden usar con clases de excepción (<code>Throwable</code>), ya que las excepciones 
requieren construir un stackTrace completo en tiempo de ejecución, que se rompe al usar tipos genéricos.

```Java
// Error: no permitido
public class ExcepcionGenerica<T> extends Exception { 
}
```

Los bloques <code>try-catch</code> tampoco admiten tipos genéricos:
```Java
try {
    // Código con excepciones
} catch (T e) { // Error: no permitido usar genéricos
}
```
</li>

<li><b>Los <code>enums</code> no pueden ser genéricos</b>: 
Los <code>enum</code> en Java tienen valores constantes bien definidos. No es posible agregar parámetros genéricos 
debido a la naturaleza fija y concreta de los <code>enum</code>.

```Java
// Error: no permitido
public enum MiEnum<T> { 
    CONSTANTE1, CONSTANTE2;
}
```
</li>

<li><b>No se permite anular métodos cambiando el tipo genérico</b>: 
Cuando se sobrescribe un método en una clase hija, la firma del método debe coincidir exactamente con la del método 
padre. No se puede modificar el parámetro genérico durante la sobrescritura.

```Java
class Padre<T> {
    public void metodo(T valor) {}
}

class Hija extends Padre<String> {
    // Error: esto no es sobrescritura, 
    // sino un método nuevo
    public void metodo(Integer valor) {} 
}
```
</li>
</ul>
</li>

</list>
</tab>   
</tabs>
</procedure>
<p>Luego de haber analizado el ejemplo anterior, es importante revisar dos aspectos importantes declarados en la 
sección de contenidos permitidos y no permitidos. En primera instancia, las restricciones sobre la declaración de 
variables tanto estáticas o de tipo <code>Array o con la keyword new</code>, sacan a la luz un proceso de Java 
complejo y fuera del enfoque total de este curso, el type erasure de tipos en Java durante ejecución. Este proceso 
de Java. <br/><br/>
Dentro del trabajo interno del compilador, el programa remueve los tipos de datos genéricos que no son 
<code>Reifiable</code>, es decir, tipos de datos cuyo conocimiento es imperativo durante ejecución. De esta manera, 
algunos tipos, como aquellos de Arreglos de primitivos, arreglo con clases de Java o clases o interfaces no 
genéricas, se guardan durante ejecución y se pueden conocer con <code>getClass() o instanceof</code>, en cambio, 
algunos de los tipos parametrizados que usamos son eliminados durante compilación por lo que el programa no puede 
conocer qué tipo se está guardando. Ciertamente, el proceso es mucho más complicado de lo que se define en la 
implementación general del lenguaje. <br/><br/>
No obstante, la idea es conocer esto para poder entender el porque de no poder realizar <code>new E[], o new E(), 
obj instanceof E
</code>.
</p>

### Genéricos en Java - Ejemplo de Implementación.
<p>En el siguiente ejemplo, tomado de unas de mis implementaciones de algoritmos para estructuras de datos, se 
presenta la manera de trabajar con genéricos simples.</p>

```Java
//... en el archivo QuickSort.Java

package OOP_Examples;


public class QuickSort{

    public static <T extends Comparable<T>> 
                    void quicksort(T[] data) {
            int n = data.length;
            // Boundary condition: if the array has fewer 
            // than 2 elements, it's already sorted
            if (n < 2) return; 
    
            // Find the largest element and 
            // move it to the last position
            int max = 0;
            for (int i = 1; i < n; i++) {
                if (data[max].compareTo(data[i]) < 0) {
                    max = i;
                }
            }
            // Move the largest element to the end
            swap(data, n - 1, max); 
    
            // Call the recursive quicksort function 
            // to sort the rest of the array
            quicksort(data, 0, n - 2);
        }
        private static <T extends Comparable<T>> 
                 void quicksort(T[] data, int first, int last) {
            // Base condition: if the segment has 0 
            // or 1 elements, it's already sorted
            if (first >= last) return; 
    
            int lower = first + 1;
            int upper = last;
    
            // Move the pivot (middle element) 
            // to the first position
            swap(data, first, (first + last) / 2); 
            T bound = data[first]; // Pivot element
    
            // Partition the array
            while (lower <= upper) {
                while (bound.compareTo(data[lower]) > 0) lower++;
                while (bound.compareTo(data[upper]) < 0) upper--;
                if (lower < upper) {
                    swap(data, lower++, upper--);
                } else {
                    lower++;
                }
            }
            
            // Place the pivot in 
            // its correct position
            swap(data, upper, first); 
    
            // Recursively sort the partitions
            if (first < upper - 1) {
                    quicksort(data, first, upper - 1);}
            if (upper + 1 < last) {
                    quicksort(data, upper + 1, last);}
        }
    
        private static <T> void swap(T[] data, int i, int j) {
            T temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
}
```


<p>El ejemplo anterior mostró una parte que no hemos revisado hasta el momento en nuestro análisis de genéricos, pero 
prefiero que lo vean en un ejemplo primero. Cuando trabajamos con una clase genérica, si solo nombramos el tipo 
podríamos esperar que este, hasta el momento, solo un placeholder para un tipo de dato cualquiera. Pero en el código 
anterior, que sucede si no puedo realizar una comparación entre dos instancias de este tipo de dato. <br/><br/>
Si el input de nuestro método no es numérico entonces, o no implementa Comparable o Comparator (en este caso 
Comparable ya que usa <code>compareTo</code>), nuestro código va a dar errores ya que no encontrará el método 
requerido en el código.
<br/><br/>
Es por esta clase de problemas, la necesidad de especialización en los <b>tipos que se permiten dentro de una 
estructura genérica</b>, que tenemos que hablar de type bounding. 
</p>

### Genéricos en Java - Especialización de Tipos
<p>Tipo Bouding, el proceso por el cual un tipo de dato genérico se especializa, se utiliza para definir un tipo de 
clases o tipos de dato referenciales permitidos dentro de un objeto o un método genérico. En el caso de la muestra 
de QuickSort, los métodos requieren como mínimo que los tipos de datos usados para definir la clase, para 
implementar una instancia no genérica, a la hora de instanciación, implementen <code>Comparable (en este caso, la 
keyword que se usa es extends). </code>
<br/><br/>
Este tipo de normativas corresponden al type bounding and wildcards de Java. Existen especificamente tres 
reglas de este estilo.
</p>

<procedure>
<tabs>
<tab title="Genéricos de tipo Upperbound">
<list>
<li><b><format color="CornFlowerBlue">Definición General</format></b>: Un tipo de especialización de tipo Upperbound 
establece que un tipo genérico tendrá como límite superior una clase o interfaz específica. Esto significa que el 
tipo genérico aceptará esa clase o cualquier subclase de la misma.</li> 

<li><b><format color="CornFlowerBlue">Sintaxis Básica</format></b>: La declaración de un Upperbound usa el carácter 
comodín `?` seguido de la palabra clave `extends`. Por ejemplo, esto funciona tanto si el límite superior es una 
clase como si es una interfaz:

```Java
//... en el archivo Caja.java

package OOP_Examples;

// Clase genérica con upperbound
public class Caja<T extends Comparable<T>> {
    private T contenido;

    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public boolean compararContenido(T otroContenido) {
        return contenido.compareTo(otroContenido) == 0;
    }
}

//... en el archivo Empaquetado.java

package OOP_Examples;

/*
 * Esta interface muestra un ejemplo de como 
 * definir una interface cuyo argumento 
 * genérico extienda una clase adicional
 * y luego de un & define una interface
 * que tiene que implementar
*/
public interface Empaquetado<TypeName extends  
            Caja<TypeName> & Comparable<TypeName>>{
    //... otros métodos pueden ir aqui!            
}
```
</li>

<li><b><format color="CornFlowerBlue">Uso Común</format></b>: Los Upperbound son útiles para:
    <ul>
        <li>Permitir que los tipos sean restringidos a un límite superior, ya sea una interfaz o una clase base 
específica.</li>
        <li>Hacer operaciones tipo-safe al garantizar que los objetos sean de un tipo esperado o un subtipo concreto.</li>
    </ul>
</li>


</list>
</tab>
<tab title="Genéricos de tipo Lowerbound">
<list>
<li><b><format color="CornFlowerBlue">Definición General</format></b>: Un tipo de especialización de tipo Lowerbound 
establece que un tipo genérico tendrá como límite inferior una clase o interfaz específica. Esto significa que el tipo genérico aceptará esa clase o cualquier clase padre de la misma.</li>
<li><b><format color="CornFlowerBlue">Sintaxis Básica</format></b>: La declaración de un Lowerbound usa el carácter 
comodín `?` (o algun identificador) seguido de la palabra clave `super`. <code>Hay que tener en cuenta que las 
declaraciones de tipo 
LowerBound no pueden hacerse en clases o interfaces, solo en métodos</code>

```Java
// Metodo que permite agregar un valor 
// de tipo T o superclase de T a 
// un Stack
public static <T> void addToStore(Stack<? super T> stack, T element) {
    stack.push(element);
}
```
En este caso, el método `agregarATienda` permite agregar elementos a una pila genérica cuyo tipo es `T` o cualquier 
superclase de `T`.
</li>

<li><b><format color="CornFlowerBlue">Uso Común</format></b>: Los Lowerbound son útiles para:
    <ul>
        <li>Permitir escritura segura en estructuras genéricas, especialmente cuando hay jerarquías de clases.</li>
        <li>Facilitar operaciones donde los tipos base comparten una jerarquía.</li>
    </ul>
</li>
<li><b><format color="CornFlowerBlue">Ejemplo con clase e interfaz</format></b>:

```Java
//... en el archivo Almacenable.java

package OOP_Examples;

// Interfaz genérica
public interface Almacenable<T> {
    void almacenar(T elemento);
}

//... en el archivo Producto.java

package OOP_Examples;
// Clase base
public class Producto {
    private String nombre;
    
        public Producto(String nombre) {
            this.nombre = nombre;
        }
    
        @Override
        public String toString() {
            return nombre;
        }
}

//... en el archivo AlimentoNoPerecedero.java

package OOP_Examples;
// Clase hija concreta
public class AlimentoNoPerecedero extends Producto {
    public Alimento(String nombre) {
        super(nombre);
    }
}

//... en algun archivo que maneje un Almacen

    // Método con Lowerbound
    public static void 
                llenarAlmacen(
                Almacenable<? super Alimento> almacen, 
                List<Alimento> alimentos) {
    for (Alimento alimento : alimentos) {
        almacen.almacenar(alimento);
    }
}
```

En este ejemplo, una función genérica utiliza un Lowerbound para aceptar cualquier estructura que almacene `Alimento` o una clase base de `Alimento` (por ejemplo, `Producto`). Esto permite escribir elementos genéricamente.
</li>
</list>
</tab>
<tab title="Wildcard sin restricciones">
<list>
<li><b><format color="CornFlowerBlue">Definición General</format></b>: Un tipo comodín genérico (`?`) sin 
restricciones permite que el tipo genérico acepte cualquier tipo. Esto proporciona la máxima flexibilidad, 
particularmente en operaciones de solo lectura.</li>

<li><b><format color="CornFlowerBlue">Sintaxis Básica</format></b>: La declaración de un wildcard sin restricciones 
utiliza únicamente el carácter `?`. Por ejemplo:

```Java
// Método genérico con wildcard sin restricciones
public static void mostrarAlmacen(Almacenable<?> almacen) {
    System.out.println("Mostrando el contenido del almacén: " 
                    + almacen.toString());
}
```
En este caso, el wildcard sin restricciones acepta objetos de cualquier tipo.
</li>
<li><b><format color="CornFlowerBlue">Uso Común</format></b>: Los wildcards sin restricciones son útiles para:
    <ul>
        <li>Cuando necesitamos máxima flexibilidad en operaciones que no dependen del tipo específico.</li>
        <li>Lecturas genéricas de colecciones o estructuras genéricas.</li>
    </ul>
</li> 
<li><b><format color="CornFlowerBlue">Ejemplo con clases e interfaces</format></b>:

```Java
// Clase almacenable genérica
public class Contenedor<T> implements Almacenable<T> {
    private List<T> elementos = new ArrayList<>();

    @Override
    public void almacenar(T elemento) {
        elementos.add(elemento);
    }

    @Override
    public String toString() {
        return "Contenedor{" + "elementos=" + elementos + '}';
    }
}

// Método genérico que utiliza wildcard sin restricciones
public static void
        mostrarTodosContenedores(Contenedor<?> contenedor) {
System.out.println("Contenido del contenedor: "
                        + contenedor.toString());
}

```

Este ejemplo muestra cómo trabajar con wildcards sin restricciones para operaciones genéricas en clases o interfaces.
</li>
</list>
</tab>
</tabs>
</procedure>
<p>El siguiente ejemplo muestra el trabajo de una clase completa y con genéricos tanto de tipo upperbound y 
lowerbound, el tipo general no se muestra porque es el más inseguro.</p>

```Java
//... en el archivo EjemploTypeBounding.java

package OOP_Examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class EjemploTypeBouding {

    /*
     * Este ejemplo demuestra el uso de una
     * estructura de clases genericas con
     * parametros multiples y con estructuras
     * internas completas
     */
     private class EjemploGenericoUno<
            TypeOne extends CharSequence,
            TypeTwo extends Number & Comparable<TypeTwo>,
            TypeThree extends Comparable<TypeThree>>
    {
         //! Declaremos parámetros internos
         private TypeOne typeOneParam;
         private TypeTwo typeTwoParam;
         private TypeThree typeThreeParam;

         //! Declaremos un constructor
        public EjemploGenericoUno(TypeOne typeOneParam, 
                TypeTwo typeTwoParam, TypeThree typeThreeParam) {
            this.setTypeOneParam(typeOneParam);
            this.setTypeTwoParam(typeTwoParam);
            this.setTypeThreeParam(typeThreeParam);
        }

        //! Setters y Getters
        public TypeOne getTypeOneParam() {
            return typeOneParam;
        }
        public void setTypeOneParam(TypeOne typeOneParam) {
            this.typeOneParam = typeOneParam;
        }
        public TypeTwo getTypeTwoParam() {
            return typeTwoParam;
        }
        public void setTypeTwoParam(TypeTwo typeTwoParam) {
            this.typeTwoParam = typeTwoParam;
        }
        public TypeThree getTypeThreeParam() {
            return typeThreeParam;
        }
        public void setTypeThreeParam(TypeThree typeThreeParam) {
            this.typeThreeParam = typeThreeParam;
        }

        //! Declaremos un método para mostrar los parámetros
        public void showParams() {
            System.out.println("TypeOne: " + typeOneParam);
            System.out.println("TypeTwo: " + typeTwoParam);
            System.out.println("TypeThree: " + typeThreeParam);
        }

        //! toString y Equals
        @Override
        public String toString() {
            return "EjemploGenericoUno{" +
                    "typeOneParam=" + typeOneParam +
                    ", typeTwoParam=" + typeTwoParam +
                    ", typeThreeParam=" + typeThreeParam +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) 
                 return false;
            try{
                EjemploGenericoUno<?, ?, ?> that 
                            = (EjemploGenericoUno<?, ?, ?>) obj;
                return Objects.equals(typeOneParam, that.typeOneParam) 
                &&Objects.equals(typeTwoParam, that.typeTwoParam) 
                && Objects.equals(typeThreeParam, that.typeThreeParam);
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }

    /*
     * Este ejemplo declara una interface que
     * realiza operaciones sobre un arreglo
     * tomando en cuenta upperbound
     */
    private interface OperacionesArreglo{
        public abstract <T extends Number> 
                        Double promedio(T[] arreglo);
        public abstract <T extends Number> void 
            addItem(List<? super Number> listofNumbers, 
                                            T Number);
    }

    /*
     * Este ejemplo declara una clase que
     * realiza operaciones sobre un arreglo
     * tomando en cuenta upperbound
     */
    private class OperacionesArregloImpl 
                        implements OperacionesArreglo{
        @Override
        public <T extends Number> Double promedio(T[] arreglo) {
            double suma = 0;
            for (T t : arreglo) {
                suma += t.doubleValue();
            }
            return suma / arreglo.length;
        }

        @Override
        public <T extends Number> void addItem(
                    List<? super Number> listofNumbers, T Number) {
            listofNumbers.add(Number);
        }
    }

```

<p>Como se pudo apreciar, el trabajo con genéricos es complejo, tiene varios caviats y existen muchas combinaciones 
que tomarían la gran parte del curso en analizar. Si bien los datos presentados en esta sección han sido vetados a 
través del contenido del libro de texto de Java usado en los cursos de estructuras de datos o apps, si tienen un 
interés en revisar más, pueden usar IntelliJ como un playground y revisar las combinaciones que se pueden hacer, o 
revisar la documentación oficial de Java para revisar los casos de uso más frecuentes y las reglas más internas del 
lenguaje sobre genéricos y más.
<br/><br/>
En este punto, el contenido general del curso se ha acabado, si requieren revisarlo de nuevo, todo el contenido y 
código se queda registrado en este repositorio. Asimismo, esta página con la información se queda en el github del 
curso para que la puedan revisar. Gracias por su atención y lectura!</p>