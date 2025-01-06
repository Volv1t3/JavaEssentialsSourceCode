package com.evolvlabs.I_JavaLangBasics;

import com.evolvlabs.IV_Extras.Colorizer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <body style="color: white">El presente archivo contiene varias declaraciones y ejemplos de manejo de las estructuras
 * de control de flujo mas comunes en Java, asi como de las estrcturas de control logicas necearias. El unico tema que no se va a trabajar es el uso de Streams de informacion
 * dado que esto sale del enfoque de un curso introductorio y generalmente no se usa en un curso de estructuras de datos
 * </body>
 * @author Santiago Arellano
 */
public class MathHelper {

    public static void main(String[] args) {

        System.out.println(Colorizer.color("Bienvenido a la aplicacion introductoria para " +
                                           "Estructuras de Control de Flujo", Colorizer.Color.YELLOW_UNDERLINED));
        System.out.println(Colorizer.color("El proposito de esta aplicacion es explicarte mediante snippets de codigo " +
                "funcionales las estructuras basicas de control de flujo en Java.\nEn este sentido, el programa utiliza under-the-hood" +
                "while loops, do-while loops, range-based fors, forEachs, etc. La idea es que la aplicacion \nsea visual y entretenida, ademas de " +
                "que su contenido tiene un proposito, son funciones matematicas!", Colorizer.Color.GREEN));

        //! Comencemos con un do-while. Usualmente se usa este loop para menus de interactividad con el usuario por consola, se espera
        //! que su at-least-once processing sea util.
        int userOption = 0;
        do{
            //! Para imprimir el menu, usamos la estructura de formatos de Java.
            menuPrintingHelper();
            Scanner scanner = new Scanner(System.in);
            //! Usemos un do-while loop para validar una correcta entrada de datos
           do{
               System.out.print("Por favor, ingrese una opcion valida: ");
               if (scanner.hasNextInt()) {
                   userOption = scanner.nextInt();
                   break;
               } else {
                   System.out.println("Por favor, ingrese un número válido.");
                   scanner.next();
               }
           } while(true);

            //! Una vez receptado el input utilizemos un switch statement para manejar los casos
            switch(userOption){
                case 1 /*!Numeros Primos en un cierto rango*/: {
                    System.out.println(Colorizer.colorWithMagentaLetters("Ha seleccionado la opcion 1, favor ingrese la cota inferior y superior para el rango de numero"));
                    Integer[] cotas = {0,0};
                    valueSelectorWithTitleForCota("Cota Inferior = ", scanner, cotas, 0);
                    valueSelectorWithTitleForCota("Cota Superior = ", scanner, cotas, 1);
                    List<Integer> primes = new ArrayList<>();
                    menuOptionOne(cotas[0],cotas[1],primes);
                    System.out.println(Colorizer.colorWithMagentaLetters("Listado de numeros primos en el rango [" + cotas[0] + " ; " + cotas[1] + "]"));
                    int counterForPrinting = 0;
                    //! Imprimamos los valores con un formato agradable
                    for(int i = 0; i < primes.size(); i++, counterForPrinting++){
                        System.out.print(primes.get(i) + " ");
                        if (counterForPrinting == 10){
                            System.out.println();
                            counterForPrinting = 0;
                        }
                    }
                    System.out.println("\n");
                    break;
                }
                case 2 /*!Calcular el Factorial*/: {
                    System.out.println(Colorizer.colorWithMagentaLetters("Ha seleccionado la opcion 2, calculo de factorial."
                    + "Favor ingrese un numero adecuado cuando se le solicie."));
                    do{
                        System.out.print("Ingrese un numero para calcular su factorial: ");
                        if (scanner.hasNextInt()) {
                            int factorial = scanner.nextInt();
                            System.out.println();
                            System.out.println(Colorizer.colorWithMagentaLetters("El factorial de " + factorial + " es " +
                                    menuOptionTwo(factorial).toString()));
                            System.out.println("\n");
                            break;
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next();
                        }
                    }while (true);
                break;
                }
                case 3 /*@Suma de los primeros enteros naturales*/: {
                    //Aunque exista la formula para esta seccion, considere mejor mostrar el funcionamiento de un for loop
                    // antes que la formula matematica

                    Integer result = 0;
                    Integer userUpperBound = 0;
                    do{
                        System.out.print("Ingrese un numero para calcular la suma de los primeros n numeros naturales: ");
                        if (scanner.hasNextInt()) {
                            userUpperBound = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next();
                        }
                    }while(true);

                    //! Calculamos
                    for(int i = 1; i <= userUpperBound; i++){
                        result += i;
                    }
                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("La suma de los primeros " + userUpperBound + " numeros naturales es " + result.toString()));
                    System.out.println("\n");
                    break;
                }
                case 4/*Suma n pares*/: {
                    Integer result = 0;
                    Integer userUpperBound = 0;
                    do{
                        System.out.print("Ingrese un numero para calcular la suma de los primeros n numeros pares: ");
                        if (scanner.hasNextInt()) {
                            userUpperBound = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next();
                        }
                    }while(true);

                    //! Calculamos
                    for(int i = 1; i <= userUpperBound; i++){
                        result += 2*i;
                    }
                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("La suma de los primeros " + userUpperBound + " numeros pares es " + result.toString()));
                    System.out.println("\n");
                    break;
                }
                case 5 /*Numeros Impares*/:{
                    Integer result = 0;
                    Integer userUpperBound = 0;
                    do{
                        System.out.print("Ingrese un numero para calcular la suma de los primeros n numeros impares: ");
                        if (scanner.hasNextInt()) {
                            userUpperBound = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next();
                        }
                    }while(true);

                    //! Calculamos
                    for(int i = 1; i <= userUpperBound; i++){
                        result += 2*i - 1;
                    }
                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("La suma de los primeros " + userUpperBound + " numeros impares es " + result.toString()));
                    System.out.println("\n");
                    break;
                }
                case 6 /*Numeros Primos*/: {
                    //! Usaremos el metodo de la opcion uno para calcular
                    List<Integer> primes = new ArrayList<>();
                    Integer result = 0;
                    Integer userUpperBound = 0;
                    do{
                        System.out.print("Ingrese un numero para calcular la suma de los primeros n numeros primos: ");
                        if (scanner.hasNextInt()) {
                            userUpperBound = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next();
                        }
                    }while(true);

                    menuOptionOne(0,userUpperBound, primes);

                    //! Utilizamos un forEach para una lista, utilizando el iterador interno
                    for(Integer number: primes){
                        result+= number;
                    }

                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("La suma de los primeros " + userUpperBound + " numeros primos es " + result.toString()));
                    System.out.println("\n");
                    break;
                }
                case 7 /*Numeros Perfectos*/: {

                    Integer result = 0;
                    Integer userUpperBound = 0;
                    do{
                        System.out.print("Ingrese un numero para calcular la suma de los primeros n numeros perfectos: ");
                        if (scanner.hasNextInt()) {
                            userUpperBound = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next();
                        }
                    }while(true);

                    //! Calculamos
                    for(int i = 2; i <= userUpperBound; i++){
                        result += (Math.sqrt(i) == (int) Math.sqrt(i)) ? i : 0;
                    }
                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("La suma de los primeros " + userUpperBound + " numeros perfectos es " + result.toString()));
                    System.out.println("\n");
                    break;
                }
                case 8 /*N Numeros Fibo*/:{
                    Integer result = 0;
                    Integer userUpperBound = 0;
                    do{
                        System.out.print("Ingrese un numero para calcular la suma de los primeros n numeros de la sucesion de Fibonacci: ");
                        if (scanner.hasNextInt()) {
                            userUpperBound = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next();
                        }
                    }while(true);

                    //! Calculamos
                    List<Integer> fibos = new ArrayList<>();
                    for(int i = 1; i <= userUpperBound; i++){
                        fiboFinder(i,fibos);
                    }

                    for(Number fibo: fibos){
                        result += fibo.intValue();
                    }

                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("La suma de los primeros " + userUpperBound + " numeros de la sucesion de Fibonacci es " + result.toString()));
                    System.out.println("\n");
                    break;
                }
                default: {
                    System.out.println(Colorizer.colorWithMagentaLetters("Opcion no valida, favor ingrese una opcion valida"));
                    break;
                }
            }



        }
        while (userOption != -1);
    }

    private static void valueSelectorWithTitleForCota(String s, Scanner scanner, Integer[] cotas, Integer index) {
        do {
            System.out.print(s);
            if (scanner.hasNextInt()) {
                cotas[index] = scanner.nextInt();
                break;
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        } while (true);
    }

    private static void menuPrintingHelper() {
        String menuOptionFormat = "%-80s";
        String menuOptionNumberFormat = "%60s";
        System.out.println(String.format(menuOptionFormat,Colorizer.colorWithYellowLetters("Encontrar los numeros primos en un cierto rango..."))
                         + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 1")));
        System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Calcular el factorial de un numero..."))
                         + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 2")));
        System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Calcular la suma de los primeros n numeros naturales..."))
                         + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 3")));
        System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Calcular la suma de los primeros n numeros pares..."))
                         + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 4")));
        System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Calcular la suma de los primeros n numeros impares..."))
                         + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 5")));
        System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Calcular la suma de los primeros n numeros primos..."))
                         + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 6")));
        System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Calcular la suma de los primeros n numeros perfectos..."))
                         + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 7")));
        System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Calcular la suma de los primeros n numeros de Fibonacci..."))
                         + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 8")));
        System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Salir del programa..."))
                         + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero -1")));
    }

    /**
     * <body style="color: white">El presente metodo contiene una modificacion a la implementacion dada por D. Liang en su
     * libro sobre Java para encontrar primos dentro de un rango de una manera eficiente. El metodo calcula los primos inferiores
     * a la cota inferior primero para poblar el arreglo general y encontrar los primos dentro del rango lowerBound-upperBound.
     * El arreglo que se pasa por referencia</body>
     * @param lowerBound: Cota inferior del rango
     * @param upperBound: Cota superior del rango
     * @param primes: Arreglo de enteros donde se guardaran los primos encontrados
     */
    private static void menuOptionOne(int lowerBound, int upperBound, List<Integer> primes) {

        if (lowerBound > upperBound) {
            Colorizer.color("Error: Lower Bound > Upper Bound para metodo menuOptionOne en la linea 83, resuelto retornando al menu",
                    Colorizer.Color.RED_BOLD_BRIGHT);
            return;
        }

        List<Integer> tempPrimes = new ArrayList<>();
        if (primes.isEmpty()) {
            tempPrimes.add(2);
        } else {
            tempPrimes.addAll(primes);
        }

        if (lowerBound <= 2 && 2 <= upperBound) {
            primes.add(2);
        }
        int number = 3;
        int sqrt = 1;

        //! Calculo de numeros primos hasta lower bound, es decir todos los base necesitados para el analisis general
        while (number < lowerBound) {
            boolean isPrime = true;
            if (sqrt * sqrt < number) {
                sqrt++;
            }

            for (int divisor = 0; divisor < tempPrimes.size() &&
                    tempPrimes.get(divisor) <= sqrt; divisor++) {
                if (number % tempPrimes.get(divisor) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                tempPrimes.add(number);
            }
            number++;
        }


        while (number <= upperBound) {
            boolean isPrime = true;
            if (sqrt * sqrt < number) {
                sqrt++;
            }

            for (int divisor = 0; divisor < tempPrimes.size() &&
                    tempPrimes.get(divisor) <= sqrt; divisor++) {
                if (number % tempPrimes.get(divisor) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(number);
                tempPrimes.add(number);
            }
            number++;
        }
    }
    private static BigInteger menuOptionTwo(int numberToFindItsFactorial){
        //! Para calcular el factorial usaremos un approach bottom-up tabulacion de datos de Dynamic Programming
        if (numberToFindItsFactorial < 0){
            Colorizer.color("Error: numberToFindItsFacorial < 0 para metodo menuOptionTwo en la linea 200, resuelto retornando al menu",
                    Colorizer.Color.RED_BOLD_BRIGHT);
            return BigInteger.ZERO;
        }

        //! Definimos la tabla
        BigInteger[] dpTable = new BigInteger[numberToFindItsFactorial + 1];
        dpTable[0] = BigInteger.ONE;

        //! Iteramos para hallar factorial
        for(int i = 1; i <= numberToFindItsFactorial; i++){
            dpTable[i] = BigInteger.valueOf((long) dpTable[i - 1].intValue() * i);
        }

        return dpTable[numberToFindItsFactorial];
    }
    private static void fiboFinder(int fiboToFind, List<Integer> memoization)
    {
        if(memoization.isEmpty()){
            memoization.addAll(List.of(0,1));
        }
        while (memoization.size() <= fiboToFind) {
            int size = memoization.size();
            memoization.add(memoization.get(size - 1) + memoization.get(size - 2));
        }
    }
}
