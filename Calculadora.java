public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        return a / b; // No hay manejo de excepciones para división por cero
    }

    public int operacionCompleja(int a, int b, int c) {
        int resultado = a + b;
        resultado *= c;
        resultado -= b;
        resultado /= (a + 1);
        resultado += 5;
        return resultado;
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    Calculadora calculadora = new Calculadora();

    @Test
    public void testSumar() {
        assertEquals(5, calculadora.sumar(2, 3));
    }

    @Test
    public void testRestar() {
        assertEquals(1, calculadora.restar(3, 2));
    }

    @Test
    public void testMultiplicar() {
        assertEquals(6, calculadora.multiplicar(2, 3));
    }

    @Test
    public void testDividir() {
        assertEquals(2, calculadora.dividir(6, 3));
    }

    @Test
    public void testOperacionCompleja() {
        assertEquals(8, calculadora.operacionCompleja(2, 3, 4));
    }
}
