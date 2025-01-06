package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.util.*;

/**
 * <body style="color:white"> El presente archivo implementa la segunda interface base de esta jerarquia, las meetings que se pueden dar en un
 * entorno de trabajo. Especificamente, esta interface y esta implementacion estan direccioneadas a un holder de meetings personales
 * basados en la clase {@link PersonalMeeting} cuya implementacion de la clase abstracta {@link Meeting}, nos permite agruparlas,
 * mientras perdemos cierta independencia al agruparlas bajo una clase abstracta</body>
 */
public class PersonalMeetings implements Meetings {

    /*! Parametros internos de la clase*/
    private final List<PersonalMeeting> personalMeetingList = new ArrayList<>();

    /*! Constructores de la clase*/
    public PersonalMeetings(){;}


    @Override
    public void scheduleAMeeting(Integer meetingID, String meetingTitle, QuickTaskTypes meetingType, QuickTimeStamps meetingTime, String meetingAsigne) {
        PersonalMeeting newMeeting = new PersonalMeeting(meetingID, meetingTitle, meetingType, meetingTime, meetingAsigne, false);
        personalMeetingList.add(newMeeting);
    }

    @Override
    public void scheduleAMeeting(Integer meetingID, String meetingTitle, QuickTaskTypes meetingType, QuickTimeStamps meetingTime) {
        PersonalMeeting newMeeting = new PersonalMeeting(meetingID, meetingTitle, meetingType, meetingTime);
        personalMeetingList.add(newMeeting);

    }

    @Override
    public Meeting getScheduledMeeting(String meetingTitle) {
        for(Meeting meeting : this.personalMeetingList){
            if (meeting.getI_MeetingTitle().equalsIgnoreCase(meetingTitle)){
                return meeting;
            }
        }
        return null;
    }

    @Override
    public Meeting getScheduledMeeting(Integer meetingID) {
        for(Meeting meeting : this.personalMeetingList){
            if (meeting.getI_MeetingID().equals(meetingID)){
                return meeting;
            }
        }
        return null;
    }

    @Override
    public Meeting getScheduledMeeting(QuickTaskTypes meetingType) {
        for(Meeting meeting : this.personalMeetingList){
            if (meeting.getI_MeetingType().equals(meetingType)){
                return meeting;
            }
        }
        return null;
    }

    @Override
    public List<Meeting> getScheduledMeetings(QuickTimeStamps meetingTime) {
        List<Meeting> meetings = new ArrayList<>();
        for(Meeting meeting : this.personalMeetingList){
            if (meeting.getI_MeetingTime().equals(meetingTime)){
                meetings.add(meeting);
            }
        }
        return meetings;
    }

    @Override
    public void clearScheduledMeetings() {
            this.personalMeetingList.clear();
    }

    @Override
    public void clearScheduledMeetings(QuickTimeStamps meetingTime) {
        List<PersonalMeeting> meetings = new ArrayList<>();
        for(PersonalMeeting meeting : this.personalMeetingList){
            if (meeting.getI_MeetingTime().equals(meetingTime)){
                meetings.add(meeting);
            }
        }
        this.personalMeetingList.removeAll(meetings);
    }

    @Override
    public void clearScheduledMeetings(QuickTaskTypes meetingType) {
        List<PersonalMeeting> meetings = new ArrayList<>();
        for(PersonalMeeting meeting : this.personalMeetingList){
            if (meeting.getI_MeetingType().equals(meetingType)){
                meetings.add(meeting);
            }
        }
        this.personalMeetingList.removeAll(meetings);
    }

    @Override
    public void clearScheduledMeetings(Integer meetingID) {
        List<PersonalMeeting> meetings = new ArrayList<>();
        for(PersonalMeeting meeting : this.personalMeetingList){
            if (meeting.getI_MeetingID().equals(meetingID)){
                meetings.add(meeting);
            }
        }
        this.personalMeetingList.removeAll(meetings);
    }

    @Override
    public void clearScheduledMeetings(String meetingTitle) {
        List<PersonalMeeting> meetings = new ArrayList<>();
        for(PersonalMeeting meeting : this.personalMeetingList){
            if (meeting.getI_MeetingTitle().equalsIgnoreCase(meetingTitle)){
                meetings.add(meeting);
            }
        }
        this.personalMeetingList.removeAll(meetings);
    }

    @Override
    public List<Meeting> getMeetings() {
        return new ArrayList<>(this.personalMeetingList);
    }
    
    /*! Implementaciones de la clase Object*/

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
        var that = (PersonalMeetings) obj;
        return Objects.equals(this.personalMeetingList, that.personalMeetingList);
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
        for (PersonalMeeting meeting : this.personalMeetingList) {
            result.append(meeting.toString()).append("\n");
        }

        return !result.isEmpty() ? result.toString().trim() : "No Meetings Scheduled";
    }
}
