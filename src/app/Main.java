package app;

import editor.TextEng;

public class Main {
    public static void main(String[] args) {

        TextEng editor = new TextEng();
        History history = new History(editor);

        // Writing something
        history.push(editor.save());
        editor.write("Vc conhece esse padrão ");
        System.out.println(editor.getText());

        // Concatenating
        history.push(editor.save());
        editor.write("Vc conhece esse padrão?");
        System.out.println(editor.getText());

        // Undo
        history.undo();
        history.undo();
        editor.write("Vocẽ conhece este padrão de projeto GoF chamado memento?");
        System.out.println(editor.getText());
    };
}