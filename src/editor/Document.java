package editor;

public class Document {

    private StringBuilder content;

    public Document() {
        this.content = new StringBuilder();
    }

    public Document(String text){
        this.content = new StringBuilder(text);
    }

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