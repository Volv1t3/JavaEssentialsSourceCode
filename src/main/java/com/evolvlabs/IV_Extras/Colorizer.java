package com.evolvlabs.IV_Extras;

/**
 * Clase implementada en base de aquella presente en el repositorio maven del siguiente URL: https://mvnrepository.com/artifact/io.github.kamilszewc/java-ansi-text-colorizer.
 * La libreria fue portada en su totalidad a este archivo para poder ser utilizada en los modulos del taller.
 *
 * Todos los derechos de la implementacion son atribuibles al autor Kamil Szewc.
 */
public class Colorizer {
    static boolean isSystemSupported = true;

    private Colorizer() {
    }

    public static String color(String text, Color color) {
        if (isSystemSupported) {
            String var10000 = color.toString();
            return var10000 + text + String.valueOf(Colorizer.Color.RESET);
        } else {
            return text;
        }
    }

    public static String color(String text, BackgroundColor backgroundColor) {
        if (isSystemSupported) {
            String var10000 = backgroundColor.toString();
            return var10000 + text + String.valueOf(Colorizer.Color.RESET);
        } else {
            return text;
        }
    }
    public static String colorWithYellowLetters(String input){
        return color(input, Color.YELLOW_BOLD);
    }
    public static String colorWithCyanLetters(String input){
        return color(input, Color.CYAN_BOLD);
    }
    public static String colorWithMagentaLetters(String input){
        return color(input, Color.MAGENTA_BOLD);
    }

    static {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows") && !osName.endsWith("11")) {
            isSystemSupported = false;
        }

    }

    public static String colorWithRedLetters(String s) {
        return Colorizer.color(s, Color.RED);
    }

    public static enum Color {
        RESET("\u001b[0m"),
        BLACK("\u001b[0;30m"),
        RED("\u001b[0;31m"),
        GREEN("\u001b[0;32m"),
        YELLOW("\u001b[0;33m"),
        BLUE("\u001b[0;34m"),
        MAGENTA("\u001b[0;35m"),
        CYAN("\u001b[0;36m"),
        WHITE("\u001b[0;37m"),
        BLACK_BOLD("\u001b[1;30m"),
        RED_BOLD("\u001b[1;31m"),
        GREEN_BOLD("\u001b[1;32m"),
        YELLOW_BOLD("\u001b[1;33m"),
        BLUE_BOLD("\u001b[1;34m"),
        MAGENTA_BOLD("\u001b[1;35m"),
        CYAN_BOLD("\u001b[1;36m"),
        WHITE_BOLD("\u001b[1;37m"),
        BLACK_BRIGHT("\u001b[0;90m"),
        RED_BRIGHT("\u001b[0;91m"),
        GREEN_BRIGHT("\u001b[0;92m"),
        YELLOW_BRIGHT("\u001b[0;93m"),
        BLUE_BRIGHT("\u001b[0;94m"),
        MAGENTA_BRIGHT("\u001b[0;95m"),
        CYAN_BRIGHT("\u001b[0;96m"),
        WHITE_BRIGHT("\u001b[0;97m"),
        BLACK_BOLD_BRIGHT("\u001b[1;90m"),
        RED_BOLD_BRIGHT("\u001b[1;91m"),
        GREEN_BOLD_BRIGHT("\u001b[1;92m"),
        YELLOW_BOLD_BRIGHT("\u001b[1;93m"),
        BLUE_BOLD_BRIGHT("\u001b[1;94m"),
        MAGENTA_BOLD_BRIGHT("\u001b[1;95m"),
        CYAN_BOLD_BRIGHT("\u001b[1;96m"),
        WHITE_BOLD_BRIGHT("\u001b[1;97m"),
        BLACK_UNDERLINED("\u001b[4;30m"),
        RED_UNDERLINED("\u001b[4;31m"),
        GREEN_UNDERLINED("\u001b[4;32m"),
        YELLOW_UNDERLINED("\u001b[4;33m"),
        BLUE_UNDERLINED("\u001b[4;34m"),
        MAGENTA_UNDERLINED("\u001b[4;35m"),
        CYAN_UNDERLINED("\u001b[4;36m"),
        WHITE_UNDERLINED("\u001b[4;37m");

        private final String color;

        private Color(String color) {
            this.color = color;
        }

        public String toString() {
            return this.color;
        }
    }

    public static enum BackgroundColor {
        RESET("\u001b[0m"),
        BLACK("\u001b[0;40m"),
        RED("\u001b[0;41m"),
        GREEN("\u001b[0;42m"),
        YELLOW("\u001b[0;43m"),
        BLUE("\u001b[0;44m"),
        MAGENTA("\u001b[0;45m"),
        CYAN("\u001b[0;46m"),
        WHITE("\u001b[0;47m"),
        BACK_BRIGHT("\u001b[0;100m"),
        RED_BRIGHT("\u001b[0;101m"),
        GREEN_BRIGHT("\u001b[0;102m"),
        YELLOW_BRIGHT("\u001b[0;103m"),
        BLUE_BRIGHT("\u001b[0;104m"),
        MAGENTA_BRIGHT("\u001b[0;105m"),
        CYAN_BRIGHT("\u001b[0;106m"),
        WHITE_BRIGHT("\u001b[0;107m");

        private final String backgroundColor;

        private BackgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        public String toString() {
            return this.backgroundColor;
        }


    }
}
