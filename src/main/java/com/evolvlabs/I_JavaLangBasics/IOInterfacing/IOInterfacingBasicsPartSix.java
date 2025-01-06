package com.evolvlabs.I_JavaLangBasics.IOInterfacing;

import java.io.*;
import java.util.List;

public class IOInterfacingBasicsPartSix {

    public static void main(String[] args) {

        // Ruta del archivo para lectura binaria
        File file =
                new File("src/main/resources/binary_output.dat");

        // Verificar si el archivo existe y no está vacío
        if (!file.exists() || file.length() == 0) {
            System.err.println(
                    "El archivo no existe o está vacío: "
                            + file.getAbsolutePath());
            return;
        }

        System.out.println(
                "\n=== Leyendo datos con diferentes Readers ===");

        // 1. Leer bytes directamente con FileInputStream
        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println(
                    "\n> Leyendo datos crudos"+
                            " con FileInputStream:");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println(
                    "\nDatos leídos con FileInputStream.");
        } catch (IOException e) {
            System.err.println(
                    "Error al leer con FileInputStream: "
                            + e.getMessage());
        }

        // 2. Mejorar eficiencia con BufferedInputStream
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            System.out.println(
                    "\n> Leyendo datos" +
                            " con BufferedInputStream:");
            int data;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println("\nDatos leídos con BufferedInputStream.");
        } catch (IOException e) {
            System.err.println(
                    "Error al leer con BufferedInputStream: "
                            + e.getMessage());
        }

        // 3. Leer datos estructurados con DataInputStream
        try (DataInputStream dis =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(file)))) {
            System.out.println("\n> Leyendo datos" +
                    "primitivos con DataInputStream:");
            while (dis.available() > 0) { // Verificar si hay datos disponibles
                for(int i = 0; i < 2 ; i++){dis.readUTF();}
                int intValue = dis.readInt();
                double doubleValue = dis.readDouble();
                String stringValue = dis.readUTF();

                System.out.println("Entero leído: "
                        + intValue);
                System.out.println("Double leído: "
                        + doubleValue);
                System.out.println("Cadena leída: "
                        + stringValue);
            }
            System.out.println("Datos primitivos leídos" +
                    " con DataInputStream.");
        } catch (IOException e) {
            System.err.println(
                    "Error al leer con DataInputStream: "
                            + e.getMessage());
        }

        // 4. Deserializar objetos con ObjectInputStream
        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(file)))) {
            System.out.println("\n> Leyendo objeto" +
                    " serializado con ObjectInputStream:");
            Object obj = ois.readObject();
            if (obj instanceof List) {
                List<String> exampleList = (List<String>) obj;
                System.out.println("Lista de objetos deserializada:");
                exampleList.forEach(System.out::println);
            }
            System.out.println(
                    "Objeto leídos con ObjectInputStream.");
        } catch (EOFException eof) {
            System.out.println(
                    "Fin del archivo alcanzado" +
                            " durante la deserialización.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(
                    "Error al leer con ObjectInputStream: "
                            + e.getMessage());
        }

        System.out.println(
                "\n=== Lectura binaria completada ===");
    }

}
