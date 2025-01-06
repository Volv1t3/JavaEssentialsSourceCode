package com.evolvlabs.II_ObjectOrientedProgramming.BookExample;

/**
 * <body style="color: white">El presente archivo contiene una clase derivada de la base Book. Incrementa sus funciones con
 * parametros y funciones dedicadas a una clase puramente de texto representativa de un PrintBook y su informacion. Contiene
 * documentacion, metodos y parametros nuevos para visualizar la forma de expandir clases en Java</body>
 */
public final class PrintBook extends Book
{


    /*? New Internal Variables*/
    private String m_internalBookPublisher = "";
    private String m_internalISBN = "";

    /*? New Forward Facing Constructors*/

    // * Primer Constructor Todos los Valores
    public PrintBook(String e_BookPublisher, String e_ISBN,
                     String e_bookTitle, String e_bookAuthor,
                     int e_bookYear) throws IllegalArgumentException
    {
        super(e_bookTitle, e_bookAuthor, e_bookYear);
        this.setInternalBookPublisher(e_BookPublisher).setInternalISBN(e_ISBN);
    }

    // * Segundo Constructor Cuatro Valores
    public PrintBook(String e_BookPublisher, String e_ISBN,
                     String e_bookTitle, String e_bookAuthor) throws IllegalArgumentException
    {
        super(e_bookTitle, e_bookAuthor);
        this.setInternalBookPublisher(e_BookPublisher).setInternalISBN(e_ISBN);

    }

    // * Tercer Constructor Sin Argumentos
    public PrintBook() throws IllegalArgumentException
    {
        super();
        this.setInternalBookPublisher("No Publisher").setInternalISBN("00000000000-1");
    }

    /*? New Internal Setter and Getters*/

    // * Setter y Getter de Book Publisher

    /**
     * Metodo que se encarga de validar el valor ingresado como editorial del libro, si es correcto se asigna el valor ingresado.
     * Para ello se utiliza una estructura Regex que permite determinar titulos complejos.
     * @param e_BookPublisher: String representativo de la editorial del libro.
     * @return : instancia de la clase para llamadas en cadena.
     * @throws IllegalArgumentException :  Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public PrintBook setInternalBookPublisher(String e_BookPublisher)
            throws IllegalArgumentException
    {
        if (e_BookPublisher.matches(m_internalBookTitlePattern.toString())) {
            this.m_internalBookPublisher = e_BookPublisher;
        }
        else
        {throw InvalidAttrGenerator("e_BookPublisher", e_BookPublisher);}

        return this;
    }
    /**
     * Metodo que se encarga de retornar el valor de la editorial del libro.
     * @return : String representativo de la editorial del libro.
     */
    public String getInternalBookPublisher() {return this.m_internalBookPublisher;}

    // * Setter y Getter de ISBN

    /**
     * Metodo que se encarga de validar el valor ingresado como ISBN del libro, si es correcto se asigna el valor ingresado.
     * @param e_ISBN : String representativo del ISBN del libro. Codigo de 13 digitos
     * @return : instancia de la clase para llamadas en cadena.
     * @throws IllegalArgumentException :  Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public PrintBook setInternalISBN(String e_ISBN) throws IllegalArgumentException
    {
        if (e_ISBN.length() >= 13) {
            this.m_internalISBN = e_ISBN;
        }
        else {throw InvalidAttrGenerator("e_ISBN", e_ISBN);}

        return this;
    }
    /**
     * Metodo que se encarga de retornar el valor del ISBN del libro.
     * @return : String representativo del ISBN del libro.
     */
    public String getInternalISBN() {return this.m_internalISBN;}


    /*? Internal Forward Facing Overwrites*/

    /**
     * Metodo que se encarga de retornar un String con la informacion del libro.
     *
     * @return :  String con la informacion del libro.
     */
    @Override
    public String toString() {
        String objAsString = super.toString() + String.format("\bDERIVED -> PRINT BOOK,\tBook Publisher: \"%30s\"\t\t" +
                ",\t Book ISBN-13: \"%14s\"}",  this.getInternalBookPublisher()
                , this.getInternalISBN());
        return objAsString;
    }

    @Override
    public void close() throws Exception {
        super.close();
    }

    /**
     * Metodo que se encarga de comparar dos objetos de la clase Book, en este caso PrintBook. Ademas de la comparacion
     * de la clase base se anade una capa de complejidad al evalur los ISBN13 del libro. Dependiendo de su valor numerico
     * podemos tener los siguientes casos,
     * <b> Retorna 1:</b> si se cumple que <code style="color: black"> this.getInternalISBN().length() > other.getInternalISBN().length()
     </code>
     * <br> <b> Retorna 0:</b> si se cumple que <code style="color: black"> this.getInternalISBN().length() == other.getInternalISBN().length()
     </code>
     * <br> <b> Retorna -1:</b> si se cumple que <code style="color: black"> this.getInternalISBN().length() < other.getInternalISBN().length(
     * </code>
     * <br><br>
     * @param otherInstance : Instancia de la clase Book a comparar.
     * @return : int con el valor numerico de la comparacion.
     * @throws NullPointerException : Excepcion que se lanza cuando se ingresa un objeto nulo a la funcion.
     */
    @Override
    public int compareTo(Book otherInstance) throws NullPointerException {
        int internalResult = 0;
            PrintBook tempBook = (PrintBook) otherInstance;
            if (Long.valueOf(this.getInternalISBN().replaceAll("-","")).longValue() >
                    Long.valueOf(tempBook.getInternalISBN().replaceAll("-","")).longValue())
            {
                internalResult = 1;
            }
            else if (Long.valueOf(this.getInternalISBN().replaceAll("-", "")).longValue() ==
                    Long.valueOf(tempBook.getInternalISBN().replaceAll("-", "")).longValue())
            {
                internalResult = 0;
            }
            else {internalResult = -1;}


        return internalResult;
    }
}
