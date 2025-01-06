package com.evolvlabs.II_ObjectOrientedProgramming.III_DataStructuresAndAlgorithms;

import com.evolvlabs.IV_Extras.Colorizer;

import java.util.*;

/**
 * <body style="color: white">El presente archivo muestra la manera de trabajar con listas, stacks y queues. Se muestra
 * como trabajar con la clase Collections con el fin de manejar implementaciones de Collections a traves de listas.</body>
 */
public class CollectionsHelper {
    public static void main(String[] args) {
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos a nuestro programa demostrativo de la clase Collections en Java!"));
        System.out.println(Colorizer.colorWithYellowLetters("Este programa se encargara de mostrar como trabajar con listas, stacks y queues."));
        System.out.println(Colorizer.colorWithYellowLetters("Ademas de como utilizar la clase Collections para manejar con estructuras de datos de Java Base"));
        System.out.println();
        System.out.println(Colorizer.colorWithCyanLetters("1. Utilizemos listas de tipo ArrayList para utilizar metodos de ordenamiento y varios de Collections"));
        ArrayList<Integer> integerList = new ArrayList<>(){{addAll(List.of(1, 2, 3, 4, 5, 6,
                7, 8, 9, 10));}};
        LinkedList<Double> doubleList = new LinkedList<>(){{addAll(List.of(1.1, 2.2, 3.3, 4.4, 5.5,
                6.6, 7.7, 8.8, 9.9, 10.10));}};
        ArrayList<String> stringList = new ArrayList<>(){{addAll(List.of("a", "b", "c", "d", "e",
                "f", "g", "h", "i", "j"));}};
        Vector<Character> characterList = new Vector<>(){{addAll(List.of('a', 'b', 'c', 'd', 'e',
                'f', 'g', 'h', 'i', 'j'));}};
        Stack<Byte> byteList = new Stack<>(){{addAll(List.of((byte) 1, (byte) 2, (byte) 3, (byte) 4,
                (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));}};
        /*! Imprimamos cada instancia y sus valores detallando entre parentesis que tipo de estructura son*/
        System.out.println(Colorizer.colorWithYellowLetters("1.1 Contenidos de integerList (ArrayList<Integer>): ") + integerList);
        System.out.println(Colorizer.colorWithYellowLetters("1.2 Contenidos de doubleList (LinkedList<Double>): ") + doubleList);
        System.out.println(Colorizer.colorWithYellowLetters("1.3 Contenidos de stringList (Arraylist<String>): ") + stringList);
        System.out.println(Colorizer.colorWithYellowLetters("1.4 Contenidos de characterList (Vector<Character>): ") + characterList);
        System.out.println(Colorizer.colorWithYellowLetters("1.5 Contenidos de byteList (Stack<Byte>): ") + byteList);

        System.out.println("\n" + Colorizer.colorWithCyanLetters("1.A._ Utilizemos el metodo shuffle de Collections y luego ordenamos"));
        /*! Shuffle Section*/
        shuffleSection(integerList, doubleList, stringList, characterList, byteList);

        /*! Utilizemos una busqueda binaria para encontrar un valor dentro y un valor fuera de la lista*/
        System.out.println("\n" + Colorizer.colorWithCyanLetters("2. Utilizemos el metodo binarySearch de Collections para buscar un valor dentro de la lista"));
        binarySearchSection(integerList, doubleList, stringList, characterList, byteList);
        /*! Utilizemos max y min para encontrar los valores correspondientes*/
        System.out.println("\n" + Colorizer.colorWithCyanLetters("3. Utilizemos el metodo max y min de Collections para encontrar los valores correspondientes"));
        minMaxSection(integerList, doubleList, stringList, characterList, byteList);

        /*! Creemos dos instancias, una de deque y otra de priority queue, asi como de mapas para manejarlos con collections*/
        System.out.println("\n" + Colorizer.colorWithCyanLetters("4. Ahora utilizemos Collections para manejar instancias de Deque, PriorityQueue y Maps"));
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>(){{addAll(integerList);}};
        PriorityQueue<Double> doublePriorityQueue = new PriorityQueue<>(){{addAll(doubleList);}};
        Map<Integer, String> integerStringMap = new HashMap<>(){{putAll(Map.of(1, "a", 2,
                "b", 3, "c", 4, "d", 5, "e",
                6, "f", 7, "g", 8, "h", 9, "i", 10, "j"));}};

        /*! Imprimimos los valores de cada instancia*/
        System.out.println(Colorizer.colorWithYellowLetters("4.1 Contenidos de integerArrayDeque (ArrayDeque<Integer>): ") + integerArrayDeque);
        System.out.println(Colorizer.colorWithYellowLetters("4.2 Contenidos de doublePriorityQueue (PriorityQueue<Double>): ") + doublePriorityQueue);
        System.out.println(Colorizer.colorWithYellowLetters("4.3 Contenidos de integerStringMap (Map<Integer, String>): ") + integerStringMap);

        /*! Shuffle and Sort */
        System.out.println("\n" + Colorizer.colorWithCyanLetters("4.A._ Utilizemos el metodo shuffle de Collections y luego ordenamos"));
        shuffleQueueAndMapSection(integerArrayDeque, doublePriorityQueue, integerStringMap);
        /*! MinMax Operations */
        System.out.println("\n" + Colorizer.colorWithCyanLetters("4.A._ Utilizemos el metodo min y max de Collections para encontrar los valores correspondientes"));
        minMaxQueueAndMapSection(integerArrayDeque, doublePriorityQueue, integerStringMap);


        


    }

    /**
     * <body style="color: white">
     * Metodo que determina el valor maximo y minimo en cinco listas de diferentes tipos empleando
     * las funcionalidades {@link Collections#max(Collection)} y {@link Collections#min(Collection)}.
     * <br><br>
     * Este metodo toma varias listas genericas implementadas con diferentes estructuras de datos de Java y calcula
     * el elemento mayor y menor segun el orden natural de los elementos en cada una.
     * <br><br>
     * <b>Conceptos utilizados:</b>
     * <ul>
     *   <li>Utilizacion de las interfaces {@code List} y {@code Collection}, que permiten manejar los elementos de las listas.</li>
     *   <li>{@code Collections.max} y {@code Collections.min} para encontrar los valores extremos en una coleccion.</li>
     *   <li>Uso de la salida a consola para presentar los resultados en un estilo formateado.</li>
     * </ul>
     * </body>
     * <br>
     *
     * @param integerList Lista de enteros de tipo {@code ArrayList<Integer>}.
     * @param doubleList Lista de numeros de punto flotante de tipo {@code LinkedList<Double>}.
     * @param stringList Lista de cadenas de texto de tipo {@code ArrayList<String>}.
     * @param characterList Lista de caracteres de tipo {@code Vector<Character>}.
     * @param byteList Lista de bytes de tipo {@code Stack<Byte>}.
     * <br>
     * <body style="color: white">
     * <b>Excepciones:</b>
     * Puede producirse {@link NullPointerException} si alguna lista es nula o contiene
     * elementos nulos. Adicionalmente, {@code ClassCastException} puede ser lanzada si los elementos
     * no son comparables entre si.
     * <br>
     * </body>
     */
    private static void minMaxSection(ArrayList<Integer> integerList, LinkedList<Double> doubleList, 
                                      ArrayList<String> stringList, Vector<Character> characterList, Stack<Byte> byteList) {
        System.out.println(Colorizer.colorWithMagentaLetters("3.1 Max en integerList : ")
                + Collections.max(integerList) + Colorizer.colorWithMagentaLetters(" 3.1 Min en integerList : ")
                + Collections.min(integerList));
        System.out.println(Colorizer.colorWithMagentaLetters("3.2 Max en doubleList : ")
                + Collections.max(doubleList) + Colorizer.colorWithMagentaLetters(" 3.2 Min en doubleList : ")
                + Collections.min(doubleList));
        System.out.println(Colorizer.colorWithMagentaLetters("3.3 Max en stringList : ")
                + Collections.max(stringList) + Colorizer.colorWithMagentaLetters(" 3.3 Min en stringList : ")
                + Collections.min(stringList));
        System.out.println(Colorizer.colorWithMagentaLetters("3.4 Max en characterList : ")
                + Collections.max(characterList) + Colorizer.colorWithMagentaLetters(" 3.4 Min en characterList : ")
                + Collections.min(characterList));
        System.out.println(Colorizer.colorWithMagentaLetters("3.5 Max en byteList : ")
                + Collections.max(byteList) + Colorizer.colorWithMagentaLetters(" 3.5 Min en byteList : ")
                + Collections.min(byteList));
    }

    /**
     * <body style="color: white">
     * Metodo que realiza busquedas binarias utilizando la funcionalidad de {@link Collections#binarySearch(List, Object)}.
     * Este metodo muestra ejemplos de busqueda en cinco tipos diferentes de listas genericas.
     * <br><br>
     * Para que {@code binarySearch} funcione correctamente, es fundamental que las listas se encuentren
     * ordenadas de acuerdo con el orden natural de los elementos. El metodo compara los valores utilizando
     * su metodo {@code compareTo} o, en su defecto, un {@code Comparator} pasado a {@code Collections.binarySearch}.
     * <br><br>
     * Si el valor buscado se encuentra en la lista, {@code binarySearch} devolvera el indice de su ubicacion.
     * En caso contrario, devolvera un valor negativo que representa donde podría insertarse el elemento.
     * <br><br>
     * <b>Conceptos utilizados:</b>
     * <ul>
     *   <li>{@code List}: La estructura base que permite la gestion de colecciones ordenadas.</li>
     *   <li>{@code binarySearch}: Un algoritmo eficiente de busqueda logaritmica que requiere datos previamente ordenados.</li>
     *   <li>Uso de bucles y comprobaciones para validar resultados y comparar los indices retornados.</li>
     * </ul>
     * </body>
     * <br>
     *
     * @param integerList Lista de enteros de tipo {@code ArrayList<Integer>}.
     * @param doubleList Lista de numeros de punto flotante de tipo {@code LinkedList<Double>}.
     * @param stringList Lista de cadenas de texto de tipo {@code ArrayList<String>}.
     * @param characterList Lista de caracteres de tipo {@code Vector<Character>}.
     * @param byteList Lista de bytes de tipo {@code Stack<Byte>}.
     * <br>
     * <body style="color: white">
     * <b>Excepciones:</b>
     * Al utilizar {@code Collections.binarySearch}, es posible que se produzca una {@link ClassCastException} si los
     * elementos de la lista no son comparables entre si. Adicionalmente, {@code NullPointerException}
     * puede ser lanzada si se pasa una lista nula al metodo.
     * <br>
     * </body>
     */
    private static void binarySearchSection(ArrayList<Integer> integerList, 
                                            LinkedList<Double> doubleList, ArrayList<String> stringList, Vector<Character> characterList, Stack<Byte> byteList) {
        System.out.println(Colorizer.colorWithYellowLetters("2.1 Buscamos el valor 5 en integerList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.1.A Esta el valor 5 en integerList? ") + Integer.valueOf(
                Collections.binarySearch(integerList, 5)).equals(integerList.indexOf(5)));
        System.out.println(Colorizer.colorWithYellowLetters("2.2 Buscamos el valor 11 en integerList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.2.A Esta el valor 11 en integerList? ") + Integer.valueOf(
                Collections.binarySearch(integerList, 11)).equals(integerList.indexOf(11)));
        System.out.println(Colorizer.colorWithYellowLetters("2.3 Buscamos el valor 5.5 en doubleList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.3.A Esta el valor 5.5 en doubleList? ") + Integer.valueOf(
                Collections.binarySearch(doubleList, 5.5)).equals(doubleList.indexOf(5.5)));
        System.out.println(Colorizer.colorWithYellowLetters("2.4 Buscamos el valor 11.5 en doubleList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.4.A Esta el valor 11.5 en doubleList? ") + Integer.valueOf(
                Collections.binarySearch(doubleList, 11.5)).equals(doubleList.indexOf(11.5)));
        System.out.println(Colorizer.colorWithYellowLetters("2.5 Buscamos el valor 'e' en stringList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.5.A Esta el valor 'e' en stringList? ") + Integer.valueOf(
                Collections.binarySearch(stringList, "e")).equals(stringList.indexOf("e")));
        System.out.println(Colorizer.colorWithYellowLetters("2.6 Buscamos el valor 'k' en stringList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.6.A Esta el valor 'k' en stringList? ") + Integer.valueOf(
                Collections.binarySearch(stringList, "k")).equals(stringList.indexOf("k")));
        System.out.println(Colorizer.colorWithYellowLetters("2.7 Buscamos el valor 'e' en characterList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.7.A Esta el valor 'e' en characterList? ") + Integer.valueOf(
                Collections.binarySearch(characterList, 'e')).equals(characterList.indexOf('e')));
        System.out.println(Colorizer.colorWithYellowLetters("2.8 Buscamos el valor 'k' en characterList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.8.A Esta el valor 'k' en characterList? ") + Integer.valueOf(
                Collections.binarySearch(characterList, 'k')).equals(characterList.indexOf('k')));
        System.out.println(Colorizer.colorWithYellowLetters("2.9 Buscamos el valor 5 en byteList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.9.A Esta el valor 5 en byteList? ") + Integer.valueOf(
                Collections.binarySearch(byteList, (byte) 5)).equals(byteList.indexOf((byte) 5)));
        System.out.println(Colorizer.colorWithYellowLetters("2.10 Buscamos el valor 11 en byteList: "));
        System.out.println(Colorizer.colorWithMagentaLetters("2.10.A Esta el valor 11 en byteList? ") + Integer.valueOf(
                Collections.binarySearch(byteList, (byte) 11)).equals(byteList.indexOf((byte) 11)));
    }

    /**
     * <body style="color: white">
     * Metodos que interactua con listas y realiza dos operaciones principales en cada una: <i>mezclar (shuffle)</i>
     * y <i>ordenar (sort)</i>.
     * <br>
     * Este metodo toma cinco listas de diferente tipo y lleva a cabo el metodo {@code Collections.shuffle}
     * para cambiar aleatoriamente el orden de los elementos internos, seguido de {@code Collections.sort}
     * para reordenarlas en orden ascendente segun los valores de los elementos.
     * Dado que todas las colecciones utilizadas implementan la interfaz {@code List}, estas son elegibles
     * para pasar a los metodos de la clase {@code Collections}.
     * </body>
     * <br>
     *
     * @param integerList Lista de enteros de tipo {@code ArrayList<Integer>}.
     * @param doubleList Lista de numeros de punto flotante de tipo {@code LinkedList<Double>}.
     * @param stringList Lista de cadenas de texto de tipo {@code ArrayList<String>}.
     * @param characterList Lista de caracteres de tipo {@code Vector<Character>}.
     * @param byteList Lista de bytes de tipo {@code Stack<Byte>}.
     * <br>
     * <body style="color: white">
     * <b>Conceptos Utilizados:</b>
     * <ul>
     *   <li>La interfaz {@code List}, que es implementada por todas las colecciones del metodo, permite
     *   que sean utilizadas directamente en los metodos {@code shuffle} y {@code sort}.</li>
     *   <li>{@code Collections.shuffle}: Desordena aleatoriamente los elementos internos de la lista.</li>
     *   <li>{@code Collections.sort}: Ordena los elementos de manera ascendente segun el metodo {@code compareTo}
     *   natural del tipo de datos.</li>
     * </ul>
     * </body>
     */
    private static void shuffleSection(ArrayList<Integer> integerList, LinkedList<Double> doubleList, ArrayList<String> stringList, Vector<Character> characterList, Stack<Byte> byteList) {
        Collections.shuffle(integerList); /*? Como todas estas instancias son internamente una Lista, se pueden pasar*/
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.1 Contenidos de integerList (ArrayList<Integer>) despues de shuffle: ") + integerList);
        Collections.sort(integerList);   /*? facilmente a un metodo que espera una lista*/
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.2 Contenidos de integerList (ArrayList<Integer>) despues de sort: ") + integerList);
        System.out.println();
    
        Collections.shuffle(doubleList);
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.3 Contenidos de doubleList (LinkedList<Double>) despues de shuffle: ") + doubleList);
        Collections.sort(doubleList);
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.4 Contenidos de doubleList (LinkedList<Double>) despues de sort: ") + doubleList);
        System.out.println();
    
        Collections.shuffle(stringList);
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.5 Contenidos de stringList (ArrayList<String>) despues de shuffle: ") + stringList);
        Collections.sort(stringList);
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.6 Contenidos de stringList (ArrayList<String>) despues de sort: ") + stringList);
        System.out.println();
    
        Collections.shuffle(characterList);
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.7 Contenidos de characterList (Vector<Character>) despues de shuffle: ") + characterList);
        Collections.sort(characterList);
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.8 Contenidos de characterList (Vector<Character>) despues de sort: ") + characterList);
        System.out.println();
    
        Collections.shuffle(byteList);
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.9 Contenidos de byteList (Stack<Byte>) despues de shuffle: ") + byteList);
        Collections.sort(byteList);
        System.out.println(Colorizer.colorWithMagentaLetters("1.A.10 Contenidos de byteList (Stack<Byte>) despues de sort: ") + byteList);
        System.out.println();
    }


    /**
     * <body style="color: white">
     * Metodo que encuentra los valores maximo y minimo en estructuras como {@code ArrayDeque}, 
     * {@code PriorityQueue} y {@code Map} utilizando las funcionalidades {@link Collections#max(Collection)} y 
     * {@link Collections#min(Collection)}.
     * 
     * <br><br>
     * Para {@code ArrayDeque} y {@code PriorityQueue}, se calcula el elemento menor y mayor segun 
     * el orden natural de los elementos contenidos en estas estructuras. En el caso del {@code Map}, los 
     * valores minimo y maximo se determinan sobre las claves del mapa.
     * 
     * <br><br>
     * <b>Conceptos utilizados:</b>
     * <ul>
     *   <li>Las interfaces {@code Collection} y {@code Deque}, que permiten gestionar las estructuras.</li>
     *   <li>El metodo {@code keySet} de {@code Map} para acceder a las claves como coleccion.</li>
     *   <li>El calculo del maximo y minimo basado en el orden natural de los elementos.</li>
     * </ul>
     * </body>
     * 
     * @param integerArrayDeque Deque de enteros sobre la cual se busca el maximo y minimo ({@link ArrayDeque}).
     * @param doublePriorityQueue PriorityQueue de numeros decimales para operaciones de maximo y minimo 
     *                            ({@link PriorityQueue}).
     * @param integerStringMap Mapa cuyas claves se analizan para encontrar el maximo y el minimo ({@link Map}<{@code 
     *                         Integer, String}>).
     * 
     * <br>
     * <body style="color: white">
     * <b>Excepciones:</b>
     * <ul>
     *   <li>{@link NullPointerException}: Si alguna estructura pasada es null o contiene valores nulos.</li>
     *   <li>{@code ClassCastException}: Si los elementos dentro de las colecciones no son comparables entre si.</li>
     * </ul>
     * </body>
     */
    private static void minMaxQueueAndMapSection(ArrayDeque<Integer> integerArrayDeque,
                                                 PriorityQueue<Double> doublePriorityQueue,
                                                 Map<Integer, String> integerStringMap) {
        System.out.println(Colorizer.colorWithMagentaLetters("4.1 Max en integerArrayDeque: ") +
                Collections.max(integerArrayDeque) + Colorizer.colorWithMagentaLetters(" Min en integerArrayDeque: ") +
                Collections.min(integerArrayDeque));
        System.out.println(Colorizer.colorWithMagentaLetters("4.2 Max en doublePriorityQueue: ") +
                Collections.max(doublePriorityQueue) + Colorizer.colorWithMagentaLetters(" Min en doublePriorityQueue: ") +
                Collections.min(doublePriorityQueue));
        System.out.println(Colorizer.colorWithMagentaLetters("4.3 Max en integerStringMap (clave): ") +
                Collections.max(integerStringMap.keySet()) + Colorizer.colorWithMagentaLetters(" Min en integerStringMap (clave): ") +
                Collections.min(integerStringMap.keySet()));
    }

   
    /**
     * <body style="color: white">
     * Metodo que realiza operaciones de mezclar (shuffle) y ordenar (sort) sobre estructuras como ArrayDeque, PriorityQueue y Map.
     * <br><br>
     * Este metodo utiliza {@code Collections.shuffle} para cambiar aleatoriamente el orden de elementos en las
     * estructuras, seguido por {@code Collections.sort} para ordenarlos en su orden ascendente natural. En
     * el caso del {@code Map}, los elementos se ordenan exclusivamente por su clave.
     * <br><br>
     * Las operaciones se realizan creando representaciones de listas temporales y volviendo a poblar las
     * estructuras originales tras las manipulaciones necesarias.
     * <br><br>
     * <b>Conceptos utilizados:</b>
     * <ul>
     *   <li>{@code Collections.shuffle}: Cambia aleatoriamente el orden de los elementos en una lista.</li>
     *   <li>{@code Collections.sort}: Ordena los elementos en una lista en su orden natural.</li>
     *   <li>Uso de streams para manejar mapas y ordenar sus claves.</li>
     * </ul>
     * </body>
     * <br>
     *
     * @param integerArrayDeque Deque de enteros que sera mezclado y luego ordenado ({@link ArrayDeque}).
     * @param doublePriorityQueue PriorityQueue de valores de punto flotante, mezclados y ordenados ({@link PriorityQueue}).
     * @param integerStringMap Mapa cuyas claves seran ordenadas ({@link Map}<{@code Integer, String}>).
     * <br>
     * <body style="color: white">
     * <b>Excepciones:</b>
     * <ul>
     *   <li>{@link NullPointerException}: Si alguna de las estructuras pasadas es null.</li>
     *   <li>{@code ClassCastException}: Si los elementos en las colecciones no son comparables entre si.</li>
     *   <li>{@code IllegalArgumentException}: Si surge un problema interno durante el shuffle o la ordenacion.</li>
     * </ul>
     * </body>
     */
    private static void shuffleQueueAndMapSection(ArrayDeque<Integer> integerArrayDeque,
                                                  PriorityQueue<Double> doublePriorityQueue,
                                                  Map<Integer, String> integerStringMap) {
        /*! Shuffle y Sort para integerArrayDeque */
        /*? Reducimos el arrayDeque hacia una lista para mezclar sus datos. Podemos pasarla hacia el constructor, ya que 
          ? la mayoria de las colleciones de Java tienen constructores que aceptan clases que implementen Collection<E>*/
        ArrayList<Integer> integerList = new ArrayList<>(integerArrayDeque);
        Collections.shuffle(integerList);
        integerArrayDeque.clear();
        integerArrayDeque.addAll(integerList);
        System.out.println(Colorizer.colorWithMagentaLetters("4.4 Contenidos de integerArrayDeque despues de shuffle: ") +
                integerArrayDeque);
        Collections.sort(integerList);
        integerArrayDeque.clear();
        integerArrayDeque.addAll(integerList);
        System.out.println(Colorizer.colorWithMagentaLetters("4.5 Contenidos de integerArrayDeque despues de sort: ") +
                integerArrayDeque);
        
        ArrayList<Double> doubleList = new ArrayList<>(doublePriorityQueue);
        Collections.shuffle(doubleList);
        doublePriorityQueue.clear();
        doublePriorityQueue.addAll(doubleList);
        System.out.println(Colorizer.colorWithMagentaLetters("4.6 Contenidos de doublePriorityQueue despues de shuffle: ") +
                doublePriorityQueue);
        Collections.sort(doubleList);
        doublePriorityQueue.clear();
        doublePriorityQueue.addAll(doubleList);
        System.out.println(Colorizer.colorWithMagentaLetters("4.7 Contenidos de doublePriorityQueue despues de sort: ") +
                doublePriorityQueue);
    
        /*! Sort for integerStringMap (No Shuffle) */
        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
        List <Integer> sortedKeys = new ArrayList<>(integerStringMap.keySet());
        Collections.sort(sortedKeys);
        for (Integer key :  sortedKeys) {
            sortedMap.put(key, integerStringMap.get(key));
        }
        System.out.println(Colorizer.colorWithMagentaLetters("4.8 Contenidos de integerStringMap despues de sort (por clave): ") +
                sortedMap);
    }
}
