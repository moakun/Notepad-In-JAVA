import javax.swing.*;

public class Function_Help {
    Notepad note;
    public Function_Help(Notepad note){
        this.note = note;
    }

    public void createAbout(){
        JOptionPane.showMessageDialog(null, "Notepad \nVersion 1.0 \nJDK 15",
                "About Notepad...", JOptionPane.INFORMATION_MESSAGE);
    }

    public void createHelp(){
        note.textA.setText("If you feel like you need help with anything related to the 'Notebook'," +
                " you may go to the following website \n" +
                "www.Microsoft.com ");

    }
}
