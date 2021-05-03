public class Function_Edit{
    Notepad note;
    public Function_Edit(Notepad note){
        this.note = note;
    }

    public void undo(){
        note.undoManager.undo();
    }

    public void redo(){
        note.undoManager.redo();
    }

    public void delete(){
        note.textA.setText(note.textA.getText().replace(note.textA.getSelectedText(),""));
    }

    public void selectAll(){
        note.textA.requestFocusInWindow();
        note.textA.selectAll();
    }
}
