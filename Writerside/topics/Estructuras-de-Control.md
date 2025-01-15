# Java Base - Estructuras de Control



> Conociendo los tipos de dato clave en Java, estamos preparados como para adentrarnos en los inicios de la 
> programación, con loops, con condicionales, trabajaremos en analizar cada una de estas estructuras y su formato para 
> implementar programas sencillos, pero ilustrativos que demuestren los conceptos de estructuras de control de flujo 
> y lógicas.

<p>Al igual que en C++ en Java existen algunos tipos de estructuras de control, tanto lógicas como de flujo que nos 
permiten organizar nuestro programa, realizar iteraciones, bucles de código e inclusive manejar una interacción 
basica con el usuario. Estas estructuras, en sus grupos tienen ahora varias formas de declararse a diferencia de 
aquellas definidas en C++ como la base, pero en realidad la mayoría de las estructuras que se encuentran en C++ se 
pueden replicar en Java con ajustes mínimos.
<br/><br/>
Para estudiar esta sección, he incluido algunos ejemplos de implementación y detalles importantes que se han ido 
incorporando al lenguaje y que me han parecido importantes para el curriculum de este curso</p>

## Estructuras de Control de Flujo
<p>Las estructuras de control de flujo son aquellas que le permiten al programa controlar la manera en la que el 
usuario accede a este, controlando inputs con base en iteraciones, controlando repeticiones de código, repeticiones de 
menu, etc. Estas estructuras están diseñadas para controlar la manera en la que el programa se ejecuta y la manera 
en la que diversos controles de repetición se ejecutan. En este grupo tenemos cuatro miembros 
<code>Iteration-Based For Loop, Range-Based For (forEach) Loop, While Loop, Do-While Loop</code>
</p>

### Iteration-Based For Loop
<p>La forma más básica de un for loop que se estudia en C++ y que se replica en Java, recordemos que Java tomo 
varias partes de C++ que fueron útiles y las implemento <i>as-is</i>. Entre estas estructuras se encontraba este 
tipo de for loops, en las cuales el único cambio significativo es la falta de un equivalente al 
<code>std::size_t</code> que usualmente se toma como tipo de dato dentro de las variables contadoras en un for 
loop de C++. 
<br/><br/>
En cualquier otro aspecto es idéntico al for loop de C++, por tanto, se establecen algunos ejemplos de este a 
continuación.
</p>
<procedure>
<tabs>
<tab title="For Loop Base I">

```Java
package example;

public class example{

    public static void main(String[] args){
        //! Declaremos un For-Loop que imprima  
        // un cuadrado en pantalla
        for(int i = 0 /*Variable Contadora*/;
            i < 5     /*condición*/;
            i++       /*Incremento*/)
        {
            for(int j = 0; j < 5; j++) { 
                System.out.print("*");
            }
            System.out.println(); 
        }
    }
}
```
<p>La corrida de este código da como resultado un cuadrado de altura cinco lleno de asteriscos</p>
<code-block lang="Markdown">
*****
*****
*****
*****
*****

Process finished with exit code 0
</code-block>
</tab>
<tab title="For Loop Base II">

```Java
package example;

public class example {

    public static void main(String[] args) {
        //! Declaremos un For-Loop que imprima un cuadrado en pantalla
        int i = 0; // Variable Contadora
        for( /* Condición del loop */; 
             i < 5; /* Condición */) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
            i++; // Incremento
        }
    }

}
```
<p>La corrida de este código imprime lo siguiente en consola</p>

<code-block lang="Markdown">
*****
*****
*****
*****
*****

Process finished with exit code 0
</code-block>
</tab>
<tab title="For Loop Base III">

```Java
package example;

public class example {

    public static void main(String[] args){
        System.out.println("           Tabla De Multiplicar");
    
        System.out.print("    ");
        for (int j = 1; j <= 9; j++)
          System.out.print("   " + j);
    
        System.out.println(
        "\n-----------------------------------------");
    
        for (int i = 1; i <= 9; i++) {
          System.out.print(i + " | ");
          for (int j = 1; j <= 9; j++) {
            System.out.printf("%4d", i * j);
          }
          System.out.println();
        }
    }
}
```
<p>La corrida de este código imprime lo siguiente en consola</p>

<code-block lang="Markdown">
           Tabla De Multiplicar
       1   2   3   4   5   6   7   8   9
-----------------------------------------
1 |    1   2   3   4   5   6   7   8   9
2 |    2   4   6   8  10  12  14  16  18
3 |    3   6   9  12  15  18  21  24  27
4 |    4   8  12  16  20  24  28  32  36
5 |    5  10  15  20  25  30  35  40  45
6 |    6  12  18  24  30  36  42  48  54
7 |    7  14  21  28  35  42  49  56  63
8 |    8  16  24  32  40  48  56  64  72
9 |    9  18  27  36  45  54  63  72  81

Process finished with exit code 0

</code-block>
</tab>
</tabs>
</procedure>
<p>Como podemos ver la manera de trabajar con un for loop de este estilo es idéntica a la de C++, no hay variaciones 
en la declaración de variables internas, es más sigue la misma norma de poder utilizar variables declaradas fuera 
del loop dentro de este. Los mismos entornos de las variables con lo que hemos trabajado en C++ se mantiene, siendo 
este que variables dentro de un for loop o nested for loops no pueden ser usadas fuera de este scope, mientras que 
variables dentro de un bloque for loop si pueden ser usadas dentro de este y sus nested for loops. 
</p>

### Range-Based For (forEach) Loop
<p>Esta version de los for loops incurre en un proceso muy diferente a comparación de lo que se trabaja en C++. En 
Java, las colecciones de datos como arreglos, listas, mapas, etc. (Los temas que van a ver en su clase de estructura 
de datos!) tienen un componente adicional, un patron de diseño llamado Iterator, es el mismo concepto de los 
iteradores de C++ solo que estos se esconden en este tipo de loops.
<br/><br/>
En Java, el patron de diseño del Iterator es forzado en cada implementación de una estructura de datos, por tanto, la 
mayoría de estas, sin modificación alguna o código extra permiten ser transversadas a través de un range-based for.
<br/><br/>
A continuación se establecen ejemplos con base en arreglos de datos.
</p>
<procedure>
<tabs>
<tab title="Range-Based For Loop I">

```Java
package example;

public class example{
    private static Integer[] numbers = {0,1,2,3,4,5,6,7,8,9,10};
    private static Integer[][] numberMatrix = {
            {0,1,2,3,4},
            {5,6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20}};
    
    public static void main(String[] args){
        //! Range based For Para numbers
        /*Oscurece el iterador*/
        System.out.print("{");
        for(Integer /*Tipo de dato del contenido
                    del iterador*/
                number /*Nombre de la variable temporal*/
                :
                numbers /*Contenedor de Datos*/){

            System.out.print(number + " ,");
        }
        System.out.print("\b" + "}");

        //! Range based for Para numberMatrix
        System.out.println();
        System.out.println();
        for(Integer[] row: numberMatrix){
            System.out.print("{");
            for(int number: row){
                System.out.print(number + ", ");
            }
            System.out.print("\b" + "}\n");
        }

    }
}
```
<p>Al ejecutar este código se obtiene el siguiente output.</p>
<code-block lang="Markdown">
{0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 }

{0, 1, 2, 3, 4,}
{5, 6, 7, 8, 9, 10,}
{11, 12, 13, 14, 15,}
{16, 17, 18, 19, 20,}

Process finished with exit code 0
</code-block>
</tab>
<tab title="Range-Based For Loop II">

```Java
package example;

public class example {
private static String[] colors = {"Red", "Blue", 
                             "Green", "Yellow"};
private static String[][] categorizedColors = {
        {"Red", "Yellow"},
        {"Blue", "Green"}};

    public static void main(String[] args) {
        //! Range-based For para colors
        System.out.print("[");
        for (String color : colors) {
            System.out.print(color + ", ");
        }
        System.out.print("\b\b]");
        
        //! Range-based For para categorizedColors
        System.out.println();
        System.out.println();
        for (String[] category : categorizedColors) {
            System.out.print("[");
            for (String color : category) {
                System.out.print(color + ", ");
            }
            System.out.print("\b\b]\n");
        }
    }

}
```
<p>Al correr este código se obtiene el siguiente resultado.</p>
<code-block lang="Markdown">
[Red, Blue, Green, Yellow]

[Red, Yellow]
[Blue, Green]

Process finished with exit code 0
</code-block>
</tab>
<tab title="Range-Based For Loop III">

```Java
package example;

import java.util.ArrayList;
import java.util.Stack;

public class example {

    private static String[] colors = {"Red", "Blue",
            "Green", "Yellow"};
    private static String[][] categorizedColors = {
            {"Red", "Yellow"},
            {"Blue", "Green"}};

    public static void main(String[] args) {
        //! ArrayList Example
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");

        System.out.print(
        "Impresion del ArrayList en Orden"+
        " usando Range-Based For Loops : ");
        System.out.print("[");
        for (String name : names) {
            System.out.print(name + ", ");
        }
        System.out.print("\b\b]\n");

        //! Stack Example
        Stack<Integer> numbers = new Stack<>();
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        numbers.push(40);

        System.out.print("Impresion del Stack en Orden usando"+
        " Range-Based For Loops : ");
        System.out.print("[");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
        System.out.print("\b\b]\n");

        System.out.print("Impresion del Stack en Orden usando"+
        " Iteration-Based For Loops: ");
        int stackSize = numbers.size();
        System.out.print("[");
        for (int i = stackSize - 1; i >= 0; i--) {
            System.out.print(numbers.pop() + (i > 0 ? ", " : ""));
        }
        System.out.print("]\n");
        
        
    }

}
```
<p>Al correr este código se obtiene el siguiente resultado.</p>
<code-block lang="Markdown">
Impresion del ArrayList en Orden usando Range-Based For Loops : 
[Alice, Bob, Charlie, Diana]
Impresion del Stack en Orden usando Range-Based For Loops : 
[10, 20, 30, 40]
Impresion del Stack en Orden usando Iteration-Based For Loops: 
[40, 30, 20, 10]

Process finished with exit code 0
</code-block>
</tab>
</tabs>
</procedure>

### While Loop
<p>Esta es otra estructura cuya implementación en general fue obtenida de C++ y cuyos ejemplos e implementaciones se 
pueden hasta replicar en Java. Las while loops en Java no dejan de ser útiles para un control de iteraciones de estilo check-first, lo que significa que en algunos casos su ejecución puede reducirse a cero o más iteraciones, dependiendo de la condición establecida.
<br/><br/>
En este sentido, la utilidad más clara de los while loops es el control fino de iteraciones a la par de los for loops, teniendo en cuenta que su flexibilidad permite manejar condiciones más complejas y dinámicas. A diferencia de los for loops, que generalmente se utilizan cuando se conoce el número de iteraciones de antemano, los while loops son especialmente útiles cuando la condición de terminación depende de eventos o estados que pueden cambiar durante la ejecución del programa.
<br/><br/>
Por ejemplo, mientras que un for loop podría ser más apropiado para iterar sobre un array de tamaño conocido, un 
while loop sería más adecuado para:<br/>
- Procesar entrada de usuario hasta que se ingrese un valor específico<br/>
- Ejecutar un proceso hasta que se alcance cierto estado <br/>
- Realizar operaciones mientras se cumplan múltiples condiciones simultáneas <br/>
<br/><br/>
La sintaxis simple, pero potente, del while loop permite una gran flexibilidad en el control de flujo del programa. A 
continuación se establecen varios ejemplos de su utilización.
</p>
<procedure>
<tabs>
<tab title="While Loop I">

```Java
package example;

public class example{
    
    //! Snippet de la implementación de un quicksort recursivo
    private static <T extends Comparable<T>> 
                void quicksort(T[] data, int first, int last) {
        // Base condition: if the segment has 0 or 1 elements, 
        // it's already sorted
        if (first >= last) return; 

        int lower = first + 1;
        int upper = last;

        // Move the pivot (middle element) to the first position
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
        // Place the pivot in its correct position
        swap(data, upper, first); 

        // Recursively sort the partitions
        if (first < upper - 1) quicksort(data, first, upper - 1);
        if (upper + 1 < last) quicksort(data, upper + 1, last);
    }

}
```

</tab>
<tab title="While Loop II">

```Java

package example;

public class example {

    public static void main(String[] args) {
        int number = 29; 
        boolean isPrime = true;
        int divisor = 2;

        if (number <= 1) {
            isPrime = false; 
        } else {
            while (divisor <= Math.sqrt(number)) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
                divisor++;
            }
        }

        if (isPrime) {
            System.out.println(number + " es primo!");
        } else {
            System.out.println(number + " no es primo :c");
        }
    }

}

```


</tab>
<tab title="While Loop III">

```Java

package example;

public class example{

    public static void main(String[] args){
        final int amountOfRows = 12;
        int counterOfRowsPrinted = 1;

        System.out.println("N\t5xN\t10xN\t15xN\t");
       
         while (counterOfRowsPrinted <= amountOfRows) {
        System.out.println(counterOfRowsPrinted + "\t" + 
        (counterOfRowsPrinted * 5) + "\t" + 
        (counterOfRowsPrinted * 10) + 
        "\t" + (counterOfRowsPrinted * 15));
        counterOfRowsPrinted++;        
        }
    }

}
```

</tab>

</tabs>
</procedure>

### Do-While Loop
<p>El formato de este tipo de loop es exactamente igual al de C++, la forma en la que lo escribimos, con sus 
secciones, declaraciones y reglas de scope siguen siendo iguales. En general, esta estructura presenta el mismo 
formato en donde la condición se revisa en un formato <i>check-at-least-once</i>, en el que el código del do-while 
se ejecuta por lo menos una vez independientemente si la condición de parada se cumple desde un inicio o si se 
modifica internamente.
<br/><br/>
Al igual que en C++, la <code>condición de parada while</code> se escribe luego del corchete de cerrada del 
bloque do, y siempre se termina con un punto y coma.
<br/><br/>
En este sentido, la utilidad de los do-while loops es clara en condiciones en donde nosotros debemos de realizar un 
análisis aunque sea una vez, como en el caso de <code>menus, interacción con el usuario, registro de valores, etc.
</code>. Esto ya que los ejemplos mencionados pueden aunque sea una vez ejecutarse (e.j. imprimir el menu al inicio 
y salir cuando el usuario lo desee, o verificar la entrada de datos del usuario aunque sea una vez). 
<br/><br/>
Basados en las mismas reglas de scopes de variables, siempre es recomendable definir la variable cuya modificación 
se realiza dentro del <code>bloque do{}</code>, fuera del bloque en sí, si esta variable se actualiza y se 
utiliza para la comparativa while. A continuación presentamos tres ejemplos de su uso, traducidos de los ejemplos de 
D. Liang para C++ y algunos nuevos de interacción con el usuario y menus.
</p>
<procedure>
<tabs>
<tab title="Do-While Loop I">

```Java
package example;

public class example {
    public static void main(String[] args) {
        java.util.Scanner sc = 
                 new java.util.Scanner(System.in);
        int item_sold = 0;
        int amount_item_sold = 0;
        int amount_units_sold_total = 0;
        double amount_earnings = 0.0;
        do {
            System.out.print(
            "Ingrese el Producto que vendio (-1 para salir): ");
            item_sold = sc.nextInt();
            if (item_sold == -1) {
                continue;
            } else {
                System.out.print(
                "Ingrese la cantidad de este producto vendido: ");
                amount_item_sold = sc.nextInt();
                switch (item_sold) {
                    case 1:
                        amount_earnings += (amount_item_sold * 2.98);
                        amount_units_sold_total += amount_item_sold;
                        break;
                    case 2:
                        amount_earnings += (amount_item_sold * 4.50);
                        amount_units_sold_total += amount_item_sold;
                        break;
                    case 3:
                        amount_earnings += (amount_item_sold * 9.98);
                        amount_units_sold_total += amount_item_sold;
                        break;
                    case 4:
                        amount_earnings += (amount_item_sold * 4.49);
                        amount_units_sold_total += amount_item_sold;
                        break;
                    case 5:
                        amount_earnings += (amount_item_sold * 6.87);
                        amount_units_sold_total += amount_item_sold;
                        break;
                    default:
                        System.out.println("Input inválido detectado." 
                        + " Deteniendo ejecución.");
                        break;
                }
            }
        } while (item_sold != -1);

        System.out.println("Total units sold: " 
        + amount_units_sold_total);
        System.out.println("Total earnings: " + amount_earnings);
        sc.close();
    }

}
```
</tab>
<tab title="Do-While Loop II">

```Java
package example;

// Ejemplo de interacción con usuario a traves de un menu 
// Usando revision de input

public class example {

    // Method to display the menu and validate input
    public static void validateMenuInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        char option;
        boolean validInput = false;

        do {
            System.out.println("Por favor, seleccione una " +
                               "opción del menú:");
            System.out.println("Opción A");
            System.out.println("Opción B");
            System.out.println("Opción C");
            System.out.println("Opción D");
            System.out.println("Opción E");
            System.out.print("Ingrese su opción (A, B, C, " +
                             "D, E): ");

            option = scanner.next().toUpperCase().charAt(0);

            switch (option) {
                case 'A': {
                    System.out.println("Has seleccionado: " +
                                       "Opción " + option);
                    validInput = true;
                    break;
                }
                case 'B': {
                    System.out.println("Has seleccionado: " +
                                       "Opción " + option);
                    validInput = true;
                    break;
                }
                case 'C': {
                    System.out.println("Has seleccionado: " +
                                       "Opción " + option);
                    validInput = true;
                    break;
                }
                case 'D': {
                    System.out.println("Has seleccionado: " +
                                       "Opción " + option);
                    validInput = true;
                    break;
                }
                case 'E': {
                    System.out.println("Has seleccionado: " +
                                       "Opción " + option);
                    validInput = true;
                    break;
                }
                default: {
                    System.out.println("Entrada inválida. " +
                                       "Por favor, intente " +
                                       "de nuevo.");
                }
            }
        } while (!validInput);
    }

}

}
```

</tab>
<tab title="Do-While Loop III">

```Java
package example;

// Ejemplo de conexion entre While y Do-While 
// Daniel Liang Programming in C++ 4.20
public class example{

public static void main(String[] args){
    int amountOfPasses = 0;
    int amountOfFailures = 0;
    final int amountOfStudents = 10;
    int counter = 1;
    
    while (counter <= amountOfStudents) {
        int gradeHelper = 0;
        System.out.print("Enter a grade(1 for pass, " +
        "2 for fail): ");
        do {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        gradeHelper = sc.nextInt();
        } while (gradeHelper != 1 && gradeHelper != 2);
        
        if (gradeHelper == 1) { 
            amountOfPasses += 1; 
        } else if (gradeHelper == 2) { 
            amountOfFailures += 1; 
        } 
        counter += 1;
    }

    System.out.println("Amount of passes: " +
    amountOfPasses);
    System.out.println("Amount of failures: " +
    amountOfFailures);
    if (amountOfPasses >= 8) {
        System.out.println("Bonus to instructor");
    } else {
        System.out.println("No Bonus");
    }
  }
}
```
</tab>
</tabs>
</procedure>

## Estructuras de Control Lógico
<p>Las estructuras de control lógicas fueron en algunos ejemplos anteriores mostrados en su formato básico, y en 
general el formato que se usa en Java cuando se trabaja con estas estructuras. En Java, las estructuras de control 
logco como if statements, if-elif-else statements, switch statements, y adicionalmente el operador ternario  if-else,
son idénticos, tanto en su implementación, como mecanismo interno con C++ en el caso de Java.
<br/><br/>
La única diferencia es que, si bien en C++ se asumía que <code>todos los valores mayores que cero eran un 
verdadero y cero era falso</code> en java esta regla se cambia y <code>no se permite la evaluación 
de números como si fueran verdadero o falso</code>, estas estructuras siempre requieren de un objeto o Boolean o un 
primitivo boolean resultante de una evaluación previa usando operadores relacionales u otros métodos de Java como 
son <code>Comparator y Comparable</code>
<br/><br/>
Por su parte, la documentación oficial de Java indica lo siguiente acerca de la utilización de booleanos en las 
estructuras de control lógico que ofrece.
</p>
<procedure>
<i>The if statement allows conditional execution of a statement or a conditional choice of two statements, execution 
one or the other, but not both. [...] <br/><br/>
The Expression [condition] must have a type <b>boolean or Boolean</b> [Boolean forces an auto-unboxing to be done], 
or a compile-time error occurs.
</i>
</procedure>
<p>De esta forma entonces, aunque podemos usar las mismas estructuras para organizar nuestro código y controlar el 
flujo de nuestro programa, también tenemos que tener en cuenta que Java solo admite valores booleanos en sus 
condicionales, limitando el código de C++ de ser usado directamente<br/><br/>
Para entender estas estructuras, se mostrarán varios ejemplos de los tres grupos grandes de estructuras de control,
if statements, switch statements y ternary if statement.
</p>

### If Statements 
<p>La base de la estructuras de control logico son los if statement, aquellos condicionales en los que se puede 
seguir un camino (de una o varias opciones) u otro camino (de una o varias opciones), pero nunca dos al mismo tiempo. 
<br/><br/>
La principal utilidad de este tipo de estructuras es la ramificacion de código dependiendo de condiciones 
predefinidas por el programador y que deben ser cumplidas o por el programa, o por el usuario para que se ejecuten 
ciertas partes del código en general. 
<br/><br/>
Por ejemplo, se pueden usar <code>if statements</code> para validar entradas del usuario, como 
asegurarse de que la información ingresada cumpla con ciertas reglas específicas (e.g., un rango de valores numéricos 
válidos). También son útiles para manejar opciones en menús interactivos, activar o desactivar funciones del 
programa basado en la configuración del usuario, o incluso para determinar el flujo del programa dependiendo de 
situaciones lógicas como verificar si una conexión a una base de datos está activa o si un archivo existe antes de 
proceder con una operación sobre él.
<br/><br/>
A continuación se escriben varios ejemplos practicos de los <code>if-statements en Java</code>
</p>

<procedure>
<tabs>
<tab title="If Statements I">

```Java
package example;

import java.util.Scanner;

public class example{


public static void main(String[] args) {
    // Array to store the sides
    double[] sidesTriangle = new double[3];

        
        Scanner scanner = new Scanner(System.in);
        for (int index = 0; 
             index < sidesTriangle.length; 
             index++) {
            System.out.print("Ingrese un lado " + 
                             (index + 1) + ": ");
            sidesTriangle[index] = 
                scanner.nextDouble();
        }


        double angleA = Math.acos(
            (Math.pow(sidesTriangle[1], 2) + 
             Math.pow(sidesTriangle[2], 2) - 
             Math.pow(sidesTriangle[0], 2)) / 
            (2 * sidesTriangle[1] * 
             sidesTriangle[2])
        );
        double angleB = Math.acos(
            (Math.pow(sidesTriangle[0], 2) + 
             Math.pow(sidesTriangle[2], 2) - 
             Math.pow(sidesTriangle[1], 2)) / 
            (2 * sidesTriangle[0] * 
             sidesTriangle[2])
        );
        double angleC = Math.acos(
            (Math.pow(sidesTriangle[0], 2) + 
             Math.pow(sidesTriangle[1], 2) - 
             Math.pow(sidesTriangle[2], 2)) / 
            (2 * sidesTriangle[0] * 
             sidesTriangle[1])
        );

        // Check total angle sum
        double totalAngleSum = 
              angleA + angleB + angleC;

        if (Math.abs(totalAngleSum - 
                     Math.PI) < 0.001) {
            System.out.println(
                "Possible sides for a triangle");
        } else {
            System.out.println(
                "No possible sides for a triangle");
        }

        scanner.close();
    }
}
```
</tab>
<tab title="If Statements II">

```Java
package example;

public class example {
    public static void main(String[] args) {
        for (int row = 1; row <= 8; row++) {   
            if (row % 2 == 0) {
                for (int col = 1; col <= 16; col++) {
                     if (col % 2 == 1) {
                        System.out.print(" "); 
                     } else {
                     System.out.print("* "); }
                }
                System.out.println();
            } else if (row % 2 != 0) {
                for (int col = 1; col <= 16; col++) {
                    if (col % 2 == 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
```
</tab>
<tab title="If Statements III">

```Java
package example;

import java.util.Scanner;

public class Example {
public static void main(String[] args) {
// Populating the array
int[] usrNumbers = new int[10];
Scanner scanner = new Scanner(System.in);

        for (int indx = 0; 
             indx < usrNumbers.length; 
             indx++) {
            System.out.print(
                "Ingrese un numero: ");
            int usrNumber = scanner.nextInt();
            usrNumbers[indx] = usrNumber;
        }

        // Variables for execution
        double firstLargestNumber = 
            usrNumbers[usrNumbers.length / 2];
        double secondLargestNumber = 
            usrNumbers[usrNumbers.length / 2];

        // Loop to find largest and 
        // second-largest numbers
        for (int startIndex = 0; 
             startIndex < usrNumbers.length; 
             startIndex++) {
            double checkValueBegin = 
                usrNumbers[startIndex];
            for (int endIndex = 
                 startIndex + 1; 
                 endIndex < usrNumbers.length; 
                 endIndex++) {
                double checkValueEnd = 
                    usrNumbers[endIndex];
                if (checkValueBegin > 
                    checkValueEnd) {
                    double highValue = 
                        checkValueBegin;
                    if (highValue > 
                        firstLargestNumber) {
                        firstLargestNumber = 
                            highValue;
                    } else if (highValue > 
                               secondLargestNumber
                               && highValue != 
                               firstLargestNumber) {
                        secondLargestNumber = 
                            highValue;
                    }
                } else if (checkValueEnd > 
                           checkValueBegin) {
                    double highValue = 
                        checkValueEnd;
                    if (highValue > 
                        firstLargestNumber) {
                        firstLargestNumber = 
                            highValue;
                    } else if (highValue > 
                               secondLargestNumber
                               && highValue != 
                               firstLargestNumber) {
                        secondLargestNumber = 
                            highValue;
                    }
                }
            }
        }

        // Output the results
        System.out.println(
            "First largest number is: " + 
            firstLargestNumber);
        System.out.println(
            "Second largest number is: " + 
            secondLargestNumber);

        scanner.close();
    }
}
```
</tab>
</tabs>
</procedure>

### Switch Statements
<p>Los condicionales de tipo switch, permiten al programa evaluar una expression, una variable o un ingreso de 
usuario para varios casos generando diversas cadenas de ejecución similares a un if-then-else statement pero con su 
código mucho más simplificado y organizado. <br/>
<br/>
En Java, este tipo de estructuras se amplía con la capacidad de analizar tanto números, como enumeraciones, como 
caracteres asi como cadenas de texto completas. Esta funcionalidad añadida amplía el repertorio de posibles casos de 
uso de los switch statements, ya que, podemos hacer revisiones de tipos de datos que en C++ están limitados a enteros 
o caracteres.
<br/><br/>
Una de las principales formas de utilización de este tipo de estructuras es el análisis de comandos ingresados por 
el usuario en un menu, o la revision de una cadena con respecto de diversas opciones (ambos ejemplos integrales de 
nuestro trabajo en el curso y con significacia en el análisis de archivos e input del usuario.
<br/><br/>
Aunque en algunos casos su utilidad pueda ser remplazada por un if-then-else statement compuesto, es muy importante 
conocer de este también, ya que en algunos casos la solución más intuitiva puede surgir en forma de un switch 
statement.</p>
<procedure>
<tabs>
<tab title="Switch Statement I">

```Java
package example;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int number = scanner.nextInt();
        switch (number) {
            case 1: {
                System.out.println("Ingresaste UNO");
                break;
            }
            case 2:{
                System.out.println("Ingresaste DOS");
                break;
            }
            case 3:{
                System.out.println("Ingresaste TRES");
                break;
            }
            case 4: {
                System.out.println("Ingresaste CUATRO");
                break;
            }
            case 5: {
                System.out.println("Ingresaste CINCO");
                break;
            }
            default: {
                System.out.println(
                "Ingresaste un numero distinto de 1, 2, 3, 4 o 5");
                break;
            }
        }
        
        scanner.close();
    }

}
```
</tab>
<tab title="Switch Statement II">

```Java
package example;

import java.util.Scanner;

public class Example {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            enum Day {
                LUNES, MARTES, MIERCOLES, JUEVES,
                VIERNES, SABADO, DOMINGO
            }

            System.out.print("Ingrese un día de la semana"
                    + "(e.g., LUNES, MARTES): ");
            String input = scanner.nextLine().toUpperCase();

            Day day = null;
            switch (input) {
                case "LUNES" -> day = Day.LUNES;
                case "MARTES" -> day = Day.MARTES;
                case "MIERCOLES" -> day = Day.MIERCOLES;
                case "JUEVES" -> day = Day.JUEVES;
                case "VIERNES" -> day = Day.VIERNES;
                case "SABADO" -> day = Day.SABADO;
                case "DOMINGO" -> day = Day.DOMINGO;
                default -> {
                    System.out.println("Dia ingresado invalido");
                    return;
                }
            }

            String message = switch (day) {
                case LUNES -> 
                "¡Inicio de la semana laboral!";
                case MARTES -> 
                "¡Segundo día de la semana laboral!";
                case MIERCOLES -> 
                "¡Mitad de semana!";
                case JUEVES -> 
                "¡Casi es fin de semana!";
                case VIERNES -> 
                "¡Último día de la semana laboral!";
                case SABADO -> 
                "¡Hora de relajarse, es fin de semana!";
                case DOMINGO -> 
                "¡Prepárate para la semana que viene!";
            };

            System.out.println(message);

            scanner.close();
        }

    }
```
</tab>
<tab title="Switch Statement III">


```Java
package example;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un comando" +  
        " (a = append, r = replace, w = save, q = quit)" + 
            ": ");
        char command = scanner.next().charAt(0);

        switch (command) {
            case 'a': {
                System.out.println("Seleccionaste APPEND" 
                     + "- Agregar datos.");
                break;
            }
            case 'r': {
                System.out.println("Seleccionaste REPLACE" + 
                    "- Reemplazar datos.");
                break;
            }
            case 'w': {
                System.out.println("Seleccionaste SAVE " + 
                    "- Guardar datos.");
                break;
            }
            case 'q': {
                System.out.println("Seleccionaste QUIT" + 
                    " - Salir del programa.");
                break;
            }
            default: {
                System.out.println("Comando no reconocido." + 
                    " Por favor usa: a, r, w, o q.");
                break;
            }
        }

        scanner.close();
    }

}
```
</tab>
</tabs>
</procedure>


## Ternary If-Else Operator
<p>Aunque en la mayoría de este texto lo hemos tratado como una estructura de control lógica. El operador ternario 
de if-else es un operador lógico cuyo propósito es acortar el proceso de escritura de una expresión del tipo if-else.
Es decir, su propósito es transformar en una simple línea el proceso de escribir una condición if larga y el cuerpo 
de tanto esta condición y su else.
<br/><br/>
Por este motivo, su utilización es mucho menos visible en código en general, más bien es un operador que se utiliza 
en algunos casos cuando el código se puede volver más legible o simple al reducir bloques de código largos que el 
usuario debe leer para entender el propósito de los mismos, acortando este proceso a una o dos líneas en donde la 
condición viene en un inicio, seguido de un <code>?</code>, luego de la condición en caso de que la pregunta sea 
verdadera, separada por un <code>:</code>, y al final el código a ejecutar en el código si la condición inicial es 
falsa.
<br/><br/>
Debido a la simpleza de este operador, los ejemplos a continuación serán en muchos casos ejemplos complejos en donde 
en alguna sección se utilice este operador.
</p>
<procedure>
<tabs>
<tab title="Ternary If-Else Operator I">


```Java
package example;

public class Example {
    public static void main(String[] args) {
        int num = 5;
        String resultado = (num % 2 == 0) /*condición*/
        ? "El numero es par" /*Resultado si es verdadero*/
        : "El numero es impar"; /*Resultado si es falso*/
        System.out.println(resultado);
    }
}
</code-block>
</tab>
<tab title="Ternary If-Else Operator II">

```Java
package example;

public class Example {

    
    public static String analizarPrimalidad(int num) {
        // Condiciona si el número es menor o igual a 1, 
        // o si al menos un número en el rango 2 hasta 
        // raíz cuadrada de num es divisor
        return (num <= 1 || isDivisible(num)) 
                ? "El número no es primo"  
                : "El número es primo"; 
    }

    
    private static boolean isDivisible(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 29; 
        String mensaje = analizarPrimalidad(num); 
        System.out.println(mensaje); 
    }

}

```
</tab>
<tab title="Ternary If-Else Operator III">

```Java
package example;

public class Example {

    public static String analizarLongitudPassword(
        String password) {
        return (password.length() < 6) 
            ? "El password es demasiado corto"  
            : "El password tiene una longitud aceptable"; 
    }

    public static void main(String[] args) {
        String password = "seguro123"; 
        String mensaje = analizarLongitudPassword(password); 
        System.out.println(mensaje); 
    }

}

```
</tab>
</tabs>
</procedure>