package com.evolvlabs.II_ObjectOrientedProgramming.Generics;

import com.evolvlabs.IV_Extras.Colorizer;
/**
 * <body style="color : white">El presente archivo tiene en su implementacion las bases de los metodos genericos, clases
 * genericas, y parametrizacion de metodos con genericos. En general, este archivo muestra una introduccion clara de la
 * forma en la que los genericos se pueden usar en un entorno de programacion general</body>
 */
public class GenericsPartOne {

    public static void main(String[] args) {

        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos a nuestro programa de prueba para genericos en Java!"));
        System.out.println(Colorizer.colorWithYellowLetters("En este programa, se muestra una implementacion basica de los metodos genericos en Java."));
        System.out.println(Colorizer.colorWithCyanLetters("1. En primera instancia, trabajemos con un metodo generico para imprimir arreglos"));
        Integer[] integerArray = {1,2,3,4,5,6,7,8,9,10};
        Double[]  doubleArray =  {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0};
        String[]  stringArray =  {"1","2","3","4","5","6","7","8","9","10"};
        Character[] characterArray = {'u','d','t','c','c','s','s','o','n','d'};

        /*
        ? Como podemos notar en las lineas inferiores, la llamada a un metodo generico no se realiza declarando el tipo de dato que se
        ? utilizara dentro del arreglo. El metodo dentro de si resuelve el tipo de dato y realiza el proceso de type erasure para
        ? ofuscar el tipo de dato que se usa durante ejecucion.
        */
        System.out.println(Colorizer.colorWithMagentaLetters("Imprimiendo el array de enteros (Integer):"));
        imprimirArregloGenerico(integerArray);
        
        System.out.println(Colorizer.colorWithMagentaLetters("Imprimiendo el array de doubles (Double):"));
        imprimirArregloGenerico(doubleArray);
        
        System.out.println(Colorizer.colorWithMagentaLetters("Imprimiendo el array de Strings:"));
        imprimirArregloGenerico(stringArray);
        
        System.out.println(Colorizer.colorWithMagentaLetters("Imprimiendo el array de caracteres (Character):"));
        imprimirArregloGenerico(characterArray);

        System.out.println("\n");
        System.out.println(Colorizer.colorWithCyanLetters("2. En segunda instancia, trabajemos con un metodo generico para comparar dos valores"));
        /*! Esta llamada al realizarse va a dar un valor correcto dado que ambos valores son numericos*/
        System.out.println(Colorizer.colorWithMagentaLetters("Comparando dos valores numericos [10,5]:"));
        System.out.println("Numero mayor: " + elementoMaximoDeDosValores(10,5));
        /*! Esta llamada al realizarse va a lanzar una excepcion ya que los valores ingresados seran de una clase donde
          ! el operador > no esta implementado (no extiende Number)*/
        try{
            System.out.println(Colorizer.colorWithMagentaLetters("Comparando dos valores no numericos [\"10\", \"5\"]:"));
            System.out.println(elementoMaximoDeDosValores("10", "5"));
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(Colorizer.colorWithRedLetters(Colorizer.colorWithCyanLetters("Como se esperaba ")+
                    " Error: IllegalArgumentException thrown: " + illegalArgumentException.getMessage()));
        }

        System.out.println("\n");
        System.out.println(Colorizer.colorWithCyanLetters("3. En tercera instancia,trabajemos con un metodo para encadenar valores en una cadena"));
        System.out.println(Colorizer.colorWithMagentaLetters("Encadenando valores en una cadena:"));
        System.out.println("Cadena resultante: " + convertirACadena("Hola", "Mundo", "!", "Java", "es", "genial"));
        System.out.println("Cadena resultante: " + convertirACadena(1,2,3,4,5,6,7,8,9,10));
        System.out.println("Cadena resultante: " + convertirACadena(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));

        System.out.println("\n");
        System.out.println(Colorizer.colorWithCyanLetters("4. En cuarta instancia, trabajemos con un metodo para sumar dos valores asumiendo que estos sean numericos"));
        System.out.println(Colorizer.colorWithMagentaLetters("Sumando dos valores numericos [10, 5]:"));
        System.out.println("Suma de valores: " + sumarDosValores(10, 5));
        System.out.println(Colorizer.colorWithMagentaLetters("Sumando dos valores no numericos [\"10\", \"5\"]:"));
        try{
            System.out.println(sumarDosValores("10", "5"));
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(Colorizer.colorWithRedLetters(Colorizer.colorWithCyanLetters("Como se esperaba ")+
                    " Error: IllegalArgumentException thrown: " + illegalArgumentException.getMessage()));
        }

        System.out.println("\n");
        System.out.println(Colorizer.colorWithCyanLetters("5. En quinta instancia, trabajemos con un metodo para saber el tipo de dato del valor ingresado"));
        System.out.println(Colorizer.colorWithMagentaLetters("Tipo de dato del valor ingresado [10]:"));
        System.out.println("Tipo de dato: " + deQueTipoEs(10));
        System.out.println(Colorizer.colorWithMagentaLetters("Tipo de dato del valor ingresado [\"10\"]:"));
        System.out.println("Tipo de dato: " + deQueTipoEs("10"));
        System.out.println(Colorizer.colorWithMagentaLetters("Tipo de dato del valor ingresado [25.4]:"));
        System.out.println("Tipo de dato: " + deQueTipoEs(25.4));

        System.out.println("\n");
        System.out.println(Colorizer.colorWithYellowLetters("Eso fue todo para esta demostracion, en el siguiente archivo revisaremos clases con genericos!"));
    }
    
    /*! En primera instancia notemos como declarar metodos parametrizados con un ejemplo simple*/
    
    /**
     * <body style="color : white">Este metodo utiliza la funcionalidad de genericos en Java para recibir un array de cualquier 
     * tipo y mostrar sus elementos en formato de lista. El parametro de tipo generico <code>E</code> permite que el metodo sea flexible
     * frente a diferentes tipos de datos. Cada elemento del array se recorre mediante un bucle for-each y se imprime en la consola 
     * con un formato estandarizado.</body>
     * @param array : Array de tipo generico que contiene elementos de cualquier tipo
     * @param <E> : Tipo generico que define el tipo de elementos del array
     */
    private static <E> void imprimirArregloGenerico(E[] array){
        if (array.length == 0){
            throw new IllegalStateException("Error: IllegalStateException thrown: El arreglo ingresado, o esta vacio, o fue nulo.");
        }
        else {
            System.out.print("[");
            for (E element : array) {
                System.out.print(element + ", ");
            }
            System.out.println("\b\b]");
        }
    }

    /*! Definimos un metodo en el cual nosotros realizamos un type checking explicito y ademas de esto regresamos el valor
      ! al caller original llamada. Notese la sintaxis usada aqui*/
    /*? access-modifer level-modifier <Generic Type> return-type methodName(Parameters)*/
    
    /**
     * <body style="color : white"> Este metodo utiliza genericos en Java para recibir dos valores de cualquier tipo. En este
     * caso, opera especificamente con valores que implementan la interface <code>Number</code>. El metodo compara ambos valores
     * utilizando su representacion como <code>double</code>.
     * <ul>
     *     <li>Si ambos valores son numeros, realiza una comparacion directa y devuelve el valor numerico mayor de los dos.</li>
     *     <li>Si uno o ambos valores no son numeros, lanza una excepcion del tipo <code>IllegalArgumentException</code>.</li>
     * </ul>
     * Los genericos permiten flexibilidad en el tipo de datos que este metodo puede manejar, manteniendo asi una fuerte
     * consistencia tipica durante la ejecucion del programa.
     * </body>
     *
     * @param valor1 : Primer valor numerico para la comparacion
     * @param valor2 : Segundo valor numerico para la comparacion
     * @param <E> : Tipo generico que debe extender de la clase <code>Number</code>
     * @return Devuelve el valor mayor entre <code>valor1</code> y <code>valor2</code>.
     * @throws IllegalArgumentException Si uno o ambos valores no son del tipo numerico.
     */
    public static <E> E elementoMaximoDeDosValores(E valor1, E valor2){
        if (valor1 instanceof Number && valor2 instanceof Number){
            Number num1 = (Number) valor1;
            Number num2 = (Number) valor2;
            if (num1.doubleValue() > num2.doubleValue()){
                return valor1;
            }
            else {
                return valor2;
            }
        }
        else {
            throw new IllegalArgumentException("Error: IllegalArgumentException thrown: Los valores ingresados no son numericos.");
        }
    }

    /**
     * <body style="color : white"> Este metodo utiliza genericos en Java para recibir una cantidad variable de parametros
     * y concatenarlos en una cadena. Cada parametro puede ser de cualquier tipo gracias al uso del tipo generico 
     * <code>T</code>.
     * <ul>
     *     <li>Se recorren todos los parametros recibidos en un bucle <code>for-each</code> y se convierten a su 
     *     representacion en cadena utilizando el metodo <code>toString()</code>.</li>
     *     <li>Todos los valores son concatenados, agregando el separador "<code>&lt;---&gt;</code>" entre ellos para 
     *     formar la cadena final.</li>
     * </ul>
     * Este metodo es flexible con respecto a los tipos de datos de los parametros, manteniendo una sintaxis compacta 
     * y reusabilidad de codigo mediante la funcionalidad de genericos.
     * </body>
     *
     * @param datos : Parametros de tipo generico que se desean concatenar en una sola cadena
     * @param <T> : Tipo generico que define el tipo de los parametros de entrada
     * @return Devuelve una cadena con todos los valores concatenados, separados por "<code>&lt;---&gt;</code>".
     */
    @SafeVarargs
    protected static <T> String convertirACadena(T... datos){
        StringBuilder sb = new StringBuilder();
        for (T dato : datos) {
            sb.append(dato.toString() + "<--->");
        }
        sb.delete(sb.length() - 5,sb.length());
        return sb.toString();
    }


    /**
     * <body style="color : white">Este metodo utiliza genericos en Java para sumar dos valores numericos.
     * El metodo permite una operacion flexible, ya que los valores son ingresados como tipo generico <code>X</code>.
     * Utiliza el operador <code>instanceof</code> para verificar si los valores implementan la interfaz <code>Number</code>.
     * <ul>
     *     <li>Si ambos valores son del tipo <code>Integer</code>, la suma se realiza con conversion explicita a enteros.</li>
     *     <li>Si ambos valores son del tipo <code>Double</code>, la suma se realiza como doble.</li>
     *     <li>Si los tipos no son numericos o no coinciden, se lanza una excepcion <code>IllegalArgumentException</code>.</li>
     * </ul>
     * Esta funcionalidad permite incorporar genericos para extender el rango de tipos de datos permitidos,
     * mientras mantiene la seguridad de tipos en tiempo de ejecucion.
     * </body>
     *
     * @param val1 : Primer valor para efectuar la operacion de suma
     * @param val2 : Segundo valor para efectuar la operacion de suma
     * @param <X> : Tipo generico que representa los parametros de entrada
     * @return Devuelve el resultado de la suma como tipo generico <code>X</code>
     * @throws IllegalArgumentException Si uno o ambos valores no son numericos
     */
    private static <X> X sumarDosValores(X val1, X val2){
        if (val1 instanceof Number && val2 instanceof Number){
            Number num1 = (Number) val1;
            Number num2 = (Number) val2;
            if (num1 instanceof Integer && num2 instanceof Integer){
                return (X) (Integer) (num1.intValue() + num2.intValue());
            }
            else if (num1 instanceof Double && num2 instanceof Double){
                return (X) (Double) (num1.doubleValue() + num2.doubleValue());
            }
            else {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: Los valores ingresados no son numericos.");
            }
        }
        else {
            throw new IllegalArgumentException("Error: IllegalArgumentException thrown: Los valores ingresados no son numericos.");
        }
    }

    
    /**
     * <body style="color : white">Este metodo utiliza genericos en Java para determinar y devolver el tipo de 
     * dato de un valor ingresado. 
     * <ul>
     *     <li>El metodo acepta un unico parametro de tipo generico <code>ABC</code>, que puede ser cualquier objeto valido en Java.</li>
     *     <li>Utiliza la funcionalidad incorporada en Java para obtener el nombre completo de la clase del objeto.</li>
     *     <li>Gracias al uso de genericos, el metodo puede manejar varios tipos de entrada sin la necesidad de realizar 
     *     conversiones explicitas.</li>
     * </ul>
     * Este metodo es extremadamente util para la introspeccion de tipos genericos y facilita la depuracion al conocer 
     * la clase exacta del elemento ingresado.</body>
     *
     * @param value : Un parametro de tipo generico <code>ABC</code>, que representa el valor cuyo tipo se desea determinar
     * @param <ABC> : Tipo generico que define el parametro de entrada
     * @return Devuelve un <code>String</code> que representa el nombre completo de la clase a la que pertenece el valor ingresado
     */
    protected static final <ABC> String deQueTipoEs(ABC value){
        return value.getClass().getName();
    }
}
