package com.evolvlabs.I_JavaLangBasics.IOInterfacing;

import com.evolvlabs.IV_Extras.Colorizer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <body style="color: white">El presente archivo contiene una serie de implementaciones claves que demuestran
 * el uso de la jerarquia de clases de OutputStream para manejo de archivos binarios</body>
 */
public class IOInterfacingBasicsPartFive {

    public static void main(String[] args) {

        File file = new File("src/main/resources/binary_output.dat");

        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos a nuestro programa demostrativo del trabajo con " +
                " la jerarquia OutputStream para archivos binarios"));
        try {
            // Crear el archivo si no existe
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Archivo creado exitosamente: " + file.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear el archivo.");
                    return;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
            return;
        }

        // Escritura de datos binarios usando diferentes tipos de OutputStreams
        System.out.println(Colorizer.colorWithCyanLetters("1. Escribiendo contenido con un FileOutputStream"));

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write("Escribir con FileOutputStream.\n".getBytes());
            System.out.println(Colorizer.color("Datos escritos con FileOutputStream.",
                    Colorizer.Color.GREEN_BRIGHT));
        } catch (IOException e) {
            System.err.println(Colorizer.color("Error al escribir con FileOutputStream: ",
                    Colorizer.Color.RED_BRIGHT) + e.getMessage());
        }

        System.out.println(Colorizer.colorWithCyanLetters("2. Escribiendo contenido con un BufferedOutputStream"));
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true))) {
            bos.write("Escribir con BufferedOutputStream.\n".getBytes());
            System.out.println(Colorizer.color("Datos escritos con BufferedOutputStream.",
                    Colorizer.Color.GREEN_BRIGHT));
        } catch (IOException e) {
            System.err.println(Colorizer.color("Error al escribir con BufferedOutputStream: ",
                    Colorizer.Color.RED_BRIGHT) + e.getMessage());
        }

        System.out.println(Colorizer.colorWithCyanLetters("3. Escribiendo contenido con un DataOutputStream"));
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(file, true)))) {
            dos.writeInt(42); // Un entero
            dos.writeDouble(3.14159); // Un número flotante
            dos.writeUTF("Texto a través de DataOutputStream.\n"); // Una cadena
            System.out.println(Colorizer.color("Datos primitivos escritos con DataOutputStream.",
                    Colorizer.Color.GREEN_BRIGHT));
        } catch (IOException e) {
            System.err.println(Colorizer.color("Error al escribir con DataOutputStream: ",
                    Colorizer.Color.RED_BRIGHT) + e.getMessage());
        }

        System.out.println(Colorizer.colorWithCyanLetters("4. Escribiendo contenido con un ObjectOutputStream"));
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(file, true)))) {
            List<String> exampleList = new ArrayList<>();
            exampleList.add("Elemento 1");
            exampleList.add("Elemento 2");
            exampleList.add("Elemento 3");

            oos.writeObject(exampleList); // Serializar una lista de objetos
            System.out.println(Colorizer.color("Objeto serializado y escrito con ObjectOutputStream.",
                    Colorizer.Color.GREEN_BRIGHT));
        } catch (IOException e) {
            System.err.println(Colorizer.color("Error al escribir con ObjectOutputStream: ",
                    Colorizer.Color.RED_BRIGHT) + e.getMessage());
        }

        System.out.println(Colorizer.colorWithYellowLetters("=== Escritura binaria completada ==="));
    }
}
