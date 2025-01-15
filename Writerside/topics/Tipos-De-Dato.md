# Java Base - Tipos De Dato

> Habiendo revisado las bases del lenguaje y algunos de sus componentes, como son los modificadores de acceso, 
> paquetes, módulos, entre otros aspectos útiles del lenguaje, es momento de analizar algunos de los componentes de 
> Java, con los que se toparán a menudo en sus implementaciones. Ahora es el turno de los tipos de dato.

<p> Dentro de Java existen varios tipos de datos, algunos tienen una contraparte directa en C++, como son int, 
double, float, String, etc. A estos tipos de datos, al igual que en C++ se los conoce como primitivos (a excepción 
de String claro esta). Por su parte, Java contiene otros tipos de dato, conocidos como tipos de dato referenciales, o 
Reference Types, que son generalmente objetos, instancias de clases que amplían las capacidades de los tipos de 
datos primitivos. <br/><br/> 
Dentro de la especificación general del lenguaje tenemos lo siguiente al respecto.
</p>
<procedure>
<i>The types of the Java programming language are divided into two kinds: primitive types and reference types. The 
primitive types are the boolean type and the numeric types [...] The reference types are class types, interface 
types, and array types.</i>
</procedure>
<p>De esta manera, en Java tenemos dos grupos, uno mucho más extenso que el otro, en el cual nuestros tipos de datos 
se agrupan. En general, todas las variables que se declaren con el estilo de <code>byte, short, int, long, o 
float, double, char o boolean
</code>, son considerados como tipos primitivos (es decir aquellos que tienen una minúscula en su inicial.) En 
contraste, los tipos estos mismos tipos de dato tienen su contraparte de tipo referencial en el estilo de 
<code>Byte, Short, Integer, Long, Float, Double, Char, Boolean</code>.
<br/><br/>
En Java hay que tener en cuenta que la mayoría de los valores se guardan en una memoria de tipo 
<code>Heap</code>, más no en Stack a menos que sean de tipo primitivo, por tanto, siempre vamos a tener una 
gran cantidad de tipos referenciales, cuya implementación es en sí una clase, comparado con algo que es directamente 
un valor en memoria, como es un primitivo.
</p>

## Primitivos en Java
<p>Aunque en muchas secciones de código de este curso se usa los tipos de dato referenciales, también es importante 
conocer y manejar los tipos de dato primitivos y su declaración. En java, estos se pueden agrupar en dos campos, 
integer single precision numbers, y fixed decimal, single and double precision floating point numbers. En este 
sentido al igual que en C++ tenemos versiones con single y double precision, dándonos 32 o 64 bits para almacenar 
informacion respectivamente.
</p>
<procedure>
<p>Es importante destacar que en Java no existen los <code>unsigned int, long, long long, unsigned long, etc. 
</code> Esto es porque Java no trabaja con valores unsigned en su formato interno de números. No obstante, Java 
tiene métodos en clases como <code>Integer</code> que permite realizar operaciones como division y 
multiplicacion en modo unsigned. 
</p>
</procedure>
<p>Antes de presentar un snippet de código para evidenciar la forma de declarar parámetros y variables locales de 
este tipo de dato, a continuación se muestra un listado de las características mas importantes de cada tipo de dato</p>
<procedure>
<tabs>
<tab title="Byte">
<list style="alpha-lower">
<li>Un tipo de dato que implementa la <code>interface  Number y es hijo de la clase Object</code></li>
<li>Permite almacenar valores entre -128 hasta 127</li>
<li>Se representa internamente con 8 bits</li>
<li>Ejemplo de declaración:
<code-block lang="Java">
package example;

public class Example{
    private byte varOne = 16;
    public byte varTwo = 12;
    protected byte varThree = 125;

    public static void  main(String[] args){
        byte localVar = 20;
        Byte localWrappedByte = Byte.valueOf("24");
        final Byte localFinalWrappedByte = 
                                Byte.valueOf((byte) 100);
    }
}
</code-block>
</li>
</list>
</tab>
<tab title="Short">
<list style="alpha-lower">
<li>Un tipo de dato que implementa la <code>interface Number y es hijo de la clase Object</code></li>
<li>Permite al usuario almacenar valores entre -32768 hasta 32767 </li>
<li>Se representa en memoria usando 16 bits</li>
<li>Ejemplo de declaración:
<code-block lang="Java">
package example;

public class example{
    short primShortOne = 1;
    final short primShortTwo = 2400;
    
    public static void main(String[] args){
        final Short wrapShortTwo = Short
                            .valueOf( (short) 32000); 
        Short wrapShortOne = 25;
    }
}
</code-block>
</li>
</list>
</tab>
<tab title="Integer">
<list style="alpha-lower">
<li> Un tipo de dato que implementa la <code>interface Number y es hijo de la clase Object</code>
</li>
<li> Permite al usuario almacenar valores entre -2147483648 y 2147483647
</li>
<li> Ejemplo de declaración:
<code-block lang="Java">
package example;

public class example{
    private int intOne = 1200;
    protected final int intTwo = 260000;
    public Integer wrapIntOne = Integer.valueOf(1220);
    
    public static void main(String[] args){
        int primIntegerOne = 12;
        //! declaración general de enteros
        final int primIntegerTwo = 24;    
        Integer wrapIntegerOne = 8;
        //!Ejemplo de auto-boxing implicito
         final Integer wrapIntegerTwo = 
                     Integer.valueOf("36"); 
    }
}
</code-block>
</li>
</list>
</tab>
<tab title="Long">
<list>
<li>Un tipo de dato que implementa la <code>interface Number y es hijo de la clase Object</code></li>
<li>Permite al usuario almacenar valores entre -9223372036854775808 y 9223372036854775807</li>
<li>Ejemplo de declaración:
<code-block lang="Java">
package example;

public class example{
    private long longOne = 12400L;
    public final long longTwo = 1300L;

    public static void main(String[] args){
        long primLongOne = 12345L;
        final long primLongTwo = 67890L;
        Long wrapLongOne = Long.valueOf(98765);
        //! Ejemplo de auto-boxing implicito
        final Long wrapLongTwo = Long.valueOf("54321");
    }
}
</code-block></li>
</list>
</tab>
<tab title="Char">
<list>
<li>Un tipo de dato que permite almacenar un solo carácter o un código Unicode</li>
<li>Se representa en memoria usando 16 bits</li>
<li>Ejemplo de declaración:
<code-block lang="Java">
package example;

public class example{
    private char charOne = 'c';
    public final char charTwo = 'f';
    protected char charThree = 'd';

    public static void main(String[] args){
        
        // Ejemplo usando Character.valueOf()
        Character wrapCharOne = Character.valueOf('X');
            // Unicode para 'Z'
        final Character wrapCharTwo = Character
                                     .valueOf('\u005A'); 

        // declaraciónes locales adicionales de char
        char localCharOne = 'g';
        final char localCharTwo = 'h';
    }
}
</code-block>
</li>
</list>
</tab>
<tab title="Float">
<list>
<li>Un tipo de dato que implementa la <code>interface Number y es hijo de la clase Object</code></li>
<li>Permite al usuario almacenar números en coma flotante de precisión simple</li>
<li>Se representa en memoria usando 32 bits</li>
<li>Ejemplo de declaración:
<code-block lang="Java">
package example;

public class example {
    private float floatOne = 1.5f;
    public final float floatTwo = 2.5f;
    protected float floatThree = 3.14f;

    public static void main(String[] args) {
        // Ejemplo usando Float.valueOf()
        Float wrapFloatOne = Float.valueOf(5.5f);
        final Float wrapFloatTwo = Float.valueOf("6.7");

        // declaraciónes locales adicionales de float
        float localFloatOne = 10.5f;
        final float localFloatTwo = 20.25f;
    }

}
</code-block>
</li>
</list>
</tab>
<tab title="Double">
<list>
<li>Un tipo de dato que implementa la <code>interface Number y es hijo de la clase Object</code></li>
<li>Permite al usuario almacenar números en coma flotante de doble precisión</li>
<li>Se representa en memoria usando 64 bits</li>
<li>Ejemplo de declaración:
<code-block lang="Java">
package example;

public class example {
    private double doubleOne = 1.5d;
    public final double doubleTwo = 3.14159d;
    protected double doubleThree = 2.71828d;

    public static void main(String[] args) {
        // Ejemplo usando Double.valueOf()
        Double wrapDoubleOne = Double.valueOf(6.7d);
        final Double wrapDoubleTwo = 
                              Double.valueOf("8.9");

        // declaraciónes locales adicionales de double
        double localDoubleOne = 12.34d;
        final double localDoubleTwo = 56.78d;
    }

}
</code-block>
</li>
</list>
</tab>
</tabs>
</procedure>

<p>Los primitivos tienen ciertas operaciones base como son multiplicación, division, suma, resta, operaciones 
binarias, etc. Solo que estos objetos no tienen ciertos métodos útiles como se han mostrado de sus contrapartes 
referenciales. Sin embargo, hasta este momento solo hemos tomado a estos objetos como contrapartes, pero en realidad 
son una ayuda.
<br/><br/>
Todas las declaraciónes de estilo <code>Character ..., final Double..., final Integer, Integer, etc.</code>, 
tienen algo en común, no solo son el mismo nombre, pero en mayúscula, sino que son clases envolventes de un tipo de 
dato primitivo. En Java, se trabaja mucho con los tipos de datos de referencia, ya que se pasan por referencia en 
métodos, constructores, copias, etc. Además, estos objetos pueden llegar a compartir la misma referencia en memoria 
y en general son mucho más útiles que un primitivo.
<br/><br/>
Por este motivo, Java tiene los primitivos, para aquel uso de datos rápido y que no necesite una variable en el Heap 
sino en el stack, como un contador, un parámetro base, etc. Paralelamente, también cuenta con una clase envolvente, 
Wrapper Classes, para cada primitivo con <code>su mismo nombre pero con la inicial en mayúsculas</code>.
<br/>
<br/>
Los beneficios de uno sobre el otro dependen del caso y en algunos momentos el IDE nos recomendará cambiar de uno 
al otro dependiendo del uso de una variable. Pero en general, las clases envolventes tienen muchos métodos de ayuda 
como son para transformar strings hacia números, transformar otros números hacia el tipo deseado, transformar su 
representacion, etc. Todo esto proviene de la interface Number.
</p>

## Reference Types En Java
<p>Las variables de tipo referenciales son todo aquello cuya representación salga de la facilidad de 
representabilidad a través de un cierto número de bits. Las instancias de clases (objetos), interfaces, o inclusive 
los arreglos de datos son referencias. Estas referencias generalmente se resuelven con un paso por referencia hacia 
los métodos, constructores, etc. que utilicemos dentro de nuestro código. Según la especificación oficial de Java</p>
<procedure>
<i>There are four kinds of reference types: class types, interface types, type variables, and array types. [...] 
The reference values (often just references) are pointers to these objects and a special null reference which refers 
to no object. </i>
</procedure>
<p>Ahora bien, esta definición trajo consigo mucha tela por donde cortar, pero en primera instancia es conveniente 
notar que class types, interface types y array types son cosas simples que ya las hemos visto en C++ y que veremos 
mas adelanta en nuestro estudio en Java. <br/><br/>
Class types y Array types son los típicos objetos de una clase (cualquiera que  esta sea), y array types son 
aquellas instancias de un arreglo de valores primitivos o clases definidas de la forma <code>dataType[]
</code>, que utilizamos a menudo cuando implementamos un arreglo de tamaño conocido. De esta forma dos de los 
cuatro tipos referenciales quedan sin analizar. Interface types los veremos en la sección de programación orientada 
a objetos, y type variables en la sección de genéricos.
<br/><br/>
No obstante, con ánimo de tener una explicación completa podemos pasar a analizar estos tipos de datos.</p>
<procedure>
<code-block lang="Java">
package example;

public class example {
        // Variable primitiva
    private int intOne = 42;
        // Wrapper final
    public final Integer wrapIntOne = Integer.valueOf(123);
        // Arreglo primitivo con inicializadores directos
    protected int[] intArrayOne = {1, 2, 3, 4, 5};
        // Arreglo wrapper
    final Integer[] wrapIntArrayOne = new Integer[] 
                                    {10, 20, 30, 40, 50}; 

    public static void main(String[] args) {
        // declaraciónes de variables primitivas y wrappers
        long primLongOne = 6789L; // Primitivo
        // Wrapper final
        final Long wrapLongOne = Long.valueOf(98765L); 
        // Primitivo
        char primCharOne = 'A'; 
        // Wrapper final
        final Character wrapCharOne = Character.valueOf('Z'); 

        // Arreglos de primitivas con inicializadores explícitos
        Integer[] localIntArrayOne = new Integer[3];
        localIntArrayOne[0] = 100;
        localIntArrayOne[1] = 200;
        localIntArrayOne[2] = 300;

        // Arreglos de wrappers
        final Double[] wrapDoubleArray = new Double[] {1.1, 2.2, 3.3};

    }

}
</code-block>
</procedure>

### Autoboxing y Unboxing de Primitivos a Wrappers
<p>En Java, las clases primitivas no siempre requieren ser creadas con una llamada de tipo 
<code>parse{DataType} o valueOf()</code>, estas también se pueden crear con el simple hecho de definir a la 
variable con un tipo de dato envolvente y con un inicializador de tipo primitivo. En estos casos el programa realiza 
un procedimiento llamado <code>Boxing</code> de las variables, que es la forma de Java de convertir un valor 
primitivo hacia uno de su clase envolvente.
</p>
<procedure>
<tabs>
<tab title="Boxing">
<p>El proceso de autoboxing consiste en tomar un valor primitivo y convertirlo en una referencia de una clase 
envolvente con el fin de que su valor interno sea exactamente el mismo que fue enviado como constructor.<br/><br/>
Esto se puede realizar en nueve casos distintos</p>
<list columns="1">
<li>Si el tipo es <code>boolean, byte, char, short, int long</code>, una conversion boxing lo transforma en 
<code>Boolean, Byte, Char, ... </code>, siempre y 
cuando la nueva instancia, al aplicarle <code>booleanValue() ... </code> retorne el valor original</li>
<li>En el caso de los valores <code>float y double</code>, la referencia se analiza en el caso de que esta sea NaN 
(Not a Number), y se transforma a su respectivo valor o a <code>Float.NaN o Double.NaN</code> respectivamente </li>
<li> Idealmente, se considera que esta regla no debería de fallar, en sistemas con menor memoria existe la 
probabilidad de que dos valores primitivos no tengan la misma referencia aunque sean el mismo valor. Esto solo se 
da en el caso de que no haya suficiente memoria para tener esta instancia, ya que el compilador hace un caché de 
algunos valores enteros en el rango de -32K a 32K para utilizar para estos propósitos.</li>
</list>
</tab>
<tab title="Unboxing">
<p>Unboxing es el proceso inverso, este proceso considera el pasar de una variable referencial, de una variable 
envuelta alrededor de un valor primitivo, hacia un valor primitivo base. Es decir pasar de un objeto a una 
localizacion en memoria del Stack. En el caso de Java existen nueve conversiones de nuevo</p>
<list>
<li>Si la instancia envuelta es de tipo <code>Boolean, Char, Integer, Long, Short, Float, o Double</code>, el 
proceso de unboxing se refiere a pasar mediante un método en el estilo de <code>{dataType}Value()</code> 
hacia un primitivo correspondiente.</li>
</list>
</tab>
</tabs>
<p>El proceso entonces de autoboxing and auto-unboxing de una variable recae en el programa y en la forma en la que 
nosotros estemos trabajando. <br/><br/>
Generalmente, cuando declaramos una variable envolvente y la inicializamos con un tipo de dato primitivo, el proceso 
de autoboxing sucede automáticamente debajo del sistema. Por otro lado, cuando nosotros creamos una variable 
primitiva y la inicializamos con una envolvente el proceso de autoboxing sucede automáticamente. Asimismo, esto 
sucede en las llamadas a las funciones cuyos parámetros sean envolventes y pasemos valores primitivos. 
<br/>
<br/>
Con el fin de comprender esto de una mejor manera, a continuación incluyo un snippet de código simple
</p>
<code-block lang="Java">
package example;

public class AutoboxingUnboxingExample {

    public static void main(String[] args) {
        // Autoboxing: Convirtiendo primitivo a Wrapper
        int primitiveInt = 50; // Entero primitivo
        // Convertido automáticamente a Integer (Wrapper)
        Integer autoboxedInt = primitiveInt;

        // Unboxing: Convirtiendo Wrapper a primitivo
            // Integer envolvente
        Integer wrapperInteger = Integer.valueOf(100); 
            // Convertido automáticamente a entero primitivo
        int unboxedInt = wrapperInteger; 

        // Ejemplos de Autoboxing en expresiones
            // Convertido automáticamente desde un double primitivo
        Double wrapperDouble = 10.5; 
            // Convertido automáticamente desde un float primitivo
        Float wrapperFloat = 5.7f; 

        // Unboxing en expresiones
            // Convertido automáticamente a primitivo en el cálculo
        double result = wrapperDouble * 2; 

        // Pasando primitivas a un método que espera Wrappers (Autoboxing)
        processInteger(25); // Autoboxing ocurre aquí

        // Retornando Wrappers desde un método que maneja primitivas (Autoboxing)
        Integer boxedResult = getAutoboxedInteger(15); // Autoboxing en el retorno del método
        System.out.println("Resultado autoboxed desde el método: " + boxedResult);
    }

    // Método que recibe Wrapper Integer (Autoboxing ocurre al pasar una primitiva)
    public static void processInteger(Integer value) {
        System.out.println("Entero procesado: " + value);
    }

    // Método que retorna Wrapper Integer (Autoboxing ocurre para el valor retornado)
    public static Integer getAutoboxedInteger(int value) {
        return value; // Autoboxing convierte primitivo a Wrapper
    }

}
</code-block>
</procedure>

## Strings, StringBuilders y StringBuffers

<p>Las Strings son un tipo de dato de Referencia, no iguales a un tipo envolvente pero que si se trabajan como 
objetos en memoria y cuyas referencias pueden ser compartidas entre partes de un programa. Una String en Java es una 
collecion de caracteres immutable, es decir, su contenido puede ser usado y su referencia sobreescrita 
<code>pero el contenido dentro de esta referencia no puede ser sobreescrito ni editado</code>. <br/><br/>
Ustedes entonces se preguntarán porque en algunos comentarios simplemente hacemos <code>String + String1</code>, 
esto se da porque al realizar una operación de concatenación de esta manera lo que estamos creando es una nueva 
String, formada a través de la concatenación de otras cadenas, más no modificando String.
<br/><br/>
Para trabajar con Strings es tan simple como definir una variable de tipo String, ya que está una vez declarada 
hagas lo que hagas no la puedes cambiar. No obstante, en Java existen dos clases adicionales que nos permiten manejar 
Strings y modificarlas, estas son <code>StringBuilders y StringBuffers</code>. 
<br/><br/>
La forma de trabajar con estos tipos de variables se presenta a continuación
</p>
<procedure>
<code-block lang="Java">
package example;


public class StringExamples {

    public static void main(String[] args) {
        // Strings: Ejemplo de declaración y concatenacion
        String cadena1 = "Hola"; // String immutable
        String cadena2 = " Mundo";
        // Concatenación crea una nueva String en memoria
        String concatenada = cadena1 + cadena2; 

        // StringBuilder: Mutable y más eficiente para modificaciónes
        StringBuilder sb = new StringBuilder("Hola"); 
        sb.append(" Mundo"); // Modificando directamente el contenido

        // StringBuffer: Similar a StringBuilder pero Thread-Safe (sincrónico)
        StringBuffer sbf = new StringBuffer("Hola"); 
        sbf.append(" Mundo"); // Modificando directamente el contenido

        // Comparación de contenido entre String, StringBuilder y StringBuffer
        System.out.println("Comparación de contenido: ");
        System.out.println("String concatenada: " + concatenada);
        System.out.println("StringBuilder: " + sb.toString());
        System.out.println("StringBuffer: " + sbf.toString());
    }

}
</code-block>
</procedure>
<p>Las diferencias en estas clases las podemos notar en el listado a continuación</p>
<procedure>
<tabs>
    <tab title="String Base">
        <list style="alpha-lower">
            <li><b><format color="CornFlowerBlue">Concurrencia</format></b>: Es recomendable usar String cuando la modificación en multiples hilos de trabajo no es probable y se requiere de una string immutable.</li>
            <li><b><format color="CornFlowerBlue">Memoria</format></b>: En algunos programas, si existe 
reutilización de algunos literales, sea en el mismo paquete o clase, el compilador reúsa los literales para ahorrar 
memoria</li> 
        </list>
    </tab>
    <tab title="StringBuilder">
        <list>
            <li><b><format color="CornFlowerBlue">Modificaciones Rápidas</format></b>: Es recomendable usar un 
StringBuilder cuando requerimos modificar strings con frecuencia, ya que provee mejor eficiencia en este tipo de 
operaaciones.</li> 
            <li><b><format color="CornFlowerBlue">Memoria</format></b>: StringBuilder ofrece mucha mayor eficiencia 
para modificación rápida de Strings, concatenación, eliminación, reverso e inserción, sin mayores costos de 
memoria</li> 
        </list>
    </tab>
    <tab title="StringBuffer">
        <list>
            <li><b><format color="CornFlowerBlue">Concurrencia</format></b>: StringBuffer presenta una mayor seguridad en el acceso de multi-hilo aunque tenga un trade-off en performance y velocidad de operaciones</li> 
             <li><b><format color="CornFlowerBlue">Memoria</format></b>: StringBuffer proporciona al programa una mejora en el manejo de memoria al reducir el overhead requerido para trabajar con modificaciónes en un ambiente multi-hilo.</li> 
        </list>
    </tab>
</tabs>
</procedure>




