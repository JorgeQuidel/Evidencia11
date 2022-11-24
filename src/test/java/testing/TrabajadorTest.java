package testing;

import excepciones.AccesoADatosInterrumpidoException;
import modelo.Trabajador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrabajadorTest {

    private Trabajador trabajador;

    @BeforeEach
    void inint(){
        trabajador = new Trabajador();
        trabajador.setNombre("Jorge");
        trabajador.setApellido("Quidel");
        trabajador.setRut("123456789");
        trabajador.setIsapre("Isapre");
        trabajador.setAFP("AFP");
    }

    @Test
    void obtenerAtributosTest() {
        assertEquals(5, trabajador.obtenerAtributos().length);
    }

    @Test
    void obtenerAtributosTest2(){
        String[] atributos = {"Jorge", "Quidel", "123456789", "Isapre", "AFP"};
        assertArrayEquals(atributos, trabajador.obtenerAtributos());
    }
}