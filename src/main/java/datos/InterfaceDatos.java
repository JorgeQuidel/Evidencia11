package datos;

public interface InterfaceDatos {
    String leerContenidosJSON(String ruta);
    void escribirArchivoJSON(String ruta, String contenido);
}