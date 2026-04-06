package app;

import editor.TextEng;

public class Main {
    public static void main(String[] args){

        TextEng editor = new TextEng();

        editor.write("Hello World");
        System.out.println(editor.getText());
    }
}