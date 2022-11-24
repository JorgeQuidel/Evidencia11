package datos;

import java.util.ArrayList;

import excepciones.AccesoADatosInterrumpidoException;
import modelo.Trabajador;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DatosTrabajador implements InterfaceDatos {
    private final String RUTA_TRABAJADORES = "src/main/java/datos/trabajadores.txt";

    private JSONArray parsearTrabajadores() throws AccesoADatosInterrumpidoException {
        return parsearArchivoJSON(RUTA_TRABAJADORES);
    }

    public List<Trabajador> obtenerTrabajadores() {
        List<Trabajador> trabajadores = new ArrayList<>();
        try{
            JSONArray jsonArrayTrabajadores = parsearTrabajadores();
            for (Object jsonArrayTrabajador : jsonArrayTrabajadores) {
                JSONObject trabajadorSiguiente = (JSONObject) jsonArrayTrabajador;
                Trabajador trabajador = new Trabajador();
                obtenerAtributosDeTrabajadorJSON(trabajador, trabajadorSiguiente);
                trabajadores.add(trabajador);
            }
            return trabajadores;
        }catch (AccesoADatosInterrumpidoException e){
            return new ArrayList<>();
        }
    }

    private void obtenerAtributosDeTrabajadorJSON(Trabajador trabajador, JSONObject trabajadoresJSON) {
        trabajador.setNombre(trabajadoresJSON.get("Nombre").toString());
        trabajador.setApellido(trabajadoresJSON.get("Apellido").toString());
        trabajador.setRut(trabajadoresJSON.get("Rut").toString());
        trabajador.setIsapre(trabajadoresJSON.get("Isapre").toString());
        trabajador.setAFP(trabajadoresJSON.get("AFP").toString());
    }

    public String[][] obtenerArregloDeTrabajadores(){
        var trabajadores = obtenerTrabajadores();
        if(trabajadores.size() == 0){
            return new String[0][5];
        }
        return trabajadores.stream().map(Trabajador::obtenerAtributos).toArray(String[][]::new);
    }

    public void crearTrabajador(Trabajador trabajador) {;
        List<Trabajador> trabajadores = obtenerTrabajadores();
        trabajadores.add(trabajador);
        escribirTrabajadores(trabajadores);
    }

    public void escribirTrabajadores(List<Trabajador> trabajadores) {
        escribirArchivo(RUTA_TRABAJADORES, convertirListaDeTrabajadoresAJSONArray(trabajadores).toJSONString());
    }

    private JSONArray convertirListaDeTrabajadoresAJSONArray(List<Trabajador> trabajadores) {
        JSONArray array = new JSONArray();
        for (Trabajador trabajador : trabajadores) {
            JSONObject trabajadorObj = new JSONObject();
            convertirJSONCampoInfoTrabajador(trabajador, trabajadorObj);
            array.add(trabajadorObj);
        }
        return array;
    }

    private static void convertirJSONCampoInfoTrabajador(Trabajador trabajador, JSONObject trabajadorObj) {
        trabajadorObj.put("Nombre", trabajador.getNombre());
        trabajadorObj.put("Apellido", trabajador.getApellido());
        trabajadorObj.put("Rut", trabajador.getRut());
        trabajadorObj.put("Isapre", trabajador.getIsapre());
        trabajadorObj.put("AFP", trabajador.getAFP());
    }

    public JSONArray parsearArchivoJSON(String ruta) throws AccesoADatosInterrumpidoException {
        try {
            String contenidosJSON = leerContenidos(ruta);
            JSONParser parser = new JSONParser();
            return (JSONArray) parser.parse(contenidosJSON);
        } catch (ParseException e) {
            throw AccesoADatosInterrumpidoException.noSePudoParsearArchivo(ruta);
        }
    }

    public String leerContenidos(String ruta) {
        try{
            StringBuilder st = new StringBuilder();
            File archivoJSON = new File(ruta);
            Scanner scanner = new Scanner(archivoJSON);
            while (scanner.hasNextLine()) {
                st.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            return st.toString();
        }catch (FileNotFoundException e){
            throw AccesoADatosInterrumpidoException.noSePudoCargarArchivo(ruta);
        }
    }

    public void escribirArchivo(String ruta, String contenido) {
        try {
            FileWriter myWriter = new FileWriter(ruta);
            myWriter.write(contenido);
            myWriter.close();
        } catch (IOException | NullPointerException e) {
            throw AccesoADatosInterrumpidoException.noSePudoEscribirArchivo(ruta);
        }
    }
}