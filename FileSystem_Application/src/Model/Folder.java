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
    protected String name; // Folder identifier
    protected boolean root; // Folder root 
    protected Folder father; // Folder father 
    protected String path; // folder direccion 
    protected ArrayList<Folder> folders; // Folders in this folder
    protected ArrayList<MyFile> files;  // Files in this folder
    
    public Folder(String name, boolean root, Folder father, String path, ArrayList<Folder> folders, ArrayList<MyFile> files){
        this.name = name;
        this.root = root;
        this.father = father;
        this.path = path;
        this.folders = folders;
        this.files = files;
    }

    public Folder(String name, boolean root, Folder father, String path) {
        this.name = name;
        this.root = root;
        this.father = father;
        this.path = path;
        this.folders = new ArrayList<Folder>();
        this.files = new ArrayList<MyFile>();
    }

    public Folder(String name, boolean root, String path) {
        this.name = name;
        this.root = root;
        this.path = path;
        this.father = null;
        this.folders = new ArrayList<Folder>();
        this.files = new ArrayList<MyFile>();
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
    
    public void addFolders(Folder folders){
        this.folders.add(folders);
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
    
    @Override
    public String toString(){
        return "Folder {" + "name:" + name + ", root:" + root +", father:" +father.getName() + 
                ", Path:"+ path +", Folders:" +folders+ ", Files:" + files;
    }
}
