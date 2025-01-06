package com.evolvlabs.I_JavaLangBasics;
/**
 * <body style="color: white">Este método imprime una leyenda visual en un marco que indica los colores 
 * que representan números, caracteres y símbolos.</body>
 */


import com.evolvlabs.IV_Extras.Colorizer;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author : Santiago Arellano
 * @Description :
 * <body style="color: white">El presente archivo muestra una implementacion para un programa que modifica una string ingresada
 * por el usuario. La convierte si es posible y la distribuye en distintas formas en la pantalla para demostrar la capacidad de Java
 * de Manejar estructuras de control, tanto de flujo como logicas. Asimismo, se trabajo con varios tipos de datos y
 * casts.</body>
 */
public class ModifyYourString {

    public static void main(String[] args) {
        System.out.println(Colorizer.color("Bienvenido a nuestro primer programa de prueba!", Colorizer.Color.CYAN));
        System.out.println(Colorizer.color("Ingresa un numero cualquier para ingresar al sistema (-1 para salir)", Colorizer.Color.RED_BOLD_BRIGHT));
        Integer userInput = 0;
        
        
        /*! Usamos una sentencia do-while para manejar inputs por consola. Util por su at-least-once modelo de trabajo*/
        do{
            Scanner scanner = new Scanner(System.in);
            boolean isValidInput = false;

            /*! Usamos una sentencia while dado su check-first modelo de trabajo*/
            while (!isValidInput) {
                System.out.print("Por favor, ingresa un número: ");
                String input = scanner.nextLine();
                try {
                    userInput = Integer.parseInt(input);
                    isValidInput = true;
                } catch (NumberFormatException e) { /*! Agarramos esta excepcion porque se lanza en cualquier caso en el que
                                                      ! el parsing del numero falle.*/
                    System.out.println("Entrada inválida. Por favor ingresa un número válido.");
                }
            }
            if (userInput == -1) {break;}
            /*! Una vez leido el numero pasamos al loop principal*/
            System.out.println(Colorizer.color("!A continuacion una string de su preferencia!", Colorizer.Color.RED_BOLD_BRIGHT));
            try{
                String readLine;
                do {
                    System.out.print("Por favor, ingresa una cadena no vacía: ");
                    readLine = scanner.nextLine();
                    if (readLine.isBlank()) {
                        System.out.println("Entrada inválida. La cadena no puede estar vacía.");
                    }
                } while (readLine.isBlank());

                System.out.println("\n");
                //! Categoria de Analysis
                System.out.println(Colorizer.color("Analisis preliminar para Input: " + readLine, Colorizer.Color.YELLOW_BOLD_BRIGHT));
                Boolean isAlphaNum = isAlphaNum(readLine);
                Boolean isAlphabetical = isAlphabetical(readLine);
                Boolean isNumerical = isNumerical(readLine);
                System.out.println();
                System.out.println("isAlphaNum = " + isAlphaNum);
                System.out.println("isAlphabetical = " + isAlphabetical);
                System.out.println("isNumerical = " + isNumerical);
                System.out.println();
                System.out.println(Colorizer.color("Impresiones de Ingreso con formato", Colorizer.Color.YELLOW_BOLD_BRIGHT));
                //! Realicemos un trabajo con la string independiente del tipo registrado anteriormente
                System.out.println();
                System.out.println(Colorizer.color("Impresion en Diagonales", Colorizer.Color.CYAN));
                imprimirEnDiagonales(readLine);
                System.out.println();
                System.out.println(Colorizer.color("Impresion en Espiral", Colorizer.Color.CYAN));
                imprimirEnEspiral(readLine);
                System.out.println();
                System.out.println(Colorizer.color("Impresion en Piramide", Colorizer.Color.CYAN));
                imprimirEnPiramide(readLine);
                System.out.println();
                System.out.println(Colorizer.color("Impresion en Piramide Invertida", Colorizer.Color.CYAN));
                imprimirEnPiramideInvertida(readLine);
                System.out.println();
                System.out.println(Colorizer.color("Impresion en Forma de Reloj", Colorizer.Color.CYAN));
                imprimirEnReloj(readLine);

                //! Realicemos un analisis con el tipo de texto ingresado, si es una cadena modifiquemosla, si es alfanumerico
                //! Trabajemosla para colorear los numeros en rojo como si fueran incorrectos
                //! Si es un numero intentemos identificar el tipo de numero que representa y convertirlo al valor original
                System.out.println(Colorizer.color("Analisis de Ingreso en Base a Contenido", Colorizer.Color.YELLOW_BOLD_BRIGHT));

                if (isAlphabetical){
                    analyzeAlphabeticString(readLine);
                } else if (isAlphaNum){
                    analyzeAlphaNumString(readLine);
                }
                else if (isNumerical){
                    analyzeNumericalInput(readLine);
                }

                if (!isNumerical && !isAlphabetical && !isAlphaNum){
                    System.out.println( Colorizer.color("La cadena ingresada no es un numero correcto, se intentara corregirlo", Colorizer.Color.RED_BOLD_BRIGHT));
                    analyzeNumericalInput(readLine);
                }

            }
            catch (NoSuchElementException noSuchElementException){
                /*! Sucede si la linea leida estaba en blanco o no se pudo leer correctamente*/
                System.out.println(Colorizer
                        .color("Exception: NoSuhElementException Thrown from line 48, resolved by try-catch",
                                Colorizer.Color.MAGENTA_BOLD));
            }
            catch (IllegalStateException illegalStateException){
                /*! Sucede si el scanner se cierra antes de la lectura (errores internos posibles)*/
                System.out.println( Colorizer
                        .color("Exception: IllegalStateException Thrown from line 48, resolved by try-catch",
                                Colorizer.Color.MAGENTA_BOLD));
            }

            
        } while(!Objects.equals(userInput, Integer.valueOf(-1)));
    }

    /**
     * <body style="color: white"> El presente metodo muestra la utilidad de los metodos de string y caracteres para
     * transformar un ingreso y modificarlo. Es un inicio, asi como el resto de los metodos al manejo base de Java</body>
     */
    private static void analyzeAlphabeticString(String readLine){
        System.out.println(Colorizer.color("La cadena ingresada es de tipo alfabetico", Colorizer.Color.MAGENTA_BOLD));
        //! Imprimir capitalized form pero con un color diferente al caracter inicial

        var arrayOfChars = readLine.toCharArray();
        System.out.print("Input Capitalized = " );
        System.out.print(Colorizer.color(String.valueOf(Character.toUpperCase(arrayOfChars[0]))
                , Colorizer.Color.YELLOW_BOLD_BRIGHT));
        for(int i = 1; i < arrayOfChars.length; i++){
            System.out.print(Colorizer.color(String.valueOf(Character.toLowerCase(arrayOfChars[i]))
                    , Colorizer.Color.BLUE_BRIGHT));
        }
        System.out.println();
        //! Impresion de la palabra todo en mayusculas
        System.out.print("Input en Mayusculas = " );
        System.out.println(Colorizer.color(readLine.toUpperCase(), Colorizer.Color.YELLOW_BOLD_BRIGHT));
        //! Impresion de la palabra todo en minusculas
        System.out.print("Input en Minusculas = " );
        System.out.println( Colorizer.color(readLine.toLowerCase(), Colorizer.Color.YELLOW_BOLD_BRIGHT));
        //! Impresion de la palabra en camelcase y arcoiris
        System.out.print("Input en CamelCase = " );
        for(int i = 0; i < arrayOfChars.length; i++){
            if (i % 2 == 0){
                System.out.print(Colorizer.color(String.valueOf(Character.toUpperCase(arrayOfChars[i]))
                        , Colorizer.Color.YELLOW_BOLD_BRIGHT));
            }
            else {
                System.out.print(Colorizer.color(String.valueOf(Character.toLowerCase(arrayOfChars[i]))
                        , Colorizer.Color.BLUE_BRIGHT));
            }
        }
        System.out.println();
    }

    /**
     * <body style="color: white"> El presente metodo muestra la utilidad de los metodos de string y caracteres para
     * transformar un ingreso y modificarlo si este es de tipo alfa-numerico. Es un inicio, asi como el resto de los metodos al manejo base de Java</body>
     */
    private static void analyzeAlphaNumString(String readLine){
        System.out.println(Colorizer.color("La cadena ingresada es de tipo alfa-numerico", Colorizer.Color.MAGENTA_BOLD));
        //! Imprimir capitalized form pero con un color diferente al caracter inicial
        var arrayOfChars = readLine.toCharArray();
        System.out.print("Input coloreado por tipo de entrada = " );
        //! Parsing del texto para determinar tipos de caracteres e imprimir con un color adecuado
        for (char ch : readLine.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                System.out.print(Colorizer.color(String.valueOf(ch), Colorizer.Color.GREEN_BRIGHT));
            } else if (Character.isDigit(ch)) {
                System.out.print(Colorizer.color(String.valueOf(ch), Colorizer.Color.RED_BRIGHT));
            } else {
                System.out.print(Colorizer.color(String.valueOf(ch), Colorizer.Color.CYAN_BRIGHT));
            }
        }
        System.out.println();
        
        //! Mostrar leyenda con colores correspondientes
        printAlphaNumLegend();
    }

    private static void printAlphaNumLegend() {
        StringBuilder legendBorder = new StringBuilder();
        legendBorder.append('+');

        legendBorder.repeat('-',38);
        legendBorder.append('+');
        System.out.println(legendBorder);
        System.out.println(String.format("%1s", "|") + String.format("%-30s", Colorizer.color("Numeros", Colorizer.Color.RED_BRIGHT)) +
                String.format("%30s", Colorizer.color("(Rojo)", Colorizer.Color.RED_BRIGHT)) + String.format("%1s", "|"));
        System.out.println(String.format("%1s", "|") + String.format("%-30s", Colorizer.color("Caracteres", Colorizer.Color.GREEN_BRIGHT)) +
                String.format("%30s", Colorizer.color("(Verde)", Colorizer.Color.GREEN_BRIGHT)) + String.format("%1s", "|"));
        System.out.println(String.format("%1s", "|") + String.format("%-30s", Colorizer.color("Simbolos", Colorizer.Color.CYAN_BRIGHT)) +
                String.format("%30s", Colorizer.color("(Cyan)", Colorizer.Color.CYAN_BRIGHT)) + String.format("%1s", "|"));

        System.out.println(legendBorder);
        System.out.println("\n");
    }

    private static void analyzeNumericalInput(String readLine){
        //! Primero debemos determinar que tipo de caracter the particion tenemos, si encontramos una coma podemos
        //! movernos directamente a la conversion a doble y de doble pasar a cualquier tipo de dato, si tenemos mas de
        //! una coma, o mas de un punto, o mas de un _ tenemos un valor numerico malformado y no podemos traducirlo a menos
        //! que consideremos que la _ simboliza millones


        StringBuilder parsedString = new StringBuilder();
        Integer[] counters = {0 /*Comas*/,0 /*Puntos*/,0/*_*/};
        Integer[][] countersPositions = new Integer[3][readLine.length()];
        //! Relleno de los arreglos
        for (int i = 0; i < countersPositions.length; i++) {
            Arrays.fill(countersPositions[i], 0);
        }
        var array = readLine.toCharArray();
        Character[] arrayOfPermittedDelimiters = {',','.','_'};
        for(int i =0; i <  array.length; i++){
            if (Character.isDigit(array[i])){
                parsedString.append(array[i]);
            }
            else {
                int finalI = i;
                if (Arrays.stream(arrayOfPermittedDelimiters).anyMatch(character -> Objects.equals(character, array[finalI]))){
                    //! Analysis de caracteres
                    switch(array[i]){
                        case ',' : {
                            counters[0]++;
                            countersPositions[0][i]++;
                            break;
                        }
                        case '.' : {
                            counters[1]++;
                            countersPositions[1][i]++;
                            break;
                        }
                        case '_' : {
                            counters[2]++;
                            countersPositions[2][i]++;
                            break;
                        }
                    }
                }
            }
        }

        //! Revisamos si los contadores no son unicos, si tienen mezcla la string esta malformada
        if ((counters[0] >= 1 && counters[1] >= 1 )||
                (counters[0] >= 1 && counters[2] >= 1)){
            System.out.println( Colorizer.color("El ingreso no es un numero valido. " +
                            "La string contiene caracteres que causan que este malformada y no puede traducirse.\nEsto" +
                            "pudo darse por la presencia de varios caracteres delimitantes en la cadena.",
                    Colorizer.Color.RED_BRIGHT));
            return;
        }

        //! Caso de las lineas
        if (counters[2] > 1){
            int lastCommaIndex = readLine.lastIndexOf('_');
            correctPositions(parsedString, countersPositions, lastCommaIndex);
        }
        else {
            for (int i = 0; i < countersPositions[2].length - 1; i++) {
                if (countersPositions[2][i] > 0) {
                    parsedString.insert(i, '_');
                }
            }
        }

        //! Caso de las comas
        if (counters[0] > 1) /*Tenemos mas de una coma*/ {
            int lastCommaIndex = readLine.lastIndexOf(',');
            correctPositions(parsedString, countersPositions, lastCommaIndex);
        } else if (counters[0] == 1){
            //! Tenemos una sola coma
            for (int i = 0; i < countersPositions[0].length - 1; i++) {
                if (countersPositions[0][i] > 0) {
                    parsedString.insert(i,'.');
                }
            }
        }

        //! Caso de los puntos
        if (counters[1] > 1){
            int lastCommaIndex = readLine.lastIndexOf('.');
            correctPositions(parsedString, countersPositions, lastCommaIndex);
        }
        else {
            for (int i = 0; i < countersPositions[1].length - 1; i++) {
                if (countersPositions[1][i] > 0) {
                    parsedString.insert(i, ".");
                }
            }
        }

        parsedString = new StringBuilder(parsedString.toString().replaceAll("_",""));
        //! Una vez arreglada la cadena procedemos a trabajar en convertirla
        ///? Flags para verificar éxito de las conversiones
        boolean isByteSuccessful = false;
        boolean isShortSuccessful = false;
        boolean isIntSuccessful = false;
        boolean isLongSuccessful = false;
        boolean isFloatSuccessful = false;
        boolean isDoubleSuccessful = false;
        
        //! Conversión a Byte
        try {
            byte byteValue = Byte.parseByte(parsedString.toString());
            isByteSuccessful = true;
            System.out.println(Colorizer.color("Convertido a byte: " + byteValue, Colorizer.Color.GREEN_BRIGHT));
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println(Colorizer.color("Error al convertir a byte: " + e.getMessage(), Colorizer.Color.RED_BRIGHT));
        }
        
        //! Conversión a Short
        try {
            short shortValue = Short.parseShort(parsedString.toString());
            isShortSuccessful = true;
            System.out.println(Colorizer.color("Convertido a short: " + shortValue, Colorizer.Color.GREEN_BRIGHT));
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println(Colorizer.color("Error al convertir a short: " + e.getMessage(), Colorizer.Color.RED_BRIGHT));
        }
        
        //! Conversión a Integer
        try {
            int intValue = Integer.parseInt(parsedString.toString());
            isIntSuccessful = true;
            System.out.println(Colorizer.color("Convertido a Integer: " + intValue, Colorizer.Color.GREEN_BRIGHT));
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println(Colorizer.color("Error al convertir a Integer: " + e.getMessage(), Colorizer.Color.RED_BRIGHT));
        }
        
        //! Conversión a Long
        try {
            long longValue = Long.parseLong(parsedString.toString());
            isLongSuccessful = true;
            System.out.println(Colorizer.color("Convertido a Long: " + longValue, Colorizer.Color.GREEN_BRIGHT));
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println(Colorizer.color("Error al convertir a Long: " + e.getMessage(), Colorizer.Color.RED_BRIGHT));
        }
        
        //! Conversión a Float
        try {
            float floatValue = Float.parseFloat(parsedString.toString());
            isFloatSuccessful = true;
            System.out.println(Colorizer.color("Convertido a Float: " + floatValue, Colorizer.Color.GREEN_BRIGHT));
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println(Colorizer.color("Error al convertir a Float: " + e.getMessage(), Colorizer.Color.RED_BRIGHT));
        }
        
        //! Conversión a Double
        try {
            double doubleValue = Double.parseDouble(parsedString.toString());
            isDoubleSuccessful = true;
            System.out.println(Colorizer.color("Convertido a Double: " + doubleValue, Colorizer.Color.GREEN_BRIGHT));
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println(Colorizer.color("Error al convertir a Double: " + e.getMessage(), Colorizer.Color.RED_BRIGHT));
        }
        

    }

    private static void correctPositions(StringBuilder parsedString, Integer[][] countersPositions, int lastCommaIndex) {
        for (int i = 0; i < countersPositions[0].length - 1; i++) {
            if (countersPositions[0][i] > 0 && i != lastCommaIndex) {
                parsedString.insert(i, '_');
            } else if (i == lastCommaIndex) {
                parsedString.insert(i, '.');
            }
        }
    }


    /**
     * <body style="color : white">El presente metodo toma una entrada de string del usuario y la imprimira en un cuadrado
     * usando las diagonales para imprimir los caracteres de la string</body>
     * @param readLine: String ingresada por el usuario
     */
    private static void imprimirEnDiagonales(String readLine) {
        var array = readLine.toCharArray();
        for(int row = 0; row < readLine.length(); row++){
            for(int col = 0; col < readLine.length(); col++){
                if (row == col) {
                    System.out.print(" " + Colorizer.color(Character.toString(array[col]),
                            Colorizer.Color.GREEN_BRIGHT) + " ");
                } else if (row + col == readLine.length() - 1) {
                    System.out.print(" " + Colorizer.color(Character.toString(array[row]),
                            Colorizer.Color.BLUE_BRIGHT) + " ");
                } else {
                    System.out.print(" ~ ");
                }
            }
            System.out.println();
        }
    }

    /**
     * <body style="color : white">El presente metodo toma una entrada de string del usuario y la imprimira en un cuadrado
     * usando el espiral para imprimir los caracteres de la string. Es decir, imprime la string en los lados con tal de que la palabra
     * se pueda seguir leyendo, hacia delante y atras mientras te mueves por los lados
     * @param readLine: String ingresada por el usuario
     */
    private static void imprimirEnEspiral(String readLine){
        var array = readLine.toCharArray();
        for(int row = 0; row < readLine.length(); row++){
            if (row == 0){
                for (Character chars:array) {
                    System.out.print(" " + Colorizer.color(Character.toString(chars),
                            Colorizer.Color.GREEN_BRIGHT) + " ");
                }
            }
            else if  (row == (readLine.length() -1)){
                for(int j = array.length - 1; j >= 0; j--){
                    System.out.print(" " + Colorizer.color(Character.toString(array[j]),
                            Colorizer.Color.BLUE_BRIGHT) + " ");
                }
            }
            else { /*? Impresion de caracteres intermedios*/
                for(int col = 0; col < readLine.length(); col++){
                    if (col == 0){
                        System.out.print(" " + Colorizer.color(Character.toString(array[row]),
                                Colorizer.Color.BLUE_BRIGHT) + " ");
                    }
                    else if (col == readLine.length() - 1){
                        System.out.print(" " + Colorizer.color(Character.toString(array[col - row]),
                                Colorizer.Color.GREEN_BRIGHT) + " ");
                    }
                    else {
                        System.out.print(" ~ ");
                    }

                }
            }
            System.out.println();
        }
    }

    
    /**
     * <body style="color: white">El presente metodo toma una cadena ingresada por el usuario y la imprime en forma de piramide. Es decir, cada
     * caracter de la cadena ingresada se posiciona en una fila del centro de un "triangulo", alineada con un espacio igual a la longitud
     * total de la cadena. Conforme se avanza hacia filas inferiores, los caracteres forman un patron simetrico desplazado que
     * crea la forma visual de una piramide.</body>
     * @param readLine: String ingresada por el usuario
     */
    private static void imprimirEnPiramide(String readLine){
        var array = readLine.toCharArray();
        for(int row = 0; row < readLine.length(); row++){
            for(int col = 0; col < (readLine.length()*2 - 1); col++){
                var mid = (readLine.length()*2 - 1)/2;
                if(col == mid - row || col == mid + row){
                    System.out.print(" " + Colorizer.color(Character.toString(array[row]),
                            Colorizer.Color.BLUE_BRIGHT) + " ");
                }
                else {
                    System.out.print(" ~ ");
                }
            }
            System.out.println();
        }
    }

    /**
     * <body style="color: white">El presente metodo toma una cadena ingresada por el usuario y la imprime en forma de piramide invertida.
     * Es decir, cada caracter de la cadena ingresada se posiciona en una fila del centro de un "triangulo", alineada con un espacio igual
     * a la longitud total de la cadena. Conforme se avanza hacia filas inferiores, los caracteres forman un patron simetrico desplazado
     * que crea la forma visual de una piramide invertida.</body>
     * @param readLine : String ingresada por el usuario
     */
    private static void imprimirEnPiramideInvertida(String readLine){
        var array = readLine.toCharArray();
        for(int row = readLine.length() - 1; row >= 0; row--){
            for(int col = (readLine.length()*2 - 1) -1; col >= 0; col--){
                var mid = (readLine.length()*2 - 1)/2;
                if(col == mid - row || col == mid + row){
                    System.out.print(" " + Colorizer.color(Character.toString(array[row]),
                            Colorizer.Color.BLUE_BRIGHT) + " ");
                }
                else {
                    System.out.print(" ~ ");
                }
            }
            System.out.println();
        }
    }

    /**
     * <body style="color: white">El presente metodo toma una cadena ingresada por el usuario y la imprime
     * en forma de reloj o diamante expandido. Es decir, cada carácter de la cadena
     * se posiciona visualmente en las diagonales de un espacio modelado como un reloj.
     * En las filas inferiores se llama al metodo para formar una pirámide invertida con la misma cadena.</body>
     *
     * @param readLine Cadena ingresada por el usuario que será utilizada
     *                 para la representación visual tipo reloj.
     */
    private static void imprimirEnReloj(String readLine){
        var array = readLine.toCharArray();
        for(int row = 0; row < readLine.length() -1; row++){
            for(int col = 0; col < (readLine.length()*2 - 1); col++){
                var mid = (readLine.length()*2 - 1)/2;
                if(col == mid - row || col == mid + row){
                    System.out.print(" " + Colorizer.color(Character.toString(array[row]),
                            Colorizer.Color.BLUE_BRIGHT) + " ");
                }
                else {
                    System.out.print(" ~ ");
                }
            }
            System.out.println();
        }
        imprimirEnPiramideInvertida(readLine);
    }

    /**
     * <body style="color: white"> El presente metodo toma una string de entrada del usuario y revisa su contenido para determinar
     * si tiene una consistencia alfa-numerica, es decir, si contiene caracteres y numeros en un mismo ingreso. De tener esta
     * consistencia, el metodo returna un booleano true.</body>
     * @param userInput: String ingresada por el usuario
     * @return : Booleano que indica si la string ingresada es alfa-numerica
     */
    private static boolean isAlphaNum(String userInput){
        Integer[] counters = {0,0}; //! Declaracion e inicializacion para arreglo de dos valores
        for(Character character : userInput.toCharArray()){
            //? Si es alfabetico se incrementa el contador inicial
            if (Character.isAlphabetic(character)){counters[0]++;}
            //? Si es numerico se incrementa el contador secundario
            if (Character.isDigit(character)){counters[1]++;}
        }

        return (counters[1] > 0 && counters[0] > 0) /*! Retorna true si tenemos aunque sea un numero y aunque sea un caracter
                                                      ! no numerico, si no se cumplen enviara falso*/;
    }

    /**
     * <body style="color: white">El presente metodo toma una string de entrada del usuario y revisa su contenido para determinar
     * si tiene una consistencia alfabetica, es decir, si contiene caracteres en un mismo ingreso. De tener esta consistencia,
     * el metodo retorna un booleano true.
     * @param userInput: String ingresada por el usuario
     * @return : Booleano que indica si la string ingresada es alfabetica
     */
    private static boolean isAlphabetical(String userInput) throws IllegalArgumentException{
        int index = 0;
        if (userInput == null || userInput.isEmpty() || userInput.isBlank()){
            throw new IllegalArgumentException("Error: Incorrect Input FOr Method is Alphabeticl thrown on line 99");
        }
        char[] charArray = userInput.toCharArray();
        while (index < userInput.length()){
            if (!Character.isAlphabetic(charArray[index])
                    && !Character.isWhitespace(charArray[index])){
                return (false);
            }
            index++;
        }
        return true;
    }

    /**
     * <body style="color: white">El presente metodo toma una string de entrada del usuario y revisa su contenido para determinar
     * si tiene una consistenia totalmente numerica. De tener esta consistencia el metodo retorna un booleano true</body>
     * @param userInput: String ingresada por el usuario
     * @return: Booleano que indica si la string ingresada es numerica
     */
    private static boolean isNumerical(String userInput){
    
        Boolean analysisResult = Boolean.TRUE;
        Character[] permittedCharacters = {'.', ','};
        boolean containsDigit = false;
        boolean allowSeparator = true;
    
        for (int index = 0; index < userInput.length(); index++) {
            char currentChar = userInput.charAt(index);
    
            if (Character.isDigit(currentChar)) {
                containsDigit = true;
            } else if (Arrays.asList(permittedCharacters).contains(currentChar)) {
                if (!allowSeparator) {
                    analysisResult = false;
                    break;
                }
                allowSeparator = false;
            } else if (currentChar == '_') {
                continue;
            } else {
                analysisResult = false;
                break;
            }
        }
    
        return analysisResult && containsDigit;
    }


}
