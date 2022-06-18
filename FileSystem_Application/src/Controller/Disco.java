package Controller;

import Model.MyFile;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter; 

/**
 *
 * @author JacobPG
 */
public class Disco {

    private static final String FILENAME = "Disco.json";
    private static int cantSectores = 0;
    private static int cantEspacios = 0;
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

    public static JSONObject generarSector(int cantidad) {
        JSONObject sector = new JSONObject();
        sector.put("idSector", indice++);

        JSONArray espacios = new JSONArray();
        for (int i = 0; i < cantidad; i++) {
            espacios.add(0);
        }
        sector.put("espacios", espacios);

        return sector;
    }

    public static JSONObject limpiarSector(int idSector, int cantidad) {
        JSONObject sector = new JSONObject();
        sector.put("idSector", idSector);

        JSONArray espacios = new JSONArray();
        for (int i = 0; i < cantidad; i++) {
            espacios.add(0);
        }
        sector.put("espacios", espacios);

        return sector;
    }

    public static void inicializarDisco(int cantSectores, int cantEspacios) {
        JSONObject disco = new JSONObject();
        JSONArray sectores = new JSONArray();

        for (int i = 0; i < cantSectores; i++) {
            sectores.add(generarSector(cantEspacios));
        }
        disco.put("Sectores", sectores);

        escribirDisco(disco, FILENAME);

        Disco.cantSectores = cantSectores;
        Disco.cantEspacios = cantEspacios;

    }

    public static void vaciarSector(int idSector) {
        JSONObject disco = obtenerDisco(FILENAME);
        JSONArray sectores = (JSONArray) disco.get("Sectores");
        JSONObject sector = (JSONObject) sectores.get(idSector);
        JSONArray espacios = (JSONArray) sector.get("espacios");

        sectores.set(idSector, limpiarSector(idSector, espacios.size()));

        disco.put("Sectores", sectores);
        escribirDisco(disco, FILENAME);

    }

    public static void modificarSector(int idSector, String contenido) {
        if (contenido.length() > cantEspacios) {
            return;
        }

        JSONObject disco = obtenerDisco(FILENAME);
        JSONArray sectores = (JSONArray) disco.get("Sectores");
        JSONObject sector = new JSONObject();
        sector.put("idSector", idSector);

        JSONArray espacios = new JSONArray();
        for (int i = 0; i < cantEspacios; i++) {
            if (i < contenido.length()) {
                espacios.add(contenido.substring(i, i + 1));
            } else {
                espacios.add(0);
            }
        }
        sector.put("espacios", espacios);
        sectores.set(idSector, sector);

        disco.put("Sectores", sectores);
        escribirDisco(disco, FILENAME);

    }

    public static int sectoresVacios() {
        JSONObject disco = obtenerDisco(FILENAME);
        JSONArray sectores = (JSONArray) disco.get("Sectores");
        JSONObject sector;
        JSONArray espacios;
        int cantVacios = 0;
        long variable = 0;

        for (int i = 0; i < cantSectores; i++) {
            sector = (JSONObject) sectores.get(i);
            espacios = (JSONArray) sector.get("espacios");
            if (espacios.get(0).getClass().isInstance(variable)) {
                cantVacios++;
            }
        }
        //System.out.println("Cantidad vacios: "+cantVacios);
        return cantVacios;
    }

    public static MyFile updateSectores(MyFile file, int total, Boolean agregar) {
        JSONObject disco = obtenerDisco(FILENAME);
        JSONArray sectores = (JSONArray) disco.get("Sectores");
        JSONObject sector;
        JSONArray espacios;
        long variable = 0;
        if (agregar) {//Si hay que agregarle espacios nuevos
            for (int i = 0; i < cantSectores; i++) {
                sector = (JSONObject) sectores.get(i);
                espacios = (JSONArray) sector.get("espacios");

                if (espacios.get(0).getClass().isInstance(variable)) {
                    file.sectors.add(i);
                }
                if (file.sectors.size() == total) {
                    break;
                }
            }
        } else {//Si hay que eliminar espacios.
            while (file.sectors.size() != total) {
                //lo elimina de la lista y lo vacía del disco.
                vaciarSector(file.sectors.remove(file.sectors.size() - 1));
            }
        }
        return file;
    }

    public static void modificarContenido(MyFile file, String contenido) {
        int sectContenido = contenido.length() / cantEspacios;
        if (contenido.length() % cantEspacios != 0) {
            sectContenido++;
        }

        //System.out.println("sectContenido: "+sectContenido);
        //System.out.println("Tamaño: "+file.sectors.size());
        //Si no cabe el contenido, no lo agrega.
        if ((file.sectors.size() + sectoresVacios()) < sectContenido) {
            //System.out.println("Primero");
            return;
        } else if (file.sectors.size() < sectContenido) {
            file = updateSectores(file, sectContenido, true);
            //System.out.println("Segundo");
        } else {
            file = updateSectores(file, sectContenido, false);
            //System.out.println("Tercero");
        }

        //System.out.println("Tamaño: "+file.sectors.size());
        //System.out.println("Sectores MyFile: "+file.sectors.toString());
        for (int i = 0; i < file.sectors.size(); i++) {
            if ((i * cantEspacios + cantEspacios) > contenido.length()) {
                modificarSector(file.sectors.get(i), contenido.substring(i * cantEspacios, contenido.length()));
            } else {
                modificarSector(file.sectors.get(i), contenido.substring(i * cantEspacios, i * cantEspacios + cantEspacios));
            }
        }
    }

    public static void createTxtFile() {
        try {
            File myObj = new File("disc.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void writeFromJson(){
       JSONParser parser = new JSONParser();
       String myText = ""; 
       try{
           Object obj = parser.parse(new FileReader("Disco.json"));
           JSONObject jsonObject = (JSONObject) obj;
           JSONArray sectores = (JSONArray) jsonObject.get("Sectores");
           for( int i =  0; i < sectores.size() ; i++ ){
               JSONObject jsonObject1 = (JSONObject) sectores.get(i);
               JSONArray espacios = (JSONArray) jsonObject1.get("espacios");
               for (int j = 0 ; j < espacios.size(); j++){
                   //System.out.println(espacios.get(j));
                   int x = (int)(long)espacios.get(j);
                   myText =  myText + Integer.toString(x);
                  
               }
                myText = myText +"\n";
               
           }
           System.out.println(myText);
           FileWriter myWriter = new FileWriter("disc.txt");
           myWriter.write(myText);
           myWriter.close();
       }catch(Exception ex){
           System.out.println(ex);
       }
    }

    public static void main(String[] args) throws Exception {
        writeFromJson();
        //inicializarDisco(3, 2);
        //vaciarSector(2);
        //modificarSector(1,"Jacob");
        //MyFile archivo = new MyFile("Ejemplo", "C:/", new ArrayList<Integer>());

        //archivo.sectors.add(1);
        //modificarSector(1, "00");

        //modificarContenido(archivo, "JACOB");

        //System.out.println("JACOB".substring(2,5));
    }

}