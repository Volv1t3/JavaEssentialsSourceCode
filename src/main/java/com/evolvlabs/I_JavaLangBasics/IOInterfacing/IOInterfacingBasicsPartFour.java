package com.evolvlabs.I_JavaLangBasics.IOInterfacing;
import com.evolvlabs.IV_Extras.Colorizer;

import java.io.*;
import java.nio.file.*;

public class IOInterfacingBasicsPartFour {

    public static void main(String[] args) {
        // Ruta del archivo para lectura
        File archivo = new
                File("src/main/resources/ejemplo_escritura.txt");

        // Verificar si el archivo existe
        if (!archivo.exists()) {
            System.err.println("El archivo no existe: " + archivo.getAbsolutePath());
            return;
        }
        try {
            if (Files.lines(archivo.toPath()).toList().isEmpty()) {
                System.out.println("El archivo está vacío.");
                return;
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo con Files: " + e.getMessage());

        }


        System.out.println(Colorizer.colorWithYellowLetters("Bienvenido a nuestro programa demostrativo de a jerarquia Reader"));
        System.out.println(Colorizer.colorWithCyanLetters("1. Leyendo contenidos mediante un FileReader"));
        try (FileReader fileReader = new FileReader(archivo)) {
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo con FileReader: " + e.getMessage());
        }

        System.out.println(Colorizer.colorWithCyanLetters( "\n\n2. Leyendo contenidos mediante un BufferedReader"));
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo con BufferedReader: " + e.getMessage());
        }

        System.out.println(Colorizer.colorWithCyanLetters("\n\n3. Leyendo contenidos mediante un StringReader"));
        try {
            String contenido = Files.readString(archivo.toPath());
            try (StringReader stringReader =
                         new StringReader(contenido);
                 BufferedReader bufferedReader =
                         new BufferedReader(stringReader)) {
                String linea;
                while ((linea =
                        bufferedReader.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer" +
                    " el archivo con StringReader: "
                    + e.getMessage());
        }

        System.out.println(Colorizer.colorWithCyanLetters("\n\n4. Leyendo contenidos mediante un LineNumberReader"));
        try (LineNumberReader lineNumberReader =
                     new LineNumberReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lineNumberReader.readLine()) != null) {
                System.out.printf("Línea %d: %s%n", lineNumberReader.getLineNumber(), linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo con LineNumberReader: " + e.getMessage());
        }
    }
}
