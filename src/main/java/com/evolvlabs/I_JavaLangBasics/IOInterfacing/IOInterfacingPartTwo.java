package com.evolvlabs.I_JavaLangBasics.IOInterfacing;

import com.evolvlabs.IV_Extras.Colorizer;
import com.evolvlabs.I_JavaLangBasics.Exceptions.ExceptionsPartTwo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 * <body style="color: white"> El presente archivo cuenta con varias funciones implementadas que se encargan de leer archivos
 * registrados en la seccion de recursos del proyecto. La idea es lograr leer un archivo en primera instancia usando el Scanner, y usarlo para
 * imprimir y leer por consola</body>
 */
public class IOInterfacingPartTwo {

    static final String RESOURCE_FILE_A = "src/main/resources/IOInterfacingPartTwo_A.txt";
    static final String RESOURCE_FILE_B = "src/main/resources/IOInterfacingPartTwo_B.txt";

    public static void main(String[] args) {
        //! Ahora vamos a trabajar con un archivo IOInterfacingPartTwo_A.txt de la carpeta de resources
        System.out.println(Colorizer.colorWithYellowLetters("Ahora vamos a trabajar con un archivo IOInterfacingPartTwo_A.txt de la carpeta de resources"));
        System.out.println();
        System.out.println(Colorizer.colorWithYellowLetters("Ejemplo 1: Abrir archivo usando el Scanner y luego imprimirlo por consola"));
        System.out.println();
        do{
            try{
                Scanner scannerForThisTest = new Scanner(System.in);
                System.out.println(Colorizer.colorWithYellowLetters("Ingrese el numero de lineas a leer: "));
                Integer numOfLines = scannerForThisTest.nextInt();
                readFileAndPrintLines(numOfLines);
                break;
            }catch (Exception e){
                System.out.println(Colorizer.colorWithCyanLetters("Error: Ingrese un numero entero"));
            }
        }while (true);
        System.out.println();
        System.out.println(Colorizer.colorWithYellowLetters("Ejemplo 2: Abrir archivo usando el FileWriter y luego escribir sobre el"));
        System.out.println();
        writeOntoFileUsingScanner();
        System.out.println();
        System.out.println(Colorizer.colorWithYellowLetters("Ejemplo 3: Abrir archivo usando el FileReader y luego leerlo por consola"));
        readSecondFileUsingFileReader();
        System.out.println();

    }

    
    /**
     * <body style="color: white">
     * Este metodo se encarga de leer un numero especifico de lineas de un archivo dentro de los recursos del proyecto
     * y las imprime en la consola. Para lograrlo, utiliza un bloque try-with-resources con un objeto Scanner para abrir
     * el archivo y leerlo linea por linea.
     *
     * @param numOfLines El numero de lineas que el usuario desea leer e imprimir desde el archivo. Este valor debe ser 
     *                   un entero positivo.
     * @throws FileNotFoundException Si el archivo "IOInterfacingPartTwo_A.txt" no puede ser localizado en la ruta especificada;
     *         la excepcion sera capturada y manejada dentro del metodo.
     *
     * El metodo muestra mensajes de error si no hay lineas suficientes para leer, y cierra automaticamente el recurso Scanner 
     * al finalizar, asegurando que no haya fugas de recursos.
     * </body>
     */
    private static void readFileAndPrintLines(Integer numOfLines){
        //! Abramos el archivo dentro de un try-with-resources-block
        try (Scanner fileScanner = new Scanner(new File(RESOURCE_FILE_A))){

            //! Con el objeto abierto es momento de leer un cierto numero de lineas de el
            int counter = 0;
            while (counter < numOfLines){
                if (fileScanner.hasNextLine()){
                    System.out.println("Linea Leida por el Scanner [" + counter + "] : " + fileScanner.nextLine());
                    counter++;
                }
                else{
                    System.out.println(Colorizer.colorWithCyanLetters("Error: No hay mas lineas para leer"));
                    break;
                }
            }
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: FileNotFoundException (archivo no encontrado) " +
                    "fue lanzado en el metodo readFileAndPrintLines. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(fileNotFoundException);
        }
        finally {
            System.out.println(Colorizer.colorWithYellowLetters("El programa ha finalizado su ejecucion, por tanto" +
                    " el Scanner se ha cerrado"));
        }
    }

    /**
     * <body style="color: white">
     * Este metodo permite a un usuario escribir datos directamente en un archivo de texto ubicado en los recursos del proyecto. <br>
     * Utiliza la clase Scanner para capturar entradas desde el teclado, y un FileWriter para escribir estas entradas al final del archivo. <br>
     * El metodo opera bajo un bloque try-with-resources, asegurando que todos los recursos utilizados sean cerrados automaticamente al finalizar. <br>
     * 
     *
     * </body>
     */
    private static void writeOntoFileUsingScanner(){
        try (Scanner lectorDeConsola = new Scanner(System.in);
             //! Esta llamada esta hecha para poder escribir valores luego de lo que ya se ha escrito
             FileWriter escritorDeArchivos = new FileWriter(RESOURCE_FILE_A, true);
             var lines = Files.lines(Path.of(RESOURCE_FILE_A)))
        {
            /*
             ? La declaracion del FileWriter, una subclase en la familia de los text wrtiers de Java, permite escribir
             ? texto (strings) directamente desde el programa hacia el archivo. Como pusimos append: true, realiza una 
             ? escritura al final del archivo
            */
            String userInput;
        System.out.println(Colorizer.colorWithYellowLetters("Ingrese lineas de texto para escribir en el archivo. Escriba 'Done' o presione Ctrl+D para finalizar:"));

            int counterOfLinesAdded = ((int) lines.count());
            while (true) {
            //! Esta linea de codigo nos da acceso al numero de lineas que tiene el archivo en base a un Stream de lineas
            //! dada por la clase Files.
            System.out.print(Colorizer.colorWithYellowLetters("Ingrese una linea de texto[ Ctrl + D o Done para salir]: "));
            if (!lectorDeConsola.hasNextLine()) {
                break;
            }
            userInput = lectorDeConsola.nextLine();
            if ("Done".equalsIgnoreCase(userInput)) {
                break;
            }
            //! Como el FileWriter no tiene la capacidad de escribir lineas con formato directo como un PrintWriter,
                //! se utiliza este tipo de declaraciones (anadiendole un lineSeparator) para que el sistema interno
                //! note que se quiere establecer una linea sola, si se quisiera hacer conexiones entre lineas, se deberia
                //! concatenar
            escritorDeArchivos.write(userInput + System.lineSeparator());
            counterOfLinesAdded++;
            System.out.println(Colorizer.colorWithMagentaLetters("Linea agregada al archivo") + " [" + counterOfLinesAdded + "] : " + userInput);
        }
        }catch (IOException ioException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: IOException (archivo no encontrado) " +
                    "fue lanzado en el metodo writeOntoFileUsingScanner(). Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
        }
        finally {
            System.out.println(Colorizer.colorWithYellowLetters("El programa ha finalizado su ejecucion, por tanto" +
                    " el Scanner y FileWriter se han cerrado"));
        }
    }


    /**
     * <body style="color: white">
     * Este metodo se encarga de leer un archivo de texto ubicado en los recursos del proyecto utilizando distintas
     * clases de la libreria estandar de Java para demostrar diferentes formas de trabajar con archivos de texto.
     * 
     * <p>Funcionamiento:</p>
     * <ul>
     *   <li>Inicialmente, se crea un objeto <code>FileReader</code> que permite leer el archivo. Se verifica su
     *   disponibilidad para la lectura usando su metodo <code>ready()</code>.</li>
     *   <li>La lectura inicial es realizada con un <code>BufferedReader</code>, el cual optimiza el proceso de lectura
     *   al agrupar datos en bloques antes de procesarlos, evitando multiples accesos directos al archivo.</li>
     *   <li>Adicionalmente, se usa un <code>LineNumberReader</code> para realizar una lectura similar mientras
     *   preserva y opera con el numero de linea actual.</li>
     *   <li>Finalmente, se demuestra una forma alternativa de trabajar con un archivo completo procesandolo como
     *   una cadena de caracteres con <code>StringReader</code>.</li>
     * </ul>
     * 
     * <p>Clases utilizadas:</p>
     * <ul>
     *   <li><code>FileReader</code>: Facilita la operacion de lectura de caracteres desde un archivo.</li>
     *   <li><code>BufferedReader</code>: Mejora la eficiencia al permitir lecturas por bloques en lugar de operacion
     *   unica por caracter.</li>
     *   <li><code>LineNumberReader</code>: Especificamente diseñado para rastrear el numero de linea actual durante
     *   la lectura.</li>
     *   <li><code>StringReader</code>: Permite trabajar con un string como si fuera un archivo, adecuado para
     *   simulaciones o pruebas.</li>
     *   <li><code>Files</code> y <code>Paths</code>: Utilizados para obtener el contenido completo del archivo como
     *   texto desde un camino especifico en el sistema de archivos.</li>
     * </ul>
     * 
     * <p>Notas importantes:</p>
     * <ul>
     *   <li>El metodo maneja todas las excepciones comunes como <code>FileNotFoundException</code> y
     *   <code>IOException</code>, imprimiendo mensajes relevantes en caso de errores.</li>
     *   <li>Define un intervalo de lectura configurable (<code>skipLines</code>) para alternar las lineas leidas,
     *   demostrando flexibilidad en lectura personalizada.</li>
     *   <li>Usa bloques <code>try-with-resources</code> para garantizar el cierre automatico de los recursos
     *   utilizados.</li>
     * </ul>
     * 
     * </body>
     */
    private static void readSecondFileUsingFileReader(){
        //! Para este ejemplo trabajaremos con un nuevo archivo IOInterfacingPartTwo_B.txt que contiene 100 lineas de
        //! palceholders usados en PowerPoint

        try(
                Scanner scanner = new Scanner(System.in);
                //! Esta linea de codigo crea un File Reader, clase que nos permite leer archivos de texto facilmente.
                //! Para realizar esto, tenemos que darle o el recurso o un nombre del archivo para que este se encarge
                //! de buscar el archivo en el sistema.
                FileReader fileReader = new FileReader(RESOURCE_FILE_B);
                )
        {
            /*
             ? Supongamos que no quiero leer todas las lineas (100 es demasiado), y quiero tener varios saltos.
             */
            if (fileReader.ready()) /*Metodo que indica que el fileReader esta listo para la lectura*/{

                /*
                 ? Al usar este sistema, un BufferedReader nos garantiza eficiencia en la lectura al leer en secciones
                 ? que llenan el Buffer interno en lugar de tener llamadas constantes por cada operacion de read()
                 ? que se reliza en un FileReader.
                 */
                System.out.println(Colorizer.colorWithYellowLetters("Ahora vamos a leer el archivo usando un BufferedReader"));
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                int lineNumber = 0;
                int skipLines = 5;
            
                while ((line = bufferedReader.readLine()) != null) {
                    if (lineNumber % skipLines == 0) {
                        System.out.println("Linea Leida [" + lineNumber + "] : " + line);
                    }
                    lineNumber++;
                }
                bufferedReader.close();
                /*
                 ? Podemos hacer lo mismo a traves de un LineNumberReader, una clase que mantiene el numero de linea
                 ? en el cual se encuentra el lector
                 */
                System.out.println(Colorizer.colorWithYellowLetters("Ahora vamos a leer el archivo usando un LineNumberReader"));
                LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(RESOURCE_FILE_B));
                int totalAmountOfLines = (int) lineNumberReader.lines().count();
                lineNumberReader.close();
                lineNumberReader = new LineNumberReader(new FileReader(RESOURCE_FILE_B));
                lineNumber = 0;
                lineNumberReader.setLineNumber(0);
                while ((line = lineNumberReader.readLine()) != null) {
                    if ((lineNumberReader.getLineNumber() - 1) % skipLines == 0) {
                        System.out.println("Linea Leida [" + (lineNumberReader.getLineNumber() - 1) + "] : " + line);
                    }
                }
                lineNumberReader.close();

                //! Hagamos lo mismo con un simple StringReader
                System.out.println(Colorizer.colorWithYellowLetters("Ahora vamos a leer el archivo usando un StringReader"));
                StringReader stringReader = new StringReader( /*!Para funcionar, un string reader requiere de tener
                                                                    ! una String GENERAL que tenga todo el archivo*/
                        Files.readString( /*! Files.readString permite crear esta string mediante el PATH de un archivo*/
                                Paths.get( /*! Paths.get nos devuelve el PATH de un archivo enviandole una String que represente su ubicacion*/
                                        RESOURCE_FILE_B)));
                BufferedReader bf = new BufferedReader(stringReader);
                while ((line = bf.readLine()) != null) {
                    if (lineNumber % skipLines == 0) {
                        System.out.println("Linea Leida [" + lineNumber + "] : " + line);
                    }
                    lineNumber++;
                }
            }
            else {
                System.out.println(Colorizer.colorWithCyanLetters("Error: El archivo no esta listo para la lectura"));
            }


        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(Colorizer.colorWithCyanLetters("Error: FileNotFoundException (archivo no encontrado) " +
                    "fue lanzado en el metodo readSecondFileUsingFileReader. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(fileNotFoundException);
        } catch (IOException ioException) {
            System.out.println(Colorizer.colorWithCyanLetters("Error: IOException (problemas I/O) " +
                    "fue lanzado en el metodo readSecondFileUsingFileReader. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
        }
    }
}
