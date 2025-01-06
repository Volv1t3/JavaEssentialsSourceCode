package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.util.List;

/**
 * <body style="color:white">La presente interface presenta varios metodos generales para el manejo de reuniones en
 * nuestra jerarquia de clases. La idea detras de esta interface es proveer al usuario de metodos clave y generalizados
 * para todas las implementaciones de esta interface.
 * <br><br>
 * </body>
 */
public interface Meetings extends Comparable<Meetings> {

        public abstract void scheduleAMeeting(Integer meetingID, String meetingTitle,
                                              QuickTaskTypes meetingType, QuickTimeStamps meetingTime,
                                              String meetingAsigne);

        public abstract void scheduleAMeeting(Integer meetingID, String meetingTitle, QuickTaskTypes meetingType,
                                              QuickTimeStamps meetingTime);

        public abstract Meeting getScheduledMeeting(String meetingTitle);

        public abstract Meeting getScheduledMeeting(Integer meetingID);

        public abstract Meeting getScheduledMeeting(QuickTaskTypes meetingType);

        public abstract List<Meeting> getScheduledMeetings(QuickTimeStamps meetingTime);

        public abstract void clearScheduledMeetings();

        public abstract void clearScheduledMeetings(QuickTimeStamps meetingTime);

        public abstract void clearScheduledMeetings(QuickTaskTypes meetingType);

        public abstract void clearScheduledMeetings(Integer meetingID);

        public abstract void clearScheduledMeetings(String meetingTitle);

        public abstract List<Meeting> getMeetings();


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
    default int compareTo(Meetings o){
        if (o.getMeetings() == null){
            throw new NullPointerException();
        }else {
            //! Si no son nulas, vamos a comparar el tamaño de las listas
            if (this.getMeetings().size() < o.getMeetings().size()){
                return -1;
            }else if (this.getMeetings().size() > o.getMeetings().size()){
                return 1;
            }else {
                //! Si son del mismo tamano, vamos a comparar elemento por elemento
                for (int i = 0; i < this.getMeetings().size(); i++) {
                    if (this.getMeetings().get(i).compareTo(o.getMeetings().get(i)) != 0){
                        return this.getMeetings().get(i).compareTo(o.getMeetings().get(i));
                    }
                }
                return 0;
            }
        }
    }
}
