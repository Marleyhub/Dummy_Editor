package editor;

import java.util.ArrayDeque;
import java.util.Deque;

public class TextEng {
    /*
    Text Engine:
    Responsable for handling user actions into the Document object
    (write, delete, get), and memento implementation (undo, redo)
    */

    private Document document;

    private Deque<Memento> undoStack = new ArrayDeque<>(); // stores what have been writen
    private Deque<Memento> redoStack = new ArrayDeque<>(); // stores what what have been deleted

    // Constructors
    public TextEng(){
        this.document = new Document();
    }

    // Methods
    public void write(String text){
        save();
        document.append(text);
        redoStack.clear();
    }
    public void delete(int start, int end) {
        save();
        document.delete(start, end);
        redoStack.clear();
    }
    public void undo(){
        if (!undoStack.isEmpty()){
            redoStack.push(saveToMemento());
            Memento prev = undoStack.pop();
            restoreFromMemento(prev);
        }
    }
    public void redo(){
        if(!redoStack.isEmpty()){

        }
    }
    public String getText(){
        return document.getText();
    }
    protected Document getDocument(){
        return this.document;
    }
    protected void setDocument(Document d){
        this.document = d;
    }
}