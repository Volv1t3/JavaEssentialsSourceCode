package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import com.evolvlabs.IV_Extras.Colorizer;
import com.evolvlabs.I_JavaLangBasics.IOInterfacing.IOInterfacingPartOne;

import java.util.*;

public class Main {
    


    private static final String                  companyName = "eVolvLabs";
    private static final PersonalNotes           personalNotes = new PersonalNotes();
    private static final PersonalMeetings        personalMeetings = new PersonalMeetings();
    private static final BusinessNotes           businessNotes = new BusinessNotes(companyName);
    private static final BusinessMeetings        businessMeetings = new BusinessMeetings(companyName);
    private static final ArrayList<BusinessTask> businessTasks = new ArrayList<>();
    private static final ArrayList<PersonalTask> personalTasks = new ArrayList<>();
    private static final String                  MENU_OPTION_FORMAT = "%-80s";
    private static final String                  MENU_OPTION_NUMBER_FORMAT = "%60s";
    private static final Scanner                 scanner = new Scanner(System.in);
    private static enum  personalNoteOptions{NOTE_TITLE, NOTE_ID, NOTE_DETAILS, NOTE_AUTHOR}
    private static enum  personalMeetingOptions{MEETING_ID, MEETING_TITLE, MEETING_TYPE, MEETING_TIME, MEETING_ASIGNEE, MEETING_WILL_ATTEND}
    private static enum  personalTaskOptions{TASK_ID, TASK_DESCRIPTION, TASK_TIME, TASK_ASIGNEE}
    private static enum  businessNoteOptions{NOTE_TITLE, NOTE_ID, NOTE_DETAILS, NOTE_AUTHOR, NOTE_COMPANY}
    private static enum  businessMeetingOptions{MEETING_ID, MEETING_TITLE, MEETING_TYPE, MEETING_TIME, MEETING_ASIGNEE, MEETING_WILL_ATTEND, MEETING_COMPANY}
    private static enum  businessTaskOptions{TASK_ID, TASK_DESCRIPTION, TASK_TIME, TASK_DUE_DATE, TASK_ASIGNEE, TASK_COMPANY}


    public static void main(String[] args) {
        //! Este main presenta opciones para manejar instancias de notas, meetings y tasks en un ambiente empresarial
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos a nuestro programa demostrativo del manejo " +
                "de Tasks, Meetings y Notes en un ambiente empresarial en Java!"));
        System.out.println(Colorizer.colorWithCyanLetters("Para trabajar con este archivo, se presentan algunas opciones" +
                " en un listado que permite seleccionar un modelo de trabajo y modificar datos internos"));
        System.out.println(Colorizer.colorWithCyanLetters("Seleccione una de las siguientes opciones\n"));
        Integer userInput = 0;
        do {
            printCenteredMessage(Colorizer.colorWithMagentaLetters("Opciones para ingreso de valores"));
            IOInterfacingPartOne.printMenuOption("1. Registrar Una Nueva Nota Personal",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[1]"),
                    MENU_OPTION_NUMBER_FORMAT);

            IOInterfacingPartOne.printMenuOption("2. Registrar Una Nueva Nota Empresarial",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[2]"),
                    MENU_OPTION_NUMBER_FORMAT);

            IOInterfacingPartOne.printMenuOption("3. Registrar Una Nueva Reunion Personal",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[3]"),
                    MENU_OPTION_NUMBER_FORMAT);

            IOInterfacingPartOne.printMenuOption("4. Registrar Una Nueva Reunion Empresarial",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[4]"),
                    MENU_OPTION_NUMBER_FORMAT);

            IOInterfacingPartOne.printMenuOption("5. Registrar Una Nueva Tarea Personal",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[5]"),
                    MENU_OPTION_NUMBER_FORMAT);

            IOInterfacingPartOne.printMenuOption("6. Registrar Una Nueva Tarea Empresarial",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[6]"),
                    MENU_OPTION_NUMBER_FORMAT);

            printCenteredMessage(Colorizer.colorWithMagentaLetters("Opciones para revision de valores"));
            IOInterfacingPartOne.printMenuOption("7. Listar Notas Personales",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[7]"),
                    MENU_OPTION_NUMBER_FORMAT);

            IOInterfacingPartOne.printMenuOption("8. Listar Notas Empresariales",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[8]"),
                    MENU_OPTION_NUMBER_FORMAT);

            IOInterfacingPartOne.printMenuOption("9. Listar Reuniones Personales",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[9]"),
                    MENU_OPTION_NUMBER_FORMAT);
            IOInterfacingPartOne.printMenuOption("10. Listar Reuniones Empresariales",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[10]"),
                    MENU_OPTION_NUMBER_FORMAT);

            IOInterfacingPartOne.printMenuOption("11. Listar Tareas Personales",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[11]"),
                    MENU_OPTION_NUMBER_FORMAT);

            IOInterfacingPartOne.printMenuOption("12. Listar Tareas Empresariales",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[12]"),
                    MENU_OPTION_NUMBER_FORMAT);
            printCenteredMessage(Colorizer.colorWithMagentaLetters("Opciones Varias"));
            IOInterfacingPartOne.printMenuOption("7. Salir del Programa",
                    MENU_OPTION_FORMAT, "Opcion Numero " + Colorizer.colorWithMagentaLetters("[-1]"),
                    MENU_OPTION_NUMBER_FORMAT);

            //! Registremos el input del usuario
            do {
                System.out.print(Colorizer.colorWithYellowLetters("Ingrese una opcion: "));
                try {
                    userInput = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) /*Excepcion de la conversion de valores*/{
                    System.out.println(Colorizer.colorWithCyanLetters("Error: Ingrese un numero valido"));
                } catch(NoSuchElementException | IllegalStateException e){
                    System.out.println(Colorizer.colorWithCyanLetters("Error: Estado del Scanner incorrecto"));
                    userInput = -1;
                    break;
                } catch (RuntimeException e) {
                    System.out.println(Colorizer.colorWithCyanLetters("Error: RuntimeException inesperada"));
                    throw new RuntimeException(e);
                }
            }while (true);

            //! Opciones del usuario: Usando la nueva sintaxis de los Switch Statements
            switch(userInput){
                case 1 /*Registrar una nueva nota personal*/:
                    //! En esta seccion simplemente vamos a solicitar al usuario rellenar un formulario con su nota
                    /*Requerimos: noteTitle, noteID, noteDetails, note Author*/
                    PersonalNote note = new PersonalNote(" ",1, QuickTaskTypes.UNDEFINED, " ");
                    printMenuOptionWithLeftAlignment("1. Ingrese el titulo de la nota que quiere ingresar");
                    String noteTitle = scanner.nextLine();
                    do {
                        printMenuOptionWithLeftAlignment("2. Ingrese el ID de la nota que quiere ingresar");
                        try {
                            int noteID = Integer.parseInt(scanner.nextLine());
                            note.setNoteID(noteID);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no puede ser transformado a un NoteID de tipo entero. Intente de nuevo."));
                        }
                    } while (true);
                    printMenuOptionWithLeftAlignment("3. Ingrese el detalle de la nota que quiere ingresar, seleccionandolo de este listado (con su entero representante)");
                    System.out.println();
                    for(QuickTaskTypes types : QuickTaskTypes.values()){
                        System.out.println(Colorizer.colorWithCyanLetters((types.ordinal() + 1) + "._ " + types.getTaskTitle()));
                    }
                    do {
                        try {
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            int noteDetails = scanner.nextInt();
                            note.setNotesDetails(QuickTaskTypes.values()[noteDetails - 1]);
                            break;
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es de tipo numerico, favor ingresar un entero valido"));
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("4. Ingrese el autor de la nota que quiere ingresar");
                    note.setPersonalNoteAuthor(scanner.nextLine());
                    personalNotes.appendToList(note);
                    break;
                case 2 /*Registro de Nota Empresarial*/:
                    /*! NOTE_TITLE, NOTE_ID, NOTE_DETAILS, NOTE_AUTHOR, NOTE_COMPANY, NOTE_CATEGORY*/
                    BusinessNote businessNote = new BusinessNote(" ", 1, QuickTaskTypes.UNDEFINED, " ", " ");
                    printMenuOptionWithLeftAlignment("1. Ingrese el titulo de la nota que quiere ingresar");
                    businessNote.setNoteTitle(scanner.nextLine());
                    do {
                        printMenuOptionWithLeftAlignment("2. Ingrese el ID de la nota que quiere ingresar");
                        try {
                            int noteID = Integer.parseInt(scanner.nextLine());
                            businessNote.setNoteID(noteID);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no puede ser transformado a un NoteID de tipo entero. Intente de nuevo."));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("3. Ingrese el detalle de la nota que quiere ingresar, seleccionandolo de este listado (con su entero representante)");
                    System.out.println();
                    for(QuickTaskTypes types : QuickTaskTypes.values()){
                        System.out.println(Colorizer.colorWithCyanLetters((types.ordinal() + 1) + "._ " + types.getTaskTitle()));
                    }
                    do {
                        try {
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            int noteDetails = scanner.nextInt();
                            businessNote.setNotesDetails(QuickTaskTypes.values()[noteDetails - 1]);
                            break;
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es de tipo numerico, favor ingresar un entero valido"));
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("4. Ingrese el autor de la nota que quiere ingresar");
                    businessNote.setBusinessNoteAuthor(scanner.nextLine());
                    businessNote.setBusinessName(companyName);
                    printMenuOptionWithLeftAlignment("5. Ingrese la categoria de la nota que quiere ingresar");
                    businessNote.setBusinessNoteCategory(scanner.nextLine());
                    businessNotes.appendToList(businessNote);
                    break;
                case 3 /*Reunion Personal*/:
                    /*! MEETING_ID, MEETING_TITLE, MEETING_TYPE, MEETING_TIME, MEETING_ASIGNEE, MEETING_WILL_ATTEND */
                    PersonalMeeting meeting = new PersonalMeeting();
                    do {
                        printMenuOptionWithLeftAlignment("1. Ingrese el ID de la reunion que quiere ingresar");
                        try {
                            int noteID = Integer.parseInt(scanner.nextLine());
                            meeting.setI_MeetingID(noteID);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no puede ser transformado a un NoteID de tipo entero. Intente de nuevo."));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("2. Ingrese el titulo de la reunion que quiere ingresar");
                    meeting.setI_MeetingTitle(scanner.nextLine());
                    printMenuOptionWithLeftAlignment("3. Ingrese el tipo de reunion que quiere ingresar, seleccionandolo de este listado (con su entero representante)");
                    System.out.println();
                    for(QuickTaskTypes types : QuickTaskTypes.values()){
                        System.out.println(Colorizer.colorWithCyanLetters((types.ordinal() + 1) + "._ " + types.getTaskTitle()));
                    }
                    do {
                        try {
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            int noteDetails = scanner.nextInt();
                            meeting.setI_MeetingType(QuickTaskTypes.values()[noteDetails - 1]);
                            break;
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es de tipo numerico, favor ingresar un entero valido"));
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("4. Ingrese el tiempo de la reunion que quiere ingresar, seleccionandolo del listado (con su entero representante)");
                    System.out.println();
                    for(QuickTimeStamps quickTimeStamps : QuickTimeStamps.values()){
                        System.out.println(Colorizer.colorWithCyanLetters((quickTimeStamps.ordinal() + 1) + "._ " + quickTimeStamps));
                    }
                    do {
                        try {
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            int noteDetails = scanner.nextInt();
                            meeting.setI_MeetingType(QuickTaskTypes.values()[noteDetails - 1]);
                            break;
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es de tipo numerico, favor ingresar un entero valido"));
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("5. Ingrese el asistente de la reunion que quiere ingresar");
                    meeting.setI_MeetingAsigne(scanner.nextLine());
                    printMenuOptionWithLeftAlignment("6. Ingrese si asistira o no a la reunion que quiere ingresar (y/n)");
                    System.out.println();
                    do{
                        try{
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            String input = scanner.nextLine();
                            if (input.matches("y")){
                                meeting.setI_WillAttend(true);
                            }else if (input.matches("n")){
                                meeting.setI_WillAttend(false);
                            }else {
                                throw new IllegalArgumentException();
                            }
                            break;
                        }catch(NumberFormatException e ){
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no puede ser transformado a un valor ordinal de tipo entero"));
                        } catch (IllegalArgumentException e){
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while(true);
                    personalMeetings.scheduleAMeeting(meeting.getI_MeetingID(),
                                                      meeting.getI_MeetingTitle(),
                                                      meeting.getI_MeetingType(),
                                                      meeting.getI_MeetingTime(),
                                                     meeting.getI_MeetingAsigne());
                    break;
                case 4 /*Anadir reunion empresarial*/: {
                    /*MEETING_ID, MEETING_TITLE, MEETING_TYPE, MEETING_TIME, MEETING_ASIGNEE, MEETING_WILL_ATTEND, MEETING_COMPANY*/
                    int meetingID = 0;
                    String meetingTitle = " ";
                    QuickTaskTypes meetingType = QuickTaskTypes.UNDEFINED;
                    QuickTimeStamps meetingTime = QuickTimeStamps.MEDIANOCHE;
                    String meetingAsigne = " ";
                    boolean meetingWillAttend = false;
                    do {
                        printMenuOptionWithLeftAlignment("1. Ingrese el ID de la nota que quiere ingresar");
                        try {
                            int noteID = Integer.parseInt(scanner.nextLine());
                            meetingID = noteID;
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no puede ser transformado a un NoteID de tipo entero. Intente de nuevo."));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("2. Ingrese el titulo de la reunion que quiere ingresar");
                    meetingTitle = scanner.nextLine();
                    printMenuOptionWithLeftAlignment("3. Ingrese el tipo de reunion que quiere ingresar, seleccionandolo de este listado (con su entero representante)");
                    System.out.println();
                    for (QuickTaskTypes types : QuickTaskTypes.values()) {
                        System.out.println(Colorizer.colorWithCyanLetters((types.ordinal() + 1) + "._ " + types.getTaskTitle()));
                    }
                    do {
                        try {
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            int noteDetails = scanner.nextInt();
                            meetingType = (QuickTaskTypes.values()[noteDetails - 1]);
                            break;
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es de tipo numerico, favor ingresar un entero valido"));
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("4. Ingrese el tiempo de la reunion que quiere ingresar, seleccionandolo del listado (con su entero representante)");
                    for (QuickTimeStamps quickTimeStamps : QuickTimeStamps.values()) {
                        System.out.println(Colorizer.colorWithCyanLetters((quickTimeStamps.ordinal() + 1) + "._ " + quickTimeStamps));
                    }
                    do {
                        try {
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            int noteDetails = scanner.nextInt();
                            meetingTime = (QuickTimeStamps.values()[noteDetails - 1]);
                            break;
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es de tipo numerico, favor ingresar un entero valido"));
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("5. Ingrese el asistente de la reunion que quiere ingresar");
                    meetingAsigne = scanner.nextLine();
                    printMenuOptionWithLeftAlignment("6. Ingrese si asistira o no a la reunion que quiere ingresar (y/n)");
                    do {
                        try {
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            String input = scanner.nextLine();
                            if (input.matches("y")) {
                                meetingWillAttend = true;
                            } else {
                                throw new IllegalArgumentException();
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no puede ser transformado a un valor ordinal de tipo entero"));
                        } catch (IllegalArgumentException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while (true);
                    businessMeetings.scheduleAMeeting(meetingID,
                            meetingTitle,
                            meetingType,
                            meetingTime,
                            meetingAsigne);
                    break;
                }
                case 5 /*Registro Nueva Tarea Personal*/:
                    /*TASK_ID, TASK_DESCRIPTION, TASK_TIME, TASK_ASIGNEE*/
                    PersonalTask task = new PersonalTask();
                    do {
                        printMenuOptionWithLeftAlignment("1. Ingrese el ID de la nota que quiere ingresar");
                        try {
                            int noteID = Integer.parseInt(scanner.nextLine());
                            task.set_task_ID(noteID);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no puede ser transformado a un NoteID de tipo entero. Intente de nuevo."));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("2. Ingrese la descripcion de la tarea que quiere ingresar");
                    task.set_task_Description(scanner.nextLine());
                    printMenuOptionWithLeftAlignment("3. Ingrese el tiempo de la tarea que quiere ingresar, seleccionandolo de este listado (con su entero representante)");
                    System.out.println();
                    for(QuickTimeStamps quickTimeStamps : QuickTimeStamps.values()){
                        System.out.println(Colorizer.colorWithCyanLetters((quickTimeStamps.ordinal() + 1) + "._ " + quickTimeStamps));
                    }
                    do {
                        try {
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            int noteDetails = scanner.nextInt();
                            task.set_task_DueDate(QuickTimeStamps.values()[noteDetails - 1]);
                            break;
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es de tipo numerico, favor ingresar un entero valido"));
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("4. Ingrese el asistente de la tarea que quiere ingresar");
                    task.set_personalTaskAssignee(scanner.nextLine());
                    personalTasks.add(task);
                    break;
                case 6 /*Registro Nueva Tarea Business*/:
                    /*! TASK_ID, TASK_DESCRIPTION, TASK_TIME, TASK_DUE_DATE, TASK_ASIGNEE, TASK_COMPANY*/
                    BusinessTask task2 = new BusinessTask(1, "undefined", QuickTimeStamps.MEDIANOCHE, companyName);
                    do {
                        printMenuOptionWithLeftAlignment("1. Ingrese el ID de la nota que quiere ingresar");
                        try {
                            int noteID = Integer.parseInt(scanner.nextLine());
                            task2.set_task_ID(noteID);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no puede ser transformado a un NoteID de tipo entero. Intente de nuevo."));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("2. Ingrese la descripcion de la tarea que quiere ingresar");
                    task2.set_task_Description(scanner.nextLine());
                    printMenuOptionWithLeftAlignment("3. Ingrese el tiempo de la tarea que quiere ingresar, seleccionandolo de este listado (con su entero representante)");
                    System.out.println();
                    for(QuickTimeStamps quickTimeStamps : QuickTimeStamps.values()){
                        System.out.println(Colorizer.colorWithCyanLetters((quickTimeStamps.ordinal() + 1) + "._ " + quickTimeStamps));
                    }
                    do {
                        try {
                            printMenuOptionWithLeftAlignment("\tEl valor que ha seleccionado");
                            int noteDetails = scanner.nextInt();
                            task2.set_task_DueDate(QuickTimeStamps.values()[noteDetails - 1]);
                            break;
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es de tipo numerico, favor ingresar un entero valido"));
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(Colorizer.colorWithRedLetters("Error: El input ingresado no es un tipo de nota valido"));
                        }
                    } while (true);
                    scanner.nextLine();
                    printMenuOptionWithLeftAlignment("4. Ingrese el asistente de la tarea que quiere ingresar");
                    task2.set_task_Notes(new BusinessNotes(scanner.nextLine()));
                    businessTasks.add(task2);
                    break;
                case 7 /*Listar notas personales*/: {
                    System.out.println(Colorizer.colorWithCyanLetters("Listado de notas personales"));
                    personalNotes.sort();
                    var counter = 0;
                    for (Notes personalNote : personalNotes.getList()) {
                        System.out.print("[" + (counter + 1) + "] : ");
                        System.out.println(Colorizer.colorWithCyanLetters(((PersonalNote) personalNote).toString()));
                    }
                    break;
                }
                case 8 /*Listar notas business*/: {
                    System.out.println(Colorizer.colorWithCyanLetters("Listado de notas business"));
                    businessNotes.sort();
                    var counter = 0;
                    for (Notes businessNoteHandler : businessNotes.getList()) {
                        System.out.print("[" + (counter + 1) + "] : ");
                        System.out.println(Colorizer.colorWithCyanLetters(((BusinessNote) businessNoteHandler).toString()));
                    }
                    break;
                }
                case 9 /*Listar Reuniones Personales*/: {
                    System.out.println(Colorizer.colorWithCyanLetters("Listado de reuniones personales"));
                    personalMeetings.getMeetings().sort(
                            Comparator.comparing(o -> o.getI_MeetingTime().getTimeofDay()));
                    var counter = 0;
                    for (Meeting meetingHolderVar : personalMeetings.getMeetings()) {
                        System.out.print("[" + (counter + 1) + "] : ");
                        System.out.println(Colorizer.colorWithCyanLetters(meetingHolderVar.toString()));
                    }
                    break;
                }
                case 10 /*Listar Reuniones Business*/:{
                    System.out.println(Colorizer.colorWithCyanLetters("Listado de reuniones business"));
                    businessMeetings.getMeetings().sort(
                            Comparator.comparing(o -> o.getI_MeetingTime().getTimeofDay()));
                    var counter = 0;
                    for (Meeting meetingHolderVar : businessMeetings.getMeetings()) {
                        System.out.print("[" + (counter + 1) + "] : ");
                        System.out.println(Colorizer.colorWithCyanLetters(meetingHolderVar.toString()));
                    }
                    break;
                }
                case 11 /*Listar Tasks Personales*/: {
                    System.out.println(Colorizer.colorWithCyanLetters("Listado de tasks personales"));
                    personalTasks.sort(Comparator.comparing(Task::get_task_DueDate));
                    var counter = 0;
                    for (Task taskHolderVar : personalTasks) {
                        System.out.print("[" + (counter + 1) + "] : ");
                        System.out.println(Colorizer.colorWithCyanLetters(taskHolderVar.toString()));
                    }
                    break;
                }
                case 12 /*Listar Tasks Business*/: {
                    System.out.println(Colorizer.colorWithCyanLetters("Listado de tasks business"));
                    businessTasks.sort(Comparator.comparing(Task::get_task_DueDate));
                    var counter = 0;
                    for (Task taskHolderVar : businessTasks) {
                        System.out.print("[" + (counter + 1) + "] : ");
                        System.out.println(Colorizer.colorWithCyanLetters(taskHolderVar.toString()));
                    }
                    break;
                }
                case -1: {
                    System.out.println(Colorizer.colorWithCyanLetters("Saliendo del programa..."));
                    break;
                }
                default: {
                    System.out.println(Colorizer.colorWithRedLetters("Opcion no valida, por favor, ingrese una opcion del menu anterior"));
                    break;
                }
            }
        } while(userInput != -1);
    }

    private static void readInputDefineBusinessNotesInstance(Scanner scannerInstance){
        //! Para este metodo intentaremos permitir que el usuario a traves de la consola ingrese un tipo de dato por parametro
        //! en un menu amigable y definido para que se facilite la creacion de un BusinessNote Holder
    }
    private static void printCenteredMessage(String message) {
        int padding = (120 - message.length()) / 2;
        String centeredMessage = " ".repeat(Math.max(0, padding)) + message + " ".repeat(Math.max(0, padding));
        System.out.println(centeredMessage);
    }

    private static void printMenuOptionWithLeftAlignment(String message) {
        System.out.printf("%-60s\t\t\t: ", message);
    }

}

