/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gestorArchivos.GestorArchivos;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Esteban
 */
public class testGestorArchivos {

    private GestorArchivos arch;

    @Before
    public void setUp() {
        arch = new GestorArchivos();
    }

    /**
     * Test encargado de probar el método leerTexto1 con un archivo que no
     * existe.
     *
     * @throws IOException
     */
    @Test
    public void testTexto1() throws IOException {
        String resultado = arch.leerTexto1("nada.txt");
        String resultadoEsperado = "nada";
        assertEquals(resultadoEsperado, resultado);
    }

    /**
     * Test encargado de probar el método leerTexto1 con un archivo que no
     * existe.
     *
     * @throws IOException
     */
    @Test
    public void testTexto2() throws IOException {
        String resultado = arch.leerTexto2("nada.txt");
        String resultadoEsperado = "nada";
        assertEquals(resultadoEsperado, resultado);
    }
}
