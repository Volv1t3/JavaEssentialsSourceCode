package com.evolvlabs.I_JavaLangBasics.IOInterfacing;
import com.evolvlabs.IV_Extras.Colorizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Locale;
import java.util.stream.Stream;

public class IOInterfacingBasicsPartTwo {

    public static void main(String[] args) {
        try {
            // Obtener el directorio del
            // usuario basado en su idioma
            String userHome =
                    System.getProperty("user.home");
            String documentsDir;
            String downloadsDir;

            // Verificar idioma local para usar
            // nombres correctos de carpetas
            if (Locale.getDefault()
                    .getLanguage().equals("es")) {
                documentsDir = Paths.get(userHome,
                        "Documentos").toString();
                downloadsDir = Paths.get(userHome,
                        "Descargas").toString();
            } else {
                documentsDir = Paths.get(userHome,
                        "Documents").toString();
                downloadsDir = Paths.get(userHome,
                        "Downloads").toString(); // inglés
            }

            // Crear objetos Path para los directorios
            Path documentosPath = Paths.get(documentsDir);
            Path descargasPath = Paths.get(downloadsDir);
            Path inicioUsuarioPath = Paths.get(userHome);

            System.out.println(Colorizer.colorWithYellowLetters( "Contenido del directorio de inicio del usuario: " + userHome));
            //! Requiere un archivo creado con una String
            listarContenidoConFile(new File(userHome));
            //! Requiere un Path ya que usa Files (nueva API)
            listarContenidoConFiles(inicioUsuarioPath);

            System.out.println();
            System.out.println(Colorizer.colorWithYellowLetters("Contenido del directorio de Documentos: " + documentsDir));

            listarContenidoConFile(new File(documentsDir));
            listarContenidoConFiles(documentosPath);

            System.out.println();
            System.out.println(Colorizer.colorWithYellowLetters("Contenido del directorio de Descargas: " + downloadsDir));
            listarContenidoConFile(new File(downloadsDir));
            listarContenidoConFiles(descargasPath);

        } catch (Exception e) {
            System.err.println("Ocurrió un error: "
                    + e.getMessage());
        }
    }

    // Listar contenido con la clase java.io.File
    public static void listarContenidoConFile(File directorio) {
        if (directorio.exists() && directorio.isDirectory()) {
            System.out.println(Colorizer.colorWithCyanLetters("*** Usando Java.io.File y Strings ***"));
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    System.out.println((archivo
                            .isDirectory()
                            ? "[Directorio] " : "[Archivo] ")
                            + archivo.getName());
                }
            } else {
                System.out.println("El directorio está"
                        + " vacío o no se puede acceder.");
            }
        } else {
            System.out.println("El directorio" +
                    "  especificado no existe o no es válido.");
        }
    }

    // Listar contenido con la clase java.nio.file.Files
    public static void listarContenidoConFiles(Path directorio) {
        System.out.println(Colorizer.colorWithCyanLetters("*** Usando Java.nio.file.Files y Path ***"));
        try (Stream<Path> paths = Files.list(directorio)) {
            paths.forEach(path -> {
                System.out.println((Files.isDirectory(path)
                        ? "[Directorio] " : "[Archivo] ")
                        + path.getFileName());
            });
        } catch (NoSuchFileException e) {
            System.out.println("El directorio" +
                    " especificado no existe.");
        } catch (IOException e) {
            System.err.println("Error al listar contenido: "
                    + e.getMessage());
        }
    }
}
