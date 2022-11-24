package ventanas;

import javax.swing.*;
import java.awt.*;

public abstract class Ventana extends JFrame {

    public Ventana() {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    protected void definirTitulo(String titulo){
        this.setTitle(titulo);
    }

    protected void definirDimensiones(int ancho, int largo){
        this.setSize(ancho, largo);
        this.setLocationRelativeTo(null);
    }

    protected JTextField generarCampoDeTexto(int x, int y, int ancho, int largo) {
        JTextField campoDeTexto = new JTextField();
        campoDeTexto.setBounds(x, y, ancho, largo);
        this.add(campoDeTexto);
        return campoDeTexto;
    }

    protected JButton generarBoton(String texto, int x, int y, int ancho, int largo) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, largo);
        this.add(boton);

        return boton;
    }

    protected JLabel generarEtiqueta (String texto, int x, int y, int ancho, int largo, String fuente, int tamaño) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        Font myFont1 = new Font(fuente, Font.BOLD, tamaño);
        etiqueta.setFont(myFont1);
        this.add(etiqueta);
        return etiqueta;
    }

    protected JLabel generarEtiqueta (String texto, int x, int y, int ancho, int largo) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        this.add(etiqueta);
        return etiqueta;
    }

    protected JScrollPane generarTabla(Object[][] datos, String[] columnas, int x, int y, int ancho, int largo){
        JTable tabla = new JTable(datos, columnas);
        tabla.setBounds(x,y,ancho,largo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(x, y, ancho, largo);
        tabla.setFillsViewportHeight(true);
        this.add(scroll);
        return scroll;

    }
}