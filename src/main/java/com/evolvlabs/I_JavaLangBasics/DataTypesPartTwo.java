package com.evolvlabs.I_JavaLangBasics;


import com.evolvlabs.IV_Extras.Colorizer;
import java.util.Arrays;

/**
 * <body style="color: white"> El presente archivo incluye ejemplos de declaracion y uso de los metodos relacionados
 * con boolean, character y String, asi como de las variantes de String que son mutables como StringBuilder y StringBuffer
 * </body>
 */
public class DataTypesPartTwo {


    /**
     * <body style="color: white">Este es un ejemplo de una variable privada de la clase de tipo string, final</body>*/
    private final String nombreProyecto = "IntroductionToJava";

    /**
     * <body style="color: white">Este es un ejemplo de una variable publica de la clase de tipo StringBuilder, mutable
     * y no final</body>
     */
    public StringBuilder abecedario = new StringBuilder("abc");

    /**
     * <body style="color: white">Este es un ejemplo de una variable protected de la clase de tipo StringBuffer,
     * mutable y no final</body>
     */
    protected StringBuffer numeros = new StringBuffer("1,2,3,");




    public static void main(String[] args) {

        //! Imprimmamos un string literal a la consola y modifiquemoslo en varios lugares
        /*
         * Los metodos definidos a continuacion son una parte de los metodos presentes en la clase String, pero por norma
         * el objeto base (mes en este caso) nunca es variado, sino que cada llamada genera una string adicional aplicandole
         * la funcion.
         */
        final String mes = "Enero";
        System.out.println(Colorizer.color("Impresiones Generales de una Variable String Pura",
                Colorizer.Color.RED_UNDERLINED));
        System.out.println("Variable mes  = " + mes);
        System.out.println("Longitud de la variable mes = " + mes.length());
        System.out.println("Variable mes en mayusculas = " + mes.toUpperCase());
        System.out.println("Variable mes en minusculas = " + mes.toLowerCase());
        System.out.println("Variable mes repetida tres veces = " + mes.repeat(3));
        System.out.println("Arreglo interno de caracteres representativos de mes = "
                + Arrays.toString(mes.toCharArray()));
        
        //! Trabajemos con caracteres
        /*
         * Los metodos presentados a continuacion son la base de los metodos de la clase envolvente Character, se pueden usar
         * para analizar caracteres, tanto dentro de una String, de un arreglo de caracteres o de la consola. Generalmente se usan para 
         * capitalizar una String, o para analizar esta.
         *
         * Los metodos de trabajo como toUpperCase o toLowerCase no modifican el caracter base a menos que se le indique
         */
        System.out.println(Colorizer.color("Impresiones Generales Para un Caracter (A)", Colorizer.Color.RED_UNDERLINED));
        char letraA = 65;
        System.out.println("Character.toString(letraA) = " + Character.toString(letraA));
        System.out.println("Character.getType(letraA) [1 Significa UPPERCASE LETTER EN UTF-16]= " + Character.getType(letraA));
        System.out.println("Character.isLetter(letraA) = " + Character.isLetter(letraA));
        System.out.println("Character.isDigit(letraA) = " + Character.isDigit(letraA));
        System.out.println("Character.isUpperCase(letraA) = " + Character.isUpperCase(letraA));
        System.out.println("Character.isLowerCase(letraA) = " + Character.isLowerCase(letraA));
        System.out.println("Character.isWhitespace(letraA) = " + Character.isWhitespace(letraA));
        System.out.println("Character.isSpaceChar(letraA) = " + Character.isSpaceChar(letraA));
        System.out.println("Character.toLowerCase(letraA) = " + (letraA= Character.toLowerCase(letraA)));
        System.out.println("letraA = " + letraA); //Llama al metodo toString que convierte, luego de un autowrap a string a este
                                                  // caracter

        //! Trabajemos con las versiones modificables de Strings
        DataTypesPartTwo instance = new DataTypesPartTwo();
        System.out.println(Colorizer.color(
                "Impresiones Generales Para una Variable String Mutable", Colorizer.Color.RED_UNDERLINED));
        System.out.println("Variable publica Abecedario (StringBuilder)= " + instance.getAbecedario());
        System.out.println("Variable protegida Numeros (StringBuffer)= " + instance.getNumeros());
        System.out.println("Variable privada NombreProyecto (String)= " + instance.getNombreProyecto());
        System.out.println(Colorizer.color("Modificaciones a la variable Abecedario (StringBuilder)",
                Colorizer.Color.GREEN_UNDERLINED));
        instance.getAbecedario().append('d').append("e").append("f");
        System.out.println("instance.getAbecedario() luego de anadirle d,e,f = " + instance.getAbecedario());
        instance.getAbecedario().replace(0,1,"A");
        System.out.println("instance.getAbecedario() luego de reemplazar el primer caracter por A = " + instance.getAbecedario());
        instance.getAbecedario().repeat("ghi",2);
        System.out.println("instance.getAbecedario() luego de repetir ghi dos veces = " + instance.getAbecedario());

        System.out.println(Colorizer.color("Modificaciones a la variable Numeros (StringBuffer)",
                Colorizer.Color.GREEN_UNDERLINED));
        System.out.println("Variable protegida numeros (StringBuffer) = " + instance.getNumeros());
        instance.getNumeros().append("4").append(",5").append(",6");
        System.out.println("instance.getNumeros() luego de anadirle 4, 5, 6 = " + instance.getNumeros());
        instance.getNumeros().replace(0, 1, "2");
        System.out.println("instance.getNumeros() luego de reemplazar el primer caracter por 2 = " + instance.getNumeros());
        instance.getNumeros().reverse();
        System.out.println("instance.getNumeros() luego de invertir el orden de los caracteres = " + instance.getNumeros());
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public StringBuffer getNumeros() {
        return numeros;
    }

    public StringBuilder getAbecedario() {
        return abecedario;
    }
}
