/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Esteban
 */
public class GestorArchivos {

    /**
     * Metodo leerTexto1 se encarga de leer un archivo y de retornar el texto
     * contenido solo con sus líneas pares.
     *
     * @param ruta es la ubicacion del archivo a leer.
     * @return Texto sin líneas impares de tipo String.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String leerTexto1(String ruta) throws FileNotFoundException, IOException {
        File f = new File(ruta);
        if (f.exists()) {
            String linea;
            String mensaje = "";
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while ((linea = br.readLine()) != null) {
                br.readLine();
                mensaje = mensaje + linea + "\n";

            }
            return mensaje;
        }
        return "nada";
    }

    /**
     * Metodo leerTexto2 se encarga de leer un archivo y retornar el texto
     * contenido sin saltos de línea.
     *
     * @param ruta es la ubicacion del archivo a leer.
     * @return Texto en línea recta de tipo String.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String leerTexto2(String ruta) throws FileNotFoundException, IOException {
        File f = new File(ruta);
        if (f.exists()) {
            String linea;
            String mensaje = "";
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                mensaje = mensaje + linea;
            }
            return mensaje;
        }
        return "nada";
    }
}
