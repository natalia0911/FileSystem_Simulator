/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Folder;
import Model.MyFile;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Natalia Vargas
 */
public class TreeController {
    
    private ArrayList<Folder> folders;
    private Folder root;

    public TreeController(Folder root) {
        this.root = root;
        this.folders = new ArrayList(); 
    }

    
    public ArrayList<Folder> getFolders() {
        return folders;
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }

    public Folder getRoot() {
        return root;
    }

    public void setRoot(Folder root) {
        this.root = root;
    }
    
    public String createRute(String parentRoot, String name){
        String[] parts = parentRoot.split("]");
        String rute = parts[0]; // 123
        return rute + ", "+ name + "]";
    }

    public boolean hasExtension(String pathFile){
        String[] parts = pathFile.split(",");
        String filename = parts[parts.length-1];
        String[] extension =  filename.split("\\.");

        if (extension.length>1){
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        return false;
    }
    
    public boolean namehasExtension(String name){;
        String[] extension =  name.split("\\.");
        return (extension.length>1);
    }
       
    public MyFile searchFile(String path){
        for(int i=0;i<folders.size();i++){
            ArrayList<MyFile> files = folders.get(i).getFiles();
            for (int j=0; j<files.size(); j++){
                if (files.get(j).getPath().equals(path)){
                    return files.get(j);
                }
            }
        }
        System.out.println("File doesn't exist");
        return null; 
    }
    
    
    public Folder searchFolder(String path){
        for(int i=0;i<folders.size();i++){
            if (folders.get(i).getPath().equals(path)){
                return folders.get(i);
            }
        }
        System.out.println("Folder doesn't exist");
        return null; 
    }

    
    public ArrayList<MyFile> getFiles(String name){
        String[] parts = name.split("\\.");
        ArrayList<MyFile> getfiles = new ArrayList();
        
        if (parts.length>1){
            if (parts[0].equals("*")){
                Pattern pat = Pattern.compile(parts[1]); //Busca solo por extension
                for(int i=0;i<folders.size();i++){
                    ArrayList<MyFile> files = folders.get(i).getFiles();
                    for (int j=0; j<files.size(); j++){
                        Matcher mat = pat.matcher(files.get(j).getExt());   
                        if (mat.matches()) {
                            getfiles.add(files.get(j));
                        }
                    }
                }
            }
            else {
                Pattern pat = Pattern.compile(name);
                for(int i=0;i<folders.size();i++){
                    ArrayList<MyFile> files = folders.get(i).getFiles();
                    for (int j=0; j<files.size(); j++){
                        Matcher mat = pat.matcher(files.get(j).getName());   
                        if (mat.matches()) {
                            getfiles.add(files.get(j));
                        }  
                    }
                }
            }
        }
        else{
            Pattern pat = Pattern.compile(name);
             for(int i=0;i<folders.size();i++){
                ArrayList<MyFile> files = folders.get(i).getFiles();
                for (int j=0; j<files.size(); j++){
                    Matcher mat = pat.matcher(files.get(j).getNameWhioutExt());   
                    if (mat.matches()) {
                         getfiles.add(files.get(j));
                    } 
                }
            }
        }
        
        return getfiles;
         
    }
    
    
    @Override
    public String toString() {
        return "TreeController{" + "folders=" + folders + ", root=" + root + '}';
    }
    

}

