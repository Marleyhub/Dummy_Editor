package editor;

public class Document {
    /*
     Real Document, the object of implemented by this class,
     receives the alterations made by the TextEng class
    */

    private StringBuilder content;

    // Constructors
    public Document() {this.content = new StringBuilder();
    }
    public Document(String text){
        this.content = new StringBuilder(text);
    }

    // Methods
    public void append(String text){
        content.append(text);
    }
    public void delete(int start, int end) {
        content.delete(start, end);
    }
    public String getText() {
        return content.toString();
    }
}