package editor;

public class TextEng {

    private Document document;

    public TextEng(){
        this.document = new Document();
    }

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