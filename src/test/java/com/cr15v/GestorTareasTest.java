package com.cr15v;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestorTareasTest {

    @Test
    public void testAgregarTarea() {
        GestorTareas gestor = new GestorTareas();
        Tarea tarea = new Tarea("Hacer compras");

        gestor.agregarTarea(tarea);

        assertEquals(1, gestor.contarTareas());
    }

    @Test
    public void testEliminarTarea() {
        GestorTareas gestor = new GestorTareas();
        Tarea tarea = new Tarea("Hacer ejercicio");

        gestor.agregarTarea(tarea);
        gestor.eliminarTarea(tarea);

        assertEquals(0, gestor.contarTareas());
    }

    @Test
    public void testExcepcionAgregarTareaNula() {
        GestorTareas gestor = new GestorTareas();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            gestor.agregarTarea(null);
        });

        assertEquals("No se puede agregar una tarea nula", exception.getMessage());
    }
}
