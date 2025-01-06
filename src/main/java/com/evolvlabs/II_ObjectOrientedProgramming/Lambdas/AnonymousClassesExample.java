package com.evolvlabs.II_ObjectOrientedProgramming.Lambdas;

import com.evolvlabs.IV_Extras.Colorizer;

import java.util.Comparator;

/**
 * <body style="color: white">El presente archivo incluye una serie de metodos demostrativos, tanto de Java como impplementaciones
 * adicionales del programa que demuestran el trabajo con clases anonimas enviadas en funciones que requieren una instancia
 * de una clase abstracta o una interface. Especificamente trabajaremos con funciones que requieran interfaces sencillas.</body>
 */
public class AnonymousClassesExample {

    public static void main(String[] args) {
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos a nuestro programa de prueba para clases anonimas en Java!"));
        System.out.println(Colorizer.colorWithMagentaLetters("Para este ejemplo, trabajaremos con varios metodos definidos, y ordenaremos arreglos!"));
        System.out.println("\n" + Colorizer.colorWithYellowLetters("1. Utilizemos la interface Addition para operaro sobre numeros"));
        System.out.println(Colorizer.colorWithCyanLetters("Calculemos la suma de 15 + 24"));
        addTwoNumbersThroughAddition(15, 24, new Addition() {
            @Override
            public Number add(Number a, Number b) {
                return a.doubleValue() + b.doubleValue();
            }

            @Override
            public Number addExact(Number a, Number b) {
                return a.intValue() + b.intValue();
            }
        });
        System.out.println(Colorizer.colorWithCyanLetters("Calculemos la suma de 15.5 + 24.5"));
        addTwoNumbersThroughAddition(15.5, 24.5, new Addition() {
            @Override
            public Number add(Number a, Number b) {
                return a.doubleValue() + b.doubleValue();
            }

            @Override
            public Number addExact(Number a, Number b) {
                return a.intValue() + b.intValue();
            }
        });
        System.out.println(Colorizer.colorWithCyanLetters("Calculemos la suma de 15 + 24.5"));
        addTwoNumbersThroughAddition(15, 24.5, new Addition() {
            @Override
            public Number add(Number a, Number b) {
                return a.doubleValue() + b.doubleValue();
            }

            @Override
            public Number addExact(Number a, Number b) {
                return a.intValue() + b.intValue();
            }
        });
        System.out.println(Colorizer.colorWithCyanLetters("Calculemos la suma de 245.25 + 125.4566"));
        addTwoNumbersThroughAddition(245.25, 125.4566, new Addition() {
            @Override
            public Number add(Number a, Number b) {
                return a.doubleValue() + b.doubleValue();
            }

            @Override
            public Number addExact(Number a, Number b) {
                return a.intValue() + b.intValue();
            }
        });

        System.out.println("\n" + Colorizer.colorWithYellowLetters("2. Utilizemos la clase abstracta Substraction para restar numeros"));
        System.out.println(Colorizer.colorWithCyanLetters("Calculemos la resta de 15 - 24"));
        determineSubstractionOfNumbers(15, 24, new Substraction() {
            @Override
            public Number substract(Number numA, Number numB) {
                return numA.doubleValue() - numB.doubleValue();
            }

            @Override
            public Number substractExact(Number numA, Number numB) {
                return numA.intValue() - numB.intValue();
            }
        });
        System.out.println(Colorizer.colorWithCyanLetters("Calculemos la resta de 15.5 - 24.5"));
        determineSubstractionOfNumbers(15.5, 24.5, new Substraction() {
            @Override
            public Number substract(Number numA, Number numB) {
                return numA.doubleValue() - numB.doubleValue();
            }

            @Override
            public Number substractExact(Number numA, Number numB) {
                return numA.intValue() - numB.intValue();
            }
        });
        System.out.println(Colorizer.colorWithCyanLetters("Calculemos la resta de 15 - 24.5"));
        determineSubstractionOfNumbers(15, 24.5, new Substraction() {
            @Override
            public Number substract(Number numA, Number numB) {
                return numA.doubleValue() - numB.doubleValue();
            }

            @Override
            public Number substractExact(Number numA, Number numB) {
                return numA.intValue() - numB.intValue();
            }
        });
        System.out.println(Colorizer.colorWithCyanLetters("Calculemos la resta de 245.25 - 125.4566"));
        determineSubstractionOfNumbers(245.25, 125.4566, new Substraction() {
            @Override
            public Number substract(Number numA, Number numB) {
                return numA.doubleValue() - numB.doubleValue();
            }

            @Override
            public Number substractExact(Number numA, Number numB) {
                return numA.intValue() - numB.intValue();
            }
        });

        System.out.println("\n" + Colorizer.colorWithYellowLetters("3. Utilizemos la interface Comparator para comparar cadenas"));
        System.out.println(Colorizer.colorWithCyanLetters("Comparemos las cadenas \"Hola\" y \"Mundo\", por la cantidad de consonantes"));
        determineBiggerOfTwoStrings("Hola", "Mundo", new Comparator<String>() {

            static final String consonantes = "bcdfghjklmnpqrstvxyz";

            @Override
            public int compare(String o1, String o2) {
                Integer[] consonantCount = {0,0};
                for(Character character : o1.toCharArray()){
                    if (consonantes.contains(character.toString())){
                        consonantCount[0]++;
                    }
                }
                for(Character character : o2.toCharArray()){
                    if (consonantes.contains(character.toString())){
                        consonantCount[1]++;
                    }
                }

                return consonantCount[0].compareTo(consonantCount[1]);
            }
        });
        System.out.println(Colorizer.colorWithCyanLetters("Comparemos las cadenas \"Hola\" y \"Mundo\", por la cantidad de vocales"));
        determineBiggerOfTwoStrings("Hola", "Mundo", new Comparator<String>() {

            static final String consonantes = "aeiou";

            @Override
            public int compare(String o1, String o2) {
                Integer[] consonantCount = {0,0};
                for(Character character : o1.toCharArray()){
                    if (consonantes.contains(character.toString())){
                        consonantCount[0]++;
                    }
                }
                for(Character character : o2.toCharArray()){
                    if (consonantes.contains(character.toString())){
                        consonantCount[1]++;
                    }
                }

                return consonantCount[0].compareTo(consonantCount[1]);
            }
        });
        

    }

    /**
     * <body style="color: white">
     * Este metodo demuestra el uso de interfaces y clases anonimas para realizar operaciones matematicas
     * utilizando dos numeros. Evalua si los numeros son de tipo exacto (ej. Integer) o inexacto (ej. Double)
     * y selecciona la operacion adecuada proporcionada por la instancia de la interface {@code Addition}.
     * </body>
     *
     * @param numA Primer numero que sera usado en la operacion.
     * @param numB Segundo numero que sera usado en la operacion.
     * @param additionMethod Instancia de la interface {@code Addition} que define las operaciones de suma.
     * 
     * @throws NullPointerException Si alguno de los argumentos proporcionados es {@code null}.
     * <br><br>
     * <body style="color: white">
     * Utiliza el metodo de la interface {@code Addition} correspondiente, dependiendo del tipo de los numeros:
     * Si son de tipo coma flotante ({@code Double} o {@code Float}), utiliza el metodo {@code add}.
     * Si los numeros son exactos, utiliza el metodo {@code addExact}.
     * </body>
     */
    public static void addTwoNumbersThroughAddition(Number numA, Number numB, Addition additionMethod){
        if ((numA instanceof Double && numB instanceof Double)
                || (numA instanceof Float && numB instanceof Float)
                || (numA instanceof Double && numB instanceof Float)
                || (numA instanceof Float && numB instanceof Double)){
            System.out.println("Como los parametros fueron de coma flotante se realizo una suma inexacta: "
                    + additionMethod.add(numA, numB));
        }
        else {
            System.out.println("Como los parametros fueron exactos se realizo una suma exacta: "
                    + additionMethod.addExact(numA, numB));
        }
    }

    /**
     * <body style="color: white">
     * Este metodo utiliza una instancia de la interface {@code Comparator} para comparar dos cadenas ({@code String}) y
     * determinar cual es la mayor basada en el criterio definido por el {@code comparatorInstance} proporcionado. La
     * comparacion es util cuando se necesita ordenar o evaluar cadenas segun ciertas reglas especificas.
     * </body>
     *
     * @param stringA            La primera cadena a comparar.
     * @param stringB            La segunda cadena a comparar.
     * @param comparatorInstance Instancia de la interface {@code Comparator} que contiene la logica necesaria para
     *                           comparar las dos cadenas.
     * @throws NullPointerException Si alguna de las cadenas o la instancia de {@code Comparator} es {@code null}.
     *                              <body style="color: white">
     *                              Realiza la comparacion llamando al metodo {@code compare} provisto por la instancia
     *                              de {@code comparatorInstance} y muestra el resultado de la cadena "mayor"
     *                              determinada por las reglas del comparador.
     *                              </body>
     */
    public static void determineBiggerOfTwoStrings(String stringA, String stringB, Comparator<String> comparatorInstance) {
        System.out.println("El string mas grande es: " + ((comparatorInstance.compare(stringA, stringB) >= 0) ? stringA : stringB));
    }

    
    /**
     * <body style="color: white">
     * Este metodo realiza una resta utilizando instancias anonimas de la clase abstracta {@code Substraction}.
     * Determina si los numeros proporcionados son exactos (ej. {@code Integer}) o de punto flotante
     * (ej. {@code Double}, {@code Float}) y selecciona el metodo adecuado para efectuar la operacion.
     * <br><br>
     * Si los numeros son de punto flotante, utiliza el metodo {@code substract}.
     * Si son numeros exactos, se usara el metodo {@code substractExact}.
     * </body>
     *
     * @param numA Primer numero que sera utilizado en la operacion de resta.
     * @param numB Segundo numero que sera utilizado en la operacion de resta.
     * @param substractionInstance Instancia anonima de la clase {@code Substraction} que contiene las operaciones necesarias.
     * @throws NullPointerException Si alguno de los parametros proporcionados es {@code null}.
     */
    public static void determineSubstractionOfNumbers(Number numA, Number numB, Substraction substractionInstance){
        if ((numA instanceof Double && numB instanceof Double)
                || (numA instanceof Float && numB instanceof Float)
                || (numA instanceof Double && numB instanceof Float)
                || (numA instanceof Float && numB instanceof Double)){
            System.out.println("Como los parametros fueron de coma flotante se realizo una resta inexacta: "
                    + substractionInstance.substract(numA, numB));
        }
        else {
            System.out.println("Como los parametros fueron exactos se realizo una resta exacta: "
                    + substractionInstance.substractExact(numA, numB));
        }
    }




    /*! Esta interface privada nos servira como base para la implementacion de metodos que demuestren el trabajo con
      ! bloques de codigo anonimo, en especifico inner anonymous classes*/
    public interface Addition{
        public abstract Number addExact(Number numA, Number numB);
        public abstract Number add(Number numA, Number numB);
    }

}
abstract class Substraction{
    public abstract Number substract(Number numA, Number numB);
    public abstract Number substractExact(Number numA, Number numB);
}
