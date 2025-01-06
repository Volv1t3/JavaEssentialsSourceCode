package com.evolvlabs.II_ObjectOrientedProgramming.BookExample;

import com.evolvlabs.IV_Extras.Colorizer;
import com.evolvlabs.I_JavaLangBasics.ExceptionsPartTwo;

import java.util.Arrays;
import java.util.Collections;


public class BookHierarchyMainTest {
    public static void main(String[] args)  {

            try{
                    Book[] internalBookArray = new Book[6];
                    //? Primeros Dos Libros se Colocan Como Clase Base
                    internalBookArray[0] = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997);
                    internalBookArray[1] = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998);
                    //? Tercer y Cuarto Libro se Colocan Como Clase Derivada PrintBook
                    internalBookArray[2] = new PrintBook("Penguin Publications", "13-145-55-242", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997);
                    internalBookArray[3] = new PrintBook("Penguin Publications", "11-112-33-111", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998);
                    //? Quinto y Sexto Libro se Colocan Como Clase Derivada AudioBook
                    internalBookArray[4] = new AudioBook(145, 111, "Fausto Pasmay", "Java How To Program 11th Edition, Global Edition Founders", "Paul Deitel", 2012);
                    internalBookArray[5] = new AudioBook(150, 222, "Daniel Riofrio", "Dart Apprentice: Learning Dart", "Paul Deitel", 2015);

                    Collections.shuffle(Arrays.asList(internalBookArray)); //? Shuffle de los Libros.
                    System.out.printf("\n%100s\n\n", "Impresion de Libros dentro de Arreglo [No Autoclosable][Polimorfismo]");
                    Arrays.stream(internalBookArray).forEach(System.out::println); //? Impresion de los nuevos valores.
            }
            catch (IllegalArgumentException illegalArgumentException){
                    System.out.println(Colorizer.colorWithCyanLetters("Error: illegalArgumentException (alguno de los valores de inicializacion de las clases fue incorrecto)" +
                            "fue lanzado en main del archivo BookHierarchyMainTest.java . Solucionado con un catch"));
                    ExceptionsPartTwo.extractorDeInformacionDeError(illegalArgumentException);
            }



    }

}