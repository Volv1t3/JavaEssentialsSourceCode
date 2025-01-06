package com.evolvlabs.I_JavaLangBasics.Exceptions;

import com.evolvlabs.IV_Extras.Colorizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * <body style="color: white"> El presente archivo contiene varios metodos implementados para demostrar el manejo de errores
 * general en Java, con bloques try-catch, try-catch-finally, y try-with-resources</body>
 */
public class ExceptionsPartTwo {

    public static void main(String[] args) {

        //! El primer ejemplo de uso de try and catch, se da cuando trabajamos con conversiones numericas. Prueba ingresar
        //! un valor incorrecto en este loop. Mira el Mensaje
        System.out.println();
        System.out.println(Colorizer.colorWithCyanLetters("Prueba de conversiones numericas con try-catch"));
        System.out.println();
        boolean correctInput = false;
        Scanner scanner = new Scanner(System.in);
        do{
            try /*Como en C++ usamos la keyword try en la seccion donde establecemos nuestro codigo*/{
                //? Usualmente se recomienda tener un Scanner en un try or try-with-resources block que lo cierre automaticamente
                System.out.print("Ingresa un valor para tu entero : ");
                if (!scanner.hasNext()) {
                    throw new NoSuchElementException();
                }
                //! Intentemos ingresar un valor incorrecto (un numero muy grande o un texto en una conversion hacia entero
                Integer userInt = scanner.nextInt();
                correctInput = true;
            }
            catch(InputMismatchException inputMismatchException) /*Las excepcions el lenguaje recomienda que tengan un nombre claro*/{
                /*Este es un tipo de Unchecked exceptions, aunque el compilador no nos las dice directamente, sabemos que existen a traves
                 * de las declaraciones el metodo*/
                System.out.println(Colorizer.colorWithCyanLetters("Error: InputMismatchException (entrada incorrecta durante conversion)" +
                        "fue lanzado en la linea 23. Solucionado con un catch"));
                extractorDeInformacionDeError(inputMismatchException);
                scanner.nextLine();
            }
            catch(NoSuchElementException noSuchElementException){
                /*Este es un tipo de Unchecked exceptions, aunque el compilador no nos las dice directamente, sabemos que existen a traves
                * de las declaraciones el metodo*/
                System.out.println(Colorizer.colorWithCyanLetters("Error: NoSuchElementException (entrada incorrecta durante conversion)" +
                        "fue lanzado en la linea 23. Solucionado con un catch"));
                extractorDeInformacionDeError(noSuchElementException);
                scanner.close();
                break;
            }
            catch (IllegalStateException illegalStateException){
                /*Este es un tipo de Unchecked exceptions, aunque el compilador no nos las dice directamente, sabemos que existen a traves
                * de las declaraciones el metodo*/
                System.out.println(Colorizer.colorWithCyanLetters("Error: IllegalStateException (el scanner fue cerrado durante los bloques aneriores)" +
                        "fue lanzado en la linea 23. Solucionado con un catch"));
                extractorDeInformacionDeError(illegalStateException);
                scanner = new Scanner(System.in);
                scanner.nextLine();
            }
        } while (!correctInput);
        System.out.println();
        System.out.println(Colorizer.color("Ahora hagamos la prueba con un try-catch-finally block", Colorizer.Color.GREEN_BOLD_BRIGHT));
        System.out.println();
        //! Ahora hagamos la prueba con un try-catch-finally block
        FileReader reader = null;
        try{
            //! Abramos un archivo que no existe
            String filename = "hello.zig";
            File fileFromName = new File(filename);

            //! Abramos un recurso global
            reader = new FileReader(fileFromName);
            /*
             ? OJO: Existen clases cuyos Checked Exceptions se nos comunicaran dentro del entorno, y hay que anadir bloques de codigo
             ? para contenerlas
             */
        } catch(FileNotFoundException fileNotFoundException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: FileNotFoundException (archivo no encontrado) " +
                    "fue lanzado en la linea 46. Solucionado con un catch"));
            extractorDeInformacionDeError(fileNotFoundException);
        }
        catch(RuntimeException runtimeException){
            //! Este catch es para cualquier otro tipo de RuntimeException
            System.out.println(Colorizer.colorWithCyanLetters("Error: RuntimeException (error unchecked)" +
                    "fue lanzado en la linea 46. Solucionado con un catch"));
            extractorDeInformacionDeError(runtimeException);
        }
        finally{
            //! El bloque finally se ejecuta siempre, haya o no haya excepcion
            System.out.println(Colorizer.colorWithCyanLetters("Bloque finally ejecutado"));
            try{
                if(reader != null){
                    //! Cerramos el recurso global
                    System.out.println(Colorizer.colorWithCyanLetters("Recurso global (FileReader) cerrado"));
                    reader.close();
                }
            } catch(IOException ioException){
                System.out.println(Colorizer.colorWithCyanLetters("Error: IOException (error de entrada/salida)" +
                        "fue lanzado en la linea 60. Solucionado con un catch"));
                extractorDeInformacionDeError(ioException);
            }
        }

        //! Ahora hagamos la prueba con un try-with-resources block
        System.out.println();
        System.out.println(Colorizer.color("Ahora hagamos la prueba con un try-with-resources block", Colorizer.Color.GREEN_BOLD_BRIGHT));
        System.out.println();


        //! Try-with-resources automaticamente cierra los recursos que implementan AutoCloseable
        try (FileReader autoCloseableReader = new FileReader("archivo_que_no_existe.txt")) {
            System.out.println("Intentando leer el archivo...");
            int data = autoCloseableReader.read();
            while(data != -1) {
                System.out.print((char) data);
                data = autoCloseableReader.read();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(Colorizer.colorWithCyanLetters("Error: FileNotFoundException (archivo no encontrado) " +
                    "fue lanzado. Try-with-resources manejará el cierre automáticamente"));
            extractorDeInformacionDeError(fileNotFoundException);
        } catch (IOException ioException) {
            System.out.println(Colorizer.colorWithCyanLetters("Error: IOException (error de entrada/salida) " +
                    "fue lanzado. Try-with-resources manejará el cierre automáticamente"));
            extractorDeInformacionDeError(ioException);
        }

        //! Demonstremos múltiples recursos en try-with-resources
        System.out.println();
        System.out.println(Colorizer.color("Ejemplo con múltiples recursos:", Colorizer.Color.GREEN_BOLD_BRIGHT));
        System.out.println();

        try (
                FileReader primerRecurso = new FileReader("primer_archivo_inexistente.txt");
                FileReader segundoRecurso = new FileReader("segundo_archivo_inexistente.txt")
        ) {
            System.out.println("Intentando leer múltiples archivos...");
            // El código aquí nunca se ejecutará porque los archivos no existen
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(Colorizer.colorWithCyanLetters("Error: FileNotFoundException (archivos no encontrados) " +
                    "fue lanzado. Ambos recursos serán manejados automáticamente"));
            extractorDeInformacionDeError(fileNotFoundException);
        } catch (IOException ioException) {
            System.out.println(Colorizer.colorWithCyanLetters("Error: IOException (error de entrada/salida) " +
                    "fue lanzado. Ambos recursos serán manejados automáticamente"));
            extractorDeInformacionDeError(ioException);
        }

        //! Demonstremos try-with-resources con Scanner
        System.out.println();
        System.out.println(Colorizer.color("Ejemplo con Scanner en try-with-resources:", Colorizer.Color.GREEN_BOLD_BRIGHT));
        System.out.println();

        try (Scanner autoCloseableScanner = new Scanner(new File("datos.txt"))) {
            System.out.println("Intentando leer datos del archivo...");
            while (autoCloseableScanner.hasNextLine()) {
                String linea = autoCloseableScanner.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(Colorizer.colorWithCyanLetters("Error: FileNotFoundException (archivo no encontrado) " +
                    "fue lanzado. Scanner será cerrado automáticamente"));
            extractorDeInformacionDeError(fileNotFoundException);
        }

    }

    public static void extractorDeInformacionDeError(Exception Exception) {
        System.out.print(Colorizer.colorWithMagentaLetters("Causa reportada por el sistema: "));
        System.out.println(Exception.getMessage());
        System.out.print(Colorizer.colorWithMagentaLetters("Tipo De Excepcion reportada por el sistema: "));
        System.out.println(Exception.getClass().getName());
    }


}
