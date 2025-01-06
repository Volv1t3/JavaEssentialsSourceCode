package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String                 companyName = "eVolvLabs";
    private static final PersonalNotes          personalNotes = new PersonalNotes();
    private static final PersonalMeetings       personalMeetings = new PersonalMeetings();
    private static final BusinessNotes          businessNotes = new BusinessNotes(companyName);
    private static final BusinessMeetings       businessMeetings = new BusinessMeetings(companyName);

    public static void main(String[] args) {
        

    }

    private static void readInputDefineBusinessNotesInstance(Scanner scannerInstance){
        //! Para este metodo intentaremos permitir que el usuario a traves de la consola ingrese un tipo de dato por parametro
        //! en un menu amigable y definido para que se facilite la creacion de un BusinessNote Holder
    }
}

