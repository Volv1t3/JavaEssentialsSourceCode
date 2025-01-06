package com.evolvlabs.I_JavaLangBasics;

import com.evolvlabs.IV_Extras.Colorizer;

import java.util.Scanner;

/**
 * <body style="color: white">EL presente archivo contiene implementaciones basicas de las estructur de control escenciales en Java. Especificamente
 * se cubre las estructuras de control logicas que se tienen en el codigo. Para esto se ha realizado un aplicativa que
 * utiliza un arreglo de calificaciones para analizar sus valores e imprimir un analisis de resultados. </body>
 */
public class ControlStructuresPartOne {

    public static void main(String[] args) {
        //! El main de esta clase esta disenado para pedir al usuario un numero como calificacion y en base a este realizar un
        //! registro de la misma. Mientras el usuario ingrese calificaciones se le asigna una letra
        Scanner scanner = new Scanner(System.in);
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenido a nuestra aplicacion demostrativa de las estructuras de control de flujo logico en Java"));
        System.out.println(Colorizer.color("Para trabajar en esta aplicacion, se espera que el ingreso de datos sea con un formato americano (usando puntos)\ny con valores" +
                " que pueden estar entre 0 hasta 100.0 en forma de dobles o enteros.", Colorizer.Color.GREEN));

        /*Ingreso de constantes de trabajo*/
        System.out.print("Ingrese el numero de calificaciones a ingresar: ");
        int numberOfGrades = scanner.nextInt();
        System.out.print("Ingrese su calificacion: ");
        Double[] grades = new Double[numberOfGrades];
        for (int i = 0; i < numberOfGrades; i++) {
            grades[i] = scanner.nextDouble();
        }
        //! Analyzamos el arreglo con un metodo externo
        var gradesInLetters = getLetterForGrade(grades);
        //! Imprimimos el resultado
        System.out.println(Colorizer.color("El resultado de su analisis es el siguiente: ", Colorizer.Color.GREEN));
        for (int i = 0; i < gradesInLetters.length; i++) {
            System.out.println(String.format("%-30s", "Para la Calificacion de : " ) + Colorizer.colorWithYellowLetters(grades[i].toString()) +
                    String.format("%-30s", ". La letra a asignar es : ") +
                    Colorizer.colorWithYellowLetters(gradesInLetters[i]));
        }
    }

    private static String[] getLetterForGrade(Double[] grades){
        String[] gradesInLetters = new String[grades.length];
        for (int i = 0; i < grades.length; i++) {
            var grade = grades[i];
            if ((grade.intValue() > 61) && (grade.intValue() <= 100)){
                if (grade.intValue() <= 71){
                    gradesInLetters[i] = "D";
                }
                else if (grade.intValue() > 71 && grade.intValue() <= 81){
                    gradesInLetters[i] = "C";
                }
                else if (grade.intValue() > 81 && grade.intValue() <= 91){
                    gradesInLetters[i] = "B";
                }
                else if (grade.intValue() > 91){
                    gradesInLetters[i] = "A";
                }
            }
            else {
                gradesInLetters[i] = "F";
            }
        }
        return gradesInLetters;
    }
}

