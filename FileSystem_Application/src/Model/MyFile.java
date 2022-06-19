/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;




/**
 *
 * @author Yosua Blanco Diaz
 */
public class MyFile {
    protected String name; // file identifier 
    protected String path; // file direcrion
    public ArrayList<Integer> sectors; // sectors in memory
    protected String text; // file contenst 
    protected String creationDate; // creation date 
    protected String modificationDate; // last modification
    protected int size; //Size of the file

    
    public MyFile(String name, String path){
        this.name = name;
        this.path = path;
        this.sectors = new ArrayList<Integer>();
        this.text = "";
    }
        
    public MyFile(String name, String path, ArrayList<Integer> sectors, String text){
        this.name = name;
        this.path = path;
        this.sectors = sectors;
        this.text = text;
    }

    public MyFile(String name, String path, ArrayList<Integer> sectors, String text, int size) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();
        this.name = name;
        this.path = path;
        this.sectors = sectors;
        this.text = text;
        this.creationDate = formatter.format(date);
        this.modificationDate = formatter.format(date);
        this.size = size;
    }

    public MyFile(String ejemplo, String c, ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<Integer> getSectors() {
        return sectors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSectors(ArrayList<Integer> sectors) {
        this.sectors = sectors;
    }
    
    public void addSectors(Integer sector) {
        this.sectors.add(sector);
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    
    @Override
    public String toString() {
        return "MyFile{" + "name=" + name + ", path=" + path + ", sectors=" + sectors + ", text=" + text + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate + ", size=" + size + '}';
    }
}
