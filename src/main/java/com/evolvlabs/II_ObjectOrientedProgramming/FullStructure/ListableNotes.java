package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.util.Comparator;
import java.util.List;

public interface ListableNotes {

    /**
     * Metodo para ordenar las notas en funcion de un criterio especifico.
     */
    void sort();

    void organizarPorCriterio(Comparator<Notes> criterio);

    /**
     * Metodo para agregar una nota nueva a la lista existente.
     * @param nota Una cadena representando la nota que se quiere agregar.
     */
    void appendToList(Notes nota);

    /**
     * Metodo para devolver todas las notas almacenadas en forma de lista.
     * @return Una lista que contiene todas las notas.
     */
    List<Notes> getList();



}
