package com.evolvlabs.II_ObjectOrientedProgramming.BookExample;


/**
 * <body style="color: white">El presente archivo contiene una clase derivada de la base Book. Incrementa sus funciones con
 * parametros y funciones dedicadas a una clase puramente de texto representativa de un AudioBook y su informacion. Contiene
 * documentacion, metodos y parametros nuevos para visualizar la forma de expandir clases en Java</body>
 */
public class AudioBook extends Book{

    /*? New Internal Variables*/
    private double m_internalBookAudioSize = 0.0d;
    private long m_internalBookDuration = 0;
    private String m_internalBookPlaybackArtist = "";

    /*? New Forward Facing Constructors*/


    // * Primer Constructor Todos los Valores
    public AudioBook(double e_bookAudioSize,        long e_bookDuration,
                     String e_bookPlaybackArtist,   String e_bookTitle,
                     String e_bookAuthor,           int e_bookYear)
                     throws IllegalArgumentException{
        super(e_bookTitle, e_bookAuthor, e_bookYear);
        this.setInternalBookAudioSize(e_bookAudioSize).setInternalBookDuration(e_bookDuration).setInternalBookPlaybackArtist(e_bookPlaybackArtist);
    }


    // * Segundo Constructor Cuatro Valores
    public AudioBook(double e_bookAudioSize,      long e_bookDuration,
                     String e_bookPlaybackArtist, String e_bookTitle,
                     String e_bookAuthor)
                     throws IllegalArgumentException {
        super(e_bookTitle, e_bookAuthor);
        this.setInternalBookAudioSize(e_bookAudioSize).setInternalBookDuration(e_bookDuration).setInternalBookPlaybackArtist(e_bookPlaybackArtist);
    }

    // * Tercer Constructor Sin Argumentos
    public AudioBook() throws IllegalArgumentException{
            super();
            this.setInternalBookAudioSize(1.0d).setInternalBookDuration(0).setInternalBookPlaybackArtist("No Artist");
    }

    /*? New Internal Setter and Getters*/

    /**
     * Metodo que se encarga de validar el valor ingresado como tamano del audiolibro. Para esto evalua si el tamano de este
     * se encuentra entro del rango de (0, 400] MB.
     * @param e_bookAudioSize : double representativo del tamano del audiolibro.
     * @return : instancia de la clase para llamadas en cadena.
     * @throws IllegalArgumentException :  Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    // * Setter y Getter de Book Audio Size
    public AudioBook setInternalBookAudioSize(double e_bookAudioSize)
            throws IllegalArgumentException{
        if (Double.MIN_VALUE < e_bookAudioSize && e_bookAudioSize < Double.MAX_VALUE) {
            if (e_bookAudioSize > 0 && e_bookAudioSize < 400d)
            {
                this.m_internalBookAudioSize = e_bookAudioSize;
            }
        }
        else {throw InvalidAttrGenerator("e_bookAudioSize", Double.valueOf(e_bookAudioSize).toString());}

        return this;
    }


    /**
     * Metodo que se encarga de retornar el valor del tamano del audiolibro.
     * @return : double representativo del tamano del audiolibro.
     */
    public double getInternalBookAudioSize() {return this.m_internalBookAudioSize;}

    /**
     * Metodo que se encarga de validar el valor ingresado como duracion del audiolibro. Para esto evalua si el tamano de este
     * se encuentra entro del rango de (0, 1440] min.
     * @param e_bookDuration : long representativo de la duracion del audiolibro en minutos.
     * @return : instancia de la clase para llamadas en cadena.
     * @throws IllegalArgumentException : Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public AudioBook setInternalBookDuration(long e_bookDuration)
            throws IllegalArgumentException{
        if (Long.MIN_VALUE < e_bookDuration && e_bookDuration < Long.MAX_VALUE)
        {
            if (e_bookDuration > 0 && e_bookDuration < 1440)
            {
                this.m_internalBookDuration = e_bookDuration;
            }
        }
        else {throw InvalidAttrGenerator("e_bookDuration", Long.valueOf(e_bookDuration).toString());}

        return this;
    }

    /**
     * Metodo que se encarga de retornar el valor de la duracion del audiolibro.
     * @return : long representativo de la duracion del audiolibro en minutos.
     */
    public long getInternalBookDuration() {return this.m_internalBookDuration;}



    /**
     * Metodo que se encarga de validar el valor ingresado como artista del audiolibro. Para esto evalua si coincide con un nombre general, es decir
     * una string con solo texto mediante una estructura regex.
     *
     * @param e_bookPlaybackArtist : String representativo del artista del audiolibro.
     * @return : instancia de la clase para llamadas en cadena.
     * @throws IllegalArgumentException : Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public AudioBook setInternalBookPlaybackArtist(String e_bookPlaybackArtist)
            throws IllegalArgumentException {
        if (e_bookPlaybackArtist.matches(m_internalBookAuthorPattern.toString())) {
            this.m_internalBookPlaybackArtist = e_bookPlaybackArtist;
        }
        else {throw InvalidAttrGenerator("e_bookPlaybackArtist", e_bookPlaybackArtist);}

        return this;
    }

    /**
     * Metodo que se encarga de retornar el valor del artista del audiolibro.
     * @return : String representativo del artista del audiolibro.
     */
    public String getInternalBookPlaybackArtist() {return this.m_internalBookPlaybackArtist;}


    /**
     * Metodo que se encarga de retornar un String con la informacion del libro.
     *
     * @return :  String con la informacion del libro.
     */
    @Override
    public String toString() {
        String objAsString = super.toString() + String.format("\b DERIVED -> AUDIO BOOK,\t Book Audio Size: \"%s MB\"" +
                "\t, Book Playback Time: \"%s s\"\n," +
                " Book Playback Artist: \"%s\"\t}", this.getInternalBookAudioSize(),
                this.getInternalBookDuration(), this.getInternalBookPlaybackArtist());
        return objAsString;
    }


    /**
     * Metodo que se encarga de comparar dos objetos de la clase Book, en este caso PrintBook. Ademas de la comparacion
     * de la clase base se anade la complejidad del chequeo del tamano del libro. Dependiendo de su valor numerico
     * podemos tener los siguientes casos,
     * <b> Retorna 1:</b> si se cumple que <code style="color: white"> this.getInternalBookAudioSize().length() > other.getInternalBookAudioSize().length()
     </code>
     * <br> <b> Retorna 0:</b> si se cumple que <code style="color: white"> this.getInternalBookAudioSize().length() == other.getInternalBookAudioSize().length()
     </code>
     * <br> <b> Retorna -1:</b> si se cumple que <code style="color: white"> this.getInternalBookAudioSize().length() < other.getInternalBookAudioSize().length(
     * </code>
     * <br><br>
     * @param otherInstance : Instancia de la clase Book a comparar.
     * @return : int con el valor numerico de la comparacion.
     * @throws NullPointerException : Excepcion que se lanza cuando se ingresa un objeto nulo a la funcion.
     */
    @Override
    public int compareTo(Book otherInstance)
            throws NullPointerException {
        int internalResult = 0;
        AudioBook tempInstance = (AudioBook) otherInstance;
        if (this.getInternalBookAudioSize() > tempInstance.getInternalBookAudioSize())
        {
            internalResult = 1;
        }
        else if (this.getInternalBookAudioSize() == tempInstance.getInternalBookAudioSize())
        {
            internalResult = 0;
        }
        else
        {
            internalResult = -1;
        }

        return internalResult;
    }
}
