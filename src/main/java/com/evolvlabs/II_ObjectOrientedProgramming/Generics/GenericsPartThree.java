package com.evolvlabs.II_ObjectOrientedProgramming.Generics;

import com.evolvlabs.IV_Extras.Colorizer;

import java.util.List;
import java.util.Objects;

/**
 * <body style="color : white">El presente archivo contiene una serie de clases que demuestran el trabajo con
 * generic type bouding en Java, es decir, el control de las clases permitidas dentro de un metodo o clase en Java. Para
 * esto se implementan varias clases privadas internas de este archivo, asi como clases con metodos estaticos</body>
 */
public class GenericsPartThree {

    /*! Main*/
    public static void main(String[] args) {
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos a nuestro ultimo programa de muestra para genericos en Java!"));
        System.out.println(Colorizer.colorWithYellowLetters("Usaremos varios metodos y clases para analizar como utilizar type bounding"));
        Mathematic<Double> doubleMathematic = new Mathematic<>();
        Mathematic<Integer> integerMathematic = new Mathematic<>();
        /*! Realizemos operaciones con estas instancias*/
        System.out.println(Colorizer.colorWithCyanLetters("1. Trabajemos con instancias Double, Integer y FLoat de Mathematic "));
        System.out.println(Colorizer.colorWithMagentaLetters("Suma inexacta de 14.5 + 14.3 : ") + doubleMathematic.sumInexact(14.5, 14.3));
        System.out.println(Colorizer.colorWithMagentaLetters("Suma exacta de 14.5 + 14.3 : ") + doubleMathematic.sumExact(14.5, 14.3));
        System.out.println(Colorizer.colorWithMagentaLetters("Resta inexacta de 14.5 - 14.3 : ") + doubleMathematic.subInexact(14.5, 14.3));
        System.out.println(Colorizer.colorWithMagentaLetters("Resta exacta de 14.4 - 14.1 : ") + doubleMathematic.subExact(14.4, 14.1));
        System.out.println(Colorizer.colorWithMagentaLetters("Raiz cuadrada inexacta de 14.5 : ") + doubleMathematic.sqrtInexact(14.5));
        System.out.println(Colorizer.colorWithMagentaLetters("Raiz cuadrada exacta de 14 : ") + doubleMathematic.sqrtExact(14.0));
        System.out.println(Colorizer.colorWithMagentaLetters("Suma inexacta de 14 + 14 : ") + integerMathematic.sumInexact(14, 14));
        System.out.println(Colorizer.colorWithMagentaLetters("Resta exacta de 15 - 14 : ") + integerMathematic.subExact(15, 14));
        System.out.println(Colorizer.colorWithMagentaLetters("Raiz cuadrada inexacta de 14 : ") + integerMathematic.sqrtInexact(14));
        System.out.println(Colorizer.colorWithMagentaLetters("Raiz cuadrada exacta de 14 : ") + integerMathematic.sqrtExact(14));

        /*! Realizemos operaciones con estas instancias*/
        System.out.println(Colorizer.colorWithCyanLetters("2. Trabajemos con la clase Array y revisemos el manejo de sus metodos "));
        Array<Integer> array = new Array<>();
        array.addElement(1);
        array.addElement(2);
        array.addElement(3);
        array.addElement(4);
        array.addElements(List.of(14.2,3,1,5,6));
        System.out.println("array.toString() = " + array.toString());
    }
}

/*! Declaracion de una clase cuyo ingreso de parametros debe cumplir con un upper-bound wildcard.*/
/*
 ? La declaracion en el estilo <E extends Number & Comparable<E>> indica que la clase enviada al tipo de dato generico
 ? debe cumplir con dos condiciones
 ? 1. Extender Number (es decir cumplir con ser Number o una clase hija de esta
 ? 2. Implementar Comparable con el mismo tipo de dato
 */
class Mathematic<E extends Number & Comparable<E>>{

    /*! Constructor*/
    public Mathematic(){;}


    /*! Metodo que suma dos numeros*/
    public double sumInexact(E a, E b){
        //? Usamos el comparable para determinar quien es mayor
        System.out.println("El mayor de los valores ingresados es : " + (a.compareTo(b) > 0 ? a : b));
        //! Realizamos la suma inexacta
        return a.doubleValue() + b.doubleValue();
    }

    /*! Metodo que suma dos numeros*/
    public double sumExact(E a, E b){
        //? Usamos el comparable para determinar quien es mayor
        System.out.println("El mayor de los valores ingresados es : " + (a.compareTo(b) > 0 ? a : b));
        //! Realizamos la suma exacta
        return a.intValue() + b.intValue();
    }

    /*! Metodo que resta dos numeros inexactamente*/
    public double subInexact(E a, E b){
        //? Usamos el comparable para determinar quien es mayor
        System.out.println("El mayor de los valores ingresados es : " + (a.compareTo(b) > 0 ? a : b));
        //! Realizamos la resta inexacta
        return a.doubleValue() - b.doubleValue();
    }

    /*! Metodo que resta dos numeros exactamente*/
    public double subExact(E a, E b){
        //? Usamos el comparable para determinar quien es mayor
        System.out.println("El mayor de los valores ingresados es : " + (a.compareTo(b) > 0 ? a : b));
        //! Realizamos la resta exacta
        return a.intValue() - b.intValue();
    }

    /*! Metodo para obtener la raiz cuadrada inexacta de un numero*/
    public double sqrtInexact(E a){
        //! Realizamos la raiz cuadrada inexacta
        return Math.sqrt(a.doubleValue());
    }

    /*! Metodo para obtener la raiz cuadrada exacta de un numero*/
    public int sqrtExact(E a){
        //! Realizamos la raiz cuadrada exacta
        return (int) Math.round(Math.sqrt(a.intValue()));
    }

}


class Array<E extends Number> {

    /*! Parametros internos*/
    private static final Integer BASE_CAPACITY = 16;
    private E[] array = (E[]) new Number[BASE_CAPACITY];
    private Integer elementcount = 0;
    /*! Constructores*/
    public Array(){;}
    
   

    /*! Setters, Getters y Modificadores*/
    public void addElement(E element){
        ensureCapacity();
        array[elementcount] = element;
        elementcount++;
    }
    public E getElement(Integer index){
        if(index < elementcount){
            return array[index];
        }else{
            System.out.println("El indice ingresado no es valido");
            return null;
        }
    }
    public void setElement(E element, Integer index){
        if(index < elementcount){
            array[index] = element;
        }else{
            System.out.println("El indice ingresado no es valido");
        }
    }
    public void removeElement(Integer index){
        if(index < elementcount){
            array[index] = null;
            elementcount--;
        }else{
            System.out.println("El indice ingresado no es valido");
        }
    }

    /*! Declaracion de un metodo para anadir numeros usando un lower bound wildcard*/
    /*
     ? Un lowerbound wildcard se establece con la estructura <? super T> donde la clase que puede estar en instanciacion 
     ? entre <> puede ser T o una clase superior a T en la estructura jerarquica. Este tipo de declaracion no se puede usar
     ? para declarar clases genericas, solo en metodos y en ciertos casos como en listas o clases. Su uso es muy especifico
     */
    public void addElements(List<? super E> listOfNumbers){
        for (Object number : listOfNumbers) {
            if (number instanceof Integer || number instanceof Short || number instanceof Long) {
                this.addElement((E) number);
            } else if (number instanceof Double || number instanceof Float) {
                this.addElement((E) (Number) Math.round((double) number));
            }
        }
    }
    
    /*! Helpers*/
    /*! Metodo para redimensionar el arreglo cuando sea necesario */
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Number[newCapacity];
        System.arraycopy(array, 0, newArray, 0, elementcount);
        array = newArray;
    }

    /*! Metodo para asegurar que haya capacidad suficiente antes de agregar elementos */
    private void ensureCapacity() {
        if (elementcount >= array.length) {
            resize(array.length * 2);
        }
    }
    
    /*! Implementacion toString()*/

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
        StringBuilder sb = new StringBuilder();
        sb.append("Array{");
        for (int i = 0; i < elementcount; i++) {
            sb.append(array[i]);
            if (i < elementcount - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

