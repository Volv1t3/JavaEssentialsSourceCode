package com.evolvlabs.I_JavaLangBasics;

import com.evolvlabs.IV_Extras.Colorizer;

/**
 * <body style="color:white "> El presente archivo contiene implementaciones que demuestran diversas capacidades adicionales
 * de las excepciones en Java. Encadenamiento de excepciones, Rethrowing Exceptions, Creating Exceptions</body>
 */
public class ExceptionsPartOne {

    public static void main(String[] args) {
    
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            int userInput;
            do {
                System.out.println(Colorizer.colorWithCyanLetters("Bienvenido a nuestro programa de prueba de Excepciones"));
                System.out.println();
                String menuOptionFormat = "%-80s";
                String menuOptionNumberFormat = "%60s";
                System.out.println(String.format(menuOptionFormat,Colorizer.colorWithYellowLetters("Excepciones encadenadas simple..."))
                        + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 1")));
                System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Excepciones encadenadas complejas..."))
                        + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 2")));
                System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Manejo de excepciones lanzadas..."))
                        + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 3")));
                System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Lanzamiento de Excepciones desde un metodo..."))
                        + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero 4")));
                System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters("Salir del programa..."))
                        + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters("Opcion Numero -1")));
                System.out.print("Su seleccion: ");

                do {
                    if (scanner.hasNextInt()){
                        userInput = scanner.nextInt();
                        break;
                    }
                    else {
                        System.out.println("Por favor, ingrese un número válido.");
                        scanner.next();
                    }
                }while (true);
    
                switch (userInput) {
                    case 1:
                        chainedExceptionsOne();
                        break;
                    case 2:
                        chainedExceptionTwo();
                        break;
                    case 3:
                        throwingExceptionOutside();
                        break;
                    case 4: {
                        // En clase un-comment this line
//                         methodThrownException(true);

                        try {
                            //! Primero intentemos hacer que el metodo lance una checked exception
                            System.out.println();
                            System.out.println(Colorizer.colorWithYellowLetters("Intentemos lanzar una excepcion checked desde el metodo"));
                            methodThrownException(true);
                        }
                        catch(Exception exceptions){
                            System.out.println(Colorizer.colorWithYellowLetters("Capturamos la Exception class e imprimimos sus valores"));
                            System.out.println(Colorizer.colorWithYellowLetters(exceptions.getMessage()));
                            ExceptionsPartTwo.extractorDeInformacionDeError(exceptions);
                            System.out.println();
                            System.out.println(Colorizer.colorWithYellowLetters("Imprimimos el StackTrace de la excepcion"));
                            exceptions.printStackTrace(System.out);
                            System.out.println(Colorizer.colorWithYellowLetters("Fin del StackTrace de la excepcion"));
                            System.out.println();
                        }

                        try{
                            //! Luego intentemos hacer que el metodo lance una unchecked exception
                            System.out.println();
                            System.out.println(Colorizer.colorWithYellowLetters("Intentemos lanzar una excepcion unchecked desde el metodo"));
                            methodThrownException(false);
                        }
                        catch (IllegalArgumentException exception){
                            System.out.println(Colorizer.colorWithYellowLetters("Capturamos la IllegalArgumentException e imprimimos sus valores"));
                            System.out.println(Colorizer.colorWithYellowLetters(exception.getMessage()));
                            ExceptionsPartTwo.extractorDeInformacionDeError(exception);
                            System.out.println();
                            System.out.println(Colorizer.colorWithYellowLetters("Imprimimos el StackTrace de la excepcion"));
                            exception.printStackTrace(System.out);
                            System.out.println(Colorizer.colorWithYellowLetters("Fin del StackTrace de la excepcion"));
                            System.out.println();
                        }
                        catch (Exception e){
                            //! Ignored
                        }

                        break;
                    }
                    case -1:
                        System.out.println(Colorizer.colorWithYellowLetters("Saliendo del programa..."));
                        break;
                    default:
                        System.out.println(Colorizer.colorWithYellowLetters("Opcion no valida, por favor, ingrese una opcion del menu anterior"));
                }
            } while (userInput != -1);
        }
    }


    /**
     * <body style="color: white">Este metodo verifica si el valor ingresado por el usuario es nulo, y en caso de que lo sea, lanza una excepcion con
     * un mensaje propio. Si el valor no es nulo, se imprime el numero proporcionado al usuario. Este metodo utiliza IllegalArgumentException
     * para representar errores derivando de argumentos invalidos, que son parte de las RuntimeExceptions, no siendo verificadas por el compilador.</body>
     */
    private static void inputOrException(Number userNumberInput) throws IllegalArgumentException {
        if (userNumberInput == null){
            throw new IllegalArgumentException("Generamos nuestro propio mensaje de excepcion y la lanzamos. Illegal Argument Exception" +
                    "proviene de las RuntimeExceptions, por lo que el compilador no revisa por esta.");
        }
        else {
            System.out.println(Colorizer.color("El numero ingresado es: " + userNumberInput, Colorizer.Color.GREEN_UNDERLINED));
        }
    }

    
    /**
     * <body style="color: white">
     * Este metodo demuestra el manejo y encadenamiento de excepciones. Inicialmente, el metodo intenta convertir 
     * un String ("Hola") a un numero entero, lo que provoca una excepcion de tipo NumberFormatException. <br><br> Esta primera 
     * excepcion es capturada con un bloque catch, y luego se crea y lanza una nueva excepcion de tipo 
     * IllegalArgumentException que encapsula a la excepcion original. Finalmente, la excepcion encadenada es manejada 
     * en un segundo bloque catch con un analisis adicional del stack trace. <br><br>Este ejemplo muestra como capturar, analizar 
     * y lanzar de nuevo excepciones en distintas capas de una aplicacion.
     * </body>
     */
    private static void chainedExceptionsOne(){
        try {
            try {
                System.out.println(Colorizer.colorWithYellowLetters("Intentemos convertir un String a un Integer"));
                Integer.parseInt("Hola");
            } catch (NumberFormatException numberFormatException) {
                System.out.println(Colorizer.colorWithCyanLetters("Error: NumberFormatException (no se puede convertir un String a un Integer) fue lanzado en la linea 64. Solucionado con un catch"));
                ExceptionsPartTwo.extractorDeInformacionDeError(numberFormatException);
                System.out.println(Colorizer.colorWithYellowLetters("Ahora vamos a encadenar la excepcion"));
                throw new IllegalArgumentException(numberFormatException);
            }
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: IllegalStateException (no se puede convertir un String a un Integer) fue lanzado en la linea 69 (propagado a otro error). " +
                    " Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(illegalArgumentException);
            System.out.println(Colorizer.colorWithYellowLetters("Inicio de Stack Trace para IllegalArgumentException "));
            StackTraceElement[] stackTrace = illegalArgumentException.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.out.println("stackTraceElement.getMethodName() = " + stackTraceElement.getMethodName());
                System.out.println("stackTraceElement.getFileName() = " + stackTraceElement.getFileName());
                System.out.println("stackTraceElement.getClassName() = " + stackTraceElement.getClassName());
                System.out.println("stackTraceElement.getLineNumber() = " + stackTraceElement.getLineNumber());
            }
            System.out.println(Colorizer.colorWithYellowLetters("Fin de Stack Trace para IllegalArgumentException "));
        }
    }
    
    /**
     * <body style="color: white">
     * Este metodo demuestra como lanzar una excepcion hacia fuera de un bloque try-catch. <br><br>
     * El metodo intenta simular una situacion donde se lanza una IllegalArgumentException. <br><br>
     * Esta excepcion es capturada dentro de un bloque catch, donde se maneja apropiadamente mostrando el stack trace y 
     * detalles del error. Posteriormente, se realiza un analisis y presentacion del stack trace a traves del metodo 
     * <code>illegalArgumentException.printStackTrace()</code>, permitiendo observar el flujo de la excepcion. 
     * Con estos pasos, se ilustra el concepto de captura y manejo de excepciones lanzadas en Java.
     * </body>
     */
    private static void throwingExceptionOutside(){
        try {
            System.out.println(Colorizer.colorWithYellowLetters("Intentemos volver a lanzar una excepcion hacia fuera"));
            throw new IllegalArgumentException("Excepcion lanzada hacia fuera");
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: IllegalArgumentException (Excepcion lanzada hacia fuera) fue lanzado en la linea 37. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(illegalArgumentException);
            System.out.println();
            System.out.println(Colorizer.colorWithYellowLetters("Inicio de Stack Trace para IllegalArgumentException "));
            illegalArgumentException.printStackTrace(System.out);
            System.out.println(Colorizer.colorWithYellowLetters("Fin de Stack Trace para IllegalArgumentException "));
            System.out.println();
        }
    }
    
    /**
     * <body style="color: white">
     * Este metodo ilustra un ejemplo complejo de encadenamiento de excepciones. Inicialmente, intenta invocar el 
     * metodo <code>inputOrException</code> con un valor nulo, lo cual lanza una excepcion <code>IllegalArgumentException</code>. <br><br>
     * Esta excepcion es capturada y luego encapsulada en una nueva excepcion <code>RuntimeException</code>. Esto se repite
     * una vez mas, lanzando otra instancia de <code>RuntimeException</code>. Finalmente, se maneja la excepcion externa 
     * con un bloque catch, donde el stack trace es analizado y mostrado usando diversos detalles como el metodo 
     * <code>RuntimeException.printStackTrace()</code>. Este ejemplo muestra el flujo de excepciones encadenadas y 
     * como manejar errores lanzados de esta manera en Java.
     * </body>
     */
    private static void chainedExceptionTwo(){
        try{
            try{
                try{
                    inputOrException(null);
                }
                catch(IllegalArgumentException illegalArgumentException){
                    throw new RuntimeException(illegalArgumentException);
                }
            }catch (RuntimeException runtimeException){
                throw new RuntimeException(runtimeException); //! Estamos lanzando la excepcion hacia afuera para causar que
                //! el programa se caiga
            }
        }catch(RuntimeException runtimeException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: RuntimeException (Excepcion lanzada hacia fuera) fue lanzado en la linea 56." +
                    " Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(runtimeException);
            System.out.println();
            System.out.println(Colorizer.colorWithYellowLetters("Inicio de Stack Trace para RuntimeException "));
            runtimeException.printStackTrace(System.out);
            System.out.println(Colorizer.colorWithYellowLetters("Fin de Stack Trace para RuntimeException "));
            System.out.println();
        }
    }
    
    
    /**
     * <body style="color: white">
     * Este metodo ilustra el lanzamiento de excepciones en Java. Dependiendo del valor del parametro <code>throwChecked</code>, 
     * este metodo genera una excepcion de tipo <code>Exception</code> (Checked Exception) que debe ser declarada en 
     * el prototipo del metodo o, alternativamente, una excepcion de tipo <code>IllegalStateException</code> 
     * (Unchecked Exception). <br><br>
     * En el caso de <code>IllegalStateException</code>, al ser una subclase de <code>RuntimeException</code>, no es obligatorio 
     * declararla en el prototipo, pero es recomendable documentarla adecuadamente en el comentario Javadoc. Este ejemplo 
     * demuestra el uso de excepciones verificadas y no verificadas en un metodo.
     * </body>
     * @param throwChecked : Booleano que determina si se lanza una excepcion de tipo Checked Exception (Exception) o
     *                     de tipo Unchecked Exception (IllegalStateException)
     * @throws Exception : Excepcion de tipo Checked Exception (Exception) que debe ser declarada en el prototipo del metodo
     * @throws IllegalArgumentException : Excepcion de tipo Unchecked Exception (IllegalStateException) que no es obligatoria
     *                                  declarar en el prototipo, pero es recomendable documentarla adecuadamente en el comentario Javadoc
     */
    private static void methodThrownException(Boolean throwChecked) throws Exception {
        //! Este metodo lo unico que realiza es lanzar una excepcion de tipo Checked Exception (Todo que extienda de Exception 
        //! o sea Exception) lo que requiere ser declarado en el prototipo de la funcion
        if (throwChecked){
            throw new Exception("Error: Instancia de la clase Exception (Checked Exception root) fue lanzada en el metodo" +
                    " methodThrownException");
        }
        else {
            //! Notese que IllegalStateException, al ser una subclase de RuntimeException no requiere ser declarada en el 
            //! prototipo, aunque es buena costumbre explicar en el Javadoc todas las excepciones posibles y describirlas en
            //! la throws clause
            throw new IllegalArgumentException("Error: Instancia de la clase IllegalArgumentException (Unchecked Exception) " +
                    " fue lanzada en el metodo methodThrownException");
        }
    }
}
