package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

/**
 * <body style="color: white">El presente archivo contiene las implementaciones base para una enumeracion avanzada
 * con un tipo de dato interno y varios metodos adicionales usados para darle al programa un nivel mayor de sofistificacion.
 * Las constantes enumeradas de este archivo se utilizan a lo largo del documento para definir notas o tasks rapidas y
 * demostrativas.</body>
 */
public enum QuickTaskTypes {

    /*! Declaraciones de valores enumerados en el orden real */
    /*
     ? Las lineas luego de este comentario, muestran el orden de declaracion de las constantes enumeradas de QuickTaskTypes.
     ? El orden de enumeracion que adhieren se da as-is en el orden de declaracion. Notese el tipo de declaracion que hace
     ? uso de un constructor adicional definido en la parte inferior.
     */
    COMER("Comer"),
    DORMIR("Dormir"),
    TRABAJAR("Trabajar"),
    JUGAR("Jugar"),
    ESTUDIAR("Estudiar"),
    HACER_EJERCICIO("Hacer ejercicio"),
    LEER("Leer"),
    VER_SERIES("Ver series"),
    IR_AL_BANCO("Ir al banco"),
    IR_AL_CINE("Ir al cine"),
    IR_AL_GYM("Ir al gym"),
    IR_AL_MUSEO("Ir al museo"),
    IR_AL_RESTAURANTE("Ir al restaurante"),
    IR_AL_SUPERMERCADO("Ir al supermercado"),
    IR_AL_TRABAJO("Ir al trabajo"),
    IR_AL_ZOOLOGICO("Ir al zoológico"),
    IR_A_LA_PLAYA("Ir a la playa"),
    IR_A_LA_TIENDA("Ir a la tienda"),
    IR_A_LA_UNIVERSIDAD("Ir a la universidad"),
    IR_AL_PARQUE("Ir al parque"),
    UNDEFINED("Undefined");

    /*!Este es un campo privado que esta enumeracion y cada una de sus instancias contienen*/
    private String TaskTitle;
    public final String EnumType = "QUICK_TASK_TYPES";
    protected final Integer EnumCount = 19;


    //! Este es un constructor privado que nos permite declarar los valores de la enumeracion
    private QuickTaskTypes(String taskTitle){
        this.setTaskTitle(taskTitle);
    }

    /*! Estos son metodos que cada instancia de la enumeracion puede acceder, pueden ser finales, estaticos o variar
      ! el modificador de accesso*/
    private void setTaskTitle(String taskTitle){
        if (!taskTitle.isBlank()){
            this.TaskTitle = taskTitle;
        }
        else {this.TaskTitle = " ";}
    }
    public String getTaskTitle() {
        return TaskTitle;
    }
    public String getEnumType() {
        return EnumType;
    }
    public Integer getEnumCount() {
        return EnumCount;
    }
}
