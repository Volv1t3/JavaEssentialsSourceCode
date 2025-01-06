package com.evolvlabs.I_JavaLangBasics.IOInterfacing;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * <body style="color: white"> Este archivo muestra cómo escribir y leer un archivo binario (.dat)
 * usando clases diseñadas para flujos binarios como DataOutputStream y DataInputStream.
 * Se escribe una serie de nombres y números en formato binario, se lee desde el archivo,
 * y se imprimen los contenidos línea por línea.</body>
 */
public class IOInterfacingPartFour {

    public static void main(String[] args) {
        readingAndWritingBinaryFiles();
    }
    
    private static void readingAndWritingBinaryFiles() {
        // Declare the file name
        String fileName = "src/main/resources/output.dat";
        try {
            Files.newOutputStream(Paths.get(fileName)).close(); // Clears file if it exists or creates a new one
        } catch (IOException e) {
            System.err.println("Error while clearing/creating the file: " + e.getMessage());
            e.printStackTrace();
            return; // Exit method if unable to prepare the file
        }
        
        // Writing data to the file
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {
            // Example data: Names and Numbers
            dataOutputStream.writeUTF("Alice");
            dataOutputStream.writeInt(25);
            dataOutputStream.writeUTF("Bob");
            dataOutputStream.writeInt(30);
            dataOutputStream.writeUTF("Charlie");
            dataOutputStream.writeInt(35);
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    
        // Reading data from the file
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))) {
            while (dataInputStream.available() > 0) {
                String name = dataInputStream.readUTF();
                int number = dataInputStream.readInt();
                System.out.println(name + ": " + number);
            }
        } catch (IOException e) {
            System.err.println("Error while reading from file: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
}


