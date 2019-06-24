/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesGraficas;

import gestorArchivos.GestorArchivos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Esteban
 */
public class Secundaria extends JFrame implements ActionListener {

    private JTextArea etiqueta_texto;
    private JButton boton_mostrar;
    private JButton boton_otro;
    private Principal ventanaPrincipal;
    private JScrollPane barraDeslizante;
    private JPanel panelInferior;

    /**
     * Constructor de la clase Secundaria
     *
     * @param ventanaInicio
     */
    public Secundaria(Principal ventanaInicio) {
        super();
        iniciarVentana();
        iniciarComponentes();
        iniciarPanelInferior();
        this.ventanaPrincipal = ventanaInicio;
    }

    /**
     * Metodo iniciarVentana se encarga de iniciar la ventana Secundaria con sus
     * respectivas configuraciones.
     *
     * @param void
     * @return void
     */
    private void iniciarVentana() {
        this.setTitle("Lector de texto");    // colocamos titulo a la ventana
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Metodo iniciarComponentes de encarga de agregar y configurar cada
     * componente de la ventana.
     *
     * @param void
     * @return void
     */
    private void iniciarComponentes() {
        // creamos los componentes 
        Font fuente = new Font("Arial", 1, 14);
        boton_mostrar = new JButton("Mostrar texto");
        boton_otro = new JButton("Cargar otro archivo");
        // configuramos los componentes
        boton_mostrar.setBounds(100, 80, 230, 50);
        boton_mostrar.setFont(fuente);
        boton_mostrar.addActionListener(this);
        boton_otro.setBounds(470, 80, 230, 50);
        boton_otro.setFont(fuente);
        boton_otro.addActionListener(this);
        // añadimos los componentes a la ventana
        this.add(boton_mostrar);
        this.add(boton_otro);
    }

    /**
     * Metodo iniciarPanelInferior es el que inicia el panel del inferior de la
     * ventana, quien se encargara de mostrar el contenido del archivo, ademas
     * crea y configura los componentes pertenecientes a este panel.
     *
     * @param void
     * @return void
     */
    private void iniciarPanelInferior() {
        panelInferior = new JPanel();
        panelInferior.setBounds(100, 160, 600, 250);
        panelInferior.setLayout(new BorderLayout());
        etiqueta_texto = new JTextArea("Contenido de archivo.");
        panelInferior.add(etiqueta_texto);
        barraDeslizante = new JScrollPane(etiqueta_texto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelInferior.add(barraDeslizante, BorderLayout.CENTER);
        this.add(panelInferior);
    }

    /**
     * Metodo mostrarTexto es el que usa las funcionalidades de la clase
     * GestorArchivos para mostrar el contenido del archivo deseado.
     *
     * @throws IOException
     */
    public void mostrarTexto() throws IOException {
        GestorArchivos gestor = new GestorArchivos();
        String ubicacion = ventanaPrincipal.getCuadro().getText();
        if (ubicacion.equals("archivos\\archivo1.txt")) {
            etiqueta_texto.setText(gestor.leerTexto1(ubicacion));
        } else if (ubicacion.equals("archivos\\archivo2.txt")) {
            etiqueta_texto.setText(gestor.leerTexto2(ubicacion));
        } else {
            JOptionPane.showMessageDialog(this, "Introduzca una ruta válida.");
            ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_mostrar) {
            try {
                mostrarTexto();
            } catch (IOException ex) {
                Logger.getLogger(Secundaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == boton_otro) {
            ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }
}
