/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.MyFile;
import java.util.ArrayList;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class Folder {
    private String name; // Folder identifier
    private boolean root; // Folder root 
    private Folder father; // Folder father 
    private String path; // folder direccion 
    private ArrayList<Folder> folders; // Folders in this folder
    private ArrayList<MyFile> files;  // Files in this folder
    
    public Folder(String name, boolean root, Folder father, String path) {
        this.name = name;
        this.root = root;
        this.father = father;
        this.path = path;
        this.folders = new ArrayList();
        this.files = new ArrayList();
    }

    public Folder(String name, boolean root, String path) {
        this.name = name;
        this.root = root;
        this.path = path;
        this.father = null;
        this.folders = new ArrayList();
        this.files = new ArrayList();
    }
    
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public boolean getRoot(){
        return root;
    }
    
    public void setRoot(boolean root){
        this.root = root;
    }
    
    public Folder getFather(){
        return father;
    }
    
    public void setFather(Folder father){
        this.father = father;
    }
    
    public String getPath(){
        return path;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public ArrayList<Folder> getFolders(){
        return folders;
    }
    
    public void setFolders(ArrayList<Folder> folders){
        this.folders = folders;
    }
    
    public void addFolders(Folder folder){
        this.folders.add(folder);
    }
    
    public ArrayList<MyFile> getFiles(){
        return files;
    }
    
    public void setFiles(ArrayList<MyFile>  files){
        this.files = files;
    }
    
    public void addFiles(MyFile  files){
        this.files.add(files);
    }
    
    public void removeFile(MyFile  file){
        this.files.remove(file);
    }

}
