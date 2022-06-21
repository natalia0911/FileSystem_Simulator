/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import Controller.Disco;
import Controller.TreeController;
import Model.Folder;
import Model.MyFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;


/**
 *
 * @author Natalia 
 */
public class FileSystem_Window extends javax.swing.JFrame {

    /**
     * Creates new form FileSystem_Window
     */
    private DefaultListModel<String> listModel;
    private DefaultTreeModel model;
    private DefaultMutableTreeNode selectedNode;
    private Disco discController;
    private TreeController treeController;
    //Auxliars nodes for copy a node inside to other node
    private DefaultMutableTreeNode originNode=null;
    private DefaultMutableTreeNode original=null;
    private DefaultMutableTreeNode destinationNode=null;
    private String destinationPath;
    
    public FileSystem_Window() {
        initComponents();
        model = (DefaultTreeModel) jTree.getModel();
        listModel =  new DefaultListModel();
        //////////////////////////////////////////////////////////////
        /*
        Folder root = new Folder("root",true,"[Root]");
        treeController = new TreeController(root);
        treeController.addFolder(root);
        */
       
        //////////////////////////////////////////////////////////////
        /*
        Folder myfolder = new Folder("Folder name", true, "Root");
        Folder myfolder2 = new Folder("Folder2 name", true, "Root");
        Folder myfolder3 = new Folder("Folder3 name", true, "Root");

        
        ArrayList<Integer> array = new  ArrayList<Integer>(); 
        MyFile file1 = new MyFile("File1.txt", "Root/Folder name", array,  "HASDFASDsdfasfdas12341234", 12);
        MyFile file2 = new MyFile("File2.txt", "Root/Folder name", array,  "saveevqfqasdfasdd", 12);
        MyFile file3 = new MyFile("File3.txt", "Root/Folder name", array,  "asdffsdfsdtrhhtht", 12);
        MyFile file4 = new MyFile("File4.txt", "Root/Folder name", array,  "asdasdsdffsdfdssdffds", 12);
        
        myfolder.addFiles(file1);
        myfolder.addFiles(file2);
        myfolder.addFiles(file3);
        myfolder.addFiles(file4);
        
        myfolder2.addFiles(file1);
        myfolder2.addFiles(file2);
        myfolder2.addFiles(file3);
        myfolder2.addFiles(file4);
        
        myfolder3.addFiles(file1);
        myfolder3.addFiles(file2);
        myfolder3.addFiles(file3);
        myfolder3.addFiles(file4);
                
        treeController.setRoot(myfolder);
        treeController.addFolder(myfolder2);
        treeController.addFolder(myfolder3);
        */
        
        pruebas();
        
    }
    
    public void pruebas(){
        
        Folder root = new Folder("root",true,"[Root]");
        treeController = new TreeController(root);
        treeController.addFolder(root);
        MyFile file = new MyFile("rootFile.txt", "[Root, rootFile.txt]", "");
        root.addFiles(file);
        
        Folder F1 = new Folder("F1",false,"[Root, F1]");
        treeController.addFolder(F1);
        root.addFolders(F1);
        Folder F11 = new Folder("F11",false,"[Root, F1, F11]");
        treeController.addFolder(F11);
        Folder F12 = new Folder("F12",false,"[Root, F1, F12]");
        treeController.addFolder(F12);
        F1.addFolders(F11);
        F1.addFolders(F12);
        MyFile file1 = new MyFile("File1.txt", "[Root, F1, File1.txt]", "");
        MyFile file2 = new MyFile("File2.txt", "[Root, F1, F12, File2.txt]", "");
        MyFile fileXX = new MyFile("FileXX.txt", "[Root, F1, F11, FileXX.txt]", "");
        F1.addFiles(file1);
        F12.addFiles(file2);
        F11.addFiles(fileXX);
        
        Folder F2 = new Folder("F2",false,"[Root, F2]");
        treeController.addFolder(F2);
        root.addFolders(F2);
        Folder F21 = new Folder("F21",false,"[Root, F2, F21]");
        treeController.addFolder(F21);
        Folder F22 = new Folder("F22",false,"[Root, F2, F22]");
        treeController.addFolder(F22);
        F2.addFolders(F21);
        F2.addFolders(F22);
        MyFile file3 = new MyFile("File3.txt", "[Root, F2, F22, File3.txt]", "");
        MyFile file4 = new MyFile("File4.txt", "[Root, F2, File4.txt]", "");
        F2.addFiles(file4);
        F22.addFiles(file3);
        
        //System.out.println(treeController.searchFolder(F22.getPath())); 
        //System.out.println(treeController.searchFile(fileXX.getPath()));  
        
        //treeController.getFiles("File1.txt");
        System.out.println("FOLDER PADRE F12 -->" +F12.getPath());
        System.out.println("FILE HIJO -->"+ file2.getPath());
        treeController.deleteFile(file2.getPath());
        //treeController.deleteFolder(F12.getPath());
        //treeController.getFolders().get(0).getFiles().get(0).getFather();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnumberOfSectors = new javax.swing.JTextField();
        txtSectorSize = new javax.swing.JTextField();
        btnDisk = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnCreateFile = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextContents = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lblFileName = new javax.swing.JLabel();
        txtFileName = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaContent = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lblCurrentDir = new javax.swing.JLabel();
        txtCurrentDir = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        txtFolderName = new javax.swing.JTextField();
        btnAddFolder = new javax.swing.JButton();
        lblAdd = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblCurrentDir2 = new javax.swing.JLabel();
        txtCurrentDir2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        btnSaveChanges = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCreation = new javax.swing.JLabel();
        lblModification = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        lblContents = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListRutes = new javax.swing.JList<>();
        btnFind = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPathCopy = new javax.swing.JTextField();
        jTextFieldDestinationPath = new javax.swing.JTextField();
        jButtonCopy = new javax.swing.JButton();
        jButtonCopyGetDestination = new javax.swing.JButton();
        jButtonCopyGetOrigin1 = new javax.swing.JButton();
        jTextFieldDestinationPathOut = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButtonCopyV_PC = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldPathFileOut = new javax.swing.JTextField();
        jButtonCopyPC_V = new javax.swing.JButton();
        btnMove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Root");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        jLabel1.setText("Number of sector");

        jLabel2.setText("Sector's size");

        btnDisk.setText("Prepare disk");
        btnDisk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDisk)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnumberOfSectors)
                            .addComponent(txtSectorSize, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnumberOfSectors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSectorSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btnDisk)
                .addContainerGap(377, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CREATE", jPanel3);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCreateFile.setText("Create File");
        btnCreateFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFileActionPerformed(evt);
            }
        });

        jTextContents.setColumns(20);
        jTextContents.setRows(5);
        jScrollPane3.setViewportView(jTextContents);

        jLabel5.setText("Contents:");

        lblFileName.setText("File name:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(lblFileName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateFile)
                    .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFileName))
                .addGap(51, 51, 51)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(btnCreateFile)
                .addGap(18, 18, 18))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("File content"));

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jScrollPane5.setViewportView(jTextAreaContent);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("FILE", jPanel2);

        lblCurrentDir.setText("Current directory");

        txtCurrentDir.setEnabled(false);
        txtCurrentDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrentDirActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAddFolder.setText("Add folder");
        btnAddFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFolderActionPerformed(evt);
            }
        });

        lblAdd.setText("Folder's name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCurrentDir)
                    .addComponent(lblAdd))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFolderName, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddFolder))
                    .addComponent(txtCurrentDir, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentDir)
                    .addComponent(txtCurrentDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFolderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddFolder)
                    .addComponent(lblAdd))
                .addGap(29, 29, 29)
                .addComponent(btnDelete)
                .addContainerGap(439, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MKDIR", jPanel1);

        lblCurrentDir2.setText("Current file: ");

        txtCurrentDir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrentDir2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Text:");

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane2.setViewportView(jTextArea);

        btnSaveChanges.setText("Save changes");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(lblCurrentDir2))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveChanges)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addComponent(txtCurrentDir2)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentDir2)
                    .addComponent(txtCurrentDir2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnSaveChanges)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MODFILE", jPanel4);

        jLabel7.setText("Name:");

        jLabel9.setText("Modification date:");

        jLabel10.setText("Creation date:");

        jLabel11.setText("Size:");

        jLabel12.setText("Contents:");

        jButton1.setText("Consult");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel12)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(72, 72, 72)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblCreation)
                    .addComponent(lblModification)
                    .addComponent(lblSize)
                    .addComponent(lblContents))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblName))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblCreation))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblModification))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblSize))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblContents))
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PROPERTIES", jPanel5);

        jLabel13.setText("Find:");

        jScrollPane4.setViewportView(jListRutes);

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/lupa.png"))); // NOI18N
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel13)
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(txtFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnFind)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("FIND", jPanel6);

        jLabel3.setText("Path to Copy:");

        jLabel14.setText("Destination Path");

        jTextFieldPathCopy.setEditable(false);
        jTextFieldPathCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPathCopyActionPerformed(evt);
            }
        });

        jTextFieldDestinationPath.setEditable(false);
        jTextFieldDestinationPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDestinationPathActionPerformed(evt);
            }
        });

        jButtonCopy.setText("Copy");
        jButtonCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopyActionPerformed(evt);
            }
        });

        jButtonCopyGetDestination.setText("GetNode");
        jButtonCopyGetDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopyGetDestinationActionPerformed(evt);
            }
        });

        jButtonCopyGetOrigin1.setText("GetNode");
        jButtonCopyGetOrigin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopyGetOrigin1ActionPerformed(evt);
            }
        });

        jTextFieldDestinationPathOut.setEditable(false);
        jTextFieldDestinationPathOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDestinationPathOutActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Copy Virtual to Virtual and Move");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Copy Virtual to PC");

        jLabel17.setText("Destination Path of PC");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Copy PC to Virtual");

        jButtonCopyV_PC.setText("Copy");
        jButtonCopyV_PC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopyV_PCActionPerformed(evt);
            }
        });

        jLabel19.setText("Path File from PC ");

        jTextFieldPathFileOut.setEditable(false);
        jTextFieldPathFileOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPathFileOutActionPerformed(evt);
            }
        });

        jButtonCopyPC_V.setText("Copy");
        jButtonCopyPC_V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopyPC_VActionPerformed(evt);
            }
        });

        btnMove.setText("Move");
        btnMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(211, 211, 211))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel16))
                            .addGap(60, 60, 60))
                        .addComponent(jLabel19)
                        .addComponent(jLabel17)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextFieldPathFileOut, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                .addComponent(jButtonCopyPC_V))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextFieldDestinationPathOut)
                                .addGap(114, 114, 114)
                                .addComponent(jButtonCopyV_PC))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jButtonCopy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMove))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPathCopy, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDestinationPath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCopyGetDestination)
                            .addComponent(jButtonCopyGetOrigin1))))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPathCopy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCopyGetOrigin1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDestinationPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCopyGetDestination))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCopy)
                    .addComponent(btnMove))
                .addGap(56, 56, 56)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDestinationPathOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCopyV_PC))
                .addGap(42, 42, 42)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPathFileOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCopyPC_V))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("COPY", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jTabbedPane1))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();

        if (selectedNode!=null){
            txtCurrentDir.setText(jTree.getSelectionPath().toString());
            txtCurrentDir2.setText(jTree.getSelectionPath().toString());
            
            MyFile file =  treeController.searchFile(jTree.getSelectionPath().toString());
            if (file!= null){
                jTextAreaContent.setText(file.getText());
                jTextArea.setText(file.getText());
            }
        }
        
    }//GEN-LAST:event_jTreeValueChanged

    private void btnMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveActionPerformed

        DefaultMutableTreeNode aux = null;

        if (destinationNode!=null && originNode!=null && destinationNode.getAllowsChildren()){
            DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();

            System.out.println("Origen: "+originNode.toString());
            System.out.println("Destino: "+destinationNode.toString());

            for (int i=0;i<jTree.getModel().getChildCount(destinationNode);i++){
                aux = (DefaultMutableTreeNode) jTree.getModel().getChild(destinationNode, i);

                if (aux.toString().equals(originNode.toString())){
                    int resp = JOptionPane.showConfirmDialog(null, "Do you want overwrite the file/dir?", "YES_NO_OPTION",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    switch (resp) {
                        case 0://yes
                        destinationNode.remove(i); break;
                        case 1:
                        originNode=null; destinationNode=null; return;
                    }
                }
            }
            model.insertNodeInto(originNode, destinationNode, destinationNode.getChildCount());
            model.removeNodeFromParent(original);
            model.reload();
            //CAMBIAR RUTAS

        }
        //make these auxiliars nodes to null.
        originNode=null;
        destinationNode=null;
    }//GEN-LAST:event_btnMoveActionPerformed

    private void jButtonCopyPC_VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopyPC_VActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCopyPC_VActionPerformed

    private void jTextFieldPathFileOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPathFileOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPathFileOutActionPerformed

    private void jButtonCopyV_PCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopyV_PCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCopyV_PCActionPerformed

    private void jTextFieldDestinationPathOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDestinationPathOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDestinationPathOutActionPerformed

    private void jButtonCopyGetOrigin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopyGetOrigin1ActionPerformed

        if (selectedNode!=null && selectedNode!=jTree.getModel().getRoot()){
            originNode = (DefaultMutableTreeNode) selectedNode.clone();
            original = selectedNode;

            DefaultMutableTreeNode aux;

            for (int i=0;i<jTree.getModel().getChildCount(selectedNode);i++){
                aux= (DefaultMutableTreeNode) jTree.getModel().getChild(selectedNode, i);
                originNode.insert(copyNode(aux),originNode.getChildCount());
            }
            jTextFieldPathCopy.setText(jTree.getSelectionPath().toString());

        }else{
            destinationNode=null;
        }
    }//GEN-LAST:event_jButtonCopyGetOrigin1ActionPerformed

    private void jButtonCopyGetDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopyGetDestinationActionPerformed

        if (selectedNode!=null && selectedNode!=jTree.getModel().getRoot()){
            destinationNode = selectedNode;
            destinationPath = jTree.getSelectionPath().toString();
            System.out.println(destinationPath);
            jTextFieldDestinationPath.setText(jTree.getSelectionPath().toString());

        }else{
            destinationNode=null;
        }
    }//GEN-LAST:event_jButtonCopyGetDestinationActionPerformed

    private void jButtonCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopyActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode aux = null;

        if (destinationNode!=null && originNode!=null && destinationNode.getAllowsChildren()){
            DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();

            System.out.println("Origen: "+originNode.toString());
            System.out.println("Destino: "+destinationNode.toString());

            for (int i=0;i<jTree.getModel().getChildCount(destinationNode);i++){
                aux = (DefaultMutableTreeNode) jTree.getModel().getChild(destinationNode, i);

                if (aux.toString().equals(originNode.toString())){
                    int resp = JOptionPane.showConfirmDialog(null, "Do you want overwrite the file/dir?", "YES_NO_OPTION",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    switch (resp) {
                        case 0://yes
                        destinationNode.remove(i); break;
                        case 1:
                        originNode=null; destinationNode=null; return;
                    }
                }
            }
            model.insertNodeInto(originNode, destinationNode, destinationNode.getChildCount());
        }
        //make these auxiliars nodes to null.
        originNode=null;
        destinationNode=null;

    }//GEN-LAST:event_jButtonCopyActionPerformed

    private void jTextFieldDestinationPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDestinationPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDestinationPathActionPerformed

    private void jTextFieldPathCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPathCopyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPathCopyActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        listModel.clear();
        String find = txtFind.getText();
        ArrayList<MyFile> getfiles = treeController.getFiles(find);
        jListRutes.setModel(listModel);
        for (MyFile f:getfiles){
            listModel.addElement(f.getPath());
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        //System.out.println( jTree.getSelectionPath().toString());
        MyFile selectedFile = treeController.searchFile(jTree.getSelectionPath().toString());
        lblName.setText(selectedFile.getName());
        lblCreation.setText(selectedFile.getCreationDate());
        lblModification.setText(selectedFile.getModificationDate());
        lblSize.setText(Integer.toString(selectedFile.getSize()));
        lblContents.setText(selectedFile.getText());

    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * Edita el contenido de un archivo
     * @param evt 
     */
    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        //Se toma la direccion del FILE
        String currentPath = txtCurrentDir2.getText();

        if (treeController.hasExtension(currentPath) && selectedNode!= null){
            int resp = JOptionPane.showConfirmDialog(null, "Do you want save changes?",
                "YES_NO_OPTION", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

            switch (resp) {
                case 0://yes
                //Se recupera el FILE que quiero modificar
                MyFile file =  treeController.searchFile(currentPath);
                System.out.println(file.getText());  //VER CONTENIDO ANTES
                //Se toma el texto modificado
                String newText = jTextArea.getText();
                //Se actualiza el FILE con la nueva informacion
                file.setText(newText);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                file.setModificationDate(formatter.format(date));
                JOptionPane.showMessageDialog(null, "The file was Successfully modified!");
                jTextArea.setText(file.getText());
                break;
                case 1:
                JOptionPane.showMessageDialog(null, "The file was not modified!");
                break;

            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You must select a file");
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private void txtCurrentDir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrentDir2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrentDir2ActionPerformed

    private void btnAddFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFolderActionPerformed
        if (selectedNode!= null){
            String filename = txtFolderName.getText();
            System.out.println(treeController.namehasExtension(filename));
            if (!filename.equals("")){

                //Se toma la direccion actual
                String currentPath = jTree.getSelectionPath().toString();
                //Se recupera el folder de dicha ruta
                Folder folder =  treeController.searchFolder(currentPath);
                //Se crea la ruta para el file a insertar
                String rute = treeController.createRute(currentPath, filename);
                //Creo el nuevo folder con la ruta padre
                Folder newFolder = new Folder(filename, false, rute);

                //Agrego el folder al treecontroller
                treeController.addFolder(newFolder);
                //Agrego el folder a la ruta padre
                folder.addFolders(newFolder);//Prueba
                //Crea el nodo en el Jtree
                createNode(filename);
                //Prueba de busqueda de un folder
                //System.out.println(treeController.searchFolder(newFolder.getPath()).getPath());
            }
            else{
                JOptionPane.showMessageDialog(null, "You must provide a name");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You must select a father folder");
        }

    }//GEN-LAST:event_btnAddFolderActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deteleNode();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtCurrentDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrentDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrentDirActionPerformed

    private void btnCreateFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFileActionPerformed

        if (selectedNode!= null && (treeController.namehasExtension(selectedNode.toString())==false)){
            String filename = txtFileName.getText();
            if ((!filename.equals("")) && (treeController.namehasExtension(filename))){
                //Se toma la direccion actual
                String currentPath = jTree.getSelectionPath().toString();
                //Se recupera el folder de dicha ruta
                Folder folder =  treeController.searchFolder(currentPath);
                //Se crea la ruta para el file a insertar
                String rute = treeController.createRute(currentPath, filename);
                //Tomar el contenido
                String txt = jTextContents.getText();
                //Creo qie nuevo file con el nombre dado y la ruta
                MyFile newFile = new MyFile(filename, rute,txt);
                //Se lo agrego al nodo padre
                folder.addFiles(newFile);
                //Crea el nodo en el Jtree
                createNode(filename);
                JOptionPane.showMessageDialog(null, "The file was Successfully created!");

                //ESCRIBIR EN DISCO AQUI

            }
            else{
                JOptionPane.showMessageDialog(null, "You must provide a valid name");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You must select a father folder");
        }

    }//GEN-LAST:event_btnCreateFileActionPerformed

    private void btnDiskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiskActionPerformed
        String sectors =txtnumberOfSectors.getText();
        String sector_size = txtSectorSize.getText();
        Disco.inicializarDisco(Integer.parseInt(sectors),Integer.parseInt(sector_size));
        //Disco.createTxtFile();
        //Disco.writeFromJson();
    }//GEN-LAST:event_btnDiskActionPerformed

    
    private DefaultMutableTreeNode copyNode(DefaultMutableTreeNode node){
        DefaultMutableTreeNode aux = null;
        DefaultMutableTreeNode child = null;
        
        if(node.isLeaf()){
            aux=(DefaultMutableTreeNode) node.clone();
        }else{
            aux = (DefaultMutableTreeNode) node.clone();
            for (int i=0;i<jTree.getModel().getChildCount(node);i++){
                //get the each child from the node that we will copy.
                child = (DefaultMutableTreeNode) jTree.getModel().getChild(node, i);
                //make a copy of that child                
                child = copyNode(child);              
                aux.add(child);
            }
        }
        
        return aux;
        
    }
    
    
    private boolean isPossibleCreate(String filename){
       
        int cont = selectedNode.getChildCount();
        DefaultMutableTreeNode child = new DefaultMutableTreeNode();
        for (int i=0; i<cont; i++){
            child = (DefaultMutableTreeNode) selectedNode.getChildAt(i);
            if (child.toString().equals(filename)){
                int resp = JOptionPane.showConfirmDialog(null, "Do you want overwrite "+filename+"?",
                "YES_NO_OPTION", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
                switch (resp) {
                case 0: //Yes
                    //Aqui eliminar el archivo o dir 
                    return true; //Hay otro y se se quiere sobrescribir 
                case 1: //No
                    return false; //Hay otro y no se quiere sobrescribir 
                } 
            }
        }
        return true; //No hay otro y se puede agregar 
    }
    
    private DefaultMutableTreeNode createNode(String filename){
        
        DefaultMutableTreeNode newFile = null;
        if (isPossibleCreate(filename)){
            newFile = new DefaultMutableTreeNode(filename);
            if (selectedNode!=null){
                //System.out.println(selectedNode);
                DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
                model.insertNodeInto(newFile, selectedNode, selectedNode.getChildCount());
            }
        }
        return newFile;
    }
    private void deteleNode(){
        
        if (selectedNode!=null && selectedNode!=jTree.getModel().getRoot()){
            DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
            model.removeNodeFromParent(selectedNode);
            model.reload();
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileSystem_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileSystem_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileSystem_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileSystem_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileSystem_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFolder;
    private javax.swing.JButton btnCreateFile;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisk;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnMove;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCopy;
    private javax.swing.JButton jButtonCopyGetDestination;
    private javax.swing.JButton jButtonCopyGetOrigin1;
    private javax.swing.JButton jButtonCopyPC_V;
    private javax.swing.JButton jButtonCopyV_PC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListRutes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextArea jTextAreaContent;
    private javax.swing.JTextArea jTextContents;
    private javax.swing.JTextField jTextFieldDestinationPath;
    private javax.swing.JTextField jTextFieldDestinationPathOut;
    private javax.swing.JTextField jTextFieldPathCopy;
    private javax.swing.JTextField jTextFieldPathFileOut;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblContents;
    private javax.swing.JLabel lblCreation;
    private javax.swing.JLabel lblCurrentDir;
    private javax.swing.JLabel lblCurrentDir2;
    private javax.swing.JLabel lblFileName;
    private javax.swing.JLabel lblModification;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSize;
    private javax.swing.JTextField txtCurrentDir;
    private javax.swing.JTextField txtCurrentDir2;
    private javax.swing.JTextField txtFileName;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFolderName;
    private javax.swing.JTextField txtSectorSize;
    private javax.swing.JTextField txtnumberOfSectors;
    // End of variables declaration//GEN-END:variables
}
