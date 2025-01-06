package com.evolvlabs.I_JavaLangBasics.ControlStructures;


import com.evolvlabs.IV_Extras.Colorizer;

import java.util.Objects;
import java.util.Scanner;

/**
 * <body style="color: white">EL presente archivo contiene implementaciones basicas de las estructur de control escenciales en Java. Especificamente
 * se cubre las estructuras de control logicas que se tienen en el codigo. Para esto se han implementado varios ejemplos del libro de D. Liang sobre Java. </body>
 */
public class ControlStructuresPartTwo {


    public static void main(String[] args) {
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenido a la segunda parte de la " +
                "introduccion a estructuras de control logico"));
        System.out.println(Colorizer.colorWithYellowLetters("Ahora con estructuras de control de flujo!"));
        System.out.println();
        System.out.println(Colorizer.colorWithYellowLetters("Ejemplo 1: Determinar si un punto esta dentro de un circulo o no"));
        isPointWithinDefinedCircle();
        System.out.println();
        System.out.println(Colorizer.colorWithYellowLetters("Ejemplo 2: Determinar si un set de lados son un triangulo correcto"));
        isValidPerimeter();
        System.out.println();
        System.out.println(Colorizer.colorWithYellowLetters("Ejemplo 3: Determinar la validez de un ISBN13"));
        isValidISBN13();
        System.out.println();
        System.out.println(Colorizer.colorWithYellowLetters("Ejemplo 4: Determinar la sequencia de Bits para un Short"));
        determineShortSequenceOfBits();
    }

    /**
     * <body style="color: white">Este metodo toma como input directamente del usuario los valores del radio de un circulo al cual
     * se centra en el origen. Luego solicita un punto en base a dos valores de x y y ingresados por el usuario para determinar si
     * esta dentro o no del circulo</body>
     */
    private static void isPointWithinDefinedCircle(){
        Scanner scanner = new Scanner(System.in);
        Double[] values = {0.0,0.0,0.0};
        registroDeValoresPorConsolaEjemploUno("Ingrese el valor requerido para el radio del circulo original : ",
                values,0);
        registroDeValoresPorConsolaEjemploUno("Ingrese el valor requerido para el punto en x : ", values,1);
        registroDeValoresPorConsolaEjemploUno("Ingrese el valor requerido para el punto en y : ", values, 2);

        //! Una vez encontrados los valores, realizamos un analisis numerico en base al cuadrado usando las librerias base de
        //! Java Math
        Double calculatedRadius = Math.sqrt(Math.pow(values[1],2) + Math.pow(values[2],2));

        //! Aqui usaremos el modelo de if ternario
        Boolean result = (Objects.compare(calculatedRadius, values[0], Double::compareTo) < 0) ?
                                                                                           Boolean.TRUE : Boolean.FALSE;
        if (result){
            System.out.println(Colorizer.colorWithMagentaLetters("El punto (" + values[1] + "," + values[2] +
                    ") esta dentro del circulo"));
        }
        else {
            System.out.println(Colorizer.colorWithMagentaLetters("El punto (" + values[1] + "," + values[2] +
                    ") no esta dentro del circulo"));
        }
    }
    private static void registroDeValoresPorConsolaEjemploUno(String inputMessage,Double[] values, int valueToStore) {
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print(inputMessage);
            if (scanner.hasNextDouble()){
                values[valueToStore] = scanner.nextDouble();
                break;
            }
            else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        } while(true);
    }

    /**
     * <body style="color: white">Este metodo toma como input directamente del usuario los valores de los lados de un triangulo.
     * Luego determina si el triangulo es valido basados en los pares de lados y sus sumas o no y en caso de serlo, calcula su perimetro</body>
     */
    private static void isValidPerimeter() {
        Scanner scanner = new Scanner(System.in);
        Double[] values = {0.0, 0.0, 0.0, 0.0};
        registroDeValoresPorConsolaEjemploUno("Ingrese el valor requerido para el lado 1 del triangulo : "
                , values, 0);
        registroDeValoresPorConsolaEjemploUno("Ingrese el valor requerido para el lado 2 del triangulo : ",
                values, 1);
        registroDeValoresPorConsolaEjemploUno("Ingrese el valor requerido para el lado 3 del triangulo : ",
                values, 2);

        //! Con los valores, un triangulo es valido si la suma de cada dos valores es mayor que los otros dos
        if (((values[0] + values[1]) > values[2])
                && ((values[0] + values[2]) > values[1])
                && ((values[1] + values[2]) > values[0])){
            System.out.println(Colorizer.colorWithMagentaLetters("El triangulo es valido"));
            //! Calculamos e imprimimos el perimetro
            var perimeter = values[0] + values[1] + values[2];
            System.out.println(Colorizer.colorWithMagentaLetters("El perimetro del triangulo es " + perimeter));
        }
        else if ((values[0] + values[1] > values[2])){
            System.out.println(Colorizer.colorWithMagentaLetters("El triangulo no es valido, solo dos de sus lados cumplen" +
                    "con las condiciones."));
            //! Imprimimos aquellos valores
            System.out.println(Colorizer.colorWithMagentaLetters("Los valores correctos ingresados son: "
                    + values[0] + ", " + values[1]));
        }
        else if ((values[0] + values[2] > values[1])){
            System.out.println(Colorizer.colorWithMagentaLetters("El triangulo no es valido, solo dos de sus lados cumplen" +
                    "con las condiciones."));
            //! Imprimimos aquellos valores
            System.out.println(Colorizer.colorWithMagentaLetters("Los valores correctos ingresados son: "
                    + values[0] + ", " + values[2]));
        }
        else if ((values[1] + values[2] > values[0])){
            System.out.println(Colorizer.colorWithMagentaLetters("El triangulo no es valido, solo dos de sus lados cumplen" +
                    "con las condiciones."));
            //! Imprimimos aquellos valores
            System.out.println(Colorizer.colorWithMagentaLetters("Los valores correctos ingresados son: "
                    + values[1] + ", " + values[2]));
        }

    }

    /**
     * <body style="color: white">Este metodo toma como input una cadena de numeros que se asume que es un ISBN 13 con un digito menos.
     * El programa analiza esta cadena y determina el valor faltante del ISBN, el CheckSum. Si la cadena no tiene todos sus caracteres
     * como numeros, o no cuenta con la longitud adecuada, el programa sale sin causar problemas</body>
     */
    private static void isValidISBN13(){
        String userReadLine;
        Scanner scanner = new Scanner(System.in);
        System.out.print(Colorizer.colorWithMagentaLetters("Ingrese el codigo ISBN13 de su libro (Primeros 12 digitos) : "));
        userReadLine = scanner.nextLine();

        //! Revision Base
        for(Character chars : userReadLine.toCharArray()){
            if (!Character.isDigit(chars)){
                System.out.println(Colorizer.colorWithMagentaLetters("El ISBN13 ingresado no es valido"));
                return;
            }
        }
        //! Revision Base.2 : Longitud
        int isbnLength = userReadLine.length();
        if (isbnLength < 12 || isbnLength > 13){
            System.out.println(Colorizer.colorWithMagentaLetters("El ISBN13 ingresado no es valido"));
            return;
        }
        else if (isbnLength == 12) {
            Integer resultingCheckSum = 0;
            for (int i = 1; i <= isbnLength; i++) {
                int parseInt = Integer.parseInt(String.valueOf(userReadLine.charAt(i -1)));
                resultingCheckSum += (i % 2 == 0)? 3*parseInt : parseInt;
            }
            Integer correctedCheckSum = 10 - (resultingCheckSum) % 10;
            if (correctedCheckSum == 10) {
                StringBuilder correctedISBN = new StringBuilder(userReadLine).append(0);
                System.out.println(Colorizer.colorWithMagentaLetters("El ISBN13 ingresado es valido y " +
                        "su ISBN completo es : " + correctedISBN));
            } else {
                StringBuilder correctedISBN = new StringBuilder(userReadLine).append(correctedCheckSum);
                System.out.println(Colorizer.colorWithMagentaLetters("El ISBN13 ingresado es valido y su " +
                        "ISBN completo es : " + correctedISBN));
            }
        }
    }

    private static void determineShortSequenceOfBits(){
        //! En este metodo lo primero es registrar un input numerico y luego intentar convertirlo en bits
        Integer userShort = 0;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.print(Colorizer.colorWithMagentaLetters("Ingrese un numero entero de 16 bits : "));
            if (scanner.hasNextInt()){
                userShort = scanner.nextInt();
            }
            else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        }
        while (userShort < -32_768 || userShort > 32_767);
        final int copyUserShort = userShort;
        //! Una vez leido el dato, tenemos que intentar convertirlo en bits
        final Integer shortLength = 16;
        StringBuilder numberString = new StringBuilder(); //! Seteamos una string variable
        //! Usaremos backtracking
        for(int i = shortLength - 1; i>=0 ; i-- ){
            numberString.append(userShort % 2);
            userShort /= 2;
        }
        numberString.reverse();
        if( copyUserShort > 0){
            System.out.println(Colorizer.colorWithMagentaLetters("El numero [" + userShort + "] " +
                    "convertido en binario = " + numberString));
        }else {

            for (int i = 0; i < 16; i++) {
                numberString.setCharAt(i , numberString.charAt(i) == '0' ? '1' : '0');
            }

            //! Damos la vuelta haciendo una suma a cada bit
            boolean llevoUno = true;
            for(int i = shortLength - 1; i>=0 ; i-- ){
                if (numberString.charAt(i) == '1' && llevoUno){
                    numberString.setCharAt(i, '0');
                }
                else if (numberString.charAt(i) == '0' && llevoUno){
                    numberString.setCharAt(i, '1');
                    llevoUno = false;
                }
            }
            System.out.println(Colorizer.colorWithMagentaLetters("El numero [" + userShort + "] " +
                    "convertido en binario = " + numberString));
        }
    }
}
