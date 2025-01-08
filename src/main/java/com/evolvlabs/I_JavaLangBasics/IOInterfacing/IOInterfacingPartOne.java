package com.evolvlabs.I_JavaLangBasics.IOInterfacing;

import com.evolvlabs.IV_Extras.Colorizer;
import com.evolvlabs.I_JavaLangBasics.Exceptions.ExceptionsPartTwo;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * <body style="color: white">El presente archivo muestra el funcionamiento de la mayoria de las clases helper que existen
 * para trabajar con archivos en Java. En este sentido, se analiza la clase de Paths, Path, Files, URI, etc.</body>
 */
public class IOInterfacingPartOne {

    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            int userInput;
            do {
                System.out.println(Colorizer.colorWithCyanLetters("Bienvenido a nuestro programa para Manejar Directorios"));
                System.out.println();
                String menuOptionFormat = "%-80s";
                String menuOptionNumberFormat = "%60s";
                printMenuOption("Manejo De Directorios I...", menuOptionFormat, "Opcion Numero 1", menuOptionNumberFormat);
                printMenuOption("Manejo De Directorios II...", menuOptionFormat, "Opcion Numero 2", menuOptionNumberFormat);
                printMenuOption("Manejo de Directorios III...", menuOptionFormat, "Opcion Numero 3", menuOptionNumberFormat);
                printMenuOption("Crear Archivos I...", menuOptionFormat, "Opcion Numero 4", menuOptionNumberFormat);
                printMenuOption("Salir Del Programa...", menuOptionFormat, "Opcion Numero -1", menuOptionNumberFormat);


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
                        listingFilesInThisDirectory();
                        break;
                    case 2:
                        listingFilesInUsersDocumentsDirectory();
                        break;
                    case 3:
                        listingFileInformationFromUserInput(scanner);
                        break;
                    case 4:
                        createFileInUsersDocumentsDirectory();
                        break;
                    case -1:
                        System.out.println(Colorizer.colorWithYellowLetters("Saliendo del programa..."));
                        break;
                    default:
                        System.out.println(Colorizer.colorWithYellowLetters("Opcion no valida, por favor, ingrese una opcion del menu anterior"));
                        break;
                }
            } while (userInput != -1);
        }
    }

   public static void printMenuOption(String menuOptionName, String menuOptionFormat, String menuOptionNumber, String menuOptionNumberFormat){
       System.out.println(String.format(menuOptionFormat, Colorizer.colorWithYellowLetters(menuOptionName))
               + String.format(menuOptionNumberFormat, Colorizer.colorWithCyanLetters(menuOptionNumber)));
   }


    /**
     * <body style="color: white">
     * Este metodo lista todos los archivos presentes en la carpeta especificada.<br><br>
     * Utiliza la clase {@link java.nio.file.Files} para establecer un {@link java.nio.file.DirectoryStream}, y 
     * itera sobre cada archivo dentro de este directorio.<br><br>
     * Por cada archivo, imprime detalles como el nombre del archivo, ruta absoluta, ruta relativa y hasta
     * las primeras cinco lineas del archivo utilizando el metodo {@link java.nio.file.Files#lines(Path)}.<br><br>
     * Maneja las siguientes excepciones:<br>
     * - {@link IOException}: Si ocurre un error al leer el archivo o directorio. Esto es manejado 
     * dentro de un bloque catch.<br>
     * - {@link NullPointerException}: Si algun archivo dentro del stream es nulo. Esto tambien es manejado en un bloque catch.<br><br>
     * Ambas excepciones son resueltas mostrando un mensaje en la consola y extrayendo mas informacion 
     * del error usando el metodo personalizado {@link ExceptionsPartTwo#extractorDeInformacionDeError(Exception)}.<br>
     * </body>
     */
    private static void listingFilesInThisDirectory(){
       try(
               //! Este metodo genera un DirectoryStream, un flujo de datos que permite usar forEach para su analisis
               DirectoryStream<Path> streamOfFolder =
                       Files /*La clase Files presenta varios metodos estaticos para manejo de archivos y directorios*/
                               .newDirectoryStream(
                                       Path.of( /*La clase Path tiene metodos estaticos para resolver ubicaciones en el sistema operativo*/
                                               "src/main/java/com/evolvlabs/I_JavaLangBasics"))
               ){
                for(Path entryFile: streamOfFolder){
                    System.out.println(Colorizer.colorWithYellowLetters("Nombre Del Archivo: ") + entryFile.getFileName());
                    System.out.println(Colorizer.colorWithYellowLetters("\t\tRuta Absoluta del Archivo: ") + entryFile.toAbsolutePath());
                    System.out.println(Colorizer.colorWithYellowLetters("\t\tRuta Relativa del Archivo: ") + entryFile.toUri());
                }
       } catch (IOException e) {
           System.out.println(Colorizer.colorWithCyanLetters("Error: IOException (archivo no encontrado) " +
                   "fue lanzado en el metodo listingFilesInThisDirectory. Solucionado con un catch"));
           ExceptionsPartTwo.extractorDeInformacionDeError(e);
       } catch (NullPointerException e ){
           System.out.println(Colorizer.colorWithCyanLetters("Error: NullPointerException (archivo vacio) " +
                   "fue lanzado en el metodo listingFilesInThisDirectory. Solucionado con un catch"));
           ExceptionsPartTwo.extractorDeInformacionDeError(e);
       }
    }
    
    
    
    /**
     * <body style="color: white">
     * Este metodo recorre el directorio de documentos del usuario y lista todos los elementos contenido en el.<br><br>
     * Utiliza la clase {@link java.nio.file.Files} para establecer un {@link java.nio.file.DirectoryStream}, lo que permite 
     * iterar sobre los archivos y carpetas presentes.<br><br>
     * Por cada elemento encontrado, se imprime:<br>
     * - Nombre del archivo o carpeta<br>
     * - Si el elemento es una carpeta mediante el metodo {@link Files#isDirectory(Path, LinkOption...)}<br>
     * - Si el elemento es un archivo usando el metodo {@link java.nio.file.Files#isRegularFile(Path, LinkOption...)}<br>
     * - Ruta absoluta y ruta relativa del elemento<br><br>
     * Maneja y resuelve las siguientes excepciones:<br>
     * - {@link IOException}: Ocurre si el directorio no existe o hay un problema al accederlo; se captura para mostrar un mensaje de error.<br>
     * - {@link NullPointerException}: Puede ocurrir si algun archivo o carpeta en el flujo es nulo; tambien es gestionado con un mensaje.<br><br>
     * En ambos casos, la informacion del error es extraida usando {@link ExceptionsPartTwo#extractorDeInformacionDeError(Exception)}.
     * </body>
     */
    private static void listingFilesInUsersDocumentsDirectory(){
       try(
               //! Obtiene el directorio de documentos del usuario a través de la propiedad del sistema del SO
               DirectoryStream<Path> userDocumentsStream =
                       Files.newDirectoryStream( /*Determina si usar 'Documents' o
                       'Documentos' basado en el idioma del sistema operativo*/
                               Path.of(System.getProperty("user.home"),
                                       System.getProperty("user.language").equalsIgnoreCase("es") ? "Documentos" : "Documents"))
               /*! La manera de Path.of anterior permite concatenar, abstrayendo la formacion de un URI dandole solo los nombres de las carpetas
                 ! a las que tiene que entrar*/
       ){
           for(Path fileOrFolder: userDocumentsStream){
               System.out.println(Colorizer.colorWithYellowLetters("Nombre del Archivo: ") + fileOrFolder.getFileName());
               System.out.println(Colorizer.colorWithYellowLetters("\t\tEs carpeta: ") + Files.isDirectory(fileOrFolder,
                       LinkOption.NOFOLLOW_LINKS));
               System.out.println(Colorizer.colorWithYellowLetters("\t\tEs archivo: ") + Files.isRegularFile(fileOrFolder));
               System.out.println(Colorizer.colorWithYellowLetters("\t\tRuta Absoluta: ") + fileOrFolder.toAbsolutePath());
               System.out.println(Colorizer.colorWithYellowLetters("\t\tRuta Relativa: ") + fileOrFolder.toUri());
           }
       } catch (IOException e) {
           System.out.println(Colorizer.colorWithCyanLetters("Error: IOException (archivo no encontrado o inaccesible) " +
                   "fue lanzado en el metodo listingFilesInUsersDocumentsDirectory. Solucionado con un catch"));
           ExceptionsPartTwo.extractorDeInformacionDeError(e);
       } catch (NullPointerException e ){
           System.out.println(Colorizer.colorWithCyanLetters("Error: NullPointerException (archivo vacio) " +
                   "fue lanzado en el metodo listingFilesInUsersDocumentsDirectory. Solucionado con un catch"));
           ExceptionsPartTwo.extractorDeInformacionDeError(e);
       }
        
    }
    /**
     * <body style="color: white">
     * Este metodo acepta una ruta especifica hacia un archivo o directorio e imprime diversas características de
     * ese archivo, como:<br>
     * - Si el archivo es legible, escribible, ejecutable (permisos).<br>
     * - Tamano del archivo en bytes.<br>
     * - Ultima fecha y hora de modificacion, utilizando {@link java.nio.file.Files#getLastModifiedTime(Path, LinkOption...)}.<br>
     * - Validaciones como si el archivo o directorio existe, si es un archivo o una carpeta.<br><br>
     *  Utiliza explicitamente las clases {@link java.nio.file.Path}, {@link java.nio.file.Files} y {@link java.net.URI}.<br>
     *  Tambien demuestra cómo convertir un {@code URI} a un {@code Path} con el metodo {@link Path#of(URI)} (opcional).
     * <br><br>
     * Este metodo maneja excepciones relacionadas como:<br>
     * - {@link java.nio.file.NoSuchFileException}: Cuando el archivo o carpeta solicitada no existe.<br>
     * - {@link java.nio.file.InvalidPathException}: Cuando la ruta del archivo no es valida.<br>
     * - {@link IOException}: Cuando un problema de entrada/salida ocurre.<br>
     * </body>
     */
    private static void listingFileInformationFromUserInput(Scanner scannerInstance){

        try
        {
            scannerInstance.nextLine();
            do{
                System.out.print(Colorizer.colorWithYellowLetters("Ingrese una direccion (archivo o carpeta) dentro de tu dispositivo [Done para salir]: "));
                String userInput = scannerInstance.nextLine().trim();
                if ("Done".equalsIgnoreCase(userInput)) {
                    break;
                }
                
                //! Analizemos la entrada de valores
                try {
                    Path filePath = null;
                    Path userHomeDir = Path.of(System.getProperty("user.home"));
                    //! Busqueda general en todos los archivos del user.home para intentar encontrar el nombre ingresado
                    try (DirectoryStream<Path> userDirectories = Files.newDirectoryStream(userHomeDir)) {
                        for (Path path : userDirectories) {
                            if (path.getFileName().toString().equalsIgnoreCase(userInput)) {
                                filePath = path;
                                break;
                            }
                        }
                    }

                    // Si la entrada de usuario es corta y no contiene diagonales, podria ser solo un nombre de archivo
                    if (filePath == null) {
                        System.out.println(Colorizer.colorWithCyanLetters("Buscando en los subdirectorios del directorio base... Esto podría tardar un poco."));
                        try (DirectoryStream<Path> deepStream = Files.newDirectoryStream(userHomeDir)) {
                            for (Path path : deepStream) {
                                if (Files.isDirectory(path)) {
                                    Path possibleMatch = path.resolve(userInput);
                                    if (Files.exists(possibleMatch)) {
                                        filePath = possibleMatch;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                
                    // Si no fue encontrado de esa manera, intenta analizarlo como URI
                    if (filePath == null) {
                        try {
                            filePath = Path.of(userInput); // Convierte el URI a Path
                            System.out.println(Colorizer.colorWithCyanLetters("El URI convertido a path es: ") + filePath);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(Colorizer.colorWithYellowLetters("La entrada no parece ser un URI. Continuando con otras verificaciones."));
                        }
                    }
                
                    // Si se encontro una ruta valida, imprime detalles del archivo/carpeta
                    if (filePath != null && Files.exists(filePath)) {
                        System.out.println(Colorizer.colorWithYellowLetters("Archivo encontrado: ") + filePath);
                        System.out.println(Colorizer.colorWithYellowLetters("Es legible: ") + Files.isReadable(filePath));
                        System.out.println(Colorizer.colorWithYellowLetters("Es escribible: ") + Files.isWritable(filePath));
                        System.out.println(Colorizer.colorWithYellowLetters("Es ejecutable: ") + Files.isExecutable(filePath));
                        System.out.println(Colorizer.colorWithYellowLetters("Tamano del archivo (en bytes): ") + Files.size(filePath));
                        System.out.println(Colorizer.colorWithYellowLetters("Ultima modificacion: ") + Files.getLastModifiedTime(filePath));
                    } else {
                        System.out.println(Colorizer.colorWithRedLetters("No se pudo localizar un archivo o carpeta valido con la entrada proporcionada."));
                    }
                } catch (IOException ioException) {
                    System.out.println(Colorizer.colorWithCyanLetters("Error: IOException al intentar localizar la entrada del usuario. Solucionado con un catch."));
                    ExceptionsPartTwo.extractorDeInformacionDeError(ioException);
                } catch (SecurityException | IllegalArgumentException exception) {
                    System.out.println(Colorizer.colorWithRedLetters("Error: Permisos insuficientes o entrada no valida al manejar la ruta / URI."));
                    ExceptionsPartTwo.extractorDeInformacionDeError(exception);
                }

            } while(true);
        }
        /*Manejo de Excepciones externas para Scanner Errors*/
        catch (InputMismatchException inputMismatchException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: InputMismatchException (entrada de datos no valida) " +
                    "fue lanzado en el metodo listingFileInformationFromUserInput. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(inputMismatchException);
        }
        catch(NoSuchElementException noSuchElementException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: NoSuchElementException (entrada de datos no valida. Esta opcion no sirve para salir de esta opcion" +
                    " del menu) " +
                    "fue lanzado en el metodo listingFileInformationFromUserInput. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(noSuchElementException);
        } catch(IllegalStateException illegalStateException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: IllegalStateException (Scanner cerrado incorrectamente) " +
                    "fue lanzado en el metodo listingFileInformationFromUserInput. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(illegalStateException);
        }


    }

    
    
    /**
     * <body style="color: white">
     * Este metodo permite al usuario crear archivos de texto dentro del directorio de Documentos en su dispositivo.<br><br>
     * Al ejecutarse, toma el nombre del archivo como entrada desde la consola, verifica si el archivo ya existe, y en caso de que no exista,
     * lo crea utilizando la clase {@link java.nio.file.Files}.<br><br>
     * Cada archivo se crea con la extension ".txt" y se guarda en el directorio "Documents" del usuario.<br><br>
     * El método maneja las siguientes excepciones:<br>
     * - {@link IOException}: Lanzada si ocurre un problema mientras se crea el archivo o se accede al sistema de archivos.<br>
     * - {@link SecurityException}: Lanzada si la aplicacion no tiene los permisos adecuados para acceder al directorio "Documents" o crear el archivo.<br><br>
     * La clase {@link Path} se usa para manejar las rutas y combinar los nombres de las carpetas y el nombre del archivo proporcionado por el usuario.<br>
     * En caso de cualquier excepcion, se muestra un mensaje en la consola y se usa {@link ExceptionsPartTwo#extractorDeInformacionDeError(Exception)}
     * para extraer y mostrar detalles adicionales del error.
     * </body>
     */
    private static void createFileInUsersDocumentsDirectory(){
        //! En este archivo vamos a crear nuestros propios archivos de texto en la carpeta de documentos
        Scanner scannerInstance = new Scanner(System.in);
        try
        {
          //! Primero tomemos la direccion del home del usuario
          String usersHomeDirectory = System.getProperty("user.home");
    
          //! Ahora enchufemos nuestra aplicacion a esta zona luego de pedirle el nombre del archivo al usuario
            do {
                System.out.println( Colorizer.colorWithYellowLetters("Ingrese el nombre del archivo que desea crear en la carpeta de documentos [Done para salir]: "));
                String userInput = scannerInstance.nextLine().trim();
                if("Done".equalsIgnoreCase(userInput)){
                    break;
                }
                Path filePath = Path.of(usersHomeDirectory, "Documents", userInput);
                if(!Files.exists(filePath)){
                    Files.createFile(filePath);
                    System.out.println(Colorizer.colorWithYellowLetters("Archivo creado exitosamente en la ruta: ") + filePath.toAbsolutePath());
                } else {
                    System.out.println(Colorizer.colorWithRedLetters("El archivo ya existe en la ruta: ") + filePath.toAbsolutePath());
                }
            } while (true);
    
        } catch (IOException e) {
            System.out.println(Colorizer.colorWithCyanLetters("Error: IOException al intentar crear el archivo. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(e);
    
        }
        catch (SecurityException securityException){
            System.out.println(Colorizer.colorWithCyanLetters("Error: SecurityException al intentar crear el archivo. Solucionado con un catch"));
            ExceptionsPartTwo.extractorDeInformacionDeError(securityException);
        }
    }
}
