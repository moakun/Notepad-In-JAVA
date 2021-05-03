import java.awt.*;
import java.awt.print.PrinterException;
import java.io.*;

public class Function_File {
    Notepad note;
    String fileName;
    String fileAddress;

    public Function_File(Notepad note){
       this.note = note;
    }

    public void newFile(){
        note.textA.setText("");
        note.wind.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void open(){
        FileDialog fileDialog = new FileDialog(note.wind, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if (fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            note.wind.setTitle(fileName);
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress + fileName));
            note.textA.setText("");
            String line;
            while((line = bufferedReader.readLine())!= null){
                note.textA.append(line + "\n");
            }
            bufferedReader.close();
        }catch(Exception e){
            System.out.println("FILE_NOT_OPENED");
        }
    }

    public void save(){
    if (fileName==null){
        saveAs();
    }else{
        try{
            FileWriter fileWriter = new FileWriter(fileAddress + fileName);
            fileWriter.write(note.textA.getText());
            note.wind.setTitle(fileName);
            fileWriter.close();
        }catch(Exception e){
            System.out.println("ERROR_404_NOT_FOUND");
        }
    }
    }
    public void saveAs(){
        FileDialog fileDialog = new FileDialog(note.wind, "Save", FileDialog.SAVE);
        fileDialog.setVisible(true);
        if (fileDialog.getFile()!= null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            note.wind.setTitle(fileName);
        }
        try{
            FileWriter fileWriter = new FileWriter(fileAddress + fileName);
            fileWriter.write(note.textA.getText());
            fileWriter.close();
        }catch(Exception e){
            System.out.println("ERROR_404_NOT_FOUND");
        }
    }

    public void exit(){
        System.exit(0);
    }

    public void print(){
        try {
            boolean complete = note.textA.print();
            if (complete) {
                System.out.println("Success");

            } else {
                System.out.println("Canceled");

            }
        } catch (PrinterException pe) {
            System.out.println("Failed");

        }
    }

}
