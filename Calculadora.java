package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class Calculadora {
    public static int ultimoResultado = 0;

    public static int sumar(int a, int b) {
        ultimoResultado = a + b;
        System.out.println("Resultado: " + ultimoResultado); // Debería usar Logger
        return ultimoResultado;
    }

    public static int dividir(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            // Swallowing exception: mala práctica
            return 0;
        }
    }

    @Test
    public void testSumar() {
        int resultado = CalculadoraMala.sumar(2, 3);
        assertEquals(5, resultado);
    }

    @Test
    public void testDividir() {
        int resultado = CalculadoraMala.dividir(10, 2);
        assertEquals(5, resultado);
    }

    @Test
    public void testDividirPorCero() {
        int resultado = CalculadoraMala.dividir(10, 0);
        assertEquals(0, resultado); // No lanza excepción, incorrecto
    }
}
