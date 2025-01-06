package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.time.Clock;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <body style="color: white">El presente archivo incluye varias delcaraciones de constantes de tiempo que se pueden usar
 * en las diversas tasks que se crean en el sistema. La idea de esta enumeracion es demostrar la facilidad de extension que
 * tienen este tipo de dato o clases, y la facilidad de implementacion de estas para dar un toque formal al desarollo.</body>
 */
public enum QuickTimeStamps {

    /*! Constantes internas que contiene la aplicacion*/
    OCHO_AM(getTime(8,0)),
    NUEVE_AM(QuickTimeStamps.getTime(9, 0)),
    DIEZ_AM(QuickTimeStamps.getTime(10, 0)),
    ONCE_AM(QuickTimeStamps.getTime(11, 0)),
    DOCE_PM(QuickTimeStamps.getTime(12, 0)),
    UNA_PM(QuickTimeStamps.getTime(13, 0)),
    DOS_PM(QuickTimeStamps.getTime(14, 0)),
    TRES_PM(QuickTimeStamps.getTime(15, 0)),
    CUATRO_PM(QuickTimeStamps.getTime(16, 0)),
    CINCO_PM(QuickTimeStamps.getTime(17, 0)),
    SEIS_PM(QuickTimeStamps.getTime(18, 0)),
    SIETE_PM(QuickTimeStamps.getTime(19, 0)),
    OCHO_PM(QuickTimeStamps.getTime(20, 0)),
    NUEVE_PM(QuickTimeStamps.getTime(21, 0)),
    DIEZ_PM(QuickTimeStamps.getTime(22, 0)),
    ONCE_PM(QuickTimeStamps.getTime(23, 0)),
    MEDIANOCHE(QuickTimeStamps.getTime(0, 0));


    /*! Campos internos*/
    /*
     ? En una enumeracion, los campos internos pueden ser publicos, privados o protegidos. Asi como finales o no finales.
     ? Esto quiere decir que se puede trabajar con estos tipos de clases de una manera mixta, teniendo constantes para
     ? facil ordenamiento y accion, asi como valores para logica de la aplicacion.
     */
    private Date timeofDay;

    QuickTimeStamps(Date _timeOfDay){
        this.timeofDay = _timeOfDay;
    }

    /*Metodo interno estatico para facilitar la creacion de las fechas internas*/
    private static Date getTime(int hourOfDay, int intMinuteOfDay){
        Calendar calendario = new GregorianCalendar();
        calendario.setTime(Date.from(Instant.now(Clock.systemDefaultZone())));
        //! Seteo de valores internos para el calendario
        calendario.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendario.set(Calendar.MINUTE, intMinuteOfDay);
        calendario.set(Calendar.SECOND, 0);
        calendario.set(Calendar.MILLISECOND, 0);

        return calendario.getTime();
    }


    /*! Este metodo forwardfacing de la enumeracion le permite al usuario obtener el valor interno de la constante*/
    public Date getTimeofDay() {
        return timeofDay;
    }
}
