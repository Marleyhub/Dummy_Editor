package editor;

public class Document {
    /*
     the real Document is the object implemented by this class,
     that receives the alterations made by the TextEng class
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
    public Document copy(){
        return new Document(this.getText());
    }
}