package com.evolvlabs.I_JavaLangBasics.IOInterfacing;

import com.evolvlabs.IV_Extras.Colorizer;

import java.io.IOException;
import java.nio.file.*;
import java.io.*;

/**
 * <body style="color: white">El presente archivo muestra el uso de la jerarquia de la clase writer para escribir un archivo
 * en la carpeta de recursos del sistema.</body>
 */
public class IOInterfacingBasicsPartThree {

    public static void main(String[] args) {
        // Ruta del archivo que será creado
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos a nuestro programa de prueba para los Writers "
        +"!"));
        Path rutaArchivo = Paths.get("src/main/resources","ejemplo_escritura.txt");

        // Intentar crear el archivo
        try {
            if (!Files.exists(rutaArchivo)) {
                Files.createFile(rutaArchivo);
                System.out.println("Archivo creado exitosamente: " + rutaArchivo.toString());
            } else {

                new FileWriter(rutaArchivo.toFile(), false).close(); // Clear the file contents if it exists
                System.out.println("El archivo ya existe: " + rutaArchivo.toString());
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
            return;
        }

        // Verificar si el archivo existe antes de trabajar con él
        if (Files.exists(rutaArchivo)) {
            // Escribir datos al archivo utilizando diferentes Writers
            try (FileWriter fileWriter = new FileWriter(rutaArchivo.toFile(), true);
                 PrintWriter printWriter = new PrintWriter(new FileWriter(rutaArchivo.toFile(), true));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaArchivo.toFile(), true))) {

                // Mensajes informativos y escritura con FileWriter
                fileWriter.write("Escribiendo con FileWriter: [");
                for (int i = 0; i < 10; i++) {
                    fileWriter.write(i + (i < 9 ? ", " : "]\n"));
                }
                fileWriter.write("Informacion sobre la JVM:\r\n");
                fileWriter.write("Fabricante del JVM: " + System.getProperty("java.vendor") + System.lineSeparator());
                fileWriter.write("Version del JVM: " + System.getProperty("java.version") + "\n");
                fileWriter.write("Nombre del JVM: " + System.getProperty("java.vm.name") + "\r\n\n");
                

                // Mensajes informativos y escritura con PrintWriter
                printWriter.print("Escribiendo con PrintWriter: ");
                printWriter.print("[");
                for (int i = 0; i < 10; i++) {
                    printWriter.print(i + (i < 9 ? ", " : "]\n"));
                }
                printWriter.println("Informacion sobre la JVM:");
                printWriter.println("Fabricante del JVM: " + System.getProperty("java.vendor"));
                printWriter.println("Version del JVM: " + System.getProperty("java.version"));
                printWriter.println("Nombre del JVM: " + System.getProperty("java.vm.name"));
                printWriter.println();

                // Mensajes informativos y escritura con BufferedWriter
                bufferedWriter.write("Escribiendo con BufferedWriter: [");
                for (int i = 0; i < 10; i++) {
                    bufferedWriter.write(i + (i < 9 ? ", " : "]\n"));
                }
                bufferedWriter.write("Informacion sobre la JVM:\r\n");
                bufferedWriter.write("Fabricante del JVM: " + System.getProperty("java.vendor") + System.lineSeparator());
                bufferedWriter.write("Version del JVM: " + System.getProperty("java.version") + "\n");
                bufferedWriter.write("Nombre del JVM: " + System.getProperty("java.vm.name") + "\r\n\n");


            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }

            // Escritura con StringWriter
            try (StringWriter stringWriter = new StringWriter()) {
                stringWriter.write("Escribiendo con StringWriter: [");
                for (int i = 0; i < 10; i++) {
                    stringWriter.write(i + (i < 9 ? ", " : "]\n"));
                }
                stringWriter.write("Informacion sobre la JVM:\r\n");
                stringWriter.write("Fabricante del JVM: " + System.getProperty("java.vendor") + System.lineSeparator());
                stringWriter.write("Version del JVM: " + System.getProperty("java.version") + "\n");
                stringWriter.write("Nombre del JVM: " + System.getProperty("java.vm.name") + "\r\n\n");

                // Escribir el contenido del StringWriter en el archivo
                try (FileWriter fileWriter = new FileWriter(rutaArchivo.toFile(), true)) {
                    fileWriter.write(stringWriter.toString());
                }
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo con StringWriter: " + e.getMessage());
            }

        } else {
            System.err.println("El archivo no pudo ser encontrado.");
        }
    }
}
