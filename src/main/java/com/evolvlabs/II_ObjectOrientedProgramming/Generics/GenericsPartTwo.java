package com.evolvlabs.II_ObjectOrientedProgramming.Generics;

import com.evolvlabs.II_ObjectOrientedProgramming.FullStructure.QuickTaskTypes;
import com.evolvlabs.IV_Extras.Colorizer;

import java.util.*;

/**
 * <body style="color : white">El presente archivo incluye una serie de clases secundarias, definidas dentro del mismo archivo como
 * privadas para analizar la forma de declarar clases con un tipo de dato generico. La idea de estas clases es demostrar
 * las imposibilidades del lenguaje a la hora de utilizar un tipo de dato generico en una clase</body>
 */
public class GenericsPartTwo {
    /*! Main*/
    public static void main(String[] args) {
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos a nuestro programa demostrativo de Genericos en Clases de Java!"));
        System.out.println(Colorizer.colorWithYellowLetters("En este programa se demostrara la forma de declarar clases con un tipo de dato generico"));
        System.out.println(Colorizer.colorWithYellowLetters("Ademas se demostrara la forma de declarar clases con un tipo de dato generico en un metodo"));
        System.out.println();
        System.out.println(Colorizer.colorWithCyanLetters("1. Utilizemos la clase Paquete para implementar varios paquetes con tipos" +
                " de dato distintos"));
        /*! Para declarar instancias de la clase paquete usamos el mismo estilo que en C+*, declarando el tipo de dato generico */
        Paquete<String> paqueteUnoDeStrings = new Paquete<>();
        paqueteUnoDeStrings.agregarContenido("StringUno");
        paqueteUnoDeStrings.agregarContenido("StringDos");
        paqueteUnoDeStrings.agregarContenido("StringTres");
        Paquete<Integer> paqueteUnoDeIntegers = new Paquete<>();
        paqueteUnoDeIntegers.agregarContenido(1);
        paqueteUnoDeIntegers.agregarContenido(2);
        paqueteUnoDeIntegers.agregarContenido(3);
        /*? Por la forma de declaracion podemos hasta declarar un paquete parametrizado de interfaces, clases abstractas o
         ? clases parametrizadas*/
        Paquete<Comparator<Integer>> paqueteDeComparables = new Paquete<>();
        paqueteDeComparables.agregarContenido((Integer a, Integer b) -> {
            if (b < a ){
                return 1;
            } else if (b.equals(a)){
                return 0;
            } else {
                return -1;
            }
        });
        paqueteDeComparables.agregarContenido((Integer a, Integer b) -> {
            return 1;
        });
        Paquete<Paquete<Double>> paqueteDePaquetesDeDoubles = new Paquete<>();
        paqueteDePaquetesDeDoubles.agregarContenido(new Paquete<>(){
            {agregarContenido(2.5); 
                agregarContenido(1.24);}});
        paqueteDePaquetesDeDoubles.agregarContenido(new Paquete<>(){
            {agregarContenido(3.5);
                agregarContenido(14.52);}});
        
        /*! Imprimamos los datos internos de cada instancia*/
        System.out.println(Colorizer.colorWithCyanLetters("Imprimamos los datos internos de cada instancia"));
        System.out.println(Colorizer.colorWithMagentaLetters("1.1 Datos de la instancia de Strings ")
                + paqueteUnoDeStrings.toString());
        System.out.println(Colorizer.colorWithMagentaLetters("1.2 Datos de la instancia de Integers ")
                + paqueteUnoDeIntegers.toString());
        System.out.println(Colorizer.colorWithMagentaLetters("1.3 Datos de la instancia de Comparables ")
                + paqueteDeComparables.toString());
        System.out.println(Colorizer.colorWithMagentaLetters("1.4 Datos de la instancia de Paquetes de Doubles ")
                + paqueteDePaquetesDeDoubles.toString());


        /*! Utilizemos otra clase para demostrar el uso de metodos genericos sobre datos genericos*/
        System.out.println();
        System.out.println(Colorizer.colorWithCyanLetters("2. Utilizemos la clase DeliveryTruck para demostrar la extensibilidad de clases" +
                "con tipos genericos"));
        /*! Como tenemos una clase que tiene un tipo de dato abstracto, la instancia se inicializa con el tipo de dato
          ! ingresado durante declaracion*/
        DeliveryTruck<String> deliveryTruckForStrings = new DeliveryTruck<>("Delivery Truck For Strings", 10);
        deliveryTruckForStrings.agregarPaquete(new Paquete<>(){{agregarContenido("Caja 1");
                                                                        agregarContenido("Caja 2");
                                                                        agregarContenido("Caja 3");}});
        deliveryTruckForStrings.agregarPaquete(new Paquete<>(){{agregarContenido("Caja A");
                                                                        agregarContenido("Caja B");
                                                                        agregarContenido("Caja C");}});
        DeliveryTruck<QuickTaskTypes> deliveryTruckForQuickTaskTypes = new DeliveryTruck<>("Delivery Truck For QuickTaskTypes", 5);
        deliveryTruckForQuickTaskTypes.agregarPaquete(new Paquete<>(){{agregarContenido(QuickTaskTypes.COMER);
                                                                        agregarContenido(QuickTaskTypes.DORMIR);
                                                                        agregarContenido(QuickTaskTypes.ESTUDIAR);}});
        /*! Imprimamos los valores ingresados*/
        System.out.println(Colorizer.colorWithMagentaLetters("Imprimamos los valores ingresados"));
        System.out.println(Colorizer.colorWithMagentaLetters("2.1 Datos de la instancia de Strings ")
                + deliveryTruckForStrings.toString());
        System.out.println(Colorizer.colorWithMagentaLetters("2.2 Datos de la instancia de QuickTaskTypes ")
                + deliveryTruckForQuickTaskTypes.toString());

        /*! Usemos sorting con nuestros propios metodos */
        System.out.println();
        System.out.println(Colorizer.colorWithCyanLetters("3. Utilicemos la clas Sort para ordenar arreglos de datos a traves de" +
                " un tipo de dato generico y una instancia de un Comparator"));
        Integer[] numbers = {0,1,25,34,6,1,7,7,3,6,9,250};
        System.out.println(Colorizer.colorWithMagentaLetters(" Imprimamos los valores ingresados"));
        System.out.println(Colorizer.colorWithMagentaLetters("Arreglo anterior : ") + Arrays.toString(numbers));
        Sort.sortAscending(numbers, Integer::compare);
        System.out.println(Colorizer.colorWithMagentaLetters("Arreglo ordenado ascendentemente: ") + Arrays.toString(numbers));
        Double[] numbers2 = {0.25,1.02,25.255,34.3,6.24,1.01,7.33,7.34,3.3,6.3,9.455,250.24};
        Sort.sortDescending(numbers, (o1, o2) -> {
            if (o2 > o1){
                return 1;
            }
            else if (o1.equals(o2)){
                return 0;
            }
            else {
                return -1;
            }
        });
        System.out.println(Colorizer.colorWithMagentaLetters("Arreglo ordenado descendentemente: ") + Arrays.toString(numbers));

        System.out.println(Colorizer.colorWithMagentaLetters("Arreglo anterior : ") + Arrays.toString(numbers2));
        Sort.sortAscending(numbers2, Double::compare);
        System.out.println(Colorizer.colorWithMagentaLetters("Arreglo ordenado ascendentemente: ") + Arrays.toString(numbers2));
        Sort.sortDescending(numbers2, (o1, o2) -> {
            if (o2 > o1){
                return 1;
            }
            else if (o1.equals(o2)){
                return 0;
            }
            else {
                return -1;
            }
        });
        System.out.println(Colorizer.colorWithMagentaLetters("Arreglo ordenado descendentemente: ") + Arrays.toString(numbers2));

    }

}


/*! Clase demostrativa del uso de genericos*/
/*
 ? La declaracion de esta clase demuestra la forma de escribir genericos en Java, los modificadores de acceso no cambian,
 ? el termino estatico puede estar o no, la keyword class debe estar y luego del nombre de la clase escribimos
 ? < tipos de dato genericos > y continuamos con la implementacion general
 */
class Paquete<Contenido> implements Comparable<Paquete<Contenido>>{

    /*! Tipos de dato*/
    /*
     ? Un tipo de dato abstracto no puede ser usado para definir un arreglo primitivo, se puede usar como template para
     ? que el compilador inicialize clases con un tipo de dato abstracto como ArrayList<>
     */
    private ArrayList<Contenido> contenidos = new ArrayList<>();

    /*! Constructores*/
    public Paquete(){
        System.out.println("Se ha creado un paquete nuevo!");
    }

    /*! Setters, Geters y attrs*/
    public List<Contenido> getContenidos() {
        return Collections.unmodifiableList(this.contenidos);
    }

    public void agregarContenido(Contenido contenido){
        if (contenido == null){
            throw new IllegalArgumentException("El contenido no puede ser nulo");
        }
        else {
            this.contenidos.add(contenido);
        }
    }

    public void imprimirContenido(){
        for (Contenido contenido : this.contenidos){
            System.out.println("El paquete contiene : " + contenido);
        }
    }
    /*! Implementaciones de toString*/
    @Override
    public String toString() {
        return "Paquete{" +
                "contenidos=" + contenidos.toString() +
                '}';
    }

    /*! Implementaciones de Comparable*/

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies that
     * {@code x.compareTo(y)} must throw an exception if and only if {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z)) == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the
     * {@code Comparable} interface and violates this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is inconsistent with equals."
     */
    @Override
    public int compareTo(Paquete o) {
        if (o == null){
            throw new NullPointerException("El paquete no puede ser nulo");
        }
        if (this.contenidos.getFirst().getClass() != o.contenidos.getFirst().getClass()){
            /*
             ? Si el tipo de dato de los contenidos de los paquetes no son iguales, se lanza una excepcion
             ? ClassCastException
             */
            throw new ClassCastException("Los contenidos de los paquetes no son del mismo tipo");
        }

        return Integer.compare(this.contenidos.size(), o.getContenidos().size());
    }
}

/*! Clase que extiende las capacidades de la clase paquete manteniendo su cualidad de generica*/
class DeliveryTruck<TipoDePaquetes> implements Comparable<DeliveryTruck<TipoDePaquetes>>{

    /*! Parametros internos*/
    private String name;
    private int capacity;
    private final List<Paquete<TipoDePaquetes>> paquetes = new ArrayList<>();

    /*! Constructores*/
    public DeliveryTruck(String name, int capacity){
        this.setName(name);
        this.setCapacity(capacity);
    }

    /*! Setters, Getters y attrs*/

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }
        else {
            this.name = name;
        }
    }
    public String getName() {
        return this.name;
    }
    private void setCapacity(int capacity) {
        if (capacity <= 0){
            throw new IllegalArgumentException("La capacidad no puede ser menor o igual a 0");
        }
        else {
            this.capacity = capacity;
        }
    }


    public void agregarPaquete(Paquete<TipoDePaquetes> paquete){
        if (paquete == null){
            throw new IllegalArgumentException("El paquete no puede ser nulo");
        }
        else if (this.paquetes.size() >= this.capacity){
            throw new IllegalArgumentException("El truck esta lleno");
        }
        else {
            this.paquetes.add(paquete);
        }
    }
    public void imprimirPaquetes(){
        for (Paquete<TipoDePaquetes> paquete : this.paquetes){
            System.out.println("El truck contiene : " + paquete.toString());
        }
    }

    /*! Implementacion de toString()*/

    /**
     * {@return a string representation of the object}
     *
     * @apiNote In general, the {@code toString} method returns a string that "textually represents" this object. The
     * result should be a concise but informative representation that is easy for a person to read. It is recommended
     * that all subclasses override this method. The string output is not necessarily stable over time or across JVM
     * invocations.
     * @implSpec The {@code toString} method for class {@code Object} returns a string consisting of the name of the
     * class of which the object is an instance, the at-sign character `{@code @}', and the unsigned hexadecimal
     * representation of the hash code of the object. In other words, this method returns a string equal to the value
     * of:
     * {@snippet lang = java:
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     *} The {@link Objects#toIdentityString(Object) Objects.toIdentityString} method returns the string for an object
     * equal to the string that would be returned if neither the {@code toString} nor {@code hashCode} methods were
     * overridden by the object's class.
     */
    @Override
    public String toString() {
        return "DeliveryTruck{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", paquetes=" + paquetes.toString() +
                '}';
    }

    /*! Implementaciones de Comparable*/

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies that
     * {@code x.compareTo(y)} must throw an exception if and only if {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z)) == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the
     * {@code Comparable} interface and violates this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is inconsistent with equals."
     */
    @Override
    public int compareTo(DeliveryTruck o) {
        if (o == null || this.paquetes.getFirst().getClass() != o.paquetes.getFirst().getClass()){
            throw new NullPointerException("El truck no puede ser nulo o de tipos diferentes");
        }
        return Integer.compare(this.paquetes.size(), o.paquetes.size());
    }
}


/*! Implementacion de una clase de ordenamiento basado en tipos de dato en metodos*/
class Sort{
    public static <E> void sortAscending(E[] dataArray, Comparator<E> comparatorInstance){
        Arrays.sort(dataArray, comparatorInstance);
    }

    public static <E> void sortDescending(E[] dataArray, Comparator<E> comparatorInstance){
        Arrays.sort(dataArray, comparatorInstance);
    }

}
