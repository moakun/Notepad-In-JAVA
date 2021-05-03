import java.awt.*;

public class Function_View {

    Notepad note;
    Font arial, comicSansMS,timesNewRoman;
    String selectedFont;

    public Function_View(Notepad note){
        this.note = note;
    }

    public void wordWrap(){
        if (!note.wordWrapOn){
            note.wordWrapOn = true;
            note.textA.setLineWrap(true);
            note.textA.setWrapStyleWord(true);
            note.iWrap.setText("Word Wrap : ON");
        }else {
            note.wordWrapOn = false;
            note.textA.setLineWrap(false);
            note.textA.setWrapStyleWord(false);
            note.iWrap.setText("Word Wrap : OFF");
        }
    }

    public void zoomIn(){
        Font font = note.textA.getFont();
        float size = font.getSize() + 3.0f;
        note.textA.setFont( font.deriveFont(size) );
    }

    public void zoomOut(){
        Font font = note.textA.getFont();
        float size = font.getSize() - 3.0f;
        note.textA.setFont( font.deriveFont(size) );
    }

    public void createFont(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic SANS MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }
    public void setFont(String font){
        selectedFont = font;
        switch (selectedFont){
            case "Arial" -> note.textA.setFont(arial);
            case "Comic Sans MS" -> note.textA.setFont(comicSansMS);
            case "Times New Roman" -> note.textA.setFont(timesNewRoman);
        }
    }

    public void changeColor(String color){
        switch (color) {
            case "Gray" -> {
                note.wind.getContentPane().setBackground(Color.gray);
                note.textA.setForeground(Color.gray);
            }
          case "Black" -> {
                note.wind.getContentPane().setBackground(Color.black);
                note.textA.setForeground(Color.black);
          }
          case "Blue" -> {
                note.wind.getContentPane().setBackground(Color.blue);
                note.textA.setForeground(Color.blue);
          }
          case "Red" -> {
                note.wind.getContentPane().setBackground(Color.red);
                note.textA.setForeground(Color.red);
          }
          case "Green" -> {
                note.wind.getContentPane().setBackground(Color.green);
                note.textA.setForeground(Color.green);
          }
          case "White" -> {
                note.wind.getContentPane().setBackground(Color.white);
                note.textA.setForeground(Color.white);
          }
        }
    }

    public void changeBColor(String color){
        switch (color) {
            case "Gray" -> {
                note.wind.getContentPane().setBackground(Color.gray);
                note.textA.setBackground(Color.gray);
            }
            case "Black" -> {
                note.wind.getContentPane().setBackground(Color.black);
                note.textA.setBackground(Color.black);
            }
            case "Blue" -> {
                note.wind.getContentPane().setBackground(Color.blue);
                note.textA.setBackground(Color.blue);
            }
            case "Red" -> {
                note.wind.getContentPane().setBackground(Color.red);
                note.textA.setBackground(Color.red);
            }
            case "Green" -> {
                note.wind.getContentPane().setBackground(Color.green);
                note.textA.setBackground(Color.green);
            }
            case "White" -> {
                note.wind.getContentPane().setBackground(Color.white);
                note.textA.setBackground(Color.white);
            }
        }
    }

}

