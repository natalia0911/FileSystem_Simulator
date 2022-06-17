/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class MyFile {
    protected String name; // file identifier 
    protected String path; // file direcrion
    public ArrayList<Integer> sectors; // sectors in memory
    protected String text; // file contenst 
    
    
    public MyFile(String name, String path){
        this.name = name;
        this.path = path;
        this.sectors = null;
        this.text = "";
    }
        
    public MyFile(String name, String path, ArrayList<Integer> sectors, String text){
        this.name = name;
        this.path = path;
        this.sectors = sectors;
        this.text = text;
    }

    public MyFile(String ejemplo, String c, ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
    public String toString() {
        return "File{" + "name=" + name + ", path=" + path + ", sectors=" + sectors + ", text=" + text + '}';
    }

   
}
