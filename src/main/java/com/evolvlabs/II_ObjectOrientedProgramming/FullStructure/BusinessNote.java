package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.util.HashMap;
import java.util.Objects;

public class BusinessNote extends Notes {

    //! Parametros internos
    private String businessNoteAuthor;
    private String businessName;
    private String businessNoteCategory;

    //! Constructor
    public BusinessNote(String noteTitle,
                        Integer noteID,
                        QuickTaskTypes notesDetails,
                        String businessNoteAuthor,
                        String businessNoteCategory) {
        super();
        this.setNoteTitle(noteTitle);
        this.setNotesDetails(notesDetails);
        this.setNoteID(noteID);
        this.setBusinessNoteAuthor(businessNoteAuthor);
        this.setBusinessNoteCategory(businessNoteCategory);
    }


    @Override
    public void setNoteTitle(String noteTitle) {
        if(noteTitle != null){
            if (!noteTitle.isBlank()){
                this.NoteTitle = noteTitle;
            }
        }else{
            throw new InvalidNoteTitleParameter("El titulo de la nota no puede ser nulo");
        }
    }

    @Override
    public String getNoteTitle() {
        return this.NoteTitle;
    }

    @Override
    public void setNotesDetails(QuickTaskTypes notesDetails) {
        if(notesDetails != null){
            if (!notesDetails.getTaskTitle().isBlank()){
                this.NotesDetails = notesDetails;
            }
        }else{
            this.NotesDetails = QuickTaskTypes.UNDEFINED;
        }
    }

    @Override
    public QuickTaskTypes getNotesDetails() {
        return this.NotesDetails;
    }

    @Override
    public void setNoteID(Integer noteID) {
        if(noteID != null){
            if (Integer.MIN_VALUE < noteID && noteID < Integer.MAX_VALUE){
                this.NoteID = noteID;
            }
        }else{
            this.NoteID = 0;
        }
    }

    @Override
    public Integer getNoteID() {
        return this.NoteID;
    }

    @Override
    public void setNoteLinkedTaskID(String noteLinkedTaskID) {
        if(noteLinkedTaskID != null){
            if (!noteLinkedTaskID.isBlank()){
                this.NoteLinkedTaskID = noteLinkedTaskID;
            }
        }else{
            this.NoteLinkedTaskID = "";
        }
    }

    @Override
    public String getNoteLinkedTaskID() {
        return this.NoteLinkedTaskID;
    }


    //! Implementaciones Adicionales
    public void setBusinessNoteAuthor(String businessNoteAuthor) {
        if(businessNoteAuthor != null){
            if (!businessNoteAuthor.isBlank()){
                this.businessNoteAuthor = businessNoteAuthor;
            }
        }else{
            this.businessNoteAuthor = "";
        }
    }
    public String getBusinessNoteAuthor() {
        return this.businessNoteAuthor;
    }

    public void setBusinessName(String businessName) {
        if(businessName != null){
            if (!businessName.isBlank()){
                this.businessName = businessName;
            }
        }else{
            this.businessName = "";
        }
    }
    public String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessNoteCategory(String businessNoteCategory) {
        if(businessNoteCategory != null){
            if (!businessNoteCategory.isBlank()){
                this.businessNoteCategory = businessNoteCategory;
            }
        }else{
            this.businessNoteCategory = "";
        }
    }
    public String getBusinessNoteCategory() {
        return this.businessNoteCategory;
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
     * @param other the object to be compared.
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
    public int compareTo(Notes other) {
        //! Implementemos un comparable con respecto a la categoria de la empresa
        if (other  == null){
            throw new NullPointerException();
        } else if (other == this) {
            return 0;
        } else if (!(other instanceof BusinessNote)){
            throw new ClassCastException();
        }
        else {
            //! Si no son nulas, vamos a comparar el tamaño de las listas
            if (this.getBusinessNoteCategory() == null && ((BusinessNote) other).getBusinessNoteCategory() == null){
                return 0;
            }else if (this.getBusinessNoteCategory() == null){
                return -1;
            }else if (((BusinessNote) other).getBusinessNoteCategory() == null){
                return 1;
            }else {
                return this.getBusinessNoteCategory().compareTo(((BusinessNote) other).getBusinessNoteCategory());
            }
        }
    }

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
        return "BusinessNote{" +
                "businessNoteAuthor='" + businessNoteAuthor + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessNoteCategory='" + businessNoteCategory + '\'' +
                ", NoteTitle='" + NoteTitle + '\'' +
                ", NotesDetails='" + NotesDetails.getTaskTitle() + '\'' +
                ", NoteID=" + NoteID +
                ", NoteLinkedTaskID='" + NoteLinkedTaskID + '\'' +
                '}';
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
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        } else if (obj == this){
            return true;
        } else {
            BusinessNote other = (BusinessNote) obj;
            return this.compareTo(other) == 0;
        }

    }
}