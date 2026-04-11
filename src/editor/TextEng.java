package editor;

public class TextEng {
    // Text Engine:
    // Responsable for wrinting into the Document object

    private Document document;

    // Constructors
    public TextEng(){
        this.document = new Document();
    }

    // Methods
    public void write(String text) {
        document.append(text);
    }
    public String getText() {
        return document.getText();
    }
    protected Document getDocument(){
        return this.document;
    }
    protected void setDocument(Document d){
        this.document = d;
    }
}