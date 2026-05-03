package editor;

import java.util.ArrayDeque;
import java.util.Deque;

public class TextEng {
    /*
    Text Engine:
    Responsable for handling user actions into the Document object
    (write, delete, get), and memento implementation.
    */

    private Document document = new Document();

    // Return the concrete class as a interface
    // Only TextEng can open and see it's state
    public Memento save(){
        return new ConcreteMemento(document.copy()):
    }

    // Even though public only TextEng can access
    public void retore (Memento m){
        if (m instanceof ConcreteMemento){
            this.document = ((ConcreteMemento) m).state;
        }
    }

    // Private nested class
    private static void ConcreteMemento implements Memento{
        private final Document state;
        private ConcreteMemento(Document state){
            this.state = state;
        }
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
}