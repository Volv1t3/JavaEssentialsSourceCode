package com.evolvlabs.I_JavaLangBasics;

import com.evolvlabs.IV_Extras.Colorizer;
/**
 * <body style="color: white">
 * Este archivo de prueba les permitira probar que su compilador este configurado apropiadamente, corran el codigo y si salta
 * algun error pueden llamarme para solucionarlo
 * <br><br>
 * <blockquote style="font-style: italic; color: white"> <q>Puntos Claves del Archivo</q>
 * <br>
 * <ol>
 *     <li>Los archivos de Java, deben tener el mismo nombre que la clase publica visible dentro del mismo, clases privadas
 *     de esta, u otras en el mismo archivo no pueden ser publicas</li>
 *     <li>Los modificadores de acceso juegan un rol primordial en la declaracion de clases, metodos y variables</li>
 *     <li>La JVM se encarga de (al correr por consola o el IDE)de buscar el metodo de entrada publico estatico llamado
 *     main, si este no existe (en el IDE no permite correr el archivo, o en consola arroja un error)</li>
 * </ol></blockquote>
 * </body>
 */

public class HelloJava {

    /**
     * <body style="color: white">
     * Este es el prototipo general de un metodo main en Java (de aqui sale el chiste de la complejidad de Java para un simple
     * Hello World).
     * <br><br>
     * En IntelliJ (lo pueden probar!), si escriben en sequencia <b style="color: green">p s v m</b> les dara un snippet de codigo rapido para
     * el main de una clase
     * </body>
     */
    public static void main(String[] args) {

        /*Asi se escribe un comentario de una linea con delimitadores completos*/
        System      /*? Clase Base por donde accedemos al sistema*/
                .out/*?Instancia interna publica de una salida a consola*/
                .println("Hello World");

        /*
        * Este es un comentario multilinea, lo usare en varias secciones para describir una clase o una declaracion en el
        * codigo
        */


        /*
         * Es interesante destacar la capacidad de IntelliJ de ayudarnos con el tipo de dato que requerimos, el orden de los
         * parametros, e inclusive a que parametro se esta mappeando nuestro input. De esta forma puedes asegurarte de usar
         * los metodos correctamente
         */
        System.out.println(Colorizer
                .color("A continuacion se imprimen algunos de los valores conocidos de la JVM",
                        Colorizer.Color.GREEN_BOLD));

        /*
         * ? Asi se ve una impresion con formato, no es el mismo de C++, asi que alineacion y centrado no se puede tener
         * ? facilmente. El formato utiliza los caracteres de escape %s para strings, %d para enteros, %f para floats, %n para
         * salto de linea, %t para tab (estos se pueden escribir con \\ tambien
         */
        System.out.printf("Java Vendor Name = %s%n", System.getProperties().getProperty("java.vm.vendor"));

        /*
         ? Asi se puede hacer una impresion simple imitando el funcionamiento de un std::cout << "" std::endl
         */
        System.out.println("Java Virtual Machine Name = " + System.getProperties().getProperty("java.vm.name"));
        /*
         ? Esta forma escribe sin terminar la linea, util para impresiones en lista
         */
        System.out.print("Java Version = " + System.getProperties().getProperty("java.version")+ "\n");
    }
}
