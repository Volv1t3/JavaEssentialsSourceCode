package com.evolvlabs.II_ObjectOrientedProgramming.III_DataStructuresAndAlgorithms.CollectionInterface;

import com.evolvlabs.IV_Extras.Colorizer;

import java.util.*;

/**
 * <body style="color: white">El presente archivo incluye una demostracion de la programacion orientada a objetos y de
 * la base de esta, la interface Collection. El proposito de esta demostracion es evaluar los metodos base de la interface
 * a traves de un codigo main y metodos adicionales estaticos que manejen colecciones de manera generica, permitiendo
 * a los estudiantes notar el manejo de colecciones de datos en Java</body>
 */
public class CollectionInterfaceMain {

    /*! Main*/
    public static void main(String[] args) {
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos a nuestro programa demostrativo de de la interface Collection"));
        System.out.println(Colorizer.colorWithYellowLetters("En este programa, se presentan ejemplos de uso de la interface Collection y de la clase DLiangMyArrayList"));
        System.out.println("\n"+ Colorizer.colorWithCyanLetters("1. Veamos como trabajar con una clase nuestra, implementadora de la interface Collection"));
        /*! Creemos una instancia para enteros y trabajemos con ella*/
        MyArrayList<Integer> myArrayList = new MyArrayList<>(15);
        /*! Imprimamos los valores internos*/
        System.out.println(Colorizer.colorWithMagentaLetters("Valores internos (luego de inicializacion): ") + myArrayList);
        /*! Usando el metodo addAll de Collection, anadimos 15 numeros de 0 al 14*/
        myArrayList.addAll(List.of(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14));
        /*! Usando el metodo add de Collection, anadimos el numero 15*/
        myArrayList.add(15);
        /*! Imprimamos los valores internos*/
        System.out.println(Colorizer.colorWithMagentaLetters("Valores internos (luego de anadir elementos): ") + myArrayList);
        /*! Usemos los metodos internos de la clase para imprimir valores internos colo tamano, si esta vacio, etc.*/
        System.out.println(Colorizer.colorWithMagentaLetters("Tamanio de la coleccion: ") + myArrayList.size());
        System.out.println(Colorizer.colorWithMagentaLetters("Esta vacia? ") + myArrayList.isEmpty());
        System.out.println(Colorizer.colorWithMagentaLetters("Contiene el elemento 15? ") + myArrayList.contains(15));
        System.out.println(Colorizer.colorWithMagentaLetters("Contiene el elemento 16? ") + myArrayList.contains(16));
        /*! Usando el metodo remove de Collection, eliminamos el elemento 15*/
        myArrayList.remove(15);
        /*! Imprimamos los valores internos*/
        System.out.println(Colorizer.colorWithMagentaLetters("Valores internos (luego de eliminar el elemento 15): ") + myArrayList);
        /*! Usando el metodo removeAll de Collection, eliminamos todos los elementos de la coleccion*/
        myArrayList.removeAll(List.of(1,3,5,2));
        /*! Imprimamos los valores internos*/
        System.out.println(Colorizer.colorWithMagentaLetters("Valores internos (luego de eliminar algunos elementos): ") + myArrayList);
    }
    
    /**
     * <body style="color: white">
     * La clase {@code DLiangMyArrayList} es una implementacion personalizada que combina la funcionalidad de {@link java.util.Collection} y
     * {@link java.lang.Comparable}. Utilizando genericos, permite trabajar exclusivamente con tipos de datos que extienden {@code Number} 
     * y que implementan {@code Comparable}.
     * <p>
     * Esta clase permite almacenar, manipular y comparar colecciones de elementos numericos de manera eficiente, implementando los metodos 
     * basicos que requieren las interfaces mencionadas.
     * <p>
     * Internamente, utiliza un arreglo dinamico ({@link ArrayList}) que almacena los elementos, ofreciendo una gestion de memoria flexible.
     * <p>
     * Notas sobre la implementacion:
     * <ul>
     *   <li>La capacidad base inicial es {@code 16}, y puede ser definida explicitamente por el usuario al utilizar los constructores.</li>
     *   <li>Proporciona comparacion entre instancias, basada en el tamanio de las colecciones internas.</li>
     *   <li>No admite elementos nulos ({@code NullPointerException} sera lanzado si se intenta agregar un elemento nulo).</li>
     * </ul>
     * </body>
     */
    private static class MyArrayList<E extends Number & Comparable<E>> implements Collection<E>, Comparable<MyArrayList<E>>{
        
        /*! Datos Internos para la implementacion*/
        private final Integer BASE_CAPACITY = 16;
        private final ArrayList<E> internalHolder;
        
        /**
         * <body style="color: white">
         * Crea una instancia de {@code DLiangMyArrayList} con una capacidad base predeterminada de {@code 16}.
         * <p>
         * Utiliza este constructor para inicializar una coleccion sin proporcionar un tamanio especifico.
         * </body>
         */
        public MyArrayList(){
            this.internalHolder = new ArrayList<>(BASE_CAPACITY);
        }
        
        /**
         * <body style="color: white">
         * Crea una instancia de {@code DLiangMyArrayList} con una capacidad inicial definida por el usuario.
         * <p>
         * @param capacity La capacidad inicial que tendra la coleccion. Debe ser un valor positivo mayor a cero.
         * @throws IllegalArgumentException Si {@code capacity} es menor o igual a cero.
         * </body>
         */
        public MyArrayList(Integer capacity){
            if (capacity <= 0){
                throw new IllegalArgumentException("Error: la capacidad debe ser un numero positivo mayor a 0.");
            }
            this.internalHolder = new ArrayList<>(capacity);
        }
        
        /**
         * <body style="color: white">
         * Crea una instancia de {@code DLiangMyArrayList} y agrega todos los elementos de la lista dada a la coleccion interna.
         * <p>
         * @param valuesToAdd Una lista existente cuyos elementos seran agregados a esta coleccion.
         * @throws NullPointerException Si {@code valuesToAdd} es {@code null} o contiene elementos nulos.
         * @throws ClassCastException Si alguno de los elementos de {@code valuesToAdd} no es del tipo soportado por esta clase.
         * </body>
         */
        public MyArrayList(List<E> valuesToAdd){
            if (valuesToAdd == null || valuesToAdd.contains(null)){
                throw new NullPointerException("Error: la lista proporcionada no puede ser nula ni contener elementos nulos.");
            }
            this.internalHolder = new ArrayList<>(){{addAll(valuesToAdd);}};
        }
        
        /*! Implementaciones generales*/
        
        
        
        /**
         * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
         * integer as this object is less than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure {@link Integer#signum
         * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies
         * that {@code x.compareTo(y)} must throw an exception if and only if {@code y.compareTo(x)} throws an
         * exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
         *
         * <p>Finally, the implementor must ensure that {@code
         * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z)) == signum(y.compareTo(z))}, for all {@code z}.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater
         * than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
         * @apiNote It is strongly recommended, but <i>not</i> strictly required that
         * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the
         * {@code Comparable} interface and violates this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is inconsistent with equals."
         */
        @Override
        public int compareTo(MyArrayList<E> o) {
            if( o == null){
                throw new NullPointerException("Error: NullPointerException thrown en metodo compareTo de DLiangMyArrayList : la instancia a compara" +
                        " no puee ser nula");
            }
            
            int result = 0;
            
            if (this.internalHolder.size() > o.internalHolder.size()){
                result = 1;
            } else if (this.internalHolder.size() < o.internalHolder.size()){
                result = -1;
            }
            
            return result;
        }

        /**
         * {@return a string representation of the object}
         *
         * @apiNote In general, the {@code toString} method returns a string that "textually represents" this object.
         * The result should be a concise but informative representation that is easy for a person to read. It is
         * recommended that all subclasses override this method. The string output is not necessarily stable over time
         * or across JVM invocations.
         * @implSpec The {@code toString} method for class {@code Object} returns a string consisting of the name of the
         * class of which the object is an instance, the at-sign character `{@code @}', and the unsigned hexadecimal
         * representation of the hash code of the object. In other words, this method returns a string equal to the
         * value of:
         * {@snippet lang = java:
         * getClass().getName() + '@' + Integer.toHexString(hashCode())
         *} The {@link Objects#toIdentityString(Object) Objects.toIdentityString} method returns the string for an
         * object equal to the string that would be returned if neither the {@code toString} nor {@code hashCode}
         * methods were overridden by the object's class.
         */
        @Override
        public String toString() {
            return "DLiangMyArrayList{" +
                    "internalHolder=" + internalHolder +
                    '}';
        }

        /**
         * Indicates whether some other object is "equal to" this one.
         * <p>
         * The {@code equals} method implements an equivalence relation on non-null object references:
         * <ul>
         * <li>It is <i>reflexive</i>: for any non-null reference value
         *     {@code x}, {@code x.equals(x)} should return
         *     {@code true}.
         * <li>It is <i>symmetric</i>: for any non-null reference values
         *     {@code x} and {@code y}, {@code x.equals(y)}
         *     should return {@code true} if and only if
         *     {@code y.equals(x)} returns {@code true}.
         * <li>It is <i>transitive</i>: for any non-null reference values
         *     {@code x}, {@code y}, and {@code z}, if
         *     {@code x.equals(y)} returns {@code true} and
         *     {@code y.equals(z)} returns {@code true}, then
         *     {@code x.equals(z)} should return {@code true}.
         * <li>It is <i>consistent</i>: for any non-null reference values
         *     {@code x} and {@code y}, multiple invocations of
         *     {@code x.equals(y)} consistently return {@code true}
         *     or consistently return {@code false}, provided no
         *     information used in {@code equals} comparisons on the
         *     objects is modified.
         * <li>For any non-null reference value {@code x},
         *     {@code x.equals(null)} should return {@code false}.
         * </ul>
         *
         * <p>
         * An equivalence relation partitions the elements it operates on
         * into <i>equivalence classes</i>; all the members of an
         * equivalence class are equal to each other. Members of an
         * equivalence class are substitutable for each other, at least
         * for some purposes.
         *
         * @param obj the reference object with which to compare.
         * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
         * @implSpec The {@code equals} method for class {@code Object} implements the most discriminating possible
         * equivalence relation on objects; that is, for any non-null reference values {@code x} and {@code y}, this
         * method returns {@code true} if and only if {@code x} and {@code y} refer to the same object ({@code x == y}
         * has the value {@code true}).
         * <p>
         * In other words, under the reference equality equivalence relation, each equivalence class only has a single
         * element.
         * @apiNote It is generally necessary to override the {@link #hashCode() hashCode} method whenever this method
         * is overridden, so as to maintain the general contract for the {@code hashCode} method, which states that
         * equal objects must have equal hash codes.
         * <p>The two-argument {@link Objects#equals(Object,
         * Object) Objects.equals} method implements an equivalence relation on two possibly-null object references.
         * @see #hashCode()
         * @see HashMap
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj == this) return true;
            if (obj.getClass() != getClass()) return false;
            try {
                MyArrayList<E> o = (MyArrayList<E>) obj;
                return o.internalHolder.equals(this.internalHolder);
            }catch (ClassCastException e){
                return false;
            }
        }
        
        
        /*! Implementaciones de Collections*/

        /**
         * Returns the number of elements in this collection.  If this collection contains more than
         * {@code Integer.MAX_VALUE} elements, returns {@code Integer.MAX_VALUE}.
         *
         * @return the number of elements in this collection
         */
        @Override
        public int size() {
            if (this.internalHolder.size() == Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else {
                return this.internalHolder.size();
            }
        }

        /**
         * Returns {@code true} if this collection contains no elements.
         *
         * @return {@code true} if this collection contains no elements
         */
        @Override
        public boolean isEmpty() {
            return this.internalHolder.isEmpty();
        }

        /**
         * Returns {@code true} if this collection contains the specified element. More formally, returns {@code true}
         * if and only if this collection contains at least one element {@code e} such that
         * {@code Objects.equals(o, e)}.
         *
         * @param o element whose presence in this collection is to be tested
         * @return {@code true} if this collection contains the specified element
         * @throws ClassCastException   if the type of the specified element is incompatible with this collection
         *                              ({@linkplain Collection##optional-restrictions optional})
         * @throws NullPointerException if the specified element is null and this collection does not permit null
         *                              elements ({@linkplain Collection##optional-restrictions optional})
         */
        @Override
        public boolean contains(Object o) {
            return this.internalHolder.contains(o);
        }

        /**
         * Ensures that this collection contains the specified element (optional operation).  Returns {@code true} if
         * this collection changed as a result of the call.  (Returns {@code false} if this collection does not permit
         * duplicates and already contains the specified element.)<p>
         * <p>
         * Collections that support this operation may place limitations on what elements may be added to this
         * collection.  In particular, some collections will refuse to add {@code null} elements, and others will impose
         * restrictions on the type of elements that may be added. Collection classes should clearly specify in their
         * documentation any restrictions on what elements may be added.<p>
         * <p>
         * If a collection refuses to add a particular element for any reason other than that it already contains the
         * element, it <i>must</i> throw an exception (rather than returning {@code false}).  This preserves the
         * invariant that a collection always contains the specified element after this call returns.
         *
         * @param e element whose presence in this collection is to be ensured
         * @return {@code true} if this collection changed as a result of the call
         * @throws UnsupportedOperationException if the {@code add} operation is not supported by this collection
         * @throws ClassCastException            if the class of the specified element prevents it from being added to
         *                                       this collection
         * @throws NullPointerException          if the specified element is null and this collection does not permit
         *                                       null elements
         * @throws IllegalArgumentException      if some property of the element prevents it from being added to this
         *                                       collection
         * @throws IllegalStateException         if the element cannot be added at this time due to insertion
         *                                       restrictions
         */
        @Override
        public boolean add(E e) {
            int prevSize = this.internalHolder.size();
            try{
                if (e != null ){
                    final E converted = (E)  e; /*Conversion implicita que solo pasara si la clase es la misma, la usamos para cumplir
                                  con la regla ClassCastException*/
                    this.internalHolder.add(e);
                }
                else {throw new NullPointerException("Error: NullPointerException thrown en metodo add de DLiangMyArrayList : el elemento a agregar" +
                        " no puede ser nulo");}
            }catch (ClassCastException | NullPointerException exception){
                throw new RuntimeException(exception);
            }
            
            return this.internalHolder.size() > prevSize;
        }

        /**
         * Removes a single instance of the specified element from this collection, if it is present (optional
         * operation).  More formally, removes an element {@code e} such that {@code Objects.equals(o, e)}, if this
         * collection contains one or more such elements.  Returns {@code true} if this collection contained the
         * specified element (or equivalently, if this collection changed as a result of the call).
         *
         * @param o element to be removed from this collection, if present
         * @return {@code true} if an element was removed as a result of this call
         * @throws ClassCastException            if the type of the specified element is incompatible with this
         *                                       collection ({@linkplain Collection##optional-restrictions optional})
         * @throws NullPointerException          if the specified element is null and this collection does not permit
         *                                       null elements
         *                                       ({@linkplain Collection##optional-restrictions optional})
         * @throws UnsupportedOperationException if the {@code remove} operation is not supported by this collection
         */
        @Override
        public boolean remove(Object o) {
            return this.internalHolder.remove(o);
        }

        /**
         * Returns {@code true} if this collection contains all of the elements in the specified collection.
         *
         * @param c collection to be checked for containment in this collection
         * @return {@code true} if this collection contains all of the elements in the specified collection
         * @throws ClassCastException   if the types of one or more elements in the specified collection are
         *                              incompatible with this collection
         *                              ({@linkplain Collection##optional-restrictions optional})
         * @throws NullPointerException if the specified collection contains one or more null elements and this
         *                              collection does not permit null elements
         *                              ({@linkplain Collection##optional-restrictions optional}) or if the specified
         *                              collection is null.
         * @see #contains(Object)
         */
        @Override
        public boolean containsAll(Collection<?> c) {
            return this.internalHolder.containsAll(c);
        }

        /**
         * Adds all of the elements in the specified collection to this collection (optional operation).  The behavior
         * of this operation is undefined if the specified collection is modified while the operation is in progress.
         * (This implies that the behavior of this call is undefined if the specified collection is this collection, and
         * this collection is nonempty.) If the specified collection has a defined
         * <a href="SequencedCollection.html#encounter">encounter order</a>,
         * processing of its elements generally occurs in that order.
         *
         * @param c collection containing elements to be added to this collection
         * @return {@code true} if this collection changed as a result of the call
         * @throws UnsupportedOperationException if the {@code addAll} operation is not supported by this collection
         * @throws ClassCastException            if the class of an element of the specified collection prevents it from
         *                                       being added to this collection
         * @throws NullPointerException          if the specified collection contains a null element and this collection
         *                                       does not permit null elements, or if the specified collection is null
         * @throws IllegalArgumentException      if some property of an element of the specified collection prevents it
         *                                       from being added to this collection
         * @throws IllegalStateException         if not all the elements can be added at this time due to insertion
         *                                       restrictions
         * @see #add(Object)
         */
        @Override
        public boolean addAll(Collection<? extends E> c) {
            return this.internalHolder.addAll(c);
        }

        /**
         * Removes all of this collection's elements that are also contained in the specified collection (optional
         * operation). After this call returns, this collection will contain no elements in common with the specified
         * collection.
         *
         * @param c collection containing elements to be removed from this collection
         * @return {@code true} if this collection changed as a result of the call
         * @throws UnsupportedOperationException if the {@code removeAll} operation is not supported by this collection
         * @throws ClassCastException            if the types of one or more elements in this collection are
         *                                       incompatible with the specified collection
         *                                       ({@linkplain Collection##optional-restrictions optional})
         * @throws NullPointerException          if this collection contains one or more null elements and the specified
         *                                       collection does not support null elements
         *                                       ({@linkplain Collection##optional-restrictions optional}) or if the
         *                                       specified collection is null
         * @see #remove(Object)
         * @see #contains(Object)
         */
        @Override
        public boolean removeAll(Collection<?> c) {
            return this.internalHolder.removeAll(c);
        }

        /**
         * Retains only the elements in this collection that are contained in the specified collection (optional
         * operation).  In other words, removes from this collection all of its elements that are not contained in the
         * specified collection.
         *
         * @param c collection containing elements to be retained in this collection
         * @return {@code true} if this collection changed as a result of the call
         * @throws UnsupportedOperationException if the {@code retainAll} operation is not supported by this collection
         * @throws ClassCastException            if the types of one or more elements in this collection are
         *                                       incompatible with the specified collection
         *                                       ({@linkplain Collection##optional-restrictions optional})
         * @throws NullPointerException          if this collection contains one or more null elements and the specified
         *                                       collection does not permit null elements
         *                                       ({@linkplain Collection##optional-restrictions optional}) or if the
         *                                       specified collection is null
         * @see #remove(Object)
         * @see #contains(Object)
         */
        @Override
        public boolean retainAll(Collection<?> c) {
            return this.internalHolder.retainAll(c);
        }

        /**
         * Removes all of the elements from this collection (optional operation). The collection will be empty after
         * this method returns.
         *
         * @throws UnsupportedOperationException if the {@code clear} operation is not supported by this collection
         */
        @Override
        public void clear() {
            this.internalHolder.clear();
        }

        /**
         * Returns an iterator over the elements in this collection.  There are no guarantees concerning the order in
         * which the elements are returned (unless this collection is an instance of some class that provides a
         * guarantee).
         *
         * @return an {@code Iterator} over the elements in this collection
         */
        @Override
        public Iterator<E> iterator() {
            return this.internalHolder.iterator();
        }

        /**
         * Returns an array containing all of the elements in this collection. If this collection makes any guarantees
         * as to what order its elements are returned by its iterator, this method must return the elements in the same
         * order. The returned array's {@linkplain Class#getComponentType runtime component type} is {@code Object}.
         *
         * <p>The returned array will be "safe" in that no references to it are
         * maintained by this collection.  (In other words, this method must allocate a new array even if this
         * collection is backed by an array). The caller is thus free to modify the returned array.
         *
         * @return an array, whose {@linkplain Class#getComponentType runtime component type} is {@code Object},
         * containing all of the elements in this collection
         * @apiNote This method acts as a bridge between array-based and collection-based APIs. It returns an array
         * whose runtime type is {@code Object[]}. Use {@link #toArray(Object[]) toArray(T[])} to reuse an existing
         * array, or use {@link #toArray(IntFunction)} to control the runtime type of the array.
         */
        @Override
        public Object[] toArray() {
            return this.internalHolder.toArray();
        }

        /**
         * Returns an array containing all of the elements in this collection; the runtime type of the returned array is
         * that of the specified array. If the collection fits in the specified array, it is returned therein.
         * Otherwise, a new array is allocated with the runtime type of the specified array and the size of this
         * collection.
         *
         * <p>If this collection fits in the specified array with room to spare
         * (i.e., the array has more elements than this collection), the element in the array immediately following the
         * end of the collection is set to {@code null}.  (This is useful in determining the length of this collection
         * <i>only</i> if the caller knows that this collection does not contain any {@code null} elements.)
         *
         * <p>If this collection makes any guarantees as to what order its elements
         * are returned by its iterator, this method must return the elements in the same order.
         *
         * @param a the array into which the elements of this collection are to be stored, if it is big enough;
         *          otherwise, a new array of the same runtime type is allocated for this purpose.
         * @return an array containing all of the elements in this collection
         * @throws ArrayStoreException  if the runtime type of any element in this collection is not assignable to the
         *                              {@linkplain Class#getComponentType runtime component type} of the specified
         *                              array
         * @throws NullPointerException if the specified array is null
         * @apiNote This method acts as a bridge between array-based and collection-based APIs. It allows an existing
         * array to be reused under certain circumstances. Use {@link #toArray()} to create an array whose runtime type
         * is {@code Object[]}, or use {@link #toArray(IntFunction)} to control the runtime type of the array.
         *
         * <p>Suppose {@code x} is a collection known to contain only strings.
         * The following code can be used to dump the collection into a previously allocated {@code String} array:
         *
         * <pre>
         *     String[] y = new String[SIZE];
         *     ...
         *     y = x.toArray(y);</pre>
         *
         * <p>The return value is reassigned to the variable {@code y}, because a
         * new array will be allocated and returned if the collection {@code x} has too many elements to fit into the
         * existing array {@code y}.
         *
         * <p>Note that {@code toArray(new Object[0])} is identical in function to
         * {@code toArray()}.
         */
        @Override
        public <T> T[] toArray(T[] a) {
            return this.internalHolder.toArray(a);
        }
    }
    
    /**
     * <body style="color: white">
     * El metodo {@code generateRandomNumbers} se encarga de generar una lista de numeros enteros aleatorios dentro de un rango especificado.
     * <p>
     * Este metodo utiliza la clase {@link Random} para generar numeros aleatorios y construye la lista implementando un bucle para iterar 
     * la cantidad de veces indicada por el parametro {@code count}.
     * <p>
     * El rango de numeros generados esta definido por los parametros {@code min} y {@code max}, asegurando que los valores devueltos esten
     * comprendidos dentro de los limites dados (ambos inclusivos). Internamente se utiliza la formula 
     * {@code random.nextInt((max - min) + 1) + min} para calcular cada numero aleatorio.
     *
     * @param count Cantidad de numeros aleatorios que se quieren generar.
     * @param min Valor minimo (inclusive) que puede tomar un numero generado.
     * @param max Valor maximo (inclusive) que puede tomar un numero generado.
     * @return Una lista {@link List} de numeros enteros generados aleatoriamente dentro del rango especificado por {@code min} y {@code max}.
     * @throws IllegalArgumentException Si el parametro {@code count} es negativo, o si el limite {@code min} es mayor que {@code max}.
     * <p>
     * @implNote Este metodo no garantiza que los numeros generados sean unicos; es posible que existan repeticiones en la lista devuelta.
     * </body>
     */
    private static List<Integer> generateRandomNumbers(int count, int min, int max) {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumbers.add(random.nextInt((max - min) + 1) + min);
        }
        return randomNumbers;
    }
}
