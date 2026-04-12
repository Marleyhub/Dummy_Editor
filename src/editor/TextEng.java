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
    private Deque<Memento> redoStack = new ArrayDeque<>(); // stores what have been deleted

    // Constructors
    public TextEng(){
        this.document = new Document();
    }

    // Public Methods
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
            undoStack.push(saveToMemento());
            Memento prev = redoStack.pop();
            restoreFromMemento(prev);
        }
    }
    public String getText(){
        return document.getText();
    }

    // Protected Methods
    protected Document getDocument(){
        return this.document;
    }
    protected void setDocument(Document d){
        this.document = d;
    }

    // Private Methods
    private void save(){
        undoStack.push(savetoMemento());
    }
    private Memento saveToMemento(){
        return new Memento(documento.copy());
    }
    private void restoreFromMemento(Memento m){
        this.document = m.document;
    }

    // Private Memento
    private static class Memento {
        private final Document document;
        private Memento(Document document){
            this.document = document;
        }
    }
}