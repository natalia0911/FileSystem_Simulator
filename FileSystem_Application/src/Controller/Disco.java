package Controller;

import Model.MyFile;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileWriter; 
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author JacobPG
 */
public class Disco {

    private static final String FILENAME = "Disco.txt";
    private static int cantSectores = 0;
    private static int cantEspacios = 0;
    protected static int indice = 0;
    private static JSONObject discoJson;

    public static String jsonToString(){
        String contenido="";
        
        JSONArray sectores = (JSONArray) discoJson.get("Sectores");
        JSONObject sector;
        JSONArray espacios;
        
        for(int i=0;i<cantSectores;i++){
            sector = (JSONObject) sectores.get(i);
            espacios = (JSONArray) sector.get("espacios");
            for (Object caracter: espacios) contenido = contenido + caracter;
            contenido = contenido + "\n";
        }
        //System.out.println("jsonToString: "+contenido);
        return contenido;
    }
    
    public static void escribirDisco(String filename) {
        FileWriter fichero=null;
        PrintWriter pw;
        try{
            fichero = new FileWriter(FILENAME);
            pw = new PrintWriter(fichero);
            pw.print(jsonToString());
            
        } catch (IOException e) {
        } finally {
           try {
               if (null != fichero) fichero.close();
           } catch (IOException e2) {
           }
        }
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
        discoJson = new JSONObject();
        JSONArray sectores = new JSONArray();
        
        for(int i=0;i<cantSectores;i++) sectores.add(generarSector(cantEspacios));
        discoJson.put("Sectores", sectores);
        
        Disco.cantSectores=cantSectores;
        Disco.cantEspacios=cantEspacios;
        
        escribirDisco(FILENAME);
        
    }

    public static void vaciarSector(int idSector) {
        JSONArray sectores = (JSONArray) discoJson.get("Sectores");
        JSONObject sector = (JSONObject) sectores.get(idSector);
        JSONArray espacios = (JSONArray) sector.get("espacios");
        
        sectores.set(idSector, limpiarSector(idSector,espacios.size()));
        
        discoJson.put("Sectores", sectores);                
    }

    public static void modificarSector(int idSector, String contenido){
        if (contenido.length()>cantEspacios) return;
        
        JSONArray sectores = (JSONArray) discoJson.get("Sectores");        
        JSONObject sector = new JSONObject();
        sector.put("idSector", idSector);
        
        JSONArray espacios = new JSONArray();
        for(int i=0;i<cantEspacios;i++){
            if (i<contenido.length()) espacios.add(contenido.substring(i, i+1));
            else espacios.add(0);
        }
        sector.put("espacios", espacios);
        sectores.set(idSector, sector);
        
        discoJson.put("Sectores", sectores);        
    }

    public static int sectoresVacios(){
        JSONArray sectores = (JSONArray) discoJson.get("Sectores");
        JSONObject sector;
        JSONArray espacios;
        int cantVacios=0;
        Integer variable=0;
        
        //System.out.println("Sectores en Vacios: "+sectores);
        
        for(int i=0;i<cantSectores;i++){
            sector = (JSONObject) sectores.get(i);
            espacios = (JSONArray) sector.get("espacios");
            if (espacios.get(0).getClass().isInstance(variable))cantVacios++;
        }
        //System.out.println("Cantidad vacios: "+cantVacios);
        return cantVacios;
    }

    public static MyFile updateSectores(MyFile file, int total, Boolean agregar){
        JSONArray sectores = (JSONArray) discoJson.get("Sectores");
        JSONObject sector;
        JSONArray espacios;
        Integer variable=0;
        if (agregar){//Si hay que agregarle espacios nuevos
            for(int i=0;i<cantSectores;i++){
                sector = (JSONObject) sectores.get(i);
                espacios = (JSONArray) sector.get("espacios");
                
                if (espacios.get(0).getClass().isInstance(variable)) file.sectors.add(i);
                if (file.sectors.size()==total) break;
            }
        }else{//Si hay que eliminar espacios.
            while (file.sectors.size()!=total){
                //lo elimina de la lista y lo vacía del disco.
                vaciarSector(file.sectors.remove(file.sectors.size()-1));
            }
            escribirDisco(FILENAME);
        }
        return file;
    }

    public static void modificarContenido(MyFile file, String contenido){
        //System.out.println("-----------------------------------------------");
        int sectContenido = contenido.length()/cantEspacios;
        if (contenido.length()%cantEspacios!=0) sectContenido++;
        
        //System.out.println("sectContenido: "+sectContenido);
        //System.out.println("Tamaño: "+file.sectors.size());
        //Si no cabe el contenido, no lo agrega.
        if ((file.sectors.size()+sectoresVacios())<sectContenido){
            //System.out.println("Primero");
            return;
        }else if (file.sectors.size()<sectContenido){
            file = updateSectores(file, sectContenido, true);
            //System.out.println("Segundo");
        }else{
            file = updateSectores(file, sectContenido, false);
            //System.out.println("Tercero");
        }
        
        file.setText(contenido);
        file.setModificationDate(new Date());
        file.setSize(contenido.length());
        
        ////System.out.println("Tamaño: "+file.sectors.size());
        ////System.out.println("Sectores File: "+file.sectors.toString());
        
        for(int i=0;i<file.sectors.size();i++){
            if ((i*cantEspacios+cantEspacios)>contenido.length()){
                modificarSector(file.sectors.get(i),contenido.substring(i*cantEspacios, contenido.length()));
            }else{
                modificarSector(file.sectors.get(i),contenido.substring(i*cantEspacios, i*cantEspacios+cantEspacios));
            }
        }
        escribirDisco(FILENAME);
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
        //writeFromJson();
        inicializarDisco(3, 7);
        //vaciarSector(2);
        //modificarSector(1,"Jacob");
        MyFile archivo = new MyFile("Ejemplo", "C:/");

        //archivo.sectors.add(1);
        //modificarSector(1, "00");
        
        //System.out.println("Archivo Antes: "+archivo);
        
        modificarContenido(archivo, "EJEMPLO DE UN");
        
        //System.out.println("Archivo Después: "+archivo);       
        
        modificarContenido(archivo, "");
        
        //System.out.println("Archivo Después: "+archivo);
        
        //System.out.println("DiscoJson: "+discoJson);
    }

}