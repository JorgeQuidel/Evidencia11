package datos;

public interface InterfaceDatos {
    String leerContenidos(String ruta);
    void escribirArchivo(String ruta, String contenido);
}