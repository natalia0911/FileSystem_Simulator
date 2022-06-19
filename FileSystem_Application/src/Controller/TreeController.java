/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Folder;
import java.util.ArrayList;

/**
 *
 * @author Natalia Vargas
 */
public class TreeController {
    
    private ArrayList<Folder> folders;
    private Folder root;

    public TreeController() {
        this.folders = new ArrayList();
    }
    
    public TreeController(Folder root) {
        this.root = root;
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
    
    

}

