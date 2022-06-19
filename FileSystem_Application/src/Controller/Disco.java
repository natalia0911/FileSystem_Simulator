package Controller;

import Model.Folder;
import Model.MyFile;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileWriter; 
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
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
        
        for(int i=0;i<cantSectores;i++){
            sector = (JSONObject) sectores.get(i);
            espacios = (JSONArray) sector.get("espacios");
            if (espacios.get(0).getClass().isInstance(variable))cantVacios++;
        }
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

    public static Boolean modificarContenido(MyFile file, String contenido){
        int sectContenido = contenido.length()/cantEspacios;
        if (contenido.length()%cantEspacios!=0) sectContenido++;
        
        //Si no cabe el contenido, no lo agrega.
        if ((file.sectors.size()+sectoresVacios())<sectContenido){
            return false;
        }else if (file.sectors.size()<sectContenido){
            file = updateSectores(file, sectContenido, true);
        }else{
            file = updateSectores(file, sectContenido, false);
        }
        
        file.setText(contenido);
        file.setModificationDate(new Date());
        file.setSize(contenido.length());
                      
        for(int i=0;i<file.sectors.size();i++){
            if ((i*cantEspacios+cantEspacios)>contenido.length()){
                modificarSector(file.sectors.get(i),contenido.substring(i*cantEspacios, contenido.length()));
            }else{
                modificarSector(file.sectors.get(i),contenido.substring(i*cantEspacios, i*cantEspacios+cantEspacios));
            }
        }
        escribirDisco(FILENAME);
        return true;
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
    
    public static int cantidadSectoresFolder(Folder folder){
        int total=0;
        
        for (MyFile file : folder.getFiles()){
            total+=file.sectors.size();
        }
        for (Folder subFolder : folder.getFolders()){
            total+=cantidadSectoresFolder(subFolder);
        }
        return total;
    }
    
    
    public static Boolean clonarContenidoFolder(Folder folder){
        
        for (MyFile file : folder.getFiles()){
            file.setSectors(new ArrayList<>());
            modificarContenido(file,file.getText());
        }
        for (Folder subFolder : folder.getFolders()){
            clonarContenidoFolder(subFolder);
        }
        
        return true;
        
    }
    
    public static Boolean clonarContenido(Object obj){
        
        if (obj.getClass()==MyFile.class){
            MyFile nuevo = (MyFile)obj;
            nuevo.setSectors(new ArrayList<>());
            //Se manda como un nuevo archivo, y dentro de esa función se encarga de agregarlo o no.
            return modificarContenido(nuevo,nuevo.getText());
            
        }else if (obj.getClass()==Folder.class){
            //Si la cantidad total de sectores dentro de los directorios es mayor al disponible no hace el copy.
            if(cantidadSectoresFolder((Folder)obj)>sectoresVacios()) return false;
            clonarContenidoFolder((Folder)obj);
        }else{
            //No es un archivo ni una carpeta.
            return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) throws Exception {
        //writeFromJson();
        /*
        inicializarDisco(3, 7);
                
        modificarContenido(archivo, "EJEMPLO DE UN");        
        modificarContenido(archivo, "");
        //*/
    }

}