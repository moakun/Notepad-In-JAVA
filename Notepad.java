import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;
import java.awt.event.*;

public class Notepad implements ActionListener {
    JFrame wind;
    JTextArea textA;
    boolean wordWrapOn = true;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu file, edit, view, help;
    JMenuItem newI, openI,saveI, saveAsI, printI, exit;
    Function_File fil = new Function_File(this);
    Function_View function_view = new Function_View(this);
    Function_Edit function_edit = new Function_Edit(this);
    Function_Help function_help = new Function_Help(this);
    JMenuItem iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenuItem color1, color2, color3, color4, color5, color6, BColor1, BColor2, BColor3, BColor4, BColor5, BColor6;
    JMenu menuFont, menuFontSize , menuColor, menuBColor;
    JMenuItem iUndo, iRedo, iCut, iCopy, iPaste, iDelete, iSelectAll;
    JMenuItem vHelp,about;
    JMenu zoom;
    JMenuItem zoomIn, zoomOut;
    JCheckBoxMenuItem iWrap;
    UndoManager undoManager= new UndoManager();


    public static void main(String[] args){
        new Notepad();
    }
    public Notepad(){
        createWind();
        createTextA();
        createMenuBar();
        createFileM();
        createViewMenu();
        createEditMenu();
        createHelpMenu();
        function_view.selectedFont = "Arial";
        function_view.createFont(16);
        function_view.wordWrap();
        wind.setVisible(true);
        ImageIcon icon = new ImageIcon("C:\\Users\\Moatassim\\Downloads\\473800-512.png");
        wind.setIconImage(icon.getImage());
    }

    public void createWind(){
        wind = new JFrame("Notepad");
        wind.setSize(700, 740);
        wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextA(){
        textA = new JTextArea();
        textA.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));
        scrollPane = new JScrollPane(textA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.addMouseWheelListener(evt -> {
            if (evt.isControlDown()) {
                textA.setFont(new java.awt.Font(textA.getFont().getFontName(), textA.getFont().getStyle(),
                        evt.getUnitsToScroll() > 0 ? textA.getFont().getSize() - 2
                                : textA.getFont().getSize() + 2));
            }
        });
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        wind.add(scrollPane);
        wind.setVisible(true);
    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        wind.setJMenuBar(menuBar);
        
        file = new JMenu("File");
        menuBar.add(file);

        edit = new JMenu("Edit");
        menuBar.add(edit);

        view = new JMenu("View");
        menuBar.add(view);

        help = new JMenu("Help");
        menuBar.add(help);
    }
    public void createFileM(){
        newI = new JMenuItem("New");
        newI.addActionListener(this);
        newI.setActionCommand("New");
        file.add(newI);
        newI.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\134224-16.png"));
        KeyStroke keyStrokeToNew = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        newI.setAccelerator(keyStrokeToNew);

        openI = new JMenuItem("Open");
        openI.addActionListener(this);
        openI.setActionCommand("Open");
        file.add(openI);
        openI.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\352375-16.png"));
        KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        openI.setAccelerator(keyStrokeToOpen);

        saveI = new JMenuItem("Save");
        saveI.addActionListener(this);
        saveI.setActionCommand("Save");
        file.add(saveI);
        saveI.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\1608823-16.png"));
        KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        saveI.setAccelerator(keyStrokeToSave);

        saveAsI = new JMenuItem("Save As");
        saveAsI.addActionListener(this);
        saveAsI.setActionCommand("Save As");
        file.add(saveAsI);
        saveAsI.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\1608823-16.png"));
        KeyStroke keyStrokeToSaveAs = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        saveAsI.setAccelerator(keyStrokeToSaveAs);


        printI = new JMenuItem("Print");
        printI.addActionListener(this);
        printI.setActionCommand("Print");
        file.add(printI);
        printI.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\172530-16.png"));
        KeyStroke keyStrokeToPrint = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
        printI.setAccelerator(keyStrokeToPrint);

        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setActionCommand("Exit");
        file.add(exit);
        exit.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\3005766-16.png"));
    }

    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        edit.add(iUndo);
        iUndo.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\2931166-16.png"));
        KeyStroke keyStrokeToUndo = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
        iUndo.setAccelerator(keyStrokeToUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        edit.add(iRedo);
        iRedo.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\2931165-16.png"));
        KeyStroke keyStrokeToRedo = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
        iRedo.setAccelerator(keyStrokeToRedo);

        iCut = new JMenuItem(new DefaultEditorKit.CutAction());
        iCut.addActionListener(this);
        iCut.setText("Cut");
        iCut.setActionCommand("Cut");
        edit.add(iCut);
        iCut.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\352286-16.png"));
        KeyStroke keyStrokeToCut = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
        iCut.setAccelerator(keyStrokeToCut);

        iCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
        iCopy.addActionListener(this);
        iCopy.setText("Copy");
        iCopy.setActionCommand("Copy");
        edit.add(iCopy);
        iCopy.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\2849804-16.png"));
        KeyStroke keyStrokeToCopy = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
        iCopy.setAccelerator(keyStrokeToCopy);

        iPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
        iPaste.addActionListener(this);
        iPaste.setActionCommand("Paste");
        iPaste.setText("Paste");
        edit.add(iPaste);
        iPaste.setVisible(true);
        iPaste.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\326599-16.png"));
        KeyStroke keyStrokeToPaste = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK);
        iPaste.setAccelerator(keyStrokeToPaste);

        iDelete = new JMenuItem("Delete");
        iDelete.addActionListener(this);
        iDelete.setActionCommand("Delete");
        edit.add(iDelete);
        iDelete.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\3669361-16.png"));
        KeyStroke keyStrokeToDelete = KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
        iDelete.setAccelerator(keyStrokeToDelete);

        iSelectAll = new JMenuItem("Select All");
        iSelectAll.addActionListener(this);
        iSelectAll.setActionCommand("Select All");
        edit.add(iSelectAll);
        iSelectAll.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\5760429-16.png"));
        KeyStroke keyStrokeToSelectAll = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
        iSelectAll.setAccelerator(keyStrokeToSelectAll);
    }

    public void createHelpMenu(){
        vHelp = new JMenuItem("Help");
        vHelp.addActionListener(this);
        vHelp.setActionCommand("Help");
        help.add(vHelp);
        vHelp.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\3669173-16.png"));

        about = new JMenuItem("About Notepad");
        about.addActionListener(this);
        about.setActionCommand("About Notepad");
        help.add(about);
        about.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\2931180-16.png"));
    }

    public void createViewMenu(){
        iWrap = new JCheckBoxMenuItem("Word Wrap : OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        view.add(iWrap);

        zoom = new JMenu("Zoom");
        zoom.addActionListener(this);
        zoom.setActionCommand("Zoom");
        zoom.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\326690-16.png"));
        view.add(zoom);

        zoomIn = new JMenuItem("Zoom In");
        zoomIn.addActionListener(this);
        zoomIn.setActionCommand("Zoom In");
        zoomIn.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\3643761-16.png"));
        zoom.add(zoomIn);
        KeyStroke keyStrokeToZoomIn = KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK);
        zoomIn.setAccelerator(keyStrokeToZoomIn);
        
        zoomOut = new JMenuItem("Zoom Out");
        zoomOut.addActionListener(this);
        zoomOut.setActionCommand("Zoom Out");
        zoomOut.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\3643760-16.png"));
        zoom.add(zoomOut);
        KeyStroke keyStrokeToZoomOut = KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK);
        zoomOut.setAccelerator(keyStrokeToZoomOut);

        menuFont = new JMenu("Font");
        view.add(menuFont);
        menuFont.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\1608890-16.png"));

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        view.add(menuFontSize);
        menuFontSize.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\451442-16.png"));

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);

        menuColor = new JMenu("Color");
        menuColor.addActionListener(this);
        menuColor.setActionCommand("Color");
        view.add(menuColor);
        menuColor.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\6140920-16.png"));

        color1 = new JMenuItem("Gray");
        color1.addActionListener(this);
        color1.setActionCommand("Gray");
        menuColor.add(color1);

        color2 = new JMenuItem("Black");
        color2.addActionListener(this);
        color2.setActionCommand("Black");
        menuColor.add(color2);

        color3 = new JMenuItem("Blue");
        color3.addActionListener(this);
        color3.setActionCommand("Blue");
        menuColor.add(color3);

        color4 = new JMenuItem("Red");
        color4.addActionListener(this);
        color4.setActionCommand("Red");
        menuColor.add(color4);

        color5 = new JMenuItem("Green");
        color5.addActionListener(this);
        color5.setActionCommand("Green");
        menuColor.add(color5);

        color6 = new JMenuItem("White");
        color6.addActionListener(this);
        color6.setActionCommand("White");
        menuColor.add(color6);

        menuBColor = new JMenu("Background Col.");
        menuBColor.addActionListener(this);
        menuBColor.setActionCommand("Background Col.");
        view.add(menuBColor);
        menuBColor.setIcon(new ImageIcon("C:\\Users\\Moatassim\\Downloads\\4243299-16.png"));

        BColor1 = new JMenuItem("gray");
        BColor1.addActionListener(this);
        BColor1.setActionCommand("gray");
        menuBColor.add(BColor1);

        BColor2 = new JMenuItem("black");
        BColor2.addActionListener(this);
        BColor2.setActionCommand("black");
        menuBColor.add(BColor2);

        BColor3 = new JMenuItem("blue");
        BColor3.addActionListener(this);
        BColor3.setActionCommand("blue");
        menuBColor.add(BColor3);

        BColor4 = new JMenuItem("red");
        BColor4.addActionListener(this);
        BColor4.setActionCommand("red");
        menuBColor.add(BColor4);

        BColor5 = new JMenuItem("green");
        BColor5.addActionListener(this);
        BColor5.setActionCommand("green");
        menuBColor.add(BColor5);

        BColor6 = new JMenuItem("white");
        BColor6.addActionListener(this);
        BColor6.setActionCommand("white");
        menuBColor.add(BColor6);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New" -> fil.newFile();
            case "Open" -> fil.open();
            case "Save" -> fil.save();
            case "Save As" -> fil.saveAs();
            case "Exit" -> fil.exit();
            case "Word Wrap" -> function_view.wordWrap();
            case "Arial" -> function_view.setFont("Arial");
            case "Comic Sans MS" -> function_view.setFont("Comic Sans MS");
            case "Times New Roman" -> function_view.setFont("Times New Roman");
            case "size8" -> function_view.createFont(8);
            case "size12" -> function_view.createFont(12);
            case "size16" -> function_view.createFont(16);
            case "size20" -> function_view.createFont(20);
            case "size24" -> function_view.createFont(24);
            case "size28" -> function_view.createFont(28);
            case "Gray" -> function_view.changeColor("Gray");
            case "Black" -> function_view.changeColor("Black");
            case "Blue" -> function_view.changeColor("Blue");
            case "Red" -> function_view.changeColor("Red");
            case "Green" -> function_view.changeColor("Green");
            case "White" -> function_view.changeColor("White");
            case "gray" -> function_view.changeBColor("Gray");
            case "black" -> function_view.changeBColor("Black");
            case "blue" -> function_view.changeBColor("Blue");
            case "red" -> function_view.changeBColor("Red");
            case "green" -> function_view.changeBColor("Green");
            case "white" -> function_view.changeBColor("White");
            case  "Undo" -> function_edit.undo();
            case "Redo" -> function_edit.redo();
            case "About Notepad" -> function_help.createAbout();
            case "Help" -> function_help.createHelp();
            case "Delete" -> function_edit.delete();
            case "Select All" -> function_edit.selectAll();
            case "Print" -> fil.print();
            case "Zoom In" -> function_view.zoomIn();
            case "Zoom Out" -> function_view.zoomOut();
        }
    }
}
