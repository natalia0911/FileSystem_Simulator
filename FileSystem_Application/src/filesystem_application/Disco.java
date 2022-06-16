
package filesystem_application;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



/**
 *
 * @author JacobPG
 */
public class Disco {
    
    private static final String FILENAME = "Disco.json";
    protected static int indice = 0;

    public static void escribirDisco(JSONObject disco, String filename) {
        try {
            Files.write(Paths.get(filename), disco.toJSONString().getBytes());
            //System.out.println(disco.toJSONString());
        } catch (IOException ex) {
            Logger.getLogger(Disco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static JSONObject obtenerDisco(String filename) {       
        try {
            JSONObject disco = (JSONObject) new JSONParser().parse(new FileReader(filename));
            return disco;
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Disco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static JSONObject generarSector(int cantidad){
        JSONObject sector = new JSONObject();
        sector.put("idSector", indice++);
        
        JSONArray espacios = new JSONArray();
        for(int i=0;i<cantidad;i++) espacios.add(0);
        sector.put("espacios", espacios);
        
        return sector;
    }
    
    public static JSONObject limpiarSector(int idSector, int cantidad){
        JSONObject sector = new JSONObject();
        sector.put("idSector", idSector);
        
        JSONArray espacios = new JSONArray();
        for(int i=0;i<cantidad;i++) espacios.add(0);
        sector.put("espacios", espacios);
        
        return sector;
    }
    
    
    public static void inicializarDisco(int cantSectores, int cantEspacios){
        JSONObject disco = new JSONObject();
        JSONArray sectores = new JSONArray();
        
        for(int i=0;i<cantSectores;i++) sectores.add(generarSector(cantEspacios));
        disco.put("Sectores", sectores);
        
        escribirDisco(disco, FILENAME);
        
    }
    
    public static void vaciarSector(int idSector) {
        JSONObject disco = obtenerDisco(FILENAME);
        JSONArray sectores = (JSONArray) disco.get("Sectores");
        JSONObject sector = (JSONObject) sectores.get(idSector);
        JSONArray espacios = (JSONArray) sector.get("espacios");
        
        sectores.set(idSector, limpiarSector(idSector,espacios.size()));
        
        disco.put("Sectores", sectores);
        escribirDisco(disco, FILENAME);
                
    }
    
    public static void main(String[] args) throws Exception {
        
        inicializarDisco(4,2);
        vaciarSector(2);
        
    }

}
