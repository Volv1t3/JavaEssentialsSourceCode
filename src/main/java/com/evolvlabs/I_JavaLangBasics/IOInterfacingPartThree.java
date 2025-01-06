package com.evolvlabs.I_JavaLangBasics;

import com.evolvlabs.IV_Extras.Colorizer;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <body style="color: white"> El presente archivo contiene codigo de ejemplo de como trabajar con escritores para archivos
 * de texto, sin entrar a manejo de datos en binario. En esta instancia, vamos a analizar el funcionamiento basico de printWriter,
 * BufferWriter y StringWriter.</body>
 */
public class IOInterfacingPartThree {

    static final String USER_PATH = Paths.get(System.getProperty("user.home"),"Documents","PrintWriterOutput").toString();
    static final Path USER_DIR = Paths.get(USER_PATH);
    private static Scanner scannerInstance = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println(Colorizer.colorWithYellowLetters("Bienvenido a nuestro programa de prueba para archivos de texto!"));
            System.out.println(Colorizer.colorWithYellowLetters("Por favor, selecciona una opcion:"));
            IOInterfacingPartOne.printMenuOption("1. Crear y escribir hacia archiso usando PrintWriter", 
                    "%-80s", "Opcion Numero [1]", "%60s");
            IOInterfacingPartOne.printMenuOption("2. Crear y escribir hacia archivos usando BufferWriter", 
                    "%-80s", "Opcion Numero [2]", "%60s");
            IOInterfacingPartOne.printMenuOption("3. Editar archivos usando StringWriter", 
                    "%-80s", "Opcion Numero [3]", "%60s");
            IOInterfacingPartOne.printMenuOption("4. Salir", "%-80s", 
                    "Opcion Numero [-1]", "%60s");
            System.out.print(Colorizer.colorWithCyanLetters("Ingrese su opcion: "));

            String choice = scannerInstance.nextLine().trim();
            switch (choice) {
                case "1":
                    creatingAndWritingToFileUsingPrintWriter();
                    break;
                case "2":
                    WritingToFilesUsingBufferWriter();
                    break;
                case "3":
                    editingFilesUsingStringWriter();
                    break;
                case "-1":
                    System.out.println(Colorizer.colorWithMagentaLetters("Saliendo del programa..."));
                    return;
                default:
                    System.out.println(Colorizer.colorWithRedLetters("Opcion Incorrecta, favor ingrese una opcion de los numeros indicados"));
            }
        }
    }

    /**
     * <body style="color: white">
     * Este metodo permite la creacion y edicion de archivos de texto en el sistema del usuario.<br>
     * Utiliza una combinacion de varias clases para lograr esta funcionalidad:<br><br>
     * 
     * - {@link java.io.PrintWriter}: Es el escritor principal utilizado para escribir datos al archivo en modo append.<br>
     * - {@link java.io.BufferedReader}: Se utiliza para leer y presentar los datos existentes en el archivo.<br>
     * - {@link java.nio.file.Files}: Ayuda a manejar operaciones del sistema de archivos, como verificar la existencia de directorios
     *   o la creacion de archivos.<br>
     * - {@link java.util.Scanner}: Permite la interaccion con el usuario para ingresar datos o nombres de archivo.<br><br>
     * 
     * Funcionamiento:<br>
     * El metodo trabaja en la carpeta "PrintWriterOutput", que se ubica en los Documentos del usuario. Este lee los archivos mas recientes<br>
     * y permite al usuario seleccionar un archivo para abrirlo en modo append o crear uno nuevo si no existe.<br>
     * Una vez seleccionado, el usuario puede ingresar lineas de texto que se almacenaran en el archivo hasta ingresar el<br>
     * comando especial <code>wq</code> para guardar y cerrar.<br><br>
     * 
     * Manejo de excepciones:<br>
     * - {@link IOException}: Su manejo asegura que problemas relacionados con la entrada y salida del archivo no causen fallos<br>
     *   inesperados. Mensajes de error claros informan al usuario y los errores son extraidos con {@link ExceptionsPartTwo#extractorDeInformacionDeError(Exception)}.<br>
     * - Si ocurre un error critico (como no poder crear un directorio requerido), el programa termina adecuadamente.<br><br>
     * 
     * Interaccion del usuario:<br>
     * El usuario ve una lista de archivos recientes en la carpeta mencionada. Puede elegir abrir un archivo existente o especificar uno nuevo.<br>
     * Los datos ingresados por el usuario se escriben linea por linea hasta que este indique "wq". Si no existen errores, el archivo<br>
     * sera guardado y el nombre se agregara al listado de recientes.<br>
     * 
     * </body>
     */
    private static void creatingAndWritingToFileUsingPrintWriter(){
        //! La idea de este programa es crear archivos y mantener un listado de estos en (arreglo de tres valores), en
        //! los mas recientes para poder trabajar con ellos
        ArrayList<String> mostRecentFiles = new ArrayList<>();

        try
        {
            //? Constantes del usuario: Creamos en esta seccion el directorio para guardar los archivos
            String userLibPath = System.getProperty("user.home");
            String userPath = Paths.get(userLibPath,"Documents","PrintWriterOutput").toString();
            Path dir = Paths.get(userPath);
            if (!Files.exists(dir)){
                Files.createDirectory(dir);
            }
            try (DirectoryStream<Path> paths = Files.newDirectoryStream(dir)){
                for(Path Paths : paths ){
                    if (Files.isRegularFile(Paths)){
                        mostRecentFiles.add(Paths.getFileName().toString());
                    }
                }
            }catch (IOException ioException){
                System.out.println(Colorizer.colorWithCyanLetters("Error: No se pudo crear el directorio que el usuario genero, por tanto salimos del programa."));
                ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
                System.exit(1);
            }


            
            //! Primero armamos una loop para imprimir los archivos mas recientes y solicitar su nombre a los usuarios
            do{
                printRecentFilesRegisteredOnFolder(mostRecentFiles);
                System.out.println("Para empezar, ingresa un nombre de archivo  junto con su extension! [q! para salir]: ");
                String fileName = scannerInstance.nextLine().trim();
                if (fileName.equalsIgnoreCase("q!")){
                    System.out.println(Colorizer.colorWithCyanLetters("Saliendo del programa..."));
                    break;
                }

                String archivo = String.valueOf(Paths.get(userPath, (fileName)));
                Path archivoPath = Paths.get(archivo);
                if (mostRecentFiles.contains(fileName)){
                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("El archivo ingresado ") + fileName +
                            Colorizer.colorWithMagentaLetters(" ya existe, abriendolo en modo append"));
                    System.out.println();

                    //! Intentamos escribir al archivo
                    try (PrintWriter writer = new PrintWriter(new FileWriter(String.valueOf(archivoPath), true));
                         BufferedReader reader = new BufferedReader(new FileReader(archivo))){
                        readFileLinesToTheScreen(scannerInstance, reader);
                        inputerInstance(scannerInstance, writer);
                    }catch (IOException fileNotFoundException){
                        System.out.println(Colorizer.colorWithCyanLetters("Error: No se pudo abrir el archivo que el usuario genero, por tanto salimos del programa."));
                        ExceptionsPartTwo.extractorDeInformacionDeError(fileNotFoundException);
                        System.exit(1);
                    }
                }
                else {
                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("El archivo ingresado ") + fileName +
                            Colorizer.colorWithMagentaLetters(" no existe, creandolo en modo append"));
                    System.out.println();


                    File openedFile = null;
                    try{
                        openedFile = Files.createFile(archivoPath).toFile();
                    }catch (IOException ioException){
                        System.out.println(Colorizer.colorWithCyanLetters("Error: No se pudo crear el archivo que el usuario genero, por tanto salimos del programa."));
                        ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
                        System.exit(1);
                    }


                    try (PrintWriter writer = new PrintWriter(openedFile);
                         BufferedReader reader = new BufferedReader(new FileReader(archivo))){
                        readFileLinesToTheScreen(scannerInstance, reader);
                        inputerInstance(scannerInstance, writer);
                        mostRecentFiles.add(fileName + ".txt");
                    }
                    catch (IOException ioException){
                        System.out.println(Colorizer.colorWithCyanLetters("Error: No se pudo crear el archivo que el usuario genero, por tanto salimos del programa."));
                        ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
                        throw new RuntimeException(ioException);
                    }
                }

            } while(true);
        } catch (IOException e) {
            System.out.println(Colorizer.colorWithRedLetters("Error Lanzado fuera del loop general de escritura. Este error se puede haber dado " +
                    " por la generacion del directorio requerido"));
            ExceptionsPartTwo.extractorDeInformacionDeError(e);
            
        }
    }
    private static void inputerInstance(Scanner scannerInstance, PrintWriter writer) {
        System.out.println("... [wq para salir]");
        do{
            System.out.print("... ");
            String line = scannerInstance.nextLine();
            if (line.equals("wq")) {
                break;
            } else {
                writer.println(line);
            }
        }while (true);
    }
    private static void readFileLinesToTheScreen(Scanner scannerInstance, BufferedReader reader ){
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println("... " + line);
            }
        } catch (IOException ioException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: Error de lectura en metodo readFileLinesToTheScreen, no se pudo leer la seccion anterior " +
                    " del archivo"));
            ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
        }
    }


    /**
     * <body style="color: white">
     * Este metodo permite al usuario abrir un archivo existente y agregar contenido adicional al mismo sin borrar datos previos.<br>
     * El funcionamiento principal utiliza las clases siguientes y sus capacidades:<br><br>
     *
     * - {@link java.nio.file.Files}: Ayuda a crear el {@link BufferedWriter} requerido para escribir en los archivos, ademas asegura<br>
     *   que el archivo pueda ser abierto en modo append.<br>
     * - {@link java.io.BufferedReader}: Se utiliza para mostrar el contenido existente del archivo antes de agregar nuevas lineas.<br>
     * - {@link java.nio.file.Path}: Representa las ubicaciones de los archivos y directorios utilizados.<br>
     * - {@link java.util.Scanner}: Permite la interaccion con el usuario para recibir informacion de entrada.<br><br>
     *
     * Funcionamiento:<br>
     * Este metodo opera en la carpeta "PrintWriterOutput" ubicada en Documentos.<br>
     * Lista los archivos recientes en la carpeta y permite al usuario elegir uno.<br>
     * El usuario agrega las lineas deseadas al archivo hasta que se ingrese el comando especial <code>wq</code>, que guarda y cierra.<br><br>
     *
     * Manejo de excepciones:<br>
     * - {@link IOException}: Se maneja en multiples bloques <code>try-catch</code> para prevenir fallos relacionados con el sistema<br>
     *   de archivos. Cuando ocurre un error, un mensaje claro explica la situacion y los detalles del error se extraen usando<br>
     *   {@link ExceptionsPartTwo#extractorDeInformacionDeError(Exception)}.<br>
     * - Casos criticos como la falta de directorios o fallos durante la escritura resultan en la salida del programa con un mensaje apropiado.<br><br>
     *
     * Interaccion del usuario:<br>
     * Si no hay archivos recientes, se cierra el programa con un mensaje. Si el nombre del archivo ingresado no coincide con ninguno<br>
     * de los archivos en la carpeta, se notifica al usuario que debe crearlo con otro metodo disponible.<br>
     * El usuario visualiza el contenido del archivo seleccionado antes de ingresar nuevas lineas.<br><br>
     *
     * </body>
     */
    private static void WritingToFilesUsingBufferWriter(){
        //! Parecido a createAndWritingToFileUsingPrintWriter vamos a modificar solo archivos ya creados, si no existen
        //! se le comunica al usuario para que realize la creacion en el primer metodo

        try
        {
            //! Dentro del Try Reusamos el codigo del primer metodo para mostrar los archivos dentro del sistema
            ArrayList<String> mostRecentFiles = new ArrayList<>();
            try {
                if (!Files.exists(USER_DIR)){
                    Files.createDirectory(USER_DIR);
                }
                try (DirectoryStream<Path> paths = Files.newDirectoryStream(USER_DIR)) {
                    for (Path Paths : paths) {
                        if (Files.isRegularFile(Paths)) {
                            mostRecentFiles.add(Paths.getFileName().toString());
                        }
                    }
                }
            }
            catch (IOException ioException){
                System.out.println(Colorizer.colorWithCyanLetters("Error: No se pudo crear el directorio que el usuario genero, por tanto salimos del programa."));
                ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
                System.exit(1);
            }



            //! Primero armamos una loop para imprimir los archivos mas recientes y solicitar su nombre a los usuarios
            String userSelection;
            do{
                System.out.println(Colorizer.colorWithYellowLetters("Bienvenido a nuestro editor de archivos .java"));
                System.out.println("Si existe un archivo en la carpeta predefinida, lo podras editar. De lo contrario el programa se cerrara.");
                if (mostRecentFiles.isEmpty()){
                    System.out.println(Colorizer.colorWithRedLetters("No hay archivos recientes, saliendo del programa..."));
                    break;
                }else {
                    printRecentFilesRegisteredOnFolder(mostRecentFiles);
                }

                //! Receptamos user input para editar el archivo
                System.out.println("Ingrese el nombre del archivo que desea editar con su nombre y extension! [q! para salir]: ");
                userSelection = scannerInstance.nextLine().trim();
                if (userSelection.equalsIgnoreCase("q!")){
                    System.out.println(Colorizer.colorWithCyanLetters("Saliendo del programa..."));
                    break;
                }
                String fileName = userSelection;
                String archivo = String.valueOf(Paths.get(USER_PATH, fileName));

                //! Buscamos el archivo, si no esta entonces salimos con un mensaje que tiene que correr el metodo uno
                if (mostRecentFiles.contains(fileName)){
                    //! El archivo existe, imprimimos mensaje y abrimos
                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("El archivo ingresado ") + userSelection +
                            Colorizer.colorWithMagentaLetters(" ya existe, abriendolo en modo append"));
                    System.out.println();
                    Path filePath = Paths.get(archivo);
                    try (BufferedWriter writer = Files.newBufferedWriter( /*La clase Files nos permite generar un BufferedWriter directamente*/
                            filePath, /*Toma el archivo con su PATH*/
                            StandardOpenOption.APPEND) /*Declara que el archivo debe ser APPEND, es decir no borra el contenido anterior*/){
                        System.out.println("... [wq para salir]");
                        readFileLinesToTheScreen(scannerInstance, new BufferedReader(new FileReader(filePath.toString())));
                        do{
                            System.out.print("... ");
                            String line = scannerInstance.nextLine();
                            if (line.equals("wq")) {
                                break;
                            } else {
                                writer.write(line);
                                writer.newLine();
                            }
                        }while (true);
                    }catch (IOException ioException){
                        System.out.println(Colorizer.colorWithCyanLetters("Error: No se pudo abrir el archivo que el usuario genero, por tanto salimos del programa."));
                        ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
                        System.exit(1);
                    }
                }else {
                    System.out.println();
                    System.out.println(Colorizer.colorWithMagentaLetters("El archivo ingresado ") + userSelection +
                            Colorizer.colorWithMagentaLetters(" no existe. Saliendo del programa... "));
                    System.out.println();
                    break;
                }

            }
            while (!userSelection.equalsIgnoreCase("q!"));


        } finally{
            System.out.println(Colorizer.colorWithYellowLetters("Bloque Finally para primer try-with-resources ejecutado. Ha llegado al final de la ejecucion de")
            + " WritingToFilesUsingBufferWriter" );
        }
    }
    private static void printRecentFilesRegisteredOnFolder(ArrayList<String> mostRecentFiles) {
        System.out.println("Most recent files: ");
        System.out.print("[");

        if (!mostRecentFiles.isEmpty()) {
            for (String file : mostRecentFiles) {
                System.out.print(" " + file + " , ");
            }
        } else {
            System.out.print(" No hay archivos recientes ");
        }
        System.out.println("]");
    }
    
    
    /**
     * <body style="color: white">
     * Este metodo permite al usuario editar archivos existentes y modificar su contenido linea por linea.<br><br>
     *
     * - {@link java.io.FileReader}: Se utiliza en conjunto con {@link java.io.LineNumberReader} para leer cada linea,<br>
     *   presentando el contenido actual al usuario y permitiendo cambios.<br>
     * - {@link java.io.StringWriter}: Se usa como buffer temporal de los cambios realizados antes de guardarlos en el archivo original.<br>
     * - {@link java.nio.file.Files}: Ayuda a crear archivos temporales y reemplazar el archivo original con los cambios realizados.<br>
     * - {@link java.util.Scanner}: Facilita la interaccion con el usuario para recibir comandos y nuevos contenidos.<br><br>
     *
     * Funcionamiento:<br>
     * El metodo lista los archivos disponibles en la carpeta "PrintWriterOutput" del sistema y permite al usuario seleccionar uno.<br>
     * El usuario puede elegir editar el archivo en modo "append" (agregar al final) o "replace" (reemplazar una linea completa).<br>
     * Linea por linea, el usuario ve el contenido y puede modificarlo o mantenerlo igual.<br><br>
     *
     * Comandos soportados:<br>
     * - ":a" - Cambia al modo "append", para agregar contenido al final de cada linea.<br>
     * - ":r" - Cambia al modo "replace", para reemplazar una linea completa.<br>
     * - ":c" - Cambiar modo de edicion durante la operacion.<br>
     * - ":wq" - Guarda los cambios y sale del programa.<br>
     * - ":q!" - Sale sin guardar cambios.<br><br>
     *
     * Manejo de excepciones:<br>
     * - {@link java.io.IOException}: Se manejan errores de lectura/escritura mediante mensajes claros, y se utiliza {@link ExceptionsPartTwo#extractorDeInformacionDeError(Exception)}<br>
     *   para extraer detalles del error.<br><br>
     *
     * Interaccion del usuario:<br>
     * Si el archivo solicitado no existe, el programa informa al usuario y finaliza.<br>
     * Todas las modificaciones se almacenan temporalmente en memoria usando {@link StringWriter}.<br>
     * Al guardar exitosamente, los cambios se escriben al archivo original reemplazando su contenido.<br><br>
     * </body>
     */
    private static void editingFilesUsingStringWriter(){
        //! En este metodo, al igual que en WritingToFilesUsingBufferWriter vamos a permitir al usuario editar archivos que ya
        //! han sido creados y estan dentro de la carpeta de trabajo, si no exsten entonces el programa no continua su ejecucion.

        /*
         ? Para trabajar, el metodo imprime cada linea y la sobreescribe dentro del archivo
         */

        try {
            //! Base check existe la carpeta
            if (Files.exists(Path.of(USER_PATH))){
                String userInput;
                do{
                    //! Receptamos user input
                    System.out.println(Colorizer.colorWithYellowLetters("Bienvenido a nuestro editor de archivos .java"));
                    System.out.println(Colorizer.colorWithCyanLetters("Ahora con edicion linea por linea!"));
                    System.out.println("Ingrese el nombre del archivo que desea editar con su nombre y extension! [q! para salir]: ");

                    //! Leemos los archivos del directory
                    ArrayList<String> mostRecentFiles = new ArrayList<>();
                    try {
                        try (DirectoryStream<Path> paths = Files.newDirectoryStream(USER_DIR)) {
                            for (Path Paths : paths) {
                                if (Files.isRegularFile(Paths)) {
                                    mostRecentFiles.add(Paths.getFileName().toString());
                                }
                            }
                        }
                    }
                    catch (IOException ioException){
                        System.out.println(Colorizer.colorWithCyanLetters("Error: No se pudo crear el directorio que el usuario genero, por tanto salimos del programa."));
                        ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
                        System.exit(1);
                    }

                    printRecentFilesRegisteredOnFolder(mostRecentFiles);
                    System.out.print("Su eleccion: ");
                    userInput = scannerInstance.nextLine().trim();
                    System.out.println();

                    if (mostRecentFiles.contains(userInput)){
                        Path originalFilePath = Paths.get(USER_PATH, userInput);
                        Path tempFile = Files.createTempFile("temp_", "_edit");
                        //! Esta linea nos permite crear archivos copiando el contenido anterior
                        Files.copy(originalFilePath, tempFile, StandardCopyOption.REPLACE_EXISTING);
                        //! Abrimos el archivo como un lector
                        try(
                                LineNumberReader numberedReader =
                                        new LineNumberReader(
                                        new BufferedReader(
                                                new FileReader(tempFile.toFile())));
                                StringWriter stringWriter = new StringWriter();
                        )
                        {
                            //! Para editar imprimimos un mensaje y manejamos la lectura de los contenidos del archivo con un lineNUmberReader de la copia del archivo
                            //! Introduce command mode (append / replace) and editing logic
                            System.out.println(Colorizer.colorWithYellowLetters("El archivo ingresado ") + userInput +
                                    Colorizer.colorWithYellowLetters(" ya existe, abriendolo en modo de edicion."));
                            System.out.println("\nComandos disponibles:");
                            System.out.println(":a  - Anadir contenido al final de la linea");
                            System.out.println(":r  - Remplazar una  linea entera");
                            System.out.println(":wq - Guardar y salir");
                            System.out.println(":q! - Salir sin guardar\n");
                            String readLine = numberedReader.readLine();
                            String workMode = ":a";
                            System.out.println(Colorizer.colorWithRedLetters("[Antes de continuar determine el modo de trabajo :a para hacer APPEND al final del archivo" +
                                    " o :r para hacer REPLACE a toda la linea"));
                            System.out.print("... ");
                            workMode = scannerInstance.nextLine().trim();
                            do{
                                if (!workMode.matches(":[ar]")){
                                    System.out.println(Colorizer.colorWithRedLetters("Modo de trabajo no valido, por favor, ingrese un modo de trabajo valido"));
                                    System.out.print("... ");
                                    workMode = scannerInstance.nextLine().trim();
                                }
                                else {
                                    break;
                                }
                            }
                            while (true);
                            System.out.println(Colorizer.colorWithYellowLetters("Durante ejecucion, podra ingresar comandos al ingresar :c\n"));
                            do {
                                if (readLine == null){
                                    System.out.println("Se ha llegado al final del archivo ingrese el comando para guardar: ");
                                }
                                else {
                                    System.out.print("[ " + numberedReader.getLineNumber() + " | " +
                                            (workMode.equalsIgnoreCase(":a") ? "APPEND" : "REPLACE")+ " ]... " + readLine +" ");
                                }
                                //! Read user input
                                String line = scannerInstance.nextLine();
                                switch (line) {
                                    case ":c":
                                        //! Guardamos la posicion anterior
                                        int prevPosition = numberedReader.getLineNumber();
                                        //! Imprimimos mensajes y registramos contenido
                                        System.out.println();
                                        System.out.println("Esta es una nueva linea temporal para tus comandos.");
                                        System.out.print("> ");
                                        String tempCommand = scannerInstance.nextLine();

                                        if (!tempCommand.matches(":[ar]")){
                                           System.out.println("Commando desconocido...");
                                           numberedReader.setLineNumber(prevPosition - 1);
                                       }
                                       else {
                                           workMode = tempCommand;
                                           System.out.println("Cambiado a modo " + (workMode.equals(":a") ? "APPEND" : "REPLACE") + ".");
                                           numberedReader.setLineNumber(prevPosition - 1);
                                       }
                                       break;
                                    case ":a":
                                        workMode = ":a";
                                        System.out.println("Cambiado a modo APPEND.");
                                        break;
                                    case ":r":
                                        workMode = ":r";
                                        System.out.println("Cambiado a modo REPLACE.");
                                        break;
                                    case ":wq":
                                        try (BufferedWriter writer = Files.newBufferedWriter(originalFilePath)) {
                                            writer.write(stringWriter.toString());
                                            System.out.println("Cambios guardados exitosamente.");
                                        }
                                        return;
                                    case ":q!":
                                        System.out.println("Cambios descartados. Saliendo...");
                                        return;
                                    default:
                                        if (workMode.equals(":a")) {
                                            stringWriter.write(readLine + line);
                                            stringWriter.write(System.lineSeparator());
                                        } else if (workMode.equals(":r")) {
                                            if (readLine != null && line.isEmpty()){
                                                stringWriter.write(readLine);
                                                stringWriter.write(System.lineSeparator());
                                            }
                                            else if (line.isBlank()){
                                                stringWriter.write(line);
                                                stringWriter.write(System.lineSeparator());
                                            }
                                            else {
                                                stringWriter.write(line);
                                                stringWriter.write(System.lineSeparator());
                                            }
                                        }
                                }
                                readLine = numberedReader.readLine();
                            } while(true);
                        }
                        finally {
                            System.out.println(Colorizer.colorWithYellowLetters("Bloque Finally para primer try-with-resources ejecutado. Ha llegado al final de la ejecucion de")
                                    + " EditingFilesUsingStringWriter" );
                            Files.delete(tempFile);
                        }
                    }else {
                        System.out.println(Colorizer.colorWithRedLetters("El archivo ingresado no existe, saliendo del programa..."));
                        break;
                    }
                }while (userInput.equalsIgnoreCase("q!"));
            }else {
                System.out.println(Colorizer.colorWithRedLetters("No existe la carpeta base, saliendo del programa..."));
            }
        }catch(IOException ioException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: Un error de I/O fue lanzado dentro del programa. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
            ioException.printStackTrace();
            System.exit(1);
        }


    }
    private static void saveToFile(Path originalFile, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(originalFile)) {
            writer.write(content); // Write the accumulated content to the original file
            System.out.println("Changes saved to the file: " + originalFile.getFileName());
        } catch (IOException e) {
            System.out.println("Failed to save changes:");
            e.printStackTrace();
        }
    }
}
