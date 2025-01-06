package com.evolvlabs.I_JavaLangBasics;

import com.evolvlabs.IV_Extras.Colorizer;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 * <body style="color: white"> El presente archivo contiene varias declaraciones de los arreglos de primitivos que son analogos
 * de aquellos en C++ para su analisis y trabajo. Se realizan varias modificaciones a estos arreglos y se da una introduccion 
 * al trabajo con loops y condicionales</body>
 */
public class DataTypesPartThree {
    
    
    public static void main(String[] args) {
        
        /*? Declaracion de las variables requeridas para esta clase*/
        byte[]      /*! arreglo de bytes primitivos*/       primByteArray = new byte[5];
        Byte[]      /*! arreglo de bytes Wrapped*/          wrapByteArray = new Byte[5];
        short[]     /*! arreglo de shorts primitivos*/      primShortArray = new short[5];
        Short[]     /*! arreglo de shorts Wrapped*/         wrapShortArray = new Short[5];
        int[]       /*! arreglo de enteros primitivos*/     primIntegerArray = new int[5];
        Integer[]   /*! arreglo de enteros Wrapped*/        wrapIntegerArray = new Integer[5];
        long[]      /*! arreglo de longs primitivos*/      primLongArray = new long[5];
        Long[]      /*! arreglo de longs Wrapped*/         wrapLongArray = new Long[5];
        float[]     /*! arreglo de floats primitivos*/     primFloatArray = new float[5];
        Float[]     /*! arreglo de floats Wrapped*/        wrapFloatArray = new Float[5];
        double[]    /*! arreglo de doubles primitivos*/    primDoubleArray = new double[5];
        Double[]    /*! arreglo de doubles Wrapped*/       wrapDoubleArray = new Double[5];
        char[]      /*! arreglo de chars primitivos*/      primCharArray = new char[5];
        Character[] /*! arreglo de chars Wrapped*/         wrapCharArray = new Character[5];
        boolean[]   /*! arreglo de booleans primitivos*/   primBooleanArray = new boolean[5];
        Boolean[]   /*! arreglo de booleans Wrapped*/      wrapBooleanArray = new Boolean[5];
        String[]    /*! arreglo de Strings*/               stringArray = new String[5];
        

        /*? Creacion de un objeto Random para generar numeros aleatorios */
        SecureRandom random = new SecureRandom(new byte[]{15,10,33,24,5,11,16});

        /*? Registrando cinco valores aleatorios en cada arreglo basandonos en sus limites */
        for (int i = 0; i < 5; i++) {

            /*! Registro de valores de tipo byte en su rango de -127 hasta 128*/
        primByteArray[i] = (byte) random.nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE + 1);
        wrapByteArray[i] = (byte) random.nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE + 1);
            /*! Registro de valores de tipo short en su rango de -32768 hasta 32767*/
        primShortArray[i] = (short) random.nextInt(Short.MIN_VALUE, Short.MAX_VALUE + 1);
        wrapShortArray[i] = (short) random.nextInt(Short.MIN_VALUE, Short.MAX_VALUE + 1);
            /*! Registro de valores aleatorios en el rango de enteros (no se establecen bounds ya que este metodo los
             ! incluye por defecto*/
        primIntegerArray[i] = random.nextInt(0,2501);
        wrapIntegerArray[i] = random.nextInt(0, 2501);
            /*! Registro de valores aleatorios en el rango de longs*/
        primLongArray[i] = random.nextLong(0, 15001);
        wrapLongArray[i] = random.nextLong(0, 15001);
            /*! Registro de valores de tipo float, estos ya incluyen su rango de toleracia*/
        primFloatArray[i] = random.nextFloat(10,21);
        wrapFloatArray[i] = random.nextFloat(50,56);
            /*! Registro de valores de tipo double*/
        primDoubleArray[i] = random.nextDouble(51,54);
        wrapDoubleArray[i] = random.nextDouble(50,52);
        /*! Registro de tipo de caracteres basados en algun valor dentro del rango de caracteres UTF-16*/
        primCharArray[i] = (char) random.nextInt(Character.MIN_VALUE, Character.MAX_VALUE + 1);
        wrapCharArray[i] = (char) random.nextInt(Character.MIN_VALUE, Character.MAX_VALUE + 1);

        stringArray[i] = "StringEjemplo-Numero--[" + random.nextInt(1000) + "]";
        }
        Arrays.fill(primBooleanArray, true); /*! Relleno de arreglo de primitivos con el primitivo true de booleanos*/
        Arrays.fill(wrapBooleanArray, true); /*! Relleno de arreglo de Boolean con el autoboxing de true a Boolean.TRUE*/

        //! Imprimiendo los valores registrados
        System.out.println(Colorizer.color("Impresiones Generales de los Arreglos de Primitivos", Colorizer.Color.RED_UNDERLINED));
        System.out.println("Arreglo de bytes primitivos = " + Arrays.toString(primByteArray));
        System.out.println("Arreglo de bytes wrapped = " + Arrays.toString(wrapByteArray));
        System.out.println("Arreglo de shorts primitivos = " + Arrays.toString(primShortArray));
        System.out.println("Arreglo de shorts wrapped = " + Arrays.toString(wrapShortArray));
        System.out.println("Arreglo de enteros primitivos = " + Arrays.toString(primIntegerArray));
        System.out.println("Arreglo de enteros wrapped = " + Arrays.toString(wrapIntegerArray));
        System.out.println("Arreglo de longs primitivos = " + Arrays.toString(primLongArray));
        System.out.println("Arreglo de longs wrapped = " + Arrays.toString(wrapLongArray));
        System.out.println("Arreglo de floats primitivos = " + Arrays.toString(primFloatArray));
        System.out.println("Arreglo de floats wrapped = " + Arrays.toString(wrapFloatArray));
        System.out.println("Arreglo de doubles primitivos = " + Arrays.toString(primDoubleArray));
        System.out.println("Arreglo de doubles wrapped = " + Arrays.toString(wrapDoubleArray));
        System.out.println("Arreglo de chars primitivos = " + Arrays.toString(primCharArray));
        System.out.println("Arreglo de chars wrapped = " + Arrays.toString(wrapCharArray));
        System.out.println("Arreglo de booleans primitivos = " + Arrays.toString(primBooleanArray));
        System.out.println("Arreglo de booleans wrapped = " + Arrays.toString(wrapBooleanArray));
        System.out.println("Arreglo de Strings = " + Arrays.toString(stringArray));

    }

}
