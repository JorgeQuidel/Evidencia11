package contoladores;

import datos.DatosTrabajador;
import modelo.Trabajador;

public class Controlador {
    public void agregarTrabajador(String nombre, String apelido, String rut, String isapre, String afp){
        DatosTrabajador dao = new DatosTrabajador();
        Trabajador trabajador = new Trabajador();
        trabajador.setNombre(nombre);
        trabajador.setApellido(apelido);
        trabajador.setRut(rut);
        trabajador.setIsapre(isapre);
        trabajador.setAFP(afp);
        dao.crearTrabajador(trabajador);
    }

    public String[][] obtenerArregloTrabajadores(){
        DatosTrabajador dao = new DatosTrabajador();
        return dao.obtenerArregloDeTrabajadores();
    }
}
