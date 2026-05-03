package app;

import editor.TextEng;

public class Main {
    public static void main(String[] args){

        TextEng editor = new TextEng();
        History history = new History(editor);

        // Writing something
        history.push(editor.save());
        editor.write("Esse memento is");

        // Undo
        history.undo();

        // Writing something
        history.push(editor.save());
        editor.write("Esse memento é mais profissional");

        // Undo
        history.undo();

        // Redo
        history.redo();
}