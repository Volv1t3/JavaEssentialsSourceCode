package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * <body style="color: white">El presente archivo contiene la implementacion de la primera clase base PersonalTask que
 * se extiende de la clase abstract Task. En esta clase al ser solo una clase normal tenemos que implementar todos los metodos
 * </body>
 */
public class PersonalTask extends Task implements Comparable<PersonalTask>{

    /*?Nuevos parametros*/
    private String personalTaskAssignee;
    private static Integer PERSONAL_TASK_COUNTER = 0;
    /*? Constructores de la clase */

    public PersonalTask(Integer task_ID, String task_Description, QuickTimeStamps task_DueDate, String personalTask_Assignee){
        super(0, task_Description, task_DueDate);
        this.set_task_Notes(new PersonalNotes());
        /*! Codigo adicional de nuestra implementacion*/
        try {
            this.set_task_ID(validateTaskIDInput(task_ID));
            this.set_personalTaskAssignee(personalTask_Assignee);
        } catch (InvalidTaskParameter e) {
            throw new RuntimeException(e);
        }
    }

    public PersonalTask(Integer task_ID, String task_Description, QuickTimeStamps taskDueDate){
        super(0, task_Description, taskDueDate);
        this.set_task_Notes(new PersonalNotes());
        try {
            this.set_task_ID(validateTaskIDInput(task_ID));
        } catch (InvalidTaskParameter e) {
            throw new RuntimeException(e);
        }
    }

    public PersonalTask(){
        super(PERSONAL_TASK_COUNTER + 1,"",QuickTimeStamps.OCHO_AM);
        this.set_task_Notes(new PersonalNotes());



    }

    /*! Implementaciones de la clase Personal Task */
    /*? Getters y Setters*/
    public final String get_personalTaskAssignee() {
        return personalTaskAssignee;
    }
    public final void set_personalTaskAssignee(String personalTaskAssignee) throws InvalidTaskParameter {
        if (personalTaskAssignee.isBlank()){
            throw new InvalidTaskParameter("El parametro ingresado en el metodo set_personalTaskAssignee es incorrecto",
                    new Throwable("Parametro Vacio").fillInStackTrace());
        }
        this.personalTaskAssignee = personalTaskAssignee;
    }

    /*! Implementaciones de la clase Task*/
    /*
     ? En Java, los metodos de una clase abstracta definidos como abstractos tienen que ser implementados en su totlidad,
     a menos que esta clase se declare abstracta por su parte*/

    @Override
    public void set_task_Completed() {
        this._task_Completed = true;
    }

    public Boolean isTaskCompleted(){ return this._task_Completed;}

    @Override
    public void set_task_PushedBack() {
        this._task_PushedBack = true;
    }
    public Boolean isTaskPushedBack(){ return this._task_PushedBack;}

    @Override
    public void set_task_Deleted() {
        this._task_Deleted = true;
    }
    public Boolean isTaskDeleted(){ return this._task_Deleted;}

    @Override
    public void set_task_Notes(ListableNotes taskNotes) {
        try{
            this._task_Notes = (PersonalNotes) taskNotes;
        }catch (ClassCastException classCastException){
            throw new InvalidTaskParameter("El parametro ingresado en el metodo set_task_Notes es incorrecto",
                    new Throwable("Parametro no es de tipo PersonalNotes").fillInStackTrace());
        }
    }

    @Override
    public ListableNotes get_task_Notes(){ return this._task_Notes;}

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
        StringBuilder personalTaskAsString = new StringBuilder(super.toString());
        personalTaskAsString.delete(super.toString().length() -2, super.toString().length() -1);
        //! Anadimos el nuevo contenido generado por esta clase
        personalTaskAsString.append(", personalTaskAssignee='").append(personalTaskAssignee).append('\'');
        personalTaskAsString.append("}");
        return personalTaskAsString.toString();
    }

    /*! Helper Methods*/

    @Override
    public Integer validateTaskIDInput(Integer task_ID) {
            if (task_ID > 0) {
                if (!Objects.equals(task_ID - 1, PERSONAL_TASK_COUNTER)) {
                    throw new InvalidTaskParameter("El parametro ingresado en el metodo set_task_ID es incorrecto",
                            new Throwable("Parametro no sige secuencia fija de PERSONAL_TASK_COUNTER + 1, para la instancia" +
                                    " que se intento crear").fillInStackTrace());
                } else {
                    PERSONAL_TASK_COUNTER++;
                    return task_ID;
                }
            } else {
                throw new InvalidTaskParameter("El parametro ingresado en el metodo set_task_ID es incorrecto",
                        new Throwable("Parametro Negativo").fillInStackTrace());
            }
        }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     *     {@code x}, {@code x.equals(x)} should return
     *     {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     *     {@code x} and {@code y}, {@code x.equals(y)}
     *     should return {@code true} if and only if
     *     {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     *     {@code x}, {@code y}, and {@code z}, if
     *     {@code x.equals(y)} returns {@code true} and
     *     {@code y.equals(z)} returns {@code true}, then
     *     {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     *     {@code x} and {@code y}, multiple invocations of
     *     {@code x.equals(y)} consistently return {@code true}
     *     or consistently return {@code false}, provided no
     *     information used in {@code equals} comparisons on the
     *     objects is modified.
     * <li>For any non-null reference value {@code x},
     *     {@code x.equals(null)} should return {@code false}.
     * </ul>
     *
     * <p>
     * An equivalence relation partitions the elements it operates on
     * into <i>equivalence classes</i>; all the members of an
     * equivalence class are equal to each other. Members of an
     * equivalence class are substitutable for each other, at least
     * for some purposes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @implSpec The {@code equals} method for class {@code Object} implements the most discriminating possible
     * equivalence relation on objects; that is, for any non-null reference values {@code x} and {@code y}, this method
     * returns {@code true} if and only if {@code x} and {@code y} refer to the same object ({@code x == y} has the
     * value {@code true}).
     * <p>
     * In other words, under the reference equality equivalence relation, each equivalence class only has a single
     * element.
     * @apiNote It is generally necessary to override the {@link #hashCode() hashCode} method whenever this method is
     * overridden, so as to maintain the general contract for the {@code hashCode} method, which states that equal
     * objects must have equal hash codes.
     * <p>The two-argument {@link Objects#equals(Object,
     * Object) Objects.equals} method implements an equivalence relation on two possibly-null object references.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if  (obj == this) {
            return true;
        }
        else if (obj.getClass() != this.getClass()){
            return false;
        }else {
            try{
                PersonalTask task = (PersonalTask) obj;
                return this.compareTo(task) == 0;
            }catch(ClassCastException classCastException){
                return false;
            }
        }
    }

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies that
     * {@code x.compareTo(y)} must throw an exception if and only if {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z)) == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the
     * {@code Comparable} interface and violates this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is inconsistent with equals."
     */
    @Override
    public int compareTo(PersonalTask o) {
        if (Objects.equals(this.get_task_ID(), o.get_task_ID())){
            return 0;
        } else if (this.get_task_ID() > o.get_task_ID()) {
            return 1;
        } else {
            return -1;
        }
    }
}
