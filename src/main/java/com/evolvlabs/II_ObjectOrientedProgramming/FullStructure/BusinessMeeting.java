package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.util.HashMap;
import java.util.Objects;

public class BusinessMeeting extends Meeting{

    /*! Parametros internos*/
    private String i_MeetingAsigne;

    /*! Constructores*/
    public BusinessMeeting(Integer e_MeetingID, String e_MeetingTitle,
                           QuickTaskTypes e_MeetingType, QuickTimeStamps e_MeetingTime,
                           String e_MeetingAsignee, Boolean e_WillAttend)
            throws InvalidMeetingParameter{
        this.setI_MeetingID(e_MeetingID);
        this.setI_MeetingTitle(e_MeetingTitle);
        this.setI_MeetingType(e_MeetingType);
        this.setI_MeetingTime(e_MeetingTime);
        this.setI_WillAttend(e_WillAttend);
        this.setI_MeetingAsigne(e_MeetingAsignee);
    }

    public BusinessMeeting(Integer e_MeetingID, String e_MeetingTitle,
                           QuickTaskTypes e_MeetingType, QuickTimeStamps e_MeetingTime)
            throws InvalidMeetingParameter{
        this.setI_MeetingID(e_MeetingID);
        this.setI_MeetingTitle(e_MeetingTitle);
        this.setI_MeetingType(e_MeetingType);
        this.setI_MeetingTime(e_MeetingTime);
        this.setI_WillAttend(false);
        this.setI_MeetingAsigne("undefined");
    }

    public BusinessMeeting() throws InvalidMeetingParameter{
        this.setI_MeetingID(0);
        this.setI_MeetingTitle("");
        this.setI_MeetingType(QuickTaskTypes.UNDEFINED);
        this.setI_MeetingTime(QuickTimeStamps.OCHO_AM);
        this.setI_WillAttend(false);
        this.setI_MeetingAsigne("undefined");
    }

    /*! Setters y Getters*/
    public void setI_MeetingAsigne(String i_MeetingAsigne) {
        if (!i_MeetingAsigne.isBlank()){
            this.i_MeetingAsigne = i_MeetingAsigne;
        }else {
            throw new InvalidMeetingParameter("El parametro ingresado en el metodo setI_MeetingAsigne es incorrecto",
                    new Throwable("Parametro vacio"));
        }
    }
    public String getI_MeetingAsigne() {
        return i_MeetingAsigne;
    }

    /*! Implementaciones de Object*/

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
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BusinessMeeting) obj;
        return Objects.equals(this.getI_MeetingID(), that.getI_MeetingID()) &&
                Objects.equals(this.getI_MeetingTitle(), that.getI_MeetingTitle()) &&
                Objects.equals(this.getI_MeetingType(), that.getI_MeetingType()) &&
                Objects.equals(this.getI_MeetingTime(), that.getI_MeetingTime()) &&
                Objects.equals(this.getI_MeetingAsigne(), that.getI_MeetingAsigne()) &&
                Objects.equals(this.getI_WillAttend(), that.getI_WillAttend());
    }

    /**
     * {@return a string representation of the object}
     *
     * @apiNote In general, the {@code toString} method returns a string that "textually represents" this object. The
     * result should be a concise but informative representation that is easy for a person to read. It is recommended
     * that all subclasses override this method. The string output is not necessarily stable over time or across JVM
     * invocations.
     * @implSpec The {@code toString} method for class {@code Object} returns a string consisting of the name of the
     * class of which the object is an instance, the at-sign character `{@code @}', and the unsigned hexadecimal
     * representation of the hash code of the object. In other words, this method returns a string equal to the value
     * of:
     * {@snippet lang = java:
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     *} The {@link Objects#toIdentityString(Object) Objects.toIdentityString} method returns the string for an object
     * equal to the string that would be returned if neither the {@code toString} nor {@code hashCode} methods were
     * overridden by the object's class.
     */
    @Override
    public String toString() {
        return "Meeting{" +
                "i_MeetingID=" + getI_MeetingID() +
                ", i_MeetingTitle='" + getI_MeetingTitle() + '\'' +
                ", i_MeetingType=" + getI_MeetingType() +
                ", i_MeetingTime=" + getI_MeetingTime() +
                ", i_MeetingAsigne='" + getI_MeetingAsigne() + '\'' +
                ", i_WillAttend=" + getI_WillAttend() +
                '}';
    }

    /*! Implementaciones de Comparable*/

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
    public int compareTo(Meeting o) {
        //! Revisaremos solo por el ID de la reunion
        return o.getI_MeetingID().compareTo(this.getI_MeetingID());
    }
}
