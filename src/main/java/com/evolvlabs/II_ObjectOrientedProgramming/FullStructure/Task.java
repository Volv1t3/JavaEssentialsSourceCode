package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;


/**
 * <body style="color:white"> El presente archivo incluye la implementacion de una clase Abstracta pura, base de nuestra
 * jerarquia de clases llamada Task, en la cual se describen varios metodos y costantes estaticas
 * */

//! Para definir una clase abstract usamos la keyword abstract
public abstract class Task {

    //! Declaracion de Constante Estatica en una clase abstracta
    public static final Integer MAX_TASKS = 100;
    private static final String APPLICATION_NAME = "MS TODO";
    protected static final Integer MAX_CONCURRENT_TASKS = 2;

    //! Constantes internas
    private Integer _task_ID = 0;
    private String _task_Description;
    private QuickTimeStamps  _task_DueDate = QuickTimeStamps.OCHO_AM;
    protected Boolean _task_Completed = false;
    protected Boolean _task_PushedBack = false;
    protected Boolean _task_Deleted = false;
    protected ListableNotes _task_Notes;


    public Task(Integer task_ID, String task_Description, QuickTimeStamps task_DueDate) throws InvalidTaskParameter{
        this.set_task_ID(task_ID);
        this.set_task_Description(task_Description);
        this.set_task_DueDate(task_DueDate);
    }

    //! Setters y Getters
    /*
     ? Las declaraciones en esta seccion se pueden realizar porque una clase abstracta no es lo mismo que una clase puramente
     ? abstracta de C++. En Java, una clase abstracta puede tener campos, metodos implementados, asi como otros cuyas implementaciones
     ? no se establezcan.
     */
    public final void set_task_ID(Integer task_id) throws InvalidTaskParameter{
        if (task_id < 0){
            throw new InvalidTaskParameter("El parametro ingresado en el metodo set_task_ID es incorrecto",
                    new Throwable("Parametro Negativo").fillInStackTrace());
        }
        this._task_ID = task_id;
    }
    public final Integer get_task_ID() {
        return _task_ID;
    }

    public final void set_task_Description(String taskDescription) throws InvalidTaskParameter{
        if (taskDescription.isBlank()){
            throw new InvalidTaskParameter("El parametro ingresado en el metodo set_task_Description es incorrecto",
                    new Throwable("Parametro Vacio").fillInStackTrace());
        }
        this._task_Description = taskDescription;
    }
    public final String get_task_Description() throws InvalidTaskParameter {
        return _task_Description;
    }

    public final void set_task_DueDate(QuickTimeStamps task_DueDate)  throws InvalidTaskParameter{
        this._task_DueDate = task_DueDate;
    }
    public final Date get_task_DueDate() {
        return _task_DueDate.getTimeofDay();
    }



    //! Metodos sin implementacion
    /*
     ? En Java los metodos abstractos, fuera de las interfaces, requieren ser declarados en base a la keyword abstracta y
     ? el tipo de retorno. Un metodo abstracto no puede ser declarado como final, ya que final define que no puede ser sobreescrito.
     ? Lo que afecta al prototipo de la funcion original.
     */
    public abstract void set_task_Completed();
    public abstract void set_task_PushedBack();
    public abstract void set_task_Deleted();
    public abstract void set_task_Notes(ListableNotes taskNotes);
    public abstract ListableNotes get_task_Notes();
    public abstract Integer validateTaskIDInput(Integer task_ID);

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @apiNote In general, the {@code toString} method returns a string that "textually represents" this object. The
     * result should be a concise but informative representation that is easy for a person to read. It is recommended
     * that all subclasses override this method. The string output is not necessarily stable over time or across JVM
     * invocations.
     * @implSpec The {@code toString} method for class {@code Object} returns a string consisting of the name of the
     * class of which the object is an instance, the at-sign character `{@code @}', and the unsigned hexadecimal
     * representation of the hash code of the object. In other words, this method returns a string equal to the value
     * of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     */
    @Override
    public String toString() {
        return "Task{" +
                "_task_ID=" + _task_ID +
                ", _task_Description='" + _task_Description + '\'' +
                ", _task_DueDate=" + _task_DueDate +
                ", _task_Completed=" + _task_Completed +
                ", _task_PushedBack=" + _task_PushedBack +
                ", _task_Deleted=" + _task_Deleted +
                ", _task_Notes=" + _task_Notes.toString() +
                '}';
    }
}
