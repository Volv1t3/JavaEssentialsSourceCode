package com.evolvlabs.I_JavaLangBasics.IOInterfacing;

import com.evolvlabs.IV_Extras.Colorizer;

import java.io.File;

/**
 * <body style="color: white">>El presente archivo muestra el manejo interno de las clases de java.io.File, cuyo objetivo
 * principal es el manejo de archivos y directorios</body
 */
public class IOInterfacingBasicsPartOne {

    public static void main(String[] args) {
        // Ruta del archivo
        String rutaArchivo = System
                .getProperty("user.home");

        // Crear una instancia de File
        try {
            File archivo = new File(rutaArchivo);

            // Intentar acceder al archivo y usar los métodos informativos
            System.out.println(Colorizer.colorWithYellowLetters("Impresiones Generales sobre la carpeta ingresada"));
            if (archivo.exists()) {
                System.out.println("El archivo existe.");
                System.out.println("Nombre del archivo: "
                        + archivo.getName());
                System.out.println("Ruta absoluta: "
                        + archivo.getAbsolutePath());
                System.out.println("Es un directorio: "
                        + archivo.isDirectory());
                System.out.println("Es un archivo: "
                        + archivo.isFile());
                System.out.println("¿Se puede leer?: "
                        + archivo.canRead());
                System.out.println("¿Se puede escribir?: "
                        + archivo.canWrite());
                System.out.println("¿Es ejecutable?: "
                        + archivo.canExecute());
                System.out.println("Tamaño del archivo (en bytes): "
                        + archivo.length());
                System.out.println("Última modificación: "
                        + archivo.lastModified());
            } else {
                System.out.println("El archivo no "
                        + "existe en la ruta especificada.");
            }

            //! Hacemos llamadas a otros archivos
            System.out.println(Colorizer.colorWithYellowLetters("\nImpresiones sobre los contenidos la carpeta ingresada\n"));
            listarArchivosYDirectorios(archivo);
            System.out.println(Colorizer.colorWithYellowLetters("\nCreando un nuevo directorio en la direccion seleccionada\n"));
            crearDirectorio(rutaArchivo + "/nuevoDirectorio");
        } catch (Exception e) {
            System.err.println("Ocurrió un error " +
                    "al acceder al archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // Listar todos los directorios
    // y archivos en la carpeta del archivo
    public static void listarArchivosYDirectorios(File archivo) {
        if (archivo.isDirectory()) {
            File[] archivos = archivo.listFiles();
            if (archivos != null && archivos.length > 0) {
                System.out.println("Contenido del directorio " +
                        archivo.getName() + ":");
                for (File f : archivos) {
                    System.out.println((f.isDirectory() ?
                            "[Directorio] " : "[Archivo] ")
                            + f.getName());
                }
            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("La ruta especificada " +
                    "no es un directorio.");
        }
    }

    // Renombrar un archivo o directorio
    public static void renombrarArchivo(File archivo, String nuevoNombre) {
        File archivoRenombrado = new
                File(archivo.getParent(), nuevoNombre);
        if (archivo.renameTo(archivoRenombrado)) {
            System.out.println("Archivo renombrado " +
                    "exitosamente a: " + nuevoNombre);
        } else {
            System.out.println("Error al " +
                    "renombrar el archivo.");
        }
    }

    // Crear un nuevo directorio
    public static void crearDirectorio(String rutaDirectorio) {
        File nuevoDirectorio = new File(rutaDirectorio);
        if (nuevoDirectorio.mkdirs()) {
            System.out.println("Directorio " +
                    "creado exitosamente: " + rutaDirectorio);
        } else {
            System.out.println("Error al crear el " +
                    "directorio, posiblemente ya exista.");
        }
    }
}
