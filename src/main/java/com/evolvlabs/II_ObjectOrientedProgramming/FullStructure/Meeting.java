package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

/**
 * <body style=:color:white">El presente archivo solo incluye la definicion de una interface generica usada para generalizar
 * a los tipos de reuniones existentes</body>
 */
public abstract class Meeting implements Comparable<Meeting>{
    /*! Parametros internos*/
    private Integer         i_MeetingID;
    private String          i_MeetingTitle;
    private QuickTaskTypes  i_MeetingType;
    private QuickTimeStamps i_MeetingTime;
    private Boolean         i_WillAttend;


    /*! Setters y Getters*/
    public void setI_MeetingID(Integer i_MeetingID) throws InvalidMeetingParameter{
        if (i_MeetingID > 0){
            this.i_MeetingID = i_MeetingID;
        }else {
            throw new InvalidMeetingParameter("El parametro ingresado en el metodo setI_MeetingID es incorrecto", new Throwable("Parametro negativo"));
        }
    }
    public Integer getI_MeetingID() {
        return i_MeetingID;
    }

    public void setI_MeetingTitle(String i_MeetingTitle) throws InvalidMeetingParameter{
        if (!i_MeetingTitle.isBlank()){
            this.i_MeetingTitle = i_MeetingTitle;
        }else {
            throw new InvalidMeetingParameter("El parametro ingresado en el metodo setI_MeetingTitle es incorrecto",
                    new Throwable("Parametro vacio"));
        }
    }
    public String getI_MeetingTitle() {
        return i_MeetingTitle;
    }

    public void setI_MeetingType(QuickTaskTypes i_MeetingType) throws InvalidMeetingParameter{
        if (i_MeetingType != null){
            this.i_MeetingType = i_MeetingType;
        }else {
            throw new InvalidMeetingParameter("El parametro ingresado en el metodo setI_MeetingType es incorrecto",
                    new Throwable("Parametro nulo"));
        }
    }
    public QuickTaskTypes getI_MeetingType() {
        return i_MeetingType;
    }

    public void setI_MeetingTime(QuickTimeStamps i_MeetingTime) throws InvalidMeetingParameter{
        if (i_MeetingTime != null){
            this.i_MeetingTime = i_MeetingTime;
        }else {
            throw new InvalidMeetingParameter("El parametro ingresado en el metodo setI_MeetingTime es incorrecto",
                    new Throwable("Parametro nulo"));
        }
    }
    public QuickTimeStamps getI_MeetingTime() {
        return i_MeetingTime;
    }



    public void setI_WillAttend(Boolean i_WillAttend) throws InvalidMeetingParameter{
        if (i_WillAttend != null){
            this.i_WillAttend = i_WillAttend;
        }else {
            throw new InvalidMeetingParameter("El parametro ingresado en el metodo setI_WillAttend es incorrecto",
                    new Throwable("Parametro nulo"));
        }
    }
    public Boolean getI_WillAttend() {
        return i_WillAttend;
    }
}
