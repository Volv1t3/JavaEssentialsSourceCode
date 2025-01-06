package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.util.*;

/**
 * <body style="color: white"> El presente archivo contiene la implementacion del segundo holder de reuniones que tiene esta
 * jerarquia, el cual esta direccioando a las reuniones de tipo Business. La clase utiliza la implementacion base de {@link
 * BusinessMeeting} que implementa la clase abstracta de {@link Meeting}.</body>
 */
public class BusinessMeetings implements Meetings{

    /*! Parametros de la clase*/
    private final List<BusinessMeeting> businessMeetingsList = new ArrayList<>();
    private String businessName;

    /*! Constructores de la clase*/
    public BusinessMeetings(String businessName){
        this.setBusinessName(businessName);
    }

    /*! Setters y Getters*/
    public void setBusinessName(String businessName) {
         if (!businessName.isBlank()){
             this.businessName = businessName;
         }
         else {
             throw new InvalidMeetingParameter("El parametro ingresado en el metodo setBusinessName es incorrecto",
                     new Throwable("Parametro vacio"));
         }
    }
    public String getBusinessName(){
        return this.businessName;
    }

    public final void sort(Comparator<BusinessMeeting> comparatorInstance){
        this.businessMeetingsList.sort(comparatorInstance);
    }

    /*! Implementaciones de Meetings*/

    @Override
    public void scheduleAMeeting(Integer meetingID, String meetingTitle, QuickTaskTypes meetingType, QuickTimeStamps meetingTime, String meetingAsigne) {
        this.businessMeetingsList.add(new BusinessMeeting(meetingID, meetingTitle,
                meetingType, meetingTime, meetingAsigne, false));
    }

    @Override
    public void scheduleAMeeting(Integer meetingID, String meetingTitle, QuickTaskTypes meetingType, QuickTimeStamps meetingTime) {
        this.businessMeetingsList.add(new BusinessMeeting(meetingID, meetingTitle,
                meetingType, meetingTime ));
    }

    @Override
    public Meeting getScheduledMeeting(String meetingTitle) {
        for (BusinessMeeting meeting : this.businessMeetingsList) {
            if (meeting.getI_MeetingTitle().equals(meetingTitle)) {
                return meeting;
            }
        }
        return null;
    }

    @Override
    public Meeting getScheduledMeeting(Integer meetingID) {
        for (BusinessMeeting meeting : this.businessMeetingsList) {
            if (meeting.getI_MeetingID().equals(meetingID)) {
                return meeting;
            }
        }
        return null;
    }

    @Override
    public Meeting getScheduledMeeting(QuickTaskTypes meetingType) {
        for (BusinessMeeting meeting : this.businessMeetingsList) {
            if (meeting.getI_MeetingType().equals(meetingType)) {
                return meeting;
            }
        }
        return null;
    }

    @Override
    public List<Meeting> getScheduledMeetings(QuickTimeStamps meetingTime) {
        List<Meeting> meetings = new ArrayList<>();
        for (BusinessMeeting meeting : this.businessMeetingsList) {
            if (meeting.getI_MeetingTime().equals(meetingTime)) {
                meetings.add(meeting);
            }
        }
        return meetings;
    }

    @Override
    public void clearScheduledMeetings() {
        this.businessMeetingsList.clear();
    }

    @Override
    public void clearScheduledMeetings(QuickTimeStamps meetingTime) {
        List<BusinessMeeting> meetings = new ArrayList<>();
        for (BusinessMeeting meeting : this.businessMeetingsList) {
            if (meeting.getI_MeetingTime().equals(meetingTime)) {
                meetings.add(meeting);
            }
        }
        this.businessMeetingsList.removeAll(meetings);
    }

    @Override
    public void clearScheduledMeetings(QuickTaskTypes meetingType) {
        List<BusinessMeeting> meetings = new ArrayList<>();
        for (BusinessMeeting meeting : this.businessMeetingsList) {
            if (meeting.getI_MeetingType().equals(meetingType)) {
                meetings.add(meeting);
            }
        }
        this.businessMeetingsList.removeAll(meetings);
    }

    @Override
    public void clearScheduledMeetings(Integer meetingID) {
        List<BusinessMeeting> meetings = new ArrayList<>();
        for (BusinessMeeting meeting : this.businessMeetingsList) {
            if (meeting.getI_MeetingID().equals(meetingID)) {
                meetings.add(meeting);
            }
        }
        this.businessMeetingsList.removeAll(meetings);
    }

    @Override
    public void clearScheduledMeetings(String meetingTitle) {
        List<BusinessMeeting> meetings = new ArrayList<>();
        for (BusinessMeeting meeting : this.businessMeetingsList) {
            if (meeting.getI_MeetingTitle().equals(meetingTitle)) {
                meetings.add(meeting);
            }
        }
        this.businessMeetingsList.removeAll(meetings);
    }

    @Override
    public List<Meeting> getMeetings() {
        return new ArrayList<>(this.businessMeetingsList);
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
        var that = (BusinessMeetings) obj;
        return Objects.equals(this.businessMeetingsList, that.businessMeetingsList);
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
        StringBuilder result = new StringBuilder();
        for (BusinessMeeting meeting : this.businessMeetingsList) {
            result.append(meeting.toString()).append("\n");
        }

        return !result.isEmpty() ? result.toString().trim() : "No Meetings Scheduled";
    }

}
