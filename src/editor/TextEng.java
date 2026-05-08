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
    // Only TextEng can open and see it's concrete state
    public Memento save(){
        return new ConcreteMemento(document.copy());
    }

    // Downcasting: Even though public, only TextEng can access it
    public void restore (Memento m){
        if (m instanceof ConcreteMemento){
            this.document = ((ConcreteMemento) m).state;
        }
    }

    // Private nested class
    private static class ConcreteMemento implements Memento{
        private final Document state;
        private ConcreteMemento(Document state){
            this.state = state;
        }
    }

    // Public whappers for Document Methods
    public void write(String text){
        document.append(text);
    }
    public void delete(int start, int end) {
        document.delete(start, end);
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