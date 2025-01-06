package com.evolvlabs.II_ObjectOrientedProgramming.Lambdas;

import com.evolvlabs.IV_Extras.Colorizer;

import java.util.Arrays;

/**
 * <body style="color: white">El presente archivo contiene implementaciones sencillas que demuestran la forma de
 * trabajo y estructura de los bloques lambda, o funciones anonimas, en Java. Para esto nos basamos en interfaces funcionales
 * y varios metodos definidos internamente</body>
 */
public class LambdaExamples {

    /*! Main*/
    public static void main(String[] args) {
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos al programa demostrativo de lambdas en Java!"));
        System.out.println("\n" + Colorizer.colorWithCyanLetters("1. Tomemos la raiz cuadrada de varios numeros usando" +
                " la interface definida dentro de exactSquareRoot para obtener un entero de raiz"));
        System.out.print(Colorizer.colorWithMagentaLetters("Raiz cuadrada exacta de 25: "));
        /*
         ? La declaracion inferior muestra la manera semi-completa de trabajar con un metodo lambda. Se define el nombre
         ? del marametro de la interface funcional (numA), luego de una flecha se define entre corchetes el codigo del
         ? metodo que esta siendo implementado. Esto se puede traducir a una clase anonima como
         ? new exactSquareRoot() {
         ?   @Override
         ?   public int squareRoot(Number numA) {
         ?      return (int) Math.round(Math.sqrt(numA.doubleValue()));
         ? }
         ?}
         */
        System.out.println(getExactSquareRoot(25, numA -> {
            return (int) Math.round(Math.sqrt(numA.doubleValue()));
        }));

        /*
         ? La declaracion inferior es una declaracion completa de un metodo lambda, donde se muestra claramente el tipo
         ? de dato tolerado en la interface funcional. Luego de la flecha, se define el codigo del metodo implementado
         ? dentro de corchetes. Aunque se traduce de igual manera, la escritura es mucho mas clara.
         */
        System.out.print(Colorizer.colorWithMagentaLetters("Raiz cuadrada exacta de 16: "));
        System.out.println(getExactSquareRoot(16, (Number numA) -> {
            return (int) Math.round(Math.sqrt(numA.doubleValue()));
        }));

        System.out.println(Colorizer.colorWithCyanLetters("2. Tomemos la raiz cuadrada de varios numeros usando" +
                " la interface definida dentro de squareRoot para obtener un double de raiz"));


        /*
         ? La definicion inferior es una declaracion mucho mas corta y visible para un metodo simple como es el de una raiz
         ? cuadrada. Es importante notar que las funciones lambda soportan una declaracion sin corchetes, en la misma linea
         ? luego de la flecha.
         */
        System.out.print(Colorizer.colorWithMagentaLetters("Raiz cuadrada de 12.45: "));
        System.out.println(getSquareRoot(12.45, numA -> (Math.sqrt(numA.doubleValue()))));


        System.out.print(Colorizer.colorWithMagentaLetters("Raiz cuadrada de 114.32: "));
        System.out.println(getSquareRoot(114.32, numA -> (Math.sqrt(numA.doubleValue()))));


        System.out.println(Colorizer.colorWithCyanLetters("3. Incrementemos los valores de un arreglo de numeros" +
                " mediante la interfaz funcional incrementNumberArrayValues"));
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print(Colorizer.colorWithMagentaLetters("Arreglo original: " + Arrays.toString(numbers)));
        System.out.println();
        incrementNumberArrayValues(numbers, numberArray -> {
            boolean isInteger = numberArray instanceof Integer[];
            for (int i = 0; i < numberArray.length; i++) {
                if (isInteger){
                    numberArray[i] = numbers[i].intValue() + 2;
                } else {
                    numberArray[i] = numbers[i].doubleValue() + 2.5;
                }
            }
        });
        System.out.print(Colorizer.colorWithMagentaLetters("Arreglo modificado: " + Arrays.toString(numbers)));
        System.out.println();
        Double[] numbers1 = {1.2,2.3,3.4,4.5,5.6,6.7,7.8,8.9,9.10,10.11};
        System.out.print(Colorizer.colorWithMagentaLetters("Arreglo original: " + Arrays.toString(numbers1)));
        System.out.println();
        incrementNumberArrayValues(numbers1, numberArray -> {
            boolean isInteger = numberArray[0] instanceof Integer;
            for(int i = 0; i < numberArray.length; i++){
                numberArray[i] = (isInteger) ? numberArray[i].intValue() + 2 : numberArray[i].doubleValue() + 2.5;
            }
        });
        System.out.print(Colorizer.colorWithMagentaLetters("Arreglo modificado: " + Arrays.toString(numbers1)));
        System.out.println();

        System.out.println(Colorizer.colorWithCyanLetters("4. Imprimamos los valores de un arreglo de numeros" +
                " mediante la interfaz funcional applyLinearFunctionToArray"));
        Integer[] usedNumbers = {0,1,2,3,4,5,6,7,8,9,10};
        System.out.print(Colorizer.colorWithMagentaLetters("Arreglo original: " + Arrays.toString(usedNumbers)));
        System.out.println();
        applyLinearFunctionToArray(4, 5, usedNumbers, (m, b, numberArray) -> {
            for(int i = 0; i < numberArray.length; i++){
                numberArray[i] = m.intValue() * numberArray[i].intValue() + b.intValue();
            }
        });
        System.out.print(Colorizer.colorWithMagentaLetters("Arreglo modificado: " + Arrays.toString(usedNumbers)));
        System.out.println();

    }
    /*! Implementaciones de Metodos Demostrativos*/
    
    /**
     * <body style="color: white">Este metodo calcula la raiz cuadrada entera exacta de un numero utilizando 
     * una instancia de una interfaz funcional. La logica especifica del calculo de la raiz cuadrada es proporcionada 
     * por la instancia de {@code exactSquareRoot}. Este metodo aprovecha la capacidad de las 
     * interfaces funcionales para encapsular la implementacion de una operacion matematica especifica.
     *
     * @param numberToSqrt El numero del cual se desea calcular la raiz cuadrada exacta en forma entera.
     * @param exactSquareRootInstance La instancia que implementa la logica para calcular la raiz cuadrada exacta.
     * @return Un valor de tipo {@code Integer} que representa la raiz cuadrada exacta entera del numero proporcionado.
     * @throws NullPointerException si {@code numberToSqrt} o {@code exactSquareRootInstance} es {@code null}.
     * </body>
     */
    private static Integer getExactSquareRoot(Number numberToSqrt, exactSquareRoot exactSquareRootInstance){
        return (exactSquareRootInstance.squareRoot(numberToSqrt));
    }

    /**
     * <body style="color: white">Este metodo calcula la raiz cuadrada de un numero utilizando una 
     * instancia de una interfaz funcional. La instancia especifica la logica de como debe calcularse 
     * la raiz cuadrada. Este metodo aprovecha el polimorfismo y la abstraccion a traves de 
     * interfaces funcionales para encapsular la logica.
     *
     * @param numberToSqrt El numero del cual se desea calcular la raiz cuadrada.
     * @param squareRootInstance La instancia que implementa la logica del calculo de raiz cuadrada.
     * @return Un valor de tipo {@code Double} que representa la raiz cuadrada del numero proporcionado.
     * @throws NullPointerException si {@code numberToSqrt} o {@code squareRootInstance} es {@code null}.
     * </body>
     */
    private static Double getSquareRoot(Number numberToSqrt, SquareRoot squareRootInstance){
        return squareRootInstance.squareRoot(numberToSqrt);
    }

    /**
     * <body style="color: white">Este metodo aplica un incremento en todos los elementos de un arreglo de numeros de 
     * tipo {@code Number}. Utiliza una interfaz funcional para encapsular la logica del incremento. La implementacion 
     * detallada del incremento se delega a una instancia de {@code incrementNumberArrayValues}.
     * 
     * @param numberArray El arreglo de numeros cuyos valores seran incrementados
     * @param incrementNumberArrayValuesInstance La instancia que aplica la logica del incremento
     * @throws NullPointerException si {@code numberArray} o {@code incrementNumberArrayValuesInstance} es {@code null}
     * </body>
     */
    private static void incrementNumberArrayValues(Number[] numberArray, incrementNumberArrayValues incrementNumberArrayValuesInstance){
        incrementNumberArrayValuesInstance.increment(numberArray);
    }

    /**
     * <body style="color: white">Este metodo aplica una funcion linear de la forma f(x) = mx + b a cada elemento de un arreglo de
     * numeros. Utiliza una interfaz funcional para definir la logica de aplicacion. El parametro m representa la pendiente, 
     * el parametro b es la interseccion en el eje y, y el arreglo de entrada {@code numberArray} contiene los elementos a los que 
     * se aplica esta funcion. La implementacion detallada del calculo se encapsula en una instancia de 
     * {@code applyLinearFunctionToArrayValues}.
     * 
     * @param m La pendiente de la funcion lineal
     * @param b El termino de interseccion en el eje Y
     * @param numberArray El arreglo de numeros al que se le aplicara la funcion lineal
     * @param applyLinearFunctionToArrayValuesInstance La instancia que implementa la logica de la funcion lineal
     * @throws NullPointerException si {@code numberArray} o {@code applyLinearFunctionToArrayValuesInstance} es {@code null}
     * </body>
     */
    private static void applyLinearFunctionToArray(Integer m, Integer b, Number[] numberArray, applyLinearFunctionToArrayValues applyLinearFunctionToArrayValuesInstance){
        applyLinearFunctionToArrayValuesInstance.linearFunction(m, b, numberArray);
    }


    /*! Interfaces funcionales que se usaran en este codigo*/
    @FunctionalInterface
    public static interface exactSquareRoot{
        public abstract int squareRoot(Number numA);
    }

    @FunctionalInterface
    public static interface SquareRoot{
        public abstract double squareRoot(Number numA);
    }

    @FunctionalInterface
    public static interface incrementNumberArrayValues{
        public abstract  void increment(Number[] numberArray);
    }

    @FunctionalInterface
    public static interface applyLinearFunctionToArrayValues{
        public abstract void linearFunction(Number m, Number b, Number[] numberArray);
    }
}
