/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Esteban
 */
public class Principal extends JFrame implements ActionListener {

    private JLabel etiqueta_texto;
    private JTextField campo_rutaArchivo;
    private JButton boton_cargar;
    private int contador;
    private Secundaria ventanaSecundaria;

    /**
     * Constructor de la clase Principal
     */
    public Principal() {
        super();
        iniciarVentana();
        iniciarComponentes();
    }

    /**
     * Metodo iniciarVentana se encarga de iniciar la ventana Principal con sus
     * respectivas configuraciones.
     *
     * @param void
     * @return void
     */
    private void iniciarVentana() {
        this.setTitle("Lector de texto");                       // colocamos titulo a la ventana
        this.setSize(800, 500);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    /**
     * Metodo iniciarComponentes de encarga de agreagar y configurar cada
     * componente de la ventana.
     *
     * @param void
     * @return void
     */
    private void iniciarComponentes() {
        contador = 0;
        // creamos los componentes 
        Font fuente = new Font("Arial", 1, 23);
        campo_rutaArchivo = new JTextField();
        etiqueta_texto = new JLabel("Ingrese la ubicación del archivo");
        boton_cargar = new JButton("Cargar archivo");
        // configuramos los componentes
        etiqueta_texto.setBounds(230, 50, 400, 25);          // asignamos posicion y tamaño a la etiqueta(x, y, ancho, alto)
        etiqueta_texto.setFont(fuente);                      // asiganmos la configuracion de las letras
        etiqueta_texto.setForeground(Color.BLACK);           // asignamos el color de las letras

        campo_rutaArchivo.setBounds(100, 120, 600, 60);
        campo_rutaArchivo.setFont(fuente);
        campo_rutaArchivo.setForeground(Color.BLACK);

        boton_cargar.setBounds(280, 250, 200, 80);
        boton_cargar.addActionListener(this);                // activamos el boton
        boton_cargar.setFont(fuente);
        boton_cargar.setForeground(Color.BLACK);
        // añadimos los componentes a la ventana
        this.add(etiqueta_texto);
        this.add(campo_rutaArchivo);
        this.add(boton_cargar);
    }

    /**
     * Metodo guardarVentana se encarga de guarda la ventana ingresada como
     * parámetros.
     *
     * @param ventanaSecundaria
     */
    public void guardarVentana(Secundaria ventanaSecundaria) {
        this.ventanaSecundaria = ventanaSecundaria;
    }

    /**
     * Metodo getVentana se encarga de retornar el estado del objeto
     * pertenecieste a la clase Principal.
     *
     * @return
     */
    public Principal getVentana() {
        return this;
    }

    /**
     * Metodo getCuadro sera utilizado para obtener la ruta de ubicacion del
     * archivo que se decea leer.
     *
     * @return
     */
    public JTextField getCuadro() {
        return campo_rutaArchivo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_cargar) {
            if (contador == 0) {
                Secundaria texto = new Secundaria(getVentana());
                texto.setVisible(true);
                this.setVisible(false);
            } else {
                ventanaSecundaria.setVisible(true);
                this.setVisible(false);
            }
        }
    }
}
