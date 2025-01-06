package com.evolvlabs.II_ObjectOrientedProgramming.BookExample;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.regex.*;

/**
 * <body style="color: white">El presente archivo contiene la implementacion de una clase base, no interface ni abstracta, que
 * contiene las definiciones base de un libro en nuestra jerarquia. Esta clase contiene todos los valores base, setters y getters
 * basicos de la jerarquia. Es important destacar que implementa {@code AutoCloseable}, una interface funcional de Java
 * que permite que esta clase y sus derivados puedan ser usados dentro de un try-with-resources block</body>
 */
public class Book
        implements AutoCloseable, Comparable<Book>
{

    /*? Internal Instance Variables */
    protected boolean isClosed = false;
    protected String m_internalBookTitle= "";
    protected String m_internalBookAuthor= "";
    protected int m_internalBookYear= 0;

    /*? Internal Pattern Matching Instances*/
    protected Pattern m_internalBookTitlePattern = Pattern.compile("^[A-Za-z|0-9|'|,|+|(|)|:|?|!|_|=|\"|/|\\s-]+$|(?:[\\s-][A-Za-z|,|'|+|(|)|:|?|!|_|=|\"|/|]+)+$");
    protected Pattern m_internalBookAuthorPattern = Pattern.compile("^[A-Za-z|[ \\t].\\s]+$|(?:[\\s-][A-Za-z]+)+$");


    /**
     * Generador Interno de Mensajes de Error Para Valores Incongruentes. El generador retorna una instancia nueva de la
     * clase InvalidAttributeValueException con un mensaje de error concentro producido en base a los parametros ingresados
     * a la funcion que se basan en el error ocurrido y el dato que causo este.
     * @param e_ErrorType:  String representativo del Tipo de Error que ocurrio, puede ser "e_BookTitle", "e_BookAuthor" o "e_BookYear", etc.
     * @param e_ErrorValue:  String representativo del Valor que causo el error, puede ser el titulo, el autor o el año del libro, etc.
     * @return :   Instancia de la clase InvalidAttributeValueException con un mensaje de error.
     */
    protected IllegalArgumentException InvalidAttrGenerator(String e_ErrorType, String e_ErrorValue)
    {
        return new IllegalArgumentException(String.format("Error Code 0x0001 - [Raised] El valor enviado al " +
                        "parametro %10s [%10s] es incorrecto, refierase a la documentacion del metodo utilizado.",
                e_ErrorType, e_ErrorValue));
    }






    /**
     * Constructor primario de la clase Base Book, toma a los tres principales campos de la clase base, el titulo, el autor
     * y el ano de publicacion y los pasa por los setters adecuados produciendo un objeto con los valores ingresados, siempre y cuando
     * no se causen errores en los setters intermedios.
     * @param e_bookTitle: String representativo Titulo del Libro. [Se aceptan solo cadenas de texto]
     * @param e_bookAuthor: String representativo Autor del Libro. [Se aceptan solo cadenas de texto]
     * @param e_bookYear: int representativo Ano de Publicacion del Libro.
     * @throws IllegalArgumentException :  Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public Book(String e_bookTitle, String e_bookAuthor, int e_bookYear) throws IllegalArgumentException
    {
        this.setInternalBookTitle(e_bookTitle).setInternalBookAuthor(e_bookAuthor).setInternalBookYear(e_bookYear);
    }




    /**
     * Constructor secundario de la clase Base Book, toma a los dos principales campos de la clase base, el titulo y el autor
     * y genera una instancia de la clase teniendo en cuenta que se los pasa por setters intermedios. De esta forma el constructor puede
     * arrojar errores en caso de ingresar valores incorrectos.
     * @param e_bookTitle: String representativo Titulo del Libro.
     * @param e_bookAuthor: String representativo Autor del Libro.
     * @throws IllegalArgumentException :  Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public Book(String e_bookTitle, String e_bookAuthor) throws IllegalArgumentException
    {
        this.setInternalBookTitle(e_bookTitle).setInternalBookAuthor(e_bookAuthor);
    }




    /**
     * Constructor ternario de la clase Base Book, genera una instancia de la clase sin ningun parametro adicional
     * del usuario, refiriendose a la documentacion de los atributos internos genera valores de prueba.
     * @throws IllegalArgumentException :  Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public Book() throws IllegalArgumentException
    {
        this.setInternalBookTitle("Sin Titulo").setInternalBookAuthor("Sin Autor").setInternalBookYear(2024);
    }






    /**
     * Metodo que se encarga de validar el valor ingresado como titulo del libro, si es correcto se asigna el valor ingresado. Para la revisions se realiza
     * un comparativo con una estructura Regex que permite determinar titulos complejos.
     * @param e_BookTitle: String representativo del titulo del libro
     * @return : instancia de la clase para llamadas en cadena.
     * @throws IllegalArgumentException :  Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public Book setInternalBookTitle(String e_BookTitle)
            throws IllegalArgumentException{
        if( e_BookTitle.matches(m_internalBookTitlePattern.toString()))
        {
            this.m_internalBookTitle = e_BookTitle;
        }
        else {throw InvalidAttrGenerator("e_BookTitle", e_BookTitle);}

        return this;
    }

    /**
     * Metodo que se encarga de retornar el valor del titulo del libro.
     * @return : String representativo del titulo del libro.
     */
    final public String getInternalBookTitle() {return this.m_internalBookTitle;}




    /**
     * Metodo que se encarga de validar el valor ingresado como autor del libro, si es correcto se asigna el valor ingresado.
     * Para la revision se realiza un comparativo con una estructura Regex que permite determinar autores complejos. No se aceptan
     * valores de autores cuyos nombres tengan numeros o caracteres especiales
     * @param e_BookAuthor : String representativo del autor del libro.
     * @return : instancia de la clase para llamadas en cadena.
     * @throws IllegalArgumentException :  Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public Book setInternalBookAuthor(String e_BookAuthor)
            throws IllegalArgumentException{
        if( e_BookAuthor.matches(m_internalBookAuthorPattern.toString()))
        {
            this.m_internalBookAuthor = e_BookAuthor;
        }
        else {throw InvalidAttrGenerator("e_BookAuthor", e_BookAuthor);}

        return this;
    }


    /**
     * Metodo que se encarga de retornar el valor del autor del libro.
     * @return : String representativo del autor del libro.
     */
    final public String getInternalBookAuthor()  {return this.m_internalBookAuthor;}



    /**
     * Metodo que se encarga de validar el valor ingresado como ano de publicacion del libro, si es correcto se asigna el valor ingresado.
     * Para la revision se realiza un comparativo con un rango de valores que permite determinar anos de publicacion validos.
     * Se aceptan valores desde el ano 1440 (Invension de la imprenta) hasta el ano actual.
     * @param e_BookYear : int representativo  del ano de publicacion del libro.
     * @return : instancia de la clase para llamadas en cadena.
     * @throws IllegalArgumentException :  Excepcion que se lanza cuando se ingresa un valor incorrecto en alguno de los setters.
     */
    public Book setInternalBookYear(int e_BookYear)
            throws IllegalArgumentException{
        if (Integer.MIN_VALUE < e_BookYear && e_BookYear < Integer.MAX_VALUE)
        {
            if( e_BookYear >= 1440 && e_BookYear <= LocalDateTime.ofInstant(Instant.now(),
                    ZoneId.systemDefault()).getYear())
            {
                this.m_internalBookYear = e_BookYear;
            }
        }
        else {throw InvalidAttrGenerator("e_BookYear", Integer.valueOf(e_BookYear).toString());}

        return this;
    }
    /**
     * Metodo que se encarga de retornar el valor del ano de publicacion del libro.
     * @return : int representativo del ano de publicacion del libro.
     */
    final public int getInternalBookYear() {return this.m_internalBookYear;}


    /*? Internal Forward Facing Overwrites*/

    /**
     * Metodo que se encarga de comparar dos instancias de la clase Book, comparando los atributos internos de la misma.
     * @param obj:  Objeto a comparar con la instancia actual.
     * @return : booleano que indica si las instancias son iguales o no.
     */
    @Override
    final public boolean equals(Object obj) {
        //? Base Checks, equal references, different classes or null references
        if (this == obj) {return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        //? Advanced Parameter Check
        try
        {
            Book testBook = (Book) obj;
            return (this.m_internalBookTitle.equals(testBook.m_internalBookTitle) &&
                    this.m_internalBookAuthor.equals(testBook.m_internalBookAuthor) &&
                    this.m_internalBookYear == testBook.m_internalBookYear);
        }
        catch (Exception e) {return false;}
    }


    /**
     * Metodo que se encarga de retornar un String con la informacion del libro.
     *
     * @return :  String con la informacion del libro.
     */
    @Override
    public String toString() {
        String objAsString = String.format("{Book Title: \"%50s\"\t\t," +
                "Book Author: \"%30s\"\t\t," +
                "Book Publication Year: \"%10s\",\tClass Name: \"BOOK\"}", this.getInternalBookTitle()
                                               , this.getInternalBookAuthor()
                                               , Integer.valueOf(this.getInternalBookYear()).toString());
        return objAsString;
    }


    /**
     * Metodo que se encarga de cerrar el recurso, en este caso el libro.
     * @throws Exception :  Excepcion que se lanza cuando el recurso ya fue cerrado.
     */
    @Override
    public void close()
            throws Exception {
        if (!this.isClosed)
        {
            this.isClosed = true;
        }
        else {throw new Exception("Error Code 0x0002 - [Raised] Recurso Ya Fue Cerrado, Contacte Con Prod. Si el Error Persiste.");}
    }


    /**
     * Metodo de la clase que implementa el orden natural de la misma, para esto nos basamos en la longitud del titulo del libro y del autor,
     * en este caso tenemos los siguientes resultados. <br><br>
     * <b> Retorna 1:</b> si se cumple que <code style="color: white"> this.getInternalBookTitle().length() > other.getInternalBookTitle().length()
     * </code>
     * <br> <b> Retorna 0:</b> si se cumple que <code style="color: white"> this.getInternalBookTitle().length() == other.getInternalBookTitle().length()
     *   </code>
     * <br> <b> Retorna -1:</b> si se cumple que <code style="color: white"> this.getInternalBookTitle().length() < other.getInternalBookTitle().length()
     *     </code>
     * <br><br>
     *
     * @param otherInstance the object to be compared.
     * @return :  int que indica la comparacion entre dos instancias de la clase Book.
     * @throws NullPointerException:  :  Excepcion que se lanza cuando el objeto a comparar es nulo.
     */
    @Override
    public int compareTo(Book otherInstance)
            throws NullPointerException {
        int internalResult = 0;
        if (otherInstance == null) {throw new NullPointerException("Error Code 0x0001 - [Raised] Objeto enviado a compareTo es nulo.");}
        else
        {
            if (this.getInternalBookTitle().length() > otherInstance.getInternalBookTitle().length())
            {
                internalResult = 1;
            }
            else if (this.equals(otherInstance)) {internalResult = 0;}
            else {internalResult = -1;}
        }

        return internalResult;
    }


}
