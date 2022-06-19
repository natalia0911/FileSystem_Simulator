/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.FileSystem_Window;



/**
 *
 * @author Natalia
 */
public class FileSystem_Application {

    /**
     * @param args the command line arguments
     */
    static FileSystem_Window window;
    public static void main(String[] args) {
        // TODO code application logic here
        window = new FileSystem_Window();
        window.setVisible (true);
    }
    
}
