package ventanas;

import contoladores.Controlador;
import datos.DatosTrabajador;
import modelo.Trabajador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiTrabajador extends Ventana implements ActionListener {
	JButton agregarTrabajador;
	JButton actualizarTabla;
	JTextField agregarNombre;
	JTextField agregarApellido;
	JTextField agregarRut;
	JTextField agregarIsapre;
	JTextField agregarAFP;
	JScrollPane tabla;
	Controlador controlador;

	public GuiTrabajador() {
		controlador = new Controlador();
		crearMarco();
		crearEtiquetas();
		crearCamposDeTexto();
		crearTabla();
		crearBotones();
		this.setVisible(true);
	}

	private void crearMarco(){
		this.definirDimensiones(1050, 500);
		this.definirTitulo("Gui Trabajador");
	}

	public void crearEtiquetas(){
		this.generarEtiqueta("Nombre: " , 50,100,75,25);
		this.generarEtiqueta("Apellido: " , 50,150,75,25);
		this.generarEtiqueta("Rut: " , 50,200,75,25);
		this.generarEtiqueta("Isapre: ", 50,250,75,25);
		this.generarEtiqueta("AFP: ", 50,300,75,25);
	}

	private void crearCamposDeTexto() {
		agregarNombre = this.generarCampoDeTexto(125,100,200,25);
		agregarApellido = this.generarCampoDeTexto(125,150,200, 25);
		agregarRut = this.generarCampoDeTexto(125, 200, 200, 25);
		agregarIsapre = this.generarCampoDeTexto(125,250,200,25);
		agregarAFP = this.generarCampoDeTexto(125,300,200,25);
	}

	private void crearTabla(){
		String[][] datos = controlador.obtenerArregloTrabajadores();
		String[] columnas = {"Nombre", "Apellido", "Rut", "Isapre", "AFP"};
		tabla = this.generarTabla(datos, columnas,370, 100, 650, 150);
	}

	private void crearBotones(){
		agregarTrabajador = this.generarBoton("Agregar", 100,350,130,50);
		agregarTrabajador.addActionListener(this);
		actualizarTabla = this.generarBoton("Actualizar", 250, 350, 130, 50);
		actualizarTabla.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == agregarTrabajador) {
			controlador.agregarTrabajador(
					agregarNombre.getText(),
					agregarApellido.getText(),
					agregarRut.getText(),
					agregarIsapre.getText(),
					agregarAFP.getText()
			);
		}
		if(e.getSource() == actualizarTabla){
			crearTabla();
		}
	}
}