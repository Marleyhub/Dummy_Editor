package editor;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {
    private final Deque<Memento> undoStack = new ArrayDeque<>();
    private final Deque<Memento> redoStack = new ArrayDeque<>();
    private final TextEng engine;

    public History(TextEng engine) {
        this.engine = engine;
    }

    public void push(Memento m) {
        undoStack.push(m);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            // Save current state to redo, then restore old state
            redoStack.push(engine.save());
            engine.restore(undoStack.pop());
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(engine.save());
            engine.restore(redoStack.pop());
        }
    }
}