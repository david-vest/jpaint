package controller.command;

import java.util.Stack;
import controller.interfaces.Undoable;

public class CommandHistory {
  private static final Stack<Undoable> undoStack = new Stack<>();
  private static final Stack<Undoable> redoStack = new Stack<>();

  public static void add(Undoable cmd) {
    undoStack.push(cmd);
    redoStack.clear();
  }

  public static void undo() {
    boolean result = !undoStack.empty();
    if (result) {
      Undoable c = undoStack.pop();
      redoStack.push(c);
      c.undo();
    }
  }

  public static void redo() {
    boolean result = !redoStack.empty();
    if (result) {
      Undoable c = redoStack.pop();
      undoStack.push(c);
      c.redo();
    }
  }
}

