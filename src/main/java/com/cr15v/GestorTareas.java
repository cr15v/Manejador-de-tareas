package com.cr15v;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private List<Tarea> tareas;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        if (tarea == null) {
            throw new RuntimeException("No se puede agregar una tarea nula");
        }
        tareas.add(tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.remove(tarea); // ⚠ No verifica si la tarea está en la lista
    }

    public int contarTareas() {
        return tareas.size();
    }

    public Tarea obtenerPrimeraTarea() {
        return tareas.get(0); // ⚠ Posible IndexOutOfBoundsException
    }
}
