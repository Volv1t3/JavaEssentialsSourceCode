package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;


import java.io.Serializable;

/**
 * <body style="color:white"> El presente archivo incluye la implementacion de una clase Abstracta pura, base de nuestra
 * jerarquia de clases llamada Notes, en la cual se describen varios metodos y costantes estaticas
 * <br><br>
 * Como adicional, esta clase presenta nuestra primera interface de Java. Serializable es una interface que comunica al
 * JVM y al resto del programa que cualquier instancia de esta clase o de sus subclases pueden ser serializadas a un archivo
 * en binario. Esta interface no requiere ningnuna implementacion adicional ya que solo es un marcador interno de Java.
 * </body>
 * */

public abstract class Notes implements Serializable, Comparable<Notes>{

    //! Clase abstracta puramente con metodos abstractos
    protected QuickTaskTypes NotesDetails;
    protected Integer NoteID;
    protected String NoteLinkedTaskID;
    protected String NoteTitle;
    protected static Integer INSTANCES_COUNT = 0;
    public abstract void setNoteTitle(String noteTitle);
    public abstract String getNoteTitle();
    public abstract void setNotesDetails(QuickTaskTypes notesDetails);
    public abstract QuickTaskTypes getNotesDetails();
    public abstract void setNoteID(Integer noteID);
    public abstract Integer getNoteID();
    public abstract void setNoteLinkedTaskID(String noteLinkedTaskID);
    public abstract String getNoteLinkedTaskID();



    //! Declaracion de metodos estaticos de la clase con implementacion definida
    /*? OJO: no se pueden declarar metodos estaticos sin implementacion. El linter dentro del IDE nos informara de esto*/
    public static final void incrementInstanceCounter(){
        INSTANCES_COUNT++;
    }
    public static final Integer getInstancesCount(){
        return INSTANCES_COUNT;
    }

}
