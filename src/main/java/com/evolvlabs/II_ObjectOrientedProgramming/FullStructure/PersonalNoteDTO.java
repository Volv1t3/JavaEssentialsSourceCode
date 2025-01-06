package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.util.Objects;

/**
 * <body style="color: white">El presente archivo contiene la implementacion de un Record para el objeto Personal Note.
 * El cual se puede usar para una semi-serializacion hacia XML con sus metodos internos.</body>
 * @param note
 */
public record PersonalNoteDTO(PersonalNote note) {

    /*! Los records no permiten ningun tipo de campo que no sea final y estatico*/
    public static final Integer[] INSTANCE_COUNTER = {0};

    /*! Constructor por defecto*/
    /*
     ? Notese que los parametros de este constructor son identicos a los declarados en la parte superior, esto es porque
     ? en Java los records generan un set de campos FINALES Y PRIVADOS para cada parametro declarado en los parentesis
     ? anteriores. Por tanto la inicializacion de las variables debe darse dentro del constructor antes de cualquier oepracion
     */
    public PersonalNoteDTO(PersonalNote note){
        this.note =  note /*Si tipean esta linea de nuevo veran que es private y final*/;
        INSTANCE_COUNTER[0]++;
    }

    /*! Getters del DTO que exponen datos internos*/
    /*? Campos de la clase Personal Notes*/
    public String getPersonalNoteAuthor(){
        return this.note.getPersonalNoteAuthor();
    }
    /*? Campos de la clase Notes*/
    public String getNoteTitle(){
        return this.note.getNoteTitle();
    }
    public Integer getNoteID(){
        return this.note.getNoteID();
    }
    public QuickTaskTypes getNotesDetails(){
        return this.note.getNotesDetails();
    }

    /*! Metodo que permite obtener el XML de la nota personal*/
    public String toXml(){
        return """
            <PersonalNoteDTO>
                <PersonalNote>
                    <PersonalNoteAuthor>%s</PersonalNoteAuthor>
                    <NoteTitle>%s</NoteTitle>
                    <NoteID>%s</NoteID>
                    <NotesDetails>%s</NotesDetails>
                </PersonalNote>
            </PersonalNoteDTO>
            """.formatted(
                getPersonalNoteAuthor(),
                getNoteTitle(),
                getNoteID(),
                getNotesDetails().getTaskTitle()
            );
    }

    /**
     * Returns a string representation of the record. In accordance with the general contract of
     * {@link Object#toString()}, the {@code toString} method returns a string that "textually represents" this record.
     * The result should be a concise but informative representation that is easy for a person to read.
     * <p>
     * In addition to this general contract, record classes must further participate in the invariant that any two
     * records which are {@linkplain Record#equals(Object) equal} must produce equal strings.  This invariant is
     * necessarily relaxed in the rare case where corresponding equal component values might fail to produce equal
     * strings for themselves.
     *
     * @return a string representation of the object.
     * @implSpec The implicitly provided implementation returns a string which contains the name of the record class,
     * the names of components of the record, and string representations of component values, so as to fulfill the
     * contract of this method. The precise format produced by this implicitly provided implementation is subject to
     * change, so the present syntax should not be parsed by applications to recover record component values.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return this.toXml();
    }

    /**
     * Indicates whether some other object is "equal to" this one.  In addition to the general contract of
     * {@link Object#equals(Object) Object.equals}, record classes must further obey the invariant that when a record
     * instance is "copied" by passing the result of the record component accessor methods to the canonical constructor,
     * as follows:
     * <pre>
     *     R copy = new R(r.c1(), r.c2(), ..., r.cn());
     * </pre>
     * then it must be the case that {@code r.equals(copy)}.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this record is equal to the argument; {@code false} otherwise.
     * @implSpec The implicitly provided implementation returns {@code true} if and only if the argument is an instance
     * of the same record class as this record, and each component of this record is equal to the corresponding
     * component of the argument; otherwise, {@code false} is returned. Equality of a component {@code c} is determined
     * as follows:
     * <ul>
     *
     * <li> If the component is of a reference type, the component is
     * considered equal if and only if {@link
     * Objects#equals(Object, Object)
     * Objects.equals(this.c, r.c)} would return {@code true}.
     *
     * <li> If the component is of a primitive type, using the
     * corresponding primitive wrapper class {@code PW} (the
     * corresponding wrapper class for {@code int} is {@code
     * java.lang.Integer}, and so on), the component is considered
     * equal if and only if {@code
     * PW.compare(this.c, r.c)} would return {@code 0}.
     *
     * </ul>
     * <p>
     * Apart from the semantics described above, the precise algorithm
     * used in the implicitly provided implementation is unspecified
     * and is subject to change. The implementation may or may not use
     * calls to the particular methods listed, and may or may not
     * perform comparisons in the order of component declaration.
     * @see Objects#equals(Object, Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        } else if (obj == this){
            return true;
        } else if (!(obj instanceof PersonalNoteDTO(PersonalNote note1))){
            return false;
        } else {
            return this.note.compareTo(note1) == 0;
        }
    }
}

