package com.evolvlabs.I_JavaLangBasics;

//!Formato de las declaraciones de importe
import com.evolvlabs.IV_Extras.Colorizer;


/**
 * <body style="color: white">El presente archivo contiene ejemplos de los diferentes tipos de datos existentes en Java, tanto de los primitivos,
 * como de aquellos Wrappers del lenguaje. Ademas se presentan varias funciones adicionales que muestran la manera en la que Java realiza
 * un auto-boxing y auto-unboxing de los datos primitivos a su clase contraparte. </body>
 */
public class DataTypesPartOne {


    public static void main(String[] args) {

        /*? Declaracion de variables para el modulo*/

        byte primByteOne = 20;
        final byte primByteTwo = 14;
        Byte wrapByteOne = Byte.valueOf("25");
        final Byte wrapByteTwo = Byte.valueOf((byte) 100);

        short primShortOne = 1;
        final short primShortTwo = 2400;
        Short wrapShortOne = 25;
        final Short wrapShortTwo = Short.valueOf( (short) 32000);

        int primIntegerOne = 12;
        final int primIntegerTwo = 24;                    //! Declaracion general de enteros
        Integer wrapIntegerOne = 8;
        final Integer wrapIntegerTwo = Integer.valueOf("36"); //!Ejemplo de auto-boxing implicito

        /*? OJO: Para definir longs en Java usamos la L mayuscula luego del literal,
               ? por completeness lo coloco en ambas declaraciones*/
        long primLongOne = 1200;
        final long primLongTwo = 2400;
        Long wrapLongOne = 4500L;
        final Long wrapLongTwo = Long.valueOf(35460);

        /*? OJO: Para definir floats en Java usamos la f minuscula luego del literal. Sin la f el lenguaje toma por defecto
               ? a los valores como double  */
        float primFloatOne = 12.3f;
        final float primFloatTwo = 24.6f;
        Float wrapFloatOne = 45.6f;
        final Float wrapFloatTwo = Float.valueOf(36.6f);

        double primDoubleOne = 13.35;
        final double primDoubleTwo = 21.62;
        Double wrapDoubleOne = 45.45;
        final Double wrapDoubleTwo = Double.valueOf(37.89);

        /*? Metodologia de trabajo para esta clase*/

        System.out.println(Colorizer.color(
                "Resultados de Varias Llamadas por tipo de dato", Colorizer.Color.RED_BOLD_BRIGHT));
        System.out.println(Colorizer.color(
                "Resultados para tipo de dato byte", Colorizer.Color.RED_UNDERLINED));
        DataTypesPartOne.addTwoBytesPrintResult(primByteOne, primByteTwo, false);
        /*Pasamos de la llamada base primitiva hacia la envuelta con un parsin definido en la clase envolvente*/
        DataTypesPartOne.addTwoBytesPrintResult(Byte.valueOf(primByteOne),
                Byte.valueOf(primByteTwo));
        DataTypesPartOne.addTwoBytesPrintResult(wrapByteOne, primByteOne);
        System.out.println(Colorizer.color(
                "Resultados para tipo de dato short", Colorizer.Color.RED_UNDERLINED));
        DataTypesPartOne.addTwoShortsPrintResult(primShortOne, primShortTwo, false);
        DataTypesPartOne.addTwoShortsPrintResult(Short.valueOf(primShortOne),
                Short.valueOf(primShortTwo));
        DataTypesPartOne.addTwoShortsPrintResult(wrapShortOne, primShortOne);
        System.out.println(Colorizer.color(
                "Resultados para tipo de dato int", Colorizer.Color.RED_UNDERLINED));
        DataTypesPartOne.addTwoIntsPrintResult(primIntegerOne, primIntegerTwo, false);
        /*! Variante que forza al sistema a usar auto-boxing para el primer parametro*/
        DataTypesPartOne.addTwoIntsPrintResult(primIntegerOne, Integer.valueOf(primIntegerTwo));
        DataTypesPartOne.addTwoIntsPrintResult(Integer.valueOf(primIntegerOne),
                Integer.valueOf(primIntegerTwo));
        DataTypesPartOne.addTwoIntsPrintResult(wrapIntegerOne, primIntegerOne);
        System.out.println(Colorizer.color("Resultados para tipo de dato long",
                Colorizer.Color.RED_UNDERLINED));
        DataTypesPartOne.addTwoLongsPrintResult(primLongOne, primLongTwo, false);
        DataTypesPartOne.addTwoLongsPrintResult(Long.valueOf(primLongOne), primLongTwo);
        DataTypesPartOne.addTwoLongsPrintResult(Long.valueOf(primLongOne), Long.valueOf(primLongTwo));
        DataTypesPartOne.addTwoLongsPrintResult(wrapLongOne, primLongOne);
        System.out.println(Colorizer.color("Resultados para tipo de dato float",
                Colorizer.Color.RED_UNDERLINED));
        DataTypesPartOne.addTwoFloatsPrintResult(primFloatOne, primFloatTwo, false);
        DataTypesPartOne.addTwoFloatsPrintResult(Float.valueOf(primFloatOne), primFloatTwo);
        DataTypesPartOne.addTwoFloatsPrintResult(Float.valueOf(primFloatOne),
                Float.valueOf(primFloatTwo));
        DataTypesPartOne.addTwoFloatsPrintResult(wrapFloatOne, primFloatOne);
        System.out.println(Colorizer.color("Resultados para tipo de dato double",
                Colorizer.Color.RED_UNDERLINED));
        DataTypesPartOne.addTwoDoublesPrintResult(primDoubleOne, primDoubleTwo, false);
        DataTypesPartOne.addTwoDoublesPrintResult(Double.valueOf(primDoubleOne), primDoubleTwo);
        DataTypesPartOne.addTwoDoublesPrintResult(Double.valueOf(primDoubleOne),
                Double.valueOf(primDoubleTwo));
        DataTypesPartOne.addTwoDoublesPrintResult(wrapDoubleOne, primDoubleOne);

    }

    /**
     * <body style="color: white">
     *     El presente metodo toma dos valores <b style="font-family: consolas; color: green">PRIMITIVOS</b>, y realiza una suma
     *     rapida de los mismos para imprimirla en consola.
     * </body>
     * @param lhs : Izquierda de la ecuacion a + b
     * @param rhs : Derecha de la ecuacion a + b
     * @implNote  Como podemos ver, utiliza una revision con la clase envolvente de {@code Integer}, para revisar si el valor actual
     * de los argumentos no supera el limite de tolerancia de la propia clase entero.
     */
    private static void addTwoIntsPrintResult(int lhs, int rhs, boolean IntegerUnboxing){
        if (lhs == Integer.MAX_VALUE || rhs == Integer.MAX_VALUE){
            System.out.println(Colorizer.color("!!Los argumentos ingresados sobrepasan los limites de registro de entero!!", Colorizer.Color.RED_BOLD_BRIGHT));
        }
        System.out.println("Resultados  " +
                (IntegerUnboxing ? "desde addTwoIntsPrintResult(Integer, Integer)" : "desde addTwoIntsPrintResult(int, int)")
                +" = " + (lhs + rhs));
    }


    /**
     * <body style="color: white">
     *      Este es un ejemplo de una clase que acepta parametros de la clase envolvente de enteros, esto significa que los
     *      valores internos tienen mas helper metodos y facilitan su manejo. Usualmente esto se utiliza para escribir funciones que
     *      hagan interface con otros componentes de Java, sea EE o SE, ya que se maneja mucho estructuras basadas en las clases
     *      envolventes.
     * </body>
     * @param lhs: Izquierda de la ecuacion a + b
     * @param rhs: Derecha de la ecuacion a + b
     * @implNote : Como se puede notar, la clase no implementa su propio metodo de trabajo, pero si utiliza el helper metodo que convierte
     * una clase envolvente en entero regular para hacer un <b style="font-family: consolas; color: green">explicit unboxing</b> de las variables
     */
    public static void addTwoIntsPrintResult(Integer lhs, Integer rhs){
        DataTypesPartOne.addTwoIntsPrintResult(lhs.intValue(), rhs.intValue(), true);
    }

    /**
     * <body style="color: white">
     *     Este metodo toma dos valores <b style="font-family: consolas; color: green">PRIMITIVOS</b> de tipo double y
     *     realiza una suma rapida de los mismos, imprimiendo el resultado en consola.
     * </body>
     * @param lhs : Izquierda de la ecuacion a + b.
     * @param rhs : Derecha de la ecuacion a + b.
     * @implNote Este metodo maneja una revision con la clase {@code Double}, verificando si alguno de los valores es
     *           igual al limite de tolerancia de {@code Double.MAX_VALUE} y emitiendo una advertencia en tal caso.
     */
    private static void addTwoDoublesPrintResult(double lhs, double rhs, boolean DoubleUnboxing){
        if (lhs == Double.MAX_VALUE || rhs == Double.MAX_VALUE){
            System.out.println(Colorizer.color("!!Los argumentos ingresados sobrepasan los limites de registro de double!!", Colorizer.Color.RED_BOLD_BRIGHT));
        }
        System.out.println("Resultados  " +
                (DoubleUnboxing ? "desde addTwoDoublesPrintResult(Double, Double)" : "desde addTwoDoublesPrintResult(double, double)")
                +" = " + (lhs + rhs));
    }

    /**
     * <body style="color: white">
     *     Este metodo recibe parametros de la clase envolvente de doubles, {@code Double}, realizando un
     *     <b style="font-family: consolas; color: green">explicit unboxing</b> para devolver el resultado de la suma en consola.
     * </body>
     * @param lhs : Izquierda de la ecuacion a + b.
     * @param rhs : Derecha de la ecuacion a + b.
     * @implNote Este metodo es util para trabajar con estructuras dependientes de {@code Double}, por ejemplo en
     *           frameworks o APIs que aprovechan las clases envolventes.
     */
    public static void addTwoDoublesPrintResult(Double lhs, Double rhs){
        DataTypesPartOne.addTwoDoublesPrintResult(lhs.doubleValue(), rhs.doubleValue(), true);
    }

    /**
     * <body style="color: white">
     *     Este metodo toma dos valores <b style="font-family: consolas; color: green">PRIMITIVOS</b> de tipo float y
     *     realiza una suma rapida, imprimiendo el resultado en consola.
     * </body>
     * @param lhs : Izquierda de la ecuacion a + b.
     * @param rhs : Derecha de la ecuacion a + b.
     * @implNote Este metodo verifica si alguno de los valores es igual al limite de tolerancia de {@code Float.MAX_VALUE}.
     */
    private static void addTwoFloatsPrintResult(float lhs, float rhs, boolean FloatUnboxing){
        if (lhs == Float.MAX_VALUE || rhs == Float.MAX_VALUE){
            System.out.println(Colorizer.color("!!Los argumentos ingresados sobrepasan los limites de registro de float!!", Colorizer.Color.RED_BOLD_BRIGHT));
        }
        System.out.println("Resultados  " +
                (FloatUnboxing ? "desde addTwoFloatsPrintResult(Float, Float)" : "desde addTwoFloatsPrintResult(float, float)")
                +" = " + (lhs + rhs));
    }

    /**
     * <body style="color: white">
     *     Este metodo recibe parametros de la clase envolvente de floats, {@code Float}, realizando un
     *     <b style="font-family: consolas; color: green">explicit unboxing</b>.
     * </body>
     * @param lhs : Izquierda de la ecuacion a + b.
     * @param rhs : Derecha de la ecuacion a + b.
     */
    public static void addTwoFloatsPrintResult(Float lhs, Float rhs){
        DataTypesPartOne.addTwoFloatsPrintResult(lhs.floatValue(), rhs.floatValue(), true);
    }

    /**
     * <body style="color: white">
     *     Este metodo recibe parametros de tipo primitivo, {@code byte}, y procede a realizar una suma de ambos valores
     *     para luego devolver el resultado por consola.
     *     </body>
     * @param lhs: Izquierda de la ecuacion a + b
     * @param rhs: Derecha de la ecuacion a + b
     */
    private static void addTwoBytesPrintResult(byte lhs, byte rhs, boolean ByteUnboxing){
        if (lhs == Byte.MAX_VALUE || rhs == Byte.MAX_VALUE){
            System.out.println(Colorizer.color("!!Los argumentos ingresados sobrepasan los limites de registro de byte!!", Colorizer.Color.RED_BOLD_BRIGHT));
        }
        System.out.println("Resultados  " +
                (ByteUnboxing ? "desde addTwoBytesPrintResult(Byte, Byte)" : "desde addTwoBytesPrintResult(byte, byte)")
                +" = " + (lhs + rhs));
    }

    /**
     * <body style="color: white">
     *     Este metodo recibe parametros de la clase envolvente de bytes, {@code Byte}, realizando un
     *     <b style="font-family: consolas; color: green">explicit unboxing</b>.
     * </body>
     * @param lhs : Izquierda de la ecuacion a + b.
     * @param rhs : Derecha de la ecuacion a + b.
     */
    public static void addTwoBytesPrintResult(Byte lhs, Byte rhs){
        DataTypesPartOne.addTwoBytesPrintResult(lhs.byteValue(), rhs.byteValue(), true);
    }

    /**
     * <body style="color: white">
     *      El presente metodo permite sumar dos valores de tipo short cuando estos son enviados en forma de primitivos.
     *      La funcion internamente hace una suma y la imprime hacia consola siempre y cuando los valores esten en el limite
     *      de los valores soportados por la clase
     * </body>
     * @param lhs: Izquierda de la ecuacion a + b
     * @param rhs: Derecha de la ecuacion a + b
     */
    private static void addTwoShortsPrintResult(short lhs, short rhs, boolean ShortUnboxing){
        if (lhs == Short.MAX_VALUE || rhs == Short.MAX_VALUE){
            System.out.println(Colorizer.color("!!Los argumentos ingresados sobrepasan los limites de registro de short!!", Colorizer.Color.RED_BOLD_BRIGHT));
        }
        System.out.println("Resultados  " +
                (ShortUnboxing ? "desde addTwoShortsPrintResult(Short, Short)" : "desde addTwoShortsPrintResult(short, short)")
                +" = " + (lhs + rhs));
    }

    /**
     * <body style="color: white">
     *      El presente metodo permite sumar dos valores de tipo short cuando estos son enviados en forma de clase envolvente
     *      {@code Float}.
     *      La funcion internamente hace una suma y la imprime hacia consola siempre y cuando los valores esten en el limite
     *      de los valores soportados por la clase
     * </body>
     * @param lhs: Izquierda de la ecuacion a + b
     * @param rhs: Derecha de la ecuacion a + b
     */
    public static void addTwoShortsPrintResult(Short lhs, Short rhs){
        DataTypesPartOne.addTwoShortsPrintResult(lhs.shortValue(), rhs.shortValue(), true);
    }



    /**
     * <body style="color: white">
     * Este metodo toma dos valores <b style="font-family: consolas; color: green">PRIMITIVOS</b> tipo long
     * como parametros, realiza una suma de los mismos, y la imprime en consola.
     * </body>
     * @param lhs : Parte izquierda de la operacion a + b.
     * @param rhs : Parte derecha de la operacion a + b.
     */
    private static void addTwoLongsPrintResult(long lhs, long rhs, boolean LongUnboxing){
        if (lhs == Long.MAX_VALUE || rhs == Long.MAX_VALUE){
            System.out.println(Colorizer.color("!!Los argumentos ingresados sobrepasan los limites de registro de long!!", Colorizer.Color.RED_BOLD_BRIGHT));
        }
        System.out.println("Resultados  " +
                (LongUnboxing ? "desde addTwoLongsPrintResult(Long, Long)" : "desde addTwoLongsPrintResult(long, long)")
                +" = " + (lhs + rhs));
    }


    /**
     * <body style="color: white"> Permite realizar la suma de dos variables de tipo envolvente {@code Float}, de esta manera, los valores son
     * utilizados en base a una clase envolvente cuyos metodos dan mayor facilidad de trabajo interno</body>
     * @param lhs: Parte izquierda de la operacion a + b.
     * @param rhs: Parte derecha de la operacion a + b.
     */
    public static void addTwoLongsPrintResult(Long lhs, Long rhs){
        DataTypesPartOne.addTwoLongsPrintResult(lhs.longValue(), rhs.longValue(), true);
    }



}
