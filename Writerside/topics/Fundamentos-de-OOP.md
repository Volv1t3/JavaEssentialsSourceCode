# Fundamentos de OOP - Estructuras Básicas

> Felicidades, si has llegado a este punto (leyendo todo el texto en anterior), estás casi al final del camino en 
> nuestro estudio de Java. Lo que queda en esta sección es revisar todos los conceptos relacionados con: 
> Programación Orientada a Objetos, Genéricos, Clases Internas, Anónimas y Lambas, y una introducción a Estructuras 
> de Datos.

## Fundamentos de OOP - Conceptos Previos
<p>La programación orientada a objetos es uno de los paradigmas de programación más usados en la industria, y es el 
pilar fundamental del cual muchos cursos de programación de la universidad se enganchan para enseñar tanto, lenguajes,
frameworks, patrones de diseño, etc. En el caso de Java y C++, el modelo de programación orientada a objetos se 
permite y ambos presentan algunas ayudas sintácticas dentro de sus respectivos lenguajes para el trabajo con este 
modelo.
<br/>
<br/>
Sin embargo, Java presenta algunas facilidades adicionales que C++ no cuenta en su base. Por ejemplo, Java incluye 
separaciones de tipos adicionales para clases cuyo contenido es abstracto, puramente abstracto o una implementación 
base. Incluye desde su base una orientación a la programación orientada a objetos, y al trabajar con módulos, 
paquetes y grupos relacionados de clases logra aislar código y facilitar su reúso mediante interacciones de paquetes.
<br/>
<br/>
Java, es un lenguaje idóneo para el desarrollo de OOP dado que su propio diseño <i>tiene una orientación a OOP</i>, 
la formulación interna del lenguaje, sus ayudas sintácticas, keywords y reglas de visibilidad entre clases, 
interfaces, clases abstractas, enumeraciones, etc., hacen de Java de un lenguaje puramente orientado a OOP, que si 
bien permite otros paradigmas de programación, siempre lo hace mediante una estructura interna basada en OOP.
<br/>
<br/>
Para comprender las bases de la programación orientada a objetos, conviene revisar los fundamentos de OOP y en 
añadidura, los conceptos y componentes básicos de Java que se usan para este paradigma.
</p>

### Los Pilares de OOP
<p>En esta sección, analizaremos los cuatro pilares de la programación orientada a objetos a manera de un listado 
de estos y la manera en la que Java nos ayuda a trabajar con estos. Si bien algunos conceptos podrían sonar poco 
familiares hasta este momento, dentro de esta misma página los analizaremos a detalle</p>
<list style="alpha-lower">
<li><b><format color="CornFlowerBlue">Inheritance</format></b>: Java incluye varias ayudas dentro del lenguaje para 
nosotros estructuras nuestras clases, interfaces, o clases abstractas de tal manera que mantengamos siempre el 
principio de herencia. <br/>
Con este fin, Java ha implementado varias keywords adicionales a las esperadas como <code>implements, extends, 
abstract, default</code>, las cuales nos permiten distinguir las raíces de nuestra estructura de herencia 
discriminando por una keyword más no, como en C++, por el código interno de una clase. <br/>
Adicionalmente, Java incluye varios nuevos <code>tipos de clases</code> que nos pueden ser de utilidad a la hora de 
estructurar nuestro programa en OOP, tipos nuevos como <code>Interfaces, Abstract Classes, Records, Enumerations, etc.
</code>, nos abren la puerta un camino de implementación OOP fácil e intuitivo.
</li> 
<li><b><format color="CornFlowerBlue">Polymorphism</format></b>: Al ser un lenguaje donde los objetos se pasan 
como referencias, definitivamente, el paso por referencia de instancias de una clase hija como una de una clase 
padre se vuelve extremadamente fácil. Este tipo de declaración son bastante útiles dado la <code>correcta 
y simple</code> estructuración de herencia en Java. Una clase puede ser referenciada mediante su clase base o 
alguna de sus interfaces, lo cual permite no solo remover la especialización en objetos al declararlos, sino que 
tambíen decidir cuál componente de la jerarquía de clases heredadas se usa en base de sus métodos.</li>
<li><b><format color="CornFlowerBlue">Encapsulation</format></b>: Java es un lenguaje cuya estructura de modificadores 
de acceso se refuerzan desde el inicio de la declaración de un simple archivo (!). Por este motivo la 
encapsulación de metodologías de trabajo, y la ofuscación de implementaciones internas es mucho más 
<code>fuerte, visible e intuitiva</code> en un lenguaje como Java que en C++. <br/>
Si bien es cierto que ambos lenguajes comparten esta metodología con modificadores de acceso, Java permite 
declarar métodos, variables, constantes o enumeraciones internas en cualquier parte del cuerpo interno de la clase, 
y con un modificador de acceso <code>personal, más no de un segmento entero</code>, permitiendo al programador 
realizar cambios de visibilidad rápidos para adaptarse a los cambios en su aplicación
</li> 
<li><b><format color="CornFlowerBlue">Abstraction</format></b>: Java, mediante sus clases, scopes de trabajo, 
paquetes y demás, logra una abstracción del código implementado del usuario rápido y de una manera sencilla para 
el programador. Mediante nuevos tipos de clases como <code>Abstract Classes o Interfaces</code>, el programador 
puede separar la lógica de una aplicación, abstraerla mediante métodos relacionados, y presentar al usuario una 
interface simple de uso. </li>
</list>

<p>Sin lugar a duda, algunas partes de esta explicación pueden haber sonado extrañas para alguien acostumbrado a 
solo tener clases en lenguajes como C++, y que en lugar de solo un tipo ahora tener cuatro(*) distintos tipos de 
clases que debe tener en cuenta a la hora de decidir como implementar o diseñar su aplicación.
<br/>
<br/>
No obstante, el propósito de esta sección también fue explicarte de una manera básica el funcionamiento de las 
cuatro bases de OOP en java, concepto que exploraremos a detalle tanto en el curso, en el material adicional y en 
esta sección.
</p>

### Requerimientos Base para una Clase en Java
<p>Aunque todos los ejemplos anteriores de clases en este archivo y en los ejemplos de práctica de la sección 
anterior han demostrado la forma de definir clases y trabajar con su archivo main, declarar parámetros, métodos, 
constantes, etc., el hecho de saber como definirlas, no significa que lo hagamos bien. Por este motivo, todas las 
clases en la sección de OOP en el curso y en gran medida aquellas presentadas en esta sección, seguirán los 
requerimientos de clases generales que se solicitan en cualquier clase de programación cuyo contenido se impartan en 
Java, 
y en especial, en un ambiente OOP.
</p>
<procedure>
<tabs>
<tab title="Requerimientos Base para una Clase en Java">
<list style="decimal">
<li><b><format color="CornFlowerBlue">Nombramiento de la clase y Archivo .java</format></b>: En Java, se espera que las 
clases siempre se definan de una manera tal que <code>El Nombre del archivo .java debe coincidir con el nombre de la clase 
pública</code>
<br/>
Asimismo, el nombre de la clase pública debe siempre iniciar con mayúsculas y seguir un formato único, por ejemplo 
<code>CamelCase</code> o <code>Snake_Camel_Case</code> o <code>Snake_case</code>
<procedure>
<code-block lang="Java">
//... en el archivo OOPExampleOne
package OOP_Examples;

public class OOPExampleOne 
        /*También puede ser OOP_Example_One*/ {
    //... Resto del Código
}
</code-block>
</procedure></li>
<li><b><format color="CornFlowerBlue">Implementación de Constructores</format></b>: Una clase en Java, ya sea para 
un trabajo personal, de Estructuras de Datos, etc., debe tener <code>como mínimo tres constructores</code>, los 
cuales deben estar estructurados de tal modo que 
<br/>
<code-block lang="Markdown">
1) Exista un constructor con todos los parámetros de la clase.
2) Exista un constructor con los parámetros más 
   importantes de la clase.
3) Exista un constructor sin parámetros default
</code-block>

La razón para este tipo de diseño es que en algunos casos, en proyectos más avanzados o con librerías estándar de Java, 
se espera que las clases implementen un constructor por defecto para su funcionamiento (Se ve mucho de este tema en 
serialización de datos con librerías de XML y JSON). Los ótros dos constructores facilitan la implementación de código
y el trabajo con este.
<procedure>

```Java
    //... en el archivo OOPExampleOne;

    package OOP_Examples;
    
    public class OOPExampleOne
            /*También puede ser OOP_Example_One*/{
        private String paramOne;
        private String paramTwo;
        private ArrayList<Integer> paramThree = new ArrayList<>();
        
        public OOPExampleOne(String exParamOne,
                             String exParamTwo,
                             ArrayList<Integer> exParamThree)
        {
            this.paramOne = exParamOne;
            this.exParamTwo = exParamTwo;
            this.paramThree = exParamThree;
        }
        
        public OOPExample(String exParamOne, String exParamTwo){
            this.paramOne = exParamOne;                 
            this.paramTwo = exParamTwo;
             
        }

        // No-args constructor
        public OOPExampleOne() {
            this.paramOne = "";
            this.paramTwo = "";
        }
        
    }
```
</procedure>
</li>
<li><b><format color="CornFlowerBlue">Getters y Setters</format></b>: 
Dentro de Java, adicional a las reglas que existen dentro de esta sección para el trabajo con clases, usualmente 
hay convenciones de nombramiento de <code>variables, métodos, clases y constructores</code>, los cuales se han 
creado para estandarizar el trabajo con librerías externas. <br/>
En nuestro caso, no es necesario estudiar estas reglas a fondo, sin embargo, es important conocer que IntelliJ 
corrige y sugiere <code>nombres e implementaciones de métodos setter y getter apropiados, siguiendo estas 
normativas</code>. Por tanto, es útil en algunos casos dejar que IntelliJ implemente estos métodos. <br/>
No obstante, <code>siempre hay que implementar Getters y Setters para todo parámetro de nuestro clase.</code>
<procedure>

```Java
    //... en el archivo OOPExampleOne;

    package OOP_Examples;
    
    public class OOPExampleOne
            /*También puede ser OOP_Example_One*/{
        private String paramOne;
        private String paramTwo;
        private ArrayList<Integer> paramThree = new ArrayList<>();
        
        /*
        * Solo implemento los Setters y Getters, se asume que los 
        * constructores en este punto los usan para manejar su 
        * entrada de datos
        */
        
        // Getters y Setters para paramOne
        public String getParamOne() {
            return paramOne;
        }
    
        public void setParamOne(String paramOne) 
                        throws IllegalArgumentException{
            if (paramOne != null && paramOne.length() >= 0) {
                this.paramOne = paramOne;
            } else {
                throw new 
                IllegalArgumentException(
                "paramOne no puede ser nulo y su longitud" + 
                " debe ser mayor a >= 0.");
            }
        }
    
        // Getters and Setters for paramTwo
        public String getParamTwo() {
            return paramTwo;
        }
    
        public void setParamTwo(String paramTwo) 
                        throws IllegalArgumentException{
            if (paramTwo != null && paramTwo.length() >= 0) {
                this.paramTwo = paramTwo;
            } else {
                throw new 
                IllegalArgumentException(
                "paramTwo no puede ser nulo y su longitud" + 
                " debe ser mayor a >= 0.");
            }
        }
    
        // Getters and Setters for paramThree
        public ArrayList<Integer> getParamThree() {
            return paramThree;
        }
    
        public void setParamThree(ArrayList<Integer> paramThree)
                    throws IllegalArgumentException {
            if (paramThree != null && !paramThree.isEmpty()) {
                this.paramThree = paramThree;
            } else {
                throw new 
                IllegalArgumentException(
                "paramThree no puede ser nulo o estar vacio!");
            }
        }
    }
```
</procedure>
</li> 
<li><b><format color="CornFlowerBlue">Overwrites de la Clase Object</format></b>: Como hemos notado desde el inicio de esta charla
en Java todo parte de la clase Object, y con justa razón, esta <code>provee a nuestros objetos de vários 
métodos base como toString(), equals(), hashCode()</code>, que son útiles para serialización, comparativa de 
objetos, etc.
<br/>
Como notamos anteriormente, la comparativa de objetos a través de un <code>==</code>, no revisa los objetos en si, 
sino su <i>dirección en memoría para ver si son el mismo objeto en términos de referencias</i>, en ese caso nosotros 
como usuarios debemos usar el método <code>equals()</code>, de nuestros objetos (ya sea de Java.base o propios) ya 
que solo este compara si realmente, internamente, los objetos son lo mismo.
<br/>
Adicionalmente es important sobreescribir <code>toString()</code>, ya que es un método útil para procesos de 
Debugging del código y nos permiten evaluar rápidamente el estado interno total de nuestro objeto.
<br/>
Por su parte, <code>hashCode()</code> se usa casi al final de estructuras de datos para hablar de hash tables, etc. 
Por lo que este método, en clases básicas no es tan necesario.
<procedure>

```Java
    //... en el archivo OOPExampleOne;

    package OOP_Examples;
    
    public class OOPExampleOne
            /*También puede ser OOP_Example_One*/{
        private String paramOne;
        private String paramTwo;
        private ArrayList<Integer> paramThree = new ArrayList<>();
        
        /*
         * En este punto se asume que los constructores usan los 
         * Setters y Getters, que estos se han definido, y en las 
         * siguientes líneas se determinan solo los Overrides 
        */
        
        //toString()
        @Override
        public String toString() {        
            return "{ " +
                    "\"paramOne\": \"" + paramOne + "\",\n" +
                    "\"paramTwo\": \"" + paramTwo + "\",\n" +
                    "\"paramThree\": " + paramThree +
                    " }";
        }
        
        //equals()
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true; 
            }
            else if  (obj == null || 
                            this.getClass() != obj.getClass()) {
                return false; 
            } else {
                // Como sabemos que son de la misma clase, 
                // hacemos una conversion 
                OOPExampleOne that = (OOPExampleOne) obj; 
                
                return Objects.equals(paramOne, that.paramOne) &&
                       Objects.equals(paramTwo, that.paramTwo) &&
                       Objects.equals(paramThree, that.paramThree);
            }           
        }
        
    }
```
</procedure>
</li> 
<li><b><format color="CornFlowerBlue">Implementación de Orden Natural y/o Comparator</format></b>: En Java, las 
clases deben tener un método que les permita ordenarse entre sí en un contexto de estructuras de datos, por 
ejemplo. Usualmente, las clases base de Java traen una implementación de un <code>orden natural, definido 
por la interface Comparable y su método compareTo(...)</code>, mientras que otras se pueden adaptar, o tienen 
implementaciones de un ordenamiento parecido a una función amiga mediante <code>la interface Comparator y 
su método compare(... , ...)</code>.<br/>
Si bien revisaremos más a detalle estas estructuras cuando topemos interfaces en nuestro contenido principal, es 
importante mostrar una implementación básica de <b>la interface Comparable</b>, dado que es la principal que se 
espera que cualquier clase implemente en Java
<procedure>

```Java
    //... en el archivo OOPExampleOne;

    package OOP_Examples;
    
    public class OOPExampleOne implements Comparable<OOPExampleOne>
            /*También puede ser OOP_Example_One*/{
        private String paramOne;
        private String paramTwo;
        private ArrayList<Integer> paramThree = new ArrayList<>();
        
        /*
         * En este punto, toda la sanitización de la clase se asume
         * completa, las implementaciones adicionales 
         * son solo de Comparable        
        */
        
        
        @Override
        public int compareTo(OOPExampleOne other) {
            if (other == null) {
                throw 
                 IllegalArgumentException(
                 "La otra instancia es nula!");
            }
            if (this == other) {
                return 0; // Misma referencia en memoria
            }
            if (this.getClass() != other.getClass()) {
                throw 
                new ClassCastException(
                "Las clases no tiene el mismo tipo de dato!");
            }
    
            //! Si no se cae el programa, comparamos con la 
            //! longitud del arreglo interno
            return Integer
                        .compare(
                            this.paramThree.size(), 
                            other.paramThree.size());
        }
        
    }
```
</procedure>
</li> 
</list>
</tab></tabs>
</procedure>
<p>Si se siguen estas reglas durante la implementación inicial de las clases en Java, entonces tendremos mucha mas 
facilidad de interoperabilidad con varios métodos de Java y clases base, así como una gran facilidad a la hora de 
Debuggear el código gracias a <code>toString()</code>.</p>

### Ejemplo OOPExampleOne completo
<p>El código presentado anteriormente mostró una implementación de una clase completa, cuyo trabajo no ha terminado. 
Para esta sección (la cual puedes obviar), se muestra el código completo de la clase anterior junto con métodos 
adicionales de manipulación de los campos internos. <br/><br/>
El objetivo de esto es permitirte observar como se definen tanto, parámetros de clases, métodos, constructores, 
métodos de ayuda, etc., para que conozcas como las clases se estructuran en el lenguaje.
</p>
<procedure>
<tabs>
<tab title="OOPExampleOne Completo">

```Java
//... en el archivo OOPExampleOne.java
package OOP_Examples;

public class OOPExampleOne 
        implements Comparable<OOPExampleOne> {
    
        private String paramOne;
        private String paramTwo;
        private ArrayList<Integer> paramThree = new ArrayList<>();
        
        public OOPExampleOne(String exParamOne,
                             String exParamTwo,
                             ArrayList<Integer> exParamThree)
        {
            this.paramOne = exParamOne;
            this.exParamTwo = exParamTwo;
            this.paramThree = exParamThree;
        }
        
        public OOPExample(String exParamOne, String exParamTwo){
            this.paramOne = exParamOne;                 
            this.paramTwo = exParamTwo;
             
        }

        // No-args constructor
        public OOPExampleOne() {
            this.paramOne = "";
            this.paramTwo = "";
        }
           
        // Getters y Setters para paramOne
        public String getParamOne() {
            return paramOne;
        }
    
        public void setParamOne(String paramOne) 
                        throws IllegalArgumentException{
            if (paramOne != null && paramOne.length() >= 0) {
                this.paramOne = paramOne;
            } else {
                throw new 
                IllegalArgumentException(
                "paramOne no puede ser nulo y su longitud" + 
                " debe ser mayor a >= 0.");
            }
        }
    
        // Getters and Setters for paramTwo
        public String getParamTwo() {
            return paramTwo;
        }
    
        public void setParamTwo(String paramTwo) 
                        throws IllegalArgumentException{
            if (paramTwo != null && paramTwo.length() >= 0) {
                this.paramTwo = paramTwo;
            } else {
                throw new 
                IllegalArgumentException(
                "paramTwo no puede ser nulo y su longitud" + 
                " debe ser mayor a >= 0.");
            }
        }
    
        // Getters and Setters for paramThree
        public ArrayList<Integer> getParamThree() {
            return paramThree;
        }
    
        public void setParamThree(ArrayList<Integer> paramThree)
                    throws IllegalArgumentException {
            if (paramThree != null && !paramThree.isEmpty()) {
                this.paramThree = paramThree;
            } else {
                throw new 
                IllegalArgumentException(
                "paramThree no puede ser nulo o estar vacio!");
            }
        }
        
        //toString()
        @Override
        public String toString() {        
            return "{ " +
                    "\"paramOne\": \"" + paramOne + "\",\n" +
                    "\"paramTwo\": \"" + paramTwo + "\",\n" +
                    "\"paramThree\": " + paramThree +
                    " }";
        }
        
        //equals()
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true; 
            }
            else if  (obj == null || 
                            this.getClass() != obj.getClass()) {
                return false; 
            } else {
                // Como sabemos que son de la misma clase, 
                // hacemos una conversion 
                OOPExampleOne that = (OOPExampleOne) obj; 
                
                return Objects.equals(paramOne, that.paramOne) &&
                       Objects.equals(paramTwo, that.paramTwo) &&
                       Objects.equals(paramThree, that.paramThree);
            }           
        }
        
        @Override
        public int compareTo(OOPExampleOne other) {
            if (other == null) {
                throw 
                 IllegalArgumentException(
                 "La otra instancia es nula!");
            }
            if (this == other) {
                return 0; // Misma referencia en memoria
            }
            if (this.getClass() != other.getClass()) {
                throw 
                new ClassCastException(
                "Las clases no tiene el mismo tipo de dato!");
            }
    
            //! Si no se cae el programa, comparamos con la 
            //! longitud del arreglo interno
            return Integer
                        .compare(
                            this.paramThree.size(), 
                            other.paramThree.size());
        }
        /*
         * Los metodos adicionales inician aqui
        */
        
        public void anadirElementoAParamThree(Integer element) 
               throws IllegalArgumentException {
            if (element != null) {
                this.paramThree.add(element);
            } else {
                throw new IllegalArgumentException(
                    "El elemento no puede ser nulo!");
            }
        }

        
        public boolean paramThreeContieneElemento(Integer element) {
            return this.paramThree.contains(element);
        }
    
        
        public String paramOneEnMayusuclas() {
            return paramOne != null ? paramOne.toUpperCase() : null;
        }
    
    
        public String paramTwoEnMinusculas() {
            return paramTwo != null ? paramTwo.toLowerCase() : null;
        }
}
```
</tab>
</tabs>
</procedure>



## Fundamentos de OOP - Tipos de Clases en Java
<p>En Java existen, además de la típica clase base de C++, que coincidentalmente mantiene la misma keyword class, 
otros tipos de clases, como son las <code>interfaces, clases abstractas, records, y enumeraciones</code> estas son la 
base de cualquier jerarquía de clases, sea de la librería estándar de Java o de nuestras propias librerías o 
proyectos desarrollados con una metodología OOP. <br/><br/>
Para explicar estos nuevos tipos de clases, sus utilidades, reglas y ejemplos de implementación, esta sección 
contiene una serie de subsecciones dedicadas a cada una de estas, en donde todo lo necesario para su utilización se 
encuentra visible y en una manera estructurada para su rápido acceso.
<br/><br/>
Cabe recalcar, que como cualquier otro tipo de clase normal o archivo de prueba que hemos definido hasta el momento, 
cada archivo que contenga una de estas nuevas clases debe <code>contener solo una (clase/interface/clase 
abstract/record/enumeración) pública</code>, no obstante como veremos en las siguientes secciones de este capítulo 
de OOP, podemos además incluir otras clases en nuestros archivos, solo que con algunas consideraciones adicionales.
</p>

### Clases en Java
<p>Las clases en Java, por lo menos las clases base que se conocen desde C++ heredan la mayoría de su estructuración 
y reglas las hereda desde C++, como por ejemplo las reglas de visibilidad de clases, parámetros, métodos y clases 
internas(por discutirse en otra sección). No obstante, Java contempla varias reglas adicionales en las clases que 
soporta el lenguaje, en su declaración y en la manera en la que esta debe ser estructurada.
<br/>
<br/>
Por este motivo, esta primera sección se encargará de definir las reglas internas del lenguaje (definidas en el 
manual de implementación de Java SE) que se deben tomar en cuenta al crear nuestras clases.   
</p>
<procedure>
<tabs>
<tab title="Reglas Con Respecto a su Definición">
<list columns="1">
<li><b><format color="CornFlowerBlue">Top Level Classes</format></b>: Una <i>top level class</i>, hace referencia a 
una clase general declarada como <code>public class {nombre}</code>, la cual se declara directamente en un archivo. 
Este tipo de clases son las más usadas en Java y en los ejemplos que se presentan aquí y en el código proporcionado 
para el curso.
<br/>
Este tipo de declaración se demuestra en el siguiente bloque de código
<code-block lang="Java"> 
//... en el archivo ClaseBase.Java
package OOP_Examples;

public class ClaseBase {
    //... resto del código aquí
}
</code-block>
</li> 
<li><b><format color="CornFlowerBlue">Herencia de Clases</format></b>: En Java, <code>una clase declarada, 
independientemente de su modificador de acceso, solo puede heredar una sola clase abstracta u otra clase 
base</code>. <br/>
El formato para realizar este tipo de herencias hace uso de la keyword <code>extends</code>, como en el 
siguiente ejemplo de código
<procedure>
    
```Java
    //... en el archivo ClaseBase.java
    package OOP_Examples;
    
    public class ClaseBase{
        // Parametros internos
        private String claseBaseString;
        protected int claseBasePrimInt = 0;
        public static final String claseBaseConstante = "HELLO";
        
        /*
         * El código de esta clase se mantiene simple para 
         * mostrar solo lo que es importante.
         * En este caso: herencia de clases
        */
        public ClaseBase(String exClaseBaseString){
            this.claseBaseString = exClaseBaseString;
        }
    }
    
    //... en el archivo ClaseDerivada.java
    
    package OOP_Examples;
    
    public class ClaseDerivada extends ClaseBase {
        /*! Esta clase derivada tiene accesso a todos los parametros
         *! publicos de la clase anterior, asi como de los protected.
         *! La String interna privada no puede ser accedida desde aqui
         *! directamente (como C++)
        */
        private String claseDerivadaString;
    
        public ClaseDerivada(String exClaseBaseString, 
                            String exClaseDerivadaString) {
            // Llamada al constructor de ClaseBase
            super(exClaseBaseString); 
            this.claseDerivadaString = exClaseDerivadaString;
        }
    
        // Métodos adicionales (si se requieren) pueden agregarse aquí.
    }
```
</procedure>
</li> 
<li><b><format color="CornFlowerBlue">Herencia de Interfaces</format></b>: En java <code>una clase 
declarada, independientemente de su modificar de acceso, puede implementar una o más interfaces siempre y 
cuando cumpla con sus contratos</code>. En este sentido, una clase en Java puede implementar tantas interfaces 
como este quiera, mientras que solo pueda extender una clase.
<br/>
La forma de manejar este tipo de herencia en Java es mediante la keyword <code>implements</code>, y si es 
necesario el listado de interfaces separadas por coma. <br/>
El siguiente ejemplo demuestra este tipo de declaraciones.

<procedure>

```Java
//... en el archivo ClaseDerivadaAvanzada.java

package OOP_Examples;

import java.util.List;
import java.util.Comparator;

public class ClaseDerivadaAvanzada 
        implements List<Object>, 
        Comparable<ClaseDerivadaAvanzada>,
        Comparator<ClaseDerivadaAvanzada> {
        
        /*! Esta clase tiene la declaración 
        *!  necesaria para implementar
        *!  las interfaces List, Comparable y Comparator.
        *!  No implementa ningun metodo en este ejemplo.
        */
}
```
</procedure>
</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a su Contenido">
<list>
<li><b><format color="CornFlowerBlue">Contenido de la Clase</format></b>: Una clase puede contener miembros como 
variables, métodos, otras clases o interfaces. Asimismo, puede contener métodos estáticos, parámetros estáticos, 
constructores privados, etc. <br/>
Si una clase hereda de otra, esta clase asume internamente los contenidos de la clase <code>extendida y los puede 
modificar y usar.
</code>
<br/>
El siguiente ejemplo, muestra como trabajar con el contenido de una clase, declarando métodos y variables.
<code-block lang="Java">
package OOP_Examples;

public class ClaseConContenidos {

    // Variables públicas, protegidas y privadas
    public String variablePublica;
    private int variablePrivada;
    protected float variableProtegida;

    // Variables estáticas
    public static final String CONSTANTE_FINAL = "VALOR_INMUTABLE";
    private static int contador = 0;
    protected static double tasaInteres = 0.05;

    // Variable estática final
    private static final int VALOR_MAXIMO = 100;

    // Constructor
    public ClaseConContenidos(String variablePublica, 
                              int variablePrivada, 
                              float variableProtegida) {
        this.variablePublica = variablePublica;
        this.variablePrivada = variablePrivada;
        this.variableProtegida = variableProtegida;
    }

    // Getters y métodos con diversos modificadores de acceso

    // Getter público
    public String getVariablePublica() {
        return this.variablePublica;
    }

    // Getter privado
    private int getVariablePrivada() {
        return this.variablePrivada;
    }

    // Getter protegido
    protected float getVariableProtegida() {
        return this.variableProtegida;
    }

    // Método estático público
    public static int getContador() {
        return contador;
    }

    // Método estático protegido
    protected static double getTasaInteres() {
        return tasaInteres;
    }

    // Método privado final
    private final String metodoPrivadoFinal() {
        return "Este método es privado y final.";
    }

}
</code-block>
</li> 
<li><b><format color="CornFlowerBlue">Alcance de los Contenidos</format></b>: Todo campo declarado internamente en 
una clase, bajo las normas de acceso definidas por sus modificadores, puede ser utilizada en todo el campo de la 
clase, y dependiendo de sus modificadores fuera de esta, adicionalmente.</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a sus Modificadores">
<list>
<li><b><format color="CornFlowerBlue">Modificadores de Estructura</format></b>: 
<p>Una clase en Java puede ser 
declarada solo con la keyword <code>class</code>, que la declara como una clase base similar a las de C++. <br/>
Adicionalmente, una clase puede ser declarada con la keyword <code>abstract</code> para transformarla en una clase 
explicitamente abstracta, u con algún modificador de tipo <code> genérico </code>, que volvería a la clase en una 
clase genérica parametrizada.</p>
<br/>
En el siguiente ejemplo, mostramos que se debe y que no se debe hacer al usar modificadores en clases
<code-block lang="Java">
package OOP_Examples;

//... en el archivo ClaseCorrecta.java
// Clase base correctamente declarada 
public class ClaseCorrecta {
}

//... en el archivo ClaseErrorDosModificadores.java
// Clase con dos modificadores de acceso seguidos 
// (esto generará un error de compilación)
private public class ClaseErrorDosModificadores {
}

//... en el archivo ClaseErrorStaticTopLevel.java
// Clase con modificadores estáticos en una top-level class 
// (esto generará un error de compilación)
public static class ClaseErrorStaticTopLevel {
}
</code-block>
</li> 
<li><b><format color="CornFlowerBlue">Modificadores de Acceso en Clases</format></b>: En Java, solo aquellas <i>top 
level 
classes </i> pueden tener un modificador de acceso <code>publico</code>, toda clase secundaria dentro del mismo 
archivo tiene por defecto <code>un modificador de acceso privado y no estático</code>
<br/>
Esto se muestra en el siguiente snippet de código
<br/>
<code-block lang="Java">
//... en el archivo ClasesVisibilidadEjemplo.java

package OOP_Examples;

// Clase top-level correctamente declarada como pública
public class ClaseCorrectamentePublica {
    // Contenido de la clase puede agregarse aquí
}

/*
 * Segunda clase en el mismo archivo, esto genera una warning 
 * de IntelliJ, y un error de compilación al intentar modificar
 * el acceso a una clase secundaria en un archivo que contiene 
 * una clase publica
*/
public static class ClaseConVisibilidadConflictiva {
// Contenido de la clase puede agregarse aquí (nunca será necesario porque esto no compila)
}

// Clase secundaria en el mismo archivo sin modificadores de acceso
// Por defecto, esta clase tendrá el modificador "package-private"
class ClaseSinModificadores {
    // Contenido de la clase puede agregarse aquí
}
</code-block>
</li>
<li><b><format color="CornFlowerBlue">Modificadores de Acceso en Contenidos</format></b>: Los contenidos de una 
clase deben igualmente seguir ciertas normas con respecto a sus modificadores. <br/> En los métodos, constructores, 
y parámetros internos <code>se puede usar modificadores como private, public o protected</code>. No obstante, 
<code>solo variables y métodos pueden tener un modificador static o final (en el caso de final este no permite 
la sobre-escritura de valores o métodos por clases hijas</code>.
<br/>
Los constructores de una clase no pueden ser <code>ni estáticos ni finales</code> 
</li> 
<li><b><format color="CornFlowerBlue">Orden de los Modificadores en Clases</format></b>: El orden de los 
modificadores de acceso de una clase, variable o método importan mucho ya que <code>pueden dar errores de 
compilación si no están en el orden correcto</code>. La idea estos es seguir un tipo de declaración de los 
siguientes estilos
<code-block lang="Markdown">
    1) Si se trabaja con clases entonces [Class Access Modifier] class 
                            [Type Identifier]  [Type Parameters]
                            [Class Extends]    [Class Implements] 
                            [Class Permits]    [Class Body]
    2) Si se trabaja con variables o métodos
        [public | protected | private | static | final | 
                                    transient | volatile] 
                                    [Type | Return Type] identifier 
                                    [Initialization | Method Body]
</code-block>
</li> 
</list>
</tab>
</tabs>
</procedure>
<p>Las reglas definidas anteriormente nos demuestran la gran versatilidad que le da este sistema de modificadores 
por declaración que introdujo Java en comparación con C++. Claro está que esto ha traído un nivel de complejidad 
superior a la hora de definir la arquitectura de nuestras clases, dada la cantidad de reglas existentes para el 
comportamiento de una clase, herencia, y declaración de métodos.
<br/><br/>
No obstante, debemos de tener en cuenta que esta cantidad de reglas, nos permite desarrollar con un nivel de revisión 
adicional, lo que garantiza, hasta cierto punto, una calidad de software elevada. Antes de pasar a nuestra sección 
sobre clases abstractas, el siguiente ejemplo muestra en su totalidad un trabajo con una clase que hereda una clase 
e implementa Comparable
</p>

```Java
package OOP_Examples;

//... en el archivo ClaseBase.java
public class ClaseBase {
    // Parámetros de clase
    private String nombre;
    private int edad;
    private double salario;

    public ClaseBase(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }


    @Override
    public String toString() {
        return "ClaseBase{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }

}

//... en el archivo ClaseDerivada.java
class ClaseDerivada extends ClaseBase 
                    implements Comparable<ClaseDerivada> {
    // Parámetros específicos de la clase derivada
    private String departamento;
    private String cargo;

    // Constructor completo
    public ClaseDerivada(String nombre, int edad, double salario, 
                             String departamento, String cargo) {
        // Llamando al constructor de la clase base
        super(nombre, edad, salario);
        this.departamento = departamento;
        this.cargo = cargo;
    }

    // Constructor que solo usa los parámetros de la clase base
    public ClaseDerivada(String nombre, int edad, double salario) {
        super(nombre, edad, salario);
    }

    // Constructor vacío
    public ClaseDerivada() {
        super("", 0, 0.0);
    }

    // Getters y Setters de los parámetros propios
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Sobrescribiendo toString para incluir los parámetros 
    // de la clase derivada
    @Override
    public String toString() {
        return "ClaseDerivada{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", salario=" + getSalario() +
                ", departamento='" + departamento + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }

    // Sobrescribiendo equals para comparar objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaseDerivada that = (ClaseDerivada) o;
        return getNombre().equals(that.getNombre()) &&
                getEdad() == that.getEdad() &&
                Double.compare(that.getSalario(), getSalario()) == 0 
                && departamento.equals(that.departamento) &&
                cargo.equals(that.cargo);
    }

    // Implementando Comparable
    @Override
    public int compareTo(ClaseDerivada o) {
        // Comparar por salario
        return Double.compare(this.getSalario(), o.getSalario());
    }

}
```

### Clases Abstractas en Java
<p>A diferencia de C++ las clases abstractas en Java no siempre tienen que ser <code>puramente abstractas</code> 
como se había utilizado en C++, en cambio, las clases abstractas en Java pueden tener en su totalidad métodos 
abstractos, pero este no siempre es el caso.
<br/><br/>
En Java una clase abstracta no solo puede contener métodos abstractos, sino que también puede contener <code>métodos cuya 
implementación se proporcione</code>, así como <code> parámetros y constantes estáticas</code> De este modo podemos 
considerar a una clase abstracta como un intermedio de lo que era una clase abstracta en C++. Teniendo en gran 
medida una similitúd con sus comportamientos, pero permitiendo que esta tenga una variedad de métodos e 
implementaciones.
<br/><br/>
Sin duda este tipo de implementaciones son muy distintas a la clase puramente abstracta en C++ (más adelante veremos 
su equivalente directo), pero son muy útiles a la hora de organizar clases mediante <code>comportamiento 
compartido en clases relacionadas</code>
<br/><br/>
Las siguientes son unas de las características de las clases abstractas, definidas por la implementación 
estandarizada de Java SE. 
</p>
<procedure>
<tabs>
<tab title="Reglas Con Respecto a su Definición">
<list columns="1">
<li><b><format color="CornFlowerBlue">Definición General</format></b>: Una <i>abstract class</i>, hace referencia a 
una clase que se encuentra incompleta, o que se puede considerar incompleta. Esta clase es la única que permite la 
declaración de métodos abstractos para una clase normal (fuera de las interfaces).
<br/> 
El siguiente bloque de código muestra la forma en la que se declara una clase abstracta usando los ejemplos anteriores
<code-block lang="Java"> 
//... en el archivo ClaseBase.Java
package OOP_Examples;

public abstract class ClaseBase {
//... resto del código aquí
}
</code-block>
</li> 
<li><b><format color="CornFlowerBlue">Herencia de Clases</format></b>: En Java una clase abstracta puede 
<code>heredar una sola clase al igual que cualquier otra clase</code>. Si esta clase heredad es abstracta, 
<code>esta puede implementar o no los métodos heredados</code>. Si esta clase no es abstracta, la herencia se da 
mediante los mecanismos normales definidos anteriormente.
<br/>
Hay que tener en cuenta que cualquier clase <code>base no abstracta que herede usando extends una clase 
abstracta</code> tiene que implementar <code>todos los métodos definidos en esta</code>, inclusive si la clase 
abstracta tiene una clase abstracta por debajo adicional.
<br/>
El siguiente ejemplo, mostrará la manera de implementar una mini jerarquía de clases abstractas.


```Java
    //... en el archivo ClaseAbstractaUno.java
    package OOP_Examples;
    
    public class ClaseAbstractaUno{
        
        /*
         * Al igual que cualquier método, un método abstracta 
         * se declara usando las mismas combinaciones de modificadores, 
         * solo anadiendo un modificar abstract
        */
        public abstract void doSomething();
        
        /*
         * Extra: asi se declara una variable en una clase abstracta
        */
        public final String abstractOneName = "Juan";
    }
    
    //... en el archivo ClaseAbstractaDos.java
    
    package OOP_Examples;
    
    public class ClaseAbstrataDos extends ClaseAbstractaDos{
    
        /*
         * Declarando un método abstracto "saySomething"
         * utilizando las mismas combinaciones de modificadores.
         */
        public abstract void saySomething();
    
        /*
         * Declarando una variable final estática.
         * Estas variables son constantes y no cambian 
         * durante la ejecución.
         */
        public static final String CONSTANTE_SAY_SOMETHING = 
                            "Hola desde la clase abstracta";
            
        }
        
    //... en el archivo ClaseBaseExtendida.java
    
    package OOP_Examples;

    public class ClaseBaseExtendida extends ClaseAbstractaDos {
    
        /*
         * Implementación del método abstracto "doSomething"
         * heredado de la clase ClaseAbstractaDos.
         */
        @Override
        public void doSomething() {
            System.out.println("Realizando algo desde la clase" +
            " base extendida.");
        }
    
        /*
         * Implementación del método abstracto "saySomething"
         * heredado de la clase ClaseAbstractaDos.
         */
        @Override
        public void saySomething() {
            System.out.println(
                       "Saludos desde la clase base extendida.");
        }
    }
```
</li> 
<li><b><format color="CornFlowerBlue">Herencia de Interfaces</format></b>: Al igual que las clases base, las clases 
abstractas pueden declarar que implementan, o que sus clases extensoras deberían de implementar una o varías 
interfaces, eso funciona ya que <code> las interfaces generalmente tienen métodos abstractos, los cuales se 
adhieren al contrato de una clase abstracta</code>
<br/> 
En este sentido una clase que extienda una clase abstracta debe atenerse también a la implementación de cualquier
interface adicional que venga por añadidura con la clase abstracta.

```Java

//... en el archivo ClaseAbstractaConComparable.java
package OOP_Examples;

public abstract class ClaseAbstractaConComparable 
    implements Comparable<ClaseAbstractaConComparable> {

    // Variables protegidas
    protected int id;
    protected String nombre;

    // Setter para 'id'
    protected void setId(int id) {
        this.id = id;
    }

    // Setter para 'nombre'
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

//... en el archivo ClaseBaseImplementadora.java
package OOP_Examples;

public class ClaseBaseImplementadora extends 
    ClaseAbstractaConComparable {

    // Implementación del método compareTo
    @Override
    public int compareTo(ClaseAbstractaConComparable o) {
        // Comparación basada en 'id'
        return Integer.compare(this.id, o.id);
    }

    // Método que permite configurar 'id' y 'nombre' 
    // usando los setters heredados
    public void configurarValores(int id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
    }

}
```

</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a su Contenido">
<list>
<li><b><format color="CornFlowerBlue">Contenido de la Clase</format></b>: Una clase abstracta, <code>si bien debe 
contener a lo menos un método abstracto</code> no necesita de contener todo método como abstracto. Existen también 
declaraciones de métodos <code> no abstractos</code>, que se realizan de una manera completamente similar a los de 
una clase normal.
<br/>
Adicionalmente, una clase abstracta puede contener tanto <code>campos como constantes</code>, permitiendo un control 
fino de la manera en la que se comparten campos y detalles de implementación entre clases extensoras. 

<br/>
El siguiente ejemplo, muestra como trabajar con el contenido de una clase abstracta, declarando métodos y variables.
<code-block lang="Java">
package OOP_Examples;

public abstract class ClaseConContenidos {

    // Variables públicas, protegidas y privadas
    public String variablePublica;
    private int variablePrivada;
    protected float variableProtegida;

    // Variables estáticas
    public static final String CONSTANTE_FINAL = "VALOR_INMUTABLE";
    private static int contador = 0;
    protected static double tasaInteres = 0.05;

    // Variable estática final
    private static final int VALOR_MAXIMO = 100;

    // Constructor
    public ClaseConContenidos(String variablePublica, 
                              int variablePrivada, 
                              float variableProtegida) {
        this.variablePublica = variablePublica;
        this.variablePrivada = variablePrivada;
        this.variableProtegida = variableProtegida;
    }

    // Métodos generales con implementación
    public String getVariablePublica() {
        return this.variablePublica;
    }

    // Método abstracto (sin implementación)
    protected abstract float calcularImpuesto();

    // Método estático público con implementación
    public static int getContador() {
        return contador;
    }

    // Método abstracto protegido (sin implementación)
    protected abstract double calcularInteres(double monto);

    // Método abstracto privado no es permitido en Java.
    // El siguiente método permanecerá como privado final
    private final String metodoPrivadoFinal() {
        return "Este método es privado y final.";
    }

    // Método protegido con implementación
    protected float getVariableProtegida() {
        return this.variableProtegida;
    }

    // Método estático protegido
    protected static double getTasaInteres() {
        return tasaInteres;
    }
}
</code-block>
</li> 
<li><b><format color="CornFlowerBlue">Alcance de los Contenidos</format></b>: Todo campo declarado interamente en 
una clase, bajo las normas de acceso definidas por sus modificadores, puede ser utilizada en todo el campo de la 
clase, y dependiendo de sus modificadores fuera de esta, adicionalmente.</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a sus Modificadores">
<list>
<li><b><format color="CornFlowerBlue">Modificadores de Estructura</format></b>: Una clase abstracta se declara 
usando la palabra <code>abstract seguido de class</code>, no se puede cambiar este tipo de declaración. En general, 
la estructura de modificadores y sus reglas siguen afectando a esta clase.
<br/>
Adicionalmente, una clase abstracta también puede ser parametrizada. Este es el caso general de las clases de 
estructuras de datos ya definidas dentro de Java SE. 
</li> 
<li><b><format color="CornFlowerBlue">Modificadores de Acceso en Clases</format></b>: En Java, solo aquellas <i>top 
level 
classes </i> pueden tener un modificador de acceso <code>publico</code>, toda clase secundaria, sea abstracta o 
normal, dentro del mismo archivo tiene por defecto <code>un modificador de acceso privado y no estático</code>
<br/>
Esto se muestra en el siguiente snippet de código
<br/>
<code-block lang="Java">
//... en el archivo ClasesVisibilidadEjemplo.java

package OOP_Examples;

// Clase top-level correctamente declarada como pública
public abstract class ClaseCorrectamentePublica {
// Contenido de la clase puede agregarse aquí
}

/*
* Segunda clase en el mismo archivo, esto genera una warning
* de IntelliJ, y un error de compilación al intentar modificar
* el acceso a una clase secundaria en un archivo que contiene
* una clase publica
  */
  public static abstract class ClaseConVisibilidadConflictiva {
  // Contenido de la clase puede agregarse aquí (nunca será necesario porque esto no compila)
  }

// Clase secundaria en el mismo archivo sin modificadores de acceso
// Por defecto, esta clase tendrá el modificador "package-private"
abstract class ClaseSinModificadores {
// Contenido de la clase puede agregarse aquí
}
</code-block>
</li>
<li><b><format color="CornFlowerBlue">Modificadores de Acceso en Contenidos</format></b>: 
Los contenidos de una clase abstracta deben igualmente seguir ciertas normas con respecto a sus modificadores.
<br/>
<ul>
  <li>Los métodos de una clase abstracta <b>pueden ser abstractos o concretos (con implementación)</b>.</li>
  <li>Los métodos abstractos <code>NO</code> pueden ser <code>private</code>, ni <code>final</code>, ni 
<code>static</code>,  ya que deben ser implementados en las subclases.</li>
  <li>Los métodos concretos y las variables definidos en las clases abstractas siguen las mismas normas que en 
clases normales (pudiendo ser final o static).</li>
  <li>Los constructores en clases abstractas son permitidos para inicializar miembros internos al ser extendidos por una subclase, 
pero <b>no pueden ser abstractos, finales o estáticos.</b></li>
</ul>
</li>

<li><b><format color="CornFlowerBlue">Orden de los Modificadores en Clases Abstractas</format></b>: 
El orden de los modificadores de acceso de una clase abstracta, variable o método es importante para evitar confusiones. 
<br/>
Se recomienda seguir los siguientes formatos:
<code-block lang="Markdown">
1) Para trabajar con Clases Abstractas:
    [public | protected] abstract class 
                        [Type Identifier]  [Type Parameters] 
                        [Class Extends]    [Class Implements] 
                        [Class Body] 
2) Para trabajar con Métodos Abstractos:
    [public | protected] abstract [Return Type] identifier
   [Method Parameters] [;]
3) Para trabajar con métodos o variables concretos:
   [public | protected | private | static | final]
   [Type | Return Type] identifier
   [Initialization | Method Body]
</code-block>
<br/>
</li>
</list>
</tab>
</tabs>
</procedure>
<p>Sin duda las clases abstractas en Java tienen muchas diferencias con su contraparte en C++, pero estas 
diferencias se fundamentan en la versatilidad que esta tiene a la hora de unificar comportamientos de varias clases, 
ofrecer comportamiento base que puede ser compartido, y recursos como constantes compartidas sin necesidad de tener 
un archivo externo con estas. El siguiente ejemplo completo presenta la manera de trabajar con estas directamente.
</p>

```Java

// en el archivo EjemploClasesAbstractas.java

package OOP_Examples;

// Clase abstracta base top-level 
// declarada correctamente como pública
public abstract class ClaseAbstractaBase {
    // Atributos privados: solo se acceden a traves de setters
    private String nombre;
    private int edad;

    // Constructor para inicializar atributos
    public ClaseAbstractaBase(String nombre, int edad) {
        this.setNombre(nombre);
        this.setEdad(edad);
    }

    // Métodos abstractos que deben ser implementados en subclases
    public abstract void mostrarInformacion();
    public abstract String obtenerDescripcion();

    // Métodos concretos accesibles por subclases
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) 
                throws IllegalArgumentException{
        if (nombre.length() >= 0){
            this.nombre = nombre;   
        }
        else {
           throw new 
           IllegalArgumentException(
           "El nombre no puede estar vacío," + 
           "por favor proporcione un nombre válido.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws IllegalArgumentException {
        if (edad > 0) {
            this.edad = edad;
        } else {
            throw new 
            IllegalArgumentException("Edad debe ser mayor a 0.");
        }
    }
}

//... en el archivo ClaseSecundariAbstracta.java

package OOP_Examples;

// Clase secundaria abstracta 
// que hereda de ClaseAbstractaBase
public abstract class ClaseSecundariaAbstracta 
                        extends ClaseAbstractaBase {
    // Atributo adicional
    protected double salario;

    // Constructor para inicializar atributos base y propios
    public ClaseSecundariaAbstracta(String nombre, 
                                    int edad, 
                                    double salario) {
        super(nombre, edad);
        this.salario = salario;
    }

    // Métodos abstractos adicionales
    public abstract void calcularSalario();
    public abstract double obtenerBonificacion();

    // Métodos concretos
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

//... en el archivo ImplementacionClaseConcreta.java

package OOP_Examples;
// Clase concreta que hereda de ClaseSecundariaAbstracta
// e implementa todos los métodos abstractos
class ImplementacionClaseConcreta extends ClaseSecundariaAbstracta {
    private String posicion;

    // Constructor que inicializa todos los atributos
    public ImplementacionClaseConcreta(String nombre, 
                                        int edad, 
                                        double salario, 
                                        String posicion) {
        super(nombre, edad, salario);
        this.posicion = posicion;
    }

    // Implementación de métodos abstractos de las clases base
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + 
        ", Edad: " + edad + ", Salario: " 
        + salario + ", Posición: " + posicion);
    }

    @Override
    public String obtenerDescripcion() {
        return "Empleado en la posición: " + posicion;
    }

    @Override
    public void calcularSalario() {
        // Ejemplo simple de cálculo de salario
        salario += obtenerBonificacion();
        System.out.println("Salario calculado: " + salario);
    }

    @Override
    public double obtenerBonificacion() {
        return salario * 0.1;
    }

    // Métodos concretos propios de esta clase
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    
    @Override
    public String toString() {
        return "ImplementacionClaseConcreta{" +
               "nombre='" + this.getNombre() + '\'' +
               ", edad=" + this.getEdad() +
               ", salario=" + this.salario +
               ", posicion='" + this.posicion + '\'' +
               '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ImplementacionClaseConcreta that = 
                            (ImplementacionClaseConcreta) obj;
        return Double.compare(that.salario, this.salario) == 0 &&
               this.getEdad() == that.getEdad() &&
               this.getNombre().equals(that.getNombre()) &&
               this.posicion.equals(that.posicion);
    }
}

```

### Interfaces en Java
<p> Una vez en esta sección, hemos llegado al equivalente cuasi-directo de las clases puramente abstractas de C++. En 
Java las interfaces son un tipo especial de clases, que permiten agrupar comportamientos (más no parámetros), de los 
cuales varias clases pueden implementar sus propias especificaciones, sin necesidad de que estas clases compartan un 
funcionamiento interno directo, o una relación en la jerarquía que las una completamente.
<br/>
<br/>
Una manera de visualizar esto es mediante una interface de tipo tacómetro, de un automóvil. Si bien una clase 
<code>automóvil</code>, si podría ser útil mediante una declaración abstracta para que várias clases puedan tomar su 
código y usarlo para desarrollar sobre el funcionamiento base de un auto.
<br/>
<br/>
En el caso de un tacómetro, la idea general de marcar la velocidad y medir la velocidad es independiente del tipo de 
vehículo, es decir, es un comportamiento que comparten tanto tractores como camiones como motocicletas. No es necesario 
que compartan una implementación interna base (porque no son lo mismo), pero sí pueden compartir el comportamiento 
de un tacómetro, porque lo usan de la misma manera o con pequeños detalles propios que no afectarían al resto. Si 
pensamos en las interfaces de esta manera, su utilización y existencia es muy fácil de entender, están aquí para 
ayudarnos a compartir comportamientos en nuestras clases, separando implementaciones. Son como módulos pequeños que 
se pueden enchufar a nuestras clases.
<br/>
<br/>
El siguiente listado determina las características más importantes, en el mismo estilo de los listados anteriormente 
realizados.
</p>
<procedure>
<tabs>
<tab title="Reglas Con Respecto a su Definición">
<list columns="1">
<li><b><format color="CornFlowerBlue">Definición General</format></b>: Una <i>interface</i> hace referencia a 
una plantilla o contrato que define métodos que una clase debe implementar. A diferencia de las clases abstractas,
una interfaz <code>no tiene atributos de instancias concretos ni implementaciones de métodos (en su estado puro).</code> 
Aunque, desde Java 8, pueden declarar métodos con implementación por defecto (default) y métodos estáticos.
<br/> 
El siguiente bloque de código muestra la forma en la que se declara una interfaz:
<code-block lang="Java"> 
//... en el archivo MiInterface.java
package OOP_Examples;

public interface MiInterface { 
    //... resto de implementaciones podrían ir aquí!
}
</code-block>
</li> 
<li><b><format color="CornFlowerBlue">Implementación de Interfaces</format></b>: En Java, una clase puede 
<code>implementar una o varias interfaces.</code> Todas las clases que implementan una interfaz están obligadas
a implementar todos los métodos definidos en ella (excepto los métodos <code>default</code>), salvo que la clase misma sea abstracta.
<br/>
El ejemplo siguiente muestra la manera de implementar una o varias interfaces:

```Java
//... implementando una interfaz aquí
package OOP_Examples;

public class MiClase implements MiInterface, Comparable<MiClase> {
    //... resto de implementaciones podrían ir aqui!
}
```
</li> 
<li><b><format color="CornFlowerBlue">Herencia entre Interfaces</format></b>: Una interfaz puede extender una o más interfaces en Java.
A través de la herencia de interfaces, se puede crear jerarquías donde una interfaz deriva contratos de otras, permitiendo
que las interfaces más avanzadas acumulen los prototípos de métodos de las interfaces previamente extendidas.
<br/>
El siguiente bloque muestra un ejemplo de cómo trabajar con jerarquías de interfaces:

```Java
//... en el archivo PrimeraInterface.Java
//... definiendo jerarquías de interfaces aquí
package OOP_Examples;

public interface PrimeraInterface {
    // Método abstracto 1
    void metodoAbstracto1();

    // Método abstracto 2
    public abstract void metodoAbstracto2();

    // Método predeterminado
    public default void metodoPorDefecto() {
        System.out.println(
        "Este es un método predeterminado en PrimeraInterface.");
    }
}


//... en el archivo SegundaInterface.Java
public interface SegundaInterface extends PrimeraInterface, 
                            Comparable<SegundaInterface> {
        // Método abstracto 1
    public abstract void metodoAbstracto3();

    // Método abstracto 2
    public abstract void metodoAbstracto4();

    // Nuevo método abstracto 3
    void metodoAbstracto5();

    // Nuevo método abstracto 4
    public abstract int calcularAlgo(int parametro);

}
```
</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a su Contenido">
<list>
<li><b><format color="CornFlowerBlue">Contenido de la Interfaz</format></b>: Una interfaz contiene métodos que son, por defecto, 
<code>abstractos y públicos</code>. Desde Java 8, sin embargo, también se pueden definir:
<ul>
  <li><code>Métodos con implementación predeterminada (default).</code></li>
  <li><code>Métodos estáticos y constantes (se asumen publicas, privadas y finales)  estáticas.</code></li>
</ul> 
Las interfaces no pueden incluir constructores, pues no pueden instanciarse directamente.
<br/>
El bloque siguiente muestra cómo declarar diferentes tipos de contenido dentro de una interfaz:

```Java

package OOP_Examples;

public interface CompleteInterface {

    /*
     * Se puede definir constantes de cualquier tipo
     * pero estas se asumen publicas privadas y finales
    */
    int CONSTANT_VAL = 100;

    /*
     * Declaracion general de un metodo abstracto, se
     * asume que es publico y abstracto 
    */
    void metodoAbstracto1();
    
    /*
     * Declaracion secundaria de un metodo abstracto, 
     * se incluyen todos los modificadores para lectura
     * facil
    */
    public abstract void metodoAbstracto2();

    /*
     * Declaracion de un metodo default, su implementacion se debe 
     * dar en la interface, pero puede ser sobrescrito en otra
    */
    default void metodoPorDefecto1() {
        System.out.println("Este es un método predeterminado 1.");
    }

    
    public default void metodoPorDefecto2() {
        System.out.println("Este es un método predeterminado 2.");
    }

    /*
     * Declaracion de un metodo estatico en una interface, se 
     * asume que es public y estatico 
    */
    static void metodoEstatico1() {
        System.out.println("Este es un método estático 1.");
    }

    // Static method with explicit modifiers and functionality
    public static void metodoEstatico2() {
        System.out.println("Este es un método estático 2.");
    }
}

```
</li> 
<li><b><format color="CornFlowerBlue">Alcance del Contenido</format></b>: Por defecto, cualquier método o variable 
definida en una interfaz es <code>público</code>. Las variables en las interfaces son implicitamente 
<code>static final</code>, lo que significa que actúan como constantes compartidas.
<br/>
Se recomienda siempre declarar explícitamente el alcance para facilitar la lectura.

</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a sus Modificadores">
<list>
<li><b><format color="CornFlowerBlue">Modificadores de Estructura</format></b>: Una interfaz se declara 
usando la palabra <code>interface</code> en reemplazo de <code>class</code>. 
<br/>
Si bien en este curso se analiza el uso base de interfaces, es importante destacar que pueden haber 
<code>superinterfaces, asi como interfaces internas tanto en un mismo archivo como en una misma interface o 
clase</code>.
</li> 
<li><b><format color="CornFlowerBlue">Modificadores de Acceso en Interfaces</format></b>: Las interfaces pueden 
tener un modificador de acceso <code>public</code> o no especificar modificadores (uso por defecto "package-private").
<br/>
</li>
<li><b><format color="CornFlowerBlue">Modificadores en el Contenido Interno</format></b>: 
<ul>
  <li>Los métodos en una interfaz son <b>públicos y abstractos</b> por defecto.</li>
  <li>Las variables son automáticamente <code>públicas, estáticas y finales.</code></li>
  <li>Los métodos con implementación explícita (default o static) solo son posibles desde Java 8.</li>
</ul>
</li>

<li><b><format color="CornFlowerBlue">Orden de los Modificadores en Interfaces</format></b>: 
El orden de los modificadores de un contenido en una interfaz también debe seguir las convenciones para facilitar
la lectura:
<code-block lang="Markdown">
1) Para trabajar con Interfaces:
    [public | package-private] interface [Type Identifier] 
                                      [Extends] [Interface Body]
2) Para trabajar con Métodos en las Interfaces:
    [public] [abstract | default | static] [Return Type] identifier
   [Parameters] [Method Body (si aplica)]
3) Para trabajar con Variables:
   [public] [static] [final] [Type] identifier [= value];
</code-block>
</li>
</list>
</tab>
</tabs>
</procedure>
<p>Una vez analizadas las consideraciones generales de las interfaces, es claro que nuestra analogía basada en un 
tacómetro fue muy acertado, las interfaces se usan generalmente para separar comportamientos entre clases cuya 
relación no es necesariamente clara, o en alguna jerarquía donde no es necesario definir una clase abstracta detrás 
que las unifique. 
<br/>
<br/>
El siguiente ejemplo muestra como trabajar con interfaces de una manera más compleja, esta se puede suplementar con 
los ejemplos desarrollados para el curso.</p>

```Java

//... en el archivo Tacometro.java
package OOP_Examples;

// Interfaz para la funcionalidad del tacómetro
public interface Tacometro {

    /*
     * Constante que representa el máximo de RPM 
     * que puede mostrar el tacómetro
     */
    int RPM_MAXIMAS = 9000;

    /*
     * Método para obtener el valor actual de RPM.
     */
    int obtenerRPM();

    /*
     * Método predeterminado para mostrar las RPM actuales.
     */
    default void mostrarRPM() {
        System.out.println(
        "Mostrando las revoluciones por minuto (RPM): " 
        + obtenerRPM());
    }

    /*
     * Método estático que reinicia el 
     * tacómetro a su valor predeterminado.
     */
    static void reiniciarTacometro() {
        System.out.println(
        "El tacómetro se ha restablecido a 0 revoluciones.");
    }
}

//... en el archivo SistemaABS.java
package vehiculos;

// Interfaz para el sistema de frenos antibloqueo (ABS)
public interface SistemaABS {

    /*
     * Constante para indicar la presión 
     * máxima permitida en el sistema ABS.
     */
    int PRESION_MAXIMA_FRENOS = 100;

    /*
     * Método para activar el sistema ABS manualmente.
     */
    void activarABS();

    /*
     * Método para desactivar el sistema ABS manualmente.
     */
    void desactivarABS();

    /*
     * Método predeterminado para verificar
     * el estado del sistema ABS.
     */
    default void verificarEstadoABS() {
        System.out.println(
        "El sistema ABS está funcionando correctamente.");
    }

    /*
     * Método estático para realizar una 
     * verificación de seguridad en el sistema ABS.
     */
    static void realizarVerificacionSeguridad() {
        System.out.println(
        "Se ha realizado una verificación de seguridad" 
        + " en el sistema ABS.");
    }
}

//... en el archivo Vehiculo.java
package vehiculos;

// Interfaz que combina las funcionalidades del Tacómetro 
// y el Sistema ABS
public interface Vehiculo extends Tacometro, SistemaABS {

    /*
     * Constante que representa la velocidad 
     * máxima predeterminada de un vehículo.
     */
    public static final int VELOCIDAD_MAXIMA = 200;

    /*
     * Método abstracto para iniciar el vehículo.
     */
    void iniciarVehiculo();

    /*
     * Método abstracto para detener el vehículo.
     */
    void detenerVehiculo();

    /*
     * Método predeterminado para mostrar 
     * información básica del vehículo.
     */
    default void mostrarInformacionVehiculo() {
        System.out.println("Velocidad máxima del vehículo: " 
        + VELOCIDAD_MAXIMA + " km/h");
        mostrarRPM();
        verificarEstadoABS();
    }

    /*
     * Método estático para mostrar los 
     * detalles del fabricante del vehículo.
     */
    static void mostrarDetallesFabricante() {
        System.out.println(
        "Fabricante del vehículo: eVolvLabs Automobile S.A.");
    }
}

//... en el archivo Auto.java

package vehiculos;

// Una clase que implementa la interfaz Vehiculo
public class Auto implements Vehiculo {

    private int rpmActual;
    private boolean absActivo;

    // Constructor para Auto
    public Auto() {
        // Inicializar RPM a 0
        this.rpmActual = 0;
        // El sistema ABS está 
        // inicialmente desactivado
        this.absActivo = false; 
    }

    /*
     * Implementación del método abstracto 
     * de Tacómetro para obtener las RPM actuales.
     */
    @Override
    public int obtenerRPM() {
        return rpmActual;
    }

    /*
     * Método para establecer el 
     * valor de las RPM del vehículo.
     */
    public void establecerRPM(int rpm) {
        if (rpm <= RPM_MAXIMAS) {
            this.rpmActual = rpm;
        } else {
            System.out.println(
            "RPM exceden el máximo permitido." 
            + " Estableciendo al límite: " + RPM_MAXIMAS);
            this.rpmActual = RPM_MAXIMAS;
        }
    }

    /*
     * Implementación del método 
     * para activar el sistema ABS.
     */
    @Override
    public void activarABS() {
        this.absActivo = true;
        System.out.println("Sistema ABS activado.");
    }

    /*
     * Implementación del método
     * para desactivar el sistema ABS.
     */
    @Override
    public void desactivarABS() {
        this.absActivo = false;
        System.out.println("Sistema ABS desactivado.");
    }

    /*
     * Implementación del método 
     * para iniciar el vehículo.
     */
    @Override
    public void iniciarVehiculo() {
        System.out.println("El vehículo está arrancando...");
        // RPM predeterminadas al arrancar el vehículo
        this.establecerRPM(1000); 
    }

    /*
     * Implementación del método 
     * para detener el vehículo.
     */
    @Override
    public void detenerVehiculo() {
        System.out.println("El vehículo se está deteniendo...");
        // Las RPM bajan a 0 al detener el vehículo
        this.establecerRPM(0); 
        desactivarABS();
    }
    
    
    /*
     * Método toString para mostrar información
     * detallada del objeto Auto.
     */
    @Override
    public String toString() {
        return "Auto{" +
               "rpmActual=" + this.rpmActual +
               ", absActivo=" + this.absActivo +
               '}';
    }

    /*
     * Método equals para comparar dos 
     * objetos Auto basándose en sus atributos.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Auto auto = (Auto) obj;
        return this.rpmActual == auto.rpmActual &&
               this.absActivo == auto.absActivo;
    }
}
```

#### Interfaces Funcionales en Java
<p>Adicional a las interfaces generales en Java, las interfaces funcionales sirven como un nivel adicional de 
especificación a la hora de diseñar nuestras aplicaciones. Las interfaces funcionales son aquellas 
<code>interfaces en donde un solo método forma parte del cuerpo de la interface</code>. Este método es usualmente 
abstracto y requiere una implementación directa por parte del usuario.
<br/><br/>
Hasta este punto, hemos tratado a <code>Comparable y Comparator</code>, como si hubiesen sido partes implícitas del 
diseño de clases en Java, como si fueran simplemente otras clases, pero anteriormente, dentro de la exploración de 
las interfaces en Java notamos que <code>ambas son interfaces funcionales de Java</code>
<br/><br/>
Comparable y Comparator son dos de las más importantes interfaces funcionales que se usan en Java para trabajar con 
instancias de objetos y en general con clases que formen parte de una jerarquía OOP. Por esta razón, conviene 
revisar ambas en cierto detalle, exponiendo algunas de sus definiciones primordiales.
</p>

##### Interface Comparable
<p>La interface Comparable es la base del ordenamiento de objetos en Java, tanto usando métodos preestablecidos, como 
en los inicios del ordenamiento y la jerarquización de objetos mediante sus características. <code>Comparable 
define el orden natural de una clase, comportamiento que indica la manera en la que estas se orden con respecto 
a instancias de la misma clase en un contexto jerarquizado</code>. 
<br/>
<br/>
En este sentido, la implementación de la clase <code>Comparable</code>, significa que nuestra clase tendrá una 
manera de usarse en mecanismos de ordenamiento dispuestos en Java, como son <code>Collections.sort() o Arrays.sort() 
</code>. El siguiente listado indica algunas de sus características más importantes
</p>
<procedure>
<list>
<li><b><format color="CornFlowerBlue">Definición</format></b>: La interfaz Comparable se utiliza para definir un método de comparación natural entre objetos de la misma clase.</li>
<li><b><format color="CornFlowerBlue">Método principal</format></b>: Contiene el método abstracto `compareTo()`, que es implementado para especificar cómo deben compararse los objetos.</li>
<li><b><format color="CornFlowerBlue">Ordenamiento</format></b>: Facilita el ordenamiento de colecciones y arreglos de objetos al definir un orden natural.</li>
<li><b><format color="CornFlowerBlue">Restricción</format></b>: Solo permite comparación entre objetos de la misma clase, lo que asegura consistencia y evita errores al realizar comparaciones.</li>
</list>
</procedure>
<p>Un ejemplo de implementación para esta clase se da en el siguiente snippet de código (nótese que esta clase se ha 
usado en la mayoría de los ejemplos previos, ya que es un requerimiento mínimo de las clases en Java).
</p>

```Java

//... en el archivo Persona.java

// Ejemplo de implementación de la interface 
// Comparable en una clase básica
package OOP_Examples;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Getter para edad
    public int getEdad() {
        return edad;
    }

    // Sobrescritura del método toString
    @Override
    public String toString() {
        return "Persona{" +
               "nombre='" + this.nombre + '\'' +
               ", edad=" +  this.edad +
               '}';
    }

    // Sobrescritura del método equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Persona persona = (Persona) obj;
        return (this.edad == persona.edad ) && 
        (this.nombre.equals(persona.nombre);)
    }

    // Sobrescritura del método compareTo 
    // para implementar la interface Comparable
    @Override
    public int compareTo(Persona otra) {
        // Comparación por edad
        return Integer.compare(this.edad, otra.edad);
    }
}

```
<p><format color="OrangeRed">OJO:</format> Al usar Comparable, la clase se limita a <b>un solo criterio de 
comparación y ordenamiento</b>, si se quiere tener criterios adicionales o más complejos se debe usar la interface 
Comparator adicional a Comparable </p>

##### Interface Comparator
<p>La segunda interface funcional clave que se va a estudiar en esta sección, es <code>Comparator</code>, cuyo 
mecanismo de trabajo se asemeja a una función amiga de C++, pudiendo utilizar dos instancias de la misma clase para 
realizar su comparativa. Comparator, se utiliza cuando el criterio de ordenamiento o jerarquización es adicional al 
que se utiliza en el orden natural.
<br/><br/>
Por este motivo, se la utiliza en <code>Collections.sort y Arrays.sort</code>, como un método sobrecargado que 
permite ingresar una instancia de un Comparator, para ser usado durante el ordenamiento.<br/><br/>
Uno de los beneficios claves de esta interface es su funcionamiento como función amiga, al requerir dos instancias 
de la misma clase para funcionar, es mucho más fácil programar un comparador como una clase <code>externa a 
la definición de la clase base original</code>. Es decir, <code>una clase Comparator puede ser implementada 
en su propio archivo, facilitando el reúso de código, y la comparmentalización del mismo</code>
<br/><br/>
El presente listado muestra cuatro de sus características primordiales.
</p>
<procedure>
<list>
<li><b><format color="CornFlowerBlue">Definición</format></b>: La interfaz Comparator se utiliza para definir una 
forma de comparación personalizada entre dos objetos o bajo distintos criterios.</li>
<li><b><format color="CornFlowerBlue">Método principal</format></b>: Contiene el método abstracto `compare()`, que 
permite implementar la lógica de comparación específica entre dos objetos.</li>

<li><b><format color="CornFlowerBlue">Flexibilidad</format></b>: Permite definir múltiples reglas de ordenamiento 
sin modificar las clases de los objetos que se están comparando.</li>

<li><b><format color="CornFlowerBlue">Uso en colecciones</format></b>: Es especialmente útil para ordenar 
colecciones usando criterios diferentes al orden natural.</li>
</list>
</procedure>
<p>Este snippet de código les mostrará como implementarlo dentro de una clase, y un archivo adicional</p>

```Java

//... en el archivo Persona.java
package OOP_Examples;

import java.util.Comparator;

//! En este ejemplo, le enchufamos Comparator a la declaracion
//! original
public class Persona implements 
                        Comparable<Persona>, Comparator<Persona> {
      /*
      * El resto del codigo implementado en el snippet anterior 
      * se omite, pero se puede asumir que es en la misma i
      * implementacion
      */
      
    //! Implementacion de un Comparator dentro de una clase existente
    //! Este revisa la edad                 
    @Override
    public int compare(Persona o1, Persona o2) {
        return Integer.compare(o1.getEdad(), o2.getEdad());
    }
                        
 }
    


//... en el archivo PersonaEdadComparator
package OOP_Examples;

import java.util.Comparator;

public class NombreLengthComparator 
            implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return Integer.compare(p1.getNombre().length(), 
                                p2.getNombre().length());
    }
}

//... en el archivo PersonaEdadComparator.java 
// Nueva clase que implementa únicamente un 
//Comparator para comparar por edad
package OOP_Examples;

import java.util.Comparator;

public class PersonaEdadComparator 
                    implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return Integer.compare(p1.getEdad(), p2.getEdad());
    }
}

```



### Records en Java
<p>Adicional a los tipos de clases que hemos estudiado, que seguramente serán los que más usen durante sus cursos de 
estructuras de datos, o en Java generalmente. Existen dos tipos de clases adicionales, una de ellas relativamente 
nueva, que se han 
incorporado al panorama OOP en Java, estas son <code>Records y Enumeraciones</code>. 
<br/>
<br/>
Los Records, son un tipo de clase distinta, orientada directamente a la programación orientada a los datos, más que 
a objetos. Estas son clases, <code>cuyos parámetros internos tienen una estructura de privados y finales</code>, lo 
que vuelve su modificación desde terceros o por nuestro código cuasi imposible.
<br/>
<br/>
Si bien no se los ve dentro de un marco de OOP general, en el material del curso existen ejemplos que revisaremos al 
respecto, y en esta sección, se exponen algunas de sus características definitorias.
</p>
<procedure>
<tabs>
<tab title="Reglas Con Respecto a su Definición">
<list columns="1">
<li><b><format color="CornFlowerBlue">Definición General</format></b>: Un <i>record</i> en Java es una clase 
especial introducida en Java 14 (como vista previa) y formalizada en Java 16, cuyo propósito principal es modelar de 
manera concisa datos inmutables. Al declarar un record, el lenguaje automáticamente genera implementaciones estándar 
como el constructor, <code>getters</code>, <code>toString()</code>, <code>equals()</code> y <code>hashCode()</code>. 
<br/> 
El siguiente bloque de código muestra la forma en la que se declara un record:
<code-block lang="Java"> 
//... en el archivo MiRecord.java
package OOP_Examples;

// Declaración de un record
public record MiRecord(String campo1, int campo2) {
//... resto de implementaciones pueden ir aquí!
}
</code-block>
</li> 
<li><b><format color="CornFlowerBlue">Implementación de Records</format></b>: Un record se utiliza para representar 
datos inmutables y <code>no puede extender una clase (ya que hereda implícitamente de java.lang.Record)</code>. Sin 
embargo, puede implementar interfaces si es necesario. 
<br/>
El siguiente ejemplo muestra cómo implementar interfaces con un record:

```Java
//... en el archivo ExampleRecord.java

package OOP_Examples;

// Declaración de un record que implementa Comparable y Comparator
public record ExampleRecord(String campo1, int campo2) 
        implements Comparable<ExampleRecord>, 
                    Comparator<ExampleRecord> {
    // El resto de las implementaciones pueden ir aquí!
}
```
</li> 
<li><b><format color="CornFlowerBlue">Herencia y Composición con Records</format></b>: Dado que los records son finales,
no pueden extenderse por otras clases o records. En cambio, los records promueven el uso de la composición. Esto 
significa que se pueden incluir otros objetos como campos, pero preservando su inmutabilidad.
<br/>
El siguiente bloque muestra cómo trabajar con composición dentro de un record:

```Java
//... en el archivo CompRecord.java
package OOP_Examples;

// Ejemplo de composición
public record CompRecord(ExampleRecord record, String otroCampo) {
//... resto de implementaciones pueden ir aquí
}
```
</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a su Contenido">
<list>
<li><b><format color="CornFlowerBlue">Contenido del Record</format></b>: Un record incluye automáticamente lo siguiente:
<ul>
  <li><code>Campos inmutables</code> definidos en la cabecera del record.</li>
  <li><code>Constructor compacto</code> y la opción de personalizarlo.</li>
  <li>Declaraciones explícitas de <code>métodos adicionales</code>, aunque deben respetar la inmutabilidad.</li>
</ul> 
Un record no puede incluir:
<ul>
  <li>Campos de instancia adicionales (deben ser parte de la definición inicial).
        Estos solo pueden existir si son <format style="bold">públicos, estáticos y finales</format>
</li>
  <li>Constructores adicionales sin el uso de la inicialización completa.</li>
</ul>
<br/>
El bloque siguiente muestra cómo declarar contenido dentro de un record:

```Java

package OOP_Examples;

// Ejemplo de un record con contenido adicional
public record AdvancedRecord(String campo1, int campo2) {

    // Método adicional
    public int metodoExtra() {
        return campo2 * 2;
    }

    // Constructor compacto
    public AdvancedRecord {
        if (campo2 < 0) {
            throw new 
                IllegalArgumentException("campo2 debe ser positivo");
        }
    }
    
    // Constructor Completo
    /*
     * Los campos internos se generan con el nombre declarado
     * al inicio del Record, por tanto se accede esta manera
     * y declara con el mismo nombre en el constructor
    public AdvancedRecord(String campo1, int campo2){
        this.campo1 = campo1;
        this.campo2 = campo2;
    
    }

    // Sobrescritura de un método generado automáticamente
    @Override
    public String toString() {
        return "AdvancedRecord[campo1=" + campo1 
        + ", campo2=" + campo2 + "]";
    }
}

```
</li> 
<li><b><format color="CornFlowerBlue">Alcance del Contenido</format></b>: Por defecto, los campos definidos en un 
record son privados y finales. Se generan automáticamente métodos <code>getter</code> públicos con el mismo nombre 
de los campos. Además, las clases record no permiten modificar el valor de los campos después de la creación del objeto (inmutabilidad).
<br/>
Se recomienda usar records únicamente para datos que no necesiten un comportamiento mutable.

</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a sus Modificadores">
<list>
<li><b><format color="CornFlowerBlue">Modificadores de Estructura</format></b>: Un record se declara utilizando la palabra clave <code>record</code> en lugar de <code>class</code>. 
<br/>
Los records son finales por diseño, lo que significa que no pueden extenderse, y todos sus campos también son finales. Igualmente, los métodos generados automáticamente (como <code>toString()</code>) son considerados definitivos.
</li> 
<li><b><format color="CornFlowerBlue">Modificadores de Acceso en Records</format></b>: Los records pueden declararse como <code>public</code> o tener el modificador por defecto paquete (<i>package-private</i>). 
Los campos internos de un record son siempre privados y finales, sin importar cómo se declaren.
<br/>
</li>
<li><b><format color="CornFlowerBlue">Modificadores en el Contenido Interno</format></b>: 
<ul>
  <li>Los campos son implícitamente <b>privados y finales</b>.</li>
  <li>Los <code>métodos generados</code> como getters, <code>toString()</code>, <code>equals()</code>, y <code>hashCode()</code> son implícitamente <code>públicos</code> y no deben ser redefinidos sin un motivo claro.</li>
  <li>Los métodos personalizados deben respetar la inmutabilidad de los campos.</li>
</ul>
</li>

<li><b><format color="CornFlowerBlue">Orden de los Modificadores en Records</format></b>: 
El orden de los modificadores en un record sigue las siguientes convenciones para facilitar la lectura:
<code-block lang="Markdown">
1) Para trabajar con Records:
    [public | package-private] record [Type Identifier] 
                                      [Implements] [Record Body]
2) Para trabajar con Métodos en los Records:
   [public | private] [Return Type] identifier
                                   [Parameters] [Method Body]
3) Para trabajar con Constructores:
   public [Type Identifier] [Parameters] {
   // Validaciones u operaciones adicionales
   }
</code-block>
</li>
</list>
</tab>
</tabs>
</procedure>


### Enumerations en Java
<p>El último tipo de dato especial que debemos tener en cuenta a la hora de trabajar con un formato de programación 
orientada a objetos son las enumeraciones. Las enumeraciones son un tipo de archivo que nos permite definir nombres 
significativos que envuelven un orden cardinal cuyo uso nos puede servir para identificar constantes en bajo un 
nombre significativo para usar dentro de un switch, etc.
<br/>
<br/>
Las enumeraciones se pueden usar, adicionalmente, con varios campos y métodos internos, permitiendo, mediante un 
<code>constructor</code>, incluir diversos factores internos que pueden ayudarnos a darles mayor utilidad que solo 
un orden cardinal y una separación de namespaces. Por ejemplo, una enumeración se puede usar para determinar 
mediante nombres horas del día para una aplicación que requiera guardar eventos, o definir con una String interna 
para definir eventos rápidos en una aplicación que registre eventos o todos. 
<br/>
<br/>
Las capacidades de las enumeraciones de ampliarse mediante métodos, constructores, y parámetros internos, sin duda 
les dan un amplio espectro de aplicabilidad a la hora de desarrollar aplicaciones donde algunos namespaces, o 
constantes requieran ser compartidas y usadas con un nombre significativo para el programador o para el usuario.
<br/><br/>
El siguiente recuadro, muestra una serie de características relevantes de las enumeraciones en Java.
</p>
<procedure>
<tabs>
<tab title="Reglas Con Respecto a su Definición">
<list columns="1">
<li><b><format color="CornFlowerBlue">Definición General</format></b>: Una <i>enumeración</i> en Java es un tipo 
especial de clase introducida en Java 5 que representa un conjunto fijo y predefinido de constantes. Cada constante 
en una enumeración es una instancia única de la enumeración definida. Las enumeraciones son útiles para representar 
datos constantes y predefinidos de manera segura, debido a su fuerte tipado.
<br/>
El siguiente bloque de código muestra la forma en la que se declara una enumeración:
<code-block lang="Java"> 
//... en el archivo MiEnum.java
package OOP_Examples;

// Declaración de una enumeración
public enum MiEnum {
CONST1, CONST2, CONST3;
//... resto de implementaciones pueden ir aquí!
}
</code-block>
</li> 
<li><b><format color="CornFlowerBlue">Implementación de Enumeraciones</format></b>: Las enumeraciones pueden implementar interfaces, pero no pueden extender otras clases debido a que ya extienden implícitamente <code>java.lang.Enum</code>. Además, pueden incluir métodos y constructores personalizados, pero no permiten crear nuevas instancias fuera de las constantes predefinidas.
<br/>
El siguiente ejemplo muestra cómo implementar interfaces en una enumeración:

```Java
//... en el archivo ExampleEnum.java

package OOP_Examples;

// Declaración de una enumeración que implementa una interfaz
public enum ExampleEnum implements SomeInterface {
    CONST1, CONST2, CONST3;

    // Definición de métodos adicionales o 
    // implementación de la interfaz
    @Override
    public void someMethod() {
        System.out.println("Método de la interfaz implementado");
    }
}
```
</li> 
<li><b><format color="CornFlowerBlue">Herencia y Composición con Enumeraciones</format></b>: Dado que las enumeraciones ya extienden implícitamente <code>java.lang.Enum</code>, no se pueden extender otras clases. Sin embargo, las enumeraciones permiten la composición agregando otros objetos como atributos y personalizando comportamientos para cada constante.
<br/>
El siguiente bloque muestra cómo trabajar con composición dentro de una enumeración:

```Java

//... en el archivo CompEnum.java
package OOP_Examples;

// Ejemplo de enumeración con composición de objetos
public enum CompEnum {
    /*
     * Aquellas declaraciones de constantes en un enum
     * si son mas que una, deben ser declaradas con una
     * coma al final. Solo la última instancia tiene un
     * punto y coma al final
    */
    
    CONST1(new SomeClass()), 
    CONST2(new SomeClass()), 
    CONST3(new SomeClass());

    /*
     * Los parámetros dentro de una enumeracion no tienen
     * requerimientos de modificadores de acceso, este es
     * simplemente un ejemplo con un modificador private 
     * y un final.
    */
    private final SomeClass attribute;

    /*
     * Esta es la implementacion de un constructor en una 
     * enumeracion. Esta puede ser declarada como privada 
     * ya que solo sera utilizado internamente
    */
    CompEnum(SomeClass attribute) {
        this.attribute = attribute;
    }

    public SomeClass getAttribute() {
        return attribute;
    }
}
```
</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a su Contenido">
<list>
<li><b><format color="CornFlowerBlue">Contenido de la Enumeración</format></b>: Una enumeración en Java puede incluir lo siguiente:
<ul>
  <li><code>Constantes predefinidas</code> que son las instancias únicas de la enumeración.</li>
  <li><code>Atributos y métodos</code> personalizados, permitiendo asignar y operar sobre datos específicos de cada constante.</li>
  <li><code>Constructores</code>, que son siempre privados o con acceso por defecto. Se utilizan para inicializar atributos de las constantes.</li>
</ul> 
Una enumeración no puede incluir:
<ul>
  <li>Instancias en tiempo de ejecución distintas a las definidas como constantes en su declaración.</li>
</ul>
<br/>
El bloque siguiente muestra cómo declarar contenido dentro de una enumeración:

```Java
//... en el archivo AdvancedEnum.java

package OOP_Examples;

// Ejemplo de una enumeración con contenido adicional
public enum AdvancedEnum {
    CONST1("Valor 1", 10), CONST2("Valor 2", 20);

    // Atributos
    private final String description;
    private final int value;

    // Constructor privado
    private AdvancedEnum(String description, int value) {
        this.description = description;
        this.value = value;
    }

    // Métodos adicionales
    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }
}

```
</li> 
<li><b><format color="CornFlowerBlue">Alcance del Contenido</format></b>: Por defecto, las constantes definidas en una enumeración tienen acceso público. Los atributos y métodos personalizados pueden tener diferentes niveles de acceso según las necesidades de la implementación. 
<br/>
Se recomienda usar enumeraciones para datos constantes que pertenecen a un conjunto finito y predecible, como días de la semana, estados de un proceso, etc.

</li> 
</list>
</tab>
<tab title="Reglas Con Respecto a sus Modificadores">
<list>
<li><b><format color="CornFlowerBlue">Modificadores de Estructura</format></b>: Una enumeración se define utilizando la palabra clave <code>enum</code> en lugar de <code>class</code>. 
<br/>
Las enumeraciones son finales por naturaleza, lo que significa que no pueden extenderse. Además, heredan implícitamente de <code>java.lang.Enum</code>, lo que garantiza un conjunto predefinido de comportamientos.
</li> 
<li><b><format color="CornFlowerBlue">Modificadores de Acceso en Enumeraciones</format></b>: Las enumeraciones pueden declararse como <code>public</code>, <code>package-private</code> o incluso dentro de otras clases como <i>nested classes</i>. 
<br/>
</li>
<li><b><format color="CornFlowerBlue">Modificadores en el Contenido Interno</format></b>: 
<ul>
  <li>Las constantes son implícitamente públicas, estáticas y finales.</li>
  <li>Los atributos pueden ser privados o protegidos, y deben ser inicializados en las constantes mediante constructores.</li>
  <li>Los métodos implementados pueden ser públicos o privados según su función.</li>
</ul>
</li>

<li><b><format color="CornFlowerBlue">Orden de los Modificadores en Enumeraciones</format></b>: 
El orden de los modificadores en una enumeración sigue las siguientes convenciones para facilitar la lectura:
<code-block lang="Markdown">
1) Para trabajar con Enumeraciones:
    [public | package-private] enum [Type Identifier] 
                                     [Implements] [Enum Body]
2) Para trabajar con Métodos en las Enumeraciones:
   [public | private | protected] [Return Type] identifier
   [Parameters] [Method Body]
3) Para trabajar con Constantes o Atributos:
   public static final [Type] identifier [= value];
</code-block>
</li>
</list>
</tab>
</tabs>
</procedure>
<p>Ejemplos de este tipo de estructuras se presentan en el código del curso, por lo que sus ejemplos no se añaden a 
los de esta página.
<br/>
<br/>
Este es el final de nuestra discusión de los tipos de datos de OOP en Java, hemos revisado varios conceptos como 
fundamentos, tipos de clases y estructuras, sus reglas y propósitos, etc. Aunque no ha sido un recorrido corto, 
todavía tenemos tela que cortar. Las siguientes secciones se encargarán de ampliar sobre <code>Inner, 
anonymous classes y expresiones Lambda, asi como genéricos.</code></p>
