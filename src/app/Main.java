package app;

import editor.TextEng;

public class Main {
    public static void main(String[] args){

        TextEng editor = new TextEng();

        editor.write("Hello ");
        editor.write("World");
        System.out.println(editor.getText()); // Hello World

        editor.undo();
        System.out.println(editor.getText()); // Hello

        editor.undo();
        System.out.println(editor.getText()); // ""

        editor.redo();
        System.out.println(editor.getText()); // Hello

        editor.redo();
        System.out.println(editor.getText()); // Hello World
    }
}