package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

/**
 * <body style="color: white">El presente archivo muestra la base en la implementacion de una clase para comparar
 * instancias de la implementacion de BusinessMeeting. El proposito de este archivo es demostrar el trabajo com Comparator,
 * como una interface funcional adicional para comparar instancias en Java.</body>
 */
public class BusinessMeetingComparator implements Comparator <BusinessMeeting>{

    /**
     * Compares its two arguments for order.  Returns a negative integer, zero, or a positive integer as the first
     * argument is less than, equal to, or greater than the second.<p>
     * <p>
     * The implementor must ensure that {@link Integer#signum signum}{@code (compare(x, y)) == -signum(compare(y, x))}
     * for all {@code x} and {@code y}.  (This implies that {@code compare(x, y)} must throw an exception if and only if
     * {@code compare(y, x)} throws an exception.)<p>
     * <p>
     * The implementor must also ensure that the relation is transitive:
     * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies {@code compare(x, z)>0}.<p>
     * <p>
     * Finally, the implementor must ensure that {@code compare(x, y)==0} implies that
     * {@code signum(compare(x, z))==signum(compare(y, z))} for all {@code z}.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater
     * than the second.
     * @throws NullPointerException if an argument is null and this comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from being compared by this comparator.
     * @apiNote It is generally the case, but <i>not</i> strictly required that
     * {@code (compare(x, y)==0) == (x.equals(y))}. Generally speaking, any comparator that violates this condition
     * should clearly indicate this fact.  The recommended language is "Note: this comparator imposes orderings that are
     * inconsistent with equals."
     */
    @Override
    public int compare(BusinessMeeting o1, BusinessMeeting o2) {
        if (o1 == null || o2 == null){
            throw new NullPointerException("Error: NullPointerException thrown en metodo compare de BusinessMeetingComparator : los objetos a comparar no pueden ser nulos");
        }
        /*! Para determinar si son superiores o no, utilizaremos la hora de la reunion para determinar quien es mayor. A
          ! mayor hora, superior es la reunion*/
        return Objects.compare(o1.getI_MeetingTime().getTimeofDay(), o2.getI_MeetingTime().getTimeofDay(), (od1, od2) -> {
            if (od1 == od2){
                return 0;
            }else if (od1.after(od2)) {
                return 1;
            }else {
                return -1;
            }
        });
    }

    public static void main(String[] args) {
        BusinessMeetings meetings=  new BusinessMeetings("Adelca");
        meetings.scheduleAMeeting(1,"Hello World", QuickTaskTypes.ESTUDIAR, QuickTimeStamps.DIEZ_AM);
        meetings.scheduleAMeeting(2, "Hello World", QuickTaskTypes.IR_A_LA_TIENDA, QuickTimeStamps.NUEVE_AM);
        meetings.scheduleAMeeting(3, "Hello World", QuickTaskTypes.IR_A_LA_TIENDA, QuickTimeStamps.DOS_PM);
        meetings.sort(new BusinessMeetingComparator());
        System.out.println("meetings = " + meetings.toString());


    }
}
